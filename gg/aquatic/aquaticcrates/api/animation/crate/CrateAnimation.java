package gg.aquatic.aquaticcrates.api.animation.crate;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.reroll.RerollManager;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.NoWhenBranchMatchedException;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntries;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntriesKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function0;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.util.NumberExtKt;
import gg.aquatic.waves.util.PAPIUtilKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0002=>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010)\u001a\u00020\u0015H\u0016J\b\u0010*\u001a\u00020\u0015H\u0016J\u0006\u0010+\u001a\u00020\u0015J\b\u0010,\u001a\u00020\u0015H&J\u0010\u0010-\u001a\u00020\u00152\b\b\u0002\u0010.\u001a\u00020/J\u0010\u00100\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/H\u0016J\u000e\u00101\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\tJ\u0010\u00102\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u000204H\u0016J\u0006\u0010<\u001a\u00020\u0015R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@dX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00000\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020 X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001d\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u00106\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006?"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "<init>", "()V", "animationManager", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;", "getAnimationManager", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;", "value", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation$State;", "state", "getState", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation$State;", "setState", "(Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation$State;)V", "rewards", "", "Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "getRewards", "()Ljava/util/List;", "tickPreOpen", "", "tickOpening", "tickPostOpen", "executeActions", "actions", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "completionFuture", "Ljava/util/concurrent/CompletableFuture;", "getCompletionFuture", "()Ljava/util/concurrent/CompletableFuture;", "settings", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "getSettings", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "playerEquipment", "Ljava/util/concurrent/ConcurrentHashMap;", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation$EquipmentSlot;", "Lorg/bukkit/inventory/ItemStack;", "getPlayerEquipment", "()Ljava/util/concurrent/ConcurrentHashMap;", "tick", "onTick", "tryReroll", "onReroll", "finalizeAnimation", "isSync", "", "onFinalize", "updateState", "onStateUpdate", "updatePlaceholders", "", "str", "usedRerolls", "", "getUsedRerolls", "()I", "setUsedRerolls", "(I)V", "skip", "State", "EquipmentSlot", "api"}
)
@SourceDebugExtension({"SMAP\nCrateAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrateAnimation.kt\ngg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation\n+ 2 AbstractCratesPlugin.kt\ngg/aquatic/aquaticcrates/api/AbstractCratesPluginKt\n+ 3 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,236:1\n22#2,6:237\n22#2,6:243\n22#2,6:249\n22#2,6:261\n6#3,4:255\n216#4,2:259\n*S KotlinDebug\n*F\n+ 1 CrateAnimation.kt\ngg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation\n*L\n39#1:237,6\n122#1:243,6\n127#1:249,6\n134#1:261,6\n143#1:255,4\n178#1:259,2\n*E\n"})
public abstract class CrateAnimation extends PlayerBoundAnimation {
   @NotNull
   private final ConcurrentHashMap<CrateAnimation.EquipmentSlot, ItemStack> playerEquipment = new ConcurrentHashMap();
   private int usedRerolls;

   @NotNull
   public abstract CrateAnimationManager getAnimationManager();

   @NotNull
   public abstract CrateAnimation.State getState();

   protected abstract void setState(@NotNull CrateAnimation.State var1);

   @NotNull
   public abstract List<RolledReward> getRewards();

   public final void tickPreOpen() {
      CrateAnimationActions var10001 = (CrateAnimationActions)this.getAnimationManager().getAnimationSettings().getPreAnimationTasks().get(this.getTick());
      if (var10001 != null) {
         this.executeActions(var10001);
      }
   }

   public final void tickOpening() {
      CrateAnimationActions var10001 = (CrateAnimationActions)this.getAnimationManager().getAnimationSettings().getAnimationTasks().get(this.getTick());
      if (var10001 != null) {
         this.executeActions(var10001);
      }
   }

   public final void tickPostOpen() {
      CrateAnimationActions var10001 = (CrateAnimationActions)this.getAnimationManager().getAnimationSettings().getPostAnimationTasks().get(this.getTick());
      if (var10001 != null) {
         this.executeActions(var10001);
      }
   }

   public void executeActions(@NotNull CrateAnimationActions var1) {
      Intrinsics.checkNotNullParameter(var1, "actions");
      boolean var2 = false;

      try {
         boolean var3 = false;
         var1.execute((Animation)this);
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }

   @NotNull
   public abstract CompletableFuture<CrateAnimation> getCompletionFuture();

   @NotNull
   public abstract CrateAnimationSettings getSettings();

   @NotNull
   public final ConcurrentHashMap<CrateAnimation.EquipmentSlot, ItemStack> getPlayerEquipment() {
      return this.playerEquipment;
   }

   public void tick() {
      try {
         this.onTick();
         switch(CrateAnimation.WhenMappings.$EnumSwitchMapping$0[this.getState().ordinal()]) {
         case 1:
            this.tickPreOpen();
            if (this.getTick() >= this.getSettings().getPreAnimationDelay()) {
               this.updateState(CrateAnimation.State.OPENING);
               this.tick();
               return;
            }
            break;
         case 2:
            this.tickOpening();
            if (this.getTick() >= this.getSettings().getAnimationLength()) {
               this.tryReroll();
               return;
            }
            break;
         case 3:
            this.tickPostOpen();
            if (this.getTick() >= this.getSettings().getPostAnimationDelay()) {
               finalizeAnimation$default(this, false, 1, (Object)null);
               return;
            }
            break;
         default:
            return;
         }

         Iterator var1 = this.getProps().entrySet().iterator();

         while(var1.hasNext()) {
            AnimationProp var3 = (AnimationProp)((Entry)var1.next()).getValue();
            var3.tick();
         }

         int var5 = this.getTick();
         this.setTick(var5 + 1);
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }

   public void onTick() {
   }

   public final void tryReroll() {
      Crate var1 = this.getAnimationManager().getCrate();
      if (!(var1 instanceof OpenableCrate)) {
         this.updateState(CrateAnimation.State.POST_OPEN);
         this.tick();
      } else {
         RerollManager var2 = this.getAnimationManager().getRerollManager();
         if (var2 == null) {
            this.updateState(CrateAnimation.State.POST_OPEN);
            this.tick();
         } else {
            int var3 = var2.availableRerolls(this.getPlayer());
            if (var3 <= this.usedRerolls) {
               this.updateState(CrateAnimation.State.POST_OPEN);
               this.tick();
            } else {
               this.updateState(CrateAnimation.State.ROLLING);
               this.onReroll();
            }
         }
      }
   }

   public abstract void onReroll();

   public final void finalizeAnimation(boolean var1) {
      this.updateState(CrateAnimation.State.FINISHED);
      boolean var2 = false;

      boolean var3;
      try {
         var3 = false;
         this.onFinalize(var1);
      } catch (Exception var9) {
         var9.printStackTrace();
      }

      this.executeActions(this.getAnimationManager().getAnimationSettings().getFinalAnimationTasks());
      Iterator var10 = this.getProps().entrySet().iterator();

      boolean var6;
      while(var10.hasNext()) {
         AnimationProp var4 = (AnimationProp)((Entry)var10.next()).getValue();
         boolean var5 = false;

         try {
            var6 = false;
            var4.onAnimationEnd();
         } catch (Exception var8) {
            var8.printStackTrace();
         }
      }

      this.getProps().clear();
      Function0 var11 = CrateAnimation::finalizeAnimation$lambda$4;
      if (var1) {
         var11.invoke();
      } else {
         var3 = false;
         Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new CrateAnimation$finalizeAnimation$$inlined$runSync$1(var11)));
      }

      Set var10000 = (Set)this.getAnimationManager().getPlayingAnimations().get(this.getPlayer().getUniqueId());
      if (var10000 != null) {
         Set var12 = var10000;
         var6 = false;
         var12.remove(this);
         if (var12.isEmpty()) {
            this.getAnimationManager().getPlayingAnimations().remove(this.getPlayer().getUniqueId());
         }
      }

      this.getCompletionFuture().complete(this);
   }

   // $FF: synthetic method
   public static void finalizeAnimation$default(CrateAnimation var0, boolean var1, int var2, Object var3) {
      if (var3 != null) {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finalizeAnimation");
      } else {
         if ((var2 & 1) != 0) {
            var1 = false;
         }

         var0.finalizeAnimation(var1);
      }
   }

   public void onFinalize(boolean var1) {
   }

   public final void updateState(@NotNull CrateAnimation.State var1) {
      Intrinsics.checkNotNullParameter(var1, "state");
      this.onStateUpdate(var1);
      this.setState(var1);
      this.setTick(0);
   }

   public void onStateUpdate(@NotNull CrateAnimation.State var1) {
      Intrinsics.checkNotNullParameter(var1, "state");
   }

   @NotNull
   public String updatePlaceholders(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "str");
      String var2 = null;
      String var10002 = this.getPlayer().getName();
      Intrinsics.checkNotNullExpressionValue(var10002, "getName(...)");
      var2 = StringsKt.replace$default(var1, "%player%", var10002, false, 4, (Object)null);
      Iterator var3 = ((Iterable)this.getRewards()).iterator();
      int var4 = 0;

      while(var3.hasNext()) {
         int var5 = var4++;
         RolledReward var6 = (RolledReward)var3.next();
         var2 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(var2, "%random-amount:" + var5 + "%", String.valueOf(var6.getRandomAmount()), false, 4, (Object)null), "%reward-name:" + var5 + "%", var6.getReward().getDisplayName(), false, 4, (Object)null), "%reward-rarity-name:" + var5 + "%", var6.getReward().getRarity().getDisplayName(), false, 4, (Object)null), "%reward-rarity-id:" + var5 + "%", var6.getReward().getRarity().getRarityId(), false, 4, (Object)null), "%reward-id:" + var5 + "%", var6.getReward().getId(), false, 4, (Object)null), "%reward-chance:" + var5 + "%", NumberExtKt.decimals(var6.getReward().getChance() * 100.0D, 2), false, 4, (Object)null);
         Map var7 = var6.getReward().getVariables();
         boolean var8 = false;

         String var13;
         String var14;
         for(Iterator var9 = var7.entrySet().iterator(); var9.hasNext(); var2 = StringsKt.replace$default(var2, "%reward-var:" + var5 + ":" + var13 + ":" + var5 + "%", var14, false, 4, (Object)null)) {
            Entry var10 = (Entry)var9.next();
            boolean var12 = false;
            var13 = (String)var10.getKey();
            var14 = (String)var10.getValue();
         }
      }

      RerollManager var10000 = this.getAnimationManager().getRerollManager();
      int var15 = var10000 != null ? var10000.availableRerolls(this.getPlayer()) : 0;
      Object var16 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(var2, "%rerolls-total%", String.valueOf(var15), false, 4, (Object)null), "%rerolls-used%", String.valueOf(this.usedRerolls), false, 4, (Object)null), "%rerolls-remaining%", String.valueOf(var15 - this.usedRerolls), false, 4, (Object)null);

      Function1 var18;
      for(Iterator var17 = ((Map)this.getExtraPlaceholders()).entrySet().iterator(); var17.hasNext(); var16 = var18.invoke(var16)) {
         var18 = (Function1)((Entry)var17.next()).getValue();
      }

      return PAPIUtilKt.updatePAPIPlaceholders((String)var16, this.getPlayer());
   }

   public final int getUsedRerolls() {
      return this.usedRerolls;
   }

   public final void setUsedRerolls(int var1) {
      this.usedRerolls = var1;
   }

   public final void skip() {
      if (this.getState() != CrateAnimation.State.ROLLING && this.getState() != CrateAnimation.State.FINISHED) {
         this.tryReroll();
      }
   }

   private static final Unit finalizeAnimation$lambda$4(CrateAnimation var0) {
      Iterator var1 = var0.getRewards().iterator();

      while(var1.hasNext()) {
         RolledReward var2 = (RolledReward)var1.next();
         boolean var3 = false;

         try {
            boolean var4 = false;
            var2.give(var0.getPlayer(), false);
         } catch (Exception var6) {
            var6.printStackTrace();
         }
      }

      return Unit.INSTANCE;
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0017"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation$EquipmentSlot;", "", "<init>", "(Ljava/lang/String;I)V", "HELMET", "CHESTPLATE", "LEGGINGS", "BOOTS", "HAND", "OFFHAND", "NUM_0", "NUM_1", "NUM_2", "NUM_3", "NUM_4", "NUM_5", "NUM_6", "NUM_7", "NUM_8", "toSlot", "", "player", "Lorg/bukkit/entity/Player;", "api"}
   )
   public static enum EquipmentSlot {
      HELMET,
      CHESTPLATE,
      LEGGINGS,
      BOOTS,
      HAND,
      OFFHAND,
      NUM_0,
      NUM_1,
      NUM_2,
      NUM_3,
      NUM_4,
      NUM_5,
      NUM_6,
      NUM_7,
      NUM_8;

      // $FF: synthetic field
      private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

      public final int toSlot(@NotNull Player var1) {
         Intrinsics.checkNotNullParameter(var1, "player");
         int var10000;
         switch(CrateAnimation.EquipmentSlot.WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
         case 1:
            var10000 = 5;
            break;
         case 2:
            var10000 = 6;
            break;
         case 3:
            var10000 = 7;
            break;
         case 4:
            var10000 = 8;
            break;
         case 5:
            var10000 = var1.getInventory().getHeldItemSlot();
            break;
         case 6:
            var10000 = 45;
            break;
         case 7:
            var10000 = 36;
            break;
         case 8:
            var10000 = 37;
            break;
         case 9:
            var10000 = 38;
            break;
         case 10:
            var10000 = 39;
            break;
         case 11:
            var10000 = 40;
            break;
         case 12:
            var10000 = 41;
            break;
         case 13:
            var10000 = 42;
            break;
         case 14:
            var10000 = 43;
            break;
         case 15:
            var10000 = 44;
            break;
         default:
            throw new NoWhenBranchMatchedException();
         }

         return var10000;
      }

      @NotNull
      public static EnumEntries<CrateAnimation.EquipmentSlot> getEntries() {
         return $ENTRIES;
      }

      // $FF: synthetic method
      private static final CrateAnimation.EquipmentSlot[] $values() {
         CrateAnimation.EquipmentSlot[] var0 = new CrateAnimation.EquipmentSlot[]{HELMET, CHESTPLATE, LEGGINGS, BOOTS, HAND, OFFHAND, NUM_0, NUM_1, NUM_2, NUM_3, NUM_4, NUM_5, NUM_6, NUM_7, NUM_8};
         return var0;
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
            int[] var0 = new int[CrateAnimation.EquipmentSlot.values().length];

            try {
               var0[CrateAnimation.EquipmentSlot.HELMET.ordinal()] = 1;
            } catch (NoSuchFieldError var16) {
            }

            try {
               var0[CrateAnimation.EquipmentSlot.CHESTPLATE.ordinal()] = 2;
            } catch (NoSuchFieldError var15) {
            }

            try {
               var0[CrateAnimation.EquipmentSlot.LEGGINGS.ordinal()] = 3;
            } catch (NoSuchFieldError var14) {
            }

            try {
               var0[CrateAnimation.EquipmentSlot.BOOTS.ordinal()] = 4;
            } catch (NoSuchFieldError var13) {
            }

            try {
               var0[CrateAnimation.EquipmentSlot.HAND.ordinal()] = 5;
            } catch (NoSuchFieldError var12) {
            }

            try {
               var0[CrateAnimation.EquipmentSlot.OFFHAND.ordinal()] = 6;
            } catch (NoSuchFieldError var11) {
            }

            try {
               var0[CrateAnimation.EquipmentSlot.NUM_0.ordinal()] = 7;
            } catch (NoSuchFieldError var10) {
            }

            try {
               var0[CrateAnimation.EquipmentSlot.NUM_1.ordinal()] = 8;
            } catch (NoSuchFieldError var9) {
            }

            try {
               var0[CrateAnimation.EquipmentSlot.NUM_2.ordinal()] = 9;
            } catch (NoSuchFieldError var8) {
            }

            try {
               var0[CrateAnimation.EquipmentSlot.NUM_3.ordinal()] = 10;
            } catch (NoSuchFieldError var7) {
            }

            try {
               var0[CrateAnimation.EquipmentSlot.NUM_4.ordinal()] = 11;
            } catch (NoSuchFieldError var6) {
            }

            try {
               var0[CrateAnimation.EquipmentSlot.NUM_5.ordinal()] = 12;
            } catch (NoSuchFieldError var5) {
            }

            try {
               var0[CrateAnimation.EquipmentSlot.NUM_6.ordinal()] = 13;
            } catch (NoSuchFieldError var4) {
            }

            try {
               var0[CrateAnimation.EquipmentSlot.NUM_7.ordinal()] = 14;
            } catch (NoSuchFieldError var3) {
            }

            try {
               var0[CrateAnimation.EquipmentSlot.NUM_8.ordinal()] = 15;
            } catch (NoSuchFieldError var2) {
            }

            $EnumSwitchMapping$0 = var0;
         }
      }
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation$State;", "", "<init>", "(Ljava/lang/String;I)V", "PRE_OPEN", "OPENING", "ROLLING", "POST_OPEN", "FINISHED", "api"}
   )
   public static enum State {
      PRE_OPEN,
      OPENING,
      ROLLING,
      POST_OPEN,
      FINISHED;

      // $FF: synthetic field
      private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

      @NotNull
      public static EnumEntries<CrateAnimation.State> getEntries() {
         return $ENTRIES;
      }

      // $FF: synthetic method
      private static final CrateAnimation.State[] $values() {
         CrateAnimation.State[] var0 = new CrateAnimation.State[]{PRE_OPEN, OPENING, ROLLING, POST_OPEN, FINISHED};
         return var0;
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

      static {
         int[] var0 = new int[CrateAnimation.State.values().length];

         try {
            var0[CrateAnimation.State.PRE_OPEN.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[CrateAnimation.State.OPENING.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[CrateAnimation.State.POST_OPEN.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
