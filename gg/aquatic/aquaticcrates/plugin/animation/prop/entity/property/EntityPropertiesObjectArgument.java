package gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property;

import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property.impl.EntityArmorProperty;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property.impl.EntityDataProperty;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.collections.MapsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.argument.AbstractObjectArgumentSerializer;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0012B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\"\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/EntityPropertiesObjectArgument;", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/EntityProperty;", "id", "", "defaultValue", "required", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Z)V", "serializer", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "getSerializer", "()Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "Serializer", "plugin"}
)
public final class EntityPropertiesObjectArgument extends AquaticObjectArgument<List<? extends EntityProperty>> {
   @NotNull
   private final AbstractObjectArgumentSerializer<List<EntityProperty>> serializer;

   public EntityPropertiesObjectArgument(@NotNull String var1, @Nullable List<? extends EntityProperty> var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "id");
      super(var1, var2, var3);
      this.serializer = (AbstractObjectArgumentSerializer)EntityPropertiesObjectArgument.Serializer.INSTANCE;
   }

   @NotNull
   public AbstractObjectArgumentSerializer<List<EntityProperty>> getSerializer() {
      return this.serializer;
   }

   @Nullable
   public List<EntityProperty> load(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      return (List)this.getSerializer().load(var1, this.getId());
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/EntityPropertiesObjectArgument$Serializer;", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/EntityProperty;", "<init>", "()V", "factories", "", "", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/impl/EntityArmorProperty$Serializer;", "getFactories", "()Ljava/util/Map;", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "id", "plugin"}
   )
   public static final class Serializer extends AbstractObjectArgumentSerializer<List<? extends EntityProperty>> {
      @NotNull
      public static final EntityPropertiesObjectArgument.Serializer INSTANCE = new EntityPropertiesObjectArgument.Serializer();
      @NotNull
      private static final Map<String, EntityArmorProperty.Serializer> factories;

      private Serializer() {
      }

      @NotNull
      public final Map<String, EntityArmorProperty.Serializer> getFactories() {
         return factories;
      }

      @NotNull
      public List<EntityProperty> load(@NotNull ConfigurationSection var1, @NotNull String var2) {
         Intrinsics.checkNotNullParameter(var1, "section");
         Intrinsics.checkNotNullParameter(var2, "id");
         List var3 = (List)(new ArrayList());
         ConfigurationSection var10000 = var1.getConfigurationSection(var2);
         if (var10000 == null) {
            return var3;
         } else {
            ConfigurationSection var4 = var10000;
            ((Collection)var3).add(EntityDataProperty.Serializer.INSTANCE.load(var4));
            Iterator var5 = factories.entrySet().iterator();

            while(var5.hasNext()) {
               Entry var6 = (Entry)var5.next();
               String var7 = (String)var6.getKey();
               EntityArmorProperty.Serializer var8 = (EntityArmorProperty.Serializer)var6.getValue();
               if (var4.contains(var7)) {
                  ((Collection)var3).add(var8.load(var4));
               }
            }

            return var3;
         }
      }

      static {
         Pair[] var0 = new Pair[]{TuplesKt.to("armor", EntityArmorProperty.Serializer.INSTANCE)};
         factories = MapsKt.mutableMapOf(var0);
      }
   }
}
