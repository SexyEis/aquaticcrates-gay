package gg.aquatic.aquaticcrates.plugin.crate;

import gg.aquatic.aquaticcrates.api.player.HistoryHandler;
import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runAsync$1\n+ 2 BasicOpenManager.kt\ngg/aquatic/aquaticcrates/plugin/crate/BasicOpenManager\n+ 3 CollectionExt.kt\ngg/aquatic/waves/util/collection/CollectionExtKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,14:1\n156#2,7:15\n163#2,7:29\n170#2,3:37\n179#2,4:44\n192#2,2:52\n7#3,2:22\n9#3,2:25\n11#3:28\n1863#4:24\n1864#4:27\n1#5:36\n6#6,4:40\n6#6,4:48\n*S KotlinDebug\n*F\n+ 1 BasicOpenManager.kt\ngg/aquatic/aquaticcrates/plugin/crate/BasicOpenManager\n*L\n162#1:22,2\n162#1:25,2\n162#1:28\n162#1:24\n162#1:27\n172#1:40,4\n182#1:48,4\n*E\n"})
public final class BasicOpenManager$massOpen$$inlined$runAsync$2 implements Runnable {
   // $FF: synthetic field
   final int $amount$inlined;
   // $FF: synthetic field
   final BasicOpenManager this$0;
   // $FF: synthetic field
   final Player $player$inlined;
   // $FF: synthetic field
   final CompletableFuture $finalFuture$inlined;

   public BasicOpenManager$massOpen$$inlined$runAsync$2(int var1, BasicOpenManager var2, Player var3, CompletableFuture var4) {
      this.$amount$inlined = var1;
      this.this$0 = var2;
      this.$player$inlined = var3;
      this.$finalFuture$inlined = var4;
   }

   public final void run() {
      boolean var1 = false;
      ConcurrentHashMap var2 = new ConcurrentHashMap();

      boolean var12;
      Iterator var22;
      for(int var3 = 0; var3 < this.$amount$inlined; ++var3) {
         List var4 = this.this$0.getCrate().getRewardManager().getRewards(this.$player$inlined);
         HistoryHandler var10000 = HistoryHandler.INSTANCE;
         Player var10001 = this.$player$inlined;
         String var10002 = this.this$0.getCrate().getIdentifier();
         Collection var5 = (Collection)var4;
         String var6 = var10002;
         Player var7 = var10001;
         HistoryHandler var8 = var10000;
         boolean var9 = false;
         Map var10 = (Map)(new LinkedHashMap());
         Iterable var11 = (Iterable)var5;
         var12 = false;
         Iterator var13 = var11.iterator();

         while(var13.hasNext()) {
            Object var14 = var13.next();
            boolean var16 = false;
            RolledReward var18 = (RolledReward)var14;
            boolean var19 = false;
            Pair var44 = TuplesKt.to(var18.getReward().getId(), var18.getRandomAmount());
            var10.put(var44.getFirst(), var44.getSecond());
         }

         var8.registerCrateOpen(var7, var6, var10);
         var22 = var4.iterator();

         while(var22.hasNext()) {
            RolledReward var27 = (RolledReward)var22.next();
            Pair var42 = (Pair)var2.get(var27.getReward());
            if (var42 == null) {
               var42 = TuplesKt.to(0, 0);
            }

            Pair var30 = var42;
            ((Map)var2).put(var27.getReward(), TuplesKt.to(((Number)var30.getFirst()).intValue() + 1, ((Number)var30.getSecond()).intValue() + var27.getRandomAmount()));
            var27.give(this.$player$inlined, true);
         }
      }

      Collection var43 = var2.values();
      Intrinsics.checkNotNullExpressionValue(var43, "<get-values>(...)");
      Iterable var21 = (Iterable)var43;
      int var23 = 0;

      int var26;
      Pair var34;
      for(Iterator var28 = var21.iterator(); var28.hasNext(); var23 += var26) {
         Object var31 = var28.next();
         var34 = (Pair)var31;
         var12 = false;
         var26 = ((Number)var34.getSecond()).intValue();
      }

      var43 = var2.values();
      Intrinsics.checkNotNullExpressionValue(var43, "<get-values>(...)");
      Iterable var24 = (Iterable)var43;
      int var29 = 0;

      for(Iterator var33 = var24.iterator(); var33.hasNext(); var29 += var26) {
         Object var36 = var33.next();
         Pair var37 = (Pair)var36;
         boolean var39 = false;
         var26 = ((Number)var37.getFirst()).intValue();
      }

      boolean var25 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new BasicOpenManager$massOpen$lambda$14$$inlined$runSync$1(this.this$0, this.$player$inlined, var23, var29)));
      var22 = ((Map)var2).entrySet().iterator();

      while(var22.hasNext()) {
         Entry var32 = (Entry)var22.next();
         Reward var35 = (Reward)var32.getKey();
         var34 = (Pair)var32.getValue();
         int var38 = ((Number)var34.getFirst()).intValue();
         int var40 = ((Number)var34.getSecond()).intValue();
         boolean var41 = false;
         Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new BasicOpenManager$massOpen$lambda$14$$inlined$runSync$2(this.this$0, this.$player$inlined, var35, var38, var40)));
      }

      this.$finalFuture$inlined.complete((Object)null);
   }
}
