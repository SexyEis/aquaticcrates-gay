package gg.aquatic.aquaticcrates.plugin.animation.prop;

import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.prop.PlayerBoundAnimationProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.StringExtKt;
import gg.aquatic.waves.util.bossbar.AquaticBossBar;
import java.util.LinkedHashSet;
import java.util.Set;
import net.kyori.adventure.bossbar.BossBar.Color;
import net.kyori.adventure.bossbar.BossBar.Overlay;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/BossbarAnimationProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/PlayerBoundAnimationProp;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "text", "", "color", "Lnet/kyori/adventure/bossbar/BossBar$Color;", "style", "Lnet/kyori/adventure/bossbar/BossBar$Overlay;", "progress", "", "<init>", "(Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;Ljava/lang/String;Lnet/kyori/adventure/bossbar/BossBar$Color;Lnet/kyori/adventure/bossbar/BossBar$Overlay;F)V", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "bossBar", "Lgg/aquatic/waves/util/bossbar/AquaticBossBar;", "getBossBar", "()Lgg/aquatic/waves/util/bossbar/AquaticBossBar;", "tick", "", "onAnimationEnd", "plugin"}
)
public final class BossbarAnimationProp extends PlayerBoundAnimationProp {
   @NotNull
   private final PlayerBoundAnimation animation;
   @NotNull
   private volatile String text;
   @NotNull
   private final AquaticBossBar bossBar;

   public BossbarAnimationProp(@NotNull PlayerBoundAnimation var1, @NotNull String var2, @NotNull Color var3, @NotNull Overlay var4, float var5) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      Intrinsics.checkNotNullParameter(var2, "text");
      Intrinsics.checkNotNullParameter(var3, "color");
      Intrinsics.checkNotNullParameter(var4, "style");
      super();
      this.animation = var1;
      this.text = var2;
      this.bossBar = new AquaticBossBar(StringExtKt.toMMComponent(this.getAnimation().updatePlaceholders(this.text)), var3, var4, (Set)(new LinkedHashSet()), var5);
      this.bossBar.addViewer(this.getAnimation().getPlayer());
   }

   @NotNull
   public PlayerBoundAnimation getAnimation() {
      return this.animation;
   }

   @NotNull
   public final String getText() {
      return this.text;
   }

   public final void setText(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.text = var1;
   }

   @NotNull
   public final AquaticBossBar getBossBar() {
      return this.bossBar;
   }

   public void tick() {
      Component var1 = StringExtKt.toMMComponent(this.getAnimation().updatePlaceholders(this.text));
      this.bossBar.setMessage(var1);
   }

   public void onAnimationEnd() {
      this.bossBar.removeViewer(this.getAnimation().getPlayer());
   }
}
