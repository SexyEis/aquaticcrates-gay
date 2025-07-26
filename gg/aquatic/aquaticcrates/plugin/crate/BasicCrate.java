package gg.aquatic.aquaticcrates.plugin.crate;

import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationManager;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationSettings;
import gg.aquatic.aquaticcrates.api.crate.CrateHandler;
import gg.aquatic.aquaticcrates.api.crate.Key;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.aquaticcrates.api.hologram.HologramSettings;
import gg.aquatic.aquaticcrates.api.interaction.crate.CrateInteractHandler;
import gg.aquatic.aquaticcrates.api.openprice.OpenPriceGroup;
import gg.aquatic.aquaticcrates.api.reward.RewardManager;
import gg.aquatic.aquaticcrates.plugin.preview.CratePreviewMenu;
import gg.aquatic.aquaticcrates.plugin.preview.CratePreviewMenuSettings;
import gg.aquatic.aquaticcrates.plugin.restriction.OpenData;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.interactable.settings.InteractableSettings;
import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.item.AquaticItemInteractEvent;
import gg.aquatic.waves.item.AquaticItemInteractEvent.InteractType;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.registry.ItemRegistryKt;
import gg.aquatic.waves.util.generic.ConfiguredExecutableObject;
import gg.aquatic.waves.util.requirement.ConfiguredRequirement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bõ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140\u0011\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00160\u0011\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00180\u0011\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b\u0012\u0018\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d0\u001c0\u000b\u0012\u0018\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d0\u001c0\u000b\u0012\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\f0\u000b¢\u0006\u0004\b!\u0010\"J\"\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\"\u0010J\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J(\u0010K\u001a\b\u0012\u0004\u0012\u00020M0L2\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J(\u0010N\u001a\b\u0012\u0004\u0012\u00020M0L2\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J-\u0010O\u001a\b\u0012\u0004\u0012\u00020M0L2\u0006\u0010E\u001a\u00020\r2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010QH\u0016¢\u0006\u0002\u0010SJ-\u0010T\u001a\b\u0012\u0004\u0012\u00020M0L2\u0006\u0010E\u001a\u00020\r2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010QH\u0016¢\u0006\u0002\u0010SJ\u001a\u0010U\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\r2\b\u0010V\u001a\u0004\u0018\u00010IH\u0016J \u0010W\u001a\u00020X2\u0006\u0010E\u001a\u00020\r2\u0006\u0010P\u001a\u00020Q2\b\u0010Y\u001a\u0004\u0018\u00010 R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R#\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d0\u001c0\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R#\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d0\u001c0\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0017\u001a\u00020\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0014\u0010\u0010\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020A¢\u0006\b\n\u0000\u001a\u0004\bB\u0010C¨\u0006Z"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/crate/BasicCrate;", "Lgg/aquatic/aquaticcrates/api/crate/OpenableCrate;", "identifier", "", "displayName", "hologramSettings", "Lgg/aquatic/aquaticcrates/api/hologram/HologramSettings;", "interactables", "", "Lgg/aquatic/waves/interactable/settings/InteractableSettings;", "openRequirements", "", "Lgg/aquatic/waves/util/requirement/ConfiguredRequirement;", "Lorg/bukkit/entity/Player;", "openPriceGroups", "Lgg/aquatic/aquaticcrates/api/openprice/OpenPriceGroup;", "animationManager", "Lgg/aquatic/waves/libs/kotlin/Function1;", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;", "key", "Lgg/aquatic/aquaticcrates/api/crate/Key;", "rewardManager", "Lgg/aquatic/aquaticcrates/api/reward/RewardManager;", "interactHandler", "Lgg/aquatic/aquaticcrates/api/interaction/crate/CrateInteractHandler;", "previewMenuSettings", "Lgg/aquatic/aquaticcrates/plugin/preview/CratePreviewMenuSettings;", "massOpenFinalActions", "Lgg/aquatic/waves/util/generic/ConfiguredExecutableObject;", "", "massOpenPerRewardActions", "openRestrictions", "Lgg/aquatic/aquaticcrates/plugin/restriction/OpenData;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lgg/aquatic/aquaticcrates/api/hologram/HologramSettings;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getIdentifier", "()Ljava/lang/String;", "getDisplayName", "getHologramSettings", "()Lgg/aquatic/aquaticcrates/api/hologram/HologramSettings;", "getInteractables", "()Ljava/util/List;", "getOpenRequirements", "getOpenPriceGroups", "getPreviewMenuSettings", "getMassOpenFinalActions", "getMassOpenPerRewardActions", "getOpenRestrictions", "openManager", "Lgg/aquatic/aquaticcrates/plugin/crate/BasicOpenManager;", "getOpenManager", "()Lgg/aquatic/aquaticcrates/plugin/crate/BasicOpenManager;", "setOpenManager", "(Lgg/aquatic/aquaticcrates/plugin/crate/BasicOpenManager;)V", "getInteractHandler", "()Lgg/aquatic/aquaticcrates/api/interaction/crate/CrateInteractHandler;", "setInteractHandler", "(Lgg/aquatic/aquaticcrates/api/interaction/crate/CrateInteractHandler;)V", "getRewardManager", "()Lgg/aquatic/aquaticcrates/api/reward/RewardManager;", "getAnimationManager", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;", "getKey", "()Lgg/aquatic/aquaticcrates/api/crate/Key;", "crateItem", "Lgg/aquatic/waves/item/AquaticItem;", "getCrateItem", "()Lgg/aquatic/waves/item/AquaticItem;", "tryInstantOpen", "player", "location", "Lorg/bukkit/Location;", "spawnedCrate", "Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "instantOpen", "tryOpen", "Ljava/util/concurrent/CompletableFuture;", "Ljava/lang/Void;", "open", "tryMassOpen", "amount", "", "threads", "(Lorg/bukkit/entity/Player;ILjava/lang/Integer;)Ljava/util/concurrent/CompletableFuture;", "massOpen", "openPreview", "placedCrate", "canBeOpened", "", "openData", "plugin"}
)
@SourceDebugExtension({"SMAP\nBasicCrate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicCrate.kt\ngg/aquatic/aquaticcrates/plugin/crate/BasicCrate\n+ 2 CollectionExt.kt\ngg/aquatic/waves/util/collection/CollectionExtKt\n+ 3 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,200:1\n15#2,4:201\n30#3,4:205\n*S KotlinDebug\n*F\n+ 1 BasicCrate.kt\ngg/aquatic/aquaticcrates/plugin/crate/BasicCrate\n*L\n161#1:201,4\n85#1:205,4\n*E\n"})
public final class BasicCrate extends OpenableCrate {
   @NotNull
   private final String identifier;
   @NotNull
   private final String displayName;
   @NotNull
   private final HologramSettings hologramSettings;
   @NotNull
   private final List<InteractableSettings> interactables;
   @NotNull
   private final List<ConfiguredRequirement<Player>> openRequirements;
   @NotNull
   private final List<OpenPriceGroup> openPriceGroups;
   @NotNull
   private final List<CratePreviewMenuSettings> previewMenuSettings;
   @NotNull
   private final List<ConfiguredExecutableObject<Player, Unit>> massOpenFinalActions;
   @NotNull
   private final List<ConfiguredExecutableObject<Player, Unit>> massOpenPerRewardActions;
   @NotNull
   private final List<ConfiguredRequirement<OpenData>> openRestrictions;
   @NotNull
   private BasicOpenManager openManager;
   @NotNull
   private CrateInteractHandler interactHandler;
   @NotNull
   private final RewardManager rewardManager;
   @NotNull
   private final CrateAnimationManager animationManager;
   @NotNull
   private final Key key;
   @NotNull
   private final AquaticItem crateItem;

   public BasicCrate(@NotNull String var1, @NotNull String var2, @NotNull HologramSettings var3, @NotNull List<? extends InteractableSettings> var4, @NotNull List<ConfiguredRequirement<Player>> var5, @NotNull List<OpenPriceGroup> var6, @NotNull Function1<? super BasicCrate, ? extends CrateAnimationManager> var7, @NotNull Function1<? super BasicCrate, ? extends Key> var8, @NotNull Function1<? super BasicCrate, ? extends RewardManager> var9, @NotNull Function1<? super BasicCrate, ? extends CrateInteractHandler> var10, @NotNull List<CratePreviewMenuSettings> var11, @NotNull List<ConfiguredExecutableObject<Player, Unit>> var12, @NotNull List<ConfiguredExecutableObject<Player, Unit>> var13, @NotNull List<ConfiguredRequirement<OpenData>> var14) {
      Intrinsics.checkNotNullParameter(var1, "identifier");
      Intrinsics.checkNotNullParameter(var2, "displayName");
      Intrinsics.checkNotNullParameter(var3, "hologramSettings");
      Intrinsics.checkNotNullParameter(var4, "interactables");
      Intrinsics.checkNotNullParameter(var5, "openRequirements");
      Intrinsics.checkNotNullParameter(var6, "openPriceGroups");
      Intrinsics.checkNotNullParameter(var7, "animationManager");
      Intrinsics.checkNotNullParameter(var8, "key");
      Intrinsics.checkNotNullParameter(var9, "rewardManager");
      Intrinsics.checkNotNullParameter(var10, "interactHandler");
      Intrinsics.checkNotNullParameter(var11, "previewMenuSettings");
      Intrinsics.checkNotNullParameter(var12, "massOpenFinalActions");
      Intrinsics.checkNotNullParameter(var13, "massOpenPerRewardActions");
      Intrinsics.checkNotNullParameter(var14, "openRestrictions");
      super();
      this.identifier = var1;
      this.displayName = var2;
      this.hologramSettings = var3;
      this.interactables = var4;
      this.openRequirements = var5;
      this.openPriceGroups = var6;
      this.previewMenuSettings = var11;
      this.massOpenFinalActions = var12;
      this.massOpenPerRewardActions = var13;
      this.openRestrictions = var14;
      this.openManager = new BasicOpenManager(this);
      this.interactHandler = (CrateInteractHandler)var10.invoke(this);
      this.rewardManager = (RewardManager)var9.invoke(this);
      this.animationManager = (CrateAnimationManager)var7.invoke(this);
      this.key = (Key)var8.invoke(this);
      ItemStack var15 = new ItemStack(Material.CHEST);
      Object var20 = null;
      boolean var17 = false;
      ItemMeta var18 = var15.getItemMeta();
      var18.displayName(Component.text("Crate: " + this.getIdentifier()).decoration(TextDecoration.ITALIC, false));
      var15.setItemMeta(var18);
      Unit var21 = Unit.INSTANCE;
      Object var22 = null;
      Object var23 = null;
      Object var24 = null;
      Object var25 = null;
      byte var26 = -1;
      byte var27 = 1;
      Object var28 = null;
      Object var29 = null;
      AquaticItem var32 = new AquaticItem((String)var20, var15, (String)var29, (List)var28, var27, var26, (String)var25, (Map)var24, (List)var23, (EntityType)var22);
      var17 = false;
      Function1 var33 = BasicCrate::crateItem$lambda$3$lambda$2;
      if (!ItemRegistryKt.register(var32, "aquaticcrates-crates", this.getIdentifier(), var33)) {
         ItemRegistryKt.setInteractionHandler(var32, var33);
      }

      this.crateItem = var32;
   }

   @NotNull
   public String getIdentifier() {
      return this.identifier;
   }

   @NotNull
   public String getDisplayName() {
      return this.displayName;
   }

   @NotNull
   public HologramSettings getHologramSettings() {
      return this.hologramSettings;
   }

   @NotNull
   public List<InteractableSettings> getInteractables() {
      return this.interactables;
   }

   @NotNull
   public List<ConfiguredRequirement<Player>> getOpenRequirements() {
      return this.openRequirements;
   }

   @NotNull
   public List<OpenPriceGroup> getOpenPriceGroups() {
      return this.openPriceGroups;
   }

   @NotNull
   public final List<CratePreviewMenuSettings> getPreviewMenuSettings() {
      return this.previewMenuSettings;
   }

   @NotNull
   public final List<ConfiguredExecutableObject<Player, Unit>> getMassOpenFinalActions() {
      return this.massOpenFinalActions;
   }

   @NotNull
   public final List<ConfiguredExecutableObject<Player, Unit>> getMassOpenPerRewardActions() {
      return this.massOpenPerRewardActions;
   }

   @NotNull
   public final List<ConfiguredRequirement<OpenData>> getOpenRestrictions() {
      return this.openRestrictions;
   }

   @NotNull
   public final BasicOpenManager getOpenManager() {
      return this.openManager;
   }

   public final void setOpenManager(@NotNull BasicOpenManager var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.openManager = var1;
   }

   @NotNull
   public CrateInteractHandler getInteractHandler() {
      return this.interactHandler;
   }

   public void setInteractHandler(@NotNull CrateInteractHandler var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.interactHandler = var1;
   }

   @NotNull
   public RewardManager getRewardManager() {
      return this.rewardManager;
   }

   @NotNull
   public CrateAnimationManager getAnimationManager() {
      return this.animationManager;
   }

   @NotNull
   public Key getKey() {
      return this.key;
   }

   @NotNull
   public final AquaticItem getCrateItem() {
      return this.crateItem;
   }

   public void tryInstantOpen(@NotNull Player var1, @NotNull Location var2, @Nullable SpawnedCrate var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "location");
      if (this.canBeOpened(var1, 1, (OpenData)null)) {
         this.instantOpen(var1, var2, var3);
      }
   }

   public void instantOpen(@NotNull Player var1, @NotNull Location var2, @Nullable SpawnedCrate var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "location");
      this.openManager.instantOpen(var1, false);
   }

   @NotNull
   public CompletableFuture<Void> tryOpen(@NotNull Player var1, @NotNull Location var2, @Nullable SpawnedCrate var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "location");
      if (!this.canBeOpened(var1, 1, new OpenData(var1, var2, (OpenableCrate)this))) {
         if (var3 != null) {
            boolean var5 = false;
            this.getAnimationManager().playFailAnimation(var3, var1);
         }

         CompletableFuture var10000 = CompletableFuture.completedFuture((Object)null);
         Intrinsics.checkNotNullExpressionValue(var10000, "completedFuture(...)");
         return var10000;
      } else {
         return this.open(var1, var2, var3);
      }
   }

   @NotNull
   public CompletableFuture<Void> open(@NotNull Player var1, @NotNull Location var2, @Nullable SpawnedCrate var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "location");
      return this.openManager.open(var1, var2, var3);
   }

   @NotNull
   public CompletableFuture<Void> tryMassOpen(@NotNull Player var1, int var2, @Nullable Integer var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      if (!this.canBeOpened(var1, var2, (OpenData)null)) {
         CompletableFuture var10000 = CompletableFuture.completedFuture((Object)null);
         Intrinsics.checkNotNullExpressionValue(var10000, "completedFuture(...)");
         return var10000;
      } else {
         return this.massOpen(var1, var2, var3);
      }
   }

   @NotNull
   public CompletableFuture<Void> massOpen(@NotNull Player var1, int var2, @Nullable Integer var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      return this.openManager.massOpen(var1, var2, var3);
   }

   public void openPreview(@NotNull Player var1, @Nullable SpawnedCrate var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      CratePreviewMenu var10000 = new CratePreviewMenu;
      CratePreviewMenuSettings var10005 = (CratePreviewMenuSettings)CollectionsKt.firstOrNull(this.previewMenuSettings);
      if (var10005 != null) {
         var10000.<init>(var1, this, var2, var10005, 0);
         CratePreviewMenu var3 = var10000;
         var3.open();
      }
   }

   public final boolean canBeOpened(@NotNull Player var1, int var2, @Nullable OpenData var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      if (var3 != null) {
         Collection var4 = (Collection)this.openRestrictions;
         boolean var5 = false;
         Iterator var6 = var4.iterator();

         boolean var10000;
         while(true) {
            if (!var6.hasNext()) {
               var10000 = true;
               break;
            }

            ConfiguredRequirement var7 = (ConfiguredRequirement)var6.next();
            if (!var7.execute(var3, (Function2)BasicCrate$canBeOpened$$inlined$checkRequirements$1.INSTANCE)) {
               var10000 = false;
               break;
            }
         }

         if (!var10000) {
            return false;
         }

         SpawnedCrate var8 = (SpawnedCrate)CrateHandler.INSTANCE.getSpawned().get(var3.getLocation());
         if (var8 != null) {
            ConcurrentHashMap var12 = (ConcurrentHashMap)this.getAnimationManager().getFailAnimations().get(var8);
            if (var12 != null ? var12.containsKey(var1.getUniqueId()) : false) {
               return false;
            }
         }

         CrateAnimationSettings.AnimationResult var10 = this.getAnimationManager().getAnimationSettings().canBeOpened(var1, this.getAnimationManager(), var3.getLocation());
         switch(BasicCrate.WhenMappings.$EnumSwitchMapping$0[var10.ordinal()]) {
         case 1:
            return false;
         case 2:
            return false;
         }
      }

      if (this.getRewardManager().getPossibleRewards(var1).isEmpty()) {
         return false;
      } else {
         Iterator var9 = this.getOpenPriceGroups().iterator();

         OpenPriceGroup var11;
         do {
            if (!var9.hasNext()) {
               return false;
            }

            var11 = (OpenPriceGroup)var9.next();
         } while(!var11.tryTake(var1, var2));

         return true;
      }
   }

   private static final Unit crateItem$lambda$3$lambda$2(BasicCrate var0, AquaticItemInteractEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "e");
      Event var2 = var1.getOriginalEvent();
      if (!(var2 instanceof InventoryClickEvent)) {
         var1.setCancelled(true);
         if (var2 instanceof PlayerInteractEvent) {
            Location var7;
            label16: {
               Block var10000 = ((PlayerInteractEvent)var2).getClickedBlock();
               if (var10000 != null) {
                  var7 = var10000.getLocation();
                  if (var7 != null) {
                     break label16;
                  }
               }

               var7 = ((PlayerInteractEvent)var2).getPlayer().getLocation();
               Intrinsics.checkNotNullExpressionValue(var7, "getLocation(...)");
            }

            Location var3 = var7;
            var3.setYaw(((PlayerInteractEvent)var2).getPlayer().getLocation().getYaw() - (float)180);
            if (var1.getInteractType() == InteractType.RIGHT) {
               long var4 = 2L;
               boolean var6 = false;
               Waves.Companion.getINSTANCE().getServer().getScheduler().runTaskLater((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new BasicCrate$crateItem$lambda$3$lambda$2$$inlined$runLaterSync$1(var0, var3)), var4);
               var1.getPlayer().sendMessage("Crate Spawned");
            }
         }
      }

      return Unit.INSTANCE;
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

      static {
         int[] var0 = new int[CrateAnimationSettings.AnimationResult.values().length];

         try {
            var0[CrateAnimationSettings.AnimationResult.ALREADY_BEING_OPENED.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[CrateAnimationSettings.AnimationResult.ALREADY_BEING_OPENED_OTHER.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
