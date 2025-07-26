package gg.aquatic.aquaticcrates.plugin.animation.prop;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathBoundProperties;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathPoint;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.joml.Math;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00070\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006#"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/Moveable;", "", "locationOffset", "Lorg/bukkit/util/Vector;", "getLocationOffset", "()Lorg/bukkit/util/Vector;", "locationOffsetYawPitch", "Lgg/aquatic/waves/libs/kotlin/Pair;", "", "getLocationOffsetYawPitch", "()Lkotlin/Pair;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/Animation;", "boundPaths", "Ljava/util/concurrent/ConcurrentHashMap;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathProp;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathBoundProperties;", "", "getBoundPaths", "()Ljava/util/concurrent/ConcurrentHashMap;", "processedPaths", "", "getProcessedPaths", "()Ljava/util/Set;", "processPath", "", "path", "point", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathPoint;", "calculatePoint", "move", "location", "Lorg/bukkit/Location;", "plugin"}
)
public interface Moveable {
   @NotNull
   Vector getLocationOffset();

   @NotNull
   Pair<Float, Float> getLocationOffsetYawPitch();

   @NotNull
   Animation getAnimation();

   @NotNull
   ConcurrentHashMap<PathProp, Pair<PathBoundProperties, Integer>> getBoundPaths();

   @NotNull
   Set<PathProp> getProcessedPaths();

   void processPath(@NotNull PathProp var1, @NotNull PathPoint var2);

   @NotNull
   PathPoint calculatePoint();

   void move(@NotNull Location var1);

   @Metadata(
      mv = {2, 1, 0},
      k = 3,
      xi = 48
   )
   @SourceDebugExtension({"SMAP\nMoveable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Moveable.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/Moveable$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,94:1\n1056#2:95\n*S KotlinDebug\n*F\n+ 1 Moveable.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/Moveable$DefaultImpls\n*L\n44#1:95\n*E\n"})
   public static final class DefaultImpls {
      public static void processPath(@NotNull Moveable var0, @NotNull PathProp var1, @NotNull PathPoint var2) {
         Intrinsics.checkNotNullParameter(var1, "path");
         Intrinsics.checkNotNullParameter(var2, "point");
         ((Collection)var0.getProcessedPaths()).add(var1);
         if (var0.getProcessedPaths().size() == var0.getBoundPaths().size()) {
            PathPoint var3 = var0.calculatePoint();
            Location var10000 = var0.getAnimation().getBaseLocation().clone().add(var3.getVector()).add(var0.getLocationOffset());
            Intrinsics.checkNotNullExpressionValue(var10000, "add(...)");
            Location var4 = var10000;
            var4.setYaw(var3.getYaw() + ((Number)var0.getLocationOffsetYawPitch().getFirst()).floatValue());
            var4.setPitch(var3.getPitch() + ((Number)var0.getLocationOffsetYawPitch().getSecond()).floatValue());
            var0.move(var4);
            var0.getProcessedPaths().clear();
         }
      }

      @NotNull
      public static PathPoint calculatePoint(@NotNull Moveable var0) {
         PathPoint var1 = new PathPoint(0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
         Set var10000 = var0.getBoundPaths().entrySet();
         Intrinsics.checkNotNullExpressionValue(var10000, "<get-entries>(...)");
         Iterable var3 = (Iterable)var10000;
         boolean var4 = false;
         Iterator var2 = CollectionsKt.sortedWith(var3, (Comparator)(new Moveable$DefaultImpls$calculatePoint$$inlined$sortedBy$1())).iterator();

         while(var2.hasNext()) {
            Object var21 = var2.next();
            Intrinsics.checkNotNullExpressionValue(var21, "next(...)");
            Entry var19 = (Entry)var21;
            var21 = var19.getKey();
            Intrinsics.checkNotNullExpressionValue(var21, "component1(...)");
            PathProp var20 = (PathProp)var21;
            var21 = var19.getValue();
            Intrinsics.checkNotNullExpressionValue(var21, "component2(...)");
            Pair var5 = (Pair)var21;
            PathBoundProperties var6 = (PathBoundProperties)var5.component1();
            PathPoint var7 = var20.getCurrentPoint();
            PathPoint var8 = var6.getOffset();
            Vector var9 = new Vector(var7.getX(), var7.getY(), var7.getZ());
            float var10 = 0.0F;
            float var11 = 0.0F;
            if (var6.getAffectYawPitch()) {
               var10 = var1.getYaw() + var7.getYaw();
               var11 = var1.getPitch() + var7.getPitch();
            } else {
               var10 = var1.getYaw();
               var11 = var1.getPitch();
            }

            var10 += var8.getYaw();
            var11 += var8.getPitch();
            if (var6.getOffsetType() == PathBoundProperties.OffsetType.STATIC) {
               var1 = new PathPoint(var9.getX() + var8.getX() + var1.getX(), var9.getY() + var8.getY() + var1.getY(), var9.getZ() + var8.getZ() + var1.getZ(), var10, var11);
            } else {
               Vector var22 = var9.clone().add(var8.getVector().rotateAroundY(-((double)Math.toRadians(var7.getYaw()))).rotateAroundX(-((double)Math.toRadians(var7.getPitch()))));
               Intrinsics.checkNotNullExpressionValue(var22, "add(...)");
               Vector var12 = var22;
               double var13 = var12.getX() + var1.getX();
               double var15 = var12.getY() + var1.getY();
               double var17 = var12.getZ() + var1.getZ();
               var1 = new PathPoint(var13, var15, var17, var10, var11);
            }
         }

         return var1;
      }
   }
}
