package gg.aquatic.aquaticcrates.plugin.editor.category.item;

import gg.aquatic.aquaticcrates.api.util.ItemBuilder;
import gg.aquatic.aquaticcrates.plugin.editor.EditorCategory;
import gg.aquatic.aquaticcrates.plugin.editor.category.collection.CollectionEditorCategory;
import gg.aquatic.aquaticcrates.plugin.editor.data.ItemModel;
import gg.aquatic.aquaticcrates.plugin.editor.item.CategoryEditorItem;
import gg.aquatic.aquaticcrates.plugin.editor.item.EditorItem;
import gg.aquatic.aquaticcrates.plugin.editor.item.InputEditorItem;
import gg.aquatic.waves.input.InputHandle;
import gg.aquatic.waves.input.impl.ChatInput;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import java.util.Collection;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0001H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/category/item/ItemEditorCategory;", "Lgg/aquatic/aquaticcrates/plugin/editor/EditorCategory;", "itemModel", "Lgg/aquatic/aquaticcrates/plugin/editor/data/ItemModel;", "<init>", "(Lgg/aquatic/aquaticcrates/plugin/editor/data/ItemModel;)V", "getItemModel", "()Lgg/aquatic/aquaticcrates/plugin/editor/data/ItemModel;", "refresh", "plugin"}
)
@SourceDebugExtension({"SMAP\nItemEditorCategory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemEditorCategory.kt\ngg/aquatic/aquaticcrates/plugin/editor/category/item/ItemEditorCategory\n+ 2 ItemBuilder.kt\ngg/aquatic/aquaticcrates/api/util/ItemBuilderKt\n*L\n1#1,120:1\n32#2:121\n32#2:122\n32#2:123\n32#2:124\n32#2:125\n*S KotlinDebug\n*F\n+ 1 ItemEditorCategory.kt\ngg/aquatic/aquaticcrates/plugin/editor/category/item/ItemEditorCategory\n*L\n31#1:121\n46#1:122\n78#1:123\n99#1:124\n57#1:125\n*E\n"})
public final class ItemEditorCategory extends EditorCategory {
   @NotNull
   private final ItemModel itemModel;

   public ItemEditorCategory(@NotNull ItemModel var1) {
      Intrinsics.checkNotNullParameter(var1, "itemModel");
      super(var1.getAquaticItem().getItem());
      this.itemModel = var1;
      Collection var2 = (Collection)this.getItems();
      ItemStack var10003 = this.itemModel.getAquaticItem().getItem();
      InputHandle var10004 = ChatInput.INSTANCE.createHandle(CollectionsKt.listOf("cancel"));
      Function1 var10005 = ItemEditorCategory::_init_$lambda$0;
      String[] var3 = new String[]{"Enter the Material for the Item...", "Type 'cancel' to cancel the input!"};
      var2.add(TuplesKt.to("material", new InputEditorItem(var10003, var10004, var10005, (Collection)CollectionsKt.listOf(var3), (Function1)null, 16, (DefaultConstructorMarker)null)));
      var2 = (Collection)this.getItems();
      Material var38 = Material.NAME_TAG;
      boolean var4 = false;
      ItemBuilder var5 = new ItemBuilder(var38);
      String var9 = "display-name";
      boolean var7 = false;
      var5.setDisplayName("Display Name");
      ItemStack var10001 = var5.build();
      InputHandle var10002 = ChatInput.INSTANCE.createHandle(CollectionsKt.listOf("cancel"));
      Function1 var40 = ItemEditorCategory::_init_$lambda$2;
      var3 = new String[]{"Enter the Display Name for the Item...", "Type 'cancel' to cancel the input!"};
      Collection var43 = (Collection)CollectionsKt.listOf(var3);
      Object var14 = null;
      byte var15 = 16;
      Object var16 = null;
      Collection var17 = var43;
      Function1 var18 = var40;
      InputHandle var19 = var10002;
      ItemStack var20 = var10001;
      var2.add(TuplesKt.to(var9, new InputEditorItem(var20, var19, var18, var17, (Function1)var16, var15, (DefaultConstructorMarker)var14)));
      var2 = (Collection)this.getItems();
      var38 = Material.BOOK;
      var4 = false;
      var5 = new ItemBuilder(var38);
      var9 = "lore";
      var7 = false;
      var5.setDisplayName("Lore");
      String[] var8 = new String[]{"The lore of the item", null};
      Iterable var41 = (Iterable)this.itemModel.getLore();
      var8[1] = "Current lore: " + CollectionsKt.joinToString$default(var41, (CharSequence)"\n", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null);
      var5.setLore(CollectionsKt.listOf(var8));
      var10001 = var5.build();
      List var39 = this.itemModel.getLore();
      Function2 var42 = ItemEditorCategory::_init_$lambda$6;
      var38 = Material.EMERALD;
      var4 = false;
      var5 = new ItemBuilder(var38);
      Function2 var12 = var42;
      List var11 = var39;
      ItemStack var10 = var10001;
      var7 = false;
      var5.setDisplayName("Add Line");
      var8 = new String[]{"", "[Left-Click] to add a new line!"};
      var5.setLore(CollectionsKt.listOf(var8));
      Unit var13 = Unit.INSTANCE;
      ItemStack var44 = var5.build();
      InputHandle var45 = ChatInput.INSTANCE.createHandle(CollectionsKt.listOf("cancel"));
      Function1 var10006 = ItemEditorCategory::_init_$lambda$8;
      var3 = new String[]{"Enter the Lore Line for the Item...", "Type 'cancel' to cancel the input!"};
      Collection var10007 = (Collection)CollectionsKt.listOf(var3);
      Object var21 = null;
      byte var22 = 16;
      Object var23 = null;
      Collection var24 = var10007;
      Function1 var25 = var10006;
      InputHandle var26 = var45;
      ItemStack var27 = var44;
      EditorItem var28 = (EditorItem)(new InputEditorItem(var27, var26, var25, var24, (Function1)var23, var22, (DefaultConstructorMarker)var21));
      EditorCategory var32 = (EditorCategory)(new CollectionEditorCategory(var10, var11, var12, var28));
      var2.add(TuplesKt.to(var9, new CategoryEditorItem(var32)));
      var2 = (Collection)this.getItems();
      var38 = Material.MINECART;
      var4 = false;
      var5 = new ItemBuilder(var38);
      var9 = "amount";
      var7 = false;
      var5.setDisplayName("Amount");
      var8 = new String[]{"The amount of the item", "Current amount: " + this.itemModel.getAmount()};
      var5.setLore(CollectionsKt.listOf(var8));
      var10001 = var5.build();
      var10002 = ChatInput.INSTANCE.createHandle(CollectionsKt.listOf("cancel"));
      var40 = ItemEditorCategory::_init_$lambda$10;
      var3 = new String[]{"Enter the Amount for the Item...", "Type 'cancel' to cancel the input!"};
      var43 = (Collection)CollectionsKt.listOf(var3);
      Function1 var33 = ItemEditorCategory::_init_$lambda$11;
      Collection var34 = var43;
      Function1 var35 = var40;
      InputHandle var36 = var10002;
      ItemStack var37 = var10001;
      var2.add(TuplesKt.to(var9, new InputEditorItem(var37, var36, var35, var34, var33)));
   }

   @NotNull
   public final ItemModel getItemModel() {
      return this.itemModel;
   }

   @NotNull
   public EditorCategory refresh() {
      return (EditorCategory)(new ItemEditorCategory(this.itemModel));
   }

   private static final Unit _init_$lambda$0(ItemEditorCategory var0, String var1) {
      Intrinsics.checkNotNullParameter(var1, "str");
      var0.itemModel.setMaterial(var1);
      return Unit.INSTANCE;
   }

   private static final Unit _init_$lambda$2(ItemEditorCategory var0, String var1) {
      Intrinsics.checkNotNullParameter(var1, "str");
      var0.itemModel.setDisplayName(var1);
      return Unit.INSTANCE;
   }

   private static final Unit lambda$6$lambda$5(ItemEditorCategory var0, int var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "str");
      var0.itemModel.getLore().set(var1, var2);
      return Unit.INSTANCE;
   }

   private static final Pair _init_$lambda$6(ItemEditorCategory var0, int var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "line");
      String var10000 = String.valueOf(var1);
      Material var3 = Material.PAPER;
      boolean var4 = false;
      ItemBuilder var5 = new ItemBuilder(var3);
      String var9 = var10000;
      boolean var7 = false;
      var5.setDisplayName(var2);
      String[] var8 = new String[]{"Line: #" + var1, "", "<gray>[Left-Click] to change the line!", "<gray>[Shift-Right-Click] to remove the line!"};
      var5.setLore(CollectionsKt.listOf(var8));
      Unit var11 = Unit.INSTANCE;
      ItemStack var10002 = var5.build();
      InputHandle var10003 = ChatInput.INSTANCE.createHandle(CollectionsKt.listOf("cancel"));
      Function1 var10004 = ItemEditorCategory::lambda$6$lambda$5;
      String[] var21 = new String[]{"Enter the Lore Line #" + var1 + " for the Item...", "Type 'cancel' to cancel the input!"};
      Collection var10005 = (Collection)CollectionsKt.listOf(var21);
      Object var12 = null;
      byte var13 = 16;
      Object var14 = null;
      Collection var15 = var10005;
      Function1 var16 = var10004;
      InputHandle var17 = var10003;
      ItemStack var18 = var10002;
      EditorItem var19 = (EditorItem)(new InputEditorItem(var18, var17, var16, var15, (Function1)var14, var13, (DefaultConstructorMarker)var12));
      return TuplesKt.to(var9, new CollectionEditorCategory.CollectionEditorItem(var1, var19));
   }

   private static final Unit _init_$lambda$8(ItemEditorCategory var0, String var1) {
      Intrinsics.checkNotNullParameter(var1, "str");
      List var2 = var0.itemModel.getLore();
      var2.add(var1);
      var0.itemModel.setLore(var2);
      return Unit.INSTANCE;
   }

   private static final Unit _init_$lambda$10(ItemEditorCategory var0, String var1) {
      Intrinsics.checkNotNullParameter(var1, "str");
      ItemModel var10000 = var0.itemModel;
      Integer var10001 = StringsKt.toIntOrNull(var1);
      var10000.setAmount(var10001 != null ? var10001 : 1);
      return Unit.INSTANCE;
   }

   private static final boolean _init_$lambda$11(String var0) {
      Intrinsics.checkNotNullParameter(var0, "str");
      return StringsKt.toIntOrNull(var0) != null && Integer.parseInt(var0) > 0;
   }
}
