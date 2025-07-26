package gg.aquatic.aquaticcrates.plugin;

import gg.aquatic.aquaticcrates.api.player.PlayerHandler;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"},
   d2 = {"takeKeys", "", "Lorg/bukkit/entity/Player;", "id", "", "amount", "", "plugin"}
)
public final class PlayerExtKt {
   public static final boolean takeKeys(@NotNull Player var0, @NotNull String var1, int var2) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "id");
      return PlayerHandler.INSTANCE.takeKeys(var0, var1, var2);
   }
}
