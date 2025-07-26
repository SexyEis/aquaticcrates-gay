package gg.aquatic.aquaticcrates.plugin.editor.category.key;

import gg.aquatic.aquaticcrates.plugin.editor.EditorCategory;
import gg.aquatic.aquaticcrates.plugin.editor.category.item.ItemEditorCategory;
import gg.aquatic.aquaticcrates.plugin.editor.data.CrateModel;
import gg.aquatic.aquaticcrates.plugin.editor.item.CategoryEditorItem;
import gg.aquatic.aquaticcrates.plugin.editor.item.ToggleEditorItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0001H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/category/key/KeyEditorCategory;", "Lgg/aquatic/aquaticcrates/plugin/editor/EditorCategory;", "crateModel", "Lgg/aquatic/aquaticcrates/plugin/editor/data/CrateModel;", "<init>", "(Lgg/aquatic/aquaticcrates/plugin/editor/data/CrateModel;)V", "getCrateModel", "()Lgg/aquatic/aquaticcrates/plugin/editor/data/CrateModel;", "refresh", "plugin"}
)
public final class KeyEditorCategory extends EditorCategory {
   @NotNull
   private final CrateModel crateModel;

   public KeyEditorCategory(@NotNull CrateModel var1) {
      Intrinsics.checkNotNullParameter(var1, "crateModel");
      super(var1.getKey().getItem().getAquaticItem().getItem());
      this.crateModel = var1;
      ((Collection)this.getItems()).add(TuplesKt.to("item", new CategoryEditorItem((EditorCategory)(new ItemEditorCategory(this.crateModel.getKey().getItem())))));
      ((Collection)this.getItems()).add(TuplesKt.to("must-be-held", new ToggleEditorItem(this.crateModel.getKey().getMustBeHeld(), "Must be Held", CollectionsKt.listOf("If the key must be held in hand in order to open the crate"), KeyEditorCategory::_init_$lambda$0)));
   }

   @NotNull
   public final CrateModel getCrateModel() {
      return this.crateModel;
   }

   @NotNull
   public EditorCategory refresh() {
      return (EditorCategory)(new KeyEditorCategory(this.crateModel));
   }

   private static final Unit _init_$lambda$0(KeyEditorCategory var0, boolean var1) {
      var0.crateModel.getKey().setMustBeHeld(var1);
      return Unit.INSTANCE;
   }
}
