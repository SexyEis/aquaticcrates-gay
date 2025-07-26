package gg.aquatic.aquaticcrates.plugin.preview;

import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.aquaticcrates.plugin.crate.BasicCrate;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 CratePreviewMenu.kt\ngg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenu\n*L\n1#1,8:1\n67#2,3:9\n*E\n"})
public final class CratePreviewMenu$loadButtons$lambda$2$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final CratePreviewMenu this$0;

   public CratePreviewMenu$loadButtons$lambda$2$$inlined$runSync$1(CratePreviewMenu var1) {
      this.this$0 = var1;
   }

   public final void run() {
      BasicCrate var10000;
      Player var10001;
      Location var2;
      label11: {
         boolean var1 = false;
         var10000 = this.this$0.getCrate();
         var10001 = this.this$0.getPlayer();
         SpawnedCrate var10002 = this.this$0.getPlacedCrate();
         if (var10002 != null) {
            var2 = var10002.getLocation();
            if (var2 != null) {
               break label11;
            }
         }

         var2 = this.this$0.getPlayer().getLocation().clone();
         Intrinsics.checkNotNullExpressionValue(var2, "clone(...)");
      }

      var10000.tryOpen(var10001, var2, this.this$0.getPlacedCrate());
      this.this$0.getPlayer().closeInventory();
   }
}
