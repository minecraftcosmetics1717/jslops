package com.stovetoptoad.jujutsuslop;

import com.stovetoptoad.jujutsuslop.network.ModNetwork;
import com.stovetoptoad.jujutsuslop.network.PacketRctOutputHold;
import com.stovetoptoad.jujutsuslop.network.PacketToggleOpenDomain;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
        modid = "jujutsuslop",
        bus = Bus.FORGE,
        value = {Dist.CLIENT}
)
public class ClientEventHandler {

   private static boolean wasRctOutputDown = false;

   @SubscribeEvent
   public static void onKeyInput(InputEvent.Key event) {
      Minecraft mc = Minecraft.getInstance();

      if (mc.player != null && mc.screen == null) {
         if (KeyBindings.TOGGLE_OPEN_DOMAIN.consumeClick()) {
            if (!mc.player.getPersistentData().getBoolean("open_domain_unlocked")) {
               return;
            }
            ModNetwork.CHANNEL.sendToServer(new PacketToggleOpenDomain());
         }
      }
   }

   @SubscribeEvent
   public static void onClientTick(TickEvent.ClientTickEvent event) {
      if (event.phase != TickEvent.Phase.END) return;

      Minecraft mc = Minecraft.getInstance();
      if (mc.player == null || mc.screen != null) {
         if (wasRctOutputDown) {
            ModNetwork.CHANNEL.sendToServer(new PacketRctOutputHold(false));
            wasRctOutputDown = false;
         }
         return;
      }

      boolean isDown = KeyBindings.RCT_OUTPUT.isDown();
      if (isDown != wasRctOutputDown) {
         ModNetwork.CHANNEL.sendToServer(new PacketRctOutputHold(isDown));
         wasRctOutputDown = isDown;
      }
   }
}