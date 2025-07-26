package gg.aquatic.aquaticcrates.api.reward;

import gg.aquatic.aquaticcrates.api.milestone.MilestoneManager;
import gg.aquatic.waves.libs.kotlin.Metadata;
import java.util.List;
import java.util.Map;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/reward/RewardManager;", "", "<init>", "()V", "milestoneManager", "Lgg/aquatic/aquaticcrates/api/milestone/MilestoneManager;", "getMilestoneManager", "()Lgg/aquatic/aquaticcrates/api/milestone/MilestoneManager;", "rewards", "", "", "Lgg/aquatic/aquaticcrates/api/reward/Reward;", "getRewards", "()Ljava/util/Map;", "", "Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "player", "Lorg/bukkit/entity/Player;", "getPossibleRewards", "api"}
)
public abstract class RewardManager {
   @NotNull
   public abstract MilestoneManager getMilestoneManager();

   @NotNull
   public abstract Map<String, Reward> getRewards();

   @NotNull
   public abstract List<RolledReward> getRewards(@NotNull Player var1);

   @NotNull
   public abstract Map<String, Reward> getPossibleRewards(@NotNull Player var1);
}
