package gg.aquatic.aquaticcrates.plugin.animation.open.settings;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import org.bukkit.entity.Player;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 CinematicAnimationSettings.kt\ngg/aquatic/aquaticcrates/plugin/animation/open/settings/CinematicAnimationSettings\n*L\n1#1,8:1\n53#2,2:9\n*E\n"})
public final class CinematicAnimationSettings$create$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final Player $player$inlined;

   public CinematicAnimationSettings$create$$inlined$runSync$1(Player var1) {
      this.$player$inlined = var1;
   }

   public final void run() {
      boolean var1 = false;
      this.$player$inlined.updateInventory();
   }
}
