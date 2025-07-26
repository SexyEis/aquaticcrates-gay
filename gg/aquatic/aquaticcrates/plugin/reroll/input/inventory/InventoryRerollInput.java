package gg.aquatic.aquaticcrates.plugin.reroll.input.inventory;

import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.reroll.RerollInput;
import gg.aquatic.aquaticcrates.api.reroll.RerollManager;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.aquaticcrates.plugin.reroll.input.InputSettingsFactory;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntries;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntriesKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.menu.MenuSerializer;
import gg.aquatic.waves.menu.SlotSelection;
import gg.aquatic.waves.menu.settings.PrivateMenuSettings;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/reroll/input/inventory/InventoryRerollInput;", "Lgg/aquatic/aquaticcrates/api/reroll/RerollInput;", "settings", "Lgg/aquatic/aquaticcrates/plugin/reroll/input/inventory/RerollInventorySettings;", "<init>", "(Lgg/aquatic/aquaticcrates/plugin/reroll/input/inventory/RerollInventorySettings;)V", "getSettings", "()Lgg/aquatic/aquaticcrates/plugin/reroll/input/inventory/RerollInventorySettings;", "handle", "Ljava/util/concurrent/CompletableFuture;", "Lgg/aquatic/aquaticcrates/api/reroll/RerollManager$RerollResult;", "rerollManager", "Lgg/aquatic/aquaticcrates/api/reroll/RerollManager;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "player", "Lorg/bukkit/entity/Player;", "rewards", "", "Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "Action", "Companion", "plugin"}
)
public final class InventoryRerollInput implements RerollInput {
   @NotNull
   public static final InventoryRerollInput.Companion Companion = new InventoryRerollInput.Companion((DefaultConstructorMarker)null);
   @NotNull
   private final RerollInventorySettings settings;

   public InventoryRerollInput(@NotNull RerollInventorySettings var1) {
      Intrinsics.checkNotNullParameter(var1, "settings");
      super();
      this.settings = var1;
   }

   @NotNull
   public final RerollInventorySettings getSettings() {
      return this.settings;
   }

   @NotNull
   public CompletableFuture<RerollManager.RerollResult> handle(@NotNull RerollManager var1, @NotNull CrateAnimation var2, @NotNull Player var3, @NotNull Collection<? extends RolledReward> var4) {
      Intrinsics.checkNotNullParameter(var1, "rerollManager");
      Intrinsics.checkNotNullParameter(var2, "animation");
      Intrinsics.checkNotNullParameter(var3, "player");
      Intrinsics.checkNotNullParameter(var4, "rewards");
      CompletableFuture var5 = new CompletableFuture();
      RerollMenu var6 = new RerollMenu(var3, var4, this.settings, var2, var5);
      var6.open();
      return var5;
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/reroll/input/inventory/InventoryRerollInput$Action;", "", "<init>", "(Ljava/lang/String;I)V", "REROLL", "CLAIM", "CANCEL", "plugin"}
   )
   public static enum Action {
      REROLL,
      CLAIM,
      CANCEL;

      // $FF: synthetic field
      private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

      @NotNull
      public static EnumEntries<InventoryRerollInput.Action> getEntries() {
         return $ENTRIES;
      }

      // $FF: synthetic method
      private static final InventoryRerollInput.Action[] $values() {
         InventoryRerollInput.Action[] var0 = new InventoryRerollInput.Action[]{REROLL, CLAIM, CANCEL};
         return var0;
      }
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/reroll/input/inventory/InventoryRerollInput$Companion;", "Lgg/aquatic/aquaticcrates/plugin/reroll/input/InputSettingsFactory;", "<init>", "()V", "serialize", "Lgg/aquatic/aquaticcrates/api/reroll/RerollInput;", "cfg", "Lorg/bukkit/configuration/file/FileConfiguration;", "plugin"}
   )
   public static final class Companion implements InputSettingsFactory {
      private Companion() {
      }

      @Nullable
      public RerollInput serialize(@NotNull FileConfiguration var1) {
         Intrinsics.checkNotNullParameter(var1, "cfg");
         MenuSerializer var10000 = MenuSerializer.INSTANCE;
         ConfigurationSection var10001 = var1.getConfigurationSection("reroll.inventory");
         if (var10001 == null) {
            return null;
         } else {
            PrivateMenuSettings var2 = var10000.loadPrivateInventory(var10001);
            boolean var3 = var1.getBoolean("reroll.inventory.clear-bottom-inventory");
            var10000 = MenuSerializer.INSTANCE;
            List var8 = var1.getStringList("reroll.inventory.reward-slots");
            Intrinsics.checkNotNullExpressionValue(var8, "getStringList(...)");
            SlotSelection var4 = var10000.loadSlotSelection(var8);
            String var7 = var1.getString("reroll.inventory.on-close-action", "CANCEL");
            Intrinsics.checkNotNull(var7);
            var7 = var7.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(var7, "toUpperCase(...)");
            InventoryRerollInput.Action var5 = InventoryRerollInput.Action.valueOf(var7);
            RerollInventorySettings var6 = new RerollInventorySettings(var2, var4, var3, var5);
            return (RerollInput)(new InventoryRerollInput(var6));
         }
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
