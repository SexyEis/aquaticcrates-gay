package gg.aquatic.aquaticcrates.api.reward;

import gg.aquatic.aquaticcrates.api.AbstractCratesPlugin;
import gg.aquatic.aquaticcrates.api.player.CrateProfileEntry;
import gg.aquatic.aquaticcrates.api.player.CrateProfileModuleKt;
import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.profile.AquaticPlayer;
import gg.aquatic.waves.profile.AquaticPlayerKt;
import gg.aquatic.waves.util.NumberExtKt;
import gg.aquatic.waves.util.PAPIUtilKt;
import gg.aquatic.waves.util.chance.IChance;
import gg.aquatic.waves.util.requirement.ConfiguredRequirement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J \u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u000bH\u0016J\u0010\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R.\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013`\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R.\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013`\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001dR\u0012\u0010&\u001a\u00020'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001e\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030+X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00065"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/reward/Reward;", "Lgg/aquatic/waves/util/chance/IChance;", "id", "", "getId", "()Ljava/lang/String;", "item", "Lgg/aquatic/waves/item/AquaticItem;", "getItem", "()Lgg/aquatic/waves/item/AquaticItem;", "giveItem", "", "getGiveItem", "()Z", "displayName", "getDisplayName", "globalLimits", "Ljava/util/HashMap;", "Lgg/aquatic/aquaticcrates/api/player/CrateProfileEntry$HistoryType;", "", "Lgg/aquatic/waves/libs/kotlin/collections/HashMap;", "getGlobalLimits", "()Ljava/util/HashMap;", "perPlayerLimits", "getPerPlayerLimits", "actions", "", "Lgg/aquatic/aquaticcrates/api/reward/RewardAction;", "getActions", "()Ljava/util/List;", "requirements", "Lgg/aquatic/waves/util/requirement/ConfiguredRequirement;", "Lorg/bukkit/entity/Player;", "getRequirements", "amountRanges", "", "Lgg/aquatic/aquaticcrates/api/reward/RewardAmountRange;", "getAmountRanges", "rarity", "Lgg/aquatic/aquaticcrates/api/reward/RewardRarity;", "getRarity", "()Lgg/aquatic/aquaticcrates/api/reward/RewardRarity;", "variables", "", "getVariables", "()Ljava/util/Map;", "give", "", "player", "randomAmount", "massOpen", "updatePlaceholders", "str", "api"}
)
public interface Reward extends IChance {
   @NotNull
   String getId();

   @NotNull
   AquaticItem getItem();

   boolean getGiveItem();

   @NotNull
   String getDisplayName();

   @NotNull
   HashMap<CrateProfileEntry.HistoryType, Integer> getGlobalLimits();

   @NotNull
   HashMap<CrateProfileEntry.HistoryType, Integer> getPerPlayerLimits();

   @NotNull
   List<RewardAction> getActions();

   @NotNull
   List<ConfiguredRequirement<Player>> getRequirements();

   @NotNull
   List<RewardAmountRange> getAmountRanges();

   @NotNull
   RewardRarity getRarity();

   @NotNull
   Map<String, String> getVariables();

   void give(@NotNull Player var1, int var2, boolean var3);

   @NotNull
   String updatePlaceholders(@NotNull String var1);

   @Metadata(
      mv = {2, 1, 0},
      k = 3,
      xi = 48
   )
   @SourceDebugExtension({"SMAP\nReward.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reward.kt\ngg/aquatic/aquaticcrates/api/reward/Reward$DefaultImpls\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,82:1\n216#2,2:83\n*S KotlinDebug\n*F\n+ 1 Reward.kt\ngg/aquatic/aquaticcrates/api/reward/Reward$DefaultImpls\n*L\n69#1:83,2\n*E\n"})
   public static final class DefaultImpls {
      public static void give(@NotNull Reward var0, @NotNull Player var1, int var2, boolean var3) {
         Intrinsics.checkNotNullParameter(var1, "player");
         AquaticPlayer var10000 = AquaticPlayerKt.toAquaticPlayer(var1);
         if (var10000 != null) {
            CrateProfileEntry var20 = CrateProfileModuleKt.crateEntry(var10000);
            if (var20 != null) {
               CrateProfileEntry var4 = var20;
               if (var0.getGiveItem()) {
                  ItemStack var5 = var0.getItem().getItem();
                  PlayerInventory var21 = var1.getInventory();
                  ItemStack[] var8 = new ItemStack[]{var5};
                  HashMap var22 = var21.addItem(var8);
                  Intrinsics.checkNotNullExpressionValue(var22, "addItem(...)");
                  HashMap var6 = var22;
                  Iterator var7 = var6.values().iterator();

                  label51:
                  while(true) {
                     while(true) {
                        if (!var7.hasNext()) {
                           break label51;
                        }

                        ItemStack var16 = (ItemStack)var7.next();
                        if (AbstractCratesPlugin.Companion.getINSTANCE().getSettings().getUseRewardsMenu()) {
                           Pair var17 = null;
                           Iterator var10 = ((Map)var4.getRewardContainer().getItems()).entrySet().iterator();

                           while(var10.hasNext()) {
                              Entry var11 = (Entry)var10.next();
                              ItemStack var12 = (ItemStack)var11.getKey();
                              int var13 = ((Number)var11.getValue()).intValue();
                              if (var12.isSimilar(var16)) {
                                 var17 = TuplesKt.to(var12, var13);
                                 break;
                              }
                           }

                           if (var17 != null) {
                              int var18 = ((Number)var17.getSecond()).intValue() + var16.getAmount();
                              Integer var19 = var18;
                              ((Map)var4.getRewardContainer().getItems()).put(var17.getFirst(), var19);
                           } else {
                              ((Map)var4.getRewardContainer().getItems()).put(var16, var16.getAmount());
                           }
                        } else {
                           Item var9 = var1.getWorld().dropItem(var1.getLocation(), var16);
                           Intrinsics.checkNotNull(var9);
                        }
                     }
                  }
               }

               Iterator var14 = var0.getActions().iterator();

               while(true) {
                  RewardAction var15;
                  do {
                     if (!var14.hasNext()) {
                        return;
                     }

                     var15 = (RewardAction)var14.next();
                  } while(!var15.getMassOpenExecute() && var3);

                  var15.getAction().execute(var1, Reward.DefaultImpls::give$lambda$0);
               }
            }
         }

      }

      @NotNull
      public static String updatePlaceholders(@NotNull Reward var0, @NotNull String var1) {
         Intrinsics.checkNotNullParameter(var1, "str");
         String var2 = null;
         var2 = var1;
         Map var3 = var0.getVariables();
         boolean var4 = false;

         String var9;
         String var10;
         for(Iterator var5 = var3.entrySet().iterator(); var5.hasNext(); var2 = StringsKt.replace$default(var2, "%reward-var:" + var9 + "%", var10, false, 4, (Object)null)) {
            Entry var6 = (Entry)var5.next();
            boolean var8 = false;
            var9 = (String)var6.getKey();
            var10 = (String)var6.getValue();
         }

         String var10000 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(var2, "%reward-name%", var0.getDisplayName(), false, 4, (Object)null), "%chance%", NumberExtKt.decimals(var0.getChance() * 100.0D, 2), false, 4, (Object)null), "%rarity-name%", var0.getRarity().getDisplayName(), false, 4, (Object)null), "%rarity-id%", var0.getRarity().getRarityId(), false, 4, (Object)null);
         String var10002 = var0.getItem().getItem().getType().name().toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var10002, "toLowerCase(...)");
         return StringsKt.replace$default(var10000, "%item_type_image_url%", "https://raw.githubusercontent.com/KygekDev/default-textures/refs/heads/master/textures/items/" + var10002 + ".png", false, 4, (Object)null);
      }

      private static String give$lambda$0(Reward var0, Player var1, int var2, Player var3, String var4) {
         Intrinsics.checkNotNullParameter(var3, "p");
         Intrinsics.checkNotNullParameter(var4, "str");
         String var10000 = PAPIUtilKt.updatePAPIPlaceholders(var0.updatePlaceholders(var4), var1);
         String var10002 = var3.getName();
         Intrinsics.checkNotNullExpressionValue(var10002, "getName(...)");
         return StringsKt.replace$default(StringsKt.replace$default(var10000, "%player%", var10002, false, 4, (Object)null), "%random-amount%", String.valueOf(var2), false, 4, (Object)null);
      }
   }
}
