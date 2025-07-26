package gg.aquatic.aquaticcrates.plugin.animation.prop.model;

import gg.aquatic.waves.interactable.type.BMInteractable;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import org.bukkit.Location;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 BMModelAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/model/BMModelAnimationProp\n*L\n1#1,8:1\n43#2,9:9\n*E\n"})
public final class BMModelAnimationProp$special$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final BMModelAnimationProp this$0;
   // $FF: synthetic field
   final Location $currentLocation$inlined;

   public BMModelAnimationProp$special$$inlined$runSync$1(BMModelAnimationProp var1, Location var2) {
      this.this$0 = var1;
      this.$currentLocation$inlined = var2;
   }

   public final void run() {
      boolean var1 = false;
      BMModelAnimationProp.access$setInteractable$p(this.this$0, new BMInteractable(this.$currentLocation$inlined, this.this$0.getModel(), this.this$0.getAnimation().getAudience(), (Function1)null.INSTANCE));
      if (this.this$0.getModelAnimation() != null) {
         BMModelAnimationProp.playAnimation$default(this.this$0, this.this$0.getModelAnimation(), 0, 0, 0.0F, 14, (Object)null);
      }

   }
}
