package gg.aquatic.aquaticcrates.plugin.editor.category.collection;

import gg.aquatic.aquaticcrates.plugin.editor.EditorCategory;
import gg.aquatic.aquaticcrates.plugin.editor.item.EditorItem;
import gg.aquatic.aquaticcrates.plugin.editor.menu.EditorMenu;
import gg.aquatic.waves.inventory.ButtonType;
import gg.aquatic.waves.inventory.PacketInventory;
import gg.aquatic.waves.inventory.event.AsyncPacketInventoryInteractEvent;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.menu.component.Button;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0017BK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012$\u0010\u0007\u001a \u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\b\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0016\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R/\u0010\u0007\u001a \u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/category/collection/CollectionEditorCategory;", "T", "Lgg/aquatic/aquaticcrates/plugin/editor/EditorCategory;", "itemStack", "Lorg/bukkit/inventory/ItemStack;", "collection", "", "itemMapper", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "Lgg/aquatic/waves/libs/kotlin/Pair;", "", "Lgg/aquatic/aquaticcrates/plugin/editor/item/EditorItem;", "addItem", "<init>", "(Lorg/bukkit/inventory/ItemStack;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lgg/aquatic/aquaticcrates/plugin/editor/item/EditorItem;)V", "getCollection", "()Ljava/util/List;", "getItemMapper", "()Lkotlin/jvm/functions/Function2;", "getAddItem", "()Lgg/aquatic/aquaticcrates/plugin/editor/item/EditorItem;", "refresh", "CollectionEditorItem", "plugin"}
)
@SourceDebugExtension({"SMAP\nCollectionEditorCategory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionEditorCategory.kt\ngg/aquatic/aquaticcrates/plugin/editor/category/collection/CollectionEditorCategory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n1573#2:53\n1604#2,4:54\n*S KotlinDebug\n*F\n+ 1 CollectionEditorCategory.kt\ngg/aquatic/aquaticcrates/plugin/editor/category/collection/CollectionEditorCategory\n*L\n22#1:53\n22#1:54,4\n*E\n"})
public final class CollectionEditorCategory<T> extends EditorCategory {
   @NotNull
   private final List<T> collection;
   @NotNull
   private final Function2<Integer, T, Pair<String, EditorItem>> itemMapper;
   @NotNull
   private final EditorItem addItem;

   public CollectionEditorCategory(@NotNull ItemStack var1, @NotNull List<T> var2, @NotNull Function2<? super Integer, ? super T, ? extends Pair<String, ? extends EditorItem>> var3, @NotNull EditorItem var4) {
      Intrinsics.checkNotNullParameter(var1, "itemStack");
      Intrinsics.checkNotNullParameter(var2, "collection");
      Intrinsics.checkNotNullParameter(var3, "itemMapper");
      Intrinsics.checkNotNullParameter(var4, "addItem");
      super(var1);
      this.collection = var2;
      this.itemMapper = var3;
      this.addItem = var4;
      Collection var5 = (Collection)this.getItems();
      Iterable var6 = (Iterable)this.collection;
      boolean var7 = false;
      Collection var9 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var6, 10)));
      boolean var10 = false;
      int var11 = 0;
      Iterator var12 = var6.iterator();

      while(var12.hasNext()) {
         Object var13 = var12.next();
         int var14 = var11++;
         if (var14 < 0) {
            CollectionsKt.throwIndexOverflow();
         }

         boolean var17 = false;
         var9.add((Pair)this.itemMapper.invoke(var14, var13));
      }

      var6 = (Iterable)((List)var9);
      CollectionsKt.addAll(var5, var6);
      ((Collection)this.getItems()).add(TuplesKt.to("add", this.addItem));
   }

   @NotNull
   public final List<T> getCollection() {
      return this.collection;
   }

   @NotNull
   public final Function2<Integer, T, Pair<String, EditorItem>> getItemMapper() {
      return this.itemMapper;
   }

   @NotNull
   public final EditorItem getAddItem() {
      return this.addItem;
   }

   @NotNull
   public EditorCategory refresh() {
      return (EditorCategory)(new CollectionEditorCategory(this.getItem(), this.collection, this.itemMapper, this.addItem));
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/category/collection/CollectionEditorCategory$CollectionEditorItem;", "Lgg/aquatic/aquaticcrates/plugin/editor/item/EditorItem;", "index", "", "editorItem", "<init>", "(ILgg/aquatic/aquaticcrates/plugin/editor/item/EditorItem;)V", "getIndex", "()I", "getEditorItem", "()Lgg/aquatic/aquaticcrates/plugin/editor/item/EditorItem;", "itemStack", "Lorg/bukkit/inventory/ItemStack;", "getItemStack", "()Lorg/bukkit/inventory/ItemStack;", "execute", "", "event", "Lgg/aquatic/waves/inventory/event/AsyncPacketInventoryInteractEvent;", "plugin"}
   )
   public static final class CollectionEditorItem implements EditorItem {
      private final int index;
      @NotNull
      private final EditorItem editorItem;

      public CollectionEditorItem(int var1, @NotNull EditorItem var2) {
         Intrinsics.checkNotNullParameter(var2, "editorItem");
         super();
         this.index = var1;
         this.editorItem = var2;
      }

      public final int getIndex() {
         return this.index;
      }

      @NotNull
      public final EditorItem getEditorItem() {
         return this.editorItem;
      }

      @NotNull
      public ItemStack getItemStack() {
         return this.editorItem.getItemStack();
      }

      public void execute(@NotNull AsyncPacketInventoryInteractEvent var1) {
         Intrinsics.checkNotNullParameter(var1, "event");
         Player var10000 = var1.getViewer().getPlayer();
         int var10001 = this.index;
         var10000.sendMessage("Clicked " + var10001 + ", btn type: " + var1.getButtonType());
         if (var1.getButtonType() == ButtonType.SHIFT_RIGHT) {
            Player var2 = var1.getViewer().getPlayer();
            PacketInventory var6 = var1.getInventory();
            Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type gg.aquatic.aquaticcrates.plugin.editor.menu.EditorMenu");
            EditorMenu var3 = (EditorMenu)var6;
            EditorCategory var7 = var3.getCategory();
            Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type gg.aquatic.aquaticcrates.plugin.editor.category.collection.CollectionEditorCategory<*>");
            CollectionEditorCategory var4 = (CollectionEditorCategory)var7;
            var4.getCollection().remove(this.index);
            EditorMenu var5 = new EditorMenu(var3.getCrateModel(), var2, var4.refresh(), var3.getPreviousMenu());
            var5.open();
         } else {
            this.editorItem.execute(var1);
         }

      }

      @NotNull
      public Button createButton(@NotNull String var1, int var2, @NotNull Function2<? super String, ? super EditorMenu, String> var3) {
         return EditorItem.DefaultImpls.createButton(this, var1, var2, var3);
      }
   }
}
