package gg.aquatic.aquaticcrates.plugin;

import gg.aquatic.aquaticcrates.api.AbstractCratesPlugin;
import gg.aquatic.aquaticcrates.api.PluginSettings;
import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationManager;
import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.CrateHandler;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.aquaticcrates.api.interaction.CrateInteractAction;
import gg.aquatic.aquaticcrates.api.openprice.PriceKt;
import gg.aquatic.aquaticcrates.api.openprice.impl.CrateKeyPrice;
import gg.aquatic.aquaticcrates.api.player.CrateProfileDriver;
import gg.aquatic.aquaticcrates.api.player.CrateProfileEntry;
import gg.aquatic.aquaticcrates.api.player.CrateProfileModule;
import gg.aquatic.aquaticcrates.api.player.HistoryHandler;
import gg.aquatic.aquaticcrates.api.reroll.RerollManager;
import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.aquaticcrates.plugin.animation.action.ConditionalActionsAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.EquipmentAnimationAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.ParticleAnimationAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.PlayerActionsAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.PushPlayerAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.RumblingRewardAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.SoundAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.StopSoundAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.StringDeobfuscationAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.ThrowEntityAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.TitleAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.block.SetBlockAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.block.SetMultiblockAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.bossbar.HideBossbarAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.bossbar.SetBossbarColorAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.bossbar.SetBossbarProgressAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.bossbar.SetBossbarStyleAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.bossbar.SetBossbarTextAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.bossbar.ShowBossbarAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.entity.AddPassengerAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.entity.HideEntityAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.entity.RemovePassengerAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.entity.ShowEntityAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.entity.UpdateEntityPropertiesAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.inventory.CloseInventoryAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.inventory.OpenInventoryAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.inventory.SetInventoryItemsAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.inventory.SetInventoryTitleAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.model.BMHideModelAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.model.BMPlayModelAnimationAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.model.BMShowModelAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.model.HideModelAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.model.PlayModelAnimationAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.model.ShowModelAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.path.BindPathAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.path.LinearPathAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.path.SmoothPathAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.potion.ClearPotionEffectsAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.potion.PotionEffectsAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.timer.LaterActionsAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.timer.StartTickerAction;
import gg.aquatic.aquaticcrates.plugin.animation.action.timer.TimedActionsAction;
import gg.aquatic.aquaticcrates.plugin.animation.condition.CustomCondition;
import gg.aquatic.aquaticcrates.plugin.animation.prop.inventory.AnimationMenu;
import gg.aquatic.aquaticcrates.plugin.awaiters.IAAwaiter;
import gg.aquatic.aquaticcrates.plugin.awaiters.MEGAwaiter;
import gg.aquatic.aquaticcrates.plugin.awaiters.NexoAwaiter;
import gg.aquatic.aquaticcrates.plugin.command.ConvertCommand;
import gg.aquatic.aquaticcrates.plugin.command.CrateCommand;
import gg.aquatic.aquaticcrates.plugin.command.KeyCommand;
import gg.aquatic.aquaticcrates.plugin.command.LogCommand;
import gg.aquatic.aquaticcrates.plugin.command.ReloadCommand;
import gg.aquatic.aquaticcrates.plugin.command.RewardMenuCommand;
import gg.aquatic.aquaticcrates.plugin.condition.impl.CustomPlayerCondition;
import gg.aquatic.aquaticcrates.plugin.condition.impl.DayRepeatCondition;
import gg.aquatic.aquaticcrates.plugin.condition.impl.PermissionCondition;
import gg.aquatic.aquaticcrates.plugin.condition.impl.WeekRepeatCondition;
import gg.aquatic.aquaticcrates.plugin.interact.action.CrateBreakAction;
import gg.aquatic.aquaticcrates.plugin.interact.action.CrateExecuteActionsAction;
import gg.aquatic.aquaticcrates.plugin.interact.action.CrateInstantOpenAction;
import gg.aquatic.aquaticcrates.plugin.interact.action.CrateOpenAction;
import gg.aquatic.aquaticcrates.plugin.interact.action.CratePreviewAction;
import gg.aquatic.aquaticcrates.plugin.log.LogMenuSettings;
import gg.aquatic.aquaticcrates.plugin.misc.Messages;
import gg.aquatic.aquaticcrates.plugin.misc.hook.BStatsHook;
import gg.aquatic.aquaticcrates.plugin.misc.hook.CometHook;
import gg.aquatic.aquaticcrates.plugin.misc.hook.PAPIHook;
import gg.aquatic.aquaticcrates.plugin.preview.CratePreviewMenu;
import gg.aquatic.aquaticcrates.plugin.reroll.input.interaction.InteractionInputHandler;
import gg.aquatic.aquaticcrates.plugin.reroll.input.inventory.InventoryRerollInput;
import gg.aquatic.aquaticcrates.plugin.reroll.input.inventory.RerollMenu;
import gg.aquatic.aquaticcrates.plugin.restriction.OpenData;
import gg.aquatic.aquaticcrates.plugin.restriction.impl.AllGlobalOpenRestriction;
import gg.aquatic.aquaticcrates.plugin.restriction.impl.AllPlayerOpenRestriction;
import gg.aquatic.aquaticcrates.plugin.restriction.impl.EmptyInventoryOpenRestriction;
import gg.aquatic.aquaticcrates.plugin.restriction.impl.GlobalOpenRestriction;
import gg.aquatic.aquaticcrates.plugin.restriction.impl.PlayerOpenRestriction;
import gg.aquatic.aquaticcrates.plugin.restriction.impl.WorldBlacklistOpenRestriction;
import gg.aquatic.aquaticcrates.plugin.reward.menu.RewardsMenuSettings;
import gg.aquatic.aquaticcrates.plugin.serialize.CrateSerializer;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.api.WavesPlugin;
import gg.aquatic.waves.api.event.packet.PacketContainerContentEvent;
import gg.aquatic.waves.api.event.packet.PacketContainerSetSlotEvent;
import gg.aquatic.waves.api.event.packet.PacketInteractEvent;
import gg.aquatic.waves.api.event.packet.PacketInteractEvent.InteractType;
import gg.aquatic.waves.command.AquaticBaseCommand;
import gg.aquatic.waves.command.CommandExtKt;
import gg.aquatic.waves.inventory.InventoryManager;
import gg.aquatic.waves.inventory.PacketInventory;
import gg.aquatic.waves.inventory.event.AsyncPacketInventoryCloseEvent;
import gg.aquatic.waves.item.ItemHandler;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.collections.MapsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.profile.ProfilesModule;
import gg.aquatic.waves.profile.module.ProfileModule;
import gg.aquatic.waves.registry.WavesRegistry;
import gg.aquatic.waves.util.Config;
import gg.aquatic.waves.util.StringExtKt;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u001bJ\b\u0010\u001c\u001a\u00020\u000bH\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u000bH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0011@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u0015@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\""},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/CratesPlugin;", "Lgg/aquatic/aquaticcrates/api/AbstractCratesPlugin;", "<init>", "()V", "settings", "Lgg/aquatic/aquaticcrates/api/PluginSettings;", "getSettings", "()Lgg/aquatic/aquaticcrates/api/PluginSettings;", "setSettings", "(Lgg/aquatic/aquaticcrates/api/PluginSettings;)V", "onLoad", "", "value", "", "loading", "getLoading", "()Z", "Lgg/aquatic/aquaticcrates/plugin/reward/menu/RewardsMenuSettings;", "rewardsMenuSettings", "getRewardsMenuSettings", "()Lgg/aquatic/aquaticcrates/plugin/reward/menu/RewardsMenuSettings;", "Lgg/aquatic/aquaticcrates/plugin/log/LogMenuSettings;", "logMenuSettings", "getLogMenuSettings", "()Lgg/aquatic/aquaticcrates/plugin/log/LogMenuSettings;", "onEnable", "reloadPlugin", "Ljava/util/concurrent/CompletableFuture;", "startTicker", "load", "Ljava/lang/Void;", "registerObjects", "injectLegacyConverterListeners", "Companion", "plugin"}
)
@SourceDebugExtension({"SMAP\nCratesPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CratesPlugin.kt\ngg/aquatic/aquaticcrates/plugin/CratesPlugin\n+ 2 EventExt.kt\ngg/aquatic/waves/api/event/EventExtKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n+ 5 ActionRegistry.kt\ngg/aquatic/waves/registry/ActionRegistryKt\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 7 RequirementRegistry.kt\ngg/aquatic/waves/registry/RequirementRegistryKt\n+ 8 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 9 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 10 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,563:1\n14#2,19:564\n14#2,19:583\n14#2,19:602\n14#2,19:625\n14#2,19:644\n14#2,19:663\n14#2,19:682\n14#2,19:701\n14#2,19:720\n14#2,19:739\n14#2,19:1342\n14#2,19:1361\n14#2,19:1380\n1563#3:621\n1634#3,3:622\n24#4,4:758\n6#5:762\n7#5,2:770\n6#5:772\n7#5,2:780\n6#5:782\n7#5,2:790\n6#5:792\n7#5,2:800\n6#5:802\n7#5,2:810\n6#5:812\n7#5,2:820\n6#5:822\n7#5,2:830\n6#5:832\n7#5,2:840\n6#5:842\n7#5,2:850\n6#5:852\n7#5,2:860\n6#5:862\n7#5,2:870\n6#5:872\n7#5,2:880\n6#5:882\n7#5,2:890\n6#5:892\n7#5,2:900\n6#5:902\n7#5,2:910\n6#5:912\n7#5,2:920\n6#5:922\n7#5,2:930\n6#5:932\n7#5,2:940\n6#5:942\n7#5,2:950\n6#5:952\n7#5,2:960\n6#5:962\n7#5,2:970\n6#5:972\n7#5,2:980\n6#5:982\n7#5,2:990\n6#5:992\n7#5,2:1000\n6#5:1002\n7#5,2:1010\n6#5:1012\n7#5,2:1020\n6#5:1022\n7#5,2:1030\n6#5:1032\n7#5,2:1040\n6#5:1042\n7#5,2:1050\n6#5:1052\n7#5,2:1060\n6#5:1062\n7#5,2:1070\n6#5:1072\n7#5,2:1080\n6#5:1082\n7#5,2:1090\n6#5:1092\n7#5,2:1100\n6#5:1102\n7#5,2:1110\n6#5:1112\n7#5,2:1120\n6#5:1122\n7#5,2:1130\n6#5:1132\n7#5,2:1140\n6#5:1142\n7#5,2:1150\n6#5:1152\n7#5,2:1160\n6#5:1162\n7#5,2:1170\n6#5:1172\n7#5,2:1180\n6#5:1182\n7#5,2:1190\n6#5:1192\n7#5,2:1200\n6#5:1202\n7#5,2:1210\n6#5:1212\n7#5,2:1220\n6#5:1222\n7#5,2:1230\n381#6,7:763\n381#6,7:773\n381#6,7:783\n381#6,7:793\n381#6,7:803\n381#6,7:813\n381#6,7:823\n381#6,7:833\n381#6,7:843\n381#6,7:853\n381#6,7:863\n381#6,7:873\n381#6,7:883\n381#6,7:893\n381#6,7:903\n381#6,7:913\n381#6,7:923\n381#6,7:933\n381#6,7:943\n381#6,7:953\n381#6,7:963\n381#6,7:973\n381#6,7:983\n381#6,7:993\n381#6,7:1003\n381#6,7:1013\n381#6,7:1023\n381#6,7:1033\n381#6,7:1043\n381#6,7:1053\n381#6,7:1063\n381#6,7:1073\n381#6,7:1083\n381#6,7:1093\n381#6,7:1103\n381#6,7:1113\n381#6,7:1123\n381#6,7:1133\n381#6,7:1143\n381#6,7:1153\n381#6,7:1163\n381#6,7:1173\n381#6,7:1183\n381#6,7:1193\n381#6,7:1203\n381#6,7:1213\n381#6,7:1223\n381#6,7:1233\n381#6,7:1243\n381#6,7:1253\n381#6,7:1263\n381#6,7:1273\n381#6,7:1283\n381#6,7:1293\n381#6,7:1303\n381#6,7:1313\n381#6,7:1323\n381#6,7:1333\n6#7:1232\n7#7,2:1240\n6#7:1242\n7#7,2:1250\n6#7:1252\n7#7,2:1260\n6#7:1262\n7#7,2:1270\n6#7:1272\n7#7,2:1280\n6#7:1282\n7#7,2:1290\n6#7:1292\n7#7,2:1300\n6#7:1302\n7#7,2:1310\n6#7:1312\n7#7,2:1320\n6#7:1322\n7#7,2:1330\n6#7:1332\n7#7,2:1340\n126#8:1399\n153#8,3:1400\n216#8,2:1403\n72#9,2:1405\n1#10:1407\n*S KotlinDebug\n*F\n+ 1 CratesPlugin.kt\ngg/aquatic/aquaticcrates/plugin/CratesPlugin\n*L\n180#1:564,19\n184#1:583,19\n191#1:602,19\n229#1:625,19\n252#1:644,19\n271#1:663,19\n282#1:682,19\n309#1:701,19\n325#1:720,19\n350#1:739,19\n521#1:1342,19\n528#1:1361,19\n546#1:1380,19\n226#1:621\n226#1:622,3\n397#1:758,4\n448#1:762\n448#1:770,2\n449#1:772\n449#1:780,2\n450#1:782\n450#1:790,2\n451#1:792\n451#1:800,2\n452#1:802\n452#1:810,2\n453#1:812\n453#1:820,2\n454#1:822\n454#1:830,2\n455#1:832\n455#1:840,2\n456#1:842\n456#1:850,2\n457#1:852\n457#1:860,2\n458#1:862\n458#1:870,2\n459#1:872\n459#1:880,2\n460#1:882\n460#1:890,2\n461#1:892\n461#1:900,2\n462#1:902\n462#1:910,2\n463#1:912\n463#1:920,2\n464#1:922\n464#1:930,2\n465#1:932\n465#1:940,2\n466#1:942\n466#1:950,2\n467#1:952\n467#1:960,2\n468#1:962\n468#1:970,2\n469#1:972\n469#1:980,2\n470#1:982\n470#1:990,2\n471#1:992\n471#1:1000,2\n472#1:1002\n472#1:1010,2\n473#1:1012\n473#1:1020,2\n474#1:1022\n474#1:1030,2\n475#1:1032\n475#1:1040,2\n476#1:1042\n476#1:1050,2\n477#1:1052\n477#1:1060,2\n478#1:1062\n478#1:1070,2\n479#1:1072\n479#1:1080,2\n480#1:1082\n480#1:1090,2\n481#1:1092\n481#1:1100,2\n482#1:1102\n482#1:1110,2\n483#1:1112\n483#1:1120,2\n484#1:1122\n484#1:1130,2\n485#1:1132\n485#1:1140,2\n486#1:1142\n486#1:1150,2\n487#1:1152\n487#1:1160,2\n488#1:1162\n488#1:1170,2\n489#1:1172\n489#1:1180,2\n492#1:1182\n492#1:1190,2\n493#1:1192\n493#1:1200,2\n494#1:1202\n494#1:1210,2\n495#1:1212\n495#1:1220,2\n496#1:1222\n496#1:1230,2\n448#1:763,7\n449#1:773,7\n450#1:783,7\n451#1:793,7\n452#1:803,7\n453#1:813,7\n454#1:823,7\n455#1:833,7\n456#1:843,7\n457#1:853,7\n458#1:863,7\n459#1:873,7\n460#1:883,7\n461#1:893,7\n462#1:903,7\n463#1:913,7\n464#1:923,7\n465#1:933,7\n466#1:943,7\n467#1:953,7\n468#1:963,7\n469#1:973,7\n470#1:983,7\n471#1:993,7\n472#1:1003,7\n473#1:1013,7\n474#1:1023,7\n475#1:1033,7\n476#1:1043,7\n477#1:1053,7\n478#1:1063,7\n479#1:1073,7\n480#1:1083,7\n481#1:1093,7\n482#1:1103,7\n483#1:1113,7\n484#1:1123,7\n485#1:1133,7\n486#1:1143,7\n487#1:1153,7\n488#1:1163,7\n489#1:1173,7\n492#1:1183,7\n493#1:1193,7\n494#1:1203,7\n495#1:1213,7\n496#1:1223,7\n499#1:1233,7\n500#1:1243,7\n501#1:1253,7\n502#1:1263,7\n503#1:1273,7\n504#1:1283,7\n507#1:1293,7\n508#1:1303,7\n509#1:1313,7\n510#1:1323,7\n513#1:1333,7\n499#1:1232\n499#1:1240,2\n500#1:1242\n500#1:1250,2\n501#1:1252\n501#1:1260,2\n502#1:1262\n502#1:1270,2\n503#1:1272\n503#1:1280,2\n504#1:1282\n504#1:1290,2\n507#1:1292\n507#1:1300,2\n508#1:1302\n508#1:1310,2\n509#1:1312\n509#1:1320,2\n510#1:1322\n510#1:1330,2\n513#1:1332\n513#1:1340,2\n347#1:1399\n347#1:1400,3\n372#1:1403,2\n421#1:1405,2\n421#1:1407\n*E\n"})
public final class CratesPlugin extends AbstractCratesPlugin {
   @NotNull
   public static final CratesPlugin.Companion Companion = new CratesPlugin.Companion((DefaultConstructorMarker)null);
   public PluginSettings settings;
   private boolean loading = true;
   private RewardsMenuSettings rewardsMenuSettings;
   private LogMenuSettings logMenuSettings;
   public static Config spawnedCratesConfig;

   @NotNull
   public PluginSettings getSettings() {
      PluginSettings var10000 = this.settings;
      if (var10000 != null) {
         return var10000;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("settings");
         return null;
      }
   }

   public void setSettings(@NotNull PluginSettings var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.settings = var1;
   }

   public void onLoad() {
      AbstractCratesPlugin.Companion.setINSTANCE((AbstractCratesPlugin)this);
      Companion.setSpawnedCratesConfig(new Config("spawnedcrates.yml", (JavaPlugin)Companion.getINSTANCE()));
   }

   public final boolean getLoading() {
      return this.loading;
   }

   @NotNull
   public final RewardsMenuSettings getRewardsMenuSettings() {
      RewardsMenuSettings var10000 = this.rewardsMenuSettings;
      if (var10000 != null) {
         return var10000;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("rewardsMenuSettings");
         return null;
      }
   }

   @NotNull
   public final LogMenuSettings getLogMenuSettings() {
      LogMenuSettings var10000 = this.logMenuSettings;
      if (var10000 != null) {
         return var10000;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("logMenuSettings");
         return null;
      }
   }

   public void onEnable() {
      this.registerObjects();
      if (this.getServer().getPluginManager().getPlugin("Comet") != null) {
         new CometHook();
      }

      BStatsHook.INSTANCE.register$plugin();
      this.injectLegacyConverterListeners();
      ProfilesModule.INSTANCE.registerModule((ProfileModule)CrateProfileModule.INSTANCE);
      PAPIHook.INSTANCE.registerPAPIHook$plugin();
      List var1 = (List)(new ArrayList());
      if (Bukkit.getPluginManager().getPlugin("Nexo") != null) {
         NexoAwaiter var2 = new NexoAwaiter();
         ((Collection)var1).add(var2);
         var2.getFuture().thenRun(CratesPlugin::onEnable$lambda$0);
      }

      if (Bukkit.getPluginManager().getPlugin("ModelEngine") != null) {
         MEGAwaiter var24 = new MEGAwaiter();
         ((Collection)var1).add(var24);
         var24.getFuture().thenRun(CratesPlugin::onEnable$lambda$1);
      }

      if (Bukkit.getPluginManager().getPlugin("ItemsAdder") != null) {
         IAAwaiter var25 = new IAAwaiter();
         ((Collection)var1).add(var25);
         var25.getFuture().thenRun(CratesPlugin::onEnable$lambda$2);
      }

      HistoryHandler.INSTANCE.getRewardHistory().clear();
      HistoryHandler.INSTANCE.getOpenHistory().clear();
      Pair var26 = CrateProfileDriver.INSTANCE.loadGlobalHistory();
      ConcurrentHashMap var3 = (ConcurrentHashMap)var26.component1();
      ConcurrentHashMap var4 = (ConcurrentHashMap)var26.component2();
      ((Map)HistoryHandler.INSTANCE.getOpenHistory()).putAll((Map)var3);
      ((Map)HistoryHandler.INSTANCE.getRewardHistory()).putAll((Map)var4);
      if (var1.isEmpty()) {
         this.load();
      }

      Consumer var7 = CratesPlugin::onEnable$lambda$3;
      boolean var5 = false;
      EventPriority var6 = EventPriority.NORMAL;
      boolean var8 = false;
      CratesPlugin$onEnable$$inlined$event$default$1 var9 = new CratesPlugin$onEnable$$inlined$event$default$1();
      Bukkit.getPluginManager().registerEvent(WorldLoadEvent.class, (Listener)var9, var6, (EventExecutor)(new CratesPlugin$onEnable$$inlined$event$default$2(var7)), (Plugin)WavesPlugin.Companion.getINSTANCE(), var5);
      Listener var10000 = (Listener)var9;
      var7 = CratesPlugin::onEnable$lambda$4;
      var5 = false;
      var6 = EventPriority.NORMAL;
      var8 = false;
      CratesPlugin$onEnable$$inlined$event$default$3 var32 = new CratesPlugin$onEnable$$inlined$event$default$3();
      Bukkit.getPluginManager().registerEvent(PlayerQuitEvent.class, (Listener)var32, var6, (EventExecutor)(new CratesPlugin$onEnable$$inlined$event$default$4(var7)), (Plugin)WavesPlugin.Companion.getINSTANCE(), var5);
      var10000 = (Listener)var32;
      var7 = CratesPlugin::onEnable$lambda$5;
      var5 = false;
      var6 = EventPriority.NORMAL;
      var8 = false;
      CratesPlugin$onEnable$$inlined$event$default$5 var33 = new CratesPlugin$onEnable$$inlined$event$default$5();
      Bukkit.getPluginManager().registerEvent(PlayerToggleSneakEvent.class, (Listener)var33, var6, (EventExecutor)(new CratesPlugin$onEnable$$inlined$event$default$6(var7)), (Plugin)WavesPlugin.Companion.getINSTANCE(), var5);
      var10000 = (Listener)var33;
      this.startTicker();
      String[] var27 = new String[]{"acrates"};
      List var10002 = CollectionsKt.mutableListOf(var27);
      Pair[] var28 = new Pair[]{TuplesKt.to("key", KeyCommand.INSTANCE), TuplesKt.to("crate", CrateCommand.INSTANCE), TuplesKt.to("reload", ReloadCommand.INSTANCE), TuplesKt.to("rewardmenu", RewardMenuCommand.INSTANCE), TuplesKt.to("log", LogCommand.INSTANCE), TuplesKt.to("convert", ConvertCommand.INSTANCE)};
      Map var10003 = MapsKt.mutableMapOf(var28);
      Iterable var29 = (Iterable)Messages.HELP.getMessage().getMessages();
      Map var17 = var10003;
      List var16 = var10002;
      String var15 = "Base command of AquaticCrates plugin";
      String var14 = "aquaticcrates";
      boolean var30 = false;
      Collection var31 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var29, 10)));
      boolean var34 = false;
      Iterator var10 = var29.iterator();

      while(var10.hasNext()) {
         Object var11 = var10.next();
         String var12 = (String)var11;
         boolean var13 = false;
         var31.add(StringExtKt.toMMComponent(var12));
      }

      List var18 = (List)var31;
      List var19 = CollectionsKt.toMutableList((Collection)var18);
      CommandExtKt.register((Command)(new AquaticBaseCommand(var14, var15, var16, var17, var19)), "aquaticcrates");
      var7 = CratesPlugin::onEnable$lambda$7;
      var5 = false;
      var6 = EventPriority.NORMAL;
      var8 = false;
      CratesPlugin$onEnable$$inlined$event$default$7 var35 = new CratesPlugin$onEnable$$inlined$event$default$7();
      Bukkit.getPluginManager().registerEvent(AsyncPacketInventoryCloseEvent.class, (Listener)var35, var6, (EventExecutor)(new CratesPlugin$onEnable$$inlined$event$default$8(var7)), (Plugin)WavesPlugin.Companion.getINSTANCE(), var5);
      var10000 = (Listener)var35;
      var5 = true;
      var7 = CratesPlugin::onEnable$lambda$8;
      var6 = EventPriority.NORMAL;
      var8 = false;
      CratesPlugin$onEnable$$inlined$event$default$9 var36 = new CratesPlugin$onEnable$$inlined$event$default$9();
      Bukkit.getPluginManager().registerEvent(EntityDamageEvent.class, (Listener)var36, var6, (EventExecutor)(new CratesPlugin$onEnable$$inlined$event$default$10(var7)), (Plugin)WavesPlugin.Companion.getINSTANCE(), var5);
      var10000 = (Listener)var36;
      var7 = CratesPlugin::onEnable$lambda$9;
      var5 = false;
      var6 = EventPriority.NORMAL;
      var8 = false;
      CratesPlugin$onEnable$$inlined$event$default$11 var37 = new CratesPlugin$onEnable$$inlined$event$default$11();
      Bukkit.getPluginManager().registerEvent(InventoryInteractEvent.class, (Listener)var37, var6, (EventExecutor)(new CratesPlugin$onEnable$$inlined$event$default$12(var7)), (Plugin)WavesPlugin.Companion.getINSTANCE(), var5);
      var10000 = (Listener)var37;
      var7 = CratesPlugin::onEnable$lambda$10;
      var5 = false;
      var6 = EventPriority.NORMAL;
      var8 = false;
      CratesPlugin$onEnable$$inlined$event$default$13 var38 = new CratesPlugin$onEnable$$inlined$event$default$13();
      Bukkit.getPluginManager().registerEvent(PlayerInteractEvent.class, (Listener)var38, var6, (EventExecutor)(new CratesPlugin$onEnable$$inlined$event$default$14(var7)), (Plugin)WavesPlugin.Companion.getINSTANCE(), var5);
      var10000 = (Listener)var38;
      var7 = CratesPlugin::onEnable$lambda$11;
      var5 = false;
      var6 = EventPriority.NORMAL;
      var8 = false;
      CratesPlugin$onEnable$$inlined$event$default$15 var39 = new CratesPlugin$onEnable$$inlined$event$default$15();
      Bukkit.getPluginManager().registerEvent(PacketInteractEvent.class, (Listener)var39, var6, (EventExecutor)(new CratesPlugin$onEnable$$inlined$event$default$16(var7)), (Plugin)WavesPlugin.Companion.getINSTANCE(), var5);
      var10000 = (Listener)var39;
      var7 = CratesPlugin::onEnable$lambda$13;
      var5 = false;
      var6 = EventPriority.NORMAL;
      var8 = false;
      CratesPlugin$onEnable$$inlined$event$default$17 var40 = new CratesPlugin$onEnable$$inlined$event$default$17();
      Bukkit.getPluginManager().registerEvent(PacketContainerSetSlotEvent.class, (Listener)var40, var6, (EventExecutor)(new CratesPlugin$onEnable$$inlined$event$default$18(var7)), (Plugin)WavesPlugin.Companion.getINSTANCE(), var5);
      var10000 = (Listener)var40;
      var7 = CratesPlugin::onEnable$lambda$15;
      var5 = false;
      var6 = EventPriority.NORMAL;
      var8 = false;
      CratesPlugin$onEnable$$inlined$event$default$19 var41 = new CratesPlugin$onEnable$$inlined$event$default$19();
      Bukkit.getPluginManager().registerEvent(PacketContainerContentEvent.class, (Listener)var41, var6, (EventExecutor)(new CratesPlugin$onEnable$$inlined$event$default$20(var7)), (Plugin)WavesPlugin.Companion.getINSTANCE(), var5);
      var10000 = (Listener)var41;
   }

   @NotNull
   public final CompletableFuture<Boolean> reloadPlugin() {
      CompletableFuture var4;
      if (this.loading) {
         var4 = CompletableFuture.completedFuture(false);
         Intrinsics.checkNotNullExpressionValue(var4, "completedFuture(...)");
         return var4;
      } else {
         Iterator var1 = CrateHandler.INSTANCE.getCrates().values().iterator();

         Object var10000;
         while(var1.hasNext()) {
            var10000 = var1.next();
            Intrinsics.checkNotNullExpressionValue(var10000, "next(...)");
            Crate var2 = (Crate)var10000;
            if (var2 instanceof OpenableCrate) {
               ((OpenableCrate)var2).getAnimationManager().forceStopAllAnimations();
            }
         }

         CrateHandler.INSTANCE.getCrates().clear();
         var1 = CrateHandler.INSTANCE.getSpawned().values().iterator();

         while(var1.hasNext()) {
            var10000 = var1.next();
            Intrinsics.checkNotNullExpressionValue(var10000, "next(...)");
            SpawnedCrate var3 = (SpawnedCrate)var10000;
            var3.destroy();
         }

         CrateHandler.INSTANCE.getSpawned().clear();
         var4 = this.load().thenApply(CratesPlugin::reloadPlugin$lambda$17);
         Intrinsics.checkNotNullExpressionValue(var4, "thenApply(...)");
         return var4;
      }
   }

   private final void startTicker() {
      long var1 = 1L;
      long var3 = 1L;
      boolean var5 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTaskTimerAsynchronously((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new CratesPlugin$startTicker$$inlined$runAsyncTimer$1()), var1, var3);
   }

   private final CompletableFuture<Void> load() {
      this.loading = true;
      this.getDataFolder().mkdirs();
      this.setSettings(CrateSerializer.INSTANCE.loadPluginSettings());
      this.rewardsMenuSettings = CrateSerializer.INSTANCE.loadRewardMenuSettings();
      this.logMenuSettings = CrateSerializer.INSTANCE.loadLogMenuSettings();
      CompletableFuture var10000 = CompletableFuture.runAsync(CratesPlugin::load$lambda$20).exceptionally(CratesPlugin::load$lambda$21);
      Intrinsics.checkNotNullExpressionValue(var10000, "exceptionally(...)");
      return var10000;
   }

   private final void registerObjects() {
      WavesRegistry var1 = WavesRegistry.INSTANCE;
      String var2 = "show-bossbar";
      ExecutableObject var3 = (ExecutableObject)(new ShowBossbarAction());
      boolean var4 = false;
      Map var5 = (Map)var1.getACTION();
      Class var6 = PlayerBoundAnimation.class;
      boolean var7 = false;
      Object var8 = var5.get(var6);
      boolean var9;
      Map var12;
      Object var10000;
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      Map var10 = (Map)var10000;
      Pair var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "hide-bossbar";
      var3 = (ExecutableObject)(new HideBossbarAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "set-bossbar-message";
      var3 = (ExecutableObject)(new SetBossbarTextAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "set-bossbar-color";
      var3 = (ExecutableObject)(new SetBossbarColorAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "set-bossbar-style";
      var3 = (ExecutableObject)(new SetBossbarStyleAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "set-bossbar-progress";
      var3 = (ExecutableObject)(new SetBossbarProgressAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "linear-path";
      var3 = (ExecutableObject)(new LinearPathAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "smooth-path";
      var3 = (ExecutableObject)(new SmoothPathAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "show-entity";
      var3 = (ExecutableObject)(new ShowEntityAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "hide-entity";
      var3 = (ExecutableObject)(new HideEntityAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "throw-entity";
      var3 = (ExecutableObject)(new ThrowEntityAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "update-entity-properties";
      var3 = (ExecutableObject)(new UpdateEntityPropertiesAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "set-block";
      var3 = (ExecutableObject)(new SetBlockAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "set-multiblock";
      var3 = (ExecutableObject)(new SetMultiblockAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "show-model";
      var3 = (ExecutableObject)(new ShowModelAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "play-model-animation";
      var3 = (ExecutableObject)(new PlayModelAnimationAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "hide-model";
      var3 = (ExecutableObject)(new HideModelAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "show-bm-model";
      var3 = (ExecutableObject)(new BMShowModelAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "play-bm-model-animation";
      var3 = (ExecutableObject)(new BMPlayModelAnimationAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "hide-bm-model";
      var3 = (ExecutableObject)(new BMHideModelAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "play-sound";
      var3 = (ExecutableObject)(new SoundAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "stop-sound";
      var3 = (ExecutableObject)(new StopSoundAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = PlayerBoundAnimation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "conditional-actions";
      var3 = (ExecutableObject)(new ConditionalActionsAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "start-ticker";
      var3 = (ExecutableObject)(new StartTickerAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "bind-path";
      var3 = (ExecutableObject)(new BindPathAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "title";
      var3 = (ExecutableObject)(new TitleAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = PlayerBoundAnimation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "string-deobfuscation";
      var3 = (ExecutableObject)(new StringDeobfuscationAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "push-player";
      var3 = (ExecutableObject)(new PushPlayerAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = PlayerBoundAnimation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "open-inventory";
      var3 = (ExecutableObject)(new OpenInventoryAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = PlayerBoundAnimation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "set-inventory-items";
      var3 = (ExecutableObject)(new SetInventoryItemsAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = PlayerBoundAnimation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "set-inventory-title";
      var3 = (ExecutableObject)(new SetInventoryTitleAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = PlayerBoundAnimation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "close-inventory";
      var3 = (ExecutableObject)(new CloseInventoryAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = PlayerBoundAnimation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "add-potion-effects";
      var3 = (ExecutableObject)(new PotionEffectsAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = PlayerBoundAnimation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "remove-potion-effects";
      var3 = (ExecutableObject)(new ClearPotionEffectsAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = PlayerBoundAnimation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "timed-actions";
      var3 = (ExecutableObject)(new TimedActionsAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "delayed-actions";
      var3 = (ExecutableObject)(new LaterActionsAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "rumbling-reward";
      var3 = (ExecutableObject)(new RumblingRewardAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "player-equipment";
      var3 = (ExecutableObject)(new EquipmentAnimationAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = PlayerBoundAnimation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "player-actions";
      var3 = (ExecutableObject)(new PlayerActionsAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = PlayerBoundAnimation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "add-passenger";
      var3 = (ExecutableObject)(new AddPassengerAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "remove-passenger";
      var3 = (ExecutableObject)(new RemovePassengerAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "particle";
      var3 = (ExecutableObject)(new ParticleAnimationAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "open-crate";
      var3 = (ExecutableObject)(new CrateOpenAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = CrateInteractAction.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "open-crate-instant";
      var3 = (ExecutableObject)(new CrateInstantOpenAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = CrateInteractAction.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "preview-crate";
      var3 = (ExecutableObject)(new CratePreviewAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = CrateInteractAction.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "destroy-crate";
      var3 = (ExecutableObject)(new CrateBreakAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = CrateInteractAction.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "execute-actions";
      var3 = (ExecutableObject)(new CrateExecuteActionsAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = CrateInteractAction.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "player";
      var3 = (ExecutableObject)(new PlayerOpenRestriction());
      var4 = false;
      var5 = (Map)var1.getREQUIREMENT();
      var6 = OpenData.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "global";
      var3 = (ExecutableObject)(new GlobalOpenRestriction());
      var4 = false;
      var5 = (Map)var1.getREQUIREMENT();
      var6 = OpenData.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "all-player";
      var3 = (ExecutableObject)(new AllPlayerOpenRestriction());
      var4 = false;
      var5 = (Map)var1.getREQUIREMENT();
      var6 = OpenData.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "all-global";
      var3 = (ExecutableObject)(new AllGlobalOpenRestriction());
      var4 = false;
      var5 = (Map)var1.getREQUIREMENT();
      var6 = OpenData.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "world-blacklist";
      var3 = (ExecutableObject)(new WorldBlacklistOpenRestriction());
      var4 = false;
      var5 = (Map)var1.getREQUIREMENT();
      var6 = OpenData.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "full-inventory";
      var3 = (ExecutableObject)(new EmptyInventoryOpenRestriction());
      var4 = false;
      var5 = (Map)var1.getREQUIREMENT();
      var6 = OpenData.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "custom";
      var3 = (ExecutableObject)(new CustomPlayerCondition());
      var4 = false;
      var5 = (Map)var1.getREQUIREMENT();
      var6 = Player.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "permission";
      var3 = (ExecutableObject)(new PermissionCondition());
      var4 = false;
      var5 = (Map)var1.getREQUIREMENT();
      var6 = Player.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "week-repeat";
      var3 = (ExecutableObject)(new WeekRepeatCondition());
      var4 = false;
      var5 = (Map)var1.getREQUIREMENT();
      var6 = Player.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "day-repeat";
      var3 = (ExecutableObject)(new DayRepeatCondition());
      var4 = false;
      var5 = (Map)var1.getREQUIREMENT();
      var6 = Player.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "custom";
      var3 = (ExecutableObject)(new CustomCondition());
      var4 = false;
      var5 = (Map)var1.getREQUIREMENT();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      Map var13 = (Map)PriceKt.getPRICES();
      Pair var14 = TuplesKt.to("crate-key", new CrateKeyPrice());
      var13.put(var14.getFirst(), var14.getSecond());
   }

   private final void injectLegacyConverterListeners() {
      boolean var1 = true;
      Consumer var3 = CratesPlugin::injectLegacyConverterListeners$lambda$22;
      EventPriority var2 = EventPriority.NORMAL;
      boolean var4 = false;
      CratesPlugin$injectLegacyConverterListeners$$inlined$event$default$1 var5 = new CratesPlugin$injectLegacyConverterListeners$$inlined$event$default$1();
      Bukkit.getPluginManager().registerEvent(AsyncPlayerPreLoginEvent.class, (Listener)var5, var2, (EventExecutor)(new CratesPlugin$injectLegacyConverterListeners$$inlined$event$default$2(var3)), (Plugin)WavesPlugin.Companion.getINSTANCE(), var1);
      Listener var10000 = (Listener)var5;
      var3 = CratesPlugin::injectLegacyConverterListeners$lambda$23;
      var1 = false;
      var2 = EventPriority.NORMAL;
      var4 = false;
      CratesPlugin$injectLegacyConverterListeners$$inlined$event$default$3 var6 = new CratesPlugin$injectLegacyConverterListeners$$inlined$event$default$3();
      Bukkit.getPluginManager().registerEvent(PlayerJoinEvent.class, (Listener)var6, var2, (EventExecutor)(new CratesPlugin$injectLegacyConverterListeners$$inlined$event$default$4(var3)), (Plugin)WavesPlugin.Companion.getINSTANCE(), var1);
      var10000 = (Listener)var6;
      var1 = true;
      var3 = CratesPlugin::injectLegacyConverterListeners$lambda$24;
      var2 = EventPriority.NORMAL;
      var4 = false;
      CratesPlugin$injectLegacyConverterListeners$$inlined$event$default$5 var7 = new CratesPlugin$injectLegacyConverterListeners$$inlined$event$default$5();
      Bukkit.getPluginManager().registerEvent(InventoryOpenEvent.class, (Listener)var7, var2, (EventExecutor)(new CratesPlugin$injectLegacyConverterListeners$$inlined$event$default$6(var3)), (Plugin)WavesPlugin.Companion.getINSTANCE(), var1);
      var10000 = (Listener)var7;
   }

   private static final void onEnable$lambda$0(List var0, NexoAwaiter var1, CratesPlugin var2) {
      ((Collection)var0).remove(var1);
      if (var0.isEmpty()) {
         var2.load();
      }

   }

   private static final void onEnable$lambda$1(List var0, MEGAwaiter var1, CratesPlugin var2) {
      ((Collection)var0).remove(var1);
      if (var0.isEmpty()) {
         var2.load();
      }

   }

   private static final void onEnable$lambda$2(List var0, IAAwaiter var1, CratesPlugin var2) {
      ((Collection)var0).remove(var1);
      if (var0.isEmpty()) {
         var2.load();
      }

   }

   private static final void onEnable$lambda$3(WorldLoadEvent var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      CrateHandler var10000 = CrateHandler.INSTANCE;
      World var10001 = var0.getWorld();
      Intrinsics.checkNotNullExpressionValue(var10001, "getWorld(...)");
      var10000.onWorldLoad(var10001);
   }

   private static final void onEnable$lambda$4(PlayerQuitEvent var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      Iterator var1 = CrateHandler.INSTANCE.getCrates().values().iterator();

      while(var1.hasNext()) {
         Object var10000 = var1.next();
         Intrinsics.checkNotNullExpressionValue(var10000, "next(...)");
         Crate var2 = (Crate)var10000;
         if (var2 instanceof OpenableCrate) {
            CrateAnimationManager var3 = ((OpenableCrate)var2).getAnimationManager();
            Player var10001 = var0.getPlayer();
            Intrinsics.checkNotNullExpressionValue(var10001, "getPlayer(...)");
            var3.forceStopAllAnimationTypes(var10001);
         }
      }

   }

   private static final void onEnable$lambda$5(PlayerToggleSneakEvent var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      if (var0.isSneaking()) {
         CrateAnimationManager var1 = null;
         Iterator var2 = CrateHandler.INSTANCE.getCrates().values().iterator();

         while(var2.hasNext()) {
            Object var10000 = var2.next();
            Intrinsics.checkNotNullExpressionValue(var10000, "next(...)");
            Crate var3 = (Crate)var10000;
            if (var3 instanceof OpenableCrate && ((OpenableCrate)var3).getAnimationManager().getPlayingAnimations().containsKey(var0.getPlayer().getUniqueId())) {
               var1 = ((OpenableCrate)var3).getAnimationManager();
               break;
            }
         }

         if (var1 != null) {
            if (InteractionInputHandler.INSTANCE.onSneak(var0)) {
               return;
            }

            if (var1.getAnimationSettings().getSkippable()) {
               Player var10001 = var0.getPlayer();
               Intrinsics.checkNotNullExpressionValue(var10001, "getPlayer(...)");
               var1.skipAnimation(var10001);
            }
         }
      }

   }

   private static final void onEnable$lambda$7(AsyncPacketInventoryCloseEvent var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      PacketInventory var1 = var0.getInventory();
      if (var1 instanceof AnimationMenu) {
         if (!((AnimationMenu)var1).getClosed()) {
            ((AnimationMenu)var1).open();
         }

      } else if (var1 instanceof RerollMenu) {
         if (!((RerollMenu)var1).getFuture().isDone()) {
            switch(CratesPlugin.WhenMappings.$EnumSwitchMapping$0[((RerollMenu)var1).getSettings().getOnClose().ordinal()]) {
            case 1:
               ((RerollMenu)var1).open();
               break;
            case 2:
               ((RerollMenu)var1).getFuture().complete(new RerollManager.RerollResult(true));
               break;
            default:
               ((RerollMenu)var1).getFuture().complete(new RerollManager.RerollResult(false));
            }

         }
      }
   }

   private static final void onEnable$lambda$8(EntityDamageEvent var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      Entity var3 = var0.getEntity();
      Player var10000 = var3 instanceof Player ? (Player)var3 : null;
      if ((var3 instanceof Player ? (Player)var3 : null) != null) {
         Player var1 = var10000;
         boolean var2 = false;
         Iterator var5 = CrateHandler.INSTANCE.getCrates().values().iterator();

         while(var5.hasNext()) {
            Object var6 = var5.next();
            Intrinsics.checkNotNullExpressionValue(var6, "next(...)");
            Crate var4 = (Crate)var6;
            if (var4 instanceof OpenableCrate && ((OpenableCrate)var4).getAnimationManager().getPlayingAnimations().containsKey(var1.getUniqueId())) {
               var2 = true;
               break;
            }
         }

         if (var2) {
            var0.setCancelled(true);
         }
      }
   }

   private static final void onEnable$lambda$9(InventoryInteractEvent var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      HumanEntity var3 = var0.getWhoClicked();
      Player var10000 = var3 instanceof Player ? (Player)var3 : null;
      if ((var3 instanceof Player ? (Player)var3 : null) != null) {
         Player var1 = var10000;
         PacketInventory var4 = (PacketInventory)InventoryManager.INSTANCE.getOpenedInventories().get(var1);
         if (var4 != null) {
            PacketInventory var2 = var4;
            if (var2 instanceof AnimationMenu || var2 instanceof RerollMenu || var2 instanceof CratePreviewMenu) {
               var2.updateItems(var1);
               var0.setCancelled(true);
            }
         }
      }
   }

   private static final void onEnable$lambda$10(PlayerInteractEvent var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      Player var10000 = var0.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player var1 = var10000;
      boolean var2 = false;
      Iterator var3 = CrateHandler.INSTANCE.getCrates().values().iterator();

      while(var3.hasNext()) {
         Object var5 = var3.next();
         Intrinsics.checkNotNullExpressionValue(var5, "next(...)");
         Crate var4 = (Crate)var5;
         if (var4 instanceof OpenableCrate && ((OpenableCrate)var4).getAnimationManager().getPlayingAnimations().containsKey(var1.getUniqueId())) {
            var2 = true;
            break;
         }
      }

      if (var2) {
         var0.setCancelled(true);
         InteractionInputHandler var6 = InteractionInputHandler.INSTANCE;
         PacketInteractEvent var10001 = new PacketInteractEvent;
         Player var10003 = var0.getPlayer();
         Intrinsics.checkNotNullExpressionValue(var10003, "getPlayer(...)");
         boolean var10004 = var0.getAction() == Action.LEFT_CLICK_AIR || var0.getAction() == Action.LEFT_CLICK_BLOCK;
         boolean var10005 = var0.getHand() == EquipmentSlot.OFF_HAND;
         InteractType var10007;
         switch(CratesPlugin.WhenMappings.$EnumSwitchMapping$1[var0.getAction().ordinal()]) {
         case 1:
         case 2:
            var10007 = InteractType.ATTACK;
            break;
         case 3:
         case 4:
            var10007 = InteractType.INTERACT;
            break;
         default:
            var10007 = InteractType.INTERACT;
         }

         var10001.<init>(var10003, var10004, var10005, 0, var10007);
         var6.onInteract(var10001);
      }

   }

   private static final void onEnable$lambda$11(PacketInteractEvent var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      Player var1 = var0.getPlayer();
      boolean var2 = false;
      Iterator var3 = CrateHandler.INSTANCE.getCrates().values().iterator();

      while(var3.hasNext()) {
         Object var10000 = var3.next();
         Intrinsics.checkNotNullExpressionValue(var10000, "next(...)");
         Crate var4 = (Crate)var10000;
         if (var4 instanceof OpenableCrate && ((OpenableCrate)var4).getAnimationManager().getPlayingAnimations().containsKey(var1.getUniqueId())) {
            var2 = true;
            break;
         }
      }

      if (var2) {
         var0.setCancelled(true);
         InteractionInputHandler.INSTANCE.onInteract(var0);
      }

   }

   private static final void onEnable$lambda$13(PacketContainerSetSlotEvent var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      Player var1 = var0.getPlayer();
      if (var0.getInventoryId() == 0) {
         CrateAnimation var2 = null;
         Iterator var3 = CrateHandler.INSTANCE.getCrates().values().iterator();

         while(true) {
            while(true) {
               Crate var4;
               do {
                  if (!var3.hasNext()) {
                     if (var2 == null) {
                        return;
                     }

                     Map var13 = (Map)var2.getPlayerEquipment();
                     boolean var14 = false;
                     Collection var15 = (Collection)(new ArrayList(var13.size()));
                     boolean var16 = false;
                     Iterator var8 = var13.entrySet().iterator();

                     while(var8.hasNext()) {
                        Entry var9 = (Entry)var8.next();
                        boolean var11 = false;
                        var15.add(((CrateAnimation.EquipmentSlot)var9.getKey()).toSlot(var1));
                     }

                     if (!((List)var15).contains(var0.getSlot())) {
                        return;
                     }

                     var0.setCancelled(true);
                     return;
                  }

                  Object var10000 = var3.next();
                  Intrinsics.checkNotNullExpressionValue(var10000, "next(...)");
                  var4 = (Crate)var10000;
               } while(!(var4 instanceof OpenableCrate));

               Set var17 = (Set)((OpenableCrate)var4).getAnimationManager().getPlayingAnimations().get(var1.getUniqueId());
               if (var17 != null) {
                  Set var5 = var17;
                  Iterator var6 = var5.iterator();

                  while(var6.hasNext()) {
                     CrateAnimation var7 = (CrateAnimation)var6.next();
                     if (var7.getState() != CrateAnimation.State.FINISHED && !((Map)var7.getPlayerEquipment()).isEmpty()) {
                        var2 = var7;
                        break;
                     }
                  }
               }
            }
         }
      }
   }

   private static final void onEnable$lambda$15(PacketContainerContentEvent var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      Player var1 = var0.getPlayer();
      if (var0.getInventoryId() == 0) {
         CrateAnimation var2 = null;
         Iterator var3 = CrateHandler.INSTANCE.getCrates().values().iterator();

         while(true) {
            while(true) {
               Crate var4;
               do {
                  if (!var3.hasNext()) {
                     if (var2 == null) {
                        return;
                     }

                     Map var12 = (Map)var2.getPlayerEquipment();
                     boolean var13 = false;
                     Iterator var14 = var12.entrySet().iterator();

                     while(var14.hasNext()) {
                        Entry var15 = (Entry)var14.next();
                        boolean var8 = false;
                        CrateAnimation.EquipmentSlot var9 = (CrateAnimation.EquipmentSlot)var15.getKey();
                        ItemStack var10 = (ItemStack)var15.getValue();
                        int var11 = var9.toSlot(var1);
                        var0.getContents().set(var11, var10);
                     }

                     return;
                  }

                  Object var10000 = var3.next();
                  Intrinsics.checkNotNullExpressionValue(var10000, "next(...)");
                  var4 = (Crate)var10000;
               } while(!(var4 instanceof OpenableCrate));

               Set var16 = (Set)((OpenableCrate)var4).getAnimationManager().getPlayingAnimations().get(var1.getUniqueId());
               if (var16 != null) {
                  Set var5 = var16;
                  Iterator var6 = var5.iterator();

                  while(var6.hasNext()) {
                     CrateAnimation var7 = (CrateAnimation)var6.next();
                     if (var7.getState() != CrateAnimation.State.FINISHED && !((Map)var7.getPlayerEquipment()).isEmpty()) {
                        var2 = var7;
                        break;
                     }
                  }
               }
            }
         }
      }
   }

   private static final Boolean reloadPlugin$lambda$16(Void var0) {
      return true;
   }

   private static final Boolean reloadPlugin$lambda$17(Function1 var0, Object var1) {
      return (Boolean)var0.invoke(var1);
   }

   private static final void load$lambda$20(CratesPlugin var0) {
      try {
         Messages.Companion.load();
         ((Map)CrateHandler.INSTANCE.getCrates()).putAll((Map)CrateSerializer.INSTANCE.loadCrates());
         CrateHandler.INSTANCE.loadSpawnedCrates(Companion.getSpawnedCratesConfig());
         Iterator var1 = CrateHandler.INSTANCE.getCrates().values().iterator();

         label50:
         while(true) {
            Crate var2;
            Object var10000;
            do {
               if (!var1.hasNext()) {
                  break label50;
               }

               var10000 = var1.next();
               Intrinsics.checkNotNullExpressionValue(var10000, "next(...)");
               var2 = (Crate)var10000;
            } while(!(var2 instanceof OpenableCrate));

            ConcurrentMap var4 = (ConcurrentMap)HistoryHandler.INSTANCE.getLatestRewards();
            String var5 = var2.getIdentifier();
            boolean var6 = false;
            var10000 = var4.get(var5);
            if (var10000 == null) {
               boolean var7 = false;
               List var8 = Collections.synchronizedList((List)(new ArrayList()));
               boolean var9 = false;
               var10000 = var4.putIfAbsent(var5, var8);
               if (var10000 == null) {
                  var10000 = var8;
               }
            }

            List var3 = (List)var10000;
            List var16 = HistoryHandler.INSTANCE.loadLogEntries(0, 10, (String)null, var2.getIdentifier(), CrateProfileDriver.Sorting.NEWEST);
            Iterator var17 = var16.iterator();

            while(var17.hasNext()) {
               Pair var18 = (Pair)var17.next();
               String var19 = (String)var18.component1();
               CrateProfileEntry.OpenHistoryEntry var20 = (CrateProfileEntry.OpenHistoryEntry)var18.component2();
               Iterator var21 = ((Map)var20.getRewardIds()).entrySet().iterator();

               while(var21.hasNext()) {
                  Entry var10 = (Entry)var21.next();
                  String var11 = (String)var10.getKey();
                  int var12 = ((Number)var10.getValue()).intValue();
                  Reward var22 = (Reward)((OpenableCrate)var2).getRewardManager().getRewards().get(var11);
                  if (var22 != null) {
                     Reward var13 = var22;
                     HistoryHandler.LatestReward var14 = new HistoryHandler.LatestReward(var13, var20.getTimestamp(), var12, var19);
                     var3.add(var14);
                     if (var3.size() >= 10) {
                        break;
                     }
                  }
               }

               if (var3.size() >= 10) {
                  break;
               }
            }
         }
      } catch (Exception var15) {
         var15.printStackTrace();
      }

      var0.loading = false;
   }

   private static final Void load$lambda$21(CratesPlugin var0, Throwable var1) {
      var1.printStackTrace();
      var0.loading = false;
      return null;
   }

   private static final void injectLegacyConverterListeners$lambda$22(CratesPlugin var0, AsyncPlayerPreLoginEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      if (var0.loading) {
         var1.disallow(Result.KICK_OTHER, (Component)Component.text("Server is currently loading..."));
      }
   }

   private static final void injectLegacyConverterListeners$lambda$23(PlayerJoinEvent var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      Player var10000 = var0.getPlayer();
      Intrinsics.checkNotNullExpressionValue(var10000, "getPlayer(...)");
      Player var1 = var10000;
      PlayerInventory var11 = var1.getInventory();
      Intrinsics.checkNotNullExpressionValue(var11, "getInventory(...)");
      PlayerInventory var2 = var11;
      ItemStack[] var12 = var2.getContents();
      Intrinsics.checkNotNullExpressionValue(var12, "getContents(...)");
      ItemStack[] var3 = var12;
      int var4 = 0;

      for(int var5 = var3.length; var4 < var5; ++var4) {
         ItemStack var6 = var3[var4];
         if (var6 != null) {
            ItemMeta var13 = var6.getItemMeta();
            if (var13 != null) {
               ItemMeta var7 = var13;
               PersistentDataContainer var14 = var7.getPersistentDataContainer();
               Intrinsics.checkNotNullExpressionValue(var14, "getPersistentDataContainer(...)");
               PersistentDataContainer var8 = var14;
               NamespacedKey var9 = new NamespacedKey("aquaticcrates", "keyidentifier");
               if (var8.has(var9, PersistentDataType.STRING)) {
                  Object var15 = var8.get(var9, PersistentDataType.STRING);
                  Intrinsics.checkNotNull(var15);
                  String var10 = (String)var15;
                  var8.remove(var9);
                  var8.set(ItemHandler.INSTANCE.getNAMESPACE_KEY(), PersistentDataType.STRING, "aquaticcrates-key:" + var10);
                  var6.setItemMeta(var7);
               }
            }
         }
      }

   }

   private static final void injectLegacyConverterListeners$lambda$24(InventoryOpenEvent var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      Inventory var10000 = var0.getInventory();
      Intrinsics.checkNotNullExpressionValue(var10000, "getInventory(...)");
      Inventory var1 = var10000;
      ItemStack[] var10 = var1.getContents();
      Intrinsics.checkNotNullExpressionValue(var10, "getContents(...)");
      ItemStack[] var2 = var10;
      int var3 = 0;

      for(int var4 = var2.length; var3 < var4; ++var3) {
         ItemStack var5 = var2[var3];
         if (var5 != null) {
            ItemMeta var11 = var5.getItemMeta();
            if (var11 != null) {
               ItemMeta var6 = var11;
               PersistentDataContainer var12 = var6.getPersistentDataContainer();
               Intrinsics.checkNotNullExpressionValue(var12, "getPersistentDataContainer(...)");
               PersistentDataContainer var7 = var12;
               NamespacedKey var8 = new NamespacedKey("aquaticcrates", "keyidentifier");
               if (var7.has(var8, PersistentDataType.STRING)) {
                  Object var13 = var7.get(var8, PersistentDataType.STRING);
                  Intrinsics.checkNotNull(var13);
                  String var9 = (String)var13;
                  var7.remove(var8);
                  var7.set(ItemHandler.INSTANCE.getNAMESPACE_KEY(), PersistentDataType.STRING, "aquaticcrates-key:" + var9);
                  var5.setItemMeta(var6);
               }
            }
         }
      }

   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/CratesPlugin$Companion;", "", "<init>", "()V", "INSTANCE", "Lgg/aquatic/aquaticcrates/api/AbstractCratesPlugin;", "getINSTANCE", "()Lgg/aquatic/aquaticcrates/api/AbstractCratesPlugin;", "spawnedCratesConfig", "Lgg/aquatic/waves/util/Config;", "getSpawnedCratesConfig", "()Lgg/aquatic/waves/util/Config;", "setSpawnedCratesConfig", "(Lgg/aquatic/waves/util/Config;)V", "plugin"}
   )
   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final AbstractCratesPlugin getINSTANCE() {
         return AbstractCratesPlugin.Companion.getINSTANCE();
      }

      @NotNull
      public final Config getSpawnedCratesConfig() {
         Config var10000 = CratesPlugin.spawnedCratesConfig;
         if (var10000 != null) {
            return var10000;
         } else {
            Intrinsics.throwUninitializedPropertyAccessException("spawnedCratesConfig");
            return null;
         }
      }

      public final void setSpawnedCratesConfig(@NotNull Config var1) {
         Intrinsics.checkNotNullParameter(var1, "<set-?>");
         CratesPlugin.spawnedCratesConfig = var1;
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }

   // $FF: synthetic class
   @Metadata(
      mv = {2, 1, 0},
      k = 3,
      xi = 48
   )
   public class WhenMappings {
      // $FF: synthetic field
      public static final int[] $EnumSwitchMapping$0;
      // $FF: synthetic field
      public static final int[] $EnumSwitchMapping$1;

      static {
         int[] var0 = new int[InventoryRerollInput.Action.values().length];

         try {
            var0[InventoryRerollInput.Action.CANCEL.ordinal()] = 1;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[InventoryRerollInput.Action.REROLL.ordinal()] = 2;
         } catch (NoSuchFieldError var6) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[Action.values().length];

         try {
            var0[Action.LEFT_CLICK_AIR.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[Action.LEFT_CLICK_BLOCK.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[Action.RIGHT_CLICK_AIR.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[Action.RIGHT_CLICK_BLOCK.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$1 = var0;
      }
   }
}
