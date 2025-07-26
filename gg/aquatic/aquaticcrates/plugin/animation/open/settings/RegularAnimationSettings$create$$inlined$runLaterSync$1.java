package gg.aquatic.aquaticcrates.plugin.animation.open.settings;

import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import org.bukkit.entity.Player;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runLaterSync$1\n+ 2 RegularAnimationSettings.kt\ngg/aquatic/aquaticcrates/plugin/animation/open/settings/RegularAnimationSettings\n*L\n1#1,32:1\n47#2,6:33\n*E\n"})
public final class RegularAnimationSettings$create$$inlined$runLaterSync$1 implements Runnable {
   // $FF: synthetic field
   final RegularAnimationSettings this$0;
   // $FF: synthetic field
   final SpawnedCrate $spawnedCrate$inlined;
   // $FF: synthetic field
   final Player $player$inlined;

   public RegularAnimationSettings$create$$inlined$runLaterSync$1(RegularAnimationSettings var1, SpawnedCrate var2, Player var3) {
      this.this$0 = var1;
      this.$spawnedCrate$inlined = var2;
      this.$player$inlined = var3;
   }

   public final void run() {
      boolean var1 = false;
      if (!this.this$0.getPersonal()) {
         if (this.$spawnedCrate$inlined != null) {
            this.$spawnedCrate$inlined.forceHide(true);
         }
      } else if (this.$spawnedCrate$inlined != null) {
         this.$spawnedCrate$inlined.forceHide(this.$player$inlined, true);
      }

   }
}
