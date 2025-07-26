package gg.aquatic.aquaticcrates.plugin.animation.action.path;

import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathPoint;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.util.argument.AbstractObjectArgumentSerializer;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0001\u0013B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R(\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/path/PathPointsArgument;", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "Ljava/util/TreeMap;", "", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathPoint;", "id", "", "defaultValue", "required", "", "<init>", "(Ljava/lang/String;Ljava/util/TreeMap;Z)V", "serializer", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "getSerializer", "()Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "Serializer", "plugin"}
)
public final class PathPointsArgument extends AquaticObjectArgument<TreeMap<Integer, PathPoint>> {
   @NotNull
   private final AbstractObjectArgumentSerializer<TreeMap<Integer, PathPoint>> serializer;

   public PathPointsArgument(@NotNull String var1, @Nullable TreeMap<Integer, PathPoint> var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "id");
      super(var1, var2, var3);
      this.serializer = (AbstractObjectArgumentSerializer)PathPointsArgument.Serializer.INSTANCE;
   }

   @NotNull
   public AbstractObjectArgumentSerializer<TreeMap<Integer, PathPoint>> getSerializer() {
      return this.serializer;
   }

   @Nullable
   public TreeMap<Integer, PathPoint> load(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      Bukkit.getConsoleSender().sendMessage("Loading points!");
      return (TreeMap)this.getSerializer().load(var1, this.getId());
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/path/PathPointsArgument$Serializer;", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "Ljava/util/TreeMap;", "", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathPoint;", "<init>", "()V", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "id", "", "plugin"}
   )
   public static final class Serializer extends AbstractObjectArgumentSerializer<TreeMap<Integer, PathPoint>> {
      @NotNull
      public static final PathPointsArgument.Serializer INSTANCE = new PathPointsArgument.Serializer();

      private Serializer() {
      }

      @NotNull
      public TreeMap<Integer, PathPoint> load(@NotNull ConfigurationSection var1, @NotNull String var2) {
         Intrinsics.checkNotNullParameter(var1, "section");
         Intrinsics.checkNotNullParameter(var2, "id");
         TreeMap var3 = new TreeMap();
         ConfigurationSection var10000 = var1.getConfigurationSection(var2);
         if (var10000 == null) {
            return var3;
         } else {
            ConfigurationSection var4 = var10000;
            Bukkit.getConsoleSender().sendMessage("Points path: " + var4.getCurrentPath());
            Iterator var5 = var4.getKeys(false).iterator();

            while(var5.hasNext()) {
               String var6 = (String)var5.next();
               var10000 = var4.getConfigurationSection(var6);
               if (var10000 != null) {
                  ConfigurationSection var7 = var10000;
                  Bukkit.getConsoleSender().sendMessage("Point path: " + var7.getCurrentPath());
                  Intrinsics.checkNotNull(var6);
                  Integer var19 = StringsKt.toIntOrNull(var6);
                  if (var19 != null) {
                     int var8 = var19;
                     double var9 = var7.getDouble("x");
                     double var11 = var7.getDouble("y");
                     double var13 = var7.getDouble("z");
                     float var15 = (float)var7.getDouble("yaw");
                     float var16 = (float)var7.getDouble("pitch");
                     Map var17 = (Map)var3;
                     Pair var18 = TuplesKt.to(var8, new PathPoint(var9, var11, var13, var15, var16));
                     var17.put(var18.getFirst(), var18.getSecond());
                  }
               }
            }

            return var3;
         }
      }
   }
}
