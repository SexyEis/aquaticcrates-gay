package gg.aquatic.aquaticcrates.plugin.animation.prop.model;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.plugin.animation.prop.Moveable;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathBoundProperties;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathPoint;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathProp;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.interactable.type.MEGInteractable;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002Bg\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\r\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010,\u001a\u00020-H\u0016J,\u0010.\u001a\u00020-2\u0006\u0010\u0003\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u00102\u001a\u000200J\b\u00103\u001a\u00020-H\u0016J\u0010\u00104\u001a\u00020-2\u0006\u00105\u001a\u000206H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR,\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\"\u0010)\u001a\u0004\u0018\u00010(2\b\u0010'\u001a\u0004\u0018\u00010(@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u00067"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/model/ModelAnimationProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/Moveable;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "model", "", "skin", "Lorg/bukkit/entity/Player;", "modelAnimation", "locationOffset", "Lorg/bukkit/util/Vector;", "boundPaths", "Ljava/util/concurrent/ConcurrentHashMap;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathProp;", "Lgg/aquatic/waves/libs/kotlin/Pair;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathBoundProperties;", "", "locationOffsetYawPitch", "", "<init>", "(Lgg/aquatic/aquaticcrates/api/animation/Animation;Ljava/lang/String;Lorg/bukkit/entity/Player;Ljava/lang/String;Lorg/bukkit/util/Vector;Ljava/util/concurrent/ConcurrentHashMap;Lkotlin/Pair;)V", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/Animation;", "getModel", "()Ljava/lang/String;", "getSkin", "()Lorg/bukkit/entity/Player;", "getModelAnimation", "getLocationOffset", "()Lorg/bukkit/util/Vector;", "getBoundPaths", "()Ljava/util/concurrent/ConcurrentHashMap;", "getLocationOffsetYawPitch", "()Lkotlin/Pair;", "processedPaths", "", "getProcessedPaths", "()Ljava/util/Set;", "value", "Lgg/aquatic/waves/interactable/type/MEGInteractable;", "interactable", "getInteractable", "()Lgg/aquatic/waves/interactable/type/MEGInteractable;", "tick", "", "playAnimation", "fadeIn", "", "fadeOut", "speed", "onAnimationEnd", "move", "location", "Lorg/bukkit/Location;", "plugin"}
)
@SourceDebugExtension({"SMAP\nModelAnimationProp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModelAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/model/ModelAnimationProp\n+ 2 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,85:1\n6#2,4:86\n6#2,4:90\n6#2,4:94\n6#2,4:98\n*S KotlinDebug\n*F\n+ 1 ModelAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/model/ModelAnimationProp\n*L\n44#1:86,4\n62#1:90,4\n68#1:94,4\n75#1:98,4\n*E\n"})
public final class ModelAnimationProp extends AnimationProp implements Moveable {
   @NotNull
   private final Animation animation;
   @NotNull
   private final String model;
   @Nullable
   private final Player skin;
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
   private MEGInteractable interactable;

   public ModelAnimationProp(@NotNull Animation var1, @NotNull String var2, @Nullable Player var3, @Nullable String var4, @NotNull Vector var5, @NotNull ConcurrentHashMap<PathProp, Pair<PathBoundProperties, Integer>> var6, @NotNull Pair<Float, Float> var7) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      Intrinsics.checkNotNullParameter(var2, "model");
      Intrinsics.checkNotNullParameter(var5, "locationOffset");
      Intrinsics.checkNotNullParameter(var6, "boundPaths");
      Intrinsics.checkNotNullParameter(var7, "locationOffsetYawPitch");
      super();
      this.animation = var1;
      this.model = var2;
      this.skin = var3;
      this.modelAnimation = var4;
      this.locationOffset = var5;
      this.boundPaths = var6;
      this.locationOffsetYawPitch = var7;
      KeySetView var10001 = ConcurrentHashMap.newKeySet();
      Intrinsics.checkNotNullExpressionValue(var10001, "newKeySet(...)");
      this.processedPaths = (Set)var10001;
      Location var10000;
      if (this.getBoundPaths().isEmpty()) {
         Location var10 = this.getAnimation().getBaseLocation().clone().add(this.getLocationOffset());
         boolean var12 = false;
         var10.setYaw(var10.getYaw() + ((Number)this.getLocationOffsetYawPitch().getFirst()).floatValue());
         var10.setPitch(var10.getPitch() + ((Number)this.getLocationOffsetYawPitch().getSecond()).floatValue());
         var10000 = var10;
      } else {
         PathPoint var13 = this.calculatePoint();
         var10000 = this.getAnimation().getBaseLocation().clone().add(var13.getVector()).add(this.getLocationOffset());
         Intrinsics.checkNotNullExpressionValue(var10000, "add(...)");
         Location var11 = var10000;
         var11.setYaw(var13.getYaw() + ((Number)this.getLocationOffsetYawPitch().getFirst()).floatValue());
         var11.setPitch(var13.getPitch() + ((Number)this.getLocationOffsetYawPitch().getSecond()).floatValue());
         var10000 = var11;
      }

      Location var9 = var10000;
      Intrinsics.checkNotNull(var9);
      Location var8 = var9;
      boolean var14 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new ModelAnimationProp$special$$inlined$runSync$1(this, var8)));
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
   public final Player getSkin() {
      return this.skin;
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
   public final MEGInteractable getInteractable() {
      return this.interactable;
   }

   public void tick() {
   }

   public final void playAnimation(@NotNull String var1, double var2, double var4, double var6) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      boolean var8 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new ModelAnimationProp$playAnimation$$inlined$runSync$1(this, var1, var2, var4, var6)));
   }

   // $FF: synthetic method
   public static void playAnimation$default(ModelAnimationProp var0, String var1, double var2, double var4, double var6, int var8, Object var9) {
      if ((var8 & 2) != 0) {
         var2 = 0.0D;
      }

      if ((var8 & 4) != 0) {
         var4 = 0.0D;
      }

      if ((var8 & 8) != 0) {
         var6 = 1.0D;
      }

      var0.playAnimation(var1, var2, var4, var6);
   }

   public void onAnimationEnd() {
      boolean var1 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new ModelAnimationProp$onAnimationEnd$$inlined$runSync$1(this)));
   }

   public void move(@NotNull Location var1) {
      Intrinsics.checkNotNullParameter(var1, "location");
      boolean var2 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new ModelAnimationProp$move$$inlined$runSync$1(this, var1)));
   }

   public void processPath(@NotNull PathProp var1, @NotNull PathPoint var2) {
      Moveable.DefaultImpls.processPath(this, var1, var2);
   }

   @NotNull
   public PathPoint calculatePoint() {
      return Moveable.DefaultImpls.calculatePoint(this);
   }

   // $FF: synthetic method
   public static final void access$setInteractable$p(ModelAnimationProp var0, MEGInteractable var1) {
      var0.interactable = var1;
   }
}
