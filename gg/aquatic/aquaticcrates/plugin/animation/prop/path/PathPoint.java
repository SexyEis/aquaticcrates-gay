package gg.aquatic.aquaticcrates.plugin.animation.prop.path;

import gg.aquatic.waves.libs.kotlin.Metadata;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathPoint;", "", "x", "", "y", "z", "yaw", "", "pitch", "<init>", "(DDDFF)V", "getX", "()D", "getY", "getZ", "getYaw", "()F", "getPitch", "vector", "Lorg/bukkit/util/Vector;", "getVector", "()Lorg/bukkit/util/Vector;", "plugin"}
)
public final class PathPoint {
   private final double x;
   private final double y;
   private final double z;
   private final float yaw;
   private final float pitch;

   public PathPoint(double var1, double var3, double var5, float var7, float var8) {
      this.x = var1;
      this.y = var3;
      this.z = var5;
      this.yaw = var7;
      this.pitch = var8;
   }

   public final double getX() {
      return this.x;
   }

   public final double getY() {
      return this.y;
   }

   public final double getZ() {
      return this.z;
   }

   public final float getYaw() {
      return this.yaw;
   }

   public final float getPitch() {
      return this.pitch;
   }

   @NotNull
   public final Vector getVector() {
      return new Vector(this.x, this.y, this.z);
   }
}
