package gg.aquatic.aquaticcrates.plugin.reward.menu;

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
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/reward/menu/RewardsMenuSettings;", "", "invSettings", "Lgg/aquatic/waves/menu/settings/PrivateMenuSettings;", "rewardSlots", "", "", "additionalRewardLore", "", "", "<init>", "(Lgg/aquatic/waves/menu/settings/PrivateMenuSettings;Ljava/util/Collection;Ljava/util/List;)V", "getInvSettings", "()Lgg/aquatic/waves/menu/settings/PrivateMenuSettings;", "getRewardSlots", "()Ljava/util/Collection;", "getAdditionalRewardLore", "()Ljava/util/List;", "plugin"}
)
public final class RewardsMenuSettings {
   @NotNull
   private final PrivateMenuSettings invSettings;
   @NotNull
   private final Collection<Integer> rewardSlots;
   @NotNull
   private final List<String> additionalRewardLore;

   public RewardsMenuSettings(@NotNull PrivateMenuSettings var1, @NotNull Collection<Integer> var2, @NotNull List<String> var3) {
      Intrinsics.checkNotNullParameter(var1, "invSettings");
      Intrinsics.checkNotNullParameter(var2, "rewardSlots");
      Intrinsics.checkNotNullParameter(var3, "additionalRewardLore");
      super();
      this.invSettings = var1;
      this.rewardSlots = var2;
      this.additionalRewardLore = var3;
   }

   @NotNull
   public final PrivateMenuSettings getInvSettings() {
      return this.invSettings;
   }

   @NotNull
   public final Collection<Integer> getRewardSlots() {
      return this.rewardSlots;
   }

   @NotNull
   public final List<String> getAdditionalRewardLore() {
      return this.additionalRewardLore;
   }
}
