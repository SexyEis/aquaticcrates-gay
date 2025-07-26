package gg.aquatic.aquaticcrates.plugin.preview;

import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.aquaticcrates.api.reward.RewardAmountRange;
import gg.aquatic.aquaticcrates.plugin.crate.BasicCrate;
import gg.aquatic.aquaticcrates.plugin.reward.RolledRewardImpl;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.inventory.event.AsyncPacketInventoryInteractEvent;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.ranges.IntRange;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.menu.AquaticMenu;
import gg.aquatic.waves.menu.MenuComponent;
import gg.aquatic.waves.menu.PrivateAquaticMenu;
import gg.aquatic.waves.menu.SlotSelection;
import gg.aquatic.waves.menu.component.Button;
import gg.aquatic.waves.menu.settings.IButtonSettings;
import gg.aquatic.waves.util.ComponentExtKt;
import gg.aquatic.waves.util.NumberExtKt;
import gg.aquatic.waves.util.PAPIUtilKt;
import gg.aquatic.waves.util.StringExtKt;
import gg.aquatic.waves.util.chance.ChanceUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\"H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenu;", "Lgg/aquatic/waves/menu/PrivateAquaticMenu;", "player", "Lorg/bukkit/entity/Player;", "crate", "Lgg/aquatic/aquaticcrates/plugin/crate/BasicCrate;", "placedCrate", "Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "settings", "Lgg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenuSettings;", "page", "", "<init>", "(Lorg/bukkit/entity/Player;Lgg/aquatic/aquaticcrates/plugin/crate/BasicCrate;Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;Lgg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenuSettings;I)V", "getCrate", "()Lgg/aquatic/aquaticcrates/plugin/crate/BasicCrate;", "getPlacedCrate", "()Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "getSettings", "()Lgg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenuSettings;", "getPage", "()I", "rewards", "", "Lgg/aquatic/aquaticcrates/api/reward/Reward;", "getRewards", "()Ljava/util/Collection;", "openPage", "", "loadItems", "loadButtons", "loadRewards", "loadRandomRewards", "hasNextPage", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nCratePreviewMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CratePreviewMenu.kt\ngg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenu\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,154:1\n1563#2:155\n1634#2,3:156\n6#3,4:159\n*S KotlinDebug\n*F\n+ 1 CratePreviewMenu.kt\ngg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenu\n*L\n105#1:155\n105#1:156,3\n66#1:159,4\n*E\n"})
public final class CratePreviewMenu extends PrivateAquaticMenu {
   @NotNull
   private final BasicCrate crate;
   @Nullable
   private final SpawnedCrate placedCrate;
   @NotNull
   private final CratePreviewMenuSettings settings;
   private final int page;
   @NotNull
   private final Collection<Reward> rewards;

   public CratePreviewMenu(@NotNull Player var1, @NotNull BasicCrate var2, @Nullable SpawnedCrate var3, @NotNull CratePreviewMenuSettings var4, int var5) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "crate");
      Intrinsics.checkNotNullParameter(var4, "settings");
      super(StringExtKt.toMMComponent(PAPIUtilKt.updatePAPIPlaceholders(ComponentExtKt.toMMString(var4.getInvSettings().getTitle()), var1)), var4.getInvSettings().getType(), var1);
      this.crate = var2;
      this.placedCrate = var3;
      this.settings = var4;
      this.page = var5;
      this.rewards = this.crate.getRewardManager().getPossibleRewards(var1).values();
      this.loadItems();
      Iterator var6 = this.getComponents().values().iterator();

      while(var6.hasNext()) {
         MenuComponent var7 = (MenuComponent)var6.next();
         this.updateComponent(var7);
      }

   }

   @NotNull
   public final BasicCrate getCrate() {
      return this.crate;
   }

   @Nullable
   public final SpawnedCrate getPlacedCrate() {
      return this.placedCrate;
   }

   @NotNull
   public final CratePreviewMenuSettings getSettings() {
      return this.settings;
   }

   public final int getPage() {
      return this.page;
   }

   @NotNull
   public final Collection<Reward> getRewards() {
      return this.rewards;
   }

   private final void openPage(int var1) {
      CratePreviewMenuSettings var2 = (CratePreviewMenuSettings)this.crate.getPreviewMenuSettings().get(var1);
      CratePreviewMenu var3 = new CratePreviewMenu(this.getPlayer(), this.crate, this.placedCrate, var2, var1);
      var3.open();
   }

   private final void loadItems() {
      this.loadButtons();
      this.loadRewards();
      this.loadRandomRewards();
   }

   private final void loadButtons() {
      Iterator var1 = ((Map)this.settings.getInvSettings().getComponents()).entrySet().iterator();

      while(var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         String var3 = (String)var2.getKey();
         IButtonSettings var4 = (IButtonSettings)var2.getValue();
         MenuComponent var5 = var4.create(CratePreviewMenu::loadButtons$lambda$0, CratePreviewMenu::loadButtons$lambda$2);
         Map var6 = (Map)this.getComponents();
         Pair var7 = TuplesKt.to(var3, var5);
         var6.put(var7.getFirst(), var7.getSecond());
      }

      if (this.settings.getClearBottomInventory()) {
         Button var8 = new Button("aquaticcrates:clear-button", new ItemStack(Material.AIR), (Collection)(new SlotSelection(CollectionsKt.toMutableList((Iterable)(new IntRange(this.getType().getSize(), this.getType().getSize() + 36))))).getSlots(), -10, 1000, (MenuComponent)null, (Function1)null, (Function2)null, (Function1)null, 448, (DefaultConstructorMarker)null);
         Map var9 = (Map)this.getComponents();
         Pair var10 = TuplesKt.to(var8.getId(), var8);
         var9.put(var10.getFirst(), var10.getSecond());
      }

   }

   private final void loadRewards() {
      int var1 = 0;
      Iterator var2 = ((Iterable)this.crate.getPreviewMenuSettings()).iterator();

      int var3;
      int var4;
      CratePreviewMenuSettings var5;
      for(var3 = 0; var2.hasNext(); var1 += var5.getRewardSlots().size()) {
         var4 = var3++;
         var5 = (CratePreviewMenuSettings)var2.next();
         if (var4 == this.page) {
            break;
         }
      }

      var2 = ((Iterable)this.settings.getRewardSlots()).iterator();
      var3 = 0;

      while(var2.hasNext()) {
         var4 = var3++;
         int var25 = ((Number)var2.next()).intValue();
         int var6 = var1 + var4;
         if (var6 >= this.rewards.size()) {
            break;
         }

         Reward var10000 = (Reward)CollectionsKt.elementAtOrNull((Iterable)this.rewards, var6);
         if (var10000 == null) {
            break;
         }

         Reward var7 = var10000;
         ItemStack var29 = var7.getItem().getItem().clone();
         Intrinsics.checkNotNullExpressionValue(var29, "clone(...)");
         ItemStack var8 = var29;
         ItemMeta var9 = var8.getItemMeta();
         List var10 = (List)(new ArrayList());
         boolean var12 = false;
         List var10001 = var9.lore();
         var10.addAll(var10001 != null ? (Collection)var10001 : (Collection)CollectionsKt.emptyList());
         Iterable var13 = (Iterable)this.settings.getAdditionalRewardLore();
         boolean var15 = false;
         Collection var17 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var13, 10)));
         boolean var18 = false;
         Iterator var19 = var13.iterator();

         while(var19.hasNext()) {
            Object var20 = var19.next();
            String var21 = (String)var20;
            boolean var23 = false;
            Component var30 = StringExtKt.toMMComponent(var21).decoration(TextDecoration.ITALIC, State.NOT_SET);
            Intrinsics.checkNotNullExpressionValue(var30, "decoration(...)");
            var17.add(var30);
         }

         var10.addAll((Collection)((List)var17));
         var9.lore(var10);
         var8.setItemMeta(var9);
         String var10002 = "reward-" + var7.getId();
         int[] var11 = new int[]{var25};
         Button var26 = new Button(var10002, var8, (Collection)SlotSelection.Companion.of(var11).getSlots(), 10, this.settings.getUpdateRewardItemsEvery(), (MenuComponent)null, (Function1)null, CratePreviewMenu::loadRewards$lambda$5, CratePreviewMenu::loadRewards$lambda$6, 64, (DefaultConstructorMarker)null);
         Map var27 = (Map)this.getComponents();
         Pair var28 = TuplesKt.to(var26.getId(), var26);
         var27.put(var28.getFirst(), var28.getSecond());
      }

   }

   private final void loadRandomRewards() {
      Iterator var1 = this.settings.getRandomRewards().getSlots().iterator();

      while(var1.hasNext()) {
         int var2 = ((Number)var1.next()).intValue();
         RandomRewardComponent var3 = new RandomRewardComponent(this.crate, this.rewards, this.settings.getRandomRewards().getChangeDuration(), CratePreviewMenu::loadRandomRewards$lambda$7, 10, (Collection)CollectionsKt.listOf(var2), CratePreviewMenu::loadRandomRewards$lambda$8, this.settings);
         Map var4 = (Map)this.getComponents();
         Pair var5 = TuplesKt.to(var3.getId(), var3);
         var4.put(var5.getFirst(), var5.getSecond());
      }

   }

   private final boolean hasNextPage() {
      return this.crate.getPreviewMenuSettings().size() > this.page + 1;
   }

   private static final String loadButtons$lambda$0(CratePreviewMenu var0, String var1, AquaticMenu var2) {
      Intrinsics.checkNotNullParameter(var1, "str");
      Intrinsics.checkNotNullParameter(var2, "menu");
      String var10000 = StringsKt.replace$default(var1, "%page%", String.valueOf(var0.page + 1), false, 4, (Object)null);
      String var10002 = var0.getPlayer().getName();
      Intrinsics.checkNotNullExpressionValue(var10002, "getName(...)");
      return PAPIUtilKt.updatePAPIPlaceholders(StringsKt.replace$default(var10000, "%player%", var10002, false, 4, (Object)null), var0.getPlayer());
   }

   private static final Unit loadButtons$lambda$2(String var0, CratePreviewMenu var1, AsyncPacketInventoryInteractEvent var2) {
      Intrinsics.checkNotNullParameter(var2, "e");
      switch(var0.hashCode()) {
      case -887731735:
         if (var0.equals("prev-page")) {
            if (var1.page <= 0) {
               return Unit.INSTANCE;
            }

            var1.openPage(var1.page - 1);
         }
         break;
      case 3417674:
         if (var0.equals("open")) {
            boolean var3 = false;
            Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new CratePreviewMenu$loadButtons$lambda$2$$inlined$runSync$1(var1)));
         }
         break;
      case 1170921769:
         if (var0.equals("next-page")) {
            if (!var1.hasNextPage()) {
               return Unit.INSTANCE;
            }

            var1.openPage(var1.page + 1);
         }
      }

      return Unit.INSTANCE;
   }

   private static final String loadRewards$lambda$5(CratePreviewMenu var0, Reward var1, String var2, AquaticMenu var3) {
      Intrinsics.checkNotNullParameter(var2, "str");
      Intrinsics.checkNotNullParameter(var3, "menu");
      return PAPIUtilKt.updatePAPIPlaceholders(StringsKt.replace$default(StringsKt.replace$default(PAPIUtilKt.updatePAPIPlaceholders(var2, var0.getPlayer()), "%chance%", NumberExtKt.decimals(var1.getChance() * 100.0D, 2), false, 4, (Object)null), "%rarity%", var1.getRarity().getDisplayName(), false, 4, (Object)null), var0.getPlayer());
   }

   private static final Unit loadRewards$lambda$6(CratePreviewMenu var0, Reward var1, AsyncPacketInventoryInteractEvent var2) {
      Intrinsics.checkNotNullParameter(var2, "e");
      if (var0.getPlayer().hasPermission("aquaticcrates.admin")) {
         RewardAmountRange var10003 = (RewardAmountRange)ChanceUtilsKt.randomItem((Collection)var1.getAmountRanges());
         (new RolledRewardImpl(var1, var10003 != null ? var10003.getRandomNum() : 1)).give(var0.getPlayer(), false);
      }

      return Unit.INSTANCE;
   }

   private static final Unit loadRandomRewards$lambda$7(AsyncPacketInventoryInteractEvent var0) {
      Intrinsics.checkNotNullParameter(var0, "e");
      return Unit.INSTANCE;
   }

   private static final String loadRandomRewards$lambda$8(CratePreviewMenu var0, String var1, AquaticMenu var2) {
      Intrinsics.checkNotNullParameter(var1, "str");
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      return PAPIUtilKt.updatePAPIPlaceholders(var1, var0.getPlayer());
   }
}
