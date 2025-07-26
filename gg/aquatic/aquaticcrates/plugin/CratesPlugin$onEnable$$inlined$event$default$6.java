package gg.aquatic.aquaticcrates.plugin;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.function.Consumer;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.EventExecutor;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
public final class CratesPlugin$onEnable$$inlined$event$default$6 implements EventExecutor {
   // $FF: synthetic field
   final Consumer $callback;

   public CratesPlugin$onEnable$$inlined$event$default$6(Consumer var1) {
      this.$callback = var1;
   }

   public final void execute(Listener var1, Event var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "event");
      if (var2 instanceof PlayerToggleSneakEvent) {
         this.$callback.accept(var2);
      }

   }
}
