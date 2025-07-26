package gg.aquatic.aquaticcrates.plugin.animation.prop.model;

import com.ticxo.modelengine.api.animation.handler.AnimationHandler;
import com.ticxo.modelengine.api.model.ActiveModel;
import gg.aquatic.waves.interactable.type.MEGInteractable;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 ModelAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/model/ModelAnimationProp\n*L\n1#1,8:1\n63#2,2:9\n*E\n"})
public final class ModelAnimationProp$playAnimation$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final ModelAnimationProp this$0;
   // $FF: synthetic field
   final String $animation$inlined;
   // $FF: synthetic field
   final double $fadeIn$inlined;
   // $FF: synthetic field
   final double $fadeOut$inlined;
   // $FF: synthetic field
   final double $speed$inlined;

   public ModelAnimationProp$playAnimation$$inlined$runSync$1(ModelAnimationProp var1, String var2, double var3, double var5, double var7) {
      this.this$0 = var1;
      this.$animation$inlined = var2;
      this.$fadeIn$inlined = var3;
      this.$fadeOut$inlined = var5;
      this.$speed$inlined = var7;
   }

   public final void run() {
      boolean var1 = false;
      MEGInteractable var10000 = this.this$0.getInteractable();
      if (var10000 != null) {
         ActiveModel var2 = var10000.getActiveModel();
         if (var2 != null) {
            AnimationHandler var3 = var2.getAnimationHandler();
            if (var3 != null) {
               var3.playAnimation(this.$animation$inlined, this.$fadeIn$inlined, this.$fadeOut$inlined, this.$speed$inlined, true);
            }
         }
      }

   }
}
