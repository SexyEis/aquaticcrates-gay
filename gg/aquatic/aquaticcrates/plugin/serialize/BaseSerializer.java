package gg.aquatic.aquaticcrates.plugin.serialize;

import gg.aquatic.aquaticcrates.api.player.CrateProfileEntry;
import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.aquaticcrates.api.reward.RewardAction;
import gg.aquatic.aquaticcrates.api.reward.RewardAmountRange;
import gg.aquatic.aquaticcrates.api.reward.RewardRarity;
import gg.aquatic.aquaticcrates.plugin.reward.RewardImpl;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.collections.MapsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.ranges.RangesKt;
import gg.aquatic.waves.registry.WavesRegistry;
import gg.aquatic.waves.registry.serializer.ActionSerializer;
import gg.aquatic.waves.registry.serializer.RequirementSerializer;
import gg.aquatic.waves.util.ComponentExtKt;
import gg.aquatic.waves.util.ConfigExtKt;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.generic.ConfiguredExecutableObject;
import gg.aquatic.waves.util.generic.ExecutableObject;
import gg.aquatic.waves.util.requirement.ConfiguredRequirement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f`\rJ4\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f`\rJ\u001f\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0012\"\u00020\u0006¢\u0006\u0002\u0010\u0013J\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018¨\u0006\u0019"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/serialize/BaseSerializer;", "", "<init>", "()V", "loadRewards", "", "", "Lgg/aquatic/aquaticcrates/api/reward/Reward;", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "rarities", "Ljava/util/HashMap;", "Lgg/aquatic/aquaticcrates/api/reward/RewardRarity;", "Lgg/aquatic/waves/libs/kotlin/collections/HashMap;", "loadReward", "sendConsoleMessage", "", "message", "", "([Ljava/lang/String;)V", "loadRewardRanges", "", "Lgg/aquatic/aquaticcrates/api/reward/RewardAmountRange;", "sections", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nBaseSerializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseSerializer.kt\ngg/aquatic/aquaticcrates/plugin/serialize/BaseSerializer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 5 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n+ 6 ActionSerializer.kt\ngg/aquatic/waves/registry/serializer/ActionSerializer\n+ 7 ActionRegistry.kt\ngg/aquatic/waves/registry/ActionRegistryKt\n+ 8 RequirementSerializer.kt\ngg/aquatic/waves/registry/serializer/RequirementSerializer\n+ 9 RequirementRegistry.kt\ngg/aquatic/waves/registry/RequirementRegistryKt\n+ 10 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,181:1\n1#2:182\n1#2:239\n1193#3,2:183\n1267#3,4:185\n1563#3:189\n1634#3,3:190\n1869#3,2:193\n1869#3,2:201\n1869#3,2:203\n1611#3,9:216\n1863#3:225\n1864#3:240\n1620#3:241\n1869#3,2:242\n216#4,2:195\n6#5,4:197\n14#6,2:205\n17#6,4:211\n12#7,4:207\n26#8:215\n12#8,2:226\n14#8,9:230\n12#9,2:228\n13472#10,2:244\n*S KotlinDebug\n*F\n+ 1 BaseSerializer.kt\ngg/aquatic/aquaticcrates/plugin/serialize/BaseSerializer\n*L\n98#1:239\n37#1:183,2\n37#1:185,4\n48#1:189\n48#1:190,3\n50#1:193,2\n81#1:201,2\n85#1:203,2\n98#1:216,9\n98#1:225\n98#1:240\n98#1:241\n107#1:242,2\n59#1:195,2\n69#1:197,4\n94#1:205,2\n94#1:211,4\n94#1:207,4\n98#1:215\n98#1:226,2\n98#1:230,9\n98#1:228,2\n128#1:244,2\n*E\n"})
public abstract class BaseSerializer {
   @NotNull
   public final Map<String, Reward> loadRewards(@NotNull ConfigurationSection var1, @NotNull HashMap<String, RewardRarity> var2) {
      Intrinsics.checkNotNullParameter(var1, "section");
      Intrinsics.checkNotNullParameter(var2, "rarities");
      LinkedHashMap var3 = new LinkedHashMap();
      Iterator var4 = var1.getKeys(false).iterator();

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         ConfigurationSection var10000 = var1.getConfigurationSection(var5);
         if (var10000 != null) {
            ConfigurationSection var6 = var10000;
            Reward var49 = this.loadReward(var6, var2);
            if (var49 != null) {
               Reward var7 = var49;
               ((Map)var3).put(var7.getId(), var7);
               Bukkit.getConsoleSender().sendMessage("Loaded Reward: " + var7.getId());
            }
         }
      }

      Collection var51 = var2.values();
      Intrinsics.checkNotNullExpressionValue(var51, "<get-values>(...)");
      Iterable var29 = (Iterable)var51;
      double var31 = 0.0D;

      Iterator var9;
      boolean var12;
      double var26;
      for(var9 = var29.iterator(); var9.hasNext(); var31 += var26) {
         Object var10 = var9.next();
         RewardRarity var11 = (RewardRarity)var10;
         var12 = false;
         var26 = var11.getChance();
      }

      double var28 = var31;
      var51 = var2.values();
      Intrinsics.checkNotNullExpressionValue(var51, "<get-values>(...)");
      Iterable var32 = (Iterable)var51;
      boolean var8 = false;
      int var36 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(var32, 10)), 16);
      Map var41 = (Map)(new LinkedHashMap(var36));
      var12 = false;
      Iterator var13 = var32.iterator();

      boolean var17;
      while(var13.hasNext()) {
         Object var14 = var13.next();
         RewardRarity var16 = (RewardRarity)var14;
         var17 = false;
         Pair var50 = TuplesKt.to(var16.getRarityId(), var16.getChance() / var28);
         var41.put(var50.getFirst(), var50.getSecond());
      }

      Map var30 = var41;
      Iterator var33 = ((Map)var2).entrySet().iterator();

      while(var33.hasNext()) {
         Entry var34 = (Entry)var33.next();
         ArrayList var37 = new ArrayList();
         Iterator var38 = ((Map)var3).entrySet().iterator();

         while(var38.hasNext()) {
            Reward var42 = (Reward)((Entry)var38.next()).getValue();
            if (Intrinsics.areEqual(var42.getRarity(), var34.getValue())) {
               ((Collection)var37).add(var42);
            }
         }

         Iterable var43 = (Iterable)var37;
         double var44 = 0.0D;

         Iterator var15;
         boolean var18;
         Object var52;
         for(var15 = var43.iterator(); var15.hasNext(); var44 += var26) {
            var52 = var15.next();
            Reward var54 = (Reward)var52;
            var18 = false;
            var26 = var54.getChance();
         }

         double var39 = var44;
         Iterable var46 = (Iterable)var37;
         boolean var47 = false;
         Collection var53 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var46, 10)));
         var17 = false;
         Iterator var58 = var46.iterator();

         while(var58.hasNext()) {
            Object var19 = var58.next();
            Reward var20 = (Reward)var19;
            boolean var21 = false;
            var53.add(TuplesKt.to(var20, var20.getChance() / var39));
         }

         List var45 = (List)var53;
         var46 = (Iterable)var45;
         var47 = false;
         var15 = var46.iterator();

         while(var15.hasNext()) {
            var52 = var15.next();
            Pair var57 = (Pair)var52;
            var18 = false;
            Reward var59 = (Reward)var57.component1();
            double var60 = ((Number)var57.component2()).doubleValue();
            Double var55 = (Double)var30.get(var34.getKey());
            double var22 = var55 != null ? var55 : 0.0D;
            if (var59 instanceof RewardImpl) {
               ((RewardImpl)var59).setChance(var22 * var60);
            }
         }
      }

      Bukkit.getConsoleSender().sendMessage("Loaded Rewards:");
      Map var35 = (Map)var3;
      var8 = false;
      var9 = var35.entrySet().iterator();

      while(var9.hasNext()) {
         Entry var40 = (Entry)var9.next();
         var12 = false;
         Reward var48 = (Reward)var40.getValue();
         ConsoleCommandSender var56 = Bukkit.getConsoleSender();
         String var10001 = var48.getId();
         var56.sendMessage("- " + var10001 + " (Chance: " + var48.getChance() + ")");
      }

      return (Map)var3;
   }

   @Nullable
   public final Reward loadReward(@NotNull ConfigurationSection var1, @NotNull HashMap<String, RewardRarity> var2) {
      Intrinsics.checkNotNullParameter(var1, "section");
      Intrinsics.checkNotNullParameter(var2, "rarities");
      String var10000 = var1.getName();
      Intrinsics.checkNotNullExpressionValue(var10000, "getName(...)");
      String var3 = var10000;
      CompletableFuture var4 = new CompletableFuture();
      boolean var5 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new BaseSerializer$loadReward$$inlined$runSync$1(var4, var1)));
      AquaticItem var40 = (AquaticItem)var4.join();
      if (var40 == null) {
         String[] var41 = new String[]{"Could not load Reward Item! (" + var1.getCurrentPath() + ".item)"};
         this.sendConsoleMessage(var41);
         return null;
      } else {
         double var6 = var1.getDouble("chance", 1.0D);
         boolean var8 = var1.getBoolean("give-item", false);
         HashMap var9 = new HashMap();
         HashMap var10 = new HashMap();
         ConfigurationSection var49 = var1.getConfigurationSection("global-limits");
         Iterable var13;
         boolean var14;
         Iterator var15;
         Object var16;
         String var17;
         String var10001;
         boolean var18;
         int var19;
         Integer var20;
         Set var51;
         Map var53;
         if (var49 != null) {
            var51 = var49.getKeys(false);
            if (var51 != null) {
               var13 = (Iterable)var51;
               var14 = false;
               var15 = var13.iterator();

               while(var15.hasNext()) {
                  var16 = var15.next();
                  var17 = (String)var16;
                  var18 = false;
                  var19 = var1.getInt("global-limits." + var17);
                  var20 = var19;
                  var53 = (Map)var9;
                  Intrinsics.checkNotNull(var17);
                  var10001 = var17.toUpperCase(Locale.ROOT);
                  Intrinsics.checkNotNullExpressionValue(var10001, "toUpperCase(...)");
                  var53.put(CrateProfileEntry.HistoryType.valueOf(var10001), var20);
               }
            }
         }

         var49 = var1.getConfigurationSection("per-player-limits");
         if (var49 != null) {
            var51 = var49.getKeys(false);
            if (var51 != null) {
               var13 = (Iterable)var51;
               var14 = false;
               var15 = var13.iterator();

               while(var15.hasNext()) {
                  var16 = var15.next();
                  var17 = (String)var16;
                  var18 = false;
                  var19 = var1.getInt("per-player-limits." + var17);
                  var20 = var19;
                  var53 = (Map)var10;
                  Intrinsics.checkNotNull(var17);
                  var10001 = var17.toUpperCase(Locale.ROOT);
                  Intrinsics.checkNotNullExpressionValue(var10001, "toUpperCase(...)");
                  var53.put(CrateProfileEntry.HistoryType.valueOf(var10001), var20);
               }
            }
         }

         ArrayList var11 = new ArrayList();
         List var12 = ConfigExtKt.getSectionList(var1, "actions");
         Iterator var42 = var12.iterator();

         boolean var22;
         ExecutableObject var59;
         while(var42.hasNext()) {
            ConfigurationSection var44 = (ConfigurationSection)var42.next();
            boolean var47 = var44.getBoolean("mass-open-execute", true);
            ActionSerializer var57 = ActionSerializer.INSTANCE;
            boolean var61 = false;
            var10000 = var44.getString("type");
            ConfiguredExecutableObject var58;
            if (var10000 == null) {
               var58 = null;
            } else {
               String var62 = var10000;
               WavesRegistry var21 = WavesRegistry.INSTANCE;
               var22 = false;
               var53 = (Map)var21.getACTION().get(Player.class);
               if (var53 == null) {
                  var59 = null;
               } else {
                  Map var23 = var53;
                  var59 = (ExecutableObject)var23.get(var62);
                  if (var59 == null) {
                     var59 = null;
                  } else {
                     ExecutableObject var24 = var59;
                     var59 = var24 instanceof ExecutableObject ? var24 : null;
                  }
               }

               if (var59 == null) {
                  var58 = null;
               } else {
                  ExecutableObject var25 = var59;
                  ObjectArguments var26 = AquaticObjectArgument.Companion.loadRequirementArguments(var44, var25.getArguments());
                  ConfiguredExecutableObject var64 = new ConfiguredExecutableObject(var25, var26);
                  var58 = var64;
               }
            }

            if (var58 != null) {
               ConfiguredExecutableObject var52 = var58;
               ((Collection)var11).add(new RewardAction(var47, var52));
            }
         }

         RequirementSerializer var45 = RequirementSerializer.INSTANCE;
         List var48 = CollectionsKt.plus((Collection)ConfigExtKt.getSectionList(var1, "requirements"), (Iterable)ConfigExtKt.getSectionList(var1, "conditions"));
         boolean var54 = false;
         Iterable var56 = (Iterable)var48;
         var18 = false;
         Collection var63 = (Collection)(new ArrayList());
         boolean var65 = false;
         boolean var70 = false;
         Iterator var72 = var56.iterator();

         while(var72.hasNext()) {
            Object var74 = var72.next();
            boolean var27 = false;
            ConfigurationSection var28 = (ConfigurationSection)var74;
            boolean var29 = false;
            RequirementSerializer var30 = RequirementSerializer.INSTANCE;
            boolean var31 = false;
            var10000 = var28.getString("type");
            ConfiguredRequirement var67;
            if (var10000 == null) {
               var67 = null;
            } else {
               String var32 = var10000;
               WavesRegistry var33 = WavesRegistry.INSTANCE;
               boolean var34 = false;
               var53 = (Map)var33.getREQUIREMENT().get(Player.class);
               if (var53 == null) {
                  var59 = null;
               } else {
                  Map var35 = var53;
                  var59 = (ExecutableObject)var35.get(var32);
                  if (var59 == null) {
                     var59 = null;
                  } else {
                     ExecutableObject var36 = var59;
                     var59 = var36 instanceof ExecutableObject ? var36 : null;
                  }
               }

               ExecutableObject var37 = var59;
               if (var37 == null) {
                  System.out.println("[Waves] Action type " + var32 + " does not exist!");
                  var67 = null;
               } else {
                  ObjectArguments var81 = AquaticObjectArgument.Companion.loadRequirementArguments(var28, var37.getArguments());
                  ConfiguredRequirement var82 = new ConfiguredRequirement(var37, var81);
                  var67 = var82;
               }
            }

            if (var67 != null) {
               ConfiguredRequirement var38 = var67;
               boolean var39 = false;
               var63.add(var38);
            }
         }

         List var43 = (List)var63;
         List var46 = this.loadRewardRanges(ConfigExtKt.getSectionList(var1, "amount-ranges"));
         var10000 = var1.getString("rarity");
         if (var10000 == null) {
            var10000 = "default";
         }

         String var50 = var10000;
         RewardRarity var77 = (RewardRarity)var2.get(var50);
         if (var77 == null) {
            return null;
         } else {
            RewardRarity var55 = var77;
            var17 = var1.getString("display-name");
            HashMap var60 = new HashMap();
            var49 = var1.getConfigurationSection("variables");
            if (var49 != null) {
               var51 = var49.getKeys(false);
               if (var51 != null) {
                  Iterable var66 = (Iterable)var51;
                  var22 = false;
                  Iterator var71 = var66.iterator();

                  while(var71.hasNext()) {
                     Object var73 = var71.next();
                     String var75 = (String)var73;
                     boolean var76 = false;
                     Map var78 = (Map)var60;
                     var10000 = var1.getString("variables." + var75);
                     if (var10000 != null) {
                        String var80 = var10000;
                        var78.put(var75, var80);
                     }
                  }
               }
            }

            RewardImpl var79 = new RewardImpl;
            String var10006 = var17;
            if (var17 == null) {
               label102: {
                  ItemMeta var68 = var40.getItem().getItemMeta();
                  if (var68 != null) {
                     Component var69 = var68.displayName();
                     if (var69 != null) {
                        var10006 = ComponentExtKt.toMMString(var69);
                        break label102;
                     }
                  }

                  var10006 = null;
               }

               if (var10006 == null) {
                  var10006 = var3;
               }
            }

            var79.<init>(var6, var3, var40, var8, var10006, var9, var10, (List)var11, var43, var46, var55, (Map)var60);
            return (Reward)var79;
         }
      }
   }

   public final void sendConsoleMessage(@NotNull String... var1) {
      Intrinsics.checkNotNullParameter(var1, "message");
      String[] var2 = var1;
      boolean var3 = false;
      int var4 = 0;

      for(int var5 = var1.length; var4 < var5; ++var4) {
         String var6 = var2[var4];
         boolean var8 = false;
         Bukkit.getConsoleSender().sendMessage(var6);
      }

   }

   @NotNull
   public final List<RewardAmountRange> loadRewardRanges(@NotNull List<? extends ConfigurationSection> var1) {
      Intrinsics.checkNotNullParameter(var1, "sections");
      if (var1.isEmpty()) {
         return (List)(new ArrayList());
      } else {
         List var2 = (List)(new ArrayList());
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            ConfigurationSection var4 = (ConfigurationSection)var3.next();
            int var5 = var4.getInt("min");
            int var6 = var4.getInt("max");
            double var7 = var4.getDouble("chance", 1.0D);
            var2.add(new RewardAmountRange(var5, var6, var7));
         }

         return var2;
      }
   }
}
