package gg.aquatic.aquaticcrates.plugin.log;

import gg.aquatic.aquaticcrates.api.player.CrateProfileEntry;
import gg.aquatic.aquaticcrates.api.player.HistoryHandler;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.menu.MenuComponent;
import gg.aquatic.waves.menu.component.Button;
import gg.aquatic.waves.util.StringExtKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runAsync$1\n+ 2 LogMenu.kt\ngg/aquatic/aquaticcrates/plugin/log/LogMenu\n*L\n1#1,14:1\n165#2,37:15\n*E\n"})
public final class LogMenu$loadEntries$$inlined$runAsync$1 implements Runnable {
   // $FF: synthetic field
   final LogMenu this$0;

   public LogMenu$loadEntries$$inlined$runAsync$1(LogMenu var1) {
      this.this$0 = var1;
   }

   public final void run() {
      boolean var1 = false;
      int var2 = this.this$0.getPage() * this.this$0.getSettings().getLogSlots().size();
      int var3 = this.this$0.getSettings().getLogSlots().size() + 1;
      List var4 = HistoryHandler.INSTANCE.loadLogEntries(var2, var3, this.this$0.getPlayerFilter(), this.this$0.getCrateFilter(), this.this$0.getSorting());
      LogMenu.access$setHasNextPage$p(this.this$0, var4.size() >= var3);
      Iterator var5 = ((Iterable)this.this$0.getSettings().getLogSlots()).iterator();
      int var6 = 0;

      while(var5.hasNext()) {
         int var7 = var6++;
         int var8 = ((Number)var5.next()).intValue();
         Pair var10000 = (Pair)CollectionsKt.getOrNull(var4, var7);
         if (var10000 == null) {
            break;
         }

         Pair var9 = var10000;
         String var10 = (String)var9.component1();
         CrateProfileEntry.OpenHistoryEntry var11 = (CrateProfileEntry.OpenHistoryEntry)var9.component2();
         ItemStack var12 = new ItemStack(Material.PAPER);
         boolean var14 = false;
         Component[] var15 = new Component[]{StringExtKt.toMMComponent(" "), StringExtKt.toMMComponent("<white>Player: <yellow>" + var10), StringExtKt.toMMComponent("<white>Timestamp: <yellow>" + var11.getTimestamp()), StringExtKt.toMMComponent("<white>Rewards: <yellow>" + var11.getRewardIds().size())};
         List var16 = CollectionsKt.mutableListOf(var15);
         Iterator var22 = ((Map)var11.getRewardIds()).entrySet().iterator();

         while(var22.hasNext()) {
            Entry var17 = (Entry)var22.next();
            String var18 = (String)var17.getKey();
            int var19 = ((Number)var17.getValue()).intValue();
            ((Collection)var16).add(StringExtKt.toMMComponent("<white> - <yellow>" + var18 + " <gray>x" + var19));
         }

         ((Collection)var16).add(StringExtKt.toMMComponent(" "));
         ((Collection)var16).add(StringExtKt.toMMComponent("<gray>" + LogMenuKt.toFriendlyTimeFromSeconds(var11.getTimestamp())));
         ItemMeta var23 = var12.getItemMeta();
         var23.lore(var16);
         var23.displayName(StringExtKt.toMMComponent("<yellow>Crate: " + var11.getCrateId()));
         var12.setItemMeta(var23);
         Button var21 = new Button("entry_" + var7, var12, (Collection)CollectionsKt.listOf(var8), 1, 20, (MenuComponent)null, (Function1)null, (Function2)null, (Function1)null, 448, (DefaultConstructorMarker)null);
         ((Collection)LogMenu.access$getEntryComponents$p(this.this$0)).add(var21);
         this.this$0.addComponent((MenuComponent)var21);
      }

      LogMenu.access$setLoading$p(this.this$0, false);
   }
}
