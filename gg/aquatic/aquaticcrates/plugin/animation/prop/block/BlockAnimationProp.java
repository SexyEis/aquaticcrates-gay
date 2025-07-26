package gg.aquatic.aquaticcrates.plugin.animation.prop.block;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.fake.block.FakeBlock;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.LocationExtKt;
import gg.aquatic.waves.util.block.AquaticBlock;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/block/BlockAnimationProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "block", "Lgg/aquatic/waves/util/block/AquaticBlock;", "offset", "Lorg/bukkit/util/Vector;", "<init>", "(Lgg/aquatic/aquaticcrates/api/animation/Animation;Lgg/aquatic/waves/util/block/AquaticBlock;Lorg/bukkit/util/Vector;)V", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/Animation;", "getOffset", "()Lorg/bukkit/util/Vector;", "packetBlock", "Lgg/aquatic/waves/fake/block/FakeBlock;", "getPacketBlock", "()Lgg/aquatic/waves/fake/block/FakeBlock;", "tick", "", "onAnimationEnd", "plugin"}
)
@SourceDebugExtension({"SMAP\nBlockAnimationProp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/block/BlockAnimationProp\n+ 2 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,30:1\n6#2,4:31\n*S KotlinDebug\n*F\n+ 1 BlockAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/block/BlockAnimationProp\n*L\n26#1:31,4\n*E\n"})
public final class BlockAnimationProp extends AnimationProp {
   @NotNull
   private final Animation animation;
   @NotNull
   private final Vector offset;
   @NotNull
   private final FakeBlock packetBlock;

   public BlockAnimationProp(@NotNull Animation var1, @NotNull AquaticBlock var2, @NotNull Vector var3) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      Intrinsics.checkNotNullParameter(var2, "block");
      Intrinsics.checkNotNullParameter(var3, "offset");
      super();
      this.animation = var1;
      this.offset = var3;
      Location var10004 = this.getAnimation().getBaseLocation().clone().add(this.offset);
      Intrinsics.checkNotNullExpressionValue(var10004, "add(...)");
      FakeBlock var4 = new FakeBlock(var2, LocationExtKt.blockLocation(var10004), 50, this.getAnimation().getAudience(), (Function1)null, 16, (DefaultConstructorMarker)null);
      boolean var6 = false;
      var4.register();
      this.packetBlock = var4;
   }

   @NotNull
   public Animation getAnimation() {
      return this.animation;
   }

   @NotNull
   public final Vector getOffset() {
      return this.offset;
   }

   @NotNull
   public final FakeBlock getPacketBlock() {
      return this.packetBlock;
   }

   public void tick() {
   }

   public void onAnimationEnd() {
      boolean var1 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new BlockAnimationProp$onAnimationEnd$$inlined$runSync$1(this)));
   }
}
