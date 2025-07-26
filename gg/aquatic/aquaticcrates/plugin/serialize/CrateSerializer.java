package gg.aquatic.aquaticcrates.plugin.serialize;

import gg.aquatic.aquaticcrates.api.PluginSettings;
import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.AnimationSettingsFactory;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationManager;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationSettings;
import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.Key;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.hologram.HologramSettings;
import gg.aquatic.aquaticcrates.api.interaction.CrateInteractAction;
import gg.aquatic.aquaticcrates.api.interaction.key.KeyInteractHandler;
import gg.aquatic.aquaticcrates.api.milestone.Milestone;
import gg.aquatic.aquaticcrates.api.openprice.ConfiguredPrice;
import gg.aquatic.aquaticcrates.api.openprice.OpenPrice;
import gg.aquatic.aquaticcrates.api.openprice.OpenPriceGroup;
import gg.aquatic.aquaticcrates.api.openprice.Price;
import gg.aquatic.aquaticcrates.api.openprice.PriceSerializer;
import gg.aquatic.aquaticcrates.api.openprice.impl.CrateKeyPrice;
import gg.aquatic.aquaticcrates.api.reroll.RerollInput;
import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.aquaticcrates.api.reward.RewardManager;
import gg.aquatic.aquaticcrates.api.reward.RewardRarity;
import gg.aquatic.aquaticcrates.plugin.CratesPlugin;
import gg.aquatic.aquaticcrates.plugin.animation.fail.settings.FailAnimationSettings;
import gg.aquatic.aquaticcrates.plugin.animation.idle.settings.IdleAnimationSettings;
import gg.aquatic.aquaticcrates.plugin.animation.open.AnimationManagerImpl;
import gg.aquatic.aquaticcrates.plugin.animation.open.settings.CinematicAnimationSettings;
import gg.aquatic.aquaticcrates.plugin.animation.open.settings.InstantAnimationSettings;
import gg.aquatic.aquaticcrates.plugin.animation.open.settings.RegularAnimationSettings;
import gg.aquatic.aquaticcrates.plugin.crate.BasicCrate;
import gg.aquatic.aquaticcrates.plugin.crate.KeyImpl;
import gg.aquatic.aquaticcrates.plugin.hologram.HologramSerializer;
import gg.aquatic.aquaticcrates.plugin.interact.BasicCrateInteractHandler;
import gg.aquatic.aquaticcrates.plugin.interact.KeyInteractHandlerImpl;
import gg.aquatic.aquaticcrates.plugin.interact.action.CrateBreakAction;
import gg.aquatic.aquaticcrates.plugin.interact.action.CrateInstantOpenAction;
import gg.aquatic.aquaticcrates.plugin.interact.action.CrateOpenAction;
import gg.aquatic.aquaticcrates.plugin.interact.action.CratePreviewAction;
import gg.aquatic.aquaticcrates.plugin.log.LogMenuSettings;
import gg.aquatic.aquaticcrates.plugin.milestone.MilestoneManagerImpl;
import gg.aquatic.aquaticcrates.plugin.preview.CratePreviewMenuSettings;
import gg.aquatic.aquaticcrates.plugin.reroll.RerollManagerImpl;
import gg.aquatic.aquaticcrates.plugin.reroll.input.InputSettingsFactory;
import gg.aquatic.aquaticcrates.plugin.reroll.input.interaction.InteractionRerollInput;
import gg.aquatic.aquaticcrates.plugin.reroll.input.inventory.InventoryRerollInput;
import gg.aquatic.aquaticcrates.plugin.restriction.OpenData;
import gg.aquatic.aquaticcrates.plugin.reward.RewardManagerImpl;
import gg.aquatic.aquaticcrates.plugin.reward.menu.RewardsMenuSettings;
import gg.aquatic.waves.interactable.settings.BlockInteractableSettings;
import gg.aquatic.waves.interactable.settings.InteractableSettings;
import gg.aquatic.waves.inventory.InventoryType;
import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.item.AquaticItemInteractEvent.InteractType;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.collections.MapsKt;
import gg.aquatic.waves.libs.kotlin.io.FilesKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.menu.MenuSerializer;
import gg.aquatic.waves.menu.SlotSelection;
import gg.aquatic.waves.menu.settings.PrivateMenuSettings;
import gg.aquatic.waves.registry.WavesRegistry;
import gg.aquatic.waves.registry.serializer.ActionSerializer;
import gg.aquatic.waves.registry.serializer.InteractableSerializer;
import gg.aquatic.waves.registry.serializer.RequirementSerializer;
import gg.aquatic.waves.util.Config;
import gg.aquatic.waves.util.ConfigExtKt;
import gg.aquatic.waves.util.StringExtKt;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.block.AquaticBlock;
import gg.aquatic.waves.util.block.impl.VanillaBlock;
import gg.aquatic.waves.util.generic.ConfiguredExecutableObject;
import gg.aquatic.waves.util.generic.ExecutableObject;
import gg.aquatic.waves.util.item.ItemStackExtKt;
import gg.aquatic.waves.util.requirement.ConfiguredRequirement;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u0005J\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u0019J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J(\u0010'\u001a\u001a\u0012\u0004\u0012\u00020)\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*0(2\b\u0010%\u001a\u0004\u0018\u00010&R-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR-\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f`\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006-"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/serialize/CrateSerializer;", "Lgg/aquatic/aquaticcrates/plugin/serialize/BaseSerializer;", "<init>", "()V", "animationSerializers", "Ljava/util/HashMap;", "", "Lgg/aquatic/aquaticcrates/api/animation/crate/AnimationSettingsFactory;", "Lgg/aquatic/waves/libs/kotlin/collections/HashMap;", "getAnimationSerializers", "()Ljava/util/HashMap;", "rerollInputSerializers", "Lgg/aquatic/aquaticcrates/plugin/reroll/input/InputSettingsFactory;", "getRerollInputSerializers", "loadPluginSettings", "Lgg/aquatic/aquaticcrates/api/PluginSettings;", "loadLogMenuSettings", "Lgg/aquatic/aquaticcrates/plugin/log/LogMenuSettings;", "loadRewardMenuSettings", "Lgg/aquatic/aquaticcrates/plugin/reward/menu/RewardsMenuSettings;", "loadCrates", "Lgg/aquatic/aquaticcrates/api/crate/Crate;", "loadBasicCrates", "Lgg/aquatic/aquaticcrates/plugin/crate/BasicCrate;", "folder", "Ljava/io/File;", "loadBasicCrate", "file", "loadFailAnimationSettings", "Lgg/aquatic/aquaticcrates/plugin/animation/fail/settings/FailAnimationSettings;", "cfg", "Lorg/bukkit/configuration/file/FileConfiguration;", "loadIdleAnimationSettings", "", "Lgg/aquatic/aquaticcrates/plugin/animation/idle/settings/IdleAnimationSettings;", "loadCratePreviewMenuSettings", "Lgg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenuSettings;", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "loadInteractActions", "Ljava/util/EnumMap;", "Lgg/aquatic/waves/item/AquaticItemInteractEvent$InteractType;", "Lgg/aquatic/waves/util/generic/ConfiguredExecutableObject;", "Lgg/aquatic/aquaticcrates/api/interaction/CrateInteractAction;", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nCrateSerializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrateSerializer.kt\ngg/aquatic/aquaticcrates/plugin/serialize/CrateSerializer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 RequirementSerializer.kt\ngg/aquatic/waves/registry/serializer/RequirementSerializer\n+ 5 RequirementRegistry.kt\ngg/aquatic/waves/registry/RequirementRegistryKt\n+ 6 ActionSerializer.kt\ngg/aquatic/waves/registry/serializer/ActionSerializer\n+ 7 ActionRegistry.kt\ngg/aquatic/waves/registry/ActionRegistryKt\n+ 8 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,466:1\n1617#2,9:467\n1869#2:476\n1870#2:478\n1626#2:479\n1611#2,9:481\n1863#2:490\n1864#2:505\n1620#2:506\n1611#2,9:508\n1863#2:517\n1864#2:529\n1620#2:530\n1611#2,9:532\n1863#2:541\n1864#2:553\n1620#2:554\n1611#2,9:556\n1863#2:565\n1864#2:580\n1620#2:581\n1611#2,9:583\n1863#2:592\n1864#2:604\n1620#2:605\n1611#2,9:607\n1863#2:616\n1864#2:628\n1620#2:629\n1611#2,9:632\n1863#2:641\n1864#2:653\n1620#2:654\n1611#2,9:656\n1863#2:665\n1864#2:677\n1620#2:678\n1611#2,9:687\n1863#2:696\n1864#2:708\n1620#2:709\n1869#2,2:720\n1869#2,2:722\n1#3:477\n1#3:504\n1#3:528\n1#3:552\n1#3:579\n1#3:603\n1#3:627\n1#3:630\n1#3:652\n1#3:676\n1#3:707\n26#4:480\n12#4,2:491\n14#4,9:495\n26#4:555\n12#4,2:566\n14#4,9:570\n12#5,2:493\n12#5,2:568\n24#6:507\n14#6,2:518\n17#6,4:524\n24#6:531\n14#6,2:542\n17#6,4:548\n24#6:582\n14#6,2:593\n17#6,4:599\n24#6:606\n14#6,2:617\n17#6,4:623\n24#6:631\n14#6,2:642\n17#6,4:648\n24#6:655\n14#6,2:666\n17#6,4:672\n24#6:686\n14#6,2:697\n17#6,4:703\n14#6,2:710\n17#6,4:716\n12#7,4:520\n12#7,4:544\n12#7,4:595\n12#7,4:619\n12#7,4:644\n12#7,4:668\n12#7,4:699\n12#7,4:712\n382#8,7:679\n*S KotlinDebug\n*F\n+ 1 CrateSerializer.kt\ngg/aquatic/aquaticcrates/plugin/serialize/CrateSerializer\n*L\n167#1:467,9\n167#1:476\n167#1:478\n167#1:479\n173#1:481,9\n173#1:490\n173#1:505\n173#1:506\n319#1:508,9\n319#1:517\n319#1:529\n319#1:530\n321#1:532,9\n321#1:541\n321#1:553\n321#1:554\n323#1:556,9\n323#1:565\n323#1:580\n323#1:581\n330#1:583,9\n330#1:592\n330#1:604\n330#1:605\n334#1:607,9\n334#1:616\n334#1:628\n334#1:629\n395#1:632,9\n395#1:641\n395#1:653\n395#1:654\n397#1:656,9\n397#1:665\n397#1:677\n397#1:678\n414#1:687,9\n414#1:696\n414#1:708\n414#1:709\n239#1:720,2\n249#1:722,2\n167#1:477\n173#1:504\n319#1:528\n321#1:552\n323#1:579\n330#1:603\n334#1:627\n395#1:652\n397#1:676\n414#1:707\n173#1:480\n173#1:491,2\n173#1:495,9\n323#1:555\n323#1:566,2\n323#1:570,9\n173#1:493,2\n323#1:568,2\n319#1:507\n319#1:518,2\n319#1:524,4\n321#1:531\n321#1:542,2\n321#1:548,4\n330#1:582\n330#1:593,2\n330#1:599,4\n334#1:606\n334#1:617,2\n334#1:623,4\n395#1:631\n395#1:642,2\n395#1:648,4\n397#1:655\n397#1:666,2\n397#1:672,4\n414#1:686\n414#1:697,2\n414#1:703,4\n460#1:710,2\n460#1:716,4\n319#1:520,4\n321#1:544,4\n330#1:595,4\n334#1:619,4\n395#1:644,4\n397#1:668,4\n414#1:699,4\n460#1:712,4\n414#1:679,7\n*E\n"})
public final class CrateSerializer extends BaseSerializer {
   @NotNull
   public static final CrateSerializer INSTANCE = new CrateSerializer();
   @NotNull
   private static final HashMap<String, AnimationSettingsFactory> animationSerializers;
   @NotNull
   private static final HashMap<String, InputSettingsFactory> rerollInputSerializers;

   private CrateSerializer() {
   }

   @NotNull
   public final HashMap<String, AnimationSettingsFactory> getAnimationSerializers() {
      return animationSerializers;
   }

   @NotNull
   public final HashMap<String, InputSettingsFactory> getRerollInputSerializers() {
      return rerollInputSerializers;
   }

   @NotNull
   public final PluginSettings loadPluginSettings() {
      Config var1 = new Config("config.yml", (JavaPlugin)CratesPlugin.Companion.getINSTANCE());
      var1.load();
      FileConfiguration var10000 = var1.getConfiguration();
      Intrinsics.checkNotNull(var10000);
      FileConfiguration var2 = var10000;
      boolean var3 = var2.getBoolean("use-rewards-menu", true);
      boolean var4 = var2.getBoolean("log-openings", true);
      int var5 = var2.getInt("reward-threshold", 50);
      return new PluginSettings(var3, var4, var5);
   }

   @NotNull
   public final LogMenuSettings loadLogMenuSettings() {
      Config var1 = new Config("config.yml", (JavaPlugin)CratesPlugin.Companion.getINSTANCE());
      var1.load();
      FileConfiguration var10000 = var1.getConfiguration();
      Intrinsics.checkNotNull(var10000);
      FileConfiguration var2 = var10000;
      ConfigurationSection var5 = var2.getConfigurationSection("log-menu");
      if (var5 == null) {
         return new LogMenuSettings(new PrivateMenuSettings(InventoryType.GENERIC9X1, StringExtKt.toMMComponent("Example Title"), new HashMap()), (Collection)CollectionsKt.emptyList());
      } else {
         ConfigurationSection var3 = var5;
         PrivateMenuSettings var4 = MenuSerializer.INSTANCE.loadPrivateInventory(var3);
         MenuSerializer var10003 = MenuSerializer.INSTANCE;
         List var10004 = var3.getStringList("log-slots");
         Intrinsics.checkNotNullExpressionValue(var10004, "getStringList(...)");
         return new LogMenuSettings(var4, (Collection)var10003.loadSlotSelection(var10004).getSlots());
      }
   }

   @NotNull
   public final RewardsMenuSettings loadRewardMenuSettings() {
      Config var1 = new Config("config.yml", (JavaPlugin)CratesPlugin.Companion.getINSTANCE());
      var1.load();
      FileConfiguration var10000 = var1.getConfiguration();
      Intrinsics.checkNotNull(var10000);
      FileConfiguration var2 = var10000;
      ConfigurationSection var7 = var2.getConfigurationSection("reward-menu");
      if (var7 == null) {
         return new RewardsMenuSettings(new PrivateMenuSettings(InventoryType.GENERIC9X1, StringExtKt.toMMComponent("Example Title"), new HashMap()), (Collection)CollectionsKt.emptyList(), CollectionsKt.emptyList());
      } else {
         ConfigurationSection var3 = var7;
         PrivateMenuSettings var4 = MenuSerializer.INSTANCE.loadPrivateInventory(var3);
         MenuSerializer var8 = MenuSerializer.INSTANCE;
         List var10001 = var3.getStringList("reward-slots");
         Intrinsics.checkNotNullExpressionValue(var10001, "getStringList(...)");
         SlotSelection var5 = var8.loadSlotSelection(var10001);
         List var9 = var3.getStringList("append-lore");
         Intrinsics.checkNotNullExpressionValue(var9, "getStringList(...)");
         List var6 = var9;
         return new RewardsMenuSettings(var4, (Collection)var5.getSlots(), var6);
      }
   }

   @NotNull
   public final HashMap<String, Crate> loadCrates() {
      CratesPlugin.Companion.getINSTANCE().getDataFolder().mkdirs();
      HashMap var1 = new HashMap();
      File var2 = new File(CratesPlugin.Companion.getINSTANCE().getDataFolder(), "crates");
      var2.mkdirs();
      ((Map)var1).putAll((Map)this.loadBasicCrates(var2));
      return var1;
   }

   @NotNull
   public final HashMap<String, BasicCrate> loadBasicCrates(@NotNull File var1) {
      Intrinsics.checkNotNullParameter(var1, "folder");
      HashMap var2 = new HashMap();
      File[] var10000 = var1.listFiles();
      Intrinsics.checkNotNull(var10000);
      File[] var3 = var10000;
      int var4 = 0;

      for(int var5 = var3.length; var4 < var5; ++var4) {
         File var6 = var3[var4];
         if (var6.isDirectory()) {
            Map var8 = (Map)var2;
            Intrinsics.checkNotNull(var6);
            var8.putAll((Map)this.loadBasicCrates(var6));
         } else {
            Intrinsics.checkNotNull(var6);
            BasicCrate var9 = this.loadBasicCrate(var6);
            if (var9 != null) {
               BasicCrate var7 = var9;
               ((Map)var2).put(var7.getIdentifier(), var7);
            }
         }
      }

      return var2;
   }

   @Nullable
   public final BasicCrate loadBasicCrate(@NotNull File var1) {
      Intrinsics.checkNotNullParameter(var1, "file");
      String var2 = FilesKt.getNameWithoutExtension(var1);
      Config var3 = new Config(var1, (JavaPlugin)CratesPlugin.Companion.getINSTANCE());
      var3.load();
      FileConfiguration var10000 = var3.getConfiguration();
      Intrinsics.checkNotNull(var10000);
      FileConfiguration var4 = var10000;
      List var5 = ConfigExtKt.getSectionList((ConfigurationSection)var4, "interactables");
      Iterable var7 = (Iterable)var5;
      boolean var8 = false;
      Collection var10 = (Collection)(new ArrayList());
      boolean var11 = false;
      boolean var13 = false;
      Iterator var14 = var7.iterator();

      boolean var17;
      boolean var21;
      while(var14.hasNext()) {
         Object var15 = var14.next();
         var17 = false;
         ConfigurationSection var18 = (ConfigurationSection)var15;
         boolean var19 = false;
         InteractableSettings var213 = InteractableSerializer.INSTANCE.load(var18);
         if (var213 != null) {
            InteractableSettings var20 = var213;
            var21 = false;
            var10.add(var20);
         }
      }

      List var6 = CollectionsKt.toMutableList((Collection)((List)var10));
      if (var6.isEmpty()) {
         Collection var68 = (Collection)var6;
         BlockData var10004 = Material.STONE.createBlockData();
         Intrinsics.checkNotNullExpressionValue(var10004, "createBlockData(...)");
         var68.add(new BlockInteractableSettings((AquaticBlock)(new VanillaBlock(var10004)), new Vector()));
      }

      RequirementSerializer var70 = RequirementSerializer.INSTANCE;
      List var9 = ConfigExtKt.getSectionList((ConfigurationSection)var4, "open-requirements");
      boolean var73 = false;
      Iterable var75 = (Iterable)var9;
      boolean var12 = false;
      Collection var80 = (Collection)(new ArrayList());
      boolean var83 = false;
      var17 = false;
      Iterator var87 = var75.iterator();

      boolean var33;
      String var214;
      ConfiguredRequirement var215;
      Map var216;
      ExecutableObject var217;
      while(var87.hasNext()) {
         Object var90 = var87.next();
         var21 = false;
         ConfigurationSection var22 = (ConfigurationSection)var90;
         boolean var23 = false;
         RequirementSerializer var24 = RequirementSerializer.INSTANCE;
         boolean var25 = false;
         var214 = var22.getString("type");
         if (var214 == null) {
            var215 = null;
         } else {
            String var26 = var214;
            WavesRegistry var27 = WavesRegistry.INSTANCE;
            boolean var28 = false;
            var216 = (Map)var27.getREQUIREMENT().get(Player.class);
            if (var216 == null) {
               var217 = null;
            } else {
               Map var29 = var216;
               var217 = (ExecutableObject)var29.get(var26);
               if (var217 == null) {
                  var217 = null;
               } else {
                  ExecutableObject var30 = var217;
                  var217 = var30 instanceof ExecutableObject ? var30 : null;
               }
            }

            ExecutableObject var31 = var217;
            if (var31 == null) {
               System.out.println("[Waves] Action type " + var26 + " does not exist!");
               var215 = null;
            } else {
               ObjectArguments var112 = AquaticObjectArgument.Companion.loadRequirementArguments(var22, var31.getArguments());
               ConfiguredRequirement var115 = new ConfiguredRequirement(var31, var112);
               var215 = var115;
            }
         }

         if (var215 != null) {
            ConfiguredRequirement var32 = var215;
            var33 = false;
            var80.add(var32);
         }
      }

      List var69;
      ConfigurationSection var71;
      label335: {
         var69 = CollectionsKt.toMutableList((Collection)((List)var80));
         var71 = var4.getConfigurationSection("reroll");
         if (var71 != null) {
            var214 = var71.getString("type");
            if (var214 != null) {
               break label335;
            }
         }

         var214 = "inventory";
      }

      String var72 = var214;
      HashMap var218 = rerollInputSerializers;
      String var10001 = var72.toLowerCase(Locale.ROOT);
      Intrinsics.checkNotNullExpressionValue(var10001, "toLowerCase(...)");
      InputSettingsFactory var219 = (InputSettingsFactory)var218.get(var10001);
      if (var219 == null) {
         var219 = (InputSettingsFactory)InventoryRerollInput.Companion;
      }

      InputSettingsFactory var74 = var219;
      Function1 var76 = CrateSerializer::loadBasicCrate$lambda$1;
      ConfigurationSection var77 = var4.getConfigurationSection("key");
      if (var77 == null) {
         String[] var79 = new String[]{"Could not load Key! (Path: key)"};
         this.sendConsoleMessage(var79);
         return null;
      } else {
         AquaticItem var78 = ItemStackExtKt.loadFromYml(AquaticItem.Companion, var77);
         if (var78 == null) {
            String[] var82 = new String[]{"Could not load Key Item! (Path: key)"};
            this.sendConsoleMessage(var82);
            return null;
         } else {
            EnumMap var81 = this.loadInteractActions(var77.getConfigurationSection("interaction"));
            Function1 var84 = CrateSerializer::loadBasicCrate$lambda$3;
            ConfigurationSection var16 = var4.getConfigurationSection("rewards");
            if (var16 == null) {
               String[] var86 = new String[]{"Could not load Rewards! (Path: rewards)"};
               this.sendConsoleMessage(var86);
               return null;
            } else {
               HashMap var88 = new HashMap();
               boolean var92 = false;
               Map var95 = (Map)var88;
               Pair var96 = TuplesKt.to("default", new RewardRarity("default", "Default", 100.0D));
               var95.put(var96.getFirst(), var96.getSecond());
               HashMap var85 = var88;
               ConfigurationSection var220 = var4.getConfigurationSection("rarities");
               ConfigurationSection var105;
               if (var220 != null) {
                  ConfigurationSection var93 = var220;
                  var21 = false;
                  Iterator var98 = var93.getKeys(false).iterator();

                  while(var98.hasNext()) {
                     String var100 = (String)var98.next();
                     var220 = var93.getConfigurationSection(var100);
                     if (var220 != null) {
                        var105 = var220;
                        var214 = var105.getString("display-name");
                        if (var214 == null) {
                           var214 = var100;
                        }

                        String var107 = var214;
                        double var110 = var105.getDouble("chance", 1.0D);
                        var216 = (Map)var85;
                        Intrinsics.checkNotNull(var100);
                        Intrinsics.checkNotNull(var107);
                        var216.put(var100, new RewardRarity(var100, var107, var110));
                     }
                  }

                  Unit var221 = Unit.INSTANCE;
                  var221 = Unit.INSTANCE;
               } else {
                  var10000 = null;
               }

               Function1 var89 = CrateSerializer::loadBasicCrate$lambda$10;
               Function1 var91 = CrateSerializer::loadBasicCrate$lambda$11;
               ArrayList var94 = new ArrayList();
               ConfigurationSection var97 = var4.getConfigurationSection("preview");
               if (var97 != null) {
                  if (!var97.contains("pages")) {
                     CratePreviewMenuSettings var99 = this.loadCratePreviewMenuSettings(var97);
                     ((Collection)var94).add(var99);
                  } else {
                     List var101 = ConfigExtKt.getSectionList(var97, "pages");
                     Iterator var103 = var101.iterator();

                     while(var103.hasNext()) {
                        var105 = (ConfigurationSection)var103.next();
                        CratePreviewMenuSettings var108 = this.loadCratePreviewMenuSettings(var105);
                        ((Collection)var94).add(var108);
                     }
                  }
               }

               var214 = var4.getString("animation.type", "instant");
               Intrinsics.checkNotNull(var214);
               var214 = var214.toLowerCase(Locale.ROOT);
               Intrinsics.checkNotNullExpressionValue(var214, "toLowerCase(...)");
               String var102 = var214;
               AnimationSettingsFactory var222 = (AnimationSettingsFactory)animationSerializers.get(var102);
               if (var222 == null) {
                  var222 = (AnimationSettingsFactory)InstantAnimationSettings.Companion;
               }

               AnimationSettingsFactory var104 = var222;
               CrateAnimationSettings var223 = var104.serialize(var4.getConfigurationSection("animation"));
               if (var223 == null) {
                  var223 = InstantAnimationSettings.Companion.serialize((ConfigurationSection)null);
               }

               CrateAnimationSettings var106 = var223;
               Bukkit.getConsoleSender().sendMessage("Loaded " + var106.getAnimationTasks().size() + " animation tasks");
               ConfigurationSection var109 = var4.getConfigurationSection("guaranteed-rewards");
               HashMap var111 = new HashMap();
               if (var109 != null) {
                  Iterator var113 = var109.getKeys(false).iterator();

                  while(var113.hasNext()) {
                     String var116 = (String)var113.next();
                     Intrinsics.checkNotNull(var116);
                     Integer var224 = StringsKt.toIntOrNull(var116);
                     if (var224 != null) {
                        int var118 = var224;
                        var220 = var109.getConfigurationSection(var116);
                        if (var220 != null) {
                           ConfigurationSection var122 = var220;
                           Reward var225 = this.loadReward(var122, var85);
                           if (var225 != null) {
                              Reward var126 = var225;
                              Map var131 = (Map)var111;
                              Pair var136 = TuplesKt.to(var118, var126);
                              var131.put(var136.getFirst(), var136.getSecond());
                           }
                        }
                     }
                  }
               }

               ActionSerializer var117 = ActionSerializer.INSTANCE;
               List var120 = ConfigExtKt.getSectionList((ConfigurationSection)var4, "mass-open.final-tasks");
               boolean var123 = false;
               Iterable var127 = (Iterable)var120;
               boolean var132 = false;
               Collection var34 = (Collection)(new ArrayList());
               boolean var35 = false;
               boolean var37 = false;
               Iterator var38 = var127.iterator();

               boolean var43;
               boolean var45;
               boolean var48;
               ExecutableObject var51;
               ConfiguredExecutableObject var226;
               while(var38.hasNext()) {
                  Object var39 = var38.next();
                  boolean var41 = false;
                  ConfigurationSection var42 = (ConfigurationSection)var39;
                  var43 = false;
                  ActionSerializer var44 = ActionSerializer.INSTANCE;
                  var45 = false;
                  var214 = var42.getString("type");
                  if (var214 == null) {
                     var226 = null;
                  } else {
                     String var46 = var214;
                     WavesRegistry var47 = WavesRegistry.INSTANCE;
                     var48 = false;
                     var216 = (Map)var47.getACTION().get(Player.class);
                     if (var216 == null) {
                        var217 = null;
                     } else {
                        Map var49 = var216;
                        var217 = (ExecutableObject)var49.get(var46);
                        if (var217 == null) {
                           var217 = null;
                        } else {
                           ExecutableObject var50 = var217;
                           var217 = var50 instanceof ExecutableObject ? var50 : null;
                        }
                     }

                     if (var217 == null) {
                        var226 = null;
                     } else {
                        var51 = var217;
                        ObjectArguments var52 = AquaticObjectArgument.Companion.loadRequirementArguments(var42, var51.getArguments());
                        ConfiguredExecutableObject var177 = new ConfiguredExecutableObject(var51, var52);
                        var226 = var177;
                     }
                  }

                  if (var226 != null) {
                     ConfiguredExecutableObject var53 = var226;
                     boolean var54 = false;
                     var34.add(var53);
                  }
               }

               List var114 = CollectionsKt.toMutableList((Collection)((List)var34));
               ActionSerializer var121 = ActionSerializer.INSTANCE;
               List var124 = ConfigExtKt.getSectionList((ConfigurationSection)var4, "mass-open.per-reward-tasks");
               boolean var129 = false;
               Iterable var134 = (Iterable)var124;
               var33 = false;
               Collection var147 = (Collection)(new ArrayList());
               boolean var36 = false;
               boolean var156 = false;
               Iterator var159 = var134.iterator();

               boolean var55;
               boolean var167;
               boolean var169;
               ExecutableObject var194;
               ConfiguredExecutableObject var201;
               while(var159.hasNext()) {
                  Object var40 = var159.next();
                  var167 = false;
                  ConfigurationSection var168 = (ConfigurationSection)var40;
                  var169 = false;
                  ActionSerializer var172 = ActionSerializer.INSTANCE;
                  boolean var173 = false;
                  var214 = var168.getString("type");
                  if (var214 == null) {
                     var226 = null;
                  } else {
                     String var178 = var214;
                     WavesRegistry var180 = WavesRegistry.INSTANCE;
                     boolean var183 = false;
                     var216 = (Map)var180.getACTION().get(Player.class);
                     if (var216 == null) {
                        var217 = null;
                     } else {
                        Map var187 = var216;
                        var217 = (ExecutableObject)var187.get(var178);
                        if (var217 == null) {
                           var217 = null;
                        } else {
                           var51 = var217;
                           var217 = var51 instanceof ExecutableObject ? var51 : null;
                        }
                     }

                     if (var217 == null) {
                        var226 = null;
                     } else {
                        var194 = var217;
                        ObjectArguments var197 = AquaticObjectArgument.Companion.loadRequirementArguments(var168, var194.getArguments());
                        ConfiguredExecutableObject var181 = new ConfiguredExecutableObject(var194, var197);
                        var226 = var181;
                     }
                  }

                  if (var226 != null) {
                     var201 = var226;
                     var55 = false;
                     var147.add(var201);
                  }
               }

               List var119 = CollectionsKt.toMutableList((Collection)((List)var147));
               RequirementSerializer var125 = RequirementSerializer.INSTANCE;
               List var130 = ConfigExtKt.getSectionList((ConfigurationSection)var4, "open-restrictions");
               var132 = false;
               Iterable var138 = (Iterable)var130;
               boolean var140 = false;
               Collection var151 = (Collection)(new ArrayList());
               var37 = false;
               boolean var160 = false;
               Iterator var162 = var138.iterator();

               boolean var179;
               boolean var189;
               while(var162.hasNext()) {
                  Object var164 = var162.next();
                  var43 = false;
                  ConfigurationSection var170 = (ConfigurationSection)var164;
                  var45 = false;
                  RequirementSerializer var175 = RequirementSerializer.INSTANCE;
                  var179 = false;
                  var214 = var170.getString("type");
                  if (var214 == null) {
                     var215 = null;
                  } else {
                     String var182 = var214;
                     WavesRegistry var185 = WavesRegistry.INSTANCE;
                     var189 = false;
                     var216 = (Map)var185.getREQUIREMENT().get(OpenData.class);
                     if (var216 == null) {
                        var217 = null;
                     } else {
                        Map var192 = var216;
                        var217 = (ExecutableObject)var192.get(var182);
                        if (var217 == null) {
                           var217 = null;
                        } else {
                           var194 = var217;
                           var217 = var194 instanceof ExecutableObject ? var194 : null;
                        }
                     }

                     ExecutableObject var199 = var217;
                     if (var199 == null) {
                        System.out.println("[Waves] Action type " + var182 + " does not exist!");
                        var215 = null;
                     } else {
                        ObjectArguments var186 = AquaticObjectArgument.Companion.loadRequirementArguments(var170, var199.getArguments());
                        ConfiguredRequirement var191 = new ConfiguredRequirement(var199, var186);
                        var215 = var191;
                     }
                  }

                  if (var215 != null) {
                     ConfiguredRequirement var203 = var215;
                     var55 = false;
                     var151.add(var203);
                  }
               }

               var120 = CollectionsKt.toMutableList((Collection)((List)var151));
               ArrayList var128 = new ArrayList();
               Iterator var133 = ConfigExtKt.getSectionList((ConfigurationSection)var4, "open-price-groups").iterator();

               OpenPriceGroup var152;
               while(var133.hasNext()) {
                  ConfigurationSection var137 = (ConfigurationSection)var133.next();
                  ArrayList var141 = new ArrayList();
                  Iterator var143 = ConfigExtKt.getSectionList(var137, "prices").iterator();

                  while(true) {
                     while(var143.hasNext()) {
                        ConfigurationSection var149 = (ConfigurationSection)var143.next();
                        ConfiguredPrice var227 = PriceSerializer.INSTANCE.fromSection(var149);
                        if (var227 != null) {
                           ConfiguredPrice var153 = var227;
                           ActionSerializer var157 = ActionSerializer.INSTANCE;
                           List var161 = ConfigExtKt.getSectionList(var149, "fail-actions");
                           boolean var163 = false;
                           Iterable var165 = (Iterable)var161;
                           var167 = false;
                           Collection var171 = (Collection)(new ArrayList());
                           var45 = false;
                           var179 = false;
                           Iterator var184 = var165.iterator();

                           while(var184.hasNext()) {
                              Object var188 = var184.next();
                              boolean var193 = false;
                              ConfigurationSection var196 = (ConfigurationSection)var188;
                              boolean var200 = false;
                              ActionSerializer var204 = ActionSerializer.INSTANCE;
                              var55 = false;
                              var214 = var196.getString("type");
                              if (var214 == null) {
                                 var226 = null;
                              } else {
                                 String var56 = var214;
                                 WavesRegistry var57 = WavesRegistry.INSTANCE;
                                 boolean var58 = false;
                                 var216 = (Map)var57.getACTION().get(Player.class);
                                 if (var216 == null) {
                                    var217 = null;
                                 } else {
                                    Map var59 = var216;
                                    var217 = (ExecutableObject)var59.get(var56);
                                    if (var217 == null) {
                                       var217 = null;
                                    } else {
                                       ExecutableObject var60 = var217;
                                       var217 = var60 instanceof ExecutableObject ? var60 : null;
                                    }
                                 }

                                 if (var217 == null) {
                                    var226 = null;
                                 } else {
                                    ExecutableObject var61 = var217;
                                    ObjectArguments var62 = AquaticObjectArgument.Companion.loadRequirementArguments(var196, var61.getArguments());
                                    ConfiguredExecutableObject var207 = new ConfiguredExecutableObject(var61, var62);
                                    var226 = var207;
                                 }
                              }

                              if (var226 != null) {
                                 ConfiguredExecutableObject var63 = var226;
                                 boolean var64 = false;
                                 var171.add(var63);
                              }
                           }

                           List var155 = (List)var171;
                           ((Collection)var141).add(new OpenPrice(var153, CollectionsKt.toMutableList((Collection)var155)));
                        }
                     }

                     ActionSerializer var150 = ActionSerializer.INSTANCE;
                     List var154 = ConfigExtKt.getSectionList(var137, "fail-actions");
                     var37 = false;
                     Iterable var158 = (Iterable)var154;
                     var160 = false;
                     Collection var166 = (Collection)(new ArrayList());
                     var167 = false;
                     var169 = false;
                     Iterator var174 = var158.iterator();

                     while(var174.hasNext()) {
                        Object var176 = var174.next();
                        var48 = false;
                        ConfigurationSection var190 = (ConfigurationSection)var176;
                        var189 = false;
                        ActionSerializer var195 = ActionSerializer.INSTANCE;
                        boolean var198 = false;
                        var214 = var190.getString("type");
                        if (var214 == null) {
                           var226 = null;
                        } else {
                           String var202 = var214;
                           WavesRegistry var205 = WavesRegistry.INSTANCE;
                           var55 = false;
                           var216 = (Map)var205.getACTION().get(Player.class);
                           if (var216 == null) {
                              var217 = null;
                           } else {
                              Map var206 = var216;
                              var217 = (ExecutableObject)var206.get(var202);
                              if (var217 == null) {
                                 var217 = null;
                              } else {
                                 ExecutableObject var208 = var217;
                                 var217 = var208 instanceof ExecutableObject ? var208 : null;
                              }
                           }

                           if (var217 == null) {
                              var226 = null;
                           } else {
                              ExecutableObject var209 = var217;
                              ObjectArguments var210 = AquaticObjectArgument.Companion.loadRequirementArguments(var190, var209.getArguments());
                              var201 = new ConfiguredExecutableObject(var209, var210);
                              var226 = var201;
                           }
                        }

                        if (var226 != null) {
                           ConfiguredExecutableObject var211 = var226;
                           boolean var212 = false;
                           var166.add(var211);
                        }
                     }

                     List var146 = (List)var166;
                     var152 = new OpenPriceGroup(CollectionsKt.toMutableList((Collection)var141), CollectionsKt.toMutableList((Collection)var146));
                     ((Collection)var128).add(var152);
                     break;
                  }
               }

               if (var128.isEmpty()) {
                  Collection var135 = (Collection)var128;
                  OpenPrice[] var139 = new OpenPrice[1];
                  Pair[] var144 = new Pair[]{TuplesKt.to("crate", var2)};
                  var139[0] = new OpenPrice(new ConfiguredPrice(new ObjectArguments((Map)MapsKt.hashMapOf(var144)), (Price)(new CrateKeyPrice())), (List)(new ArrayList()));
                  var135.add(new OpenPriceGroup(CollectionsKt.mutableListOf(var139), (List)(new ArrayList())));
               }

               ConsoleCommandSender var228 = Bukkit.getConsoleSender();
               var127 = (Iterable)var128;
               ConsoleCommandSender var65 = var228;
               int var142 = 0;

               int var67;
               for(Iterator var145 = var127.iterator(); var145.hasNext(); var142 += var67) {
                  Object var148 = var145.next();
                  var152 = (OpenPriceGroup)var148;
                  var36 = false;
                  var67 = var152.getPrices().size();
               }

               var65.sendMessage("Loaded " + var142 + " open price groups");
               BasicCrate var229 = new BasicCrate;
               String var10003 = var4.getString("display-name");
               if (var10003 == null) {
                  var10003 = var2;
               }

               var229.<init>(var2, var10003, (HologramSettings)HologramSerializer.INSTANCE.loadAquaticHologram(var4.getConfigurationSection("hologram")), var6, var69, (List)var128, CrateSerializer::loadBasicCrate$lambda$14, var84, CrateSerializer::loadBasicCrate$lambda$15, var91, (List)var94, var114, var119, var120);
               return var229;
            }
         }
      }
   }

   private final FailAnimationSettings loadFailAnimationSettings(FileConfiguration var1) {
      ConfigurationSection var10000 = var1.getConfigurationSection("fail-animation");
      if (var10000 == null) {
         return null;
      } else {
         ConfigurationSection var2 = var10000;
         var10000 = var2.getConfigurationSection("actions");
         if (var10000 == null) {
            return null;
         } else {
            ConfigurationSection var3 = var10000;
            TreeMap var4 = new TreeMap();
            Iterator var5 = var3.getKeys(false).iterator();

            while(true) {
               String var6;
               Integer var46;
               do {
                  if (!var5.hasNext()) {
                     int var37 = var2.getInt("length", -1);
                     if (var37 < 0) {
                        return null;
                     }

                     return new FailAnimationSettings(var4, var37);
                  }

                  var6 = (String)var5.next();
                  Intrinsics.checkNotNull(var6);
                  var46 = StringsKt.toIntOrNull(var6);
               } while(var46 == null);

               int var7 = var46;
               ActionSerializer var9 = ActionSerializer.INSTANCE;
               List var10 = ConfigExtKt.getSectionList(var3, var6);
               boolean var11 = false;
               Iterable var12 = (Iterable)var10;
               boolean var13 = false;
               Collection var15 = (Collection)(new ArrayList());
               boolean var16 = false;
               boolean var18 = false;
               Iterator var19 = var12.iterator();

               ExecutableObject var32;
               String var47;
               ConfiguredExecutableObject var48;
               Map var49;
               ExecutableObject var50;
               while(var19.hasNext()) {
                  Object var20 = var19.next();
                  boolean var22 = false;
                  ConfigurationSection var23 = (ConfigurationSection)var20;
                  boolean var24 = false;
                  ActionSerializer var25 = ActionSerializer.INSTANCE;
                  boolean var26 = false;
                  var47 = var23.getString("type");
                  if (var47 == null) {
                     var48 = null;
                  } else {
                     String var27 = var47;
                     WavesRegistry var28 = WavesRegistry.INSTANCE;
                     boolean var29 = false;
                     var49 = (Map)var28.getACTION().get(Animation.class);
                     if (var49 == null) {
                        var50 = null;
                     } else {
                        Map var30 = var49;
                        var50 = (ExecutableObject)var30.get(var27);
                        if (var50 == null) {
                           var50 = null;
                        } else {
                           ExecutableObject var31 = var50;
                           var50 = var31 instanceof ExecutableObject ? var31 : null;
                        }
                     }

                     if (var50 == null) {
                        var48 = null;
                     } else {
                        var32 = var50;
                        ObjectArguments var33 = AquaticObjectArgument.Companion.loadRequirementArguments(var23, var32.getArguments());
                        ConfiguredExecutableObject var58 = new ConfiguredExecutableObject(var32, var33);
                        var48 = var58;
                     }
                  }

                  if (var48 != null) {
                     ConfiguredExecutableObject var34 = var48;
                     boolean var35 = false;
                     var15.add(var34);
                  }
               }

               List var8 = (List)var15;
               ActionSerializer var39 = ActionSerializer.INSTANCE;
               List var41 = ConfigExtKt.getSectionList(var3, var6);
               boolean var42 = false;
               Iterable var44 = (Iterable)var41;
               boolean var14 = false;
               Collection var45 = (Collection)(new ArrayList());
               boolean var17 = false;
               boolean var51 = false;
               Iterator var52 = var44.iterator();

               while(var52.hasNext()) {
                  Object var21 = var52.next();
                  boolean var53 = false;
                  ConfigurationSection var54 = (ConfigurationSection)var21;
                  boolean var55 = false;
                  ActionSerializer var56 = ActionSerializer.INSTANCE;
                  boolean var57 = false;
                  var47 = var54.getString("type");
                  if (var47 == null) {
                     var48 = null;
                  } else {
                     String var59 = var47;
                     WavesRegistry var60 = WavesRegistry.INSTANCE;
                     boolean var62 = false;
                     var49 = (Map)var60.getACTION().get(PlayerBoundAnimation.class);
                     if (var49 == null) {
                        var50 = null;
                     } else {
                        Map var63 = var49;
                        var50 = (ExecutableObject)var63.get(var59);
                        if (var50 == null) {
                           var50 = null;
                        } else {
                           var32 = var50;
                           var50 = var32 instanceof ExecutableObject ? var32 : null;
                        }
                     }

                     if (var50 == null) {
                        var48 = null;
                     } else {
                        ExecutableObject var64 = var50;
                        ObjectArguments var65 = AquaticObjectArgument.Companion.loadRequirementArguments(var54, var64.getArguments());
                        ConfiguredExecutableObject var61 = new ConfiguredExecutableObject(var64, var65);
                        var48 = var61;
                     }
                  }

                  if (var48 != null) {
                     ConfiguredExecutableObject var66 = var48;
                     boolean var36 = false;
                     var45.add(var66);
                  }
               }

               List var38 = (List)var45;
               CrateAnimationActions var40 = new CrateAnimationActions((Collection)CollectionsKt.toMutableList((Collection)var8), (Collection)CollectionsKt.toMutableList((Collection)var38));
               Integer var43 = var7;
               ((Map)var4).put(var43, var40);
            }
         }
      }
   }

   private final List<IdleAnimationSettings> loadIdleAnimationSettings(FileConfiguration var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = ConfigExtKt.getSectionList((ConfigurationSection)var1, "idle-animations").iterator();

      while(true) {
         label70:
         while(var3.hasNext()) {
            ConfigurationSection var4 = (ConfigurationSection)var3.next();
            ConfigurationSection var10000 = var4.getConfigurationSection("actions");
            if (var10000 != null) {
               ConfigurationSection var5 = var10000;
               TreeMap var6 = new TreeMap();
               Iterator var7 = var5.getKeys(false).iterator();

               while(true) {
                  String var8;
                  Integer var48;
                  do {
                     if (!var7.hasNext()) {
                        boolean var38 = var4.getBoolean("loop", false);
                        int var39 = var4.getInt("length", -1);
                        double var40 = var4.getDouble("chance", 1.0D);
                        if (var39 >= 0) {
                           ((Collection)var2).add(new IdleAnimationSettings(var6, var39, var38, var40));
                           Bukkit.getConsoleSender().sendMessage("Loaded idle animation with " + var6.size() + " tasks");
                        }
                        continue label70;
                     }

                     var8 = (String)var7.next();
                     Intrinsics.checkNotNull(var8);
                     var48 = StringsKt.toIntOrNull(var8);
                  } while(var48 == null);

                  int var9 = var48;
                  Map var10 = (Map)var6;
                  Integer var11 = var9;
                  boolean var12 = false;
                  Object var13 = var10.get(var11);
                  Object var50;
                  if (var13 == null) {
                     boolean var14 = false;
                     List var49 = Collections.synchronizedList((List)(new ArrayList()));
                     Intrinsics.checkNotNullExpressionValue(var49, "synchronizedList(...)");
                     List var46 = var49;
                     var10.put(var11, var46);
                     var50 = var46;
                  } else {
                     var50 = var13;
                  }

                  Collection var41 = (Collection)var50;
                  ActionSerializer var42 = ActionSerializer.INSTANCE;
                  List var44 = ConfigExtKt.getSectionList(var5, var8);
                  boolean var45 = false;
                  Iterable var47 = (Iterable)var44;
                  boolean var15 = false;
                  Collection var17 = (Collection)(new ArrayList());
                  boolean var18 = false;
                  boolean var20 = false;
                  Iterator var21 = var47.iterator();

                  while(var21.hasNext()) {
                     Object var22 = var21.next();
                     boolean var24 = false;
                     ConfigurationSection var25 = (ConfigurationSection)var22;
                     boolean var26 = false;
                     ActionSerializer var27 = ActionSerializer.INSTANCE;
                     boolean var28 = false;
                     String var51 = var25.getString("type");
                     ConfiguredExecutableObject var52;
                     if (var51 == null) {
                        var52 = null;
                     } else {
                        String var29 = var51;
                        WavesRegistry var30 = WavesRegistry.INSTANCE;
                        boolean var31 = false;
                        Map var53 = (Map)var30.getACTION().get(Animation.class);
                        ExecutableObject var54;
                        if (var53 == null) {
                           var54 = null;
                        } else {
                           Map var32 = var53;
                           var54 = (ExecutableObject)var32.get(var29);
                           if (var54 == null) {
                              var54 = null;
                           } else {
                              ExecutableObject var33 = var54;
                              var54 = var33 instanceof ExecutableObject ? var33 : null;
                           }
                        }

                        if (var54 == null) {
                           var52 = null;
                        } else {
                           ExecutableObject var34 = var54;
                           ObjectArguments var35 = AquaticObjectArgument.Companion.loadRequirementArguments(var25, var34.getArguments());
                           ConfiguredExecutableObject var55 = new ConfiguredExecutableObject(var34, var35);
                           var52 = var55;
                        }
                     }

                     if (var52 != null) {
                        ConfiguredExecutableObject var36 = var52;
                        boolean var37 = false;
                        var17.add(var36);
                     }
                  }

                  Iterable var43 = (Iterable)((List)var17);
                  CollectionsKt.addAll(var41, var43);
               }
            }
         }

         return (List)var2;
      }
   }

   private final CratePreviewMenuSettings loadCratePreviewMenuSettings(ConfigurationSection var1) {
      MenuSerializer var10000 = MenuSerializer.INSTANCE;
      List var10001 = var1.getStringList("reward-slots");
      Intrinsics.checkNotNullExpressionValue(var10001, "getStringList(...)");
      SlotSelection var2 = var10000.loadSlotSelection(var10001);
      PrivateMenuSettings var3 = MenuSerializer.INSTANCE.loadPrivateInventory(var1);
      boolean var4 = var1.getBoolean("clear-bottom-inventory", false);
      var10000 = MenuSerializer.INSTANCE;
      var10001 = var1.getStringList("random-rewards.slots");
      Intrinsics.checkNotNullExpressionValue(var10001, "getStringList(...)");
      SlotSelection var5 = var10000.loadSlotSelection(var10001);
      int var6 = var1.getInt("random-rewards.change-duration");
      List var9 = var1.getStringList("reward-lore");
      Intrinsics.checkNotNullExpressionValue(var9, "getStringList(...)");
      List var7 = var9;
      int var8 = var1.getInt("update-reward-items-every", 1);
      return new CratePreviewMenuSettings(var3, var4, (Collection)var2.getSlots(), new CratePreviewMenuSettings.RandomRewardsSettings((Collection)var5.getSlots(), var6), var7, var8);
   }

   @NotNull
   public final EnumMap<InteractType, ConfiguredExecutableObject<CrateInteractAction, Unit>> loadInteractActions(@Nullable ConfigurationSection var1) {
      EnumMap var2 = new EnumMap(InteractType.class);
      if (var1 == null) {
         return var2;
      } else {
         Iterator var3 = var1.getKeys(false).iterator();

         while(var3.hasNext()) {
            String var4 = (String)var3.next();
            ConfigurationSection var10000 = var1.getConfigurationSection(var4);
            if (var10000 != null) {
               ConfigurationSection var5 = var10000;
               Intrinsics.checkNotNull(var4);
               String var18 = var4.toUpperCase(Locale.ROOT);
               Intrinsics.checkNotNullExpressionValue(var18, "toUpperCase(...)");
               InteractType var6 = InteractType.valueOf(var18);
               ActionSerializer var8 = ActionSerializer.INSTANCE;
               boolean var9 = false;
               var18 = var5.getString("type");
               ConfiguredExecutableObject var19;
               if (var18 == null) {
                  var19 = null;
               } else {
                  String var10 = var18;
                  WavesRegistry var11 = WavesRegistry.INSTANCE;
                  boolean var12 = false;
                  Map var20 = (Map)var11.getACTION().get(CrateInteractAction.class);
                  ExecutableObject var21;
                  if (var20 == null) {
                     var21 = null;
                  } else {
                     Map var13 = var20;
                     var21 = (ExecutableObject)var13.get(var10);
                     if (var21 == null) {
                        var21 = null;
                     } else {
                        ExecutableObject var14 = var21;
                        var21 = var14 instanceof ExecutableObject ? var14 : null;
                     }
                  }

                  if (var21 == null) {
                     var19 = null;
                  } else {
                     ExecutableObject var15 = var21;
                     ObjectArguments var16 = AquaticObjectArgument.Companion.loadRequirementArguments(var5, var15.getArguments());
                     ConfiguredExecutableObject var17 = new ConfiguredExecutableObject(var15, var16);
                     var19 = var17;
                  }
               }

               if (var19 != null) {
                  ConfiguredExecutableObject var7 = var19;
                  ((Map)var2).put(var6, var7);
               }
            }
         }

         return var2;
      }
   }

   private static final RerollManagerImpl loadBasicCrate$lambda$1(InputSettingsFactory var0, FileConfiguration var1, ConfigurationSection var2, OpenableCrate var3) {
      Intrinsics.checkNotNullParameter(var3, "crate");
      RerollInput var4 = var0.serialize(var1);
      RerollManagerImpl var12;
      if (var4 != null) {
         HashMap var5;
         Collection var11;
         label28: {
            var5 = new HashMap();
            Bukkit.getConsoleSender().sendMessage("Loading reroll groups:");
            if (var2 != null) {
               ConfigurationSection var10000 = var2.getConfigurationSection("groups");
               if (var10000 != null) {
                  Set var10 = var10000.getKeys(false);
                  if (var10 != null) {
                     var11 = (Collection)var10;
                     break label28;
                  }
               }
            }

            var11 = (Collection)CollectionsKt.emptyList();
         }

         Iterator var6 = var11.iterator();

         while(var6.hasNext()) {
            String var7 = (String)var6.next();
            int var8 = var1.getInt("reroll.groups." + var7);
            if (var8 > 0) {
               Bukkit.getConsoleSender().sendMessage("Loaded " + var7 + " with " + var8);
               Integer var9 = var8;
               ((Map)var5).put(var7, var9);
            }
         }

         var12 = new RerollManagerImpl((Crate)var3, var5, var4);
      } else {
         var12 = null;
      }

      return var12;
   }

   private static final KeyInteractHandler loadBasicCrate$lambda$3$lambda$2(EnumMap var0, KeyImpl var1) {
      Intrinsics.checkNotNullParameter(var1, "key");
      return (KeyInteractHandler)(new KeyInteractHandlerImpl((Key)var1, var0));
   }

   private static final KeyImpl loadBasicCrate$lambda$3(AquaticItem var0, FileConfiguration var1, EnumMap var2, OpenableCrate var3) {
      Intrinsics.checkNotNullParameter(var3, "crate");
      return new KeyImpl((Crate)var3, var0, var1.getBoolean("key.must-be-held", false), CrateSerializer::loadBasicCrate$lambda$3$lambda$2);
   }

   private static final MilestoneManagerImpl loadBasicCrate$lambda$10(FileConfiguration var0, HashMap var1, OpenableCrate var2) {
      Intrinsics.checkNotNullParameter(var2, "crate");
      TreeMap var3 = new TreeMap();
      TreeMap var4 = new TreeMap();
      ConfigurationSection var10000 = var0.getConfigurationSection("milestones");
      ConfigurationSection var5;
      boolean var6;
      Iterable var7;
      boolean var8;
      Iterator var9;
      Object var10;
      String var11;
      boolean var12;
      ConfigurationSection var13;
      String var14;
      int var15;
      Map var16;
      ConfigurationSection var10001;
      Map var17;
      Pair var18;
      Set var19;
      String var20;
      Integer var21;
      CrateSerializer var22;
      if (var10000 != null) {
         var5 = var10000;
         var6 = false;
         var19 = var5.getKeys(false);
         Intrinsics.checkNotNullExpressionValue(var19, "getKeys(...)");
         var7 = (Iterable)var19;
         var8 = false;
         var9 = var7.iterator();

         while(var9.hasNext()) {
            var10 = var9.next();
            var11 = (String)var10;
            var12 = false;
            var10000 = var5.getConfigurationSection(var11);
            if (var10000 != null) {
               var13 = var10000;
               var20 = var13.getString("display-name");
               if (var20 != null) {
                  var14 = var20;
                  Intrinsics.checkNotNull(var11);
                  var21 = StringsKt.toIntOrNull(var11);
                  if (var21 != null) {
                     var15 = var21;
                     var22 = INSTANCE;
                     var10001 = var13.getConfigurationSection("rewards");
                     if (var10001 != null) {
                        var16 = var22.loadRewards(var10001, var1);
                        Bukkit.getConsoleSender().sendMessage("Loaded milestone " + var15 + " with " + var16.size() + " rewards");
                        var17 = (Map)var3;
                        var18 = TuplesKt.to(var15, new Milestone(var15, StringExtKt.toMMComponent(var14), CollectionsKt.toList((Iterable)var16.values())));
                        var17.put(var18.getFirst(), var18.getSecond());
                     }
                  }
               }
            }
         }
      }

      var10000 = var0.getConfigurationSection("repeatable-milestones");
      if (var10000 != null) {
         var5 = var10000;
         var6 = false;
         var19 = var5.getKeys(false);
         Intrinsics.checkNotNullExpressionValue(var19, "getKeys(...)");
         var7 = (Iterable)var19;
         var8 = false;
         var9 = var7.iterator();

         while(var9.hasNext()) {
            var10 = var9.next();
            var11 = (String)var10;
            var12 = false;
            var10000 = var5.getConfigurationSection(var11);
            if (var10000 != null) {
               var13 = var10000;
               var20 = var13.getString("display-name");
               if (var20 != null) {
                  var14 = var20;
                  Intrinsics.checkNotNull(var11);
                  var21 = StringsKt.toIntOrNull(var11);
                  if (var21 != null) {
                     var15 = var21;
                     var22 = INSTANCE;
                     var10001 = var13.getConfigurationSection("rewards");
                     if (var10001 != null) {
                        var16 = var22.loadRewards(var10001, var1);
                        Bukkit.getConsoleSender().sendMessage("Loaded repeatable milestone " + var15 + " with " + var16.size() + " rewards");
                        var17 = (Map)var4;
                        var18 = TuplesKt.to(var15, new Milestone(var15, StringExtKt.toMMComponent(var14), CollectionsKt.toList((Iterable)var16.values())));
                        var17.put(var18.getFirst(), var18.getSecond());
                     }
                  }
               }
            }
         }
      }

      return new MilestoneManagerImpl(var2, var3, var4);
   }

   private static final BasicCrateInteractHandler loadBasicCrate$lambda$11(FileConfiguration var0, OpenableCrate var1) {
      Intrinsics.checkNotNullParameter(var1, "crate");
      EnumMap var2 = INSTANCE.loadInteractActions(var0.getConfigurationSection("interaction"));
      if (var2.isEmpty()) {
         Map var3 = (Map)var2;
         Pair var4 = TuplesKt.to(InteractType.LEFT, new ConfiguredExecutableObject((ExecutableObject)(new CratePreviewAction()), new ObjectArguments(MapsKt.emptyMap())));
         var3.put(var4.getFirst(), var4.getSecond());
         var3 = (Map)var2;
         var4 = TuplesKt.to(InteractType.RIGHT, new ConfiguredExecutableObject((ExecutableObject)(new CrateOpenAction()), new ObjectArguments(MapsKt.emptyMap())));
         var3.put(var4.getFirst(), var4.getSecond());
         var3 = (Map)var2;
         var4 = TuplesKt.to(InteractType.SHIFT_RIGHT, new ConfiguredExecutableObject((ExecutableObject)(new CrateInstantOpenAction()), new ObjectArguments(MapsKt.emptyMap())));
         var3.put(var4.getFirst(), var4.getSecond());
         var3 = (Map)var2;
         var4 = TuplesKt.to(InteractType.SHIFT_LEFT, new ConfiguredExecutableObject((ExecutableObject)(new CrateBreakAction()), new ObjectArguments(MapsKt.emptyMap())));
         var3.put(var4.getFirst(), var4.getSecond());
      }

      return new BasicCrateInteractHandler((Crate)var1, var2);
   }

   private static final CrateAnimationManager loadBasicCrate$lambda$14(CrateAnimationSettings var0, FileConfiguration var1, Function1 var2, BasicCrate var3) {
      Intrinsics.checkNotNullParameter(var3, "bc");
      OpenableCrate var10000 = (OpenableCrate)var3;
      List var4 = INSTANCE.loadIdleAnimationSettings(var1);
      OpenableCrate var7 = var10000;
      boolean var6 = false;
      Bukkit.getConsoleSender().sendMessage("Loaded " + var4.size() + " idle animations");
      Unit var9 = Unit.INSTANCE;
      Collection var10002 = (Collection)var4;
      FailAnimationSettings var11 = INSTANCE.loadFailAnimationSettings(var1);
      Collection var12 = var10002;
      return (CrateAnimationManager)(new AnimationManagerImpl(var7, var0, var12, var11, var2));
   }

   private static final RewardManager loadBasicCrate$lambda$15(FileConfiguration var0, ConfigurationSection var1, HashMap var2, HashMap var3, Function1 var4, BasicCrate var5) {
      Intrinsics.checkNotNullParameter(var5, "bc");
      List var6 = INSTANCE.loadRewardRanges(ConfigExtKt.getSectionList((ConfigurationSection)var0, "possible-rewards"));
      Map var7 = INSTANCE.loadRewards(var1, var2);
      return (RewardManager)(new RewardManagerImpl((OpenableCrate)var5, var6, var3, var4, var7));
   }

   static {
      Pair[] var0 = new Pair[]{TuplesKt.to("instant", InstantAnimationSettings.Companion), TuplesKt.to("regular", RegularAnimationSettings.Companion), TuplesKt.to("cinematic", CinematicAnimationSettings.Companion)};
      animationSerializers = MapsKt.hashMapOf(var0);
      var0 = new Pair[]{TuplesKt.to("inventory", InventoryRerollInput.Companion), TuplesKt.to("interaction", InteractionRerollInput.Companion)};
      rerollInputSerializers = MapsKt.hashMapOf(var0);
   }
}
