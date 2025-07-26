package gg.aquatic.aquaticcrates.plugin.animation.prop.timer;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0016\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0019¨\u0006\u001f"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/timer/TickerAnimationProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "id", "", "tickEvery", "", "actions", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "repeatLimit", "<init>", "(Lgg/aquatic/aquaticcrates/api/animation/Animation;Ljava/lang/String;ILgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;I)V", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/Animation;", "getId", "()Ljava/lang/String;", "getTickEvery", "()I", "getActions", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "getRepeatLimit", "tick", "getTick", "setTick", "(I)V", "actualTick", "getActualTick", "setActualTick", "", "onAnimationEnd", "plugin"}
)
public final class TickerAnimationProp extends AnimationProp {
   @NotNull
   private final Animation animation;
   @NotNull
   private final String id;
   private final int tickEvery;
   @NotNull
   private final CrateAnimationActions actions;
   private final int repeatLimit;
   private int tick;
   private int actualTick;

   public TickerAnimationProp(@NotNull Animation var1, @NotNull String var2, int var3, @NotNull CrateAnimationActions var4, int var5) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      Intrinsics.checkNotNullParameter(var2, "id");
      Intrinsics.checkNotNullParameter(var4, "actions");
      super();
      this.animation = var1;
      this.id = var2;
      this.tickEvery = var3;
      this.actions = var4;
      this.repeatLimit = var5;
      Map var6 = (Map)this.getAnimation().getExtraPlaceholders();
      Pair var7 = TuplesKt.to("tick:" + this.id, TickerAnimationProp::_init_$lambda$0);
      var6.put(var7.getFirst(), var7.getSecond());
   }

   @NotNull
   public Animation getAnimation() {
      return this.animation;
   }

   @NotNull
   public final String getId() {
      return this.id;
   }

   public final int getTickEvery() {
      return this.tickEvery;
   }

   @NotNull
   public final CrateAnimationActions getActions() {
      return this.actions;
   }

   public final int getRepeatLimit() {
      return this.repeatLimit;
   }

   public final int getTick() {
      return this.tick;
   }

   public final void setTick(int var1) {
      this.tick = var1;
   }

   public final int getActualTick() {
      return this.actualTick;
   }

   public final void setActualTick(int var1) {
      this.actualTick = var1;
   }

   public void tick() {
      if (this.repeatLimit <= 0 || this.actualTick < this.repeatLimit) {
         int var1 = this.tick++;
         if (this.tick >= this.tickEvery) {
            this.tick = 0;
            var1 = this.actualTick++;
            this.actions.execute(this.getAnimation());
         }

      }
   }

   public void onAnimationEnd() {
   }

   private static final String _init_$lambda$0(TickerAnimationProp var0, String var1) {
      Intrinsics.checkNotNullParameter(var1, "str");
      return StringsKt.replace$default(var1, "%tick:" + var0.id + "%", String.valueOf(var0.actualTick), false, 4, (Object)null);
   }
}
