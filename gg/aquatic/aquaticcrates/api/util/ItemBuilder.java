package gg.aquatic.aquaticcrates.api.util;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.StringExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010 \u001a\u00020!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""},
   d2 = {"Lgg/aquatic/aquaticcrates/api/util/ItemBuilder;", "", "material", "Lorg/bukkit/Material;", "<init>", "(Lorg/bukkit/Material;)V", "getMaterial", "()Lorg/bukkit/Material;", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "lore", "", "getLore", "()Ljava/util/List;", "setLore", "(Ljava/util/List;)V", "amount", "", "getAmount", "()I", "setAmount", "(I)V", "customModelData", "getCustomModelData", "()Ljava/lang/Integer;", "setCustomModelData", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "build", "Lorg/bukkit/inventory/ItemStack;", "api"}
)
@SourceDebugExtension({"SMAP\nItemBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemBuilder.kt\ngg/aquatic/aquaticcrates/api/util/ItemBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,34:1\n1563#2:35\n1634#2,3:36\n*S KotlinDebug\n*F\n+ 1 ItemBuilder.kt\ngg/aquatic/aquaticcrates/api/util/ItemBuilder\n*L\n22#1:35\n22#1:36,3\n*E\n"})
public final class ItemBuilder {
   @NotNull
   private final Material material;
   @Nullable
   private String displayName;
   @Nullable
   private List<String> lore;
   private int amount;
   @Nullable
   private Integer customModelData;

   public ItemBuilder(@NotNull Material var1) {
      Intrinsics.checkNotNullParameter(var1, "material");
      super();
      this.material = var1;
      this.amount = 1;
   }

   @NotNull
   public final Material getMaterial() {
      return this.material;
   }

   @Nullable
   public final String getDisplayName() {
      return this.displayName;
   }

   public final void setDisplayName(@Nullable String var1) {
      this.displayName = var1;
   }

   @Nullable
   public final List<String> getLore() {
      return this.lore;
   }

   public final void setLore(@Nullable List<String> var1) {
      this.lore = var1;
   }

   public final int getAmount() {
      return this.amount;
   }

   public final void setAmount(int var1) {
      this.amount = var1;
   }

   @Nullable
   public final Integer getCustomModelData() {
      return this.customModelData;
   }

   public final void setCustomModelData(@Nullable Integer var1) {
      this.customModelData = var1;
   }

   @NotNull
   public final ItemStack build() {
      ItemStack var1 = new ItemStack(this.material, this.amount);
      ItemMeta var2 = var1.getItemMeta();
      String var10000 = this.displayName;
      boolean var5;
      if (var10000 != null) {
         Component var15 = StringExtKt.toMMComponent(var10000);
         if (var15 != null) {
            Component var4 = var15;
            var5 = false;
            var2.displayName(var4);
         }
      }

      List var16 = this.lore;
      if (var16 != null) {
         Iterable var3 = (Iterable)var16;
         boolean var13 = false;
         Collection var6 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var3, 10)));
         boolean var7 = false;
         Iterator var8 = var3.iterator();

         while(var8.hasNext()) {
            Object var9 = var8.next();
            String var10 = (String)var9;
            boolean var11 = false;
            var6.add(StringExtKt.toMMComponent(var10));
         }

         List var14 = (List)var6;
         var5 = false;
         var2.lore(var14);
      }

      var2.setCustomModelData(this.customModelData);
      var1.setItemMeta(var2);
      return var1;
   }
}
