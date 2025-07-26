package gg.aquatic.aquaticcrates.plugin.animation.fail.settings;

import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import org.bukkit.entity.Player;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 FailAnimationSettings.kt\ngg/aquatic/aquaticcrates/plugin/animation/fail/settings/FailAnimationSettings\n*L\n1#1,8:1\n30#2,2:9\n*E\n"})
public final class FailAnimationSettings$create$lambda$2$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final SpawnedCrate $spawnedCrate$inlined;
   // $FF: synthetic field
   final Player $player$inlined;

   public FailAnimationSettings$create$lambda$2$$inlined$runSync$1(SpawnedCrate var1, Player var2) {
      this.$spawnedCrate$inlined = var1;
      this.$player$inlined = var2;
   }

   public final void run() {
      boolean var1 = false;
      this.$spawnedCrate$inlined.forceHide(this.$player$inlined, false);
   }
}
