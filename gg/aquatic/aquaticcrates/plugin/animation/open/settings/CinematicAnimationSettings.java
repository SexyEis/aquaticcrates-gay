package gg.aquatic.aquaticcrates.plugin.animation.open.settings;

import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.AnimationSettingsFactory;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationManager;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationSettings;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.aquaticcrates.plugin.animation.open.CinematicAnimationImpl;
import gg.aquatic.aquaticcrates.plugin.animation.prop.CameraAnimationProp;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.audience.AquaticAudience;
import gg.aquatic.waves.util.audience.FilterAudience;
import gg.aquatic.waves.util.location.AquaticLocation;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\u00020\u0001:\u00014B\u0093\u0001\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00110\u0011¢\u0006\u0004\b\u0014\u0010\u0015J4\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0016J \u00102\u001a\u0002032\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R)\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00110\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00065"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/open/settings/CinematicAnimationSettings;", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "animationTasks", "Ljava/util/TreeMap;", "", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "animationLength", "preAnimationDelay", "preAnimationTasks", "postAnimationDelay", "postAnimationTasks", "finalAnimationTasks", "skippable", "", "cinematicLocation", "Lgg/aquatic/waves/util/location/AquaticLocation;", "cameraLocation", "Lgg/aquatic/waves/libs/kotlin/Pair;", "Lorg/bukkit/util/Vector;", "", "<init>", "(Ljava/util/TreeMap;IILjava/util/TreeMap;ILjava/util/TreeMap;Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;ZLgg/aquatic/waves/util/location/AquaticLocation;Lkotlin/Pair;)V", "getAnimationTasks", "()Ljava/util/TreeMap;", "getAnimationLength", "()I", "getPreAnimationDelay", "getPreAnimationTasks", "getPostAnimationDelay", "getPostAnimationTasks", "getFinalAnimationTasks", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "getSkippable", "()Z", "getCinematicLocation", "()Lgg/aquatic/waves/util/location/AquaticLocation;", "getCameraLocation", "()Lkotlin/Pair;", "create", "Ljava/util/concurrent/CompletableFuture;", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "player", "Lorg/bukkit/entity/Player;", "animationManager", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;", "location", "Lorg/bukkit/Location;", "rolledRewards", "", "Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "canBeOpened", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings$AnimationResult;", "Companion", "plugin"}
)
@SourceDebugExtension({"SMAP\nCinematicAnimationSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CinematicAnimationSettings.kt\ngg/aquatic/aquaticcrates/plugin/animation/open/settings/CinematicAnimationSettings\n+ 2 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,112:1\n6#2,4:113\n*S KotlinDebug\n*F\n+ 1 CinematicAnimationSettings.kt\ngg/aquatic/aquaticcrates/plugin/animation/open/settings/CinematicAnimationSettings\n*L\n52#1:113,4\n*E\n"})
public final class CinematicAnimationSettings extends CrateAnimationSettings {
   @NotNull
   public static final CinematicAnimationSettings.Companion Companion = new CinematicAnimationSettings.Companion((DefaultConstructorMarker)null);
   @NotNull
   private final TreeMap<Integer, CrateAnimationActions> animationTasks;
   private final int animationLength;
   private final int preAnimationDelay;
   @NotNull
   private final TreeMap<Integer, CrateAnimationActions> preAnimationTasks;
   private final int postAnimationDelay;
   @NotNull
   private final TreeMap<Integer, CrateAnimationActions> postAnimationTasks;
   @NotNull
   private final CrateAnimationActions finalAnimationTasks;
   private final boolean skippable;
   @NotNull
   private final AquaticLocation cinematicLocation;
   @NotNull
   private final Pair<Vector, Pair<Float, Float>> cameraLocation;

   public CinematicAnimationSettings(@NotNull TreeMap<Integer, CrateAnimationActions> var1, int var2, int var3, @NotNull TreeMap<Integer, CrateAnimationActions> var4, int var5, @NotNull TreeMap<Integer, CrateAnimationActions> var6, @NotNull CrateAnimationActions var7, boolean var8, @NotNull AquaticLocation var9, @NotNull Pair<? extends Vector, Pair<Float, Float>> var10) {
      Intrinsics.checkNotNullParameter(var1, "animationTasks");
      Intrinsics.checkNotNullParameter(var4, "preAnimationTasks");
      Intrinsics.checkNotNullParameter(var6, "postAnimationTasks");
      Intrinsics.checkNotNullParameter(var7, "finalAnimationTasks");
      Intrinsics.checkNotNullParameter(var9, "cinematicLocation");
      Intrinsics.checkNotNullParameter(var10, "cameraLocation");
      super();
      this.animationTasks = var1;
      this.animationLength = var2;
      this.preAnimationDelay = var3;
      this.preAnimationTasks = var4;
      this.postAnimationDelay = var5;
      this.postAnimationTasks = var6;
      this.finalAnimationTasks = var7;
      this.skippable = var8;
      this.cinematicLocation = var9;
      this.cameraLocation = var10;
   }

   @NotNull
   public TreeMap<Integer, CrateAnimationActions> getAnimationTasks() {
      return this.animationTasks;
   }

   public int getAnimationLength() {
      return this.animationLength;
   }

   public int getPreAnimationDelay() {
      return this.preAnimationDelay;
   }

   @NotNull
   public TreeMap<Integer, CrateAnimationActions> getPreAnimationTasks() {
      return this.preAnimationTasks;
   }

   public int getPostAnimationDelay() {
      return this.postAnimationDelay;
   }

   @NotNull
   public TreeMap<Integer, CrateAnimationActions> getPostAnimationTasks() {
      return this.postAnimationTasks;
   }

   @NotNull
   public CrateAnimationActions getFinalAnimationTasks() {
      return this.finalAnimationTasks;
   }

   public boolean getSkippable() {
      return this.skippable;
   }

   @NotNull
   public final AquaticLocation getCinematicLocation() {
      return this.cinematicLocation;
   }

   @NotNull
   public final Pair<Vector, Pair<Float, Float>> getCameraLocation() {
      return this.cameraLocation;
   }

   @NotNull
   public CompletableFuture<CrateAnimation> create(@NotNull Player var1, @NotNull CrateAnimationManager var2, @NotNull Location var3, @NotNull List<RolledReward> var4) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "animationManager");
      Intrinsics.checkNotNullParameter(var3, "location");
      Intrinsics.checkNotNullParameter(var4, "rolledRewards");
      Location var10000 = this.cinematicLocation.toLocation();
      Intrinsics.checkNotNull(var10000);
      Location var5 = var10000;
      CinematicAnimationImpl var6 = new CinematicAnimationImpl(var1, var2, var5, var4, (AquaticAudience)(new FilterAudience(CinematicAnimationSettings::create$lambda$0)), new CompletableFuture());
      Iterator var7 = CrateAnimation.EquipmentSlot.getEntries().iterator();

      while(var7.hasNext()) {
         CrateAnimation.EquipmentSlot var8 = (CrateAnimation.EquipmentSlot)var7.next();
         ((Map)var6.getPlayerEquipment()).put(var8, new ItemStack(Material.AIR));
      }

      boolean var12 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new CinematicAnimationSettings$create$$inlined$runSync$1(var1)));
      Location var9 = var5.clone();
      boolean var11 = false;
      var9.setX(((Vector)this.cameraLocation.getFirst()).getX());
      var9.setY(((Vector)this.cameraLocation.getFirst()).getY());
      var9.setZ(((Vector)this.cameraLocation.getFirst()).getZ());
      var9.setYaw(((Number)((Pair)this.cameraLocation.getSecond()).getFirst()).floatValue());
      var9.setPitch(((Number)((Pair)this.cameraLocation.getSecond()).getSecond()).floatValue());
      Intrinsics.checkNotNullExpressionValue(var9, "apply(...)");
      CameraAnimationProp var13 = new CameraAnimationProp((PlayerBoundAnimation)var6, var9, new Vector(), new ConcurrentHashMap(), TuplesKt.to(0.0F, 0.0F));
      ((Map)var6.getProps()).put("camera", var13);
      var2.playAnimation((CrateAnimation)var6);
      return var6.getCompletionFuture();
   }

   @NotNull
   public CrateAnimationSettings.AnimationResult canBeOpened(@NotNull Player var1, @NotNull CrateAnimationManager var2, @NotNull Location var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "animationManager");
      Intrinsics.checkNotNullParameter(var3, "location");
      return var2.getPlayingAnimations().containsKey(var1.getUniqueId()) ? CrateAnimationSettings.AnimationResult.ALREADY_BEING_OPENED : CrateAnimationSettings.AnimationResult.SUCCESS;
   }

   private static final Boolean create$lambda$0(Player var0, Player var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      return Intrinsics.areEqual(var1, var0);
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/open/settings/CinematicAnimationSettings$Companion;", "Lgg/aquatic/aquaticcrates/api/animation/crate/AnimationSettingsFactory;", "<init>", "()V", "serialize", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "plugin"}
   )
   public static final class Companion extends AnimationSettingsFactory {
      private Companion() {
      }

      @Nullable
      public CrateAnimationSettings serialize(@Nullable ConfigurationSection var1) {
         if (var1 == null) {
            return null;
         } else {
            ConfigurationSection var10000 = var1.getConfigurationSection("location");
            if (var10000 == null) {
               return null;
            } else {
               ConfigurationSection var2 = var10000;
               String var23 = var2.getString("world");
               if (var23 == null) {
                  return null;
               } else {
                  String var3 = var23;
                  double var4 = var2.getDouble("x");
                  double var6 = var2.getDouble("y");
                  double var8 = var2.getDouble("z");
                  float var10 = (float)var2.getDouble("pitch");
                  float var11 = (float)var2.getDouble("yaw");
                  AquaticLocation var12 = new AquaticLocation(var3, var4, var6, var8, var10, var11);
                  var10000 = var1.getConfigurationSection("camera-location");
                  if (var10000 == null) {
                     return null;
                  } else {
                     ConfigurationSection var13 = var10000;
                     double var14 = var13.getDouble("x");
                     double var16 = var13.getDouble("y");
                     double var18 = var13.getDouble("z");
                     float var20 = (float)var13.getDouble("pitch");
                     float var21 = (float)var13.getDouble("yaw");
                     Pair var22 = new Pair(new Vector(var14, var16, var18), new Pair(var21, var20));
                     return (CrateAnimationSettings)(new CinematicAnimationSettings(this.loadAnimationTasks(var1.getConfigurationSection("tasks")), this.loadAnimationLength(var1), this.loadPreAnimationDelay(var1), this.loadPreAnimationTasks(var1), this.loadPostAnimationDelay(var1), this.loadPostAnimationTasks(var1), this.loadFinalActions(var1), this.loadSkippable(var1), var12, var22));
                  }
               }
            }
         }
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
