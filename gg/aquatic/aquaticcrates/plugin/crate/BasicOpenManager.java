package gg.aquatic.aquaticcrates.plugin.crate;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationManager;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationSettings;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.aquaticcrates.api.milestone.Milestone;
import gg.aquatic.aquaticcrates.api.player.CrateProfileModuleKt;
import gg.aquatic.aquaticcrates.api.player.HistoryHandler;
import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.aquaticcrates.plugin.animation.open.settings.InstantAnimationSettings;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.profile.AquaticPlayer;
import gg.aquatic.waves.profile.AquaticPlayerKt;
import gg.aquatic.waves.util.audience.AquaticAudience;
import gg.aquatic.waves.util.audience.FilterAudience;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J+\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/crate/BasicOpenManager;", "", "crate", "Lgg/aquatic/aquaticcrates/plugin/crate/BasicCrate;", "<init>", "(Lgg/aquatic/aquaticcrates/plugin/crate/BasicCrate;)V", "getCrate", "()Lgg/aquatic/aquaticcrates/plugin/crate/BasicCrate;", "instantOpen", "", "player", "Lorg/bukkit/entity/Player;", "massOpen", "", "open", "Ljava/util/concurrent/CompletableFuture;", "Ljava/lang/Void;", "location", "Lorg/bukkit/Location;", "spawnedCrate", "Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "amount", "", "threadsAmount", "(Lorg/bukkit/entity/Player;ILjava/lang/Integer;)Ljava/util/concurrent/CompletableFuture;", "Companion", "plugin"}
)
@SourceDebugExtension({"SMAP\nBasicOpenManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicOpenManager.kt\ngg/aquatic/aquaticcrates/plugin/crate/BasicOpenManager\n+ 2 CollectionExt.kt\ngg/aquatic/waves/util/collection/CollectionExtKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,196:1\n7#2,2:197\n9#2,2:200\n11#2:203\n7#2,2:212\n9#2,2:215\n11#2:218\n1863#3:199\n1864#3:202\n1863#3:214\n1864#3:217\n12#4,4:204\n12#4,4:208\n*S KotlinDebug\n*F\n+ 1 BasicOpenManager.kt\ngg/aquatic/aquaticcrates/plugin/crate/BasicOpenManager\n*L\n62#1:197,2\n62#1:200,2\n62#1:203\n84#1:212,2\n84#1:215,2\n84#1:218\n62#1:199\n62#1:202\n84#1:214\n84#1:217\n97#1:204,4\n155#1:208,4\n*E\n"})
public final class BasicOpenManager {
   @NotNull
   public static final BasicOpenManager.Companion Companion = new BasicOpenManager.Companion((DefaultConstructorMarker)null);
   @NotNull
   private final BasicCrate crate;
   private static final int THREADS_LIMIT = 2;

   public BasicOpenManager(@NotNull BasicCrate var1) {
      Intrinsics.checkNotNullParameter(var1, "crate");
      super();
      this.crate = var1;
   }

   @NotNull
   public final BasicCrate getCrate() {
      return this.crate;
   }

   public final void instantOpen(@NotNull Player var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      AquaticPlayer var10000 = AquaticPlayerKt.toAquaticPlayer(var1);
      if (var10000 != null && CrateProfileModuleKt.crateEntry(var10000) != null) {
         List var3 = this.crate.getRewardManager().getRewards(var1);
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            RolledReward var5 = (RolledReward)var4.next();
            var5.give(var1, var2);
         }

         this.crate.getAnimationManager().getAnimationSettings().getFinalAnimationTasks().execute((Animation)(new CrateAnimation(this, var3, var1) {
            private final CrateAnimationManager animationManager;
            private CrateAnimation.State state;
            private final List<RolledReward> rewards;
            private final CompletableFuture<CrateAnimation> completionFuture;
            private final CrateAnimationSettings settings;
            private final Player player;
            private final Location baseLocation;
            private final AquaticAudience audience;
            private final Map<String, AnimationProp> props;

            {
               this.animationManager = var1.getCrate().getAnimationManager();
               this.state = CrateAnimation.State.FINISHED;
               this.rewards = var2;
               CompletableFuture var10001 = CompletableFuture.completedFuture(this);
               Intrinsics.checkNotNullExpressionValue(var10001, "completedFuture(...)");
               this.completionFuture = var10001;
               this.settings = var1.getCrate().getAnimationManager().getAnimationSettings();
               this.player = var3;
               Location var4 = var3.getLocation();
               Intrinsics.checkNotNullExpressionValue(var4, "getLocation(...)");
               this.baseLocation = var4;
               this.audience = (AquaticAudience)(new FilterAudience(<undefinedtype>::audience$lambda$0));
               this.props = (Map)(new HashMap());
            }

            public CrateAnimationManager getAnimationManager() {
               return this.animationManager;
            }

            public CrateAnimation.State getState() {
               return this.state;
            }

            protected void setState(CrateAnimation.State var1) {
               Intrinsics.checkNotNullParameter(var1, "<set-?>");
               this.state = var1;
            }

            public List<RolledReward> getRewards() {
               return this.rewards;
            }

            public CompletableFuture<CrateAnimation> getCompletionFuture() {
               return this.completionFuture;
            }

            public CrateAnimationSettings getSettings() {
               return this.settings;
            }

            public void onReroll() {
            }

            public Player getPlayer() {
               return this.player;
            }

            public Location getBaseLocation() {
               return this.baseLocation;
            }

            public AquaticAudience getAudience() {
               return this.audience;
            }

            public Map<String, AnimationProp> getProps() {
               return this.props;
            }

            private static final Boolean audience$lambda$0(Player var0, Player var1) {
               Intrinsics.checkNotNullParameter(var1, "it");
               return Intrinsics.areEqual(var1, var0);
            }
         }));
         HistoryHandler var23 = HistoryHandler.INSTANCE;
         String var10002 = this.crate.getIdentifier();
         Collection var20 = (Collection)var3;
         String var18 = var10002;
         HistoryHandler var16 = var23;
         boolean var21 = false;
         Map var6 = (Map)(new LinkedHashMap());
         Iterable var7 = (Iterable)var20;
         boolean var8 = false;
         Iterator var9 = var7.iterator();

         while(var9.hasNext()) {
            Object var10 = var9.next();
            boolean var12 = false;
            RolledReward var14 = (RolledReward)var10;
            boolean var15 = false;
            Pair var22 = TuplesKt.to(var14.getReward().getId(), var14.getRandomAmount());
            var6.put(var22.getFirst(), var22.getSecond());
         }

         var16.registerCrateOpen(var1, var18, var6);
         InstantAnimationSettings.Companion.execute(var1, this.crate.getAnimationManager());
      }
   }

   // $FF: synthetic method
   public static void instantOpen$default(BasicOpenManager var0, Player var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      var0.instantOpen(var1, var2);
   }

   @NotNull
   public final CompletableFuture<Void> open(@NotNull Player var1, @NotNull Location var2, @Nullable SpawnedCrate var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "location");
      AquaticPlayer var10000 = AquaticPlayerKt.toAquaticPlayer(var1);
      CompletableFuture var5;
      if (var10000 != null && CrateProfileModuleKt.crateEntry(var10000) != null) {
         List var4 = this.crate.getRewardManager().getRewards(var1);
         var5 = this.crate.getAnimationManager().getAnimationSettings().create(var1, this.crate.getAnimationManager(), var2, var4).thenAccept(BasicOpenManager::open$lambda$3);
         Intrinsics.checkNotNullExpressionValue(var5, "thenAccept(...)");
         return var5;
      } else {
         var5 = CompletableFuture.completedFuture((Object)null);
         Intrinsics.checkNotNullExpressionValue(var5, "completedFuture(...)");
         return var5;
      }
   }

   @NotNull
   public final CompletableFuture<Void> massOpen(@NotNull Player var1, int var2, @Nullable Integer var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      int var4 = var3 != null ? var3 : 2;
      CompletableFuture var5 = new CompletableFuture();
      if (var2 > 10000) {
         ConcurrentHashMap var8 = new ConcurrentHashMap();
         boolean var7 = false;
         Waves.Companion.getINSTANCE().getServer().getScheduler().runTaskAsynchronously((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new BasicOpenManager$massOpen$$inlined$runAsync$1(var2, var4, var8, var5, this, var1)));
         return var5;
      } else {
         boolean var6 = false;
         Waves.Companion.getINSTANCE().getServer().getScheduler().runTaskAsynchronously((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new BasicOpenManager$massOpen$$inlined$runAsync$2(var2, this, var1, var5)));
         return var5;
      }
   }

   private static final Unit open$lambda$2(BasicOpenManager var0, Player var1, CrateAnimation var2) {
      List var3 = var0.crate.getRewardManager().getMilestoneManager().milestonesReached(var1);
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         Milestone var5 = (Milestone)var4.next();
         Iterator var6 = var5.getRewards().iterator();

         while(var6.hasNext()) {
            Reward var7 = (Reward)var6.next();
            var7.give(var1, 1, false);
         }
      }

      HistoryHandler var10000 = HistoryHandler.INSTANCE;
      String var10002 = var0.crate.getIdentifier();
      Collection var20 = (Collection)var2.getRewards();
      String var18 = var10002;
      HistoryHandler var16 = var10000;
      boolean var21 = false;
      Map var22 = (Map)(new LinkedHashMap());
      Iterable var23 = (Iterable)var20;
      boolean var8 = false;
      Iterator var9 = var23.iterator();

      while(var9.hasNext()) {
         Object var10 = var9.next();
         boolean var12 = false;
         RolledReward var14 = (RolledReward)var10;
         boolean var15 = false;
         Pair var24 = TuplesKt.to(var14.getReward().getId(), var14.getRandomAmount());
         var22.put(var24.getFirst(), var24.getSecond());
      }

      var16.registerCrateOpen(var1, var18, var22);
      return Unit.INSTANCE;
   }

   private static final void open$lambda$3(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/crate/BasicOpenManager$Companion;", "", "<init>", "()V", "THREADS_LIMIT", "", "plugin"}
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
