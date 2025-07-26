package gg.aquatic.aquaticcrates.plugin.animation.prop.model;

import gg.aquatic.waves.interactable.type.BMInteractable;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 BMModelAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/model/BMModelAnimationProp\n*L\n1#1,8:1\n66#2,2:9\n*E\n"})
public final class BMModelAnimationProp$onAnimationEnd$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final BMModelAnimationProp this$0;

   public BMModelAnimationProp$onAnimationEnd$$inlined$runSync$1(BMModelAnimationProp var1) {
      this.this$0 = var1;
   }

   public final void run() {
      boolean var1 = false;
      BMInteractable var10000 = this.this$0.getInteractable();
      if (var10000 != null) {
         var10000.destroy();
      }

   }
}
