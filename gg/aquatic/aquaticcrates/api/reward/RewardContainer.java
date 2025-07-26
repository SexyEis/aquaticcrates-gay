package gg.aquatic.aquaticcrates.api.reward;

import gg.aquatic.waves.libs.kotlin.Metadata;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/reward/RewardContainer;", "", "<init>", "()V", "items", "Ljava/util/concurrent/ConcurrentHashMap;", "Lorg/bukkit/inventory/ItemStack;", "", "getItems", "()Ljava/util/concurrent/ConcurrentHashMap;", "api"}
)
public final class RewardContainer {
   @NotNull
   private final ConcurrentHashMap<ItemStack, Integer> items = new ConcurrentHashMap();

   @NotNull
   public final ConcurrentHashMap<ItemStack, Integer> getItems() {
      return this.items;
   }
}
