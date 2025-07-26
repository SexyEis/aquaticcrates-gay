package gg.aquatic.aquaticcrates.plugin.animation.prop.model;

import gg.aquatic.waves.interactable.type.MEGInteractable;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 ModelAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/model/ModelAnimationProp\n*L\n1#1,8:1\n69#2,2:9\n*E\n"})
public final class ModelAnimationProp$onAnimationEnd$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final ModelAnimationProp this$0;

   public ModelAnimationProp$onAnimationEnd$$inlined$runSync$1(ModelAnimationProp var1) {
      this.this$0 = var1;
   }

   public final void run() {
      boolean var1 = false;
      MEGInteractable var10000 = this.this$0.getInteractable();
      if (var10000 != null) {
         var10000.destroy();
      }

   }
}
