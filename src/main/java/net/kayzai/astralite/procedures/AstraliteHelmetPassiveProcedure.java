package net.kayzai.astralite.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.kayzai.astralite.init.AstraliteModItems;

public class AstraliteHelmetPassiveProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrCldRem0 ? _plrCldRem0.getCooldowns().getCooldownPercent(AstraliteModItems.ASTRALITE_BOOTS.get(), 0f) * 100 : 0) < 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 60, 0, false, false));
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.WITHER);
		}
	}
}