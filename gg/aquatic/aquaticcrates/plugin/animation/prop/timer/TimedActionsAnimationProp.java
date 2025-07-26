package gg.aquatic.aquaticcrates.plugin.animation.prop.timer;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0010\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/timer/TimedActionsAnimationProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "actions", "Ljava/util/HashMap;", "", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "Lgg/aquatic/waves/libs/kotlin/collections/HashMap;", "<init>", "(Lgg/aquatic/aquaticcrates/api/animation/Animation;Ljava/util/HashMap;)V", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/Animation;", "getActions", "()Ljava/util/HashMap;", "value", "tick", "getTick", "()I", "", "onAnimationEnd", "plugin"}
)
public final class TimedActionsAnimationProp extends AnimationProp {
   @NotNull
   private final Animation animation;
   @NotNull
   private final HashMap<Integer, CrateAnimationActions> actions;
   private int tick;

   public TimedActionsAnimationProp(@NotNull Animation var1, @NotNull HashMap<Integer, CrateAnimationActions> var2) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      Intrinsics.checkNotNullParameter(var2, "actions");
      super();
      this.animation = var1;
      this.actions = var2;
   }

   @NotNull
   public Animation getAnimation() {
      return this.animation;
   }

   @NotNull
   public final HashMap<Integer, CrateAnimationActions> getActions() {
      return this.actions;
   }

   public final int getTick() {
      return this.tick;
   }

   public void tick() {
      CrateAnimationActions var10000 = (CrateAnimationActions)this.actions.get(this.tick);
      if (var10000 != null) {
         var10000.execute(this.getAnimation());
      }

      int var1 = this.tick++;
   }

   public void onAnimationEnd() {
   }
}
