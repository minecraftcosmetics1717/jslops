package com.stovetoptoad.jujutsuslop.network;

import com.stovetoptoad.jujutsuslop.JslopGamerules;
import com.stovetoptoad.jujutsuslop.RefinementPoints;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class PacketSpendRefinementPoint {

   public PacketSpendRefinementPoint() {
   }

   public PacketSpendRefinementPoint(FriendlyByteBuf buf) {
   }

   public void encode(FriendlyByteBuf buf) {
   }

   public void handle(Supplier<NetworkEvent.Context> contextSupplier) {
      NetworkEvent.Context ctx = contextSupplier.get();
      ctx.enqueueWork(() -> {
         ServerPlayer player = ctx.getSender();
         if (player != null) {
            if (!JslopGamerules.isEnabled(player, JslopGamerules.DOMAIN_REFINEMENT)) {
               player.sendSystemMessage(Component.literal("§cDomain Refinement has been disabled by a server rule"));
            } else {
               RefinementPoints.trySpendPoint(player);
            }
         }
      });
      ctx.setPacketHandled(true);
   }
}