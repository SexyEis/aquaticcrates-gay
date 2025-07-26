package gg.aquatic.aquaticcrates.plugin.animation.prop;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.prop.PlayerBoundAnimationProp;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathBoundProperties;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathPoint;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathProp;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.api.nms.NMSHandler;
import gg.aquatic.waves.api.nms.PacketEntity;
import gg.aquatic.waves.api.nms.profile.GameEventAction;
import gg.aquatic.waves.api.nms.profile.UserProfile;
import gg.aquatic.waves.api.nms.profile.UserProfile.TextureProperty;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.EntityExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002BS\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\n\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020$H\u0002J\u0006\u00103\u001a\u00020\"J\u0010\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u000206H\u0002J\f\u00107\u001a\u000208*\u000209H\u0002J\b\u0010:\u001a\u00020\"H\u0016J\u000e\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u000eJ\u000e\u0010=\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010>\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010?\u001a\u00020\"H\u0016J\u0006\u0010@\u001a\u00020\"R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R,\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010,\u001a\u00070\u0006¢\u0006\u0002\b-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0016R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u0006A"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/CameraAnimationProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/PlayerBoundAnimationProp;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/Moveable;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "location", "Lorg/bukkit/Location;", "locationOffset", "Lorg/bukkit/util/Vector;", "boundPaths", "Ljava/util/concurrent/ConcurrentHashMap;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathProp;", "Lgg/aquatic/waves/libs/kotlin/Pair;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathBoundProperties;", "", "locationOffsetYawPitch", "", "<init>", "(Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;Lorg/bukkit/Location;Lorg/bukkit/util/Vector;Ljava/util/concurrent/ConcurrentHashMap;Lkotlin/Pair;)V", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "getLocation", "()Lorg/bukkit/Location;", "getLocationOffset", "()Lorg/bukkit/util/Vector;", "getBoundPaths", "()Ljava/util/concurrent/ConcurrentHashMap;", "getLocationOffsetYawPitch", "()Lkotlin/Pair;", "processedPaths", "", "getProcessedPaths", "()Ljava/util/Set;", "move", "", "packetEntity", "Lgg/aquatic/waves/api/nms/PacketEntity;", "getPacketEntity", "()Lgg/aquatic/waves/api/nms/PacketEntity;", "createEntity", "previousGamemode", "Lorg/bukkit/GameMode;", "getPreviousGamemode", "()Lorg/bukkit/GameMode;", "previousLocation", "Lorg/jetbrains/annotations/NotNull;", "getPreviousLocation", "wasFlying", "", "getWasFlying", "()Z", "attachPlayer", "modernPlayerListOrder", "player", "Lorg/bukkit/entity/Player;", "toUserProfile", "Lgg/aquatic/waves/api/nms/profile/UserProfile;", "Lcom/destroystokyo/paper/profile/PlayerProfile;", "tick", "setTeleportInterpolation", "interpolation", "smoothTeleport", "teleport", "onAnimationEnd", "detach", "plugin"}
)
@SourceDebugExtension({"SMAP\nCameraAnimationProp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/CameraAnimationProp\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,155:1\n1563#2:156\n1634#2,3:157\n6#3,4:160\n30#3,4:164\n*S KotlinDebug\n*F\n+ 1 CameraAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/CameraAnimationProp\n*L\n100#1:156\n100#1:157,3\n58#1:160,4\n62#1:164,4\n*E\n"})
public final class CameraAnimationProp extends PlayerBoundAnimationProp implements Moveable {
   @NotNull
   private final PlayerBoundAnimation animation;
   @NotNull
   private final Location location;
   @NotNull
   private final Vector locationOffset;
   @NotNull
   private final ConcurrentHashMap<PathProp, Pair<PathBoundProperties, Integer>> boundPaths;
   @NotNull
   private final Pair<Float, Float> locationOffsetYawPitch;
   @NotNull
   private final Set<PathProp> processedPaths;
   @NotNull
   private final PacketEntity packetEntity;
   @NotNull
   private final GameMode previousGamemode;
   @NotNull
   private final Location previousLocation;
   private final boolean wasFlying;

   public CameraAnimationProp(@NotNull PlayerBoundAnimation var1, @NotNull Location var2, @NotNull Vector var3, @NotNull ConcurrentHashMap<PathProp, Pair<PathBoundProperties, Integer>> var4, @NotNull Pair<Float, Float> var5) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      Intrinsics.checkNotNullParameter(var2, "location");
      Intrinsics.checkNotNullParameter(var3, "locationOffset");
      Intrinsics.checkNotNullParameter(var4, "boundPaths");
      Intrinsics.checkNotNullParameter(var5, "locationOffsetYawPitch");
      super();
      this.animation = var1;
      this.location = var2;
      this.locationOffset = var3;
      this.boundPaths = var4;
      this.locationOffsetYawPitch = var5;
      KeySetView var10001 = ConcurrentHashMap.newKeySet();
      Intrinsics.checkNotNullExpressionValue(var10001, "newKeySet(...)");
      this.processedPaths = (Set)var10001;
      this.packetEntity = this.createEntity();
      GameMode var6 = this.getAnimation().getPlayer().getGameMode();
      Intrinsics.checkNotNullExpressionValue(var6, "getGameMode(...)");
      this.previousGamemode = var6;
      Location var7 = this.getAnimation().getPlayer().getLocation().clone();
      Intrinsics.checkNotNullExpressionValue(var7, "clone(...)");
      this.previousLocation = var7;
      this.wasFlying = this.getAnimation().getPlayer().getAllowFlight();
   }

   @NotNull
   public PlayerBoundAnimation getAnimation() {
      return this.animation;
   }

   @NotNull
   public final Location getLocation() {
      return this.location;
   }

   @NotNull
   public Vector getLocationOffset() {
      return this.locationOffset;
   }

   @NotNull
   public ConcurrentHashMap<PathProp, Pair<PathBoundProperties, Integer>> getBoundPaths() {
      return this.boundPaths;
   }

   @NotNull
   public Pair<Float, Float> getLocationOffsetYawPitch() {
      return this.locationOffsetYawPitch;
   }

   @NotNull
   public Set<PathProp> getProcessedPaths() {
      return this.processedPaths;
   }

   public void move(@NotNull Location var1) {
      Intrinsics.checkNotNullParameter(var1, "location");
      this.smoothTeleport(var1);
   }

   @NotNull
   public final PacketEntity getPacketEntity() {
      return this.packetEntity;
   }

   private final PacketEntity createEntity() {
      PacketEntity var10000 = Waves.Companion.getNMS_HANDLER().createEntity(this.location, EntityType.BLOCK_DISPLAY, (UUID)null);
      if (var10000 == null) {
         throw new Exception("Failed to create entity");
      } else {
         PacketEntity var1 = var10000;
         return var1;
      }
   }

   @NotNull
   public final GameMode getPreviousGamemode() {
      return this.previousGamemode;
   }

   @NotNull
   public final Location getPreviousLocation() {
      return this.previousLocation;
   }

   public final boolean getWasFlying() {
      return this.wasFlying;
   }

   public final void attachPlayer() {
      int var1 = Intrinsics.areEqual(this.previousLocation.getWorld(), this.location.getWorld()) ? 0 : 5;
      this.getAnimation().getPlayer().teleportAsync(this.location).thenAccept(CameraAnimationProp::attachPlayer$lambda$3);
   }

   private final int modernPlayerListOrder(Player var1) {
      return var1.getPlayerListOrder();
   }

   private final UserProfile toUserProfile(PlayerProfile var1) {
      UUID var10000 = var1.getId();
      if (var10000 == null) {
         var10000 = UUID.randomUUID();
      }

      UUID var3 = var10000;
      Intrinsics.checkNotNull(var3);
      var10000 = var3;
      String var10001 = var1.getName();
      if (var10001 == null) {
         var10001 = "";
      }

      Set var10002 = var1.getProperties();
      Intrinsics.checkNotNullExpressionValue(var10002, "getProperties(...)");
      Iterable var18 = (Iterable)var10002;
      String var13 = var10001;
      UUID var12 = var10000;
      boolean var4 = false;
      Collection var6 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var18, 10)));
      boolean var7 = false;
      Iterator var8 = var18.iterator();

      while(var8.hasNext()) {
         Object var9 = var8.next();
         ProfileProperty var10 = (ProfileProperty)var9;
         boolean var11 = false;
         TextureProperty var19 = new TextureProperty;
         String var20 = var10.getName();
         Intrinsics.checkNotNullExpressionValue(var20, "getName(...)");
         String var10003 = var10.getValue();
         Intrinsics.checkNotNullExpressionValue(var10003, "getValue(...)");
         String var10004 = var10.getSignature();
         if (var10004 == null) {
            var10004 = "";
         }

         var19.<init>(var20, var10003, var10004);
         var6.add(var19);
      }

      List var14 = (List)var6;
      Collection var15 = (Collection)CollectionsKt.toMutableList((Collection)var14);
      UserProfile var2 = new UserProfile(var12, var13, var15);
      return var2;
   }

   public void tick() {
      if (!this.wasFlying) {
         this.getAnimation().getPlayer().setAllowFlight(true);
         this.getAnimation().getPlayer().setFlying(true);
      }
   }

   public final void setTeleportInterpolation(int var1) {
      EntityExtKt.modify(this.packetEntity, CameraAnimationProp::setTeleportInterpolation$lambda$5);
      Player var10000 = this.getAnimation().getPlayer();
      Object var10001 = this.packetEntity.getUpdatePacket();
      Intrinsics.checkNotNull(var10001);
      EntityExtKt.sendPacket(var10000, var10001, false);
   }

   public final void smoothTeleport(@NotNull Location var1) {
      Intrinsics.checkNotNullParameter(var1, "location");
      this.setTeleportInterpolation(2);
      PacketEntity var10000 = this.packetEntity;
      NMSHandler var10001 = Waves.Companion.getNMS_HANDLER();
      Player[] var2 = new Player[]{this.getAnimation().getPlayer()};
      var10000.teleport(var10001, var1, false, var2);
   }

   public final void teleport(@NotNull Location var1) {
      Intrinsics.checkNotNullParameter(var1, "location");
      this.setTeleportInterpolation(0);
      PacketEntity var10000 = this.packetEntity;
      NMSHandler var10001 = Waves.Companion.getNMS_HANDLER();
      Player[] var2 = new Player[]{this.getAnimation().getPlayer()};
      var10000.teleport(var10001, var1, false, var2);
   }

   public void onAnimationEnd() {
   }

   public final void detach() {
      Object var1 = Waves.Companion.getNMS_HANDLER().createChangeGameStatePacket(GameEventAction.CHANGE_GAME_MODE, (float)this.previousGamemode.getValue());
      Object var2 = Waves.Companion.getNMS_HANDLER().createCameraPacket(this.getAnimation().getPlayer().getEntityId());
      EntityExtKt.sendPacket$default(this.getAnimation().getPlayer(), var2, false, 2, (Object)null);
      EntityExtKt.sendPacket$default(this.getAnimation().getPlayer(), var1, false, 2, (Object)null);
      if (!this.wasFlying) {
         this.getAnimation().getPlayer().setFlying(false);
         this.getAnimation().getPlayer().setAllowFlight(false);
      }
   }

   public void processPath(@NotNull PathProp var1, @NotNull PathPoint var2) {
      Moveable.DefaultImpls.processPath(this, var1, var2);
   }

   @NotNull
   public PathPoint calculatePoint() {
      return Moveable.DefaultImpls.calculatePoint(this);
   }

   private static final Unit attachPlayer$lambda$2(int var0, CameraAnimationProp var1, Boolean var2) {
      boolean var3 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new CameraAnimationProp$attachPlayer$lambda$2$$inlined$runSync$1(var1)));
      long var6 = (long)var0;
      boolean var5 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTaskLater((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new CameraAnimationProp$attachPlayer$lambda$2$$inlined$runLaterSync$1(var1)), var6);
      return Unit.INSTANCE;
   }

   private static final void attachPlayer$lambda$3(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit setTeleportInterpolation$lambda$5(int var0, Entity var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      BlockDisplay var2 = (BlockDisplay)var1;
      var2.setTeleportDuration(var0);
      return Unit.INSTANCE;
   }

   // $FF: synthetic method
   public static final int access$modernPlayerListOrder(CameraAnimationProp var0, Player var1) {
      return var0.modernPlayerListOrder(var1);
   }

   // $FF: synthetic method
   public static final UserProfile access$toUserProfile(CameraAnimationProp var0, PlayerProfile var1) {
      return var0.toUserProfile(var1);
   }
}
