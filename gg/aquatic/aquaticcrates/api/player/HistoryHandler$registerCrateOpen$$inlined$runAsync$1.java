package gg.aquatic.aquaticcrates.api.player;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runAsync$1\n+ 2 HistoryHandler.kt\ngg/aquatic/aquaticcrates/api/player/HistoryHandler\n*L\n1#1,14:1\n79#2,2:15\n*E\n"})
public final class HistoryHandler$registerCrateOpen$$inlined$runAsync$1 implements Runnable {
   // $FF: synthetic field
   final CrateProfileEntry $crateEntry$inlined;

   public HistoryHandler$registerCrateOpen$$inlined$runAsync$1(CrateProfileEntry var1) {
      this.$crateEntry$inlined = var1;
   }

   public final void run() {
      boolean var1 = false;
      this.$crateEntry$inlined.saveAndPrune();
   }
}
