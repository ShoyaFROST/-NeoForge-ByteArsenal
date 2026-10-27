package net.shoya.byte_armories.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class RadioactiveScythe extends SwordItem {

    public RadioactiveScythe(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.level().isClientSide && attacker instanceof Player player) {
            float baseDamage = (float) player.getAttributeValue(Attributes.ATTACK_DAMAGE);
            float sweepDamage = 1.0F + (float) player.getAttributeValue(Attributes.SWEEPING_DAMAGE_RATIO) * baseDamage;
            float yawRad = player.getYRot() * ((float) Math.PI / 180F);

            for (LivingEntity e : player.level().getEntitiesOfClass(
                    LivingEntity.class, target.getBoundingBox().inflate(1.0, 0.25, 1.0))) {
                if (e != player && e != target && !player.isAlliedTo(e) && !(e instanceof ArmorStand stand && stand.isMarker()) && player.distanceToSqr(e) < 9.0) {
                    e.knockback(0.4F, Mth.sin(yawRad), -Mth.cos(yawRad));
                    e.hurt(player.level().damageSources().playerAttack(player), sweepDamage);
                }
            }

            player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.PLAYER_ATTACK_SWEEP, player.getSoundSource(), 1.0F, 1.0F);
            player.sweepAttack(); // sweep particle
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    // Disable vanilla's sweep for this item so normal hits don't sweep twice
    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility ability) {
        if (ability == ItemAbilities.SWORD_SWEEP) return false;
        return super.canPerformAction(stack, ability);
    }
}