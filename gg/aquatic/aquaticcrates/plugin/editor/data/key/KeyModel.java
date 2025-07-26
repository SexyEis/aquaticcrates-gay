package gg.aquatic.aquaticcrates.plugin.editor.data.key;

import gg.aquatic.aquaticcrates.plugin.crate.BasicCrate;
import gg.aquatic.aquaticcrates.plugin.editor.data.ItemModel;
import gg.aquatic.aquaticcrates.plugin.editor.data.interact.CrateInteractActionModel;
import gg.aquatic.waves.item.AquaticItemInteractEvent.InteractType;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J%\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003JC\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R6\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/data/key/KeyModel;", "", "item", "Lgg/aquatic/aquaticcrates/plugin/editor/data/ItemModel;", "mustBeHeld", "", "clickActions", "Ljava/util/HashMap;", "Lgg/aquatic/waves/item/AquaticItemInteractEvent$InteractType;", "Lgg/aquatic/aquaticcrates/plugin/editor/data/interact/CrateInteractActionModel;", "Lgg/aquatic/waves/libs/kotlin/collections/HashMap;", "<init>", "(Lgg/aquatic/aquaticcrates/plugin/editor/data/ItemModel;ZLjava/util/HashMap;)V", "getItem", "()Lgg/aquatic/aquaticcrates/plugin/editor/data/ItemModel;", "setItem", "(Lgg/aquatic/aquaticcrates/plugin/editor/data/ItemModel;)V", "getMustBeHeld", "()Z", "setMustBeHeld", "(Z)V", "getClickActions", "()Ljava/util/HashMap;", "setClickActions", "(Ljava/util/HashMap;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "plugin"}
)
public final class KeyModel {
   @NotNull
   public static final KeyModel.Companion Companion = new KeyModel.Companion((DefaultConstructorMarker)null);
   @NotNull
   private ItemModel item;
   private boolean mustBeHeld;
   @NotNull
   private HashMap<InteractType, CrateInteractActionModel> clickActions;

   public KeyModel(@NotNull ItemModel var1, boolean var2, @NotNull HashMap<InteractType, CrateInteractActionModel> var3) {
      Intrinsics.checkNotNullParameter(var1, "item");
      Intrinsics.checkNotNullParameter(var3, "clickActions");
      super();
      this.item = var1;
      this.mustBeHeld = var2;
      this.clickActions = var3;
   }

   @NotNull
   public final ItemModel getItem() {
      return this.item;
   }

   public final void setItem(@NotNull ItemModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.item = var1;
   }

   public final boolean getMustBeHeld() {
      return this.mustBeHeld;
   }

   public final void setMustBeHeld(boolean var1) {
      this.mustBeHeld = var1;
   }

   @NotNull
   public final HashMap<InteractType, CrateInteractActionModel> getClickActions() {
      return this.clickActions;
   }

   public final void setClickActions(@NotNull HashMap<InteractType, CrateInteractActionModel> var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.clickActions = var1;
   }

   @NotNull
   public final ItemModel component1() {
      return this.item;
   }

   public final boolean component2() {
      return this.mustBeHeld;
   }

   @NotNull
   public final HashMap<InteractType, CrateInteractActionModel> component3() {
      return this.clickActions;
   }

   @NotNull
   public final KeyModel copy(@NotNull ItemModel var1, boolean var2, @NotNull HashMap<InteractType, CrateInteractActionModel> var3) {
      Intrinsics.checkNotNullParameter(var1, "item");
      Intrinsics.checkNotNullParameter(var3, "clickActions");
      return new KeyModel(var1, var2, var3);
   }

   // $FF: synthetic method
   public static KeyModel copy$default(KeyModel var0, ItemModel var1, boolean var2, HashMap var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.item;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.mustBeHeld;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.clickActions;
      }

      return var0.copy(var1, var2, var3);
   }

   @NotNull
   public String toString() {
      return "KeyModel(item=" + this.item + ", mustBeHeld=" + this.mustBeHeld + ", clickActions=" + this.clickActions + ")";
   }

   public int hashCode() {
      int var1 = this.item.hashCode();
      var1 = var1 * 31 + Boolean.hashCode(this.mustBeHeld);
      var1 = var1 * 31 + this.clickActions.hashCode();
      return var1;
   }

   public boolean equals(@Nullable Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof KeyModel)) {
         return false;
      } else {
         KeyModel var2 = (KeyModel)var1;
         if (!Intrinsics.areEqual(this.item, var2.item)) {
            return false;
         } else if (this.mustBeHeld != var2.mustBeHeld) {
            return false;
         } else {
            return Intrinsics.areEqual(this.clickActions, var2.clickActions);
         }
      }
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/data/key/KeyModel$Companion;", "", "<init>", "()V", "of", "Lgg/aquatic/aquaticcrates/plugin/editor/data/key/KeyModel;", "crate", "Lgg/aquatic/aquaticcrates/plugin/crate/BasicCrate;", "plugin"}
   )
   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final KeyModel of(@NotNull BasicCrate var1) {
         Intrinsics.checkNotNullParameter(var1, "crate");
         return new KeyModel(ItemModel.Companion.of(var1.getKey().getItem()), var1.getKey().getMustBeHeld(), new HashMap());
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
