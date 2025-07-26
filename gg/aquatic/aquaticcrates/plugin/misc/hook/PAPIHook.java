package gg.aquatic.aquaticcrates.plugin.misc.hook;

import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.CrateHandler;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.milestone.Milestone;
import gg.aquatic.aquaticcrates.api.milestone.MilestoneManager;
import gg.aquatic.aquaticcrates.api.player.CrateProfileEntry;
import gg.aquatic.aquaticcrates.api.player.HistoryHandler;
import gg.aquatic.aquaticcrates.api.player.PlayerHandler;
import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.aquaticcrates.api.reward.RewardManager;
import gg.aquatic.aquaticcrates.plugin.log.LogMenuKt;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.util.ComponentExtKt;
import gg.aquatic.waves.util.PAPIUtil;
import gg.aquatic.waves.util.chance.ChanceUtilsKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bR&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/misc/hook/PAPIHook;", "", "<init>", "()V", "cachedPlaceholders", "", "", "Lgg/aquatic/waves/libs/kotlin/Pair;", "", "registerPAPIHook", "", "registerPAPIHook$plugin", "plugin"}
)
@SourceDebugExtension({"SMAP\nPAPIHook.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PAPIHook.kt\ngg/aquatic/aquaticcrates/plugin/misc/hook/PAPIHook\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,239:1\n382#2,7:240\n1869#3,2:247\n*S KotlinDebug\n*F\n+ 1 PAPIHook.kt\ngg/aquatic/aquaticcrates/plugin/misc/hook/PAPIHook\n*L\n36#1:240,7\n216#1:247,2\n*E\n"})
public final class PAPIHook {
   @NotNull
   public static final PAPIHook INSTANCE = new PAPIHook();
   @NotNull
   private static final Map<String, Pair<Long, String>> cachedPlaceholders = (Map)(new LinkedHashMap());

   private PAPIHook() {
   }

   public final void registerPAPIHook$plugin() {
      PAPIUtil.INSTANCE.registerExtension("Larkyy", "aquaticcrates", PAPIHook::registerPAPIHook$lambda$3);
   }

   private static final String registerPAPIHook$lambda$3(OfflinePlayer var0, String var1) {
      Intrinsics.checkNotNullParameter(var0, "offlinePlayer");
      Intrinsics.checkNotNullParameter(var1, "str");
      CharSequence var10000 = (CharSequence)var1;
      String[] var3 = new String[]{"_"};
      List var2 = StringsKt.split$default(var10000, var3, false, 0, 6, (Object)null);
      if (var2.isEmpty()) {
         return "";
      } else {
         String var46 = ((String)var2.get(0)).toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var46, "toLowerCase(...)");
         String var19 = var46;
         String var4;
         Crate var5;
         int var6;
         boolean var12;
         Player var10001;
         Player var20;
         String var21;
         TreeMap var26;
         Milestone var30;
         String var34;
         Crate var47;
         Integer var48;
         Player var56;
         Milestone var57;
         MilestoneManager var58;
         switch(var19.hashCode()) {
         case -2081261232:
            if (var19.equals("statistic")) {
               if (var2.size() < 2) {
                  return "";
               }

               var46 = ((String)var2.get(1)).toLowerCase(Locale.ROOT);
               Intrinsics.checkNotNullExpressionValue(var46, "toLowerCase(...)");
               if (Intrinsics.areEqual(var46, "crate")) {
                  if (var2.size() < 4) {
                     return "";
                  }

                  var4 = (String)var2.get(2);
                  var46 = var4.toLowerCase(Locale.ROOT);
                  Intrinsics.checkNotNullExpressionValue(var46, "toLowerCase(...)");
                  if (Intrinsics.areEqual(var46, "all")) {
                     var47 = null;
                  } else {
                     var47 = (Crate)CrateHandler.INSTANCE.getCrates().get(var4);
                     if (var47 == null) {
                        return "";
                     }
                  }

                  var5 = var47;
                  var46 = (String)CollectionsKt.getOrNull(var2, 3);
                  if (var46 == null) {
                     var46 = "alltime";
                  }

                  var46 = var46.toUpperCase(Locale.ROOT);
                  Intrinsics.checkNotNullExpressionValue(var46, "toUpperCase(...)");
                  CrateProfileEntry.HistoryType var27 = CrateProfileEntry.HistoryType.valueOf(var46);
                  if (var2.size() >= 5) {
                     String var31 = CollectionsKt.joinToString$default((Iterable)var2.subList(4, var2.size()), (CharSequence)"_", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null);
                     var46 = var31.toLowerCase(Locale.ROOT);
                     Intrinsics.checkNotNullExpressionValue(var46, "toLowerCase(...)");
                     if (Intrinsics.areEqual(var46, "self")) {
                        var56 = var0.getPlayer();
                        if (var56 == null) {
                           return "";
                        }
                     } else {
                        var56 = Bukkit.getPlayer(var31);
                        if (var56 == null) {
                           return "";
                        }
                     }

                     Player var35 = var56;
                     if (var5 != null) {
                        return String.valueOf(HistoryHandler.INSTANCE.history(var5.getIdentifier(), var27, var35));
                     }

                     return String.valueOf(HistoryHandler.INSTANCE.history(var27, var35));
                  }

                  if (var5 != null) {
                     return String.valueOf(HistoryHandler.INSTANCE.history(var5.getIdentifier(), var27));
                  }

                  return String.valueOf(HistoryHandler.INSTANCE.history(var27));
               }

               var46 = ((String)var2.get(1)).toLowerCase(Locale.ROOT);
               Intrinsics.checkNotNullExpressionValue(var46, "toLowerCase(...)");
               if (Intrinsics.areEqual(var46, "reward")) {
                  if (var2.size() < 4) {
                     return "";
                  }

                  var10000 = (CharSequence)var2.get(2);
                  String[] var23 = new String[]{":"};
                  List var22 = StringsKt.split$default(var10000, var23, false, 0, 6, (Object)null);
                  if (var22.size() != 2) {
                     return "";
                  }

                  var21 = (String)var22.get(0);
                  String var24 = (String)var22.get(1);
                  var47 = (Crate)CrateHandler.INSTANCE.getCrates().get(var21);
                  if (var47 == null) {
                     return "";
                  }

                  Crate var28 = var47;
                  var46 = (String)CollectionsKt.getOrNull(var2, 3);
                  if (var46 == null) {
                     var46 = "alltime";
                  }

                  var46 = var46.toUpperCase(Locale.ROOT);
                  Intrinsics.checkNotNullExpressionValue(var46, "toUpperCase(...)");
                  CrateProfileEntry.HistoryType var33 = CrateProfileEntry.HistoryType.valueOf(var46);
                  if (var2.size() < 5) {
                     return String.valueOf(HistoryHandler.INSTANCE.rewardHistory(var28.getIdentifier(), var24, var33));
                  }

                  StringBuilder var37 = new StringBuilder();
                  StringBuilder var40 = var37;
                  var12 = false;
                  Iterable var43 = (Iterable)var2.subList(4, var2.size());
                  boolean var44 = false;
                  Iterator var45 = var43.iterator();

                  while(var45.hasNext()) {
                     Object var16 = var45.next();
                     String var17 = (String)var16;
                     boolean var18 = false;
                     var40.append(var17);
                  }

                  var34 = var37.toString();
                  var46 = var34.toLowerCase(Locale.ROOT);
                  Intrinsics.checkNotNullExpressionValue(var46, "toLowerCase(...)");
                  if (Intrinsics.areEqual(var46, "self")) {
                     var56 = var0.getPlayer();
                     if (var56 == null) {
                        return "";
                     }
                  } else {
                     var56 = Bukkit.getPlayer(var34);
                     if (var56 == null) {
                        return "";
                     }
                  }

                  Player var38 = var56;
                  return String.valueOf(HistoryHandler.INSTANCE.rewardHistory(var28.getIdentifier(), var24, var33, var38));
               }
            }
            break;
         case -1065084560:
            if (var19.equals("milestone")) {
               if (var2.size() < 4) {
                  return "";
               }

               var4 = (String)var2.get(1);
               var47 = (Crate)CrateHandler.INSTANCE.getCrates().get(var4);
               if (var47 == null) {
                  return "";
               }

               var5 = var47;
               if (!(var5 instanceof OpenableCrate)) {
                  return "";
               }

               var48 = StringsKt.toIntOrNull((String)var2.get(2));
               if (var48 != null) {
                  var6 = var48;
                  var26 = ((OpenableCrate)var5).getRewardManager().getMilestoneManager().getMilestones();
                  var57 = (Milestone)var26.get(var6);
                  if (var57 == null) {
                     return "";
                  }

                  var30 = var57;
                  var46 = ((String)var2.get(3)).toLowerCase(Locale.ROOT);
                  Intrinsics.checkNotNullExpressionValue(var46, "toLowerCase(...)");
                  var34 = var46;
                  switch(var34.hashCode()) {
                  case 3373707:
                     if (var34.equals("name")) {
                        var46 = ComponentExtKt.toMMString(var30.getDisplayName());
                        return var46;
                     }
                     break;
                  case 869838326:
                     if (var34.equals("remaining")) {
                        var58 = ((OpenableCrate)var5).getRewardManager().getMilestoneManager();
                        var10001 = var0.getPlayer();
                        if (var10001 == null) {
                           return "";
                        }

                        var46 = String.valueOf(var58.remaining(var10001, var6));
                        return var46;
                     }
                     break;
                  case 1080382802:
                     if (var34.equals("reached")) {
                        HistoryHandler var59 = HistoryHandler.INSTANCE;
                        String var50 = var5.getIdentifier();
                        CrateProfileEntry.HistoryType var10002 = CrateProfileEntry.HistoryType.ALLTIME;
                        Player var10003 = var0.getPlayer();
                        if (var10003 == null) {
                           return "";
                        }

                        int var36 = var59.history(var50, var10002, var10003);
                        var46 = var36 >= var6 ? "yes" : "no";
                        return var46;
                     }
                  }

                  var46 = "";
                  return var46;
               }

               return "";
            }
            break;
         case -576600264:
            if (var19.equals("totalkeys")) {
               if (var2.size() < 2) {
                  return "";
               }

               var56 = var0.getPlayer();
               if (var56 == null) {
                  return "";
               }

               var20 = var56;
               var46 = (String)CollectionsKt.getOrNull(var2, 1);
               if (var46 == null) {
                  return "";
               }

               var21 = var46;
               var48 = PlayerHandler.INSTANCE.totalKeys(var20, var21);
               if (var48 != null) {
                  var46 = var48.toString();
                  if (var46 != null) {
                     return var46;
                  }
               }

               var46 = "";
               return var46;
            }
            break;
         case -560076008:
            if (var19.equals("repeatable-milestone")) {
               if (var2.size() < 4) {
                  return "";
               }

               var4 = (String)var2.get(1);
               var47 = (Crate)CrateHandler.INSTANCE.getCrates().get(var4);
               if (var47 == null) {
                  return "";
               }

               var5 = var47;
               if (!(var5 instanceof OpenableCrate)) {
                  return "";
               }

               var48 = StringsKt.toIntOrNull((String)var2.get(2));
               if (var48 != null) {
                  var6 = var48;
                  var26 = ((OpenableCrate)var5).getRewardManager().getMilestoneManager().getRepeatableMilestones();
                  var57 = (Milestone)var26.get(var6);
                  if (var57 == null) {
                     return "";
                  }

                  var30 = var57;
                  var46 = ((String)var2.get(3)).toLowerCase(Locale.ROOT);
                  Intrinsics.checkNotNullExpressionValue(var46, "toLowerCase(...)");
                  var34 = var46;
                  if (Intrinsics.areEqual(var34, "remaining")) {
                     var58 = ((OpenableCrate)var5).getRewardManager().getMilestoneManager();
                     var10001 = var0.getPlayer();
                     if (var10001 == null) {
                        return "";
                     }

                     var46 = String.valueOf(var58.remainingRepeatable(var10001, var6));
                  } else {
                     var46 = Intrinsics.areEqual(var34, "name") ? ComponentExtKt.toMMString(var30.getDisplayName()) : "";
                  }

                  return var46;
               }

               return "";
            }
            break;
         case 3288564:
            if (var19.equals("keys")) {
               if (var2.size() < 2) {
                  return "";
               }

               var56 = var0.getPlayer();
               if (var56 == null) {
                  return "";
               }

               var20 = var56;
               var46 = (String)CollectionsKt.getOrNull(var2, 1);
               if (var46 == null) {
                  return "";
               }

               var21 = var46;
               var48 = PlayerHandler.INSTANCE.virtualKeys(var20, var21);
               if (var48 != null) {
                  var46 = var48.toString();
                  if (var46 != null) {
                     return var46;
                  }
               }

               var46 = "";
               return var46;
            }
            break;
         case 319182258:
            if (var19.equals("randomreward")) {
               if (var2.size() < 4) {
                  return "";
               }

               var4 = (String)var2.get(1);
               var47 = (Crate)CrateHandler.INSTANCE.getCrates().get(var4);
               if (var47 == null) {
                  return "";
               }

               var5 = var47;
               if (!(var5 instanceof OpenableCrate)) {
                  return "";
               }

               var48 = StringsKt.toIntOrNull((String)var2.get(2));
               if (var48 == null) {
                  return "";
               }

               var6 = var48;
               Boolean var52 = StringsKt.toBooleanStrictOrNull((String)var2.get(3));
               if (var52 != null) {
                  boolean var25 = var52;
                  Map var9 = cachedPlaceholders;
                  boolean var10 = false;
                  Object var11 = var9.get(var1);
                  Object var53;
                  if (var11 == null) {
                     var12 = false;
                     Pair var41 = TuplesKt.to(System.currentTimeMillis(), "");
                     var9.put(var1, var41);
                     var53 = var41;
                  } else {
                     var53 = var11;
                  }

                  Pair var29 = (Pair)var53;
                  long var32 = ((Number)var29.component1()).longValue();
                  String var39 = (String)var29.component2();
                  if (var32 + (long)(var6 * 50) >= System.currentTimeMillis()) {
                     Collection var55;
                     if (var25) {
                        RewardManager var54 = ((OpenableCrate)var5).getRewardManager();
                        var10001 = var0.getPlayer();
                        if (var10001 == null) {
                           return "";
                        }

                        var55 = var54.getPossibleRewards(var10001).values();
                     } else {
                        var55 = ((OpenableCrate)var5).getRewardManager().getRewards().values();
                     }

                     label310: {
                        Reward var14 = (Reward)ChanceUtilsKt.randomItem(var55);
                        if (var14 != null) {
                           String var15 = var14.getDisplayName();
                           if (var15 != null) {
                              var46 = var15;
                              break label310;
                           }
                        }

                        var46 = "";
                     }

                     String var13 = var46;
                     cachedPlaceholders.put(var1, TuplesKt.to(System.currentTimeMillis(), var13));
                     var46 = var13;
                  } else {
                     var46 = var39;
                  }

                  String var42 = var46;
                  return var42;
               }

               return "";
            }
            break;
         case 599716917:
            if (var19.equals("latest-reward")) {
               if (var2.size() < 4) {
                  return "";
               }

               var4 = (String)var2.get(1);
               var47 = (Crate)CrateHandler.INSTANCE.getCrates().get(var4);
               if (var47 == null) {
                  return "";
               }

               var5 = var47;
               if (!(var5 instanceof OpenableCrate)) {
                  return "";
               }

               var48 = StringsKt.toIntOrNull((String)var2.get(2));
               if (var48 == null) {
                  return "";
               }

               var6 = var48;
               List var49 = (List)HistoryHandler.INSTANCE.getLatestRewards().get(var4);
               HistoryHandler.LatestReward var7 = var49 != null ? (HistoryHandler.LatestReward)var49.get(var6) : null;
               var46 = ((String)var2.get(3)).toLowerCase(Locale.ROOT);
               Intrinsics.checkNotNullExpressionValue(var46, "toLowerCase(...)");
               String var8 = var46;
               Reward var51;
               switch(var8.hashCode()) {
               case -787742657:
                  if (var8.equals("winner")) {
                     if (var7 != null) {
                        var46 = var7.getWinner();
                        if (var46 != null) {
                           return var46;
                        }
                     }

                     var46 = "";
                     return var46;
                  }
                  break;
               case 3355:
                  if (var8.equals("id")) {
                     if (var7 != null) {
                        var51 = var7.getReward();
                        if (var51 != null) {
                           var46 = var51.getId();
                           if (var46 != null) {
                              return var46;
                           }
                        }
                     }

                     var46 = "";
                     return var46;
                  }
                  break;
               case 3373707:
                  if (var8.equals("name")) {
                     if (var7 != null) {
                        var51 = var7.getReward();
                        if (var51 != null) {
                           var46 = var51.getDisplayName();
                           if (var46 != null) {
                              return var46;
                           }
                        }
                     }

                     var46 = "";
                     return var46;
                  }
                  break;
               case 55126294:
                  if (var8.equals("timestamp")) {
                     if (var7 != null) {
                        var46 = LogMenuKt.toFriendlyTimeFromSeconds(var7.getTimestamp());
                        if (var46 != null) {
                           return var46;
                        }
                     }

                     var46 = "";
                     return var46;
                  }
               }
            }
         }

         return "";
      }
   }
}
