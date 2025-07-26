package gg.aquatic.aquaticcrates.api.reward;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.random.Random;
import gg.aquatic.waves.util.chance.IChance;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\n¨\u0006\u0010"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/reward/RewardAmountRange;", "Lgg/aquatic/waves/util/chance/IChance;", "min", "", "max", "chance", "", "<init>", "(IID)V", "getMin", "()I", "getMax", "getChance", "()D", "randomNum", "getRandomNum", "api"}
)
public final class RewardAmountRange implements IChance {
   private final int min;
   private final int max;
   private final double chance;

   public RewardAmountRange(int var1, int var2, double var3) {
      this.min = var1;
      this.max = var2;
      this.chance = var3;
   }

   public final int getMin() {
      return this.min;
   }

   public final int getMax() {
      return this.max;
   }

   public double getChance() {
      return this.chance;
   }

   public final int getRandomNum() {
      return this.min == this.max ? this.min : Random.Default.nextInt(Math.min(this.min, this.max), Math.max(this.min, this.max) + 1);
   }
}
