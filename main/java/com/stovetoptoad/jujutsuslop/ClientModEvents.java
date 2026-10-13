package com.stovetoptoad.jujutsuslop;

import com.stovetoptoad.jujutsuslop.rika.RikaInventoryScreen;
import com.stovetoptoad.jujutsuslop.rika.RikaMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(
        modid = "jujutsuslop",
        bus = Bus.MOD,
        value = {Dist.CLIENT}
)
public class ClientModEvents {

   @SubscribeEvent
   public static void onClientSetup(FMLClientSetupEvent event) {
      event.enqueueWork(() ->
              MenuScreens.register(RikaMenuTypes.RIKA_INVENTORY.get(), RikaInventoryScreen::new)
      );
   }
}