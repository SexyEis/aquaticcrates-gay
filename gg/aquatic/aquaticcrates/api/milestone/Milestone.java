package gg.aquatic.aquaticcrates.api.milestone;

import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.List;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/milestone/Milestone;", "", "milestone", "", "displayName", "Lnet/kyori/adventure/text/Component;", "rewards", "", "Lgg/aquatic/aquaticcrates/api/reward/Reward;", "<init>", "(ILnet/kyori/adventure/text/Component;Ljava/util/List;)V", "getMilestone", "()I", "getDisplayName", "()Lnet/kyori/adventure/text/Component;", "getRewards", "()Ljava/util/List;", "api"}
)
public final class Milestone {
   private final int milestone;
   @NotNull
   private final Component displayName;
   @NotNull
   private final List<Reward> rewards;

   public Milestone(int var1, @NotNull Component var2, @NotNull List<? extends Reward> var3) {
      Intrinsics.checkNotNullParameter(var2, "displayName");
      Intrinsics.checkNotNullParameter(var3, "rewards");
      super();
      this.milestone = var1;
      this.displayName = var2;
      this.rewards = var3;
   }

   public final int getMilestone() {
      return this.milestone;
   }

   @NotNull
   public final Component getDisplayName() {
      return this.displayName;
   }

   @NotNull
   public final List<Reward> getRewards() {
      return this.rewards;
   }
}
