package gg.aquatic.aquaticcrates.api.crate;

import gg.aquatic.aquaticcrates.api.hologram.HologramSettings;
import gg.aquatic.aquaticcrates.api.interaction.crate.CrateInteractHandler;
import gg.aquatic.waves.interactable.settings.InteractableSettings;
import gg.aquatic.waves.libs.kotlin.Metadata;
import java.util.List;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/crate/Crate;", "", "<init>", "()V", "identifier", "", "getIdentifier", "()Ljava/lang/String;", "displayName", "getDisplayName", "hologramSettings", "Lgg/aquatic/aquaticcrates/api/hologram/HologramSettings;", "getHologramSettings", "()Lgg/aquatic/aquaticcrates/api/hologram/HologramSettings;", "interactHandler", "Lgg/aquatic/aquaticcrates/api/interaction/crate/CrateInteractHandler;", "getInteractHandler", "()Lgg/aquatic/aquaticcrates/api/interaction/crate/CrateInteractHandler;", "interactables", "", "Lgg/aquatic/waves/interactable/settings/InteractableSettings;", "getInteractables", "()Ljava/util/List;", "api"}
)
public abstract class Crate {
   @NotNull
   public abstract String getIdentifier();

   @NotNull
   public abstract String getDisplayName();

   @NotNull
   public abstract HologramSettings getHologramSettings();

   @NotNull
   public abstract CrateInteractHandler getInteractHandler();

   @NotNull
   public abstract List<InteractableSettings> getInteractables();
}
