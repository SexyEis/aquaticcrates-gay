package gg.aquatic.aquaticcrates.plugin.animation.open;

import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationManager;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationSettings;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.reroll.RerollManager;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.audience.AquaticAudience;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010.\u001a\u00020/H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u00060"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/open/RegularAnimationImpl;", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "player", "Lorg/bukkit/entity/Player;", "animationManager", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;", "baseLocation", "Lorg/bukkit/Location;", "rewards", "", "Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "audience", "Lgg/aquatic/waves/util/audience/AquaticAudience;", "completionFuture", "Ljava/util/concurrent/CompletableFuture;", "<init>", "(Lorg/bukkit/entity/Player;Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;Lorg/bukkit/Location;Ljava/util/List;Lgg/aquatic/waves/util/audience/AquaticAudience;Ljava/util/concurrent/CompletableFuture;)V", "getPlayer", "()Lorg/bukkit/entity/Player;", "getAnimationManager", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;", "getBaseLocation", "()Lorg/bukkit/Location;", "getRewards", "()Ljava/util/List;", "getAudience", "()Lgg/aquatic/waves/util/audience/AquaticAudience;", "getCompletionFuture", "()Ljava/util/concurrent/CompletableFuture;", "value", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation$State;", "state", "getState", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation$State;", "setState", "(Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation$State;)V", "settings", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "getSettings", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "props", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "getProps", "()Ljava/util/concurrent/ConcurrentHashMap;", "onReroll", "", "plugin"}
)
public final class RegularAnimationImpl extends CrateAnimation {
   @NotNull
   private final Player player;
   @NotNull
   private final CrateAnimationManager animationManager;
   @NotNull
   private final Location baseLocation;
   @NotNull
   private final List<RolledReward> rewards;
   @NotNull
   private final AquaticAudience audience;
   @NotNull
   private final CompletableFuture<CrateAnimation> completionFuture;
   @NotNull
   private CrateAnimation.State state;
   @NotNull
   private final CrateAnimationSettings settings;
   @NotNull
   private final ConcurrentHashMap<String, AnimationProp> props;

   public RegularAnimationImpl(@NotNull Player var1, @NotNull CrateAnimationManager var2, @NotNull Location var3, @NotNull List<RolledReward> var4, @NotNull AquaticAudience var5, @NotNull CompletableFuture<CrateAnimation> var6) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "animationManager");
      Intrinsics.checkNotNullParameter(var3, "baseLocation");
      Intrinsics.checkNotNullParameter(var4, "rewards");
      Intrinsics.checkNotNullParameter(var5, "audience");
      Intrinsics.checkNotNullParameter(var6, "completionFuture");
      super();
      this.player = var1;
      this.animationManager = var2;
      this.baseLocation = var3;
      this.rewards = var4;
      this.audience = var5;
      this.completionFuture = var6;
      this.state = CrateAnimation.State.PRE_OPEN;
      this.settings = this.getAnimationManager().getAnimationSettings();
      this.props = new ConcurrentHashMap();
   }

   @NotNull
   public Player getPlayer() {
      return this.player;
   }

   @NotNull
   public CrateAnimationManager getAnimationManager() {
      return this.animationManager;
   }

   @NotNull
   public Location getBaseLocation() {
      return this.baseLocation;
   }

   @NotNull
   public List<RolledReward> getRewards() {
      return this.rewards;
   }

   @NotNull
   public AquaticAudience getAudience() {
      return this.audience;
   }

   @NotNull
   public CompletableFuture<CrateAnimation> getCompletionFuture() {
      return this.completionFuture;
   }

   @NotNull
   public CrateAnimation.State getState() {
      return this.state;
   }

   protected void setState(@NotNull CrateAnimation.State var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.state = var1;
   }

   @NotNull
   public CrateAnimationSettings getSettings() {
      return this.settings;
   }

   @NotNull
   public ConcurrentHashMap<String, AnimationProp> getProps() {
      return this.props;
   }

   public void onReroll() {
      Crate var10000 = this.getAnimationManager().getCrate();
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type gg.aquatic.aquaticcrates.api.crate.OpenableCrate");
      OpenableCrate var1 = (OpenableCrate)var10000;
      RerollManager var3 = this.getAnimationManager().getRerollManager();
      Intrinsics.checkNotNull(var3);
      RerollManager var2 = var3;
      var2.openReroll(this.getPlayer(), (CrateAnimation)this, (Collection)this.getRewards()).thenAcceptAsync(RegularAnimationImpl::onReroll$lambda$1).exceptionally(RegularAnimationImpl::onReroll$lambda$2);
   }

   private static final Unit onReroll$lambda$0(RegularAnimationImpl var0, OpenableCrate var1, RerollManager.RerollResult var2) {
      if (var2.getReroll()) {
         var0.updateState(CrateAnimation.State.OPENING);
         var0.getRewards().clear();
         Iterator var3 = ((Map)var0.getProps()).entrySet().iterator();

         while(var3.hasNext()) {
            AnimationProp var4 = (AnimationProp)((Entry)var3.next()).getValue();
            var4.onAnimationEnd();
         }

         var0.getProps().clear();
         CollectionsKt.addAll((Collection)var0.getRewards(), (Iterable)var1.getRewardManager().getRewards(var0.getPlayer()));
         var0.tick();
      } else {
         var0.updateState(CrateAnimation.State.POST_OPEN);
         var0.tick();
      }

      int var5 = var0.getUsedRerolls();
      var0.setUsedRerolls(var5 + 1);
      return Unit.INSTANCE;
   }

   private static final void onReroll$lambda$1(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Void onReroll$lambda$2(Throwable var0) {
      var0.printStackTrace();
      return null;
   }
}
