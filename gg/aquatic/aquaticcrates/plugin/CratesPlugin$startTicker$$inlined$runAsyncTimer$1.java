package gg.aquatic.aquaticcrates.plugin;

import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.CrateHandler;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runAsyncTimer$1\n+ 2 CratesPlugin.kt\ngg/aquatic/aquaticcrates/plugin/CratesPlugin\n*L\n1#1,26:1\n398#2,6:27\n*E\n"})
public final class CratesPlugin$startTicker$$inlined$runAsyncTimer$1 implements Runnable {
   public final void run() {
      boolean var1 = false;
      Iterator var2 = ((Map)CrateHandler.INSTANCE.getCrates()).entrySet().iterator();

      while(var2.hasNext()) {
         Crate var3 = (Crate)((Entry)var2.next()).getValue();
         if (var3 instanceof OpenableCrate) {
            ((OpenableCrate)var3).getAnimationManager().tick();
         }
      }

   }
}
