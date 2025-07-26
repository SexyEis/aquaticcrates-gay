package gg.aquatic.aquaticcrates.api.animation.crate;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function0;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 CrateAnimation.kt\ngg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation\n*L\n1#1,8:1\n144#2,2:9\n*E\n"})
public final class CrateAnimation$finalizeAnimation$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final Function0 $block$inlined;

   public CrateAnimation$finalizeAnimation$$inlined$runSync$1(Function0 var1) {
      this.$block$inlined = var1;
   }

   public final void run() {
      boolean var1 = false;
      this.$block$inlined.invoke();
   }
}
