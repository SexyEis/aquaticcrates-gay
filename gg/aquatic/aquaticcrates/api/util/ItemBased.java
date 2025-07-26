package gg.aquatic.aquaticcrates.api.util;

import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/util/ItemBased;", "", "item", "Lgg/aquatic/waves/item/AquaticItem;", "getItem", "()Lgg/aquatic/waves/item/AquaticItem;", "giveItem", "", "amount", "", "players", "", "Lorg/bukkit/entity/Player;", "(I[Lorg/bukkit/entity/Player;)V", "Lorg/bukkit/inventory/ItemStack;", "api"}
)
public interface ItemBased {
   @NotNull
   AquaticItem getItem();

   void giveItem(int var1, @NotNull Player... var2);

   @NotNull
   ItemStack getItem(int var1);

   @Metadata(
      mv = {2, 1, 0},
      k = 3,
      xi = 48
   )
   public static final class DefaultImpls {
      public static void giveItem(@NotNull ItemBased var0, int var1, @NotNull Player... var2) {
         Intrinsics.checkNotNullParameter(var2, "players");
         ItemStack var3 = var0.getItem(var1);
         int var4 = 0;

         for(int var5 = var2.length; var4 < var5; ++var4) {
            Player var6 = var2[var4];
            ItemStack var10000 = var3.clone();
            Intrinsics.checkNotNullExpressionValue(var10000, "clone(...)");
            ItemStack var7 = var10000;
            PlayerInventory var10 = var6.getInventory();
            ItemStack[] var9 = new ItemStack[]{var7};
            HashMap var11 = var10.addItem(var9);
            Intrinsics.checkNotNullExpressionValue(var11, "addItem(...)");
            Iterator var8 = ((Map)var11).entrySet().iterator();

            while(var8.hasNext()) {
               ItemStack var12 = (ItemStack)((Entry)var8.next()).getValue();
               var6.getWorld().dropItem(var6.getLocation(), var12);
            }
         }

      }

      @NotNull
      public static ItemStack getItem(@NotNull ItemBased var0, int var1) {
         ItemStack var2 = var0.getItem().getItem();
         var2.setAmount(var1);
         return var2;
      }
   }
}
