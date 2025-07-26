package gg.aquatic.aquaticcrates.plugin.animation.idle.settings;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.aquaticcrates.plugin.animation.idle.IdleAnimationImpl;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.chance.IChance;
import gg.aquatic.waves.util.generic.ConfiguredExecutableObject;
import java.util.List;
import java.util.TreeMap;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BE\u0012$\u0010\u0002\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00050\u0003\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR/\u0010\u0002\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0014R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/idle/settings/IdleAnimationSettings;", "Lgg/aquatic/waves/util/chance/IChance;", "animationTasks", "Ljava/util/TreeMap;", "", "", "Lgg/aquatic/waves/util/generic/ConfiguredExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "length", "isLoop", "", "chance", "", "<init>", "(Ljava/util/TreeMap;IZD)V", "getAnimationTasks", "()Ljava/util/TreeMap;", "getLength", "()I", "()Z", "getChance", "()D", "create", "Lgg/aquatic/aquaticcrates/plugin/animation/idle/IdleAnimationImpl;", "spawnedCrate", "Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "plugin"}
)
public final class IdleAnimationSettings implements IChance {
   @NotNull
   private final TreeMap<Integer, List<ConfiguredExecutableObject<Animation, Unit>>> animationTasks;
   private final int length;
   private final boolean isLoop;
   private final double chance;

   public IdleAnimationSettings(@NotNull TreeMap<Integer, List<ConfiguredExecutableObject<Animation, Unit>>> var1, int var2, boolean var3, double var4) {
      Intrinsics.checkNotNullParameter(var1, "animationTasks");
      super();
      this.animationTasks = var1;
      this.length = var2;
      this.isLoop = var3;
      this.chance = var4;
   }

   @NotNull
   public final TreeMap<Integer, List<ConfiguredExecutableObject<Animation, Unit>>> getAnimationTasks() {
      return this.animationTasks;
   }

   public final int getLength() {
      return this.length;
   }

   public final boolean isLoop() {
      return this.isLoop;
   }

   public double getChance() {
      return this.chance;
   }

   @NotNull
   public final IdleAnimationImpl create(@NotNull SpawnedCrate var1) {
      Intrinsics.checkNotNullParameter(var1, "spawnedCrate");
      return new IdleAnimationImpl(var1, this);
   }
}
