package gg.aquatic.aquaticcrates.plugin.reroll.input.inventory;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.menu.SlotSelection;
import gg.aquatic.waves.menu.settings.PrivateMenuSettings;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/reroll/input/inventory/RerollInventorySettings;", "", "inventorySettings", "Lgg/aquatic/waves/menu/settings/PrivateMenuSettings;", "rewardSlots", "Lgg/aquatic/waves/menu/SlotSelection;", "clearBottomInventory", "", "onClose", "Lgg/aquatic/aquaticcrates/plugin/reroll/input/inventory/InventoryRerollInput$Action;", "<init>", "(Lgg/aquatic/waves/menu/settings/PrivateMenuSettings;Lgg/aquatic/waves/menu/SlotSelection;ZLgg/aquatic/aquaticcrates/plugin/reroll/input/inventory/InventoryRerollInput$Action;)V", "getInventorySettings", "()Lgg/aquatic/waves/menu/settings/PrivateMenuSettings;", "getRewardSlots", "()Lgg/aquatic/waves/menu/SlotSelection;", "getClearBottomInventory", "()Z", "getOnClose", "()Lgg/aquatic/aquaticcrates/plugin/reroll/input/inventory/InventoryRerollInput$Action;", "plugin"}
)
public final class RerollInventorySettings {
   @NotNull
   private final PrivateMenuSettings inventorySettings;
   @NotNull
   private final SlotSelection rewardSlots;
   private final boolean clearBottomInventory;
   @NotNull
   private final InventoryRerollInput.Action onClose;

   public RerollInventorySettings(@NotNull PrivateMenuSettings var1, @NotNull SlotSelection var2, boolean var3, @NotNull InventoryRerollInput.Action var4) {
      Intrinsics.checkNotNullParameter(var1, "inventorySettings");
      Intrinsics.checkNotNullParameter(var2, "rewardSlots");
      Intrinsics.checkNotNullParameter(var4, "onClose");
      super();
      this.inventorySettings = var1;
      this.rewardSlots = var2;
      this.clearBottomInventory = var3;
      this.onClose = var4;
   }

   @NotNull
   public final PrivateMenuSettings getInventorySettings() {
      return this.inventorySettings;
   }

   @NotNull
   public final SlotSelection getRewardSlots() {
      return this.rewardSlots;
   }

   public final boolean getClearBottomInventory() {
      return this.clearBottomInventory;
   }

   @NotNull
   public final InventoryRerollInput.Action getOnClose() {
      return this.onClose;
   }
}
