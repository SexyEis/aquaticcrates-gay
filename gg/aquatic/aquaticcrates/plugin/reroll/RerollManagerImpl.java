package gg.aquatic.aquaticcrates.plugin.reroll;

import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.reroll.RerollInput;
import gg.aquatic.aquaticcrates.api.reroll.RerollManager;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ,\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR0\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/reroll/RerollManagerImpl;", "Lgg/aquatic/aquaticcrates/api/reroll/RerollManager;", "crate", "Lgg/aquatic/aquaticcrates/api/crate/Crate;", "groups", "Ljava/util/HashMap;", "", "", "Lgg/aquatic/waves/libs/kotlin/collections/HashMap;", "rerollInput", "Lgg/aquatic/aquaticcrates/api/reroll/RerollInput;", "<init>", "(Lgg/aquatic/aquaticcrates/api/crate/Crate;Ljava/util/HashMap;Lgg/aquatic/aquaticcrates/api/reroll/RerollInput;)V", "getCrate", "()Lgg/aquatic/aquaticcrates/api/crate/Crate;", "getGroups", "()Ljava/util/HashMap;", "getRerollInput", "()Lgg/aquatic/aquaticcrates/api/reroll/RerollInput;", "openReroll", "Ljava/util/concurrent/CompletableFuture;", "Lgg/aquatic/aquaticcrates/api/reroll/RerollManager$RerollResult;", "player", "Lorg/bukkit/entity/Player;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "rewards", "", "Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "plugin"}
)
public final class RerollManagerImpl extends RerollManager {
   @NotNull
   private final Crate crate;
   @NotNull
   private final HashMap<String, Integer> groups;
   @NotNull
   private final RerollInput rerollInput;

   public RerollManagerImpl(@NotNull Crate var1, @NotNull HashMap<String, Integer> var2, @NotNull RerollInput var3) {
      Intrinsics.checkNotNullParameter(var1, "crate");
      Intrinsics.checkNotNullParameter(var2, "groups");
      Intrinsics.checkNotNullParameter(var3, "rerollInput");
      super();
      this.crate = var1;
      this.groups = var2;
      this.rerollInput = var3;
   }

   @NotNull
   public Crate getCrate() {
      return this.crate;
   }

   @NotNull
   public HashMap<String, Integer> getGroups() {
      return this.groups;
   }

   @NotNull
   public RerollInput getRerollInput() {
      return this.rerollInput;
   }

   @NotNull
   public CompletableFuture<RerollManager.RerollResult> openReroll(@NotNull Player var1, @NotNull CrateAnimation var2, @NotNull Collection<? extends RolledReward> var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "animation");
      Intrinsics.checkNotNullParameter(var3, "rewards");
      return this.getRerollInput().handle((RerollManager)this, var2, var1, var3);
   }
}
