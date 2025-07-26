package gg.aquatic.aquaticcrates.plugin.animation.open;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function0;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 CinematicAnimationImpl.kt\ngg/aquatic/aquaticcrates/plugin/animation/open/CinematicAnimationImpl\n*L\n1#1,8:1\n83#2,2:9\n*E\n"})
public final class CinematicAnimationImpl$onFinalize$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final Function0 $runnable$inlined;

   public CinematicAnimationImpl$onFinalize$$inlined$runSync$1(Function0 var1) {
      this.$runnable$inlined = var1;
   }

   public final void run() {
      boolean var1 = false;
      this.$runnable$inlined.invoke();
   }
}
