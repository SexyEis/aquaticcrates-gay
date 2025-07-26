package gg.aquatic.aquaticcrates.plugin.restriction;

import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/restriction/OpenData;", "", "player", "Lorg/bukkit/entity/Player;", "location", "Lorg/bukkit/Location;", "crate", "Lgg/aquatic/aquaticcrates/api/crate/OpenableCrate;", "<init>", "(Lorg/bukkit/entity/Player;Lorg/bukkit/Location;Lgg/aquatic/aquaticcrates/api/crate/OpenableCrate;)V", "getPlayer", "()Lorg/bukkit/entity/Player;", "getLocation", "()Lorg/bukkit/Location;", "getCrate", "()Lgg/aquatic/aquaticcrates/api/crate/OpenableCrate;", "plugin"}
)
public final class OpenData {
   @NotNull
   private final Player player;
   @NotNull
   private final Location location;
   @NotNull
   private final OpenableCrate crate;

   public OpenData(@NotNull Player var1, @NotNull Location var2, @NotNull OpenableCrate var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "location");
      Intrinsics.checkNotNullParameter(var3, "crate");
      super();
      this.player = var1;
      this.location = var2;
      this.crate = var3;
   }

   @NotNull
   public final Player getPlayer() {
      return this.player;
   }

   @NotNull
   public final Location getLocation() {
      return this.location;
   }

   @NotNull
   public final OpenableCrate getCrate() {
      return this.crate;
   }
}
