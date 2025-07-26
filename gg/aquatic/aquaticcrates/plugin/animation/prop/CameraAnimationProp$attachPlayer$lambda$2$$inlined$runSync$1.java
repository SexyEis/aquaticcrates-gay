package gg.aquatic.aquaticcrates.plugin.animation.prop;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import org.bukkit.GameMode;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 CameraAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/CameraAnimationProp\n*L\n1#1,8:1\n59#2,3:9\n*E\n"})
public final class CameraAnimationProp$attachPlayer$lambda$2$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final CameraAnimationProp this$0;

   public CameraAnimationProp$attachPlayer$lambda$2$$inlined$runSync$1(CameraAnimationProp var1) {
      this.this$0 = var1;
   }

   public final void run() {
      boolean var1 = false;
      this.this$0.getAnimation().getPlayer().setInvisible(true);
      this.this$0.getAnimation().getPlayer().setGameMode(GameMode.SPECTATOR);
   }
}
