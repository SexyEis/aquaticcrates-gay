package gg.aquatic.aquaticcrates.api.event;

import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.waves.api.event.AquaticEvent;
import gg.aquatic.waves.item.AquaticItemInteractEvent.InteractType;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u0017"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/event/CrateInteractEvent;", "Lgg/aquatic/waves/api/event/AquaticEvent;", "player", "Lorg/bukkit/entity/Player;", "placedCrate", "Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "interactType", "Lgg/aquatic/waves/item/AquaticItemInteractEvent$InteractType;", "interactedLocation", "Lorg/bukkit/Location;", "<init>", "(Lorg/bukkit/entity/Player;Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;Lgg/aquatic/waves/item/AquaticItemInteractEvent$InteractType;Lorg/bukkit/Location;)V", "getPlayer", "()Lorg/bukkit/entity/Player;", "getPlacedCrate", "()Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "getInteractType", "()Lgg/aquatic/waves/item/AquaticItemInteractEvent$InteractType;", "getInteractedLocation", "()Lorg/bukkit/Location;", "isKeyInteraction", "", "()Z", "api"}
)
public final class CrateInteractEvent extends AquaticEvent {
   @NotNull
   private final Player player;
   @Nullable
   private final SpawnedCrate placedCrate;
   @NotNull
   private final InteractType interactType;
   @NotNull
   private final Location interactedLocation;

   public CrateInteractEvent(@NotNull Player var1, @Nullable SpawnedCrate var2, @NotNull InteractType var3, @NotNull Location var4) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var3, "interactType");
      Intrinsics.checkNotNullParameter(var4, "interactedLocation");
      super(false, 1, (DefaultConstructorMarker)null);
      this.player = var1;
      this.placedCrate = var2;
      this.interactType = var3;
      this.interactedLocation = var4;
   }

   @NotNull
   public final Player getPlayer() {
      return this.player;
   }

   @Nullable
   public final SpawnedCrate getPlacedCrate() {
      return this.placedCrate;
   }

   @NotNull
   public final InteractType getInteractType() {
      return this.interactType;
   }

   @NotNull
   public final Location getInteractedLocation() {
      return this.interactedLocation;
   }

   public final boolean isKeyInteraction() {
      return this.placedCrate == null;
   }
}
