package net.kayzai.astralite.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.kayzai.astralite.init.AstraliteModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AstraliteChestplatePassiveProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double zTest = 0;
		double triesCount = 0;
		double xTest = 0;
		double yTest = 0;
		boolean SafeZone = false;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == AstraliteModItems.ASTRALITE_CHESTPLATE.get()) {
			if ((entity instanceof Player _plrCldRem2 ? _plrCldRem2.getCooldowns().getCooldownPercent(AstraliteModItems.ASTRALITE_CHESTPLATE.get(), 0f) * 100 : 0) < 1) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				} else if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
				SafeZone = false;
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(8);
				triesCount = 0;
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(AstraliteModItems.ASTRALITE_CHESTPLATE.get(), 1200);
				while (SafeZone == false && triesCount < 300) {
					xTest = x + Mth.nextInt(RandomSource.create(), -15, 15);
					yTest = y + Mth.nextInt(RandomSource.create(), -5, 5);
					zTest = z + Mth.nextInt(RandomSource.create(), -150, 15);
					triesCount = triesCount + 1;
					if ((world.getBlockState(BlockPos.containing(xTest, yTest, zTest))).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing(xTest, yTest - 1, zTest)).canOcclude()) {
						SafeZone = true;
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.END_ROD, x, y, z, 5, 3, 3, 3, 1);
						{
							Entity _ent = entity;
							_ent.teleportTo(xTest, yTest, zTest);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(xTest, yTest, zTest, _ent.getYRot(), _ent.getXRot());
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(xTest, yTest, zTest), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("item.totem.use")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(xTest, yTest, zTest, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("item.totem.use")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (true)
							Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(AstraliteModItems.ASTRALITE_CHESTPLATE.get()));
					}
				}
			}
		}
	}
}