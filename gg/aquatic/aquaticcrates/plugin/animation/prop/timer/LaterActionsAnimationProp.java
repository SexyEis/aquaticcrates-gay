package gg.aquatic.aquaticcrates.plugin.animation.prop.timer;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0011\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/timer/LaterActionsAnimationProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "action", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "runAfter", "", "<init>", "(Lgg/aquatic/aquaticcrates/api/animation/Animation;Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;I)V", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/Animation;", "getAction", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "getRunAfter", "()I", "value", "tick", "getTick", "finished", "", "", "onAnimationEnd", "plugin"}
)
public final class LaterActionsAnimationProp extends AnimationProp {
   @NotNull
   private final Animation animation;
   @NotNull
   private final CrateAnimationActions action;
   private final int runAfter;
   private int tick;
   private boolean finished;

   public LaterActionsAnimationProp(@NotNull Animation var1, @NotNull CrateAnimationActions var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      Intrinsics.checkNotNullParameter(var2, "action");
      super();
      this.animation = var1;
      this.action = var2;
      this.runAfter = var3;
   }

   @NotNull
   public Animation getAnimation() {
      return this.animation;
   }

   @NotNull
   public final CrateAnimationActions getAction() {
      return this.action;
   }

   public final int getRunAfter() {
      return this.runAfter;
   }

   public final int getTick() {
      return this.tick;
   }

   public void tick() {
      if (!this.finished) {
         if (this.tick >= this.runAfter) {
            this.action.execute(this.getAnimation());
         }

      }
   }

   public void onAnimationEnd() {
   }
}
