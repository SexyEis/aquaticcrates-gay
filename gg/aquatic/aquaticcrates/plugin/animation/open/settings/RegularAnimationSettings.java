package gg.aquatic.aquaticcrates.plugin.animation.open.settings;

import gg.aquatic.aquaticcrates.api.animation.crate.AnimationSettingsFactory;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationManager;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationSettings;
import gg.aquatic.aquaticcrates.api.crate.CrateHandler;
import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.aquaticcrates.plugin.animation.open.RegularAnimationImpl;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.audience.AquaticAudience;
import gg.aquatic.waves.util.audience.FilterAudience;
import gg.aquatic.waves.util.audience.GlobalAudience;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,Bs\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J4\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J \u0010*\u001a\u00020+2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c¨\u0006-"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/open/settings/RegularAnimationSettings;", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "animationTasks", "Ljava/util/TreeMap;", "", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "animationLength", "preAnimationDelay", "preAnimationTasks", "postAnimationDelay", "postAnimationTasks", "finalAnimationTasks", "skippable", "", "personal", "<init>", "(Ljava/util/TreeMap;IILjava/util/TreeMap;ILjava/util/TreeMap;Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;ZZ)V", "getAnimationTasks", "()Ljava/util/TreeMap;", "getAnimationLength", "()I", "getPreAnimationDelay", "getPreAnimationTasks", "getPostAnimationDelay", "getPostAnimationTasks", "getFinalAnimationTasks", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "getSkippable", "()Z", "getPersonal", "create", "Ljava/util/concurrent/CompletableFuture;", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "player", "Lorg/bukkit/entity/Player;", "animationManager", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;", "location", "Lorg/bukkit/Location;", "rolledRewards", "", "Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "canBeOpened", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings$AnimationResult;", "Companion", "plugin"}
)
@SourceDebugExtension({"SMAP\nRegularAnimationSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RegularAnimationSettings.kt\ngg/aquatic/aquaticcrates/plugin/animation/open/settings/RegularAnimationSettings\n+ 2 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,90:1\n30#2,4:91\n6#2,4:95\n*S KotlinDebug\n*F\n+ 1 RegularAnimationSettings.kt\ngg/aquatic/aquaticcrates/plugin/animation/open/settings/RegularAnimationSettings\n*L\n46#1:91,4\n56#1:95,4\n*E\n"})
public final class RegularAnimationSettings extends CrateAnimationSettings {
   @NotNull
   public static final RegularAnimationSettings.Companion Companion = new RegularAnimationSettings.Companion((DefaultConstructorMarker)null);
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
   private final boolean personal;

   public RegularAnimationSettings(@NotNull TreeMap<Integer, CrateAnimationActions> var1, int var2, int var3, @NotNull TreeMap<Integer, CrateAnimationActions> var4, int var5, @NotNull TreeMap<Integer, CrateAnimationActions> var6, @NotNull CrateAnimationActions var7, boolean var8, boolean var9) {
      Intrinsics.checkNotNullParameter(var1, "animationTasks");
      Intrinsics.checkNotNullParameter(var4, "preAnimationTasks");
      Intrinsics.checkNotNullParameter(var6, "postAnimationTasks");
      Intrinsics.checkNotNullParameter(var7, "finalAnimationTasks");
      super();
      this.animationTasks = var1;
      this.animationLength = var2;
      this.preAnimationDelay = var3;
      this.preAnimationTasks = var4;
      this.postAnimationDelay = var5;
      this.postAnimationTasks = var6;
      this.finalAnimationTasks = var7;
      this.skippable = var8;
      this.personal = var9;
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

   public final boolean getPersonal() {
      return this.personal;
   }

   @NotNull
   public CompletableFuture<CrateAnimation> create(@NotNull Player var1, @NotNull CrateAnimationManager var2, @NotNull Location var3, @NotNull List<RolledReward> var4) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "animationManager");
      Intrinsics.checkNotNullParameter(var3, "location");
      Intrinsics.checkNotNullParameter(var4, "rolledRewards");
      RegularAnimationImpl var5 = new RegularAnimationImpl(var1, var2, var3, var4, this.personal ? (AquaticAudience)(new FilterAudience(RegularAnimationSettings::create$lambda$0)) : (AquaticAudience)(new GlobalAudience()), new CompletableFuture());
      SpawnedCrate var6 = (SpawnedCrate)CrateHandler.INSTANCE.getSpawned().get(var3);
      var5.tick();
      long var7 = 1L;
      boolean var9 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTaskLater((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new RegularAnimationSettings$create$$inlined$runLaterSync$1(this, var6, var1)), var7);
      var2.playAnimation((CrateAnimation)var5);
      CompletableFuture var10000 = var5.getCompletionFuture().thenApply(RegularAnimationSettings::create$lambda$4);
      Intrinsics.checkNotNullExpressionValue(var10000, "thenApply(...)");
      return var10000;
   }

   @NotNull
   public CrateAnimationSettings.AnimationResult canBeOpened(@NotNull Player var1, @NotNull CrateAnimationManager var2, @NotNull Location var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "animationManager");
      Intrinsics.checkNotNullParameter(var3, "location");
      if (!((Map)var2.getPlayingAnimations()).isEmpty() && !this.personal) {
         return CrateAnimationSettings.AnimationResult.ALREADY_BEING_OPENED_OTHER;
      } else {
         return this.personal && var2.getPlayingAnimations().containsKey(var1.getUniqueId()) ? CrateAnimationSettings.AnimationResult.ALREADY_BEING_OPENED : CrateAnimationSettings.AnimationResult.SUCCESS;
      }
   }

   private static final Boolean create$lambda$0(Player var0, Player var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      return Intrinsics.areEqual(var1, var0);
   }

   private static final CrateAnimation create$lambda$3(RegularAnimationSettings var0, SpawnedCrate var1, Player var2, CrateAnimation var3) {
      boolean var4 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new RegularAnimationSettings$create$lambda$3$$inlined$runSync$1(var0, var1, var2)));
      return var3;
   }

   private static final CrateAnimation create$lambda$4(Function1 var0, Object var1) {
      return (CrateAnimation)var0.invoke(var1);
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/open/settings/RegularAnimationSettings$Companion;", "Lgg/aquatic/aquaticcrates/api/animation/crate/AnimationSettingsFactory;", "<init>", "()V", "serialize", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "plugin"}
   )
   public static final class Companion extends AnimationSettingsFactory {
      private Companion() {
      }

      @Nullable
      public CrateAnimationSettings serialize(@Nullable ConfigurationSection var1) {
         return var1 == null ? null : (CrateAnimationSettings)(new RegularAnimationSettings(this.loadAnimationTasks(var1.getConfigurationSection("tasks")), this.loadAnimationLength(var1), this.loadPreAnimationDelay(var1), this.loadPreAnimationTasks(var1), this.loadPostAnimationDelay(var1), this.loadPostAnimationTasks(var1), this.loadFinalActions(var1), this.loadSkippable(var1), this.loadIsPersonal(var1)));
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
