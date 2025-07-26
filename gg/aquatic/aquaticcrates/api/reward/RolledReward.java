package gg.aquatic.aquaticcrates.api.reward;

import gg.aquatic.waves.libs.kotlin.Metadata;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "", "<init>", "()V", "reward", "Lgg/aquatic/aquaticcrates/api/reward/Reward;", "getReward", "()Lgg/aquatic/aquaticcrates/api/reward/Reward;", "randomAmount", "", "getRandomAmount", "()I", "give", "", "player", "Lorg/bukkit/entity/Player;", "massOpen", "", "api"}
)
public abstract class RolledReward {
   @NotNull
   public abstract Reward getReward();

   public abstract int getRandomAmount();

   public abstract void give(@NotNull Player var1, boolean var2);
}
