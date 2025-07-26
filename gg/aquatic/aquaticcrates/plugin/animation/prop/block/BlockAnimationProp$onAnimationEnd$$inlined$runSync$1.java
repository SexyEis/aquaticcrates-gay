package gg.aquatic.aquaticcrates.plugin.animation.prop.block;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 BlockAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/block/BlockAnimationProp\n*L\n1#1,8:1\n27#2,2:9\n*E\n"})
public final class BlockAnimationProp$onAnimationEnd$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final BlockAnimationProp this$0;

   public BlockAnimationProp$onAnimationEnd$$inlined$runSync$1(BlockAnimationProp var1) {
      this.this$0 = var1;
   }

   public final void run() {
      boolean var1 = false;
      this.this$0.getPacketBlock().destroy();
   }
}
