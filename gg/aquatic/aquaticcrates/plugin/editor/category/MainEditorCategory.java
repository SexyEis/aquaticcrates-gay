package gg.aquatic.aquaticcrates.plugin.editor.category;

import gg.aquatic.aquaticcrates.api.util.ItemBuilder;
import gg.aquatic.aquaticcrates.plugin.editor.EditorCategory;
import gg.aquatic.aquaticcrates.plugin.editor.category.key.KeyEditorCategory;
import gg.aquatic.aquaticcrates.plugin.editor.data.CrateModel;
import gg.aquatic.aquaticcrates.plugin.editor.item.CategoryEditorItem;
import gg.aquatic.aquaticcrates.plugin.editor.item.InputEditorItem;
import gg.aquatic.waves.input.InputHandle;
import gg.aquatic.waves.input.impl.ChatInput;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.Collection;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0001H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/category/MainEditorCategory;", "Lgg/aquatic/aquaticcrates/plugin/editor/EditorCategory;", "crateModel", "Lgg/aquatic/aquaticcrates/plugin/editor/data/CrateModel;", "<init>", "(Lgg/aquatic/aquaticcrates/plugin/editor/data/CrateModel;)V", "getCrateModel", "()Lgg/aquatic/aquaticcrates/plugin/editor/data/CrateModel;", "refresh", "plugin"}
)
@SourceDebugExtension({"SMAP\nMainEditorCategory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainEditorCategory.kt\ngg/aquatic/aquaticcrates/plugin/editor/category/MainEditorCategory\n+ 2 ItemBuilder.kt\ngg/aquatic/aquaticcrates/api/util/ItemBuilderKt\n*L\n1#1,43:1\n32#2:44\n*S KotlinDebug\n*F\n+ 1 MainEditorCategory.kt\ngg/aquatic/aquaticcrates/plugin/editor/category/MainEditorCategory\n*L\n26#1:44\n*E\n"})
public final class MainEditorCategory extends EditorCategory {
   @NotNull
   private final CrateModel crateModel;

   public MainEditorCategory(@NotNull CrateModel var1) {
      Intrinsics.checkNotNullParameter(var1, "crateModel");
      ItemStack var10001 = ItemStack.of(Material.STONE);
      Intrinsics.checkNotNullExpressionValue(var10001, "of(...)");
      super(var10001);
      this.crateModel = var1;
      KeyEditorCategory var2 = new KeyEditorCategory(this.crateModel);
      ((Collection)this.getItems()).add(TuplesKt.to("key", new CategoryEditorItem((EditorCategory)var2)));
      Collection var3 = (Collection)this.getItems();
      Material var4 = Material.NAME_TAG;
      boolean var5 = false;
      ItemBuilder var6 = new ItemBuilder(var4);
      String var10 = "display-name";
      boolean var8 = false;
      var6.setDisplayName("Crate Display Name");
      String[] var9 = new String[]{"The display name of crate", "Current display name: " + this.crateModel.getDisplayName()};
      var6.setLore(CollectionsKt.listOf(var9));
      var10001 = var6.build();
      InputHandle var10002 = ChatInput.INSTANCE.createHandle(CollectionsKt.listOf("cancel"));
      Function1 var10003 = MainEditorCategory::_init_$lambda$1;
      String[] var18 = new String[]{"Enter the Display Name for the Crate...", "Type 'cancel' to cancel the input!"};
      Collection var10004 = (Collection)CollectionsKt.listOf(var18);
      Object var11 = null;
      byte var12 = 16;
      Object var13 = null;
      Collection var14 = var10004;
      Function1 var15 = var10003;
      InputHandle var16 = var10002;
      ItemStack var17 = var10001;
      var3.add(TuplesKt.to(var10, new InputEditorItem(var17, var16, var15, var14, (Function1)var13, var12, (DefaultConstructorMarker)var11)));
   }

   @NotNull
   public final CrateModel getCrateModel() {
      return this.crateModel;
   }

   @NotNull
   public EditorCategory refresh() {
      return (EditorCategory)(new MainEditorCategory(this.crateModel));
   }

   private static final Unit _init_$lambda$1(MainEditorCategory var0, String var1) {
      Intrinsics.checkNotNullParameter(var1, "str");
      var0.crateModel.setDisplayName(var1);
      return Unit.INSTANCE;
   }
}
