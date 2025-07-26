package gg.aquatic.aquaticcrates.plugin.animation.prop.path;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntries;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntriesKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathBoundProperties;", "", "offset", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathPoint;", "offsetType", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathBoundProperties$OffsetType;", "affectYawPitch", "", "<init>", "(Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathPoint;Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathBoundProperties$OffsetType;Z)V", "getOffset", "()Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathPoint;", "getOffsetType", "()Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathBoundProperties$OffsetType;", "getAffectYawPitch", "()Z", "OffsetType", "plugin"}
)
public final class PathBoundProperties {
   @NotNull
   private final PathPoint offset;
   @NotNull
   private final PathBoundProperties.OffsetType offsetType;
   private final boolean affectYawPitch;

   public PathBoundProperties(@NotNull PathPoint var1, @NotNull PathBoundProperties.OffsetType var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "offset");
      Intrinsics.checkNotNullParameter(var2, "offsetType");
      super();
      this.offset = var1;
      this.offsetType = var2;
      this.affectYawPitch = var3;
   }

   @NotNull
   public final PathPoint getOffset() {
      return this.offset;
   }

   @NotNull
   public final PathBoundProperties.OffsetType getOffsetType() {
      return this.offsetType;
   }

   public final boolean getAffectYawPitch() {
      return this.affectYawPitch;
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathBoundProperties$OffsetType;", "", "<init>", "(Ljava/lang/String;I)V", "STATIC", "DYNAMIC", "plugin"}
   )
   public static enum OffsetType {
      STATIC,
      DYNAMIC;

      // $FF: synthetic field
      private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

      @NotNull
      public static EnumEntries<PathBoundProperties.OffsetType> getEntries() {
         return $ENTRIES;
      }

      // $FF: synthetic method
      private static final PathBoundProperties.OffsetType[] $values() {
         PathBoundProperties.OffsetType[] var0 = new PathBoundProperties.OffsetType[]{STATIC, DYNAMIC};
         return var0;
      }
   }
}
