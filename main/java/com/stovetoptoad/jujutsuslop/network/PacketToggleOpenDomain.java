package com.stovetoptoad.jujutsuslop.network;

import com.stovetoptoad.jujutsuslop.JslopGamerules;
import com.stovetoptoad.jujutsuslop.OpenDomain;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class PacketToggleOpenDomain {
   public PacketToggleOpenDomain() {
   }

   public PacketToggleOpenDomain(FriendlyByteBuf buf) {
   }

   public void encode(FriendlyByteBuf buf) {
   }

   public void handle(Supplier<NetworkEvent.Context> contextSupplier) {
      NetworkEvent.Context ctx = contextSupplier.get();
      ctx.enqueueWork(() -> {
         ServerPlayer player = ctx.getSender();
         if (player != null) {
            if (JslopGamerules.isEnabled(player, JslopGamerules.OPEN_DOMAIN)) {
               if (!this.hasDomainExpansionEffect(player)) {
                  if (!PacketRequestUnlockOpenDomain.isRestrictedCT(player)) {
                     OpenDomain.toggle(player);
                  }
               }
            }
         }
      });
      ctx.setPacketHandled(true);
   }

   private boolean hasDomainExpansionEffect(ServerPlayer player) {
      return player.getActiveEffects().stream().anyMatch((effect) -> {
         ResourceLocation loc = ForgeRegistries.MOB_EFFECTS.getKey(effect.getEffect());
         return loc != null && loc.toString().equals("jujutsucraft:domain_expansion");
      });
   }
}