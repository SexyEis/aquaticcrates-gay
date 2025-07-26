package gg.aquatic.aquaticcrates.api.animation.prop;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.waves.libs.kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "", "<init>", "()V", "animation", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/Animation;", "tick", "", "onAnimationEnd", "api"}
)
public abstract class AnimationProp {
   @NotNull
   public abstract Animation getAnimation();

   public abstract void tick();

   public abstract void onAnimationEnd();
}
