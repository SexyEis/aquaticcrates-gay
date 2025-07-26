package gg.aquatic.aquaticcrates.plugin.serialize;

import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.item.ItemStackExtKt;
import java.util.concurrent.CompletableFuture;
import org.bukkit.configuration.ConfigurationSection;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runSync$1\n+ 2 BaseSerializer.kt\ngg/aquatic/aquaticcrates/plugin/serialize/BaseSerializer\n*L\n1#1,8:1\n70#2,2:9\n*E\n"})
public final class BaseSerializer$loadReward$$inlined$runSync$1 implements Runnable {
   // $FF: synthetic field
   final CompletableFuture $itemFuture$inlined;
   // $FF: synthetic field
   final ConfigurationSection $section$inlined;

   public BaseSerializer$loadReward$$inlined$runSync$1(CompletableFuture var1, ConfigurationSection var2) {
      this.$itemFuture$inlined = var1;
      this.$section$inlined = var2;
   }

   public final void run() {
      boolean var1 = false;
      this.$itemFuture$inlined.complete(ItemStackExtKt.loadFromYml(AquaticItem.Companion, this.$section$inlined.getConfigurationSection("item")));
   }
}
