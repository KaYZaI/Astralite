/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kayzai.astralite.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.kayzai.astralite.client.model.Modelwhite_enderman;
import net.kayzai.astralite.client.model.ModelArmor;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class AstraliteModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelwhite_enderman.LAYER_LOCATION, Modelwhite_enderman::createBodyLayer);
		event.registerLayerDefinition(ModelArmor.LAYER_LOCATION, ModelArmor::createBodyLayer);
	}
}