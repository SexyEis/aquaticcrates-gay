package gg.aquatic.aquaticcrates.api.animation.crate;

import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntries;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntriesKt;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H&J \u0010(\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H&R\u001e\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\tR\u0012\u0010\u0011\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u001e\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\tR\u0012\u0010\u0015\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "", "<init>", "()V", "animationTasks", "Ljava/util/TreeMap;", "", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "getAnimationTasks", "()Ljava/util/TreeMap;", "animationLength", "getAnimationLength", "()I", "preAnimationDelay", "getPreAnimationDelay", "preAnimationTasks", "getPreAnimationTasks", "postAnimationDelay", "getPostAnimationDelay", "postAnimationTasks", "getPostAnimationTasks", "finalAnimationTasks", "getFinalAnimationTasks", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "skippable", "", "getSkippable", "()Z", "create", "Ljava/util/concurrent/CompletableFuture;", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "player", "Lorg/bukkit/entity/Player;", "animationManager", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;", "location", "Lorg/bukkit/Location;", "rolledRewards", "", "Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "canBeOpened", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings$AnimationResult;", "AnimationResult", "api"}
)
public abstract class CrateAnimationSettings {
   @NotNull
   public abstract TreeMap<Integer, CrateAnimationActions> getAnimationTasks();

   public abstract int getAnimationLength();

   public abstract int getPreAnimationDelay();

   @NotNull
   public abstract TreeMap<Integer, CrateAnimationActions> getPreAnimationTasks();

   public abstract int getPostAnimationDelay();

   @NotNull
   public abstract TreeMap<Integer, CrateAnimationActions> getPostAnimationTasks();

   @NotNull
   public abstract CrateAnimationActions getFinalAnimationTasks();

   public abstract boolean getSkippable();

   @NotNull
   public abstract CompletableFuture<CrateAnimation> create(@NotNull Player var1, @NotNull CrateAnimationManager var2, @NotNull Location var3, @NotNull List<RolledReward> var4);

   @NotNull
   public abstract CrateAnimationSettings.AnimationResult canBeOpened(@NotNull Player var1, @NotNull CrateAnimationManager var2, @NotNull Location var3);

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings$AnimationResult;", "", "<init>", "(Ljava/lang/String;I)V", "ALREADY_BEING_OPENED", "ALREADY_BEING_OPENED_OTHER", "SUCCESS", "api"}
   )
   public static enum AnimationResult {
      ALREADY_BEING_OPENED,
      ALREADY_BEING_OPENED_OTHER,
      SUCCESS;

      // $FF: synthetic field
      private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

      @NotNull
      public static EnumEntries<CrateAnimationSettings.AnimationResult> getEntries() {
         return $ENTRIES;
      }

      // $FF: synthetic method
      private static final CrateAnimationSettings.AnimationResult[] $values() {
         CrateAnimationSettings.AnimationResult[] var0 = new CrateAnimationSettings.AnimationResult[]{ALREADY_BEING_OPENED, ALREADY_BEING_OPENED_OTHER, SUCCESS};
         return var0;
      }
   }
}
