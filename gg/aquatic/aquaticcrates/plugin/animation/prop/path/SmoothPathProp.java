package gg.aquatic.aquaticcrates.plugin.animation.prop.path;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.plugin.animation.prop.Moveable;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.collections.MapsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.ranges.RangesKt;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001a\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J&\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0#J\u001e\u0010$\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010&\u001a\u00020'H\u0002J0\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0002J0\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020'2\u0006\u0010&\u001a\u00020'H\u0002J \u00103\u001a\u00020'2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u0010&\u001a\u00020'H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u00067"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/SmoothPathProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathProp;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "points", "Ljava/util/TreeMap;", "", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathPoint;", "<init>", "(Lgg/aquatic/aquaticcrates/api/animation/Animation;Ljava/util/TreeMap;)V", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/Animation;", "getPoints", "()Ljava/util/TreeMap;", "currentPoint", "getCurrentPoint", "()Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathPoint;", "setCurrentPoint", "(Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathPoint;)V", "boundProps", "", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/Moveable;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathBoundProperties;", "getBoundProps", "()Ljava/util/Map;", "tick", "getTick", "()I", "setTick", "(I)V", "", "onAnimationEnd", "generateSmoothPath", "controlPoints", "", "interpolatePoints", "", "t", "", "catmullRomPosition", "Lorg/bukkit/util/Vector;", "p0", "p1", "p2", "p3", "lerpSmooth", "d0", "d1", "d2", "d3", "interpolateAngle", "angle1", "", "angle2", "plugin"}
)
@SourceDebugExtension({"SMAP\nSmoothPathProp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmoothPathProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/path/SmoothPathProp\n+ 2 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,106:1\n12#2,4:107\n*S KotlinDebug\n*F\n+ 1 SmoothPathProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/path/SmoothPathProp\n*L\n20#1:107,4\n*E\n"})
public final class SmoothPathProp extends AnimationProp implements PathProp {
   @NotNull
   private final Animation animation;
   @NotNull
   private final TreeMap<Integer, PathPoint> points;
   @NotNull
   private PathPoint currentPoint;
   @NotNull
   private final Map<Moveable, PathBoundProperties> boundProps;
   private int tick;

   public SmoothPathProp(@NotNull Animation var1, @NotNull TreeMap<Integer, PathPoint> var2) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      Intrinsics.checkNotNullParameter(var2, "points");
      super();
      this.animation = var1;
      this.points = this.generateSmoothPath((Map)var2);
      Object var10001 = var2.firstEntry().getValue();
      Intrinsics.checkNotNullExpressionValue(var10001, "<get-value>(...)");
      this.currentPoint = (PathPoint)var10001;
      this.boundProps = (Map)(new HashMap());
   }

   @NotNull
   public Animation getAnimation() {
      return this.animation;
   }

   @NotNull
   public TreeMap<Integer, PathPoint> getPoints() {
      return this.points;
   }

   @NotNull
   public PathPoint getCurrentPoint() {
      return this.currentPoint;
   }

   public void setCurrentPoint(@NotNull PathPoint var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.currentPoint = var1;
   }

   @NotNull
   public Map<Moveable, PathBoundProperties> getBoundProps() {
      return this.boundProps;
   }

   public final int getTick() {
      return this.tick;
   }

   public final void setTick(int var1) {
      this.tick = var1;
   }

   public void tick() {
      boolean var1 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTaskAsynchronously((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new SmoothPathProp$tick$$inlined$runAsync$1(this)));
   }

   public void onAnimationEnd() {
      this.tick = 0;
   }

   @NotNull
   public final TreeMap<Integer, PathPoint> generateSmoothPath(@NotNull Map<Integer, PathPoint> var1) {
      Intrinsics.checkNotNullParameter(var1, "controlPoints");
      SortedMap var2 = MapsKt.toSortedMap(var1);
      TreeMap var3 = new TreeMap();
      Set var10000 = var2.keySet();
      Intrinsics.checkNotNullExpressionValue(var10000, "<get-keys>(...)");
      List var4 = CollectionsKt.toList((Iterable)var10000);
      Collection var13 = var2.values();
      Intrinsics.checkNotNullExpressionValue(var13, "<get-values>(...)");
      List var5 = CollectionsKt.toList((Iterable)var13);
      if (var4.size() < 2) {
         throw new IllegalArgumentException("At least 2 points are required for interpolation.");
      } else {
         Integer var6 = (Integer)CollectionsKt.last(var4);
         int var7 = 0;
         Intrinsics.checkNotNull(var6);
         int var8 = var6;
         if (var7 <= var8) {
            while(true) {
               double var9 = (double)var7 / (double)var6;
               PathPoint var11 = this.interpolatePoints(var5, var9);
               Integer var12 = var7;
               ((Map)var3).put(var12, var11);
               if (var7 == var8) {
                  break;
               }

               ++var7;
            }
         }

         return var3;
      }
   }

   private final PathPoint interpolatePoints(List<PathPoint> var1, double var2) {
      if (var2 <= 0.0D) {
         return (PathPoint)var1.get(0);
      } else if (var2 >= 1.0D) {
         return (PathPoint)var1.get(1);
      } else {
         int var4 = var1.size();
         int var5 = RangesKt.coerceAtMost((int)(var2 * (double)(var4 - 1)), var4 - 2);
         int var6 = RangesKt.coerceAtLeast(var5 - 1, 0);
         int var7 = RangesKt.coerceAtMost(var5 + 1, var4 - 1);
         int var8 = RangesKt.coerceAtMost(var7 + 1, var4 - 1);
         double var9 = var2 * (double)(var4 - 1) - (double)var5;
         Vector var11 = this.catmullRomPosition(((PathPoint)var1.get(var6)).getVector(), ((PathPoint)var1.get(var5)).getVector(), ((PathPoint)var1.get(var7)).getVector(), ((PathPoint)var1.get(var8)).getVector(), var9);
         float var12 = (float)this.interpolateAngle(((PathPoint)var1.get(var5)).getYaw(), ((PathPoint)var1.get(var7)).getYaw(), var9);
         float var13 = (float)this.interpolateAngle(((PathPoint)var1.get(var5)).getPitch(), ((PathPoint)var1.get(var7)).getPitch(), var9);
         return new PathPoint(var11.getX(), var11.getY(), var11.getZ(), var12, var13);
      }
   }

   private final Vector catmullRomPosition(Vector var1, Vector var2, Vector var3, Vector var4, double var5) {
      return new Vector(this.lerpSmooth(var1.getX(), var2.getX(), var3.getX(), var4.getX(), var5), this.lerpSmooth(var1.getY(), var2.getY(), var3.getY(), var4.getY(), var5), this.lerpSmooth(var1.getZ(), var2.getZ(), var3.getZ(), var4.getZ(), var5));
   }

   private final double lerpSmooth(double var1, double var3, double var5, double var7, double var9) {
      double var11 = var9 * var9;
      double var13 = var11 * var9;
      return 0.5D * ((double)2 * var3 + (-var1 + var5) * var9 + ((double)2 * var1 - (double)5 * var3 + (double)4 * var5 - var7) * var11 + (-var1 + (double)3 * var3 - (double)3 * var5 + var7) * var13);
   }

   private final double interpolateAngle(float var1, float var2, double var3) {
      float var5 = (var2 - var1 + (float)360) % (float)360;
      float var6 = var5 > 180.0F ? var5 - (float)360 : var5;
      return (double)var1 + (double)var6 * var3;
   }
}
