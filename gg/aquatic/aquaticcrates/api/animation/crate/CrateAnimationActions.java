package gg.aquatic.aquaticcrates.api.animation.crate;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.generic.ConfiguredExecutableObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00040\u0003¢\u0006\u0004\b\t\u0010\nB\t\b\u0016¢\u0006\u0004\b\t\u0010\u000bJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0005J\u001b\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003HÆ\u0003J\u001b\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00040\u0003HÆ\u0003JA\u0010\u0013\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00032\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00040\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR#\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001b"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "", "animationActions", "", "Lgg/aquatic/waves/util/generic/ConfiguredExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "playerBoundActions", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "<init>", "(Ljava/util/Collection;Ljava/util/Collection;)V", "()V", "getAnimationActions", "()Ljava/util/Collection;", "getPlayerBoundActions", "execute", "animation", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api"}
)
@SourceDebugExtension({"SMAP\nCrateAnimationActions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrateAnimationActions.kt\ngg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions\n+ 2 CollectionExt.kt\ngg/aquatic/waves/util/collection/CollectionExtKt\n*L\n1#1,26:1\n21#2,4:27\n21#2,4:31\n*S KotlinDebug\n*F\n+ 1 CrateAnimationActions.kt\ngg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions\n*L\n16#1:27,4\n18#1:31,4\n*E\n"})
public final class CrateAnimationActions {
   @NotNull
   private final Collection<ConfiguredExecutableObject<Animation, Unit>> animationActions;
   @NotNull
   private final Collection<ConfiguredExecutableObject<PlayerBoundAnimation, Unit>> playerBoundActions;

   public CrateAnimationActions(@NotNull Collection<ConfiguredExecutableObject<Animation, Unit>> var1, @NotNull Collection<ConfiguredExecutableObject<PlayerBoundAnimation, Unit>> var2) {
      Intrinsics.checkNotNullParameter(var1, "animationActions");
      Intrinsics.checkNotNullParameter(var2, "playerBoundActions");
      super();
      this.animationActions = var1;
      this.playerBoundActions = var2;
   }

   @NotNull
   public final Collection<ConfiguredExecutableObject<Animation, Unit>> getAnimationActions() {
      return this.animationActions;
   }

   @NotNull
   public final Collection<ConfiguredExecutableObject<PlayerBoundAnimation, Unit>> getPlayerBoundActions() {
      return this.playerBoundActions;
   }

   public CrateAnimationActions() {
      this((Collection)((List)(new ArrayList())), (Collection)((List)(new ArrayList())));
   }

   public final void execute(@NotNull Animation var1) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      Collection var2 = this.animationActions;
      Function2 var3 = CrateAnimationActions::execute$lambda$0;
      boolean var4 = false;
      Iterator var5 = var2.iterator();

      while(var5.hasNext()) {
         ConfiguredExecutableObject var6 = (ConfiguredExecutableObject)var5.next();
         var6.execute(var1, var3);
      }

      if (var1 instanceof PlayerBoundAnimation) {
         var2 = this.playerBoundActions;
         Animation var8 = var1;
         Function2 var9 = CrateAnimationActions::execute$lambda$1;
         boolean var10 = false;
         Iterator var11 = var2.iterator();

         while(var11.hasNext()) {
            ConfiguredExecutableObject var7 = (ConfiguredExecutableObject)var11.next();
            var7.execute(var8, var9);
         }
      }

   }

   @NotNull
   public final Collection<ConfiguredExecutableObject<Animation, Unit>> component1() {
      return this.animationActions;
   }

   @NotNull
   public final Collection<ConfiguredExecutableObject<PlayerBoundAnimation, Unit>> component2() {
      return this.playerBoundActions;
   }

   @NotNull
   public final CrateAnimationActions copy(@NotNull Collection<ConfiguredExecutableObject<Animation, Unit>> var1, @NotNull Collection<ConfiguredExecutableObject<PlayerBoundAnimation, Unit>> var2) {
      Intrinsics.checkNotNullParameter(var1, "animationActions");
      Intrinsics.checkNotNullParameter(var2, "playerBoundActions");
      return new CrateAnimationActions(var1, var2);
   }

   // $FF: synthetic method
   public static CrateAnimationActions copy$default(CrateAnimationActions var0, Collection var1, Collection var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.animationActions;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.playerBoundActions;
      }

      return var0.copy(var1, var2);
   }

   @NotNull
   public String toString() {
      return "CrateAnimationActions(animationActions=" + this.animationActions + ", playerBoundActions=" + this.playerBoundActions + ")";
   }

   public int hashCode() {
      int var1 = this.animationActions.hashCode();
      var1 = var1 * 31 + this.playerBoundActions.hashCode();
      return var1;
   }

   public boolean equals(@Nullable Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof CrateAnimationActions)) {
         return false;
      } else {
         CrateAnimationActions var2 = (CrateAnimationActions)var1;
         if (!Intrinsics.areEqual(this.animationActions, var2.animationActions)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.playerBoundActions, var2.playerBoundActions);
         }
      }
   }

   private static final String execute$lambda$0(Animation var0, String var1) {
      Intrinsics.checkNotNullParameter(var0, "a");
      Intrinsics.checkNotNullParameter(var1, "str");
      return var0.updatePlaceholders(var1);
   }

   private static final String execute$lambda$1(PlayerBoundAnimation var0, String var1) {
      Intrinsics.checkNotNullParameter(var0, "a");
      Intrinsics.checkNotNullParameter(var1, "str");
      return var0.updatePlaceholders(var1);
   }
}
