package gg.aquatic.aquaticcrates.plugin.preview;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.menu.settings.PrivateMenuSettings;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0001\u001dBC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenuSettings;", "", "invSettings", "Lgg/aquatic/waves/menu/settings/PrivateMenuSettings;", "clearBottomInventory", "", "rewardSlots", "", "", "randomRewards", "Lgg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenuSettings$RandomRewardsSettings;", "additionalRewardLore", "", "", "updateRewardItemsEvery", "<init>", "(Lgg/aquatic/waves/menu/settings/PrivateMenuSettings;ZLjava/util/Collection;Lgg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenuSettings$RandomRewardsSettings;Ljava/util/List;I)V", "getInvSettings", "()Lgg/aquatic/waves/menu/settings/PrivateMenuSettings;", "getClearBottomInventory", "()Z", "getRewardSlots", "()Ljava/util/Collection;", "getRandomRewards", "()Lgg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenuSettings$RandomRewardsSettings;", "getAdditionalRewardLore", "()Ljava/util/List;", "getUpdateRewardItemsEvery", "()I", "RandomRewardsSettings", "plugin"}
)
public final class CratePreviewMenuSettings {
   @NotNull
   private final PrivateMenuSettings invSettings;
   private final boolean clearBottomInventory;
   @NotNull
   private final Collection<Integer> rewardSlots;
   @NotNull
   private final CratePreviewMenuSettings.RandomRewardsSettings randomRewards;
   @NotNull
   private final List<String> additionalRewardLore;
   private final int updateRewardItemsEvery;

   public CratePreviewMenuSettings(@NotNull PrivateMenuSettings var1, boolean var2, @NotNull Collection<Integer> var3, @NotNull CratePreviewMenuSettings.RandomRewardsSettings var4, @NotNull List<String> var5, int var6) {
      Intrinsics.checkNotNullParameter(var1, "invSettings");
      Intrinsics.checkNotNullParameter(var3, "rewardSlots");
      Intrinsics.checkNotNullParameter(var4, "randomRewards");
      Intrinsics.checkNotNullParameter(var5, "additionalRewardLore");
      super();
      this.invSettings = var1;
      this.clearBottomInventory = var2;
      this.rewardSlots = var3;
      this.randomRewards = var4;
      this.additionalRewardLore = var5;
      this.updateRewardItemsEvery = var6;
   }

   @NotNull
   public final PrivateMenuSettings getInvSettings() {
      return this.invSettings;
   }

   public final boolean getClearBottomInventory() {
      return this.clearBottomInventory;
   }

   @NotNull
   public final Collection<Integer> getRewardSlots() {
      return this.rewardSlots;
   }

   @NotNull
   public final CratePreviewMenuSettings.RandomRewardsSettings getRandomRewards() {
      return this.randomRewards;
   }

   @NotNull
   public final List<String> getAdditionalRewardLore() {
      return this.additionalRewardLore;
   }

   public final int getUpdateRewardItemsEvery() {
      return this.updateRewardItemsEvery;
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenuSettings$RandomRewardsSettings;", "", "slots", "", "", "changeDuration", "<init>", "(Ljava/util/Collection;I)V", "getSlots", "()Ljava/util/Collection;", "getChangeDuration", "()I", "plugin"}
   )
   public static final class RandomRewardsSettings {
      @NotNull
      private final Collection<Integer> slots;
      private final int changeDuration;

      public RandomRewardsSettings(@NotNull Collection<Integer> var1, int var2) {
         Intrinsics.checkNotNullParameter(var1, "slots");
         super();
         this.slots = var1;
         this.changeDuration = var2;
      }

      @NotNull
      public final Collection<Integer> getSlots() {
         return this.slots;
      }

      public final int getChangeDuration() {
         return this.changeDuration;
      }
   }
}
