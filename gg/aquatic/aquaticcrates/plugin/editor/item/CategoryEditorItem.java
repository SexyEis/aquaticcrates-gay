package gg.aquatic.aquaticcrates.plugin.editor.item;

import gg.aquatic.aquaticcrates.plugin.editor.EditorCategory;
import gg.aquatic.aquaticcrates.plugin.editor.menu.EditorMenu;
import gg.aquatic.waves.inventory.PacketInventory;
import gg.aquatic.waves.inventory.event.AsyncPacketInventoryInteractEvent;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.menu.component.Button;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/item/CategoryEditorItem;", "Lgg/aquatic/aquaticcrates/plugin/editor/item/EditorItem;", "category", "Lgg/aquatic/aquaticcrates/plugin/editor/EditorCategory;", "<init>", "(Lgg/aquatic/aquaticcrates/plugin/editor/EditorCategory;)V", "getCategory", "()Lgg/aquatic/aquaticcrates/plugin/editor/EditorCategory;", "itemStack", "Lorg/bukkit/inventory/ItemStack;", "getItemStack", "()Lorg/bukkit/inventory/ItemStack;", "execute", "", "event", "Lgg/aquatic/waves/inventory/event/AsyncPacketInventoryInteractEvent;", "plugin"}
)
public final class CategoryEditorItem implements EditorItem {
   @NotNull
   private final EditorCategory category;
   @NotNull
   private final ItemStack itemStack;

   public CategoryEditorItem(@NotNull EditorCategory var1) {
      Intrinsics.checkNotNullParameter(var1, "category");
      super();
      this.category = var1;
      this.itemStack = this.category.getItem();
   }

   @NotNull
   public final EditorCategory getCategory() {
      return this.category;
   }

   @NotNull
   public ItemStack getItemStack() {
      return this.itemStack;
   }

   public void execute(@NotNull AsyncPacketInventoryInteractEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "event");
      PacketInventory var10000 = var1.getInventory();
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type gg.aquatic.aquaticcrates.plugin.editor.menu.EditorMenu");
      EditorMenu var2 = (EditorMenu)var10000;
      EditorMenu var3 = new EditorMenu(var2.getCrateModel(), var1.getViewer().getPlayer(), this.category, var2);
      var3.open();
   }

   @NotNull
   public Button createButton(@NotNull String var1, int var2, @NotNull Function2<? super String, ? super EditorMenu, String> var3) {
      return EditorItem.DefaultImpls.createButton(this, var1, var2, var3);
   }
}
