package gg.aquatic.aquaticcrates.plugin.animation.prop.entity;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathBoundProperties;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathPoint;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.argument.AbstractObjectArgumentSerializer;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00020\u0001:\u0001\u0015B9\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ*\u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R4\u0010\u000e\u001a\"\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/BoundPathObjectArgument;", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "Lgg/aquatic/waves/libs/kotlin/Function1;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathProp;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathBoundProperties;", "id", "", "defaultValue", "required", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Z)V", "serializer", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "getSerializer", "()Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "Serializer", "plugin"}
)
public final class BoundPathObjectArgument extends AquaticObjectArgument<Function1<? super Animation, ? extends ConcurrentHashMap<PathProp, PathBoundProperties>>> {
   @NotNull
   private final AbstractObjectArgumentSerializer<Function1<Animation, ConcurrentHashMap<PathProp, PathBoundProperties>>> serializer;

   public BoundPathObjectArgument(@NotNull String var1, @Nullable Function1<? super Animation, ? extends ConcurrentHashMap<PathProp, PathBoundProperties>> var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "id");
      super(var1, var2, var3);
      this.serializer = (AbstractObjectArgumentSerializer)BoundPathObjectArgument.Serializer.INSTANCE;
   }

   @NotNull
   public AbstractObjectArgumentSerializer<Function1<Animation, ConcurrentHashMap<PathProp, PathBoundProperties>>> getSerializer() {
      return this.serializer;
   }

   @Nullable
   public Function1<Animation, ConcurrentHashMap<PathProp, PathBoundProperties>> load(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      return (Function1)this.getSerializer().load(var1, this.getId());
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\"\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/BoundPathObjectArgument$Serializer;", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "Lgg/aquatic/waves/libs/kotlin/Function1;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathProp;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathBoundProperties;", "<init>", "()V", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "id", "", "plugin"}
   )
   public static final class Serializer extends AbstractObjectArgumentSerializer<Function1<? super Animation, ? extends ConcurrentHashMap<PathProp, PathBoundProperties>>> {
      @NotNull
      public static final BoundPathObjectArgument.Serializer INSTANCE = new BoundPathObjectArgument.Serializer();

      private Serializer() {
      }

      @NotNull
      public Function1<Animation, ConcurrentHashMap<PathProp, PathBoundProperties>> load(@NotNull ConfigurationSection var1, @NotNull String var2) {
         Intrinsics.checkNotNullParameter(var1, "section");
         Intrinsics.checkNotNullParameter(var2, "id");
         ConfigurationSection var10000 = var1.getConfigurationSection(var2);
         if (var10000 == null) {
            return BoundPathObjectArgument.Serializer::load$lambda$0;
         } else {
            ConfigurationSection var3 = var10000;
            return BoundPathObjectArgument.Serializer::load$lambda$1;
         }
      }

      private static final ConcurrentHashMap load$lambda$0(Animation var0) {
         Intrinsics.checkNotNullParameter(var0, "<unused var>");
         return new ConcurrentHashMap();
      }

      private static final ConcurrentHashMap load$lambda$1(ConfigurationSection var0, Animation var1) {
         Intrinsics.checkNotNullParameter(var1, "animation");
         ConcurrentHashMap var2 = new ConcurrentHashMap();
         Iterator var3 = var0.getKeys(false).iterator();

         while(var3.hasNext()) {
            String var4 = (String)var3.next();
            ConfigurationSection var10000 = var0.getConfigurationSection(var4);
            Intrinsics.checkNotNull(var10000);
            ConfigurationSection var5 = var10000;
            Bukkit.getConsoleSender().sendMessage("Path path: " + var5.getCurrentPath());
            Object var7 = var1.getProps().get("path:" + var4);
            PathProp var6 = var7 instanceof PathProp ? (PathProp)var7 : null;
            if (var6 == null) {
               Bukkit.getConsoleSender().sendMessage("Could not find path with id of " + var4);
            } else {
               PathPoint var10002 = new PathPoint(var5.getDouble("offset.x"), var5.getDouble("offset.y"), var5.getDouble("offset.z"), (float)var5.getDouble("offset.yaw"), (float)var5.getDouble("offset.pitch"));
               String var10003 = var5.getString("offset.type", "dynamic");
               Intrinsics.checkNotNull(var10003);
               var10003 = var10003.toUpperCase(Locale.ROOT);
               Intrinsics.checkNotNullExpressionValue(var10003, "toUpperCase(...)");
               PathBoundProperties var10 = new PathBoundProperties(var10002, PathBoundProperties.OffsetType.valueOf(var10003), var5.getBoolean("affect-yaw-pitch", true));
               Map var8 = (Map)var2;
               Pair var9 = TuplesKt.to(var6, var10);
               var8.put(var9.getFirst(), var9.getSecond());
            }
         }

         Bukkit.getConsoleSender().sendMessage("Size: " + var2.size());
         return var2;
      }
   }
}
