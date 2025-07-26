package gg.aquatic.aquaticcrates.api.crate;

import gg.aquatic.aquaticcrates.api.interaction.key.KeyInteractHandler;
import gg.aquatic.aquaticcrates.api.util.ItemBased;
import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.item.AquaticItemInteractEvent;
import gg.aquatic.waves.item.ItemHandler;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.registry.ItemRegistryKt;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/crate/Key;", "Lgg/aquatic/aquaticcrates/api/util/ItemBased;", "crate", "Lgg/aquatic/aquaticcrates/api/crate/Crate;", "item", "Lgg/aquatic/waves/item/AquaticItem;", "<init>", "(Lgg/aquatic/aquaticcrates/api/crate/Crate;Lgg/aquatic/waves/item/AquaticItem;)V", "getCrate", "()Lgg/aquatic/aquaticcrates/api/crate/Crate;", "getItem", "()Lgg/aquatic/waves/item/AquaticItem;", "mustBeHeld", "", "getMustBeHeld", "()Z", "interactHandler", "Lgg/aquatic/aquaticcrates/api/interaction/key/KeyInteractHandler;", "getInteractHandler", "()Lgg/aquatic/aquaticcrates/api/interaction/key/KeyInteractHandler;", "Companion", "api"}
)
public abstract class Key implements ItemBased {
   @NotNull
   public static final Key.Companion Companion = new Key.Companion((DefaultConstructorMarker)null);
   @NotNull
   private final Crate crate;
   @NotNull
   private final AquaticItem item;

   public Key(@NotNull Crate var1, @NotNull AquaticItem var2) {
      Intrinsics.checkNotNullParameter(var1, "crate");
      Intrinsics.checkNotNullParameter(var2, "item");
      super();
      this.crate = var1;
      this.item = var2;
      Function1 var3 = Key::_init_$lambda$0;
      if (!ItemRegistryKt.register(this.item, "aquaticcrates-key", this.crate.getIdentifier(), var3)) {
         ItemRegistryKt.setInteractionHandler(this.item, var3);
      }

   }

   @NotNull
   public final Crate getCrate() {
      return this.crate;
   }

   @NotNull
   public final AquaticItem getItem() {
      return this.item;
   }

   public abstract boolean getMustBeHeld();

   @NotNull
   public abstract KeyInteractHandler getInteractHandler();

   public void giveItem(int var1, @NotNull Player... var2) {
      ItemBased.DefaultImpls.giveItem(this, var1, var2);
   }

   @NotNull
   public ItemStack getItem(int var1) {
      return ItemBased.DefaultImpls.getItem(this, var1);
   }

   private static final Unit _init_$lambda$0(Key var0, AquaticItemInteractEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      Event var2 = var1.getOriginalEvent();
      Location var5;
      if (var2 instanceof PlayerInteractEvent) {
         label21: {
            Block var10000 = ((PlayerInteractEvent)var2).getClickedBlock();
            if (var10000 != null) {
               var5 = var10000.getLocation();
               if (var5 != null) {
                  break label21;
               }
            }

            var5 = ((PlayerInteractEvent)var2).getPlayer().getLocation();
            Intrinsics.checkNotNullExpressionValue(var5, "getLocation(...)");
         }
      } else {
         var5 = var1.getPlayer().getLocation();
         Intrinsics.checkNotNullExpressionValue(var5, "getLocation(...)");
      }

      Location var3 = var5;
      boolean var4 = var0.getInteractHandler().handleInteract(var1.getPlayer(), var1.getInteractType(), var3, (SpawnedCrate)null);
      if (!(var2 instanceof InventoryClickEvent) || var4) {
         var1.setCancelled(true);
      }

      return Unit.INSTANCE;
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t¨\u0006\n"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/crate/Key$Companion;", "", "<init>", "()V", "get", "Lgg/aquatic/aquaticcrates/api/crate/Key;", "id", "", "itemStack", "Lorg/bukkit/inventory/ItemStack;", "api"}
   )
   public static final class Companion {
      private Companion() {
      }

      @Nullable
      public final Key get(@NotNull String var1) {
         Intrinsics.checkNotNullParameter(var1, "id");
         Object var3 = CrateHandler.INSTANCE.getCrates().get(var1);
         OpenableCrate var10000 = var3 instanceof OpenableCrate ? (OpenableCrate)var3 : null;
         if ((var3 instanceof OpenableCrate ? (OpenableCrate)var3 : null) == null) {
            return null;
         } else {
            OpenableCrate var2 = var10000;
            return var2.getKey();
         }
      }

      @Nullable
      public final Key get(@NotNull ItemStack var1) {
         Intrinsics.checkNotNullParameter(var1, "itemStack");
         ItemMeta var10000 = var1.getItemMeta();
         if (var10000 == null) {
            return null;
         } else {
            ItemMeta var2 = var10000;
            String var6 = (String)var2.getPersistentDataContainer().get(ItemHandler.INSTANCE.getNAMESPACE_KEY(), PersistentDataType.STRING);
            if (var6 == null) {
               return null;
            } else {
               String var3 = var6;
               String var4 = StringsKt.substringAfter$default(var3, ":", (String)null, 2, (Object)null);
               String var5 = StringsKt.substringBefore$default(var3, ":", (String)null, 2, (Object)null);
               return !StringsKt.equals(var5, "aquaticcrates-key", true) ? null : this.get(var4);
            }
         }
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
