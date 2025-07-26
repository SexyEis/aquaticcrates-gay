package gg.aquatic.aquaticcrates.api.interaction;

import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.waves.item.AquaticItemInteractEvent.InteractType;
import gg.aquatic.waves.libs.kotlin.Metadata;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000e"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/interaction/InteractHandler;", "", "<init>", "()V", "handleInteract", "", "player", "Lorg/bukkit/entity/Player;", "clickType", "Lgg/aquatic/waves/item/AquaticItemInteractEvent$InteractType;", "interactedLocation", "Lorg/bukkit/Location;", "crate", "Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "api"}
)
public abstract class InteractHandler {
   public abstract boolean handleInteract(@NotNull Player var1, @NotNull InteractType var2, @NotNull Location var3, @Nullable SpawnedCrate var4);
}
