package gg.aquatic.aquaticcrates.plugin.reroll.input.inventory;

import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.reroll.RerollManager;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
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
import gg.aquatic.waves.menu.AquaticMenu;
import gg.aquatic.waves.menu.MenuComponent;
import gg.aquatic.waves.menu.PrivateAquaticMenu;
import gg.aquatic.waves.menu.SlotSelection;
import gg.aquatic.waves.menu.component.Button;
import gg.aquatic.waves.menu.settings.IButtonSettings;
import gg.aquatic.waves.util.ComponentExtKt;
import gg.aquatic.waves.util.PAPIUtilKt;
import gg.aquatic.waves.util.StringExtKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/reroll/input/inventory/RerollMenu;", "Lgg/aquatic/waves/menu/PrivateAquaticMenu;", "player", "Lorg/bukkit/entity/Player;", "rewards", "", "Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "settings", "Lgg/aquatic/aquaticcrates/plugin/reroll/input/inventory/RerollInventorySettings;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "future", "Ljava/util/concurrent/CompletableFuture;", "Lgg/aquatic/aquaticcrates/api/reroll/RerollManager$RerollResult;", "<init>", "(Lorg/bukkit/entity/Player;Ljava/util/Collection;Lgg/aquatic/aquaticcrates/plugin/reroll/input/inventory/RerollInventorySettings;Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;Ljava/util/concurrent/CompletableFuture;)V", "getRewards", "()Ljava/util/Collection;", "getSettings", "()Lgg/aquatic/aquaticcrates/plugin/reroll/input/inventory/RerollInventorySettings;", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "getFuture", "()Ljava/util/concurrent/CompletableFuture;", "loadItems", "", "loadRewardButtons", "loadButtons", "plugin"}
)
@SourceDebugExtension({"SMAP\nRerollMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RerollMenu.kt\ngg/aquatic/aquaticcrates/plugin/reroll/input/inventory/RerollMenu\n+ 2 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,93:1\n6#2,4:94\n6#2,4:98\n*S KotlinDebug\n*F\n+ 1 RerollMenu.kt\ngg/aquatic/aquaticcrates/plugin/reroll/input/inventory/RerollMenu\n*L\n68#1:94,4\n73#1:98,4\n*E\n"})
public final class RerollMenu extends PrivateAquaticMenu {
   @NotNull
   private final Collection<RolledReward> rewards;
   @NotNull
   private final RerollInventorySettings settings;
   @NotNull
   private final CrateAnimation animation;
   @NotNull
   private final CompletableFuture<RerollManager.RerollResult> future;

   public RerollMenu(@NotNull Player var1, @NotNull Collection<? extends RolledReward> var2, @NotNull RerollInventorySettings var3, @NotNull CrateAnimation var4, @NotNull CompletableFuture<RerollManager.RerollResult> var5) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "rewards");
      Intrinsics.checkNotNullParameter(var3, "settings");
      Intrinsics.checkNotNullParameter(var4, "animation");
      Intrinsics.checkNotNullParameter(var5, "future");
      super(StringExtKt.toMMComponent(PAPIUtilKt.updatePAPIPlaceholders(var4.updatePlaceholders(ComponentExtKt.toMMString(var3.getInventorySettings().getTitle())), var1)), var3.getInventorySettings().getType(), var1);
      this.rewards = var2;
      this.settings = var3;
      this.animation = var4;
      this.future = var5;
      this.loadItems();
      Iterator var6 = this.getComponents().values().iterator();

      while(var6.hasNext()) {
         MenuComponent var7 = (MenuComponent)var6.next();
         this.updateComponent(var7);
      }

   }

   @NotNull
   public final Collection<RolledReward> getRewards() {
      return this.rewards;
   }

   @NotNull
   public final RerollInventorySettings getSettings() {
      return this.settings;
   }

   @NotNull
   public final CrateAnimation getAnimation() {
      return this.animation;
   }

   @NotNull
   public final CompletableFuture<RerollManager.RerollResult> getFuture() {
      return this.future;
   }

   private final void loadItems() {
      this.loadButtons();
      this.loadRewardButtons();
   }

   private final void loadRewardButtons() {
      Iterator var1 = ((Iterable)this.settings.getRewardSlots().getSlots()).iterator();
      int var2 = 0;

      while(var1.hasNext()) {
         int var3 = var2++;
         int var4 = ((Number)var1.next()).intValue();
         RolledReward var10000 = (RolledReward)CollectionsKt.elementAtOrNull((Iterable)this.rewards, var3);
         if (var10000 == null) {
            break;
         }

         RolledReward var5 = var10000;
         ItemStack var6 = var5.getReward().getItem().getItem();
         Button var7 = new Button("reward-" + var5.getReward().getId(), var6, (Collection)CollectionsKt.listOf(var4), 10, 10, (MenuComponent)null, RerollMenu::loadRewardButtons$lambda$0, RerollMenu::loadRewardButtons$lambda$1, (Function1)null, 256, (DefaultConstructorMarker)null);
         Map var8 = (Map)this.getComponents();
         Pair var9 = TuplesKt.to(var7.getId(), var7);
         var8.put(var9.getFirst(), var9.getSecond());
      }

   }

   private final void loadButtons() {
      Iterator var1 = ((Map)this.settings.getInventorySettings().getComponents()).entrySet().iterator();

      while(var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         String var3 = (String)var2.getKey();
         IButtonSettings var4 = (IButtonSettings)var2.getValue();
         Map var5 = (Map)this.getComponents();
         Pair var6 = TuplesKt.to(var3, var4.create(RerollMenu::loadButtons$lambda$2, RerollMenu::loadButtons$lambda$5));
         var5.put(var6.getFirst(), var6.getSecond());
      }

      if (this.settings.getClearBottomInventory()) {
         Button var7 = new Button("aquaticcrates:clear-button", new ItemStack(Material.AIR), (Collection)(new SlotSelection(CollectionsKt.toMutableList((Iterable)(new IntRange(this.getType().getSize(), this.getType().getSize() + 36))))).getSlots(), -10, 1000, (MenuComponent)null, RerollMenu::loadButtons$lambda$6, (Function2)null, (Function1)null, 384, (DefaultConstructorMarker)null);
         Map var8 = (Map)this.getComponents();
         Pair var9 = TuplesKt.to(var7.getId(), var7);
         var8.put(var9.getFirst(), var9.getSecond());
      }

   }

   private static final boolean loadRewardButtons$lambda$0(AquaticMenu var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      return true;
   }

   private static final String loadRewardButtons$lambda$1(RerollMenu var0, String var1, AquaticMenu var2) {
      Intrinsics.checkNotNullParameter(var1, "str");
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      return PAPIUtilKt.updatePAPIPlaceholders(var0.animation.updatePlaceholders(var1), var0.getPlayer());
   }

   private static final String loadButtons$lambda$2(RerollMenu var0, String var1, AquaticMenu var2) {
      Intrinsics.checkNotNullParameter(var1, "str");
      Intrinsics.checkNotNullParameter(var2, "menu");
      return var0.animation.updatePlaceholders(var1);
   }

   private static final Unit loadButtons$lambda$5(String var0, RerollMenu var1, AsyncPacketInventoryInteractEvent var2) {
      Intrinsics.checkNotNullParameter(var2, "e");
      boolean var3;
      if (Intrinsics.areEqual(var0, "reroll")) {
         var1.future.complete(new RerollManager.RerollResult(true));
         var3 = false;
         Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new RerollMenu$loadButtons$lambda$5$$inlined$runSync$1(var1)));
      } else if (Intrinsics.areEqual(var0, "claim")) {
         var1.future.complete(new RerollManager.RerollResult(false));
         var3 = false;
         Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new RerollMenu$loadButtons$lambda$5$$inlined$runSync$2(var1)));
      }

      return Unit.INSTANCE;
   }

   private static final boolean loadButtons$lambda$6(AquaticMenu var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      return true;
   }
}
