package gg.aquatic.aquaticcrates.plugin.animation.open.settings;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.crate.AnimationSettingsFactory;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationManager;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationSettings;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.audience.AquaticAudience;
import gg.aquatic.waves.util.audience.GlobalAudience;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0016J \u0010(\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u0014\u0010\u0018\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/open/settings/InstantAnimationSettings;", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "finalAnimationTasks", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "<init>", "(Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;)V", "getFinalAnimationTasks", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "animationTasks", "Ljava/util/TreeMap;", "", "getAnimationTasks", "()Ljava/util/TreeMap;", "animationLength", "getAnimationLength", "()I", "preAnimationDelay", "getPreAnimationDelay", "preAnimationTasks", "getPreAnimationTasks", "postAnimationDelay", "getPostAnimationDelay", "postAnimationTasks", "getPostAnimationTasks", "skippable", "", "getSkippable", "()Z", "create", "Ljava/util/concurrent/CompletableFuture;", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "player", "Lorg/bukkit/entity/Player;", "animationManager", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;", "location", "Lorg/bukkit/Location;", "rolledRewards", "", "Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "canBeOpened", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings$AnimationResult;", "Companion", "plugin"}
)
public final class InstantAnimationSettings extends CrateAnimationSettings {
   @NotNull
   public static final InstantAnimationSettings.Companion Companion = new InstantAnimationSettings.Companion((DefaultConstructorMarker)null);
   @NotNull
   private final CrateAnimationActions finalAnimationTasks;
   @NotNull
   private final TreeMap<Integer, CrateAnimationActions> animationTasks;
   private final int animationLength;
   private final int preAnimationDelay;
   @NotNull
   private final TreeMap<Integer, CrateAnimationActions> preAnimationTasks;
   private final int postAnimationDelay;
   @NotNull
   private final TreeMap<Integer, CrateAnimationActions> postAnimationTasks;
   private final boolean skippable;

   public InstantAnimationSettings(@NotNull CrateAnimationActions var1) {
      Intrinsics.checkNotNullParameter(var1, "finalAnimationTasks");
      super();
      this.finalAnimationTasks = var1;
      this.animationTasks = new TreeMap();
      this.preAnimationTasks = new TreeMap();
      this.postAnimationTasks = new TreeMap();
   }

   @NotNull
   public CrateAnimationActions getFinalAnimationTasks() {
      return this.finalAnimationTasks;
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

   public boolean getSkippable() {
      return this.skippable;
   }

   @NotNull
   public CompletableFuture<CrateAnimation> create(@NotNull Player var1, @NotNull CrateAnimationManager var2, @NotNull Location var3, @NotNull List<RolledReward> var4) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "animationManager");
      Intrinsics.checkNotNullParameter(var3, "location");
      Intrinsics.checkNotNullParameter(var4, "rolledRewards");
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         RolledReward var6 = (RolledReward)var5.next();
         var6.give(var1, false);
      }

      Companion.execute(var1, var2);
      CompletableFuture var10000 = CompletableFuture.completedFuture((Object)null);
      Intrinsics.checkNotNullExpressionValue(var10000, "completedFuture(...)");
      return var10000;
   }

   @NotNull
   public CrateAnimationSettings.AnimationResult canBeOpened(@NotNull Player var1, @NotNull CrateAnimationManager var2, @NotNull Location var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "animationManager");
      Intrinsics.checkNotNullParameter(var3, "location");
      return CrateAnimationSettings.AnimationResult.SUCCESS;
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/open/settings/InstantAnimationSettings$Companion;", "Lgg/aquatic/aquaticcrates/api/animation/crate/AnimationSettingsFactory;", "<init>", "()V", "serialize", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "execute", "", "player", "Lorg/bukkit/entity/Player;", "animationManager", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;", "plugin"}
   )
   public static final class Companion extends AnimationSettingsFactory {
      private Companion() {
      }

      @NotNull
      public CrateAnimationSettings serialize(@Nullable ConfigurationSection var1) {
         if (var1 == null) {
            return (CrateAnimationSettings)(new InstantAnimationSettings(new CrateAnimationActions()));
         } else {
            CrateAnimationActions var2 = this.loadFinalActions(var1);
            return (CrateAnimationSettings)(new InstantAnimationSettings(var2));
         }
      }

      public final void execute(@NotNull Player var1, @NotNull CrateAnimationManager var2) {
         Intrinsics.checkNotNullParameter(var1, "player");
         Intrinsics.checkNotNullParameter(var2, "animationManager");
         CrateAnimationActions var3 = var2.getAnimationSettings().getFinalAnimationTasks();
         CrateAnimation var4 = new CrateAnimation(var2, var1) {
            private final CrateAnimationManager animationManager;
            private CrateAnimation.State state;
            private final Location baseLocation;
            private final Player player;
            private final AquaticAudience audience;
            private final List<RolledReward> rewards;
            private final CompletableFuture<CrateAnimation> completionFuture;
            private final CrateAnimationSettings settings;
            private final Map<String, AnimationProp> props;

            {
               this.animationManager = var1;
               this.state = CrateAnimation.State.FINISHED;
               Location var10001 = var2.getLocation();
               Intrinsics.checkNotNullExpressionValue(var10001, "getLocation(...)");
               this.baseLocation = var10001;
               this.player = var2;
               this.audience = (AquaticAudience)(new GlobalAudience());
               this.rewards = (List)(new ArrayList());
               CompletableFuture var3 = CompletableFuture.completedFuture(this);
               Intrinsics.checkNotNullExpressionValue(var3, "completedFuture(...)");
               this.completionFuture = var3;
               this.settings = var1.getAnimationSettings();
               this.props = (Map)(new LinkedHashMap());
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

            public Location getBaseLocation() {
               return this.baseLocation;
            }

            public Player getPlayer() {
               return this.player;
            }

            public AquaticAudience getAudience() {
               return this.audience;
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

            public Map<String, AnimationProp> getProps() {
               return this.props;
            }

            public void tick() {
            }

            public void onReroll() {
            }
         };
         var3.execute((Animation)var4);
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
