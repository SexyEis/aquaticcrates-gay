package gg.aquatic.aquaticcrates.plugin.animation.prop.entity;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.plugin.animation.prop.Moveable;
import gg.aquatic.aquaticcrates.plugin.animation.prop.Seatable;
import gg.aquatic.aquaticcrates.plugin.animation.prop.Throwable;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property.EntityProperty;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathBoundProperties;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathPoint;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathProp;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.fake.entity.FakeEntity;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.EntityExtKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004Ba\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\n\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\f¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016J\u0010\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\bH\u0016J\u0010\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\u0000H\u0016J\u0010\u00104\u001a\u00020+2\u0006\u00103\u001a\u00020\u0000H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR,\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0'X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u00065"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/EntityAnimationProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/Moveable;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/Throwable;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/Seatable;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "locationOffset", "Lorg/bukkit/util/Vector;", "boundPaths", "Ljava/util/concurrent/ConcurrentHashMap;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathProp;", "Lgg/aquatic/waves/libs/kotlin/Pair;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathBoundProperties;", "", "entityType", "", "properties", "", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/EntityProperty;", "locationOffsetYawPitch", "", "<init>", "(Lgg/aquatic/aquaticcrates/api/animation/Animation;Lorg/bukkit/util/Vector;Ljava/util/concurrent/ConcurrentHashMap;Ljava/lang/String;Ljava/util/Collection;Lkotlin/Pair;)V", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/Animation;", "getLocationOffset", "()Lorg/bukkit/util/Vector;", "getBoundPaths", "()Ljava/util/concurrent/ConcurrentHashMap;", "getLocationOffsetYawPitch", "()Lkotlin/Pair;", "entity", "Lgg/aquatic/waves/fake/entity/FakeEntity;", "getEntity", "()Lgg/aquatic/waves/fake/entity/FakeEntity;", "setEntity", "(Lgg/aquatic/waves/fake/entity/FakeEntity;)V", "processedPaths", "", "getProcessedPaths", "()Ljava/util/Set;", "tick", "", "onAnimationEnd", "move", "location", "Lorg/bukkit/Location;", "throwObject", "vector", "addPassenger", "entityAnimationProp", "removePassenger", "plugin"}
)
public final class EntityAnimationProp extends AnimationProp implements Moveable, Throwable, Seatable {
   @NotNull
   private final Animation animation;
   @NotNull
   private final Vector locationOffset;
   @NotNull
   private final ConcurrentHashMap<PathProp, Pair<PathBoundProperties, Integer>> boundPaths;
   @NotNull
   private final Pair<Float, Float> locationOffsetYawPitch;
   @NotNull
   private FakeEntity entity;
   @NotNull
   private final Set<PathProp> processedPaths;

   public EntityAnimationProp(@NotNull Animation var1, @NotNull Vector var2, @NotNull ConcurrentHashMap<PathProp, Pair<PathBoundProperties, Integer>> var3, @NotNull String var4, @NotNull Collection<? extends EntityProperty> var5, @NotNull Pair<Float, Float> var6) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      Intrinsics.checkNotNullParameter(var2, "locationOffset");
      Intrinsics.checkNotNullParameter(var3, "boundPaths");
      Intrinsics.checkNotNullParameter(var4, "entityType");
      Intrinsics.checkNotNullParameter(var5, "properties");
      Intrinsics.checkNotNullParameter(var6, "locationOffsetYawPitch");
      super();
      this.animation = var1;
      this.locationOffset = var2;
      this.boundPaths = var3;
      this.locationOffsetYawPitch = var6;
      KeySetView var10001 = ConcurrentHashMap.newKeySet();
      Intrinsics.checkNotNullExpressionValue(var10001, "newKeySet(...)");
      this.processedPaths = (Set)var10001;
      Location var10000;
      if (this.getBoundPaths().isEmpty()) {
         Location var9 = this.getAnimation().getBaseLocation().clone().add(this.getLocationOffset());
         boolean var11 = false;
         var9.setYaw(var9.getYaw() + ((Number)this.getLocationOffsetYawPitch().getFirst()).floatValue());
         var9.setPitch(var9.getPitch() + ((Number)this.getLocationOffsetYawPitch().getSecond()).floatValue());
         var10000 = var9;
      } else {
         PathPoint var13 = this.calculatePoint();
         var10000 = this.getAnimation().getBaseLocation().clone().add(var13.getVector()).add(this.getLocationOffset());
         Intrinsics.checkNotNullExpressionValue(var10000, "add(...)");
         Location var10 = var10000;
         var10.setYaw(var13.getYaw() + ((Number)this.getLocationOffsetYawPitch().getFirst()).floatValue());
         var10.setPitch(var13.getPitch() + ((Number)this.getLocationOffsetYawPitch().getSecond()).floatValue());
         var10000 = var10;
      }

      Location var8 = var10000;
      Intrinsics.checkNotNull(var8);
      String var10003 = var4.toUpperCase(Locale.ROOT);
      Intrinsics.checkNotNullExpressionValue(var10003, "toUpperCase(...)");
      this.entity = new FakeEntity(EntityType.valueOf(var10003), var8, 50, this.getAnimation().getAudience(), (Function1)null, (Function1)null, (Function1)null, 112, (DefaultConstructorMarker)null);
      Iterator var12 = var5.iterator();

      while(var12.hasNext()) {
         EntityProperty var14 = (EntityProperty)var12.next();
         var14.apply(this.entity, this);
      }

   }

   @NotNull
   public Animation getAnimation() {
      return this.animation;
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
   public final FakeEntity getEntity() {
      return this.entity;
   }

   public final void setEntity(@NotNull FakeEntity var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.entity = var1;
   }

   @NotNull
   public Set<PathProp> getProcessedPaths() {
      return this.processedPaths;
   }

   public void tick() {
   }

   public void onAnimationEnd() {
      this.entity.destroy();
   }

   public void move(@NotNull Location var1) {
      Intrinsics.checkNotNullParameter(var1, "location");
      this.entity.teleport(var1);
   }

   public void throwObject(@NotNull Vector var1) {
      Intrinsics.checkNotNullParameter(var1, "vector");
      Object var2 = Waves.Companion.getNMS_HANDLER().createEntityMotionPacket(this.entity.getEntityId(), var1);
      Iterator var10000 = this.entity.getViewers().iterator();
      Intrinsics.checkNotNullExpressionValue(var10000, "iterator(...)");
      Iterator var3 = var10000;

      while(var3.hasNext()) {
         Player var4 = (Player)var3.next();
         Intrinsics.checkNotNull(var4);
         EntityExtKt.sendPacket$default(var4, var2, false, 2, (Object)null);
      }

   }

   public void addPassenger(@NotNull EntityAnimationProp var1) {
      Intrinsics.checkNotNullParameter(var1, "entityAnimationProp");
      this.entity.updateEntity(EntityAnimationProp::addPassenger$lambda$1);
   }

   public void removePassenger(@NotNull EntityAnimationProp var1) {
      Intrinsics.checkNotNullParameter(var1, "entityAnimationProp");
      this.entity.updateEntity(EntityAnimationProp::removePassenger$lambda$2);
   }

   public void processPath(@NotNull PathProp var1, @NotNull PathPoint var2) {
      Moveable.DefaultImpls.processPath(this, var1, var2);
   }

   @NotNull
   public PathPoint calculatePoint() {
      return Moveable.DefaultImpls.calculatePoint(this);
   }

   private static final Unit addPassenger$lambda$1(EntityAnimationProp var0, FakeEntity var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$updateEntity");
      KeySetView var10000 = var1.getPassengers();
      Intrinsics.checkNotNullExpressionValue(var10000, "<get-passengers>(...)");
      Collection var2 = (Collection)var10000;
      var2.add(var0.entity.getEntityId());
      return Unit.INSTANCE;
   }

   private static final Unit removePassenger$lambda$2(EntityAnimationProp var0, FakeEntity var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$updateEntity");
      KeySetView var10000 = var1.getPassengers();
      Intrinsics.checkNotNullExpressionValue(var10000, "<get-passengers>(...)");
      Collection var2 = (Collection)var10000;
      var2.remove(var0.entity.getEntityId());
      return Unit.INSTANCE;
   }
}
