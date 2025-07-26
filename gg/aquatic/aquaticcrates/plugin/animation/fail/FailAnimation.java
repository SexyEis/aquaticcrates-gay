package gg.aquatic.aquaticcrates.plugin.animation.fail;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.aquaticcrates.plugin.animation.fail.settings.FailAnimationSettings;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.util.PAPIUtilKt;
import gg.aquatic.waves.util.audience.FilterAudience;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006&"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/fail/FailAnimation;", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "settings", "Lgg/aquatic/aquaticcrates/plugin/animation/fail/settings/FailAnimationSettings;", "player", "Lorg/bukkit/entity/Player;", "spawnedCrate", "Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "<init>", "(Lgg/aquatic/aquaticcrates/plugin/animation/fail/settings/FailAnimationSettings;Lorg/bukkit/entity/Player;Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;)V", "getSettings", "()Lgg/aquatic/aquaticcrates/plugin/animation/fail/settings/FailAnimationSettings;", "getPlayer", "()Lorg/bukkit/entity/Player;", "getSpawnedCrate", "()Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "future", "Ljava/util/concurrent/CompletableFuture;", "getFuture", "()Ljava/util/concurrent/CompletableFuture;", "baseLocation", "Lorg/bukkit/Location;", "getBaseLocation", "()Lorg/bukkit/Location;", "audience", "Lgg/aquatic/waves/util/audience/FilterAudience;", "getAudience", "()Lgg/aquatic/waves/util/audience/FilterAudience;", "props", "", "", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "getProps", "()Ljava/util/Map;", "tick", "", "updatePlaceholders", "str", "plugin"}
)
@SourceDebugExtension({"SMAP\nFailAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FailAnimation.kt\ngg/aquatic/aquaticcrates/plugin/animation/fail/FailAnimation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n1869#2,2:53\n*S KotlinDebug\n*F\n+ 1 FailAnimation.kt\ngg/aquatic/aquaticcrates/plugin/animation/fail/FailAnimation\n*L\n38#1:53,2\n*E\n"})
public final class FailAnimation extends PlayerBoundAnimation {
   @NotNull
   private final FailAnimationSettings settings;
   @NotNull
   private final Player player;
   @NotNull
   private final SpawnedCrate spawnedCrate;
   @NotNull
   private final CompletableFuture<FailAnimation> future;
   @NotNull
   private final Location baseLocation;
   @NotNull
   private final FilterAudience audience;
   @NotNull
   private final Map<String, AnimationProp> props;

   public FailAnimation(@NotNull FailAnimationSettings var1, @NotNull Player var2, @NotNull SpawnedCrate var3) {
      Intrinsics.checkNotNullParameter(var1, "settings");
      Intrinsics.checkNotNullParameter(var2, "player");
      Intrinsics.checkNotNullParameter(var3, "spawnedCrate");
      super();
      this.settings = var1;
      this.player = var2;
      this.spawnedCrate = var3;
      this.future = new CompletableFuture();
      this.baseLocation = this.spawnedCrate.getLocation();
      this.audience = new FilterAudience(FailAnimation::audience$lambda$0);
      this.props = (Map)(new ConcurrentHashMap());
   }

   @NotNull
   public final FailAnimationSettings getSettings() {
      return this.settings;
   }

   @NotNull
   public Player getPlayer() {
      return this.player;
   }

   @NotNull
   public final SpawnedCrate getSpawnedCrate() {
      return this.spawnedCrate;
   }

   @NotNull
   public final CompletableFuture<FailAnimation> getFuture() {
      return this.future;
   }

   @NotNull
   public Location getBaseLocation() {
      return this.baseLocation;
   }

   @NotNull
   public FilterAudience getAudience() {
      return this.audience;
   }

   @NotNull
   public Map<String, AnimationProp> getProps() {
      return this.props;
   }

   public void tick() {
      Iterator var1 = this.getProps().entrySet().iterator();

      while(var1.hasNext()) {
         AnimationProp var3 = (AnimationProp)((Entry)var1.next()).getValue();
         var3.tick();
      }

      CrateAnimationActions var10000 = (CrateAnimationActions)this.settings.getAnimationTasks().get(this.getTick());
      if (var10000 != null) {
         var10000.execute((Animation)this);
      }

      int var8 = this.getTick();
      this.setTick(var8 + 1);
      if (this.getTick() > this.settings.getLength()) {
         Crate var11 = this.spawnedCrate.getCrate();
         Intrinsics.checkNotNull(var11, "null cannot be cast to non-null type gg.aquatic.aquaticcrates.api.crate.OpenableCrate");
         ConcurrentHashMap var9 = (ConcurrentHashMap)((OpenableCrate)var11).getAnimationManager().getFailAnimations().get(this.spawnedCrate);
         if (var9 != null) {
            PlayerBoundAnimation var12 = (PlayerBoundAnimation)var9.remove(this.getPlayer().getUniqueId());
         }

         Iterable var2 = (Iterable)this.getProps().values();
         boolean var10 = false;
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            AnimationProp var6 = (AnimationProp)var5;
            boolean var7 = false;
            var6.onAnimationEnd();
         }

         this.future.complete(this);
      }

   }

   @NotNull
   public String updatePlaceholders(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "str");
      String var10002 = this.getPlayer().getName();
      Intrinsics.checkNotNullExpressionValue(var10002, "getName(...)");
      String var2 = PAPIUtilKt.updatePAPIPlaceholders(StringsKt.replace$default(var1, "%player%", var10002, false, 4, (Object)null), this.getPlayer());

      Function1 var4;
      for(Iterator var3 = ((Map)this.getExtraPlaceholders()).entrySet().iterator(); var3.hasNext(); var2 = (String)var4.invoke(var2)) {
         var4 = (Function1)((Entry)var3.next()).getValue();
      }

      return var2;
   }

   private static final Boolean audience$lambda$0(FailAnimation var0, Player var1) {
      Intrinsics.checkNotNullParameter(var1, "p");
      return Intrinsics.areEqual(var1, var0.getPlayer());
   }
}
