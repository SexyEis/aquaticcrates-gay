package gg.aquatic.aquaticcrates.api.reward;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.generic.ConfiguredExecutableObject;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/reward/RewardAction;", "", "massOpenExecute", "", "action", "Lgg/aquatic/waves/util/generic/ConfiguredExecutableObject;", "Lorg/bukkit/entity/Player;", "", "<init>", "(ZLgg/aquatic/waves/util/generic/ConfiguredExecutableObject;)V", "getMassOpenExecute", "()Z", "getAction", "()Lgg/aquatic/waves/util/generic/ConfiguredExecutableObject;", "api"}
)
public final class RewardAction {
   private final boolean massOpenExecute;
   @NotNull
   private final ConfiguredExecutableObject<Player, Unit> action;

   public RewardAction(boolean var1, @NotNull ConfiguredExecutableObject<Player, Unit> var2) {
      Intrinsics.checkNotNullParameter(var2, "action");
      super();
      this.massOpenExecute = var1;
      this.action = var2;
   }

   public final boolean getMassOpenExecute() {
      return this.massOpenExecute;
   }

   @NotNull
   public final ConfiguredExecutableObject<Player, Unit> getAction() {
      return this.action;
   }
}
