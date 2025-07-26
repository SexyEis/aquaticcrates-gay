package gg.aquatic.aquaticcrates.plugin.animation.idle;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.aquaticcrates.plugin.animation.idle.settings.IdleAnimationSettings;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.audience.AquaticAudience;
import gg.aquatic.waves.util.generic.ConfiguredExecutableObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/idle/IdleAnimationImpl;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "crate", "Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "settings", "Lgg/aquatic/aquaticcrates/plugin/animation/idle/settings/IdleAnimationSettings;", "<init>", "(Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;Lgg/aquatic/aquaticcrates/plugin/animation/idle/settings/IdleAnimationSettings;)V", "getCrate", "()Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "getSettings", "()Lgg/aquatic/aquaticcrates/plugin/animation/idle/settings/IdleAnimationSettings;", "baseLocation", "Lorg/bukkit/Location;", "getBaseLocation", "()Lorg/bukkit/Location;", "audience", "Lgg/aquatic/waves/util/audience/AquaticAudience;", "getAudience", "()Lgg/aquatic/waves/util/audience/AquaticAudience;", "props", "", "", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "getProps", "()Ljava/util/Map;", "tick", "", "updatePlaceholders", "str", "plugin"}
)
@SourceDebugExtension({"SMAP\nIdleAnimationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IdleAnimationImpl.kt\ngg/aquatic/aquaticcrates/plugin/animation/idle/IdleAnimationImpl\n+ 2 CollectionExt.kt\ngg/aquatic/waves/util/collection/CollectionExtKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,49:1\n21#2,4:50\n1869#3,2:54\n*S KotlinDebug\n*F\n+ 1 IdleAnimationImpl.kt\ngg/aquatic/aquaticcrates/plugin/animation/idle/IdleAnimationImpl\n*L\n24#1:50,4\n35#1:54,2\n*E\n"})
public final class IdleAnimationImpl extends Animation {
   @NotNull
   private final SpawnedCrate crate;
   @NotNull
   private final IdleAnimationSettings settings;
   @NotNull
   private final Location baseLocation;
   @NotNull
   private final AquaticAudience audience;
   @NotNull
   private final Map<String, AnimationProp> props;

   public IdleAnimationImpl(@NotNull SpawnedCrate var1, @NotNull IdleAnimationSettings var2) {
      Intrinsics.checkNotNullParameter(var1, "crate");
      Intrinsics.checkNotNullParameter(var2, "settings");
      super();
      this.crate = var1;
      this.settings = var2;
      this.baseLocation = this.crate.getLocation();
      this.audience = (AquaticAudience)this.crate.getAudience();
      this.props = (Map)(new ConcurrentHashMap());
   }

   @NotNull
   public final SpawnedCrate getCrate() {
      return this.crate;
   }

   @NotNull
   public final IdleAnimationSettings getSettings() {
      return this.settings;
   }

   @NotNull
   public Location getBaseLocation() {
      return this.baseLocation;
   }

   @NotNull
   public AquaticAudience getAudience() {
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

      List var10000 = (List)this.settings.getAnimationTasks().get(this.getTick());
      if (var10000 != null) {
         Collection var2 = (Collection)var10000;
         Function2 var10 = IdleAnimationImpl::tick$lambda$0;
         boolean var4 = false;
         Iterator var5 = var2.iterator();

         while(var5.hasNext()) {
            ConfiguredExecutableObject var6 = (ConfiguredExecutableObject)var5.next();
            var6.execute(this, var10);
         }
      }

      int var7 = this.getTick();
      this.setTick(var7 + 1);
      if (this.getTick() > this.settings.getLength()) {
         if (this.settings.isLoop()) {
            this.setTick(0);
            return;
         }

         Iterable var8 = (Iterable)this.getProps().values();
         boolean var9 = false;
         Iterator var11 = var8.iterator();

         while(var11.hasNext()) {
            Object var12 = var11.next();
            AnimationProp var13 = (AnimationProp)var12;
            boolean var14 = false;
            var13.onAnimationEnd();
         }

         Crate var15 = this.crate.getCrate();
         Intrinsics.checkNotNull(var15, "null cannot be cast to non-null type gg.aquatic.aquaticcrates.api.crate.OpenableCrate");
         ((OpenableCrate)var15).getAnimationManager().playNewIdleAnimation(this.crate);
      }

   }

   @NotNull
   public String updatePlaceholders(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "str");
      String var2 = var1;

      Function1 var4;
      for(Iterator var3 = ((Map)this.getExtraPlaceholders()).entrySet().iterator(); var3.hasNext(); var2 = (String)var4.invoke(var2)) {
         var4 = (Function1)((Entry)var3.next()).getValue();
      }

      return var2;
   }

   private static final String tick$lambda$0(Animation var0, String var1) {
      Intrinsics.checkNotNullParameter(var0, "a");
      Intrinsics.checkNotNullParameter(var1, "str");
      return var0.updatePlaceholders(var1);
   }
}
