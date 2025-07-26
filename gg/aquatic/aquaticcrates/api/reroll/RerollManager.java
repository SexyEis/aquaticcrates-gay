package gg.aquatic.aquaticcrates.api.reroll;

import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH&J\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R.\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/reroll/RerollManager;", "", "<init>", "()V", "crate", "Lgg/aquatic/aquaticcrates/api/crate/Crate;", "getCrate", "()Lgg/aquatic/aquaticcrates/api/crate/Crate;", "groups", "Ljava/util/HashMap;", "", "", "Lgg/aquatic/waves/libs/kotlin/collections/HashMap;", "getGroups", "()Ljava/util/HashMap;", "rerollInput", "Lgg/aquatic/aquaticcrates/api/reroll/RerollInput;", "getRerollInput", "()Lgg/aquatic/aquaticcrates/api/reroll/RerollInput;", "openReroll", "Ljava/util/concurrent/CompletableFuture;", "Lgg/aquatic/aquaticcrates/api/reroll/RerollManager$RerollResult;", "player", "Lorg/bukkit/entity/Player;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "rewards", "", "Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "availableRerolls", "RerollResult", "api"}
)
public abstract class RerollManager {
   @NotNull
   public abstract Crate getCrate();

   @NotNull
   public abstract HashMap<String, Integer> getGroups();

   @NotNull
   public abstract RerollInput getRerollInput();

   @NotNull
   public abstract CompletableFuture<RerollManager.RerollResult> openReroll(@NotNull Player var1, @NotNull CrateAnimation var2, @NotNull Collection<? extends RolledReward> var3);

   public final int availableRerolls(@NotNull Player var1) {
      Intrinsics.checkNotNullParameter(var1, "player");
      int var2 = 0;
      Iterator var3 = ((Map)this.getGroups()).entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         String var5 = (String)var4.getKey();
         int var6 = ((Number)var4.getValue()).intValue();
         if (var1.hasPermission("aquaticcrates.reroll." + var5) && var6 > var2) {
            var2 = var6;
         }
      }

      return var2;
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/reroll/RerollManager$RerollResult;", "", "reroll", "", "<init>", "(Z)V", "getReroll", "()Z", "api"}
   )
   public static final class RerollResult {
      private final boolean reroll;

      public RerollResult(boolean var1) {
         this.reroll = var1;
      }

      public final boolean getReroll() {
         return this.reroll;
      }
   }
}
