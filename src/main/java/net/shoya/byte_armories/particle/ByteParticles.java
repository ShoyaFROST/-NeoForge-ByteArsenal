package net.shoya.byte_armories.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.shoya.byte_armories.RhenTutorial;

import java.util.function.Supplier;

public class ByteParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, RhenTutorial.MODID);

    public static final Supplier<SimpleParticleType> BlueSoulParticle =
            PARTICLE_TYPES.register("blue_soul_particle", () -> new SimpleParticleType(false));
    public static final Supplier<SimpleParticleType> Glow =
            PARTICLE_TYPES.register("glow", () -> new SimpleParticleType(false));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
