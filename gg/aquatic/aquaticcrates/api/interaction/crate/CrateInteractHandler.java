package gg.aquatic.aquaticcrates.api.interaction.crate;

import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.interaction.CrateInteractAction;
import gg.aquatic.aquaticcrates.api.interaction.InteractHandler;
import gg.aquatic.waves.item.AquaticItemInteractEvent.InteractType;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.util.generic.ConfiguredExecutableObject;
import java.util.EnumMap;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/interaction/crate/CrateInteractHandler;", "Lgg/aquatic/aquaticcrates/api/interaction/InteractHandler;", "<init>", "()V", "clickActions", "Ljava/util/EnumMap;", "Lgg/aquatic/waves/item/AquaticItemInteractEvent$InteractType;", "Lgg/aquatic/waves/util/generic/ConfiguredExecutableObject;", "Lgg/aquatic/aquaticcrates/api/interaction/CrateInteractAction;", "", "getClickActions", "()Ljava/util/EnumMap;", "crate", "Lgg/aquatic/aquaticcrates/api/crate/Crate;", "getCrate", "()Lgg/aquatic/aquaticcrates/api/crate/Crate;", "api"}
)
public abstract class CrateInteractHandler extends InteractHandler {
   @NotNull
   public abstract EnumMap<InteractType, ConfiguredExecutableObject<CrateInteractAction, Unit>> getClickActions();

   @NotNull
   public abstract Crate getCrate();
}
