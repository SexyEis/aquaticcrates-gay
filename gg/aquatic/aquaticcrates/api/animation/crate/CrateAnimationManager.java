package gg.aquatic.aquaticcrates.api.animation.crate;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.aquaticcrates.api.reroll.RerollManager;
import gg.aquatic.waves.libs.kotlin.Metadata;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u001bH&J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010'\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010(\u001a\u00020\u0011H&J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010*\u001a\u00020\u0011H&J\b\u0010+\u001a\u00020\u0011H&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001f0\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001dR*\u0010!\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\"0\u00180\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001d¨\u0006,"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;", "", "<init>", "()V", "crate", "Lgg/aquatic/aquaticcrates/api/crate/Crate;", "getCrate", "()Lgg/aquatic/aquaticcrates/api/crate/Crate;", "animationSettings", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "getAnimationSettings", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "rerollManager", "Lgg/aquatic/aquaticcrates/api/reroll/RerollManager;", "getRerollManager", "()Lgg/aquatic/aquaticcrates/api/reroll/RerollManager;", "playNewIdleAnimation", "", "spawnedCrate", "Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "playFailAnimation", "player", "Lorg/bukkit/entity/Player;", "playingAnimations", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/UUID;", "", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "getPlayingAnimations", "()Ljava/util/concurrent/ConcurrentHashMap;", "idleAnimation", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "getIdleAnimation", "failAnimations", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "getFailAnimations", "playAnimation", "animation", "skipAnimation", "forceStopAnimation", "forceStopAnimations", "forceStopAllAnimationTypes", "forceStopAllAnimations", "tick", "api"}
)
public abstract class CrateAnimationManager {
   @NotNull
   public abstract Crate getCrate();

   @NotNull
   public abstract CrateAnimationSettings getAnimationSettings();

   @Nullable
   public abstract RerollManager getRerollManager();

   public abstract void playNewIdleAnimation(@NotNull SpawnedCrate var1);

   public abstract void playFailAnimation(@NotNull SpawnedCrate var1, @NotNull Player var2);

   @NotNull
   public abstract ConcurrentHashMap<UUID, Set<CrateAnimation>> getPlayingAnimations();

   @NotNull
   public abstract ConcurrentHashMap<SpawnedCrate, Animation> getIdleAnimation();

   @NotNull
   public abstract ConcurrentHashMap<SpawnedCrate, ConcurrentHashMap<UUID, PlayerBoundAnimation>> getFailAnimations();

   public abstract void playAnimation(@NotNull CrateAnimation var1);

   public abstract void skipAnimation(@NotNull Player var1);

   public abstract void forceStopAnimation(@NotNull Player var1);

   public abstract void forceStopAnimations();

   public abstract void forceStopAllAnimationTypes(@NotNull Player var1);

   public abstract void forceStopAllAnimations();

   public abstract void tick();
}
