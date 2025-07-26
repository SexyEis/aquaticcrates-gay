package gg.aquatic.aquaticcrates.plugin.editor;

import gg.aquatic.aquaticcrates.plugin.editor.item.EditorItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.ArrayList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0000H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R9\u0010\b\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\tj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/EditorCategory;", "", "item", "Lorg/bukkit/inventory/ItemStack;", "<init>", "(Lorg/bukkit/inventory/ItemStack;)V", "getItem", "()Lorg/bukkit/inventory/ItemStack;", "items", "Ljava/util/ArrayList;", "Lgg/aquatic/waves/libs/kotlin/Pair;", "", "Lgg/aquatic/aquaticcrates/plugin/editor/item/EditorItem;", "Lgg/aquatic/waves/libs/kotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "refresh", "plugin"}
)
public abstract class EditorCategory {
   @NotNull
   private final ItemStack item;
   @NotNull
   private final ArrayList<Pair<String, EditorItem>> items;

   public EditorCategory(@NotNull ItemStack var1) {
      Intrinsics.checkNotNullParameter(var1, "item");
      super();
      this.item = var1;
      this.items = new ArrayList();
   }

   @NotNull
   public final ItemStack getItem() {
      return this.item;
   }

   @NotNull
   public final ArrayList<Pair<String, EditorItem>> getItems() {
      return this.items;
   }

   @NotNull
   public abstract EditorCategory refresh();
}
