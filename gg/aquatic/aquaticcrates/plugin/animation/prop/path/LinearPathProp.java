package gg.aquatic.aquaticcrates.plugin.animation.prop.path;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.plugin.animation.prop.Moveable;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0019\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0016\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010!H\u0002J \u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#H\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006'"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/LinearPathProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathProp;", "points", "Ljava/util/TreeMap;", "", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathPoint;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "<init>", "(Ljava/util/TreeMap;Lgg/aquatic/aquaticcrates/api/animation/Animation;)V", "getPoints", "()Ljava/util/TreeMap;", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/Animation;", "value", "currentPoint", "getCurrentPoint", "()Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathPoint;", "boundProps", "", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/Moveable;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathBoundProperties;", "getBoundProps", "()Ljava/util/Map;", "tick", "getTick", "()I", "setTick", "(I)V", "", "onAnimationEnd", "lowerPoint", "Lgg/aquatic/waves/libs/kotlin/Pair;", "interpolate", "", "start", "end", "ratio", "plugin"}
)
public final class LinearPathProp extends AnimationProp implements PathProp {
   @NotNull
   private final TreeMap<Integer, PathPoint> points;
   @NotNull
   private final Animation animation;
   @NotNull
   private PathPoint currentPoint;
   @NotNull
   private final Map<Moveable, PathBoundProperties> boundProps;
   private int tick;

   public LinearPathProp(@NotNull TreeMap<Integer, PathPoint> var1, @NotNull Animation var2) {
      Intrinsics.checkNotNullParameter(var1, "points");
      Intrinsics.checkNotNullParameter(var2, "animation");
      super();
      this.points = var1;
      this.animation = var2;
      this.currentPoint = new PathPoint(0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
      this.boundProps = (Map)(new HashMap());
      this.tick();
   }

   @NotNull
   public TreeMap<Integer, PathPoint> getPoints() {
      return this.points;
   }

   @NotNull
   public Animation getAnimation() {
      return this.animation;
   }

   @NotNull
   public PathPoint getCurrentPoint() {
      return this.currentPoint;
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
      if (this.getPoints().isEmpty()) {
         Iterator var19 = this.getBoundProps().entrySet().iterator();

         while(var19.hasNext()) {
            Moveable var24 = (Moveable)((Entry)var19.next()).getKey();
            var24.processPath((PathProp)this, new PathPoint(0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
         }

      } else {
         PathProp var10001;
         Iterator var20;
         Moveable var25;
         if (this.tick > ((Number)this.getPoints().lastKey()).intValue()) {
            PathPoint var18 = (PathPoint)this.getPoints().lastEntry().getValue();
            var20 = this.getBoundProps().entrySet().iterator();

            while(var20.hasNext()) {
               var25 = (Moveable)((Entry)var20.next()).getKey();
               var10001 = (PathProp)this;
               Intrinsics.checkNotNull(var18);
               var25.processPath(var10001, var18);
            }

         } else {
            Pair var1 = this.lowerPoint();
            if (var1 == null) {
               int var21 = this.tick++;
               var20 = this.getBoundProps().entrySet().iterator();

               while(var20.hasNext()) {
                  var25 = (Moveable)((Entry)var20.next()).getKey();
                  var25.processPath((PathProp)this, new PathPoint(0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
               }

            } else if (Intrinsics.areEqual(var1.getSecond(), this.getPoints().lastEntry().getValue())) {
               var20 = this.getBoundProps().entrySet().iterator();

               while(var20.hasNext()) {
                  var25 = (Moveable)((Entry)var20.next()).getKey();
                  var25.processPath((PathProp)this, (PathPoint)var1.getSecond());
               }

            } else {
               Entry var10000 = this.getPoints().higherEntry(this.tick);
               Intrinsics.checkNotNullExpressionValue(var10000, "higherEntry(...)");
               Entry var3 = var10000;
               Pair var2 = new Pair(var3.getKey(), var3.getValue());
               if (Intrinsics.areEqual(var2.getSecond(), var1.getSecond())) {
                  Iterator var23 = this.getBoundProps().entrySet().iterator();

                  while(var23.hasNext()) {
                     Moveable var26 = (Moveable)((Entry)var23.next()).getKey();
                     var10001 = (PathProp)this;
                     Object var10002 = var2.getSecond();
                     Intrinsics.checkNotNullExpressionValue(var10002, "<get-second>(...)");
                     var26.processPath(var10001, (PathPoint)var10002);
                  }

               } else {
                  int var22 = ((Number)var2.getFirst()).intValue() - ((Number)var1.getFirst()).intValue();
                  int var4 = this.tick - ((Number)var1.getFirst()).intValue();
                  double var5 = (double)var4 / (double)var22;
                  double var7 = this.interpolate(((PathPoint)var1.getSecond()).getX(), ((PathPoint)var2.getSecond()).getX(), var5);
                  double var9 = this.interpolate(((PathPoint)var1.getSecond()).getY(), ((PathPoint)var2.getSecond()).getY(), var5);
                  double var11 = this.interpolate(((PathPoint)var1.getSecond()).getZ(), ((PathPoint)var2.getSecond()).getZ(), var5);
                  float var13 = (float)this.interpolate((double)((PathPoint)var1.getSecond()).getYaw(), (double)((PathPoint)var2.getSecond()).getYaw(), var5);
                  float var14 = (float)this.interpolate((double)((PathPoint)var1.getSecond()).getPitch(), (double)((PathPoint)var2.getSecond()).getPitch(), var5);
                  PathPoint var15 = new PathPoint(var7, var9, var11, var13, var14);
                  this.currentPoint = var15;
                  Iterator var16 = this.getBoundProps().entrySet().iterator();

                  while(var16.hasNext()) {
                     Moveable var17 = (Moveable)((Entry)var16.next()).getKey();
                     var17.processPath((PathProp)this, var15);
                  }

                  int var27 = this.tick++;
               }
            }
         }
      }
   }

   public void onAnimationEnd() {
      this.tick = 0;
   }

   private final Pair<Integer, PathPoint> lowerPoint() {
      PathPoint var1 = (PathPoint)this.getPoints().get(this.tick);
      if (var1 != null) {
         return new Pair(this.tick, var1);
      } else {
         Entry var10000 = this.getPoints().lowerEntry(this.tick);
         Pair var3;
         if (var10000 != null) {
            Entry var2 = var10000;
            var3 = new Pair(var2.getKey(), var2.getValue());
         } else {
            var3 = null;
         }

         return var3;
      }
   }

   private final double interpolate(double var1, double var3, double var5) {
      return var1 + (var3 - var1) * var5;
   }
}
