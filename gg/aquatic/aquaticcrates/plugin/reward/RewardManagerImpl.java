package gg.aquatic.aquaticcrates.plugin.reward;

import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.milestone.MilestoneManager;
import gg.aquatic.aquaticcrates.api.player.CrateProfileEntry;
import gg.aquatic.aquaticcrates.api.player.HistoryHandler;
import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.aquaticcrates.api.reward.RewardAmountRange;
import gg.aquatic.aquaticcrates.api.reward.RewardManager;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.chance.ChanceUtilsKt;
import gg.aquatic.waves.util.requirement.ConfiguredRequirement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00052\u0006\u0010\u001f\u001a\u00020 H\u0016JJ\u0010!\u001a6\u0012\u0004\u0012\u00020\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\t0\"0\bj\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\t0\"`\u000b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\tJ\u001c\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\f\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006%"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/reward/RewardManagerImpl;", "Lgg/aquatic/aquaticcrates/api/reward/RewardManager;", "crate", "Lgg/aquatic/aquaticcrates/api/crate/OpenableCrate;", "possibleRewardRanges", "", "Lgg/aquatic/aquaticcrates/api/reward/RewardAmountRange;", "guaranteedRewards", "Ljava/util/HashMap;", "", "Lgg/aquatic/aquaticcrates/api/reward/Reward;", "Lgg/aquatic/waves/libs/kotlin/collections/HashMap;", "milestoneManager", "Lgg/aquatic/waves/libs/kotlin/Function1;", "Lgg/aquatic/aquaticcrates/api/milestone/MilestoneManager;", "rewards", "", "", "<init>", "(Lgg/aquatic/aquaticcrates/api/crate/OpenableCrate;Ljava/util/List;Ljava/util/HashMap;Lkotlin/jvm/functions/Function1;Ljava/util/Map;)V", "getCrate", "()Lgg/aquatic/aquaticcrates/api/crate/OpenableCrate;", "getPossibleRewardRanges", "()Ljava/util/List;", "getGuaranteedRewards", "()Ljava/util/HashMap;", "getRewards", "()Ljava/util/Map;", "getMilestoneManager", "()Lgg/aquatic/aquaticcrates/api/milestone/MilestoneManager;", "Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "player", "Lorg/bukkit/entity/Player;", "getRandomRewards", "Lgg/aquatic/waves/libs/kotlin/Pair;", "amount", "getPossibleRewards", "plugin"}
)
@SourceDebugExtension({"SMAP\nRewardManagerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RewardManagerImpl.kt\ngg/aquatic/aquaticcrates/plugin/reward/RewardManagerImpl\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 CollectionExt.kt\ngg/aquatic/waves/util/collection/CollectionExtKt\n*L\n1#1,77:1\n382#2,7:78\n15#3,4:85\n*S KotlinDebug\n*F\n+ 1 RewardManagerImpl.kt\ngg/aquatic/aquaticcrates/plugin/reward/RewardManagerImpl\n*L\n52#1:78,7\n62#1:85,4\n*E\n"})
public final class RewardManagerImpl extends RewardManager {
   @NotNull
   private final OpenableCrate crate;
   @NotNull
   private final List<RewardAmountRange> possibleRewardRanges;
   @NotNull
   private final HashMap<Integer, Reward> guaranteedRewards;
   @NotNull
   private final Map<String, Reward> rewards;
   @NotNull
   private final MilestoneManager milestoneManager;

   public RewardManagerImpl(@NotNull OpenableCrate var1, @NotNull List<RewardAmountRange> var2, @NotNull HashMap<Integer, Reward> var3, @NotNull Function1<? super OpenableCrate, ? extends MilestoneManager> var4, @NotNull Map<String, Reward> var5) {
      Intrinsics.checkNotNullParameter(var1, "crate");
      Intrinsics.checkNotNullParameter(var2, "possibleRewardRanges");
      Intrinsics.checkNotNullParameter(var3, "guaranteedRewards");
      Intrinsics.checkNotNullParameter(var4, "milestoneManager");
      Intrinsics.checkNotNullParameter(var5, "rewards");
      super();
      this.crate = var1;
      this.possibleRewardRanges = var2;
      this.guaranteedRewards = var3;
      this.rewards = var5;
      this.milestoneManager = (MilestoneManager)var4.invoke(this.crate);
   }

   @NotNull
   public final OpenableCrate getCrate() {
      return this.crate;
   }

   @NotNull
   public final List<RewardAmountRange> getPossibleRewardRanges() {
      return this.possibleRewardRanges;
   }

   @NotNull
   public final HashMap<Integer, Reward> getGuaranteedRewards() {
      return this.guaranteedRewards;
   }

   @NotNull
   public Map<String, Reward> getRewards() {
      return this.rewards;
   }

   @NotNull
   public MilestoneManager getMilestoneManager() {
      return this.milestoneManager;
   }

   @NotNull
   public List<RolledReward> getRewards(@NotNull Player var1) {
      Intrinsics.checkNotNullParameter(var1, "player");
      List var2 = (List)(new ArrayList());
      RewardAmountRange var10000 = (RewardAmountRange)ChanceUtilsKt.randomItem((Collection)this.possibleRewardRanges);
      int var3 = var10000 != null ? var10000.getRandomNum() : 1;
      HashMap var4 = this.getRandomRewards(var1, var3);
      Iterator var5 = ((Map)var4).entrySet().iterator();

      while(var5.hasNext()) {
         Pair var6 = (Pair)((Entry)var5.next()).getValue();
         Reward var7 = (Reward)var6.getFirst();
         int var8 = ((Number)var6.getSecond()).intValue();

         for(int var9 = 0; var9 < var8; ++var9) {
            Collection var10 = (Collection)var2;
            RewardAmountRange var10003 = (RewardAmountRange)ChanceUtilsKt.randomItem((Collection)var7.getAmountRanges());
            var10.add(new RolledRewardImpl(var7, var10003 != null ? var10003.getRandomNum() : 1));
         }
      }

      return var2;
   }

   @NotNull
   public final HashMap<String, Pair<Reward, Integer>> getRandomRewards(@NotNull Player var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      HashMap var3 = new HashMap();
      int var4 = var2;
      Map var5 = this.getPossibleRewards(var1);
      if (var5.isEmpty()) {
         return var3;
      } else {
         int var6 = HistoryHandler.INSTANCE.history(this.crate.getIdentifier(), CrateProfileEntry.HistoryType.ALLTIME, var1);
         Reward var7;
         Object var10000;
         if (this.guaranteedRewards.containsKey(var6)) {
            var10000 = this.guaranteedRewards.get(var6);
            Intrinsics.checkNotNull(var10000);
            var7 = (Reward)var10000;
            ((Map)var3).put(var7.getId(), TuplesKt.to(var7, 1));
            var4 = var2 - 1;
         }

         while(var4 > 0) {
            Reward var15 = (Reward)ChanceUtilsKt.randomItem((Collection)CollectionsKt.toList((Iterable)var5.values()));
            if (var15 == null) {
               return var3;
            }

            var7 = var15;
            Map var9 = (Map)var3;
            String var10 = var7.getId();
            boolean var11 = false;
            Object var12 = var9.get(var10);
            if (var12 == null) {
               boolean var13 = false;
               Pair var14 = TuplesKt.to(var7, 0);
               var9.put(var10, var14);
               var10000 = var14;
            } else {
               var10000 = var12;
            }

            Pair var8 = (Pair)var10000;
            ((Map)var3).put(var7.getId(), TuplesKt.to(var8.getFirst(), ((Number)var8.getSecond()).intValue() + 1));
            --var4;
         }

         return var3;
      }
   }

   @NotNull
   public Map<String, Reward> getPossibleRewards(@NotNull Player var1) {
      Intrinsics.checkNotNullParameter(var1, "player");
      LinkedHashMap var2 = new LinkedHashMap();
      Iterator var3 = this.getRewards().entrySet().iterator();

      while(true) {
         while(true) {
            label41:
            while(true) {
               String var5;
               Reward var6;
               boolean var10000;
               label33:
               do {
                  if (!var3.hasNext()) {
                     return (Map)var2;
                  }

                  Entry var4 = (Entry)var3.next();
                  var5 = (String)var4.getKey();
                  var6 = (Reward)var4.getValue();
                  Collection var7 = (Collection)var6.getRequirements();
                  boolean var8 = false;
                  Iterator var9 = var7.iterator();

                  ConfiguredRequirement var10;
                  do {
                     if (!var9.hasNext()) {
                        var10000 = true;
                        continue label33;
                     }

                     var10 = (ConfiguredRequirement)var9.next();
                  } while(var10.execute(var1, (Function2)RewardManagerImpl$getPossibleRewards$$inlined$checkRequirements$1.INSTANCE));

                  var10000 = false;
               } while(!var10000);

               Iterator var11 = ((Map)var6.getGlobalLimits()).entrySet().iterator();

               Entry var12;
               CrateProfileEntry.HistoryType var13;
               int var14;
               while(var11.hasNext()) {
                  var12 = (Entry)var11.next();
                  var13 = (CrateProfileEntry.HistoryType)var12.getKey();
                  var14 = ((Number)var12.getValue()).intValue();
                  if (HistoryHandler.INSTANCE.rewardHistory(this.crate.getIdentifier(), var5, var13) >= var14) {
                     continue label41;
                  }
               }

               var11 = ((Map)var6.getPerPlayerLimits()).entrySet().iterator();

               while(var11.hasNext()) {
                  var12 = (Entry)var11.next();
                  var13 = (CrateProfileEntry.HistoryType)var12.getKey();
                  var14 = ((Number)var12.getValue()).intValue();
                  if (HistoryHandler.INSTANCE.rewardHistory(this.crate.getIdentifier(), var5, var13, var1) >= var14) {
                     continue label41;
                  }
               }

               ((Map)var2).put(var5, var6);
            }
         }
      }
   }
}
