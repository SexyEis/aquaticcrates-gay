package gg.aquatic.aquaticcrates.api.crate;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.api.hologram.Hologram;
import gg.aquatic.aquaticcrates.api.util.ACGlobalAudience;
import gg.aquatic.waves.interactable.Interactable;
import gg.aquatic.waves.interactable.InteractableInteractEvent;
import gg.aquatic.waves.interactable.settings.InteractableSettings;
import gg.aquatic.waves.item.AquaticItemInteractEvent.InteractType;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.PAPIUtilKt;
import gg.aquatic.waves.util.audience.AquaticAudience;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006 "},
   d2 = {"Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "", "crate", "Lgg/aquatic/aquaticcrates/api/crate/Crate;", "location", "Lorg/bukkit/Location;", "<init>", "(Lgg/aquatic/aquaticcrates/api/crate/Crate;Lorg/bukkit/Location;)V", "getCrate", "()Lgg/aquatic/aquaticcrates/api/crate/Crate;", "getLocation", "()Lorg/bukkit/Location;", "audience", "Lgg/aquatic/aquaticcrates/api/util/ACGlobalAudience;", "getAudience", "()Lgg/aquatic/aquaticcrates/api/util/ACGlobalAudience;", "hologram", "Lgg/aquatic/aquaticcrates/api/hologram/Hologram;", "getHologram", "()Lgg/aquatic/aquaticcrates/api/hologram/Hologram;", "spawnedInteractables", "", "Lgg/aquatic/waves/interactable/Interactable;", "getSpawnedInteractables", "()Ljava/util/List;", "destroy", "", "forceHide", "player", "Lorg/bukkit/entity/Player;", "hide", "", "api"}
)
@SourceDebugExtension({"SMAP\nSpawnedCrate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpawnedCrate.kt\ngg/aquatic/aquaticcrates/api/crate/SpawnedCrate\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,97:1\n1563#2:98\n1634#2,3:99\n1869#2,2:106\n1869#2,2:108\n1617#2,9:110\n1869#2:119\n1870#2:121\n1626#2:122\n1617#2,9:123\n1869#2:132\n1870#2:134\n1626#2:135\n216#3,2:102\n216#3,2:104\n1#4:120\n1#4:133\n*S KotlinDebug\n*F\n+ 1 SpawnedCrate.kt\ngg/aquatic/aquaticcrates/api/crate/SpawnedCrate\n*L\n19#1:98\n19#1:99,3\n69#1:106,2\n73#1:108,2\n78#1:110,9\n78#1:119\n78#1:121\n78#1:122\n91#1:123,9\n91#1:132\n91#1:134\n91#1:135\n55#1:102,2\n60#1:104,2\n78#1:120\n91#1:133\n*E\n"})
public final class SpawnedCrate {
   @NotNull
   private final Crate crate;
   @NotNull
   private final Location location;
   @NotNull
   private final ACGlobalAudience audience;
   @NotNull
   private final Hologram hologram;
   @NotNull
   private final List<Interactable> spawnedInteractables;

   public SpawnedCrate(@NotNull Crate var1, @NotNull Location var2) {
      Intrinsics.checkNotNullParameter(var1, "crate");
      Intrinsics.checkNotNullParameter(var2, "location");
      super();
      this.crate = var1;
      this.location = var2;
      this.audience = new ACGlobalAudience();
      this.hologram = this.crate.getHologramSettings().create(this.location);
      Iterable var3 = (Iterable)this.crate.getInteractables();
      boolean var4 = false;
      Collection var6 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var3, 10)));
      boolean var7 = false;
      Iterator var8 = var3.iterator();

      while(var8.hasNext()) {
         Object var9 = var8.next();
         InteractableSettings var10 = (InteractableSettings)var9;
         boolean var11 = false;
         var6.add(var10.build(this.location, (AquaticAudience)this.audience, SpawnedCrate::spawnedInteractables$lambda$1$lambda$0));
      }

      this.spawnedInteractables = (List)var6;
      this.hologram.spawn((AquaticAudience)this.audience, SpawnedCrate::_init_$lambda$2);
      if (this.crate instanceof OpenableCrate) {
         ((OpenableCrate)this.crate).getAnimationManager().playNewIdleAnimation(this);
      }

   }

   @NotNull
   public final Crate getCrate() {
      return this.crate;
   }

   @NotNull
   public final Location getLocation() {
      return this.location;
   }

   @NotNull
   public final ACGlobalAudience getAudience() {
      return this.audience;
   }

   @NotNull
   public final Hologram getHologram() {
      return this.hologram;
   }

   @NotNull
   public final List<Interactable> getSpawnedInteractables() {
      return this.spawnedInteractables;
   }

   public final void destroy() {
      Iterator var1 = this.spawnedInteractables.iterator();

      while(var1.hasNext()) {
         Interactable var2 = (Interactable)var1.next();
         var2.destroy();
      }

      if (this.crate instanceof OpenableCrate) {
         ConcurrentHashMap var10000 = (ConcurrentHashMap)((OpenableCrate)this.crate).getAnimationManager().getFailAnimations().remove(this);
         boolean var4;
         if (var10000 != null) {
            ConcurrentHashMap var3 = var10000;
            var4 = false;
            Iterator var5 = var3.values().iterator();

            while(true) {
               if (!var5.hasNext()) {
                  var3.clear();
                  break;
               }

               Object var19 = var5.next();
               Intrinsics.checkNotNullExpressionValue(var19, "next(...)");
               PlayerBoundAnimation var6 = (PlayerBoundAnimation)var19;
               Map var7 = var6.getProps();
               boolean var8 = false;
               Iterator var9 = var7.entrySet().iterator();

               while(var9.hasNext()) {
                  Entry var10 = (Entry)var9.next();
                  boolean var12 = false;
                  ((AnimationProp)var10.getValue()).onAnimationEnd();
               }
            }
         }

         Animation var20 = (Animation)((OpenableCrate)this.crate).getAnimationManager().getIdleAnimation().remove(this);
         if (var20 != null) {
            Animation var13 = var20;
            var4 = false;
            Map var14 = var13.getProps();
            boolean var15 = false;
            Iterator var16 = var14.entrySet().iterator();

            while(var16.hasNext()) {
               Entry var17 = (Entry)var16.next();
               boolean var18 = false;
               ((AnimationProp)var17.getValue()).onAnimationEnd();
            }
         }
      }

      this.hologram.despawn();
   }

   public final void forceHide(@NotNull Player var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Iterable var3;
      boolean var4;
      Iterator var5;
      Object var6;
      Interactable var7;
      boolean var8;
      if (var2) {
         this.audience.getHiddenFrom().add(var1);
         var3 = (Iterable)this.spawnedInteractables;
         var4 = false;
         var5 = var3.iterator();

         while(var5.hasNext()) {
            var6 = var5.next();
            var7 = (Interactable)var6;
            var8 = false;
            var7.removeViewer(var1);
         }

      } else {
         this.audience.getHiddenFrom().remove(var1);
         var3 = (Iterable)this.spawnedInteractables;
         var4 = false;
         var5 = var3.iterator();

         while(var5.hasNext()) {
            var6 = var5.next();
            var7 = (Interactable)var6;
            var8 = false;
            var7.addViewer(var1);
         }

      }
   }

   public final void forceHide(boolean var1) {
      List var2;
      Iterable var3;
      boolean var4;
      Collection var6;
      boolean var7;
      boolean var9;
      Iterator var10;
      Object var11;
      boolean var13;
      UUID var14;
      boolean var15;
      Player var10000;
      Player var16;
      boolean var17;
      Iterator var18;
      Interactable var19;
      if (var1) {
         var3 = (Iterable)this.audience.getUuids();
         var4 = false;
         var6 = (Collection)(new ArrayList());
         var7 = false;
         var9 = false;
         var10 = var3.iterator();

         while(var10.hasNext()) {
            var11 = var10.next();
            var13 = false;
            var14 = (UUID)var11;
            var15 = false;
            var10000 = Bukkit.getPlayer(var14);
            if (var10000 != null) {
               var16 = var10000;
               var17 = false;
               var6.add(var16);
            }
         }

         var2 = (List)var6;
         this.audience.setHidden(true);
         var18 = this.spawnedInteractables.iterator();

         while(var18.hasNext()) {
            var19 = (Interactable)var18.next();
            Iterator var5 = var2.iterator();

            while(var5.hasNext()) {
               Player var20 = (Player)var5.next();
               var19.removeViewer(var20);
            }

            var19.getViewers().clear();
            var19.updateViewers();
         }

      } else {
         this.audience.setHidden(false);
         var3 = (Iterable)this.audience.getUuids();
         var4 = false;
         var6 = (Collection)(new ArrayList());
         var7 = false;
         var9 = false;
         var10 = var3.iterator();

         while(var10.hasNext()) {
            var11 = var10.next();
            var13 = false;
            var14 = (UUID)var11;
            var15 = false;
            var10000 = Bukkit.getPlayer(var14);
            if (var10000 != null) {
               var16 = var10000;
               var17 = false;
               var6.add(var16);
            }
         }

         var2 = (List)var6;
         var18 = this.spawnedInteractables.iterator();

         while(var18.hasNext()) {
            var19 = (Interactable)var18.next();
            CollectionsKt.addAll((Collection)var19.getViewers(), (Iterable)var2);
            var19.updateViewers();
         }

      }
   }

   private static final Unit spawnedInteractables$lambda$1$lambda$0(SpawnedCrate var0, InteractableInteractEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "e");
      InteractType var2 = var1.isLeft() ? (var1.getPlayer().isSneaking() ? InteractType.SHIFT_LEFT : InteractType.LEFT) : (var1.getPlayer().isSneaking() ? InteractType.SHIFT_RIGHT : InteractType.RIGHT);
      var0.crate.getInteractHandler().handleInteract(var1.getPlayer(), var2, var0.location, var0);
      return Unit.INSTANCE;
   }

   private static final String _init_$lambda$2(Player var0, String var1) {
      Intrinsics.checkNotNullParameter(var0, "p");
      Intrinsics.checkNotNullParameter(var1, "str");
      return PAPIUtilKt.updatePAPIPlaceholders(var1, var0);
   }
}
