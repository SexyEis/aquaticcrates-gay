package gg.aquatic.aquaticcrates.plugin.milestone;

import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.milestone.Milestone;
import gg.aquatic.aquaticcrates.api.milestone.MilestoneManager;
import gg.aquatic.aquaticcrates.api.player.CrateProfileEntry;
import gg.aquatic.aquaticcrates.api.player.HistoryHandler;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0017"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/milestone/MilestoneManagerImpl;", "Lgg/aquatic/aquaticcrates/api/milestone/MilestoneManager;", "crate", "Lgg/aquatic/aquaticcrates/api/crate/OpenableCrate;", "milestones", "Ljava/util/TreeMap;", "", "Lgg/aquatic/aquaticcrates/api/milestone/Milestone;", "repeatableMilestones", "<init>", "(Lgg/aquatic/aquaticcrates/api/crate/OpenableCrate;Ljava/util/TreeMap;Ljava/util/TreeMap;)V", "getCrate", "()Lgg/aquatic/aquaticcrates/api/crate/OpenableCrate;", "getMilestones", "()Ljava/util/TreeMap;", "getRepeatableMilestones", "milestonesReached", "", "player", "Lorg/bukkit/entity/Player;", "remaining", "milestone", "remainingRepeatable", "plugin"}
)
@SourceDebugExtension({"SMAP\nMilestoneManagerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MilestoneManagerImpl.kt\ngg/aquatic/aquaticcrates/plugin/milestone/MilestoneManagerImpl\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,43:1\n216#2,2:44\n*S KotlinDebug\n*F\n+ 1 MilestoneManagerImpl.kt\ngg/aquatic/aquaticcrates/plugin/milestone/MilestoneManagerImpl\n*L\n24#1:44,2\n*E\n"})
public final class MilestoneManagerImpl extends MilestoneManager {
   @NotNull
   private final OpenableCrate crate;
   @NotNull
   private final TreeMap<Integer, Milestone> milestones;
   @NotNull
   private final TreeMap<Integer, Milestone> repeatableMilestones;

   public MilestoneManagerImpl(@NotNull OpenableCrate var1, @NotNull TreeMap<Integer, Milestone> var2, @NotNull TreeMap<Integer, Milestone> var3) {
      Intrinsics.checkNotNullParameter(var1, "crate");
      Intrinsics.checkNotNullParameter(var2, "milestones");
      Intrinsics.checkNotNullParameter(var3, "repeatableMilestones");
      super();
      this.crate = var1;
      this.milestones = var2;
      this.repeatableMilestones = var3;
   }

   @NotNull
   public final OpenableCrate getCrate() {
      return this.crate;
   }

   @NotNull
   public TreeMap<Integer, Milestone> getMilestones() {
      return this.milestones;
   }

   @NotNull
   public TreeMap<Integer, Milestone> getRepeatableMilestones() {
      return this.repeatableMilestones;
   }

   @NotNull
   public List<Milestone> milestonesReached(@NotNull Player var1) {
      Intrinsics.checkNotNullParameter(var1, "player");
      List var2 = (List)(new ArrayList());
      int var3 = HistoryHandler.INSTANCE.history(this.crate.getIdentifier(), CrateProfileEntry.HistoryType.ALLTIME, var1);
      if (this.getMilestones().containsKey(var3)) {
         Collection var10000 = (Collection)var2;
         Object var10001 = this.getMilestones().get(var3);
         Intrinsics.checkNotNull(var10001);
         var10000.add(var10001);
      }

      Map var4 = (Map)this.getRepeatableMilestones();
      boolean var5 = false;
      Iterator var6 = var4.entrySet().iterator();

      while(var6.hasNext()) {
         Entry var7 = (Entry)var6.next();
         boolean var9 = false;
         int var10 = ((Number)var7.getKey()).intValue();
         Milestone var11 = (Milestone)var7.getValue();
         if (var3 % var10 == 0) {
            ((Collection)var2).add(var11);
         }
      }

      return var2;
   }

   public int remaining(@NotNull Player var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      if (var2 < 1) {
         return 0;
      } else {
         int var3 = HistoryHandler.INSTANCE.history(this.crate.getIdentifier(), CrateProfileEntry.HistoryType.ALLTIME, var1);
         return Math.max(var2 - var3, 0);
      }
   }

   public int remainingRepeatable(@NotNull Player var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      if (var2 < 1) {
         return 0;
      } else {
         int var3 = HistoryHandler.INSTANCE.history(this.crate.getIdentifier(), CrateProfileEntry.HistoryType.ALLTIME, var1);
         return Math.max(var2 - var3 % var2, var2);
      }
   }
}
