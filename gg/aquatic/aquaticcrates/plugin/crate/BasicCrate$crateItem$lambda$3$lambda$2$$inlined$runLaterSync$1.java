package gg.aquatic.aquaticcrates.plugin.crate;

import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.CrateHandler;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.concurrent.CompletableFuture;
import org.bukkit.Location;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runLaterSync$1\n+ 2 BasicCrate.kt\ngg/aquatic/aquaticcrates/plugin/crate/BasicCrate\n*L\n1#1,32:1\n86#2,5:33\n*E\n"})
public final class BasicCrate$crateItem$lambda$3$lambda$2$$inlined$runLaterSync$1 implements Runnable {
   // $FF: synthetic field
   final BasicCrate this$0;
   // $FF: synthetic field
   final Location $location$inlined;

   public BasicCrate$crateItem$lambda$3$lambda$2$$inlined$runLaterSync$1(BasicCrate var1, Location var2) {
      this.this$0 = var1;
      this.$location$inlined = var2;
   }

   public final void run() {
      boolean var1 = false;
      CrateHandler var10000 = CrateHandler.INSTANCE;
      Crate var10001 = (Crate)this.this$0;
      Location var10002 = this.$location$inlined.clone().add(0.5D, 1.0D, 0.5D);
      Intrinsics.checkNotNullExpressionValue(var10002, "add(...)");
      var10000.spawnCrate(var10001, var10002);
      CompletableFuture.runAsync((Runnable)null.INSTANCE);
   }
}
