package gg.aquatic.aquaticcrates.api.interaction;

import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.waves.item.AquaticItemInteractEvent.InteractType;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/interaction/CrateInteractAction;", "", "crate", "Lgg/aquatic/aquaticcrates/api/crate/Crate;", "player", "Lorg/bukkit/entity/Player;", "interactType", "Lgg/aquatic/waves/item/AquaticItemInteractEvent$InteractType;", "interactedLocation", "Lorg/bukkit/Location;", "spawnedCrate", "Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "<init>", "(Lgg/aquatic/aquaticcrates/api/crate/Crate;Lorg/bukkit/entity/Player;Lgg/aquatic/waves/item/AquaticItemInteractEvent$InteractType;Lorg/bukkit/Location;Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;)V", "getCrate", "()Lgg/aquatic/aquaticcrates/api/crate/Crate;", "getPlayer", "()Lorg/bukkit/entity/Player;", "getInteractType", "()Lgg/aquatic/waves/item/AquaticItemInteractEvent$InteractType;", "getInteractedLocation", "()Lorg/bukkit/Location;", "getSpawnedCrate", "()Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "api"}
)
public final class CrateInteractAction {
   @NotNull
   private final Crate crate;
   @NotNull
   private final Player player;
   @NotNull
   private final InteractType interactType;
   @NotNull
   private final Location interactedLocation;
   @Nullable
   private final SpawnedCrate spawnedCrate;

   public CrateInteractAction(@NotNull Crate var1, @NotNull Player var2, @NotNull InteractType var3, @NotNull Location var4, @Nullable SpawnedCrate var5) {
      Intrinsics.checkNotNullParameter(var1, "crate");
      Intrinsics.checkNotNullParameter(var2, "player");
      Intrinsics.checkNotNullParameter(var3, "interactType");
      Intrinsics.checkNotNullParameter(var4, "interactedLocation");
      super();
      this.crate = var1;
      this.player = var2;
      this.interactType = var3;
      this.interactedLocation = var4;
      this.spawnedCrate = var5;
   }

   @NotNull
   public final Crate getCrate() {
      return this.crate;
   }

   @NotNull
   public final Player getPlayer() {
      return this.player;
   }

   @NotNull
   public final InteractType getInteractType() {
      return this.interactType;
   }

   @NotNull
   public final Location getInteractedLocation() {
      return this.interactedLocation;
   }

   @Nullable
   public final SpawnedCrate getSpawnedCrate() {
      return this.spawnedCrate;
   }
}
