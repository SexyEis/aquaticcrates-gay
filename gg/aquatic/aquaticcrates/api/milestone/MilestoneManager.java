package gg.aquatic.aquaticcrates.api.milestone;

import gg.aquatic.waves.libs.kotlin.Metadata;
import java.util.List;
import java.util.TreeMap;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H&R\u001e\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/milestone/MilestoneManager;", "", "<init>", "()V", "milestones", "Ljava/util/TreeMap;", "", "Lgg/aquatic/aquaticcrates/api/milestone/Milestone;", "getMilestones", "()Ljava/util/TreeMap;", "repeatableMilestones", "getRepeatableMilestones", "milestonesReached", "", "player", "Lorg/bukkit/entity/Player;", "remaining", "milestone", "remainingRepeatable", "api"}
)
public abstract class MilestoneManager {
   @NotNull
   public abstract TreeMap<Integer, Milestone> getMilestones();

   @NotNull
   public abstract TreeMap<Integer, Milestone> getRepeatableMilestones();

   @NotNull
   public abstract List<Milestone> milestonesReached(@NotNull Player var1);

   public abstract int remaining(@NotNull Player var1, int var2);

   public abstract int remainingRepeatable(@NotNull Player var1, int var2);
}
