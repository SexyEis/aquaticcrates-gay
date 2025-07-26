package gg.aquatic.aquaticcrates.plugin.animation.open;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationManager;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationSettings;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.api.crate.CrateHandler;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.aquaticcrates.api.reroll.RerollManager;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.aquaticcrates.plugin.animation.fail.FailAnimation;
import gg.aquatic.aquaticcrates.plugin.animation.fail.settings.FailAnimationSettings;
import gg.aquatic.aquaticcrates.plugin.animation.idle.settings.IdleAnimationSettings;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.collections.MapsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.chance.ChanceUtilsKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001eH\u0016J\u0018\u0010)\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\u001aH\u0016J\b\u0010.\u001a\u00020'H\u0016J\u0010\u0010/\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0016J\b\u00101\u001a\u00020'H\u0016J\u0010\u00102\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0016J\b\u00103\u001a\u00020'H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR&\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\"R,\u0010#\u001a\u001a\u0012\u0004\u0012\u00020\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020$0\u00170\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001c¨\u00064"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/open/AnimationManagerImpl;", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;", "crate", "Lgg/aquatic/aquaticcrates/api/crate/OpenableCrate;", "animationSettings", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "idleAnimationSettings", "", "Lgg/aquatic/aquaticcrates/plugin/animation/idle/settings/IdleAnimationSettings;", "failAnimationSettings", "Lgg/aquatic/aquaticcrates/plugin/animation/fail/settings/FailAnimationSettings;", "rerollManager", "Lgg/aquatic/waves/libs/kotlin/Function1;", "Lgg/aquatic/aquaticcrates/api/reroll/RerollManager;", "<init>", "(Lgg/aquatic/aquaticcrates/api/crate/OpenableCrate;Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;Ljava/util/Collection;Lgg/aquatic/aquaticcrates/plugin/animation/fail/settings/FailAnimationSettings;Lkotlin/jvm/functions/Function1;)V", "getCrate", "()Lgg/aquatic/aquaticcrates/api/crate/OpenableCrate;", "getAnimationSettings", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "getRerollManager", "()Lgg/aquatic/aquaticcrates/api/reroll/RerollManager;", "playingAnimations", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/UUID;", "", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "getPlayingAnimations", "()Ljava/util/concurrent/ConcurrentHashMap;", "idleAnimation", "Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "getIdleAnimation", "setIdleAnimation", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "failAnimations", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "getFailAnimations", "playNewIdleAnimation", "", "spawnedCrate", "playFailAnimation", "player", "Lorg/bukkit/entity/Player;", "playAnimation", "animation", "tick", "skipAnimation", "forceStopAnimation", "forceStopAnimations", "forceStopAllAnimationTypes", "forceStopAllAnimations", "plugin"}
)
@SourceDebugExtension({"SMAP\nAnimationManagerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimationManagerImpl.kt\ngg/aquatic/aquaticcrates/plugin/animation/open/AnimationManagerImpl\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,126:1\n72#2,2:127\n72#2,2:134\n1#3:129\n1#3:136\n1869#4,2:130\n1869#4,2:132\n1869#4,2:141\n1869#4,2:147\n1869#4,2:149\n1869#4,2:151\n12#5,4:137\n12#5,4:143\n*S KotlinDebug\n*F\n+ 1 AnimationManagerImpl.kt\ngg/aquatic/aquaticcrates/plugin/animation/open/AnimationManagerImpl\n*L\n41#1:127,2\n55#1:134,2\n41#1:129\n55#1:136\n43#1:130,2\n53#1:132,2\n91#1:141,2\n106#1:147,2\n115#1:149,2\n122#1:151,2\n76#1:137,4\n92#1:143,4\n*E\n"})
public final class AnimationManagerImpl extends CrateAnimationManager {
   @NotNull
   private final OpenableCrate crate;
   @NotNull
   private final CrateAnimationSettings animationSettings;
   @NotNull
   private final Collection<IdleAnimationSettings> idleAnimationSettings;
   @Nullable
   private final FailAnimationSettings failAnimationSettings;
   @Nullable
   private final RerollManager rerollManager;
   @NotNull
   private final ConcurrentHashMap<UUID, Set<CrateAnimation>> playingAnimations;
   @NotNull
   private ConcurrentHashMap<SpawnedCrate, Animation> idleAnimation;
   @NotNull
   private final ConcurrentHashMap<SpawnedCrate, ConcurrentHashMap<UUID, PlayerBoundAnimation>> failAnimations;

   public AnimationManagerImpl(@NotNull OpenableCrate var1, @NotNull CrateAnimationSettings var2, @NotNull Collection<IdleAnimationSettings> var3, @Nullable FailAnimationSettings var4, @NotNull Function1<? super OpenableCrate, ? extends RerollManager> var5) {
      Intrinsics.checkNotNullParameter(var1, "crate");
      Intrinsics.checkNotNullParameter(var2, "animationSettings");
      Intrinsics.checkNotNullParameter(var3, "idleAnimationSettings");
      Intrinsics.checkNotNullParameter(var5, "rerollManager");
      super();
      this.crate = var1;
      this.animationSettings = var2;
      this.idleAnimationSettings = var3;
      this.failAnimationSettings = var4;
      this.rerollManager = (RerollManager)var5.invoke(this.getCrate());
      this.playingAnimations = new ConcurrentHashMap();
      this.idleAnimation = new ConcurrentHashMap();
      this.failAnimations = new ConcurrentHashMap();
   }

   @NotNull
   public OpenableCrate getCrate() {
      return this.crate;
   }

   @NotNull
   public CrateAnimationSettings getAnimationSettings() {
      return this.animationSettings;
   }

   @Nullable
   public RerollManager getRerollManager() {
      return this.rerollManager;
   }

   @NotNull
   public ConcurrentHashMap<UUID, Set<CrateAnimation>> getPlayingAnimations() {
      return this.playingAnimations;
   }

   @NotNull
   public ConcurrentHashMap<SpawnedCrate, Animation> getIdleAnimation() {
      return this.idleAnimation;
   }

   public void setIdleAnimation(@NotNull ConcurrentHashMap<SpawnedCrate, Animation> var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.idleAnimation = var1;
   }

   @NotNull
   public ConcurrentHashMap<SpawnedCrate, ConcurrentHashMap<UUID, PlayerBoundAnimation>> getFailAnimations() {
      return this.failAnimations;
   }

   public void playNewIdleAnimation(@NotNull SpawnedCrate var1) {
      Intrinsics.checkNotNullParameter(var1, "spawnedCrate");
      IdleAnimationSettings var10000 = (IdleAnimationSettings)ChanceUtilsKt.randomItem(this.idleAnimationSettings);
      if (var10000 != null) {
         IdleAnimationSettings var2 = var10000;
         ((Map)this.getIdleAnimation()).put(var1, var2.create(var1));
      }
   }

   public void playFailAnimation(@NotNull SpawnedCrate var1, @NotNull Player var2) {
      Intrinsics.checkNotNullParameter(var1, "spawnedCrate");
      Intrinsics.checkNotNullParameter(var2, "player");
      ConcurrentMap var4 = (ConcurrentMap)this.getFailAnimations();
      boolean var5 = false;
      Object var10000 = var4.get(var1);
      boolean var8;
      if (var10000 == null) {
         boolean var6 = false;
         ConcurrentHashMap var7 = new ConcurrentHashMap();
         var8 = false;
         var10000 = var4.putIfAbsent(var1, var7);
         if (var10000 == null) {
            var10000 = var7;
         }
      }

      ConcurrentHashMap var3 = (ConcurrentHashMap)var10000;
      PlayerBoundAnimation var13 = (PlayerBoundAnimation)var3.remove(var2.getUniqueId());
      if (var13 != null) {
         Map var16 = var13.getProps();
         if (var16 != null) {
            Collection var17 = var16.values();
            if (var17 != null) {
               Iterable var15 = (Iterable)var17;
               var8 = false;
               Iterator var9 = var15.iterator();

               while(var9.hasNext()) {
                  Object var10 = var9.next();
                  AnimationProp var11 = (AnimationProp)var10;
                  boolean var12 = false;
                  var11.onAnimationEnd();
               }
            }
         }
      }

      FailAnimationSettings var18 = this.failAnimationSettings;
      if (var18 != null) {
         FailAnimation var19 = var18.create(var1, var2);
         if (var19 != null) {
            FailAnimation var14 = var19;
            Intrinsics.checkNotNull(var3);
            ((Map)var3).put(var2.getUniqueId(), var14);
            return;
         }
      }

   }

   public void playAnimation(@NotNull CrateAnimation var1) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      SpawnedCrate var2 = (SpawnedCrate)CrateHandler.INSTANCE.getSpawned().get(var1.getBaseLocation());
      boolean var7;
      if (var2 != null) {
         ConcurrentHashMap var10000 = (ConcurrentHashMap)this.getFailAnimations().get(var2);
         PlayerBoundAnimation var3 = var10000 != null ? (PlayerBoundAnimation)var10000.remove(var1.getPlayer().getUniqueId()) : null;
         if (var3 != null) {
            Map var16 = var3.getProps();
            if (var16 != null) {
               Collection var17 = var16.values();
               if (var17 != null) {
                  Iterable var6 = (Iterable)var17;
                  var7 = false;
                  Iterator var8 = var6.iterator();

                  while(var8.hasNext()) {
                     Object var9 = var8.next();
                     AnimationProp var10 = (AnimationProp)var9;
                     boolean var11 = false;
                     var10.onAnimationEnd();
                  }
               }
            }
         }
      }

      ConcurrentMap var4 = (ConcurrentMap)this.getPlayingAnimations();
      UUID var5 = var1.getPlayer().getUniqueId();
      boolean var13 = false;
      Object var18 = var4.get(var5);
      if (var18 == null) {
         var7 = false;
         Set var14 = (Set)ConcurrentHashMap.newKeySet();
         boolean var15 = false;
         var18 = var4.putIfAbsent(var5, var14);
         if (var18 == null) {
            var18 = var14;
         }
      }

      Set var12 = (Set)var18;
      Intrinsics.checkNotNull(var12);
      ((Collection)var12).add(var1);
   }

   public void tick() {
      Iterator var1 = ((Map)this.getPlayingAnimations()).entrySet().iterator();

      while(var1.hasNext()) {
         Set var3 = (Set)((Entry)var1.next()).getValue();
         Iterator var4 = CollectionsKt.toMutableList((Collection)var3).iterator();

         while(var4.hasNext()) {
            CrateAnimation var5 = (CrateAnimation)var4.next();
            var5.tick();
         }
      }

      var1 = ((Map)this.getIdleAnimation()).entrySet().iterator();

      while(var1.hasNext()) {
         Animation var6 = (Animation)((Entry)var1.next()).getValue();
         var6.tick();
      }

      var1 = ((Map)this.getFailAnimations()).entrySet().iterator();

      while(var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         Iterator var7 = MapsKt.toMutableMap((Map)var2.getValue()).entrySet().iterator();

         while(var7.hasNext()) {
            PlayerBoundAnimation var8 = (PlayerBoundAnimation)((Entry)var7.next()).getValue();
            var8.tick();
         }
      }

   }

   public void skipAnimation(@NotNull Player var1) {
      Intrinsics.checkNotNullParameter(var1, "player");
      boolean var2 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTaskAsynchronously((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new AnimationManagerImpl$skipAnimation$$inlined$runAsync$1(this, var1)));
   }

   public void forceStopAnimation(@NotNull Player var1) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Set var10000 = (Set)this.getPlayingAnimations().get(var1.getUniqueId());
      if (var10000 != null) {
         Set var2 = var10000;
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            CrateAnimation var4 = (CrateAnimation)var3.next();
            var4.finalizeAnimation(true);
         }

      }
   }

   public void forceStopAnimations() {
      Iterator var1 = ((Map)this.getPlayingAnimations()).entrySet().iterator();

      while(var1.hasNext()) {
         Set var2 = (Set)((Entry)var1.next()).getValue();
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            CrateAnimation var4 = (CrateAnimation)var3.next();
            Iterable var5 = (Iterable)var4.getRewards();
            boolean var6 = false;
            Iterator var7 = var5.iterator();

            while(var7.hasNext()) {
               Object var8 = var7.next();
               RolledReward var9 = (RolledReward)var8;
               boolean var10 = false;
               var9.give(var4.getPlayer(), false);
            }

            boolean var11 = false;
            Waves.Companion.getINSTANCE().getServer().getScheduler().runTaskAsynchronously((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new AnimationManagerImpl$forceStopAnimations$$inlined$runAsync$1(var4)));
         }
      }

      this.getPlayingAnimations().clear();
   }

   public void forceStopAllAnimationTypes(@NotNull Player var1) {
      Intrinsics.checkNotNullParameter(var1, "player");
      this.forceStopAnimation(var1);
      Iterator var2 = ((Map)this.getFailAnimations()).entrySet().iterator();

      while(true) {
         while(var2.hasNext()) {
            ConcurrentHashMap var3 = (ConcurrentHashMap)((Entry)var2.next()).getValue();
            PlayerBoundAnimation var10000 = (PlayerBoundAnimation)var3.remove(var1.getUniqueId());
            if (var10000 != null) {
               PlayerBoundAnimation var4 = var10000;
               Iterable var5 = (Iterable)var4.getProps().values();
               boolean var6 = false;
               Iterator var7 = var5.iterator();

               while(var7.hasNext()) {
                  Object var8 = var7.next();
                  AnimationProp var9 = (AnimationProp)var8;
                  boolean var10 = false;
                  var9.onAnimationEnd();
               }
            }
         }

         return;
      }
   }

   public void forceStopAllAnimations() {
      this.forceStopAnimations();
      Iterator var1 = ((Map)this.getFailAnimations()).entrySet().iterator();

      while(var1.hasNext()) {
         ConcurrentHashMap var2 = (ConcurrentHashMap)((Entry)var1.next()).getValue();
         Iterator var3 = ((Map)var2).entrySet().iterator();

         while(var3.hasNext()) {
            PlayerBoundAnimation var5 = (PlayerBoundAnimation)((Entry)var3.next()).getValue();
            Iterable var6 = (Iterable)var5.getProps().values();
            boolean var7 = false;
            Iterator var8 = var6.iterator();

            while(var8.hasNext()) {
               Object var9 = var8.next();
               AnimationProp var10 = (AnimationProp)var9;
               boolean var11 = false;
               var10.onAnimationEnd();
            }
         }
      }

      this.getPlayingAnimations().clear();
      this.getFailAnimations().clear();
      var1 = ((Map)this.getIdleAnimation()).entrySet().iterator();

      while(var1.hasNext()) {
         Animation var12 = (Animation)((Entry)var1.next()).getValue();
         Iterable var13 = (Iterable)var12.getProps().values();
         boolean var4 = false;
         Iterator var14 = var13.iterator();

         while(var14.hasNext()) {
            Object var15 = var14.next();
            AnimationProp var16 = (AnimationProp)var15;
            boolean var17 = false;
            var16.onAnimationEnd();
         }
      }

      this.getIdleAnimation().clear();
   }
}
