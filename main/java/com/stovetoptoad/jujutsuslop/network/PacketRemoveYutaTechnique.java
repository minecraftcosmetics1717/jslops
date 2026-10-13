package com.stovetoptoad.jujutsuslop.network;

import com.stovetoptoad.jujutsuslop.JujutsuSlop;
import com.stovetoptoad.jujutsuslop.YutaTechniqueRegistry;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class PacketRemoveYutaTechnique {
   private final int slot;

   public PacketRemoveYutaTechnique(int slot) {
      this.slot = slot;
   }

   public PacketRemoveYutaTechnique(FriendlyByteBuf buf) {
      this.slot = buf.readInt();
   }

   public void encode(FriendlyByteBuf buf) {
      buf.writeInt(this.slot);
   }

   public void handle(Supplier<NetworkEvent.Context> ctxSupplier) {
      NetworkEvent.Context ctx = ctxSupplier.get();
      ctx.enqueueWork(() -> {
         ServerPlayer player = ctx.getSender();
         if (player != null) {
            if (YutaTechniqueRegistry.hasYutaCT(player)) {
               if (this.slot >= 0 && this.slot < YutaTechniqueRegistry.getCount(player)) {
                  YutaTechniqueRegistry.remove(player, this.slot);
                  PacketSyncYutaTechniques.sync(player);
                  JujutsuSlop.LOGGER.debug(
                          "[JSlop] {} removed registered technique at slot {}",
                          player.getScoreboardName(),
                          this.slot
                  );
               }
            }
         }
      });
      ctx.setPacketHandled(true);
   }
}