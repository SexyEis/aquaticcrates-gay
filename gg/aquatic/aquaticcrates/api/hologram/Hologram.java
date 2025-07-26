package gg.aquatic.aquaticcrates.api.hologram;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.audience.AquaticAudience;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\nH&J*\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0010H&J\"\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0010H&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0014"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/hologram/Hologram;", "", "location", "Lorg/bukkit/Location;", "<init>", "(Lorg/bukkit/Location;)V", "getLocation", "()Lorg/bukkit/Location;", "setLocation", "move", "", "despawn", "spawn", "audience", "Lgg/aquatic/waves/util/audience/AquaticAudience;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "Lorg/bukkit/entity/Player;", "", "update", "api"}
)
public abstract class Hologram {
   @NotNull
   private Location location;

   public Hologram(@NotNull Location var1) {
      Intrinsics.checkNotNullParameter(var1, "location");
      super();
      this.location = var1;
   }

   @NotNull
   public final Location getLocation() {
      return this.location;
   }

   public final void setLocation(@NotNull Location var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.location = var1;
   }

   public abstract void move(@NotNull Location var1);

   public abstract void despawn();

   public abstract void spawn(@NotNull AquaticAudience var1, @NotNull Function2<? super Player, ? super String, String> var2);

   public abstract void update(@NotNull Function2<? super Player, ? super String, String> var1);
}
