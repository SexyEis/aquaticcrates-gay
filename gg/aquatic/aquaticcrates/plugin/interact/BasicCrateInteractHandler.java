package gg.aquatic.aquaticcrates.plugin.interact;

import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.aquaticcrates.api.event.CrateInteractEvent;
import gg.aquatic.aquaticcrates.api.interaction.CrateInteractAction;
import gg.aquatic.aquaticcrates.api.interaction.crate.CrateInteractHandler;
import gg.aquatic.waves.api.event.EventExtKt;
import gg.aquatic.waves.item.AquaticItemInteractEvent.InteractType;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.generic.ConfiguredExecutableObject;
import java.util.EnumMap;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0005¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0002\u001a\u0004\u0018\u00010\u0017H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR,\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/interact/BasicCrateInteractHandler;", "Lgg/aquatic/aquaticcrates/api/interaction/crate/CrateInteractHandler;", "crate", "Lgg/aquatic/aquaticcrates/api/crate/Crate;", "clickActions", "Ljava/util/EnumMap;", "Lgg/aquatic/waves/item/AquaticItemInteractEvent$InteractType;", "Lgg/aquatic/waves/util/generic/ConfiguredExecutableObject;", "Lgg/aquatic/aquaticcrates/api/interaction/CrateInteractAction;", "", "<init>", "(Lgg/aquatic/aquaticcrates/api/crate/Crate;Ljava/util/EnumMap;)V", "getCrate", "()Lgg/aquatic/aquaticcrates/api/crate/Crate;", "getClickActions", "()Ljava/util/EnumMap;", "handleInteract", "", "player", "Lorg/bukkit/entity/Player;", "interactType", "interactedLocation", "Lorg/bukkit/Location;", "Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "plugin"}
)
public final class BasicCrateInteractHandler extends CrateInteractHandler {
   @NotNull
   private final Crate crate;
   @NotNull
   private final EnumMap<InteractType, ConfiguredExecutableObject<CrateInteractAction, Unit>> clickActions;

   public BasicCrateInteractHandler(@NotNull Crate var1, @NotNull EnumMap<InteractType, ConfiguredExecutableObject<CrateInteractAction, Unit>> var2) {
      Intrinsics.checkNotNullParameter(var1, "crate");
      Intrinsics.checkNotNullParameter(var2, "clickActions");
      super();
      this.crate = var1;
      this.clickActions = var2;
   }

   @NotNull
   public Crate getCrate() {
      return this.crate;
   }

   @NotNull
   public EnumMap<InteractType, ConfiguredExecutableObject<CrateInteractAction, Unit>> getClickActions() {
      return this.clickActions;
   }

   public boolean handleInteract(@NotNull Player var1, @NotNull InteractType var2, @NotNull Location var3, @Nullable SpawnedCrate var4) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "interactType");
      Intrinsics.checkNotNullParameter(var3, "interactedLocation");
      EventExtKt.call((Event)(new CrateInteractEvent(var1, var4, var2, var3)));
      ConfiguredExecutableObject var10000 = (ConfiguredExecutableObject)this.getClickActions().get(var2);
      if (var10000 == null) {
         return false;
      } else {
         ConfiguredExecutableObject var5 = var10000;
         var5.execute(new CrateInteractAction(this.getCrate(), var1, var2, var3, var4), BasicCrateInteractHandler::handleInteract$lambda$0);
         return true;
      }
   }

   private static final String handleInteract$lambda$0(CrateInteractAction var0, String var1) {
      Intrinsics.checkNotNullParameter(var0, "<unused var>");
      Intrinsics.checkNotNullParameter(var1, "str");
      return var1;
   }
}
