package gg.aquatic.aquaticcrates.plugin.animation.prop.model;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.plugin.animation.prop.Moveable;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathBoundProperties;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathPoint;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathProp;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.interactable.type.BMInteractable;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B]\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\u000b\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\r¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010(\u001a\u00020)H\u0016J,\u0010*\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u00062\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u0011J\b\u0010.\u001a\u00020)H\u0016J\u0010\u0010/\u001a\u00020)2\u0006\u00100\u001a\u000201H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR,\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\"\u0010%\u001a\u0004\u0018\u00010$2\b\u0010#\u001a\u0004\u0018\u00010$@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00062"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/model/BMModelAnimationProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/Moveable;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "model", "", "modelAnimation", "locationOffset", "Lorg/bukkit/util/Vector;", "boundPaths", "Ljava/util/concurrent/ConcurrentHashMap;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathProp;", "Lgg/aquatic/waves/libs/kotlin/Pair;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathBoundProperties;", "", "locationOffsetYawPitch", "", "<init>", "(Lgg/aquatic/aquaticcrates/api/animation/Animation;Ljava/lang/String;Ljava/lang/String;Lorg/bukkit/util/Vector;Ljava/util/concurrent/ConcurrentHashMap;Lkotlin/Pair;)V", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/Animation;", "getModel", "()Ljava/lang/String;", "getModelAnimation", "getLocationOffset", "()Lorg/bukkit/util/Vector;", "getBoundPaths", "()Ljava/util/concurrent/ConcurrentHashMap;", "getLocationOffsetYawPitch", "()Lkotlin/Pair;", "processedPaths", "", "getProcessedPaths", "()Ljava/util/Set;", "value", "Lgg/aquatic/waves/interactable/type/BMInteractable;", "interactable", "getInteractable", "()Lgg/aquatic/waves/interactable/type/BMInteractable;", "tick", "", "playAnimation", "fadeIn", "fadeOut", "speed", "onAnimationEnd", "move", "location", "Lorg/bukkit/Location;", "plugin"}
)
@SourceDebugExtension({"SMAP\nBMModelAnimationProp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BMModelAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/model/BMModelAnimationProp\n+ 2 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,76:1\n6#2,4:77\n6#2,4:81\n6#2,4:85\n6#2,4:89\n*S KotlinDebug\n*F\n+ 1 BMModelAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/model/BMModelAnimationProp\n*L\n42#1:77,4\n59#1:81,4\n65#1:85,4\n72#1:89,4\n*E\n"})
public final class BMModelAnimationProp extends AnimationProp implements Moveable {
   @NotNull
   private final Animation animation;
   @NotNull
   private final String model;
   @Nullable
   private final String modelAnimation;
   @NotNull
   private final Vector locationOffset;
   @NotNull
   private final ConcurrentHashMap<PathProp, Pair<PathBoundProperties, Integer>> boundPaths;
   @NotNull
   private final Pair<Float, Float> locationOffsetYawPitch;
   @NotNull
   private final Set<PathProp> processedPaths;
   @Nullable
   private BMInteractable interactable;

   public BMModelAnimationProp(@NotNull Animation var1, @NotNull String var2, @Nullable String var3, @NotNull Vector var4, @NotNull ConcurrentHashMap<PathProp, Pair<PathBoundProperties, Integer>> var5, @NotNull Pair<Float, Float> var6) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      Intrinsics.checkNotNullParameter(var2, "model");
      Intrinsics.checkNotNullParameter(var4, "locationOffset");
      Intrinsics.checkNotNullParameter(var5, "boundPaths");
      Intrinsics.checkNotNullParameter(var6, "locationOffsetYawPitch");
      super();
      this.animation = var1;
      this.model = var2;
      this.modelAnimation = var3;
      this.locationOffset = var4;
      this.boundPaths = var5;
      this.locationOffsetYawPitch = var6;
      KeySetView var10001 = ConcurrentHashMap.newKeySet();
      Intrinsics.checkNotNullExpressionValue(var10001, "newKeySet(...)");
      this.processedPaths = (Set)var10001;
      Location var10000;
      if (this.getBoundPaths().isEmpty()) {
         Location var9 = this.getAnimation().getBaseLocation().clone().add(this.getLocationOffset());
         boolean var11 = false;
         var9.setYaw(var9.getYaw() + ((Number)this.getLocationOffsetYawPitch().getFirst()).floatValue());
         var9.setPitch(var9.getPitch() + ((Number)this.getLocationOffsetYawPitch().getSecond()).floatValue());
         var10000 = var9;
      } else {
         PathPoint var13 = this.calculatePoint();
         var10000 = this.getAnimation().getBaseLocation().clone().add(var13.getVector()).add(this.getLocationOffset());
         Intrinsics.checkNotNullExpressionValue(var10000, "add(...)");
         Location var10 = var10000;
         var10.setYaw(var13.getYaw() + ((Number)this.getLocationOffsetYawPitch().getFirst()).floatValue());
         var10.setPitch(var13.getPitch() + ((Number)this.getLocationOffsetYawPitch().getSecond()).floatValue());
         var10000 = var10;
      }

      Location var8 = var10000;
      Intrinsics.checkNotNull(var8);
      Location var7 = var8;
      boolean var12 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new BMModelAnimationProp$special$$inlined$runSync$1(this, var7)));
   }

   @NotNull
   public Animation getAnimation() {
      return this.animation;
   }

   @NotNull
   public final String getModel() {
      return this.model;
   }

   @Nullable
   public final String getModelAnimation() {
      return this.modelAnimation;
   }

   @NotNull
   public Vector getLocationOffset() {
      return this.locationOffset;
   }

   @NotNull
   public ConcurrentHashMap<PathProp, Pair<PathBoundProperties, Integer>> getBoundPaths() {
      return this.boundPaths;
   }

   @NotNull
   public Pair<Float, Float> getLocationOffsetYawPitch() {
      return this.locationOffsetYawPitch;
   }

   @NotNull
   public Set<PathProp> getProcessedPaths() {
      return this.processedPaths;
   }

   @Nullable
   public final BMInteractable getInteractable() {
      return this.interactable;
   }

   public void tick() {
   }

   public final void playAnimation(@NotNull String var1, int var2, int var3, float var4) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      boolean var5 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new BMModelAnimationProp$playAnimation$$inlined$runSync$1(this, var1, var2, var3, var4)));
   }

   // $FF: synthetic method
   public static void playAnimation$default(BMModelAnimationProp var0, String var1, int var2, int var3, float var4, int var5, Object var6) {
      if ((var5 & 2) != 0) {
         var2 = 0;
      }

      if ((var5 & 4) != 0) {
         var3 = 0;
      }

      if ((var5 & 8) != 0) {
         var4 = 1.0F;
      }

      var0.playAnimation(var1, var2, var3, var4);
   }

   public void onAnimationEnd() {
      boolean var1 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new BMModelAnimationProp$onAnimationEnd$$inlined$runSync$1(this)));
   }

   public void move(@NotNull Location var1) {
      Intrinsics.checkNotNullParameter(var1, "location");
      boolean var2 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new BMModelAnimationProp$move$$inlined$runSync$1(this, var1)));
   }

   public void processPath(@NotNull PathProp var1, @NotNull PathPoint var2) {
      Moveable.DefaultImpls.processPath(this, var1, var2);
   }

   @NotNull
   public PathPoint calculatePoint() {
      return Moveable.DefaultImpls.calculatePoint(this);
   }

   // $FF: synthetic method
   public static final void access$setInteractable$p(BMModelAnimationProp var0, BMInteractable var1) {
      var0.interactable = var1;
   }
}
