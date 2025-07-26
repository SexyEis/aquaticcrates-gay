package gg.aquatic.aquaticcrates.api.hologram;

import gg.aquatic.waves.hologram.AquaticHologram;
import gg.aquatic.waves.hologram.HologramLine;
import gg.aquatic.waves.hologram.LineSettings;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.audience.AquaticAudience;
import gg.aquatic.waves.util.audience.GlobalAudience;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\u0014\u001a\u00020\u00152\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00162\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0018J\"\u0010\u001b\u001a\u00020\u00152\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J*\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0018H\u0016J\"\u0010\u001f\u001a\u00020\u00152\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0018H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "},
   d2 = {"Lgg/aquatic/aquaticcrates/api/hologram/AHologram;", "Lgg/aquatic/aquaticcrates/api/hologram/Hologram;", "location", "Lorg/bukkit/Location;", "settings", "Lgg/aquatic/aquaticcrates/api/hologram/AquaticHologramSettings;", "<init>", "(Lorg/bukkit/Location;Lgg/aquatic/aquaticcrates/api/hologram/AquaticHologramSettings;)V", "getSettings", "()Lgg/aquatic/aquaticcrates/api/hologram/AquaticHologramSettings;", "value", "", "Lgg/aquatic/waves/hologram/HologramLine;", "lines", "getLines", "()Ljava/util/Set;", "audience", "Lgg/aquatic/waves/util/audience/AquaticAudience;", "hologram", "Lgg/aquatic/waves/hologram/AquaticHologram;", "setLines", "", "", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "Lorg/bukkit/entity/Player;", "", "createHologram", "move", "despawn", "spawn", "update", "api"}
)
@SourceDebugExtension({"SMAP\nAHologram.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AHologram.kt\ngg/aquatic/aquaticcrates/api/hologram/AHologram\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,56:1\n1563#2:57\n1634#2,3:58\n*S KotlinDebug\n*F\n+ 1 AHologram.kt\ngg/aquatic/aquaticcrates/api/hologram/AHologram\n*L\n15#1:57\n15#1:58,3\n*E\n"})
public final class AHologram extends Hologram {
   @NotNull
   private final AquaticHologramSettings settings;
   @NotNull
   private Set<HologramLine> lines;
   @NotNull
   private AquaticAudience audience;
   @Nullable
   private AquaticHologram hologram;

   public AHologram(@NotNull Location var1, @NotNull AquaticHologramSettings var2) {
      Intrinsics.checkNotNullParameter(var1, "location");
      Intrinsics.checkNotNullParameter(var2, "settings");
      super(var1);
      this.settings = var2;
      Iterable var3 = (Iterable)this.settings.getLines();
      boolean var4 = false;
      Collection var6 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var3, 10)));
      boolean var7 = false;
      Iterator var8 = var3.iterator();

      while(var8.hasNext()) {
         Object var9 = var8.next();
         LineSettings var10 = (LineSettings)var9;
         boolean var11 = false;
         var6.add(var10.create());
      }

      this.lines = CollectionsKt.toMutableSet((Iterable)((List)var6));
      this.audience = (AquaticAudience)(new GlobalAudience());
   }

   @NotNull
   public final AquaticHologramSettings getSettings() {
      return this.settings;
   }

   @NotNull
   public final Set<HologramLine> getLines() {
      return this.lines;
   }

   public final void setLines(@NotNull List<? extends HologramLine> var1, @NotNull Function2<? super Player, ? super String, String> var2) {
      Intrinsics.checkNotNullParameter(var1, "lines");
      Intrinsics.checkNotNullParameter(var2, "textUpdater");
      this.lines = CollectionsKt.toMutableSet((Iterable)var1);
      this.createHologram(var2);
   }

   private final void createHologram(Function2<? super Player, ? super String, String> var1) {
      AquaticHologram var10000 = this.hologram;
      if (var10000 != null) {
         var10000.destroy();
      }

      Location var10003 = this.getLocation().clone().add(this.settings.getOffset());
      Intrinsics.checkNotNullExpressionValue(var10003, "add(...)");
      this.hologram = new AquaticHologram(var10003, AHologram::createHologram$lambda$1, var1, 50, this.lines);
   }

   public void move(@NotNull Location var1) {
      Intrinsics.checkNotNullParameter(var1, "location");
      this.setLocation(var1);
      AquaticHologram var10000 = this.hologram;
      if (var10000 != null) {
         Location var10001 = var1.clone().add(this.settings.getOffset());
         Intrinsics.checkNotNullExpressionValue(var10001, "add(...)");
         var10000.teleport(var10001);
      }

   }

   public void despawn() {
      AquaticHologram var10000 = this.hologram;
      if (var10000 != null) {
         var10000.destroy();
      }

      this.hologram = null;
   }

   public void spawn(@NotNull AquaticAudience var1, @NotNull Function2<? super Player, ? super String, String> var2) {
      Intrinsics.checkNotNullParameter(var1, "audience");
      Intrinsics.checkNotNullParameter(var2, "textUpdater");
      this.despawn();
      this.audience = var1;
      this.createHologram(var2);
   }

   public void update(@NotNull Function2<? super Player, ? super String, String> var1) {
      Intrinsics.checkNotNullParameter(var1, "textUpdater");
   }

   private static final boolean createHologram$lambda$1(AHologram var0, Player var1) {
      Intrinsics.checkNotNullParameter(var1, "player");
      return var0.audience.canBeApplied(var1);
   }
}
