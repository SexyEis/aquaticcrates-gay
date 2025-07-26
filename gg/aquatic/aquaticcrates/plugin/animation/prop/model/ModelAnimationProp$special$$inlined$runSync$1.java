package gg.aquatic.aquaticcrates.plugin.animation.prop.model;

import gg.aquatic.waves.interactable.type.MEGInteractable;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 ModelAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/model/ModelAnimationProp\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,8:1\n45#2,6:9\n51#2,4:16\n1#3:15\n*E\n"})
public final class ModelAnimationProp$special$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final ModelAnimationProp this$0;
   // $FF: synthetic field
   final Location $currentLocation$inlined;

   public ModelAnimationProp$special$$inlined$runSync$1(ModelAnimationProp var1, Location var2) {
      this.this$0 = var1;
      this.$currentLocation$inlined = var2;
   }

   public final void run() {
      boolean var1 = false;
      ModelAnimationProp.access$setInteractable$p(this.this$0, new MEGInteractable(this.$currentLocation$inlined, this.this$0.getModel(), this.this$0.getAnimation().getAudience(), (Function1)null.INSTANCE));
      Player var10000 = this.this$0.getSkin();
      if (var10000 != null) {
         Player var2 = var10000;
         boolean var3 = false;
         MEGInteractable var4 = this.this$0.getInteractable();
         Intrinsics.checkNotNull(var4);
         var4.setSkin(var2);
      }

      if (this.this$0.getModelAnimation() != null) {
         ModelAnimationProp.playAnimation$default(this.this$0, this.this$0.getModelAnimation(), 0.0D, 0.0D, 0.0D, 14, (Object)null);
      }

   }
}
