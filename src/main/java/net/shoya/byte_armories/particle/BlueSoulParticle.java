package net.shoya.byte_armories.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;

public class BlueSoulParticle extends TextureSheetParticle {

    private final SpriteSet spriteSet;

    protected BlueSoulParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, float sizeMultiplier, SpriteSet spriteSet) {
        super(level, x, y, z, (double)0.0F, (double)0.0F, (double)0.0F);
        this.friction = 0.99F;
        this.gravity = -0.005F;
        this.speedUpWhenYMotionIsBlocked = true;
        this.xd *= (double)0.0F;
        this.yd *= 1.3;
        this.zd *= (double)0.0F;
        this.quadSize *= 0.75F * sizeMultiplier;
        this.lifetime = (int)(8.0F / Mth.randomBetween(this.random, 0.5F, 1.0F) * sizeMultiplier);
        this.lifetime = Math.max(this.lifetime, 1);
        this.setSpriteFromAge(spriteSet);
        this.hasPhysics = true;
        this.spriteSet = spriteSet;
        this.setSpriteFromAge(spriteSet);
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.spriteSet);

        if (this.age > this.lifetime * 0.6F) {
            float progress = (this.age - this.lifetime * 0.6F)
                    / (this.lifetime * 0.4F);

            this.alpha = 1.0F - progress;
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    protected int getLightColor(float partialTick) {
        return 0xF000F0;
    }
    public static class Provider implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType type,
                                       ClientLevel level,
                                       double x, double y, double z,
                                       double xSpeed, double ySpeed, double zSpeed) {

            return new BlueSoulParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, 0.6F, spriteSet
            );
        }
    }
}