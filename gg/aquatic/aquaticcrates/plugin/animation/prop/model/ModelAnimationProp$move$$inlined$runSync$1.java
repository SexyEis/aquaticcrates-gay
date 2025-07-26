package gg.aquatic.aquaticcrates.plugin.animation.prop.model;

import com.ticxo.modelengine.api.entity.BaseEntity;
import com.ticxo.modelengine.api.entity.Dummy;
import com.ticxo.modelengine.api.model.ModeledEntity;
import gg.aquatic.waves.interactable.type.MEGInteractable;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import org.bukkit.Location;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 ModelAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/model/ModelAnimationProp\n*L\n1#1,8:1\n76#2,8:9\n*E\n"})
public final class ModelAnimationProp$move$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final ModelAnimationProp this$0;
   // $FF: synthetic field
   final Location $location$inlined;

   public ModelAnimationProp$move$$inlined$runSync$1(ModelAnimationProp var1, Location var2) {
      this.this$0 = var1;
      this.$location$inlined = var2;
   }

   public final void run() {
      BaseEntity var5;
      label22: {
         boolean var1 = false;
         MEGInteractable var10000 = this.this$0.getInteractable();
         if (var10000 != null) {
            ModeledEntity var4 = var10000.getModeledEntity();
            if (var4 != null) {
               var5 = var4.getBase();
               break label22;
            }
         }

         var5 = null;
      }

      BaseEntity var2 = var5;
      Dummy var6 = var2 instanceof Dummy ? (Dummy)var2 : null;
      if ((var2 instanceof Dummy ? (Dummy)var2 : null) != null) {
         Dummy var3 = var6;
         var3.setLocation(this.$location$inlined);
         var3.getBodyRotationController().setYBodyRot(this.$location$inlined.getYaw());
         var3.getBodyRotationController().setXHeadRot(this.$location$inlined.getPitch());
         var3.getBodyRotationController().setYHeadRot(this.$location$inlined.getYaw());
         var3.setYHeadRot(this.$location$inlined.getYaw());
         var3.setYBodyRot(this.$location$inlined.getYaw());
      }

   }
}
