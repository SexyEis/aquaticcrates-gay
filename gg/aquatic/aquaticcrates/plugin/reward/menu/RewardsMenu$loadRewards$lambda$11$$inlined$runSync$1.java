package gg.aquatic.aquaticcrates.plugin.reward.menu;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 RewardsMenu.kt\ngg/aquatic/aquaticcrates/plugin/reward/menu/RewardsMenu\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,8:1\n69#2:9\n70#2,3:11\n1#3:10\n*E\n"})
public final class RewardsMenu$loadRewards$lambda$11$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final RewardsMenu this$0;
   // $FF: synthetic field
   final ItemStack $item$inlined;
   // $FF: synthetic field
   final Integer $amount$inlined;

   public RewardsMenu$loadRewards$lambda$11$$inlined$runSync$1(RewardsMenu var1, ItemStack var2, Integer var3) {
      this.this$0 = var1;
      this.$item$inlined = var2;
      this.$amount$inlined = var3;
   }

   public final void run() {
      boolean var1 = false;
      PlayerInventory var10000 = this.this$0.getPlayer().getInventory();
      ItemStack[] var2 = new ItemStack[1];
      ItemStack var3 = this.$item$inlined.clone();
      byte var5 = 0;
      PlayerInventory var7 = var10000;
      boolean var8 = false;
      var3.setAmount(this.$amount$inlined);
      Unit var9 = Unit.INSTANCE;
      var2[var5] = var3;
      HashMap var12 = var7.addItem(var2);
      Intrinsics.checkNotNullExpressionValue(var12, "addItem(...)");
      Iterator var10 = ((Map)var12).entrySet().iterator();

      while(var10.hasNext()) {
         ItemStack var11 = (ItemStack)((Entry)var10.next()).getValue();
         World var13 = this.this$0.getPlayer().getLocation().getWorld();
         Intrinsics.checkNotNull(var13);
         var13.dropItem(this.this$0.getPlayer().getLocation(), var11);
      }

   }
}
