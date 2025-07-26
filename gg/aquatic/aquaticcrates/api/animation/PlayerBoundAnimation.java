package gg.aquatic.aquaticcrates.api.animation;

import gg.aquatic.waves.libs.kotlin.Metadata;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "<init>", "()V", "player", "Lorg/bukkit/entity/Player;", "getPlayer", "()Lorg/bukkit/entity/Player;", "api"}
)
public abstract class PlayerBoundAnimation extends Animation {
   @NotNull
   public abstract Player getPlayer();
}
