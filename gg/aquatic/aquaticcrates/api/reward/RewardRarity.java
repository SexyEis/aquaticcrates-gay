package gg.aquatic.aquaticcrates.api.reward;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.chance.IChance;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/reward/RewardRarity;", "Lgg/aquatic/waves/util/chance/IChance;", "rarityId", "", "displayName", "chance", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;D)V", "getRarityId", "()Ljava/lang/String;", "getDisplayName", "getChance", "()D", "api"}
)
public final class RewardRarity implements IChance {
   @NotNull
   private final String rarityId;
   @NotNull
   private final String displayName;
   private final double chance;

   public RewardRarity(@NotNull String var1, @NotNull String var2, double var3) {
      Intrinsics.checkNotNullParameter(var1, "rarityId");
      Intrinsics.checkNotNullParameter(var2, "displayName");
      super();
      this.rarityId = var1;
      this.displayName = var2;
      this.chance = var3;
   }

   @NotNull
   public final String getRarityId() {
      return this.rarityId;
   }

   @NotNull
   public final String getDisplayName() {
      return this.displayName;
   }

   public double getChance() {
      return this.chance;
   }
}
