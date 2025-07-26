package gg.aquatic.aquaticcrates.plugin.animation.open;

import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.Iterator;
import java.util.Set;
import org.bukkit.entity.Player;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runAsync$1\n+ 2 AnimationManagerImpl.kt\ngg/aquatic/aquaticcrates/plugin/animation/open/AnimationManagerImpl\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,14:1\n77#2:15\n78#2:18\n1869#3,2:16\n*S KotlinDebug\n*F\n+ 1 AnimationManagerImpl.kt\ngg/aquatic/aquaticcrates/plugin/animation/open/AnimationManagerImpl\n*L\n77#1:16,2\n*E\n"})
public final class AnimationManagerImpl$skipAnimation$$inlined$runAsync$1 implements Runnable {
   // $FF: synthetic field
   final AnimationManagerImpl this$0;
   // $FF: synthetic field
   final Player $player$inlined;

   public AnimationManagerImpl$skipAnimation$$inlined$runAsync$1(AnimationManagerImpl var1, Player var2) {
      this.this$0 = var1;
      this.$player$inlined = var2;
   }

   public final void run() {
      boolean var1 = false;
      Set var10000 = (Set)this.this$0.getPlayingAnimations().get(this.$player$inlined.getUniqueId());
      if (var10000 != null) {
         Iterable var2 = (Iterable)var10000;
         boolean var3 = false;
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            CrateAnimation var6 = (CrateAnimation)var5;
            boolean var7 = false;
            var6.skip();
         }
      }

   }
}
