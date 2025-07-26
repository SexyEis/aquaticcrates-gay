package gg.aquatic.aquaticcrates.plugin.animation.prop.path;

import gg.aquatic.aquaticcrates.plugin.animation.prop.Moveable;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.Iterator;
import java.util.Map.Entry;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runAsync$1\n+ 2 SmoothPathProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/path/SmoothPathProp\n*L\n1#1,14:1\n21#2,9:15\n*E\n"})
public final class SmoothPathProp$tick$$inlined$runAsync$1 implements Runnable {
   // $FF: synthetic field
   final SmoothPathProp this$0;

   public SmoothPathProp$tick$$inlined$runAsync$1(SmoothPathProp var1) {
      this.this$0 = var1;
   }

   public final void run() {
      boolean var1 = false;
      PathPoint var10000 = (PathPoint)this.this$0.getPoints().get(this.this$0.getTick());
      if (var10000 != null) {
         PathPoint var2 = var10000;
         this.this$0.setCurrentPoint(var2);
         Iterator var3 = this.this$0.getBoundProps().entrySet().iterator();

         while(var3.hasNext()) {
            Moveable var4 = (Moveable)((Entry)var3.next()).getKey();
            var4.processPath((PathProp)this.this$0, var2);
         }

         int var5 = this.this$0.getTick();
         this.this$0.setTick(var5 + 1);
      }

   }
}
