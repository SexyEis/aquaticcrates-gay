package gg.aquatic.aquaticcrates.plugin.animation.fail.settings;

import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.aquaticcrates.plugin.animation.fail.FailAnimation;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.TreeMap;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/fail/settings/FailAnimationSettings;", "", "animationTasks", "Ljava/util/TreeMap;", "", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "length", "<init>", "(Ljava/util/TreeMap;I)V", "getAnimationTasks", "()Ljava/util/TreeMap;", "getLength", "()I", "create", "Lgg/aquatic/aquaticcrates/plugin/animation/fail/FailAnimation;", "spawnedCrate", "Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "player", "Lorg/bukkit/entity/Player;", "plugin"}
)
@SourceDebugExtension({"SMAP\nFailAnimationSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FailAnimationSettings.kt\ngg/aquatic/aquaticcrates/plugin/animation/fail/settings/FailAnimationSettings\n+ 2 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,37:1\n30#2,4:38\n6#2,4:42\n*S KotlinDebug\n*F\n+ 1 FailAnimationSettings.kt\ngg/aquatic/aquaticcrates/plugin/animation/fail/settings/FailAnimationSettings\n*L\n24#1:38,4\n29#1:42,4\n*E\n"})
public final class FailAnimationSettings {
   @NotNull
   private final TreeMap<Integer, CrateAnimationActions> animationTasks;
   private final int length;

   public FailAnimationSettings(@NotNull TreeMap<Integer, CrateAnimationActions> var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "animationTasks");
      super();
      this.animationTasks = var1;
      this.length = var2;
   }

   @NotNull
   public final TreeMap<Integer, CrateAnimationActions> getAnimationTasks() {
      return this.animationTasks;
   }

   public final int getLength() {
      return this.length;
   }

   @NotNull
   public final FailAnimation create(@NotNull SpawnedCrate var1, @NotNull Player var2) {
      Intrinsics.checkNotNullParameter(var1, "spawnedCrate");
      Intrinsics.checkNotNullParameter(var2, "player");
      FailAnimation var3 = new FailAnimation(this, var2, var1);
      var3.tick();
      long var4 = 1L;
      boolean var6 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTaskLater((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new FailAnimationSettings$create$$inlined$runLaterSync$1(var1, var2)), var4);
      var3.getFuture().thenRun(FailAnimationSettings::create$lambda$2);
      return var3;
   }

   private static final void create$lambda$2(SpawnedCrate var0, Player var1) {
      boolean var2 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new FailAnimationSettings$create$lambda$2$$inlined$runSync$1(var0, var1)));
   }
}
