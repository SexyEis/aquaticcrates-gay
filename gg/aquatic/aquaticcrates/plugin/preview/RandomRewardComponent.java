package gg.aquatic.aquaticcrates.plugin.preview;

import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.aquaticcrates.plugin.crate.BasicCrate;
import gg.aquatic.waves.inventory.event.AsyncPacketInventoryInteractEvent;
import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.random.Random;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.menu.AquaticMenu;
import gg.aquatic.waves.menu.MenuComponent;
import gg.aquatic.waves.util.NumberExtKt;
import gg.aquatic.waves.util.StringExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0006\u0010\r\u001a\u00020\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0012H\u0016J\u0010\u00106\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010\r\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR#\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u00102\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u00105¨\u00067"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/preview/RandomRewardComponent;", "Lgg/aquatic/waves/menu/MenuComponent;", "crate", "Lgg/aquatic/aquaticcrates/plugin/crate/BasicCrate;", "rewards", "", "Lgg/aquatic/aquaticcrates/api/reward/Reward;", "changeEvery", "", "onClick", "Lgg/aquatic/waves/libs/kotlin/Function1;", "Lgg/aquatic/waves/inventory/event/AsyncPacketInventoryInteractEvent;", "", "priority", "slots", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "Lgg/aquatic/waves/menu/AquaticMenu;", "settings", "Lgg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenuSettings;", "<init>", "(Lgg/aquatic/aquaticcrates/plugin/crate/BasicCrate;Ljava/util/Collection;ILkotlin/jvm/functions/Function1;ILjava/util/Collection;Lkotlin/jvm/functions/Function2;Lgg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenuSettings;)V", "getCrate", "()Lgg/aquatic/aquaticcrates/plugin/crate/BasicCrate;", "getRewards", "()Ljava/util/Collection;", "getChangeEvery", "()I", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "getPriority", "getSlots", "getTextUpdater", "()Lkotlin/jvm/functions/Function2;", "getSettings", "()Lgg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenuSettings;", "id", "getId", "()Ljava/lang/String;", "currentReward", "getCurrentReward", "()Lgg/aquatic/aquaticcrates/api/reward/Reward;", "setCurrentReward", "(Lgg/aquatic/aquaticcrates/api/reward/Reward;)V", "itemstack", "Lorg/bukkit/inventory/ItemStack;", "menu", "changeTick", "getChangeTick", "setChangeTick", "(I)V", "tick", "plugin"}
)
@SourceDebugExtension({"SMAP\nRandomRewardComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RandomRewardComponent.kt\ngg/aquatic/aquaticcrates/plugin/preview/RandomRewardComponent\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,72:1\n1563#2:73\n1634#2,3:74\n1563#2:77\n1634#2,3:78\n*S KotlinDebug\n*F\n+ 1 RandomRewardComponent.kt\ngg/aquatic/aquaticcrates/plugin/preview/RandomRewardComponent\n*L\n41#1:73\n41#1:74,3\n43#1:77\n43#1:78,3\n*E\n"})
public final class RandomRewardComponent extends MenuComponent {
   @NotNull
   private final BasicCrate crate;
   @NotNull
   private final Collection<Reward> rewards;
   private final int changeEvery;
   @NotNull
   private Function1<? super AsyncPacketInventoryInteractEvent, Unit> onClick;
   private final int priority;
   @NotNull
   private final Collection<Integer> slots;
   @NotNull
   private final Function2<String, AquaticMenu, String> textUpdater;
   @NotNull
   private final CratePreviewMenuSettings settings;
   @NotNull
   private final String id;
   @Nullable
   private Reward currentReward;
   private int changeTick;

   public RandomRewardComponent(@NotNull BasicCrate var1, @NotNull Collection<? extends Reward> var2, int var3, @NotNull Function1<? super AsyncPacketInventoryInteractEvent, Unit> var4, int var5, @NotNull Collection<Integer> var6, @NotNull Function2<? super String, ? super AquaticMenu, String> var7, @NotNull CratePreviewMenuSettings var8) {
      Intrinsics.checkNotNullParameter(var1, "crate");
      Intrinsics.checkNotNullParameter(var2, "rewards");
      Intrinsics.checkNotNullParameter(var4, "onClick");
      Intrinsics.checkNotNullParameter(var6, "slots");
      Intrinsics.checkNotNullParameter(var7, "textUpdater");
      Intrinsics.checkNotNullParameter(var8, "settings");
      super();
      this.crate = var1;
      this.rewards = var2;
      this.changeEvery = var3;
      this.onClick = var4;
      this.priority = var5;
      this.slots = var6;
      this.textUpdater = var7;
      this.settings = var8;
      this.id = "random-reward:" + UUID.randomUUID();
      this.currentReward = (Reward)CollectionsKt.randomOrNull(this.rewards, (Random)Random.Default);
   }

   @NotNull
   public final BasicCrate getCrate() {
      return this.crate;
   }

   @NotNull
   public final Collection<Reward> getRewards() {
      return this.rewards;
   }

   public final int getChangeEvery() {
      return this.changeEvery;
   }

   @NotNull
   public Function1<AsyncPacketInventoryInteractEvent, Unit> getOnClick() {
      return this.onClick;
   }

   public void setOnClick(@NotNull Function1<? super AsyncPacketInventoryInteractEvent, Unit> var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.onClick = var1;
   }

   public int getPriority() {
      return this.priority;
   }

   @NotNull
   public Collection<Integer> getSlots() {
      return this.slots;
   }

   @NotNull
   public final Function2<String, AquaticMenu, String> getTextUpdater() {
      return this.textUpdater;
   }

   @NotNull
   public final CratePreviewMenuSettings getSettings() {
      return this.settings;
   }

   @NotNull
   public String getId() {
      return this.id;
   }

   @Nullable
   public final Reward getCurrentReward() {
      return this.currentReward;
   }

   public final void setCurrentReward(@Nullable Reward var1) {
      this.currentReward = var1;
   }

   @NotNull
   public ItemStack itemstack(@NotNull AquaticMenu var1) {
      Reward var10000;
      ItemStack var22;
      label61: {
         Intrinsics.checkNotNullParameter(var1, "menu");
         var10000 = this.currentReward;
         if (var10000 != null) {
            AquaticItem var21 = var10000.getItem();
            if (var21 != null) {
               var22 = var21.getItem();
               if (var22 != null) {
                  var22 = var22.clone();
                  break label61;
               }
            }
         }

         var22 = null;
      }

      ItemStack var2 = var22;
      var10000 = this.currentReward;
      if (var10000 != null) {
         Reward var3 = var10000;
         boolean var4 = false;
         if (var2 != null) {
            ItemMeta var26 = var2.getItemMeta();
            if (var26 != null) {
               ItemMeta var5 = var26;
               Component var28 = var5.displayName();
               boolean var7;
               if (var28 != null) {
                  Component var6 = var28;
                  var7 = false;
                  MiniMessage var10001 = MiniMessage.miniMessage();
                  Function2 var10002 = this.textUpdater;
                  Object var10003 = MiniMessage.miniMessage().serialize(var6);
                  Intrinsics.checkNotNullExpressionValue(var10003, "serialize(...)");
                  var5.displayName(var10001.deserialize(var10002.invoke(var10003, var1)).decoration(TextDecoration.ITALIC, false));
               }

               List var29 = var5.lore();
               if (var29 != null) {
                  List var20 = var29;
                  var7 = false;
                  Collection var23 = (Collection)var20;
                  Iterable var8 = (Iterable)this.settings.getAdditionalRewardLore();
                  Collection var9 = var23;
                  boolean var11 = false;
                  Collection var13 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var8, 10)));
                  boolean var14 = false;
                  Iterator var15 = var8.iterator();

                  Object var16;
                  boolean var19;
                  while(var15.hasNext()) {
                     var16 = var15.next();
                     String var17 = (String)var16;
                     var19 = false;
                     var13.add(StringExtKt.toMMComponent(var17));
                  }

                  List var18 = (List)var13;
                  var8 = (Iterable)var18;
                  var11 = false;
                  var13 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var8, 10)));
                  var14 = false;
                  var15 = var8.iterator();

                  while(var15.hasNext()) {
                     var16 = var15.next();
                     Component var24 = (Component)var16;
                     var19 = false;
                     MiniMessage var30 = MiniMessage.miniMessage();
                     Function2 var25 = this.textUpdater;
                     Object var27 = MiniMessage.miniMessage().serialize(var24);
                     Intrinsics.checkNotNullExpressionValue(var27, "serialize(...)");
                     var13.add(var30.deserialize(var25.invoke(StringsKt.replace$default(StringsKt.replace$default((String)var27, "%chance%", NumberExtKt.decimals(var3.getChance() * 100.0D, 2), false, 4, (Object)null), "%rarity%", var3.getRarity().getDisplayName(), false, 4, (Object)null), var1)).decoration(TextDecoration.ITALIC, false));
                  }

                  var18 = (List)var13;
                  var5.lore(CollectionsKt.plus(var9, (Iterable)var18));
               }

               var2.setItemMeta(var5);
            }
         }
      }

      var22 = var2;
      if (var2 == null) {
         var22 = new ItemStack(Material.AIR);
      }

      return var22;
   }

   public final int getChangeTick() {
      return this.changeTick;
   }

   public final void setChangeTick(int var1) {
      this.changeTick = var1;
   }

   public void tick(@NotNull AquaticMenu var1) {
      Intrinsics.checkNotNullParameter(var1, "menu");
      if (this.changeEvery > 0) {
         int var2 = this.changeTick++;
         if (this.changeTick >= this.changeEvery) {
            this.changeTick = 0;
            this.currentReward = (Reward)CollectionsKt.random(this.rewards, (Random)Random.Default);
            var1.updateComponent((MenuComponent)this);
         }

      }
   }
}
