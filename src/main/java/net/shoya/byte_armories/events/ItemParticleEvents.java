package net.shoya.byte_armories.events;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.shoya.byte_armories.RhenTutorial;
import net.shoya.byte_armories.items.OreItems;
import net.shoya.byte_armories.particle.ByteParticles;

@EventBusSubscriber(modid = RhenTutorial.MODID)
public class ItemParticleEvents {

    @SubscribeEvent
    public static void onItemTick(EntityTickEvent.Post event) {

        if (!(event.getEntity() instanceof ItemEntity itemEntity))
            return;
        if (!itemEntity.level().isClientSide())
            return;
        if (itemEntity.tickCount % 2 != 0)
            return;

        ItemStack stack = itemEntity.getItem();

        if (stack.is(OreItems.crystal_frost.get())) {

            itemEntity.level().addParticle(
                    ParticleTypes.SNOWFLAKE,
                    itemEntity.getX(), itemEntity.getY() + 0.15, itemEntity.getZ(),
                    0, 0.02, 0
            );
        };
        if (stack.is(OreItems.blue_soul.get())) {

            itemEntity.level().addParticle(
                    ByteParticles.BlueSoulParticle.get(),
                    itemEntity.getX() + (itemEntity.level().random.nextDouble() - 0.2) * 0.2, itemEntity.getY() + 0.3, itemEntity.getZ() + (itemEntity.level().random.nextDouble() - 0.2) * 0.2,
                    0, 0.04, 0
            );
            itemEntity.level().addParticle(
                    ByteParticles.BlueSoulParticle.get(),
                    itemEntity.getX(), itemEntity.getY() + 0.3, itemEntity.getZ(),
                    0, 0, 0
            );

        }
    }
}

