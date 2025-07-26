package gg.aquatic.aquaticcrates.plugin.reroll.input.interaction;

import gg.aquatic.aquaticcrates.api.reroll.RerollManager;
import gg.aquatic.waves.api.event.packet.PacketInteractEvent;
import gg.aquatic.waves.api.event.packet.PacketInteractEvent.InteractType;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.NoWhenBranchMatchedException;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0015R;\u0010\u0004\u001a,\u0012\u0004\u0012\u00020\u0006\u0012\"\u0012 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/reroll/input/interaction/InteractionInputHandler;", "", "<init>", "()V", "awaiting", "", "Ljava/util/UUID;", "Lgg/aquatic/waves/libs/kotlin/Pair;", "Ljava/util/concurrent/CompletableFuture;", "Lgg/aquatic/aquaticcrates/api/reroll/RerollManager$RerollResult;", "", "Lgg/aquatic/aquaticcrates/plugin/reroll/input/interaction/InteractionRerollInput$InteractionType;", "Lgg/aquatic/aquaticcrates/plugin/reroll/input/interaction/InteractionRerollInput$Action;", "getAwaiting", "()Ljava/util/Map;", "onSneak", "", "event", "Lorg/bukkit/event/player/PlayerToggleSneakEvent;", "onInteract", "", "Lgg/aquatic/waves/api/event/packet/PacketInteractEvent;", "plugin"}
)
public final class InteractionInputHandler {
   @NotNull
   public static final InteractionInputHandler INSTANCE = new InteractionInputHandler();
   @NotNull
   private static final Map<UUID, Pair<CompletableFuture<RerollManager.RerollResult>, Map<InteractionRerollInput.InteractionType, InteractionRerollInput.Action>>> awaiting = (Map)(new LinkedHashMap());

   private InteractionInputHandler() {
   }

   @NotNull
   public final Map<UUID, Pair<CompletableFuture<RerollManager.RerollResult>, Map<InteractionRerollInput.InteractionType, InteractionRerollInput.Action>>> getAwaiting() {
      return awaiting;
   }

   public final boolean onSneak(@NotNull PlayerToggleSneakEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "event");
      Pair var10000 = (Pair)awaiting.get(var1.getPlayer().getUniqueId());
      if (var10000 == null) {
         return false;
      } else {
         Pair var2 = var10000;
         CompletableFuture var3 = (CompletableFuture)var2.component1();
         Map var4 = (Map)var2.component2();
         InteractionRerollInput.Action var6 = (InteractionRerollInput.Action)var4.get(InteractionRerollInput.InteractionType.SNEAK);
         if (var6 == null) {
            return false;
         } else {
            InteractionRerollInput.Action var5 = var6;
            switch(InteractionInputHandler.WhenMappings.$EnumSwitchMapping$0[var5.ordinal()]) {
            case 1:
               var3.complete(new RerollManager.RerollResult(true));
               var10000 = (Pair)awaiting.remove(var1.getPlayer().getUniqueId());
               break;
            case 2:
               var3.complete(new RerollManager.RerollResult(false));
               var10000 = (Pair)awaiting.remove(var1.getPlayer().getUniqueId());
               break;
            default:
               throw new NoWhenBranchMatchedException();
            }

            return true;
         }
      }
   }

   public final void onInteract(@NotNull PacketInteractEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "event");
      Player var2 = var1.getPlayer();
      if (!var1.isSecondary()) {
         Pair var10000 = (Pair)awaiting.get(var2.getUniqueId());
         if (var10000 != null) {
            Pair var3 = var10000;
            CompletableFuture var4 = (CompletableFuture)var3.component1();
            Map var5 = (Map)var3.component2();
            InteractionRerollInput.InteractionType var6 = var1.getInteractType() == InteractType.INTERACT ? InteractionRerollInput.InteractionType.RIGHT_CLICK : InteractionRerollInput.InteractionType.LEFT_CLICK;
            InteractionRerollInput.Action var8 = (InteractionRerollInput.Action)var5.get(var6);
            if (var8 != null) {
               InteractionRerollInput.Action var7 = var8;
               switch(InteractionInputHandler.WhenMappings.$EnumSwitchMapping$0[var7.ordinal()]) {
               case 1:
                  var4.complete(new RerollManager.RerollResult(true));
                  var10000 = (Pair)awaiting.remove(var2.getUniqueId());
                  break;
               case 2:
                  var4.complete(new RerollManager.RerollResult(false));
                  var10000 = (Pair)awaiting.remove(var2.getUniqueId());
                  break;
               default:
                  throw new NoWhenBranchMatchedException();
               }

            }
         }
      }
   }

   // $FF: synthetic class
   @Metadata(
      mv = {2, 1, 0},
      k = 3,
      xi = 48
   )
   public class WhenMappings {
      // $FF: synthetic field
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[InteractionRerollInput.Action.values().length];

         try {
            var0[InteractionRerollInput.Action.REROLL.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[InteractionRerollInput.Action.CLAIM.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
