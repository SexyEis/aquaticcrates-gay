package gg.aquatic.aquaticcrates.plugin.animation.open;

import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.Iterator;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runAsync$1\n+ 2 AnimationManagerImpl.kt\ngg/aquatic/aquaticcrates/plugin/animation/open/AnimationManagerImpl\n*L\n1#1,14:1\n93#2,4:15\n*E\n"})
public final class AnimationManagerImpl$forceStopAnimations$$inlined$runAsync$1 implements Runnable {
   // $FF: synthetic field
   final CrateAnimation $animation$inlined;

   public AnimationManagerImpl$forceStopAnimations$$inlined$runAsync$1(CrateAnimation var1) {
      this.$animation$inlined = var1;
   }

   public final void run() {
      boolean var1 = false;
      Iterator var2 = this.$animation$inlined.getProps().values().iterator();

      while(var2.hasNext()) {
         AnimationProp var3 = (AnimationProp)var2.next();
         var3.onAnimationEnd();
      }

   }
}
