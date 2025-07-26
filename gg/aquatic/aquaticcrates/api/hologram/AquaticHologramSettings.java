package gg.aquatic.aquaticcrates.api.hologram;

import gg.aquatic.waves.hologram.LineSettings;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/hologram/AquaticHologramSettings;", "Lgg/aquatic/aquaticcrates/api/hologram/HologramSettings;", "lines", "", "Lgg/aquatic/waves/hologram/LineSettings;", "offset", "Lorg/bukkit/util/Vector;", "<init>", "(Ljava/util/Set;Lorg/bukkit/util/Vector;)V", "getLines", "()Ljava/util/Set;", "getOffset", "()Lorg/bukkit/util/Vector;", "create", "Lgg/aquatic/aquaticcrates/api/hologram/Hologram;", "location", "Lorg/bukkit/Location;", "api"}
)
public final class AquaticHologramSettings implements HologramSettings {
   @NotNull
   private final Set<LineSettings> lines;
   @NotNull
   private final Vector offset;

   public AquaticHologramSettings(@NotNull Set<? extends LineSettings> var1, @NotNull Vector var2) {
      Intrinsics.checkNotNullParameter(var1, "lines");
      Intrinsics.checkNotNullParameter(var2, "offset");
      super();
      this.lines = var1;
      this.offset = var2;
   }

   @NotNull
   public final Set<LineSettings> getLines() {
      return this.lines;
   }

   @NotNull
   public final Vector getOffset() {
      return this.offset;
   }

   @NotNull
   public Hologram create(@NotNull Location var1) {
      Intrinsics.checkNotNullParameter(var1, "location");
      Location var10002 = var1.clone();
      Intrinsics.checkNotNullExpressionValue(var10002, "clone(...)");
      return (Hologram)(new AHologram(var10002, this));
   }
}
