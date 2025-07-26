package gg.aquatic.aquaticcrates.api.player;

import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.CrateHandler;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.NoWhenBranchMatchedException;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.profile.AquaticPlayer;
import gg.aquatic.waves.profile.AquaticPlayerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0017J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\fJ\u0016\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\fJ\u001e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\fJ\u0016\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014JF\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010#R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR)\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR)\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006%"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/player/HistoryHandler;", "", "<init>", "()V", "latestRewards", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lgg/aquatic/aquaticcrates/api/player/HistoryHandler$LatestReward;", "getLatestRewards", "()Ljava/util/concurrent/ConcurrentHashMap;", "openHistory", "Lgg/aquatic/aquaticcrates/api/player/CrateProfileEntry$HistoryType;", "", "getOpenHistory", "rewardHistory", "getRewardHistory", "registerCrateOpen", "", "player", "Lorg/bukkit/entity/Player;", "crateId", "rewards", "", "history", "historyType", "rewardId", "loadLogEntries", "", "Lgg/aquatic/waves/libs/kotlin/Pair;", "Lgg/aquatic/aquaticcrates/api/player/CrateProfileEntry$OpenHistoryEntry;", "offset", "limit", "playerName", "sorting", "Lgg/aquatic/aquaticcrates/api/player/CrateProfileDriver$Sorting;", "LatestReward", "api"}
)
@SourceDebugExtension({"SMAP\nHistoryHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HistoryHandler.kt\ngg/aquatic/aquaticcrates/api/player/HistoryHandler\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,232:1\n72#2,2:233\n72#2,2:236\n72#2,2:239\n72#2,2:242\n72#2,2:245\n72#2,2:248\n72#2,2:251\n72#2,2:254\n72#2,2:257\n72#2,2:260\n1#3:235\n1#3:238\n1#3:241\n1#3:244\n1#3:247\n1#3:250\n1#3:253\n1#3:256\n1#3:259\n1#3:262\n1#3:268\n12#4,4:263\n216#5:267\n217#5:269\n77#5:272\n97#5,5:273\n1068#6:270\n1056#6:271\n1563#6:278\n1634#6,3:279\n*S KotlinDebug\n*F\n+ 1 HistoryHandler.kt\ngg/aquatic/aquaticcrates/api/player/HistoryHandler\n*L\n34#1:233,2\n36#1:236,2\n44#1:239,2\n52#1:242,2\n53#1:245,2\n58#1:248,2\n64#1:251,2\n66#1:254,2\n69#1:257,2\n70#1:260,2\n34#1:235\n36#1:238\n44#1:241\n52#1:244\n53#1:247\n58#1:250\n64#1:253\n66#1:256\n69#1:259\n70#1:262\n78#1:263,4\n89#1:267\n89#1:269\n149#1:272\n149#1:273,5\n206#1:270\n207#1:271\n161#1:278\n161#1:279,3\n*E\n"})
public final class HistoryHandler {
   @NotNull
   public static final HistoryHandler INSTANCE = new HistoryHandler();
   @NotNull
   private static final ConcurrentHashMap<String, List<HistoryHandler.LatestReward>> latestRewards = new ConcurrentHashMap();
   @NotNull
   private static final ConcurrentHashMap<String, ConcurrentHashMap<CrateProfileEntry.HistoryType, Integer>> openHistory = new ConcurrentHashMap();
   @NotNull
   private static final ConcurrentHashMap<String, ConcurrentHashMap<CrateProfileEntry.HistoryType, Integer>> rewardHistory = new ConcurrentHashMap();

   private HistoryHandler() {
   }

   @NotNull
   public final ConcurrentHashMap<String, List<HistoryHandler.LatestReward>> getLatestRewards() {
      return latestRewards;
   }

   @NotNull
   public final ConcurrentHashMap<String, ConcurrentHashMap<CrateProfileEntry.HistoryType, Integer>> getOpenHistory() {
      return openHistory;
   }

   @NotNull
   public final ConcurrentHashMap<String, ConcurrentHashMap<CrateProfileEntry.HistoryType, Integer>> getRewardHistory() {
      return rewardHistory;
   }

   public final void registerCrateOpen(@NotNull Player var1, @NotNull String var2, @NotNull Map<String, Integer> var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "crateId");
      Intrinsics.checkNotNullParameter(var3, "rewards");
      AquaticPlayer var10000 = AquaticPlayerKt.toAquaticPlayer(var1);
      if (var10000 != null) {
         CrateProfileEntry var54 = CrateProfileModuleKt.crateEntry(var10000);
         if (var54 != null) {
            CrateProfileEntry var4 = var54;
            ConcurrentHashMap var5 = var4.getNewEntries();
            ConcurrentMap var7 = (ConcurrentMap)openHistory;
            boolean var8 = false;
            Object var56 = var7.get(var2);
            boolean var9;
            boolean var11;
            if (var56 == null) {
               var9 = false;
               ConcurrentHashMap var10 = new ConcurrentHashMap();
               var11 = false;
               var56 = var7.putIfAbsent(var2, var10);
               if (var56 == null) {
                  var56 = var10;
               }
            }

            ConcurrentHashMap var6 = (ConcurrentHashMap)var56;
            Iterator var26 = CrateProfileEntry.HistoryType.getEntries().iterator();

            boolean var12;
            boolean var14;
            boolean var22;
            Iterator var35;
            Integer var52;
            boolean var70;
            while(var26.hasNext()) {
               CrateProfileEntry.HistoryType var28 = (CrateProfileEntry.HistoryType)var26.next();
               Intrinsics.checkNotNull(var6);
               ConcurrentMap var33 = (ConcurrentMap)var6;
               var11 = false;
               var56 = var33.get(var28);
               if (var56 == null) {
                  var12 = false;
                  Integer var13 = 0;
                  var14 = false;
                  var56 = var33.putIfAbsent(var28, var13);
                  if (var56 == null) {
                     var56 = var13;
                  }
               }

               Integer var31 = (Integer)var56;
               ((Map)var6).put(var28, var31 + 1);
               var35 = var3.entrySet().iterator();

               while(var35.hasNext()) {
                  Entry var38 = (Entry)var35.next();
                  String var41 = (String)var38.getKey();
                  int var44 = ((Number)var38.getValue()).intValue();
                  Crate var64 = (Crate)CrateHandler.INSTANCE.getCrates().get(var2);
                  boolean var17;
                  if (var64 != null) {
                     Crate var16 = var64;
                     var17 = false;
                     if (var16 instanceof OpenableCrate) {
                        var56 = ((OpenableCrate)var16).getRewardManager().getRewards().get(var41);
                        Intrinsics.checkNotNull(var56);
                        Reward var18 = (Reward)var56;
                        long var10003 = System.currentTimeMillis();
                        String var10005 = var1.getName();
                        Intrinsics.checkNotNullExpressionValue(var10005, "getName(...)");
                        HistoryHandler.LatestReward var19 = new HistoryHandler.LatestReward(var18, var10003, var44, var10005);
                        HistoryHandler var68 = INSTANCE;
                        ConcurrentMap var20 = (ConcurrentMap)latestRewards;
                        boolean var21 = false;
                        var56 = var20.get(var2);
                        if (var56 == null) {
                           var22 = false;
                           List var23 = Collections.synchronizedList((List)(new ArrayList()));
                           boolean var24 = false;
                           var56 = var20.putIfAbsent(var2, var23);
                           if (var56 == null) {
                              var56 = var23;
                           }
                        }

                        List var25 = (List)var56;
                        var25.add(var19);
                        if (var25.size() > 10) {
                           var25.removeLast();
                        }
                     }
                  }

                  ConcurrentMap var15 = (ConcurrentMap)rewardHistory;
                  String var55 = var2 + ":" + var41;
                  var17 = false;
                  var56 = var15.get(var55);
                  boolean var61;
                  if (var56 == null) {
                     var61 = false;
                     ConcurrentHashMap var65 = new ConcurrentHashMap();
                     var70 = false;
                     var56 = var15.putIfAbsent(var55, var65);
                     if (var56 == null) {
                        var56 = var65;
                     }
                  }

                  ConcurrentHashMap var49 = (ConcurrentHashMap)var56;
                  Intrinsics.checkNotNull(var49);
                  ConcurrentMap var57 = (ConcurrentMap)var49;
                  var17 = false;
                  var56 = var57.get(var28);
                  if (var56 == null) {
                     var61 = false;
                     Integer var67 = 0;
                     var70 = false;
                     var56 = var57.putIfAbsent(var28, var67);
                     if (var56 == null) {
                        var56 = var67;
                     }
                  }

                  var52 = (Integer)var56;
                  ((Map)var49).put(var28, var52 + var44);
               }
            }

            ConcurrentMap var29 = (ConcurrentMap)var5;
            var9 = false;
            var56 = var29.get(var2);
            boolean var37;
            if (var56 == null) {
               var37 = false;
               Collection var40 = (Collection)Collections.synchronizedList((List)(new ArrayList()));
               var12 = false;
               var56 = var29.putIfAbsent(var2, var40);
               if (var56 == null) {
                  var56 = var40;
               }
            }

            Collection var27 = (Collection)var56;
            Intrinsics.checkNotNull(var27);
            var27.add(new CrateProfileEntry.OpenHistoryEntry(System.currentTimeMillis() / (long)'\uea60', var2, new HashMap(var3)));
            ConcurrentMap var32 = (ConcurrentMap)var4.getOpenHistory();
            var37 = false;
            var56 = var32.get(var2);
            boolean var46;
            if (var56 == null) {
               var11 = false;
               ConcurrentHashMap var43 = new ConcurrentHashMap();
               var46 = false;
               var56 = var32.putIfAbsent(var2, var43);
               if (var56 == null) {
                  var56 = var43;
               }
            }

            ConcurrentHashMap var30 = (ConcurrentHashMap)var56;
            Iterator var34 = CrateProfileEntry.HistoryType.getEntries().iterator();

            while(var34.hasNext()) {
               CrateProfileEntry.HistoryType var39 = (CrateProfileEntry.HistoryType)var34.next();
               Intrinsics.checkNotNull(var30);
               ConcurrentMap var45 = (ConcurrentMap)var30;
               var46 = false;
               var56 = var45.get(var39);
               if (var56 == null) {
                  var14 = false;
                  var52 = 0;
                  boolean var58 = false;
                  var56 = var45.putIfAbsent(var39, var52);
                  if (var56 == null) {
                     var56 = var52;
                  }
               }

               Integer var42 = (Integer)var56;
               ((Map)var30).put(var39, var42 + CollectionsKt.sumOfInt((Iterable)var3.values()));
               Iterator var47 = var3.entrySet().iterator();

               while(var47.hasNext()) {
                  Entry var50 = (Entry)var47.next();
                  String var51 = (String)var50.getKey();
                  int var53 = ((Number)var50.getValue()).intValue();
                  ConcurrentMap var60 = (ConcurrentMap)var4.getRewardHistory();
                  String var63 = var2 + ":" + var51;
                  boolean var69 = false;
                  var56 = var60.get(var63);
                  if (var56 == null) {
                     var70 = false;
                     ConcurrentHashMap var71 = new ConcurrentHashMap();
                     var22 = false;
                     var56 = var60.putIfAbsent(var63, var71);
                     if (var56 == null) {
                        var56 = var71;
                     }
                  }

                  ConcurrentHashMap var59 = (ConcurrentHashMap)var56;
                  Intrinsics.checkNotNull(var59);
                  ConcurrentMap var66 = (ConcurrentMap)var59;
                  var69 = false;
                  var56 = var66.get(var39);
                  if (var56 == null) {
                     var70 = false;
                     Integer var72 = 0;
                     var22 = false;
                     var56 = var66.putIfAbsent(var39, var72);
                     if (var56 == null) {
                        var56 = var72;
                     }
                  }

                  Integer var62 = (Integer)var56;
                  ((Map)var59).put(var39, var62 + var53);
               }
            }

            int var36 = 0;
            var35 = ((Map)var5).entrySet().iterator();

            while(var35.hasNext()) {
               Collection var48 = (Collection)((Entry)var35.next()).getValue();
               var36 += var48.size();
               if (var36 >= 500) {
                  var46 = false;
                  Waves.Companion.getINSTANCE().getServer().getScheduler().runTaskAsynchronously((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new HistoryHandler$registerCrateOpen$$inlined$runAsync$1(var4)));
                  break;
               }
            }

            return;
         }
      }

   }

   public final int history(@NotNull CrateProfileEntry.HistoryType var1) {
      Intrinsics.checkNotNullParameter(var1, "historyType");
      int var2 = 0;
      Map var3 = (Map)openHistory;
      boolean var4 = false;
      Iterator var5 = var3.entrySet().iterator();

      while(var5.hasNext()) {
         Entry var6 = (Entry)var5.next();
         boolean var8 = false;
         ConcurrentHashMap var9 = (ConcurrentHashMap)var6.getValue();
         Integer var10000 = (Integer)var9.get(var1);
         if (var10000 != null) {
            int var10 = ((Number)var10000).intValue();
            boolean var11 = false;
            var2 += var10;
         }
      }

      return var2;
   }

   public final int history(@NotNull String var1, @NotNull CrateProfileEntry.HistoryType var2) {
      Intrinsics.checkNotNullParameter(var1, "crateId");
      Intrinsics.checkNotNullParameter(var2, "historyType");
      int var3 = 0;
      ConcurrentHashMap var10000 = (ConcurrentHashMap)openHistory.get(var1);
      if (var10000 != null) {
         ConcurrentHashMap var4 = var10000;
         boolean var5 = false;
         Integer var8 = (Integer)var4.get(var2);
         if (var8 != null) {
            int var6 = ((Number)var8).intValue();
            boolean var7 = false;
            var3 += var6;
         }
      }

      return var3;
   }

   public final int rewardHistory(@NotNull String var1, @NotNull String var2, @NotNull CrateProfileEntry.HistoryType var3) {
      Intrinsics.checkNotNullParameter(var1, "crateId");
      Intrinsics.checkNotNullParameter(var2, "rewardId");
      Intrinsics.checkNotNullParameter(var3, "historyType");
      ConcurrentHashMap var10000 = (ConcurrentHashMap)rewardHistory.get(var1 + ":" + var2);
      int var5;
      if (var10000 != null) {
         Integer var4 = (Integer)var10000.get(var3);
         if (var4 != null) {
            var5 = var4;
            return var5;
         }
      }

      var5 = 0;
      return var5;
   }

   public final int history(@NotNull CrateProfileEntry.HistoryType var1, @NotNull Player var2) {
      byte var3;
      int var5;
      label12: {
         Intrinsics.checkNotNullParameter(var1, "historyType");
         Intrinsics.checkNotNullParameter(var2, "player");
         var3 = 0;
         AquaticPlayer var10001 = AquaticPlayerKt.toAquaticPlayer(var2);
         if (var10001 != null) {
            CrateProfileEntry var4 = CrateProfileModuleKt.crateEntry(var10001);
            if (var4 != null) {
               var5 = var4.openHistory(var1);
               break label12;
            }
         }

         var5 = 0;
      }

      int var6 = var3 + var5;
      return var6;
   }

   public final int history(@NotNull String var1, @NotNull CrateProfileEntry.HistoryType var2, @NotNull Player var3) {
      byte var4;
      int var6;
      label12: {
         Intrinsics.checkNotNullParameter(var1, "crateId");
         Intrinsics.checkNotNullParameter(var2, "historyType");
         Intrinsics.checkNotNullParameter(var3, "player");
         var4 = 0;
         AquaticPlayer var10001 = AquaticPlayerKt.toAquaticPlayer(var3);
         if (var10001 != null) {
            CrateProfileEntry var5 = CrateProfileModuleKt.crateEntry(var10001);
            if (var5 != null) {
               var6 = var5.openHistory(var1, var2);
               break label12;
            }
         }

         var6 = 0;
      }

      int var7 = var4 + var6;
      return var7;
   }

   public final int rewardHistory(@NotNull String var1, @NotNull String var2, @NotNull CrateProfileEntry.HistoryType var3, @NotNull Player var4) {
      Intrinsics.checkNotNullParameter(var1, "crateId");
      Intrinsics.checkNotNullParameter(var2, "rewardId");
      Intrinsics.checkNotNullParameter(var3, "historyType");
      Intrinsics.checkNotNullParameter(var4, "player");
      AquaticPlayer var10000 = AquaticPlayerKt.toAquaticPlayer(var4);
      CrateProfileEntry var5 = var10000 != null ? CrateProfileModuleKt.crateEntry(var10000) : null;
      return var5 != null ? var5.rewardHistory(var1, var2, var3) : 0;
   }

   @NotNull
   public final List<Pair<String, CrateProfileEntry.OpenHistoryEntry>> loadLogEntries(int var1, int var2, @Nullable String var3, @Nullable String var4, @Nullable CrateProfileDriver.Sorting var5) {
      List var6 = (List)(new ArrayList());
      CrateProfileEntry var16;
      AquaticPlayer var10005;
      if (var3 != null) {
         Player var7 = Bukkit.getPlayer(var3);
         if (var7 != null) {
            var10005 = AquaticPlayerKt.toAquaticPlayer(var7);
            if (var10005 == null) {
               return CollectionsKt.emptyList();
            }

            var16 = CrateProfileModuleKt.crateEntry(var10005);
            if (var16 == null) {
               return CollectionsKt.emptyList();
            }

            List var8 = loadLogEntries$collectPlayerLogs(var4, var5, var2, var1, var3, var16);
            var6.addAll((Collection)var8);
         }
      } else {
         Iterator var17 = Bukkit.getOnlinePlayers().iterator();

         label57:
         while(true) {
            while(true) {
               if (!var17.hasNext()) {
                  break label57;
               }

               Player var19 = (Player)var17.next();
               String var10004 = var19.getName();
               Intrinsics.checkNotNullExpressionValue(var10004, "getName(...)");
               Intrinsics.checkNotNull(var19);
               var10005 = AquaticPlayerKt.toAquaticPlayer(var19);
               if (var10005 != null) {
                  var16 = CrateProfileModuleKt.crateEntry(var10005);
                  if (var16 != null) {
                     List var9 = loadLogEntries$collectPlayerLogs(var4, var5, var2, var1, var10004, var16);
                     var6.addAll((Collection)var9);
                  }
               }
            }
         }
      }

      int var18 = var6.size();
      int var20 = Math.max(var1 - var18, 0);
      Map var21 = CrateProfileDriver.INSTANCE.loadLogEntries(var20, var2, var3, var4, var5);
      List var10 = CollectionsKt.plus((Collection)var6, (Iterable)var21.values());
      Iterable var14;
      boolean var15;
      List var10000;
      switch(var5 == null ? -1 : HistoryHandler.WhenMappings.$EnumSwitchMapping$0[var5.ordinal()]) {
      case -1:
         var10000 = var10;
         break;
      case 0:
      default:
         throw new NoWhenBranchMatchedException();
      case 1:
         var14 = (Iterable)var10;
         var15 = false;
         var10000 = CollectionsKt.sortedWith(var14, (Comparator)(new HistoryHandler$loadLogEntries$$inlined$sortedByDescending$1()));
         break;
      case 2:
         var14 = (Iterable)var10;
         var15 = false;
         var10000 = CollectionsKt.sortedWith(var14, (Comparator)(new HistoryHandler$loadLogEntries$$inlined$sortedBy$1()));
      }

      List var11 = CollectionsKt.toMutableList((Collection)var10000);
      if (var18 > 0 && var5 != CrateProfileDriver.Sorting.OLDEST) {
         Iterator var12 = ((Iterable)CollectionsKt.toMutableList((Collection)var11)).iterator();
         int var13 = 0;

         while(var12.hasNext()) {
            int var22 = var13++;
            Pair var23 = (Pair)var12.next();
            if (var22 >= var1) {
               break;
            }

            if (var6.contains(var23)) {
               var11.remove(var23);
            }
         }
      }

      return CollectionsKt.take((Iterable)var11, var2);
   }

   private static final List<Pair<String, CrateProfileEntry.OpenHistoryEntry>> loadLogEntries$collectPlayerLogs(String var0, CrateProfileDriver.Sorting var1, int var2, int var3, String var4, CrateProfileEntry var5) {
      ConcurrentHashMap var6 = var5.getNewEntries();
      List var25;
      if (var0 != null) {
         label43: {
            Collection var10000 = (Collection)var6.get(var0);
            if (var10000 != null) {
               var25 = CollectionsKt.toList((Iterable)var10000);
               if (var25 != null) {
                  break label43;
               }
            }

            var25 = CollectionsKt.emptyList();
         }
      } else {
         Map var8 = (Map)var6;
         boolean var9 = false;
         Collection var11 = (Collection)(new ArrayList());
         boolean var12 = false;
         Iterator var13 = var8.entrySet().iterator();

         while(var13.hasNext()) {
            Entry var14 = (Entry)var13.next();
            boolean var16 = false;
            Iterable var15 = (Iterable)var14.getValue();
            CollectionsKt.addAll(var11, var15);
         }

         var25 = (List)var11;
      }

      List var7 = var25;
      switch(var1 == null ? -1 : HistoryHandler.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
      case -1:
         var25 = var7;
         break;
      case 0:
      default:
         throw new NoWhenBranchMatchedException();
      case 1:
         var25 = var7;
         break;
      case 2:
         var25 = CollectionsKt.asReversed(var7);
      }

      List var19 = var25;
      Iterable var20 = (Iterable)CollectionsKt.take((Iterable)var19, var2 + var3);
      boolean var10 = false;
      Collection var21 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var20, 10)));
      boolean var22 = false;
      Iterator var23 = var20.iterator();

      while(var23.hasNext()) {
         Object var24 = var23.next();
         CrateProfileEntry.OpenHistoryEntry var26 = (CrateProfileEntry.OpenHistoryEntry)var24;
         boolean var17 = false;
         var21.add(TuplesKt.to(var4, var26));
      }

      return (List)var21;
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/player/HistoryHandler$LatestReward;", "", "reward", "Lgg/aquatic/aquaticcrates/api/reward/Reward;", "timestamp", "", "amount", "", "winner", "", "<init>", "(Lgg/aquatic/aquaticcrates/api/reward/Reward;JILjava/lang/String;)V", "getReward", "()Lgg/aquatic/aquaticcrates/api/reward/Reward;", "getTimestamp", "()J", "getAmount", "()I", "getWinner", "()Ljava/lang/String;", "api"}
   )
   public static final class LatestReward {
      @NotNull
      private final Reward reward;
      private final long timestamp;
      private final int amount;
      @NotNull
      private final String winner;

      public LatestReward(@NotNull Reward var1, long var2, int var4, @NotNull String var5) {
         Intrinsics.checkNotNullParameter(var1, "reward");
         Intrinsics.checkNotNullParameter(var5, "winner");
         super();
         this.reward = var1;
         this.timestamp = var2;
         this.amount = var4;
         this.winner = var5;
      }

      @NotNull
      public final Reward getReward() {
         return this.reward;
      }

      public final long getTimestamp() {
         return this.timestamp;
      }

      public final int getAmount() {
         return this.amount;
      }

      @NotNull
      public final String getWinner() {
         return this.winner;
      }
   }

   // $FF: synthetic class
   @Metadata(
      mv = {2, 1, 0},
      k = 3,
      xi = 48
   )
   public class WhenMappings {
      // $FF: synthetic field
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[CrateProfileDriver.Sorting.values().length];

         try {
            var0[CrateProfileDriver.Sorting.NEWEST.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[CrateProfileDriver.Sorting.OLDEST.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
