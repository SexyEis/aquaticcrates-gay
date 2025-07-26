package gg.aquatic.aquaticcrates.api.util;

import gg.aquatic.aquaticcrates.api.reward.RewardManager;
import gg.aquatic.waves.libs.kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/util/Rewardable;", "", "rewardManager", "Lgg/aquatic/aquaticcrates/api/reward/RewardManager;", "getRewardManager", "()Lgg/aquatic/aquaticcrates/api/reward/RewardManager;", "api"}
)
public interface Rewardable {
   @NotNull
   RewardManager getRewardManager();
}
