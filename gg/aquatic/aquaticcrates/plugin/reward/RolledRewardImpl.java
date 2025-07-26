package gg.aquatic.aquaticcrates.plugin.reward;

import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/reward/RolledRewardImpl;", "Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "reward", "Lgg/aquatic/aquaticcrates/api/reward/Reward;", "randomAmount", "", "<init>", "(Lgg/aquatic/aquaticcrates/api/reward/Reward;I)V", "getReward", "()Lgg/aquatic/aquaticcrates/api/reward/Reward;", "getRandomAmount", "()I", "give", "", "player", "Lorg/bukkit/entity/Player;", "massOpen", "", "plugin"}
)
public final class RolledRewardImpl extends RolledReward {
   @NotNull
   private final Reward reward;
   private final int randomAmount;

   public RolledRewardImpl(@NotNull Reward var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "reward");
      super();
      this.reward = var1;
      this.randomAmount = var2;
   }

   @NotNull
   public Reward getReward() {
      return this.reward;
   }

   public int getRandomAmount() {
      return this.randomAmount;
   }

   public void give(@NotNull Player var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      this.getReward().give(var1, this.getRandomAmount(), var2);
   }
}
