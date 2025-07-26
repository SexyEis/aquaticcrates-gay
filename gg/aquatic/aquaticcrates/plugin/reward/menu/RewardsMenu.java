package gg.aquatic.aquaticcrates.plugin.reward.menu;

import gg.aquatic.aquaticcrates.api.player.CrateProfileEntry;
import gg.aquatic.aquaticcrates.api.player.CrateProfileModuleKt;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.inventory.event.AsyncPacketInventoryInteractEvent;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.menu.AquaticMenu;
import gg.aquatic.waves.menu.MenuComponent;
import gg.aquatic.waves.menu.PrivateAquaticMenu;
import gg.aquatic.waves.menu.component.Button;
import gg.aquatic.waves.menu.settings.IButtonSettings;
import gg.aquatic.waves.profile.AquaticPlayer;
import gg.aquatic.waves.profile.AquaticPlayerKt;
import gg.aquatic.waves.util.ComponentExtKt;
import gg.aquatic.waves.util.PAPIUtilKt;
import gg.aquatic.waves.util.StringExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/reward/menu/RewardsMenu;", "Lgg/aquatic/waves/menu/PrivateAquaticMenu;", "settings", "Lgg/aquatic/aquaticcrates/plugin/reward/menu/RewardsMenuSettings;", "player", "Lorg/bukkit/entity/Player;", "<init>", "(Lgg/aquatic/aquaticcrates/plugin/reward/menu/RewardsMenuSettings;Lorg/bukkit/entity/Player;)V", "getSettings", "()Lgg/aquatic/aquaticcrates/plugin/reward/menu/RewardsMenuSettings;", "page", "", "rewardComponents", "Ljava/util/HashSet;", "Lgg/aquatic/waves/menu/MenuComponent;", "Lgg/aquatic/waves/libs/kotlin/collections/HashSet;", "loadRewards", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nRewardsMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RewardsMenu.kt\ngg/aquatic/aquaticcrates/plugin/reward/menu/RewardsMenu\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,84:1\n1563#2:85\n1634#2,3:86\n1869#2,2:89\n1869#2,2:91\n1869#2,2:97\n6#3,4:93\n*S KotlinDebug\n*F\n+ 1 RewardsMenu.kt\ngg/aquatic/aquaticcrates/plugin/reward/menu/RewardsMenu\n*L\n57#1:85\n57#1:86,3\n31#1:89,2\n36#1:91,2\n74#1:97,2\n68#1:93,4\n*E\n"})
public final class RewardsMenu extends PrivateAquaticMenu {
   @NotNull
   private final RewardsMenuSettings settings;
   private int page;
   @NotNull
   private final HashSet<MenuComponent> rewardComponents;

   public RewardsMenu(@NotNull RewardsMenuSettings var1, @NotNull Player var2) {
      Intrinsics.checkNotNullParameter(var1, "settings");
      Intrinsics.checkNotNullParameter(var2, "player");
      super(StringExtKt.toMMComponent(PAPIUtilKt.updatePAPIPlaceholders(ComponentExtKt.toMMString(var1.getInvSettings().getTitle()), var2)), var1.getInvSettings().getType(), var2);
      this.settings = var1;
      this.rewardComponents = new HashSet();
      AquaticPlayer var10000 = AquaticPlayerKt.toAquaticPlayer(var2);
      CrateProfileEntry var3 = var10000 != null ? CrateProfileModuleKt.crateEntry(var10000) : null;
      Iterator var4 = ((Map)this.settings.getInvSettings().getComponents()).entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         String var6 = (String)var5.getKey();
         IButtonSettings var7 = (IButtonSettings)var5.getValue();
         this.addComponent(var7.create(RewardsMenu::_init_$lambda$0, RewardsMenu::_init_$lambda$3));
      }

      this.loadRewards();
   }

   @NotNull
   public final RewardsMenuSettings getSettings() {
      return this.settings;
   }

   private final void loadRewards() {
      AquaticPlayer var10000 = AquaticPlayerKt.toAquaticPlayer(this.getPlayer());
      if (var10000 != null) {
         CrateProfileEntry var39 = CrateProfileModuleKt.crateEntry(var10000);
         if (var39 != null) {
            CrateProfileEntry var1 = var39;
            Set var40 = var1.getRewardContainer().getItems().entrySet();
            Intrinsics.checkNotNullExpressionValue(var40, "<get-entries>(...)");
            Set var2 = var40;
            Iterator var3 = ((Iterable)this.settings.getRewardSlots()).iterator();
            int var4 = 0;

            while(var3.hasNext()) {
               int var5 = var4++;
               int var6 = ((Number)var3.next()).intValue();
               int var7 = this.page * this.settings.getRewardSlots().size() + var5;
               Entry var41 = (Entry)CollectionsKt.elementAtOrNull((Iterable)var2, var7);
               if (var41 == null) {
                  break;
               }

               Entry var11 = var41;
               Pair var8 = new Pair(var11.getKey(), var11.getValue());
               Object var42 = var8.component1();
               Intrinsics.checkNotNullExpressionValue(var42, "component1(...)");
               ItemStack var9 = (ItemStack)var42;
               var42 = var8.component2();
               Intrinsics.checkNotNullExpressionValue(var42, "component2(...)");
               Integer var10 = (Integer)var42;
               String var43 = "reward-" + var6;
               ItemStack var12 = var9.clone();
               String var28 = var43;
               boolean var14 = false;
               ItemMeta var15 = var12.getItemMeta();
               List var10001 = var15.lore();
               if (var10001 == null) {
                  var10001 = CollectionsKt.emptyList();
               }

               Collection var44 = (Collection)var10001;
               Iterable var16 = (Iterable)this.settings.getAdditionalRewardLore();
               Collection var17 = var44;
               boolean var19 = false;
               Collection var21 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var16, 10)));
               boolean var22 = false;
               Iterator var23 = var16.iterator();

               while(var23.hasNext()) {
                  Object var24 = var23.next();
                  String var25 = (String)var24;
                  boolean var27 = false;
                  var21.add(StringExtKt.toMMComponent(var25));
               }

               List var26 = (List)var21;
               var15.lore(CollectionsKt.plus(var17, (Iterable)var26));
               var12.setItemMeta(var15);
               Collection var10002 = (Collection)CollectionsKt.listOf(var6);
               Function1 var10006 = RewardsMenu::loadRewards$lambda$6;
               Function2 var10007 = RewardsMenu::loadRewards$lambda$7;
               Function1 var29 = RewardsMenu::loadRewards$lambda$11;
               Function2 var30 = var10007;
               Function1 var31 = var10006;
               Object var32 = null;
               byte var33 = 1;
               byte var34 = 10;
               Collection var35 = var10002;
               Button var38 = new Button(var28, var12, var35, var34, var33, (MenuComponent)var32, var31, var30, var29);
               ((Collection)this.rewardComponents).add(var38);
               this.addComponent((MenuComponent)var38);
            }

            return;
         }
      }

   }

   private static final String _init_$lambda$0(Player var0, String var1, AquaticMenu var2) {
      Intrinsics.checkNotNullParameter(var1, "str");
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      return PAPIUtilKt.updatePAPIPlaceholders(var1, var0);
   }

   private static final Unit _init_$lambda$3(String var0, CrateProfileEntry var1, RewardsMenu var2, AsyncPacketInventoryInteractEvent var3) {
      Intrinsics.checkNotNullParameter(var3, "<unused var>");
      int var4;
      boolean var5;
      Iterator var6;
      Object var7;
      MenuComponent var8;
      boolean var9;
      Iterable var10;
      if (Intrinsics.areEqual(var0, "next-page")) {
         if (var1 == null) {
            return Unit.INSTANCE;
         }

         if (var1.getRewardContainer().getItems().size() / var2.settings.getRewardSlots().size() < var2.page + 1) {
            return Unit.INSTANCE;
         }

         var4 = var2.page++;
         var10 = (Iterable)var2.rewardComponents;
         var5 = false;
         var6 = var10.iterator();

         while(var6.hasNext()) {
            var7 = var6.next();
            var8 = (MenuComponent)var7;
            var9 = false;
            var2.removeComponent(var8);
         }

         var2.loadRewards();
      } else if (Intrinsics.areEqual(var0, "prev-page")) {
         if (var2.page <= 0) {
            return Unit.INSTANCE;
         }

         var4 = var2.page;
         var2.page = var4 + -1;
         var10 = (Iterable)var2.rewardComponents;
         var5 = false;
         var6 = var10.iterator();

         while(var6.hasNext()) {
            var7 = var6.next();
            var8 = (MenuComponent)var7;
            var9 = false;
            var2.removeComponent(var8);
         }

         var2.loadRewards();
      }

      return Unit.INSTANCE;
   }

   private static final boolean loadRewards$lambda$6(AquaticMenu var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      return true;
   }

   private static final String loadRewards$lambda$7(RewardsMenu var0, Integer var1, String var2, AquaticMenu var3) {
      Intrinsics.checkNotNullParameter(var2, "str");
      Intrinsics.checkNotNullParameter(var3, "<unused var>");
      return StringsKt.replace$default(PAPIUtilKt.updatePAPIPlaceholders(var2, var0.getPlayer()), "%amount%", String.valueOf(var1), false, 4, (Object)null);
   }

   private static final Unit loadRewards$lambda$11(CrateProfileEntry var0, ItemStack var1, RewardsMenu var2, Integer var3, AsyncPacketInventoryInteractEvent var4) {
      Intrinsics.checkNotNullParameter(var4, "e");
      boolean var5 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new RewardsMenu$loadRewards$lambda$11$$inlined$runSync$1(var2, var1, var3)));
      var0.getRewardContainer().getItems().remove(var1);
      Iterable var11 = (Iterable)var2.rewardComponents;
      boolean var6 = false;
      Iterator var7 = var11.iterator();

      while(var7.hasNext()) {
         Object var8 = var7.next();
         MenuComponent var9 = (MenuComponent)var8;
         boolean var10 = false;
         var2.removeComponent(var9);
      }

      var2.rewardComponents.clear();
      var2.loadRewards();
      return Unit.INSTANCE;
   }
}
