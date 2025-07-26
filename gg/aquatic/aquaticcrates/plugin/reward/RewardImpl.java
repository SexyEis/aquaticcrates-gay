package gg.aquatic.aquaticcrates.plugin.reward;

import gg.aquatic.aquaticcrates.api.player.CrateProfileEntry;
import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.aquaticcrates.api.reward.RewardAction;
import gg.aquatic.aquaticcrates.api.reward.RewardAmountRange;
import gg.aquatic.aquaticcrates.api.reward.RewardRarity;
import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.requirement.ConfiguredRequirement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0019\u0018\u00002\u00020\u0001BÃ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0012\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001d¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010\n\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R0\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R0\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R \u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u00066"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/reward/RewardImpl;", "Lgg/aquatic/aquaticcrates/api/reward/Reward;", "chance", "", "id", "", "item", "Lgg/aquatic/waves/item/AquaticItem;", "giveItem", "", "displayName", "globalLimits", "Ljava/util/HashMap;", "Lgg/aquatic/aquaticcrates/api/player/CrateProfileEntry$HistoryType;", "", "Lgg/aquatic/waves/libs/kotlin/collections/HashMap;", "perPlayerLimits", "actions", "", "Lgg/aquatic/aquaticcrates/api/reward/RewardAction;", "requirements", "Lgg/aquatic/waves/util/requirement/ConfiguredRequirement;", "Lorg/bukkit/entity/Player;", "amountRanges", "", "Lgg/aquatic/aquaticcrates/api/reward/RewardAmountRange;", "rarity", "Lgg/aquatic/aquaticcrates/api/reward/RewardRarity;", "variables", "", "<init>", "(DLjava/lang/String;Lgg/aquatic/waves/item/AquaticItem;ZLjava/lang/String;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lgg/aquatic/aquaticcrates/api/reward/RewardRarity;Ljava/util/Map;)V", "getChance", "()D", "setChance", "(D)V", "getId", "()Ljava/lang/String;", "getItem", "()Lgg/aquatic/waves/item/AquaticItem;", "getGiveItem", "()Z", "getDisplayName", "getGlobalLimits", "()Ljava/util/HashMap;", "getPerPlayerLimits", "getActions", "()Ljava/util/List;", "getRequirements", "getAmountRanges", "getRarity", "()Lgg/aquatic/aquaticcrates/api/reward/RewardRarity;", "getVariables", "()Ljava/util/Map;", "plugin"}
)
public final class RewardImpl implements Reward {
   private double chance;
   @NotNull
   private final String id;
   @NotNull
   private final AquaticItem item;
   private final boolean giveItem;
   @NotNull
   private final String displayName;
   @NotNull
   private final HashMap<CrateProfileEntry.HistoryType, Integer> globalLimits;
   @NotNull
   private final HashMap<CrateProfileEntry.HistoryType, Integer> perPlayerLimits;
   @NotNull
   private final List<RewardAction> actions;
   @NotNull
   private final List<ConfiguredRequirement<Player>> requirements;
   @NotNull
   private final List<RewardAmountRange> amountRanges;
   @NotNull
   private final RewardRarity rarity;
   @NotNull
   private final Map<String, String> variables;

   public RewardImpl(double var1, @NotNull String var3, @NotNull AquaticItem var4, boolean var5, @NotNull String var6, @NotNull HashMap<CrateProfileEntry.HistoryType, Integer> var7, @NotNull HashMap<CrateProfileEntry.HistoryType, Integer> var8, @NotNull List<RewardAction> var9, @NotNull List<ConfiguredRequirement<Player>> var10, @NotNull List<RewardAmountRange> var11, @NotNull RewardRarity var12, @NotNull Map<String, String> var13) {
      Intrinsics.checkNotNullParameter(var3, "id");
      Intrinsics.checkNotNullParameter(var4, "item");
      Intrinsics.checkNotNullParameter(var6, "displayName");
      Intrinsics.checkNotNullParameter(var7, "globalLimits");
      Intrinsics.checkNotNullParameter(var8, "perPlayerLimits");
      Intrinsics.checkNotNullParameter(var9, "actions");
      Intrinsics.checkNotNullParameter(var10, "requirements");
      Intrinsics.checkNotNullParameter(var11, "amountRanges");
      Intrinsics.checkNotNullParameter(var12, "rarity");
      Intrinsics.checkNotNullParameter(var13, "variables");
      super();
      this.chance = var1;
      this.id = var3;
      this.item = var4;
      this.giveItem = var5;
      this.displayName = var6;
      this.globalLimits = var7;
      this.perPlayerLimits = var8;
      this.actions = var9;
      this.requirements = var10;
      this.amountRanges = var11;
      this.rarity = var12;
      this.variables = var13;
   }

   public double getChance() {
      return this.chance;
   }

   public void setChance(double var1) {
      this.chance = var1;
   }

   @NotNull
   public String getId() {
      return this.id;
   }

   @NotNull
   public AquaticItem getItem() {
      return this.item;
   }

   public boolean getGiveItem() {
      return this.giveItem;
   }

   @NotNull
   public String getDisplayName() {
      return this.displayName;
   }

   @NotNull
   public HashMap<CrateProfileEntry.HistoryType, Integer> getGlobalLimits() {
      return this.globalLimits;
   }

   @NotNull
   public HashMap<CrateProfileEntry.HistoryType, Integer> getPerPlayerLimits() {
      return this.perPlayerLimits;
   }

   @NotNull
   public List<RewardAction> getActions() {
      return this.actions;
   }

   @NotNull
   public List<ConfiguredRequirement<Player>> getRequirements() {
      return this.requirements;
   }

   @NotNull
   public List<RewardAmountRange> getAmountRanges() {
      return this.amountRanges;
   }

   @NotNull
   public RewardRarity getRarity() {
      return this.rarity;
   }

   @NotNull
   public Map<String, String> getVariables() {
      return this.variables;
   }

   public void give(@NotNull Player var1, int var2, boolean var3) {
      Reward.DefaultImpls.give(this, var1, var2, var3);
   }

   @NotNull
   public String updatePlaceholders(@NotNull String var1) {
      return Reward.DefaultImpls.updatePlaceholders(this, var1);
   }
}
