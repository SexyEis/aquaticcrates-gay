package gg.aquatic.aquaticcrates.plugin.editor.data;

import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.item.ItemHandler;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J9\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006("},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/data/ItemModel;", "", "material", "", "amount", "", "displayName", "lore", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;)V", "getMaterial", "()Ljava/lang/String;", "setMaterial", "(Ljava/lang/String;)V", "getAmount", "()I", "setAmount", "(I)V", "getDisplayName", "setDisplayName", "getLore", "()Ljava/util/List;", "setLore", "(Ljava/util/List;)V", "aquaticItem", "Lgg/aquatic/waves/item/AquaticItem;", "getAquaticItem", "()Lgg/aquatic/waves/item/AquaticItem;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "plugin"}
)
public final class ItemModel {
   @NotNull
   public static final ItemModel.Companion Companion = new ItemModel.Companion((DefaultConstructorMarker)null);
   @NotNull
   private String material;
   private int amount;
   @Nullable
   private String displayName;
   @NotNull
   private List<String> lore;

   public ItemModel(@NotNull String var1, int var2, @Nullable String var3, @NotNull List<String> var4) {
      Intrinsics.checkNotNullParameter(var1, "material");
      Intrinsics.checkNotNullParameter(var4, "lore");
      super();
      this.material = var1;
      this.amount = var2;
      this.displayName = var3;
      this.lore = var4;
   }

   // $FF: synthetic method
   public ItemModel(String var1, int var2, String var3, List var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 8) != 0) {
         var4 = (List)(new ArrayList());
      }

      this(var1, var2, var3, var4);
   }

   @NotNull
   public final String getMaterial() {
      return this.material;
   }

   public final void setMaterial(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.material = var1;
   }

   public final int getAmount() {
      return this.amount;
   }

   public final void setAmount(int var1) {
      this.amount = var1;
   }

   @Nullable
   public final String getDisplayName() {
      return this.displayName;
   }

   public final void setDisplayName(@Nullable String var1) {
      this.displayName = var1;
   }

   @NotNull
   public final List<String> getLore() {
      return this.lore;
   }

   public final void setLore(@NotNull List<String> var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.lore = var1;
   }

   @NotNull
   public final AquaticItem getAquaticItem() {
      String var3;
      if (StringsKt.contains$default((CharSequence)this.material, (CharSequence)":", false, 2, (Object)null)) {
         CharSequence var10000 = (CharSequence)this.material;
         String[] var2 = new String[]{":"};
         var3 = ((String)StringsKt.split$default(var10000, var2, false, 0, 6, (Object)null).get(0)).toUpperCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var3, "toUpperCase(...)");
      } else {
         var3 = null;
      }

      String var1 = var3;
      if (var1 == null) {
         ItemHandler var4 = ItemHandler.INSTANCE;
         String var10001 = this.material;
         String var10002 = this.material.toUpperCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var10002, "toUpperCase(...)");
         ItemStack var5 = ItemStack.of(Material.valueOf(var10002));
         Intrinsics.checkNotNullExpressionValue(var5, "of(...)");
         return ItemHandler.create$default(var4, var10001, var5, this.displayName, CollectionsKt.toMutableList((Collection)this.lore), this.amount, 0, (String)null, (Map)null, (List)null, (EntityType)null, 992, (Object)null);
      } else {
         throw new Exception("Invalid item type " + var1);
      }
   }

   @NotNull
   public final String component1() {
      return this.material;
   }

   public final int component2() {
      return this.amount;
   }

   @Nullable
   public final String component3() {
      return this.displayName;
   }

   @NotNull
   public final List<String> component4() {
      return this.lore;
   }

   @NotNull
   public final ItemModel copy(@NotNull String var1, int var2, @Nullable String var3, @NotNull List<String> var4) {
      Intrinsics.checkNotNullParameter(var1, "material");
      Intrinsics.checkNotNullParameter(var4, "lore");
      return new ItemModel(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static ItemModel copy$default(ItemModel var0, String var1, int var2, String var3, List var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.material;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.amount;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.displayName;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.lore;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   @NotNull
   public String toString() {
      return "ItemModel(material=" + this.material + ", amount=" + this.amount + ", displayName=" + this.displayName + ", lore=" + this.lore + ")";
   }

   public int hashCode() {
      int var1 = this.material.hashCode();
      var1 = var1 * 31 + Integer.hashCode(this.amount);
      var1 = var1 * 31 + (this.displayName == null ? 0 : this.displayName.hashCode());
      var1 = var1 * 31 + this.lore.hashCode();
      return var1;
   }

   public boolean equals(@Nullable Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ItemModel)) {
         return false;
      } else {
         ItemModel var2 = (ItemModel)var1;
         if (!Intrinsics.areEqual(this.material, var2.material)) {
            return false;
         } else if (this.amount != var2.amount) {
            return false;
         } else if (!Intrinsics.areEqual(this.displayName, var2.displayName)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.lore, var2.lore);
         }
      }
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/data/ItemModel$Companion;", "", "<init>", "()V", "of", "Lgg/aquatic/aquaticcrates/plugin/editor/data/ItemModel;", "aquaticItem", "Lgg/aquatic/waves/item/AquaticItem;", "plugin"}
   )
   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final ItemModel of(@NotNull AquaticItem var1) {
         Intrinsics.checkNotNullParameter(var1, "aquaticItem");
         ItemModel var10000 = new ItemModel;
         String var10002 = var1.getInternalId();
         Intrinsics.checkNotNull(var10002);
         int var10003 = var1.getAmount();
         String var10004 = var1.getName();
         List var10005 = var1.getDescription();
         if (var10005 == null) {
            var10005 = (List)(new ArrayList());
         }

         var10000.<init>(var10002, var10003, var10004, var10005);
         return var10000;
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
