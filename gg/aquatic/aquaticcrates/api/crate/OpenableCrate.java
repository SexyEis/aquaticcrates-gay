package gg.aquatic.aquaticcrates.api.crate;

import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationManager;
import gg.aquatic.aquaticcrates.api.openprice.OpenPriceGroup;
import gg.aquatic.aquaticcrates.api.util.Rewardable;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.util.requirement.ConfiguredRequirement;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\"\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J(\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J-\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010$H&¢\u0006\u0002\u0010&J-\u0010'\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010$H&¢\u0006\u0002\u0010&J\u001a\u0010(\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010\u001cH&R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/crate/OpenableCrate;", "Lgg/aquatic/aquaticcrates/api/crate/Crate;", "Lgg/aquatic/aquaticcrates/api/util/Rewardable;", "<init>", "()V", "key", "Lgg/aquatic/aquaticcrates/api/crate/Key;", "getKey", "()Lgg/aquatic/aquaticcrates/api/crate/Key;", "openRequirements", "", "Lgg/aquatic/waves/util/requirement/ConfiguredRequirement;", "Lorg/bukkit/entity/Player;", "getOpenRequirements", "()Ljava/util/List;", "openPriceGroups", "Lgg/aquatic/aquaticcrates/api/openprice/OpenPriceGroup;", "getOpenPriceGroups", "animationManager", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;", "getAnimationManager", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationManager;", "tryInstantOpen", "", "player", "location", "Lorg/bukkit/Location;", "spawnedCrate", "Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "instantOpen", "tryOpen", "Ljava/util/concurrent/CompletableFuture;", "Ljava/lang/Void;", "open", "tryMassOpen", "amount", "", "threads", "(Lorg/bukkit/entity/Player;ILjava/lang/Integer;)Ljava/util/concurrent/CompletableFuture;", "massOpen", "openPreview", "placedCrate", "api"}
)
public abstract class OpenableCrate extends Crate implements Rewardable {
   @NotNull
   public abstract Key getKey();

   @NotNull
   public abstract List<ConfiguredRequirement<Player>> getOpenRequirements();

   @NotNull
   public abstract List<OpenPriceGroup> getOpenPriceGroups();

   @NotNull
   public abstract CrateAnimationManager getAnimationManager();

   public abstract void tryInstantOpen(@NotNull Player var1, @NotNull Location var2, @Nullable SpawnedCrate var3);

   public abstract void instantOpen(@NotNull Player var1, @NotNull Location var2, @Nullable SpawnedCrate var3);

   @NotNull
   public abstract CompletableFuture<Void> tryOpen(@NotNull Player var1, @NotNull Location var2, @Nullable SpawnedCrate var3);

   @NotNull
   public abstract CompletableFuture<Void> open(@NotNull Player var1, @NotNull Location var2, @Nullable SpawnedCrate var3);

   @NotNull
   public abstract CompletableFuture<Void> tryMassOpen(@NotNull Player var1, int var2, @Nullable Integer var3);

   @NotNull
   public abstract CompletableFuture<Void> massOpen(@NotNull Player var1, int var2, @Nullable Integer var3);

   public abstract void openPreview(@NotNull Player var1, @Nullable SpawnedCrate var2);
}
