package gg.aquatic.aquaticcrates.plugin.awaiters;

import com.ticxo.modelengine.api.events.ModelRegistrationEvent;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.function.Consumer;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
public final class MEGAwaiter$special$$inlined$event$default$2 implements EventExecutor {
   // $FF: synthetic field
   final Consumer $callback;

   public MEGAwaiter$special$$inlined$event$default$2(Consumer var1) {
      this.$callback = var1;
   }

   public final void execute(Listener var1, Event var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "event");
      if (var2 instanceof ModelRegistrationEvent) {
         this.$callback.accept(var2);
      }

   }
}
