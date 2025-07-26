package gg.aquatic.aquaticcrates.plugin.log;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 LogMenu.kt\ngg/aquatic/aquaticcrates/plugin/log/LogMenu\n*L\n1#1,8:1\n79#2,2:9\n*E\n"})
public final class LogMenu$loadButtons$lambda$8$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final LogMenu this$0;

   public LogMenu$loadButtons$lambda$8$$inlined$runSync$1(LogMenu var1) {
      this.this$0 = var1;
   }

   public final void run() {
      boolean var1 = false;
      this.this$0.getPlayer().closeInventory();
   }
}
