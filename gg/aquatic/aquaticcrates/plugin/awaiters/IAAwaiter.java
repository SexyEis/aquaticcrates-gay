package gg.aquatic.aquaticcrates.plugin.awaiters;

import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent;
import gg.aquatic.waves.api.WavesPlugin;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/awaiters/IAAwaiter;", "Lgg/aquatic/aquaticcrates/plugin/awaiters/AbstractAwaiter;", "<init>", "()V", "future", "Ljava/util/concurrent/CompletableFuture;", "Ljava/lang/Void;", "getFuture", "()Ljava/util/concurrent/CompletableFuture;", "plugin"}
)
@SourceDebugExtension({"SMAP\nIAAwaiter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IAAwaiter.kt\ngg/aquatic/aquaticcrates/plugin/awaiters/IAAwaiter\n+ 2 EventExt.kt\ngg/aquatic/waves/api/event/EventExtKt\n*L\n1#1,16:1\n14#2,19:17\n*S KotlinDebug\n*F\n+ 1 IAAwaiter.kt\ngg/aquatic/aquaticcrates/plugin/awaiters/IAAwaiter\n*L\n11#1:17,19\n*E\n"})
public final class IAAwaiter extends AbstractAwaiter {
   @NotNull
   private final CompletableFuture<Void> future = new CompletableFuture();

   public IAAwaiter() {
      Consumer var3 = IAAwaiter::_init_$lambda$0;
      boolean var1 = false;
      EventPriority var2 = EventPriority.NORMAL;
      boolean var4 = false;
      IAAwaiter$special$$inlined$event$default$1 var5 = new IAAwaiter$special$$inlined$event$default$1();
      Bukkit.getPluginManager().registerEvent(ItemsAdderLoadDataEvent.class, (Listener)var5, var2, (EventExecutor)(new IAAwaiter$special$$inlined$event$default$2(var3)), (Plugin)WavesPlugin.Companion.getINSTANCE(), var1);
      Listener var10000 = (Listener)var5;
   }

   @NotNull
   public CompletableFuture<Void> getFuture() {
      return this.future;
   }

   private static final void _init_$lambda$0(IAAwaiter var0, ItemsAdderLoadDataEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getFuture().complete((Object)null);
      var0.setLoaded(true);
   }
}
