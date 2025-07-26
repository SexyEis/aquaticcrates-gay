package gg.aquatic.aquaticcrates.plugin.animation.prop.model;

import gg.aquatic.waves.interactable.type.BMInteractable;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import kr.toxicity.model.api.animation.AnimationModifier;
import kr.toxicity.model.api.tracker.DummyTracker;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 BMModelAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/model/BMModelAnimationProp\n*L\n1#1,8:1\n60#2,2:9\n*E\n"})
public final class BMModelAnimationProp$playAnimation$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final BMModelAnimationProp this$0;
   // $FF: synthetic field
   final String $animation$inlined;
   // $FF: synthetic field
   final int $fadeIn$inlined;
   // $FF: synthetic field
   final int $fadeOut$inlined;
   // $FF: synthetic field
   final float $speed$inlined;

   public BMModelAnimationProp$playAnimation$$inlined$runSync$1(BMModelAnimationProp var1, String var2, int var3, int var4, float var5) {
      this.this$0 = var1;
      this.$animation$inlined = var2;
      this.$fadeIn$inlined = var3;
      this.$fadeOut$inlined = var4;
      this.$speed$inlined = var5;
   }

   public final void run() {
      boolean var1 = false;
      BMInteractable var10000 = this.this$0.getInteractable();
      if (var10000 != null) {
         DummyTracker var2 = var10000.getTracker();
         if (var2 != null) {
            var2.animate(this.$animation$inlined, new AnimationModifier(this.$fadeIn$inlined, this.$fadeOut$inlined, this.$speed$inlined));
         }
      }

   }
}
