package gg.aquatic.aquaticcrates.api.animation;

import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.util.audience.AquaticAudience;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0019H&J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eH&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R)\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "<init>", "()V", "baseLocation", "Lorg/bukkit/Location;", "getBaseLocation", "()Lorg/bukkit/Location;", "audience", "Lgg/aquatic/waves/util/audience/AquaticAudience;", "getAudience", "()Lgg/aquatic/waves/util/audience/AquaticAudience;", "props", "", "", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "getProps", "()Ljava/util/Map;", "value", "", "tick", "getTick", "()I", "setTick", "(I)V", "", "extraPlaceholders", "Ljava/util/concurrent/ConcurrentHashMap;", "Lgg/aquatic/waves/libs/kotlin/Function1;", "getExtraPlaceholders", "()Ljava/util/concurrent/ConcurrentHashMap;", "updatePlaceholders", "str", "api"}
)
public abstract class Animation {
   private int tick;
   @NotNull
   private final ConcurrentHashMap<String, Function1<String, String>> extraPlaceholders = new ConcurrentHashMap();

   @NotNull
   public abstract Location getBaseLocation();

   @NotNull
   public abstract AquaticAudience getAudience();

   @NotNull
   public abstract Map<String, AnimationProp> getProps();

   public final int getTick() {
      return this.tick;
   }

   protected final void setTick(int var1) {
      this.tick = var1;
   }

   public abstract void tick();

   @NotNull
   public final ConcurrentHashMap<String, Function1<String, String>> getExtraPlaceholders() {
      return this.extraPlaceholders;
   }

   @NotNull
   public abstract String updatePlaceholders(@NotNull String var1);
}
