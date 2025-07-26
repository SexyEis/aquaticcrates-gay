package gg.aquatic.aquaticcrates.plugin.reward;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import org.bukkit.entity.Player;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
public final class RewardManagerImpl$getPossibleRewards$$inlined$checkRequirements$1 implements Function2<Player, String, String> {
   public static final RewardManagerImpl$getPossibleRewards$$inlined$checkRequirements$1 INSTANCE = new RewardManagerImpl$getPossibleRewards$$inlined$checkRequirements$1();

   public final String invoke(Player var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "str");
      return var2;
   }
}
