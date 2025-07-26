package gg.aquatic.aquaticcrates.api.util;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"},
   d2 = {"createItem", "Lorg/bukkit/inventory/ItemStack;", "material", "Lorg/bukkit/Material;", "builder", "Lgg/aquatic/waves/libs/kotlin/Function1;", "Lgg/aquatic/aquaticcrates/api/util/ItemBuilder;", "", "Lgg/aquatic/waves/libs/kotlin/ExtensionFunctionType;", "api"}
)
public final class ItemBuilderKt {
   @NotNull
   public static final ItemStack createItem(@NotNull Material var0, @NotNull Function1<? super ItemBuilder, Unit> var1) {
      Intrinsics.checkNotNullParameter(var0, "material");
      Intrinsics.checkNotNullParameter(var1, "builder");
      boolean var2 = false;
      ItemBuilder var3 = new ItemBuilder(var0);
      var1.invoke(var3);
      return var3.build();
   }
}
