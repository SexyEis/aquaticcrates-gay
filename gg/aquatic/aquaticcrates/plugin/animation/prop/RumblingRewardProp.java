package gg.aquatic.aquaticcrates.plugin.animation.prop;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.api.animation.prop.ItemBasedProp;
import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.TypeIntrinsics;
import gg.aquatic.waves.libs.kotlin.random.Random;
import gg.aquatic.waves.libs.kotlin.ranges.RangesKt;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u001c\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0002J\u0010\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\tH\u0002J\u0018\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020!2\u0006\u0010(\u001a\u00020\tH\u0002J\b\u0010+\u001a\u00020%H\u0016J\n\u0010,\u001a\u0004\u0018\u00010-H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u001e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\"\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u001b\u001a\u0004\u0018\u00010!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006."},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/RumblingRewardProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/ItemBasedProp;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "rumblingLength", "", "rumblingPeriod", "easeOut", "", "rewardIndex", "onRumbleActions", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "onFinishActions", "<init>", "(Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;IIZILgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;)V", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "getRumblingLength", "()I", "getRumblingPeriod", "getEaseOut", "()Z", "getRewardIndex", "getOnRumbleActions", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "getOnFinishActions", "value", "tick", "getTick", "nextUpdateTick", "finished", "getFinished", "Lgg/aquatic/aquaticcrates/api/reward/Reward;", "currentReward", "getCurrentReward", "()Lgg/aquatic/aquaticcrates/api/reward/Reward;", "", "scheduleNextUpdate", "performUpdate", "final", "onUpdate", "reward", "onAnimationEnd", "item", "Lgg/aquatic/waves/item/AquaticItem;", "plugin"}
)
public final class RumblingRewardProp extends AnimationProp implements ItemBasedProp {
   @NotNull
   private final CrateAnimation animation;
   private final int rumblingLength;
   private final int rumblingPeriod;
   private final boolean easeOut;
   private final int rewardIndex;
   @NotNull
   private final CrateAnimationActions onRumbleActions;
   @NotNull
   private final CrateAnimationActions onFinishActions;
   private volatile int tick;
   private volatile int nextUpdateTick;
   private volatile boolean finished;
   @Nullable
   private volatile Reward currentReward;

   public RumblingRewardProp(@NotNull CrateAnimation var1, int var2, int var3, boolean var4, int var5, @NotNull CrateAnimationActions var6, @NotNull CrateAnimationActions var7) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      Intrinsics.checkNotNullParameter(var6, "onRumbleActions");
      Intrinsics.checkNotNullParameter(var7, "onFinishActions");
      super();
      this.animation = var1;
      this.rumblingLength = var2;
      this.rumblingPeriod = var3;
      this.easeOut = var4;
      this.rewardIndex = var5;
      this.onRumbleActions = var6;
      this.onFinishActions = var7;
      this.tick = -1;
      this.nextUpdateTick = -1;
   }

   @NotNull
   public CrateAnimation getAnimation() {
      return this.animation;
   }

   public final int getRumblingLength() {
      return this.rumblingLength;
   }

   public final int getRumblingPeriod() {
      return this.rumblingPeriod;
   }

   public final boolean getEaseOut() {
      return this.easeOut;
   }

   public final int getRewardIndex() {
      return this.rewardIndex;
   }

   @NotNull
   public final CrateAnimationActions getOnRumbleActions() {
      return this.onRumbleActions;
   }

   @NotNull
   public final CrateAnimationActions getOnFinishActions() {
      return this.onFinishActions;
   }

   public final int getTick() {
      return this.tick;
   }

   public final boolean getFinished() {
      return this.finished;
   }

   @Nullable
   public final Reward getCurrentReward() {
      return this.currentReward;
   }

   public void tick() {
      if (!this.finished) {
         int var1 = this.tick++;
         if (this.tick >= this.rumblingLength) {
            this.performUpdate(true);
         } else {
            if (this.tick == this.nextUpdateTick || this.nextUpdateTick == -1) {
               this.scheduleNextUpdate();
               this.performUpdate(false);
            }

         }
      }
   }

   private final void scheduleNextUpdate() {
      if (!this.easeOut) {
         this.nextUpdateTick = this.tick + this.rumblingPeriod;
      } else {
         int var1 = (int)((double)this.rumblingLength * 0.5D);
         int var2 = this.rumblingLength - this.tick;
         if (this.tick <= var1) {
            this.nextUpdateTick = this.tick + this.rumblingPeriod;
         } else {
            int var3 = this.rumblingLength - var1;
            double var4 = (double)var2 / (double)var3;
            int var6 = RangesKt.coerceAtLeast((int)((double)this.rumblingPeriod + (double)10 * ((double)1 - var4 * var4)), 1);
            this.nextUpdateTick = RangesKt.coerceAtMost(this.tick + var6, this.rumblingLength);
         }

      }
   }

   private final void performUpdate(boolean var1) {
      if (!var1) {
         Crate var10000 = this.getAnimation().getAnimationManager().getCrate();
         Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type gg.aquatic.aquaticcrates.api.crate.OpenableCrate");
         List var2 = CollectionsKt.toMutableList(((OpenableCrate)var10000).getRewardManager().getPossibleRewards(this.getAnimation().getPlayer()).values());
         if (this.currentReward != null) {
            Collection var3 = (Collection)var2;
            Reward var4 = this.currentReward;
            TypeIntrinsics.asMutableCollection(var3).remove(var4);
         }

         this.onUpdate((Reward)CollectionsKt.random((Collection)var2, (Random)Random.Default), false);
      } else {
         Reward var5;
         label18: {
            RolledReward var10001 = (RolledReward)CollectionsKt.getOrNull(this.getAnimation().getRewards(), this.rewardIndex);
            if (var10001 != null) {
               var5 = var10001.getReward();
               if (var5 != null) {
                  break label18;
               }
            }

            var5 = ((RolledReward)CollectionsKt.first(this.getAnimation().getRewards())).getReward();
         }

         this.onUpdate(var5, true);
         this.finished = true;
      }
   }

   private final void onUpdate(Reward var1, boolean var2) {
      this.currentReward = var1;
      if (var2) {
         this.onFinishActions.execute((Animation)this.getAnimation());
         this.finished = true;
      } else {
         this.onRumbleActions.execute((Animation)this.getAnimation());
      }

   }

   public void onAnimationEnd() {
   }

   @Nullable
   public AquaticItem item() {
      Reward var10000 = this.currentReward;
      return var10000 != null ? var10000.getItem() : null;
   }
}
