package gg.aquatic.aquaticcrates.api.reroll;

import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.waves.libs.kotlin.Metadata;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¨\u0006\u000e"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/reroll/RerollInput;", "", "handle", "Ljava/util/concurrent/CompletableFuture;", "Lgg/aquatic/aquaticcrates/api/reroll/RerollManager$RerollResult;", "rerollManager", "Lgg/aquatic/aquaticcrates/api/reroll/RerollManager;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "player", "Lorg/bukkit/entity/Player;", "rewards", "", "Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "api"}
)
public interface RerollInput {
   @NotNull
   CompletableFuture<RerollManager.RerollResult> handle(@NotNull RerollManager var1, @NotNull CrateAnimation var2, @NotNull Player var3, @NotNull Collection<? extends RolledReward> var4);
}
