package gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property.impl;

import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.EntityAnimationProp;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property.EntityProperty;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property.EntityPropertySerializer;
import gg.aquatic.waves.fake.entity.FakeEntity;
import gg.aquatic.waves.fake.entity.data.ConfiguredEntityData;
import gg.aquatic.waves.fake.entity.data.EntityData;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.registry.WavesRegistry;
import gg.aquatic.waves.util.argument.ArgumentSerializer;
import gg.aquatic.waves.util.argument.ObjectArguments;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/impl/EntityDataProperty;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/EntityProperty;", "data", "", "Lgg/aquatic/waves/fake/entity/data/ConfiguredEntityData;", "<init>", "(Ljava/util/Collection;)V", "getData", "()Ljava/util/Collection;", "apply", "", "entity", "Lgg/aquatic/waves/fake/entity/FakeEntity;", "prop", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/EntityAnimationProp;", "Serializer", "plugin"}
)
@SourceDebugExtension({"SMAP\nEntityDataProperty.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityDataProperty.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/impl/EntityDataProperty\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,37:1\n1374#2:38\n1460#2,5:39\n*S KotlinDebug\n*F\n+ 1 EntityDataProperty.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/impl/EntityDataProperty\n*L\n19#1:38\n19#1:39,5\n*E\n"})
public final class EntityDataProperty implements EntityProperty {
   @NotNull
   private final Collection<ConfiguredEntityData> data;

   public EntityDataProperty(@NotNull Collection<ConfiguredEntityData> var1) {
      Intrinsics.checkNotNullParameter(var1, "data");
      super();
      this.data = var1;
   }

   @NotNull
   public final Collection<ConfiguredEntityData> getData() {
      return this.data;
   }

   public void apply(@NotNull FakeEntity var1, @NotNull EntityAnimationProp var2) {
      Intrinsics.checkNotNullParameter(var1, "entity");
      Intrinsics.checkNotNullParameter(var2, "prop");
      var1.updateEntity(EntityDataProperty::apply$lambda$2);
   }

   private static final String apply$lambda$2$lambda$1$lambda$0(EntityAnimationProp var0, String var1) {
      Intrinsics.checkNotNullParameter(var1, "str");
      return var0.getAnimation().updatePlaceholders(var1);
   }

   private static final Unit apply$lambda$2(EntityDataProperty var0, EntityAnimationProp var1, FakeEntity var2) {
      Intrinsics.checkNotNullParameter(var2, "$this$updateEntity");
      Iterable var4 = (Iterable)var0.data;
      boolean var5 = false;
      Collection var7 = (Collection)(new ArrayList());
      boolean var8 = false;
      Iterator var9 = var4.iterator();

      while(var9.hasNext()) {
         Object var10 = var9.next();
         ConfiguredEntityData var11 = (ConfiguredEntityData)var10;
         boolean var12 = false;
         Iterable var13 = (Iterable)var11.generate(EntityDataProperty::apply$lambda$2$lambda$1$lambda$0);
         CollectionsKt.addAll(var7, var13);
      }

      List var3 = (List)var7;
      var2.setEntityData((Collection)var3);
      return Unit.INSTANCE;
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/impl/EntityDataProperty$Serializer;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/EntityPropertySerializer;", "<init>", "()V", "load", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/EntityProperty;", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "plugin"}
   )
   @SourceDebugExtension({"SMAP\nEntityDataProperty.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityDataProperty.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/impl/EntityDataProperty$Serializer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,37:1\n1617#2,9:38\n1869#2:47\n1870#2:49\n1626#2:50\n1#3:48\n*S KotlinDebug\n*F\n+ 1 EntityDataProperty.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/impl/EntityDataProperty$Serializer\n*L\n26#1:38,9\n26#1:47\n26#1:49\n26#1:50\n26#1:48\n*E\n"})
   public static final class Serializer implements EntityPropertySerializer {
      @NotNull
      public static final EntityDataProperty.Serializer INSTANCE = new EntityDataProperty.Serializer();

      private Serializer() {
      }

      @NotNull
      public EntityProperty load(@NotNull ConfigurationSection var1) {
         Intrinsics.checkNotNullParameter(var1, "section");
         Set var10000 = var1.getKeys(false);
         Intrinsics.checkNotNullExpressionValue(var10000, "getKeys(...)");
         Iterable var2 = (Iterable)var10000;
         boolean var3 = false;
         Collection var5 = (Collection)(new ArrayList());
         boolean var6 = false;
         boolean var8 = false;
         Iterator var9 = var2.iterator();

         while(var9.hasNext()) {
            Object var10 = var9.next();
            boolean var12 = false;
            String var13 = (String)var10;
            boolean var14 = false;
            HashMap var15 = new HashMap();
            Iterator var16 = WavesRegistry.INSTANCE.getENTITY_DATA().values().iterator();

            while(var16.hasNext()) {
               Object var21 = var16.next();
               Intrinsics.checkNotNullExpressionValue(var21, "next(...)");
               HashMap var17 = (HashMap)var21;
               ((Map)var15).putAll((Map)var17);
            }

            EntityData var23 = (EntityData)var15.get(var13);
            ConfiguredEntityData var24;
            if (var23 == null) {
               var24 = null;
            } else {
               EntityData var22 = var23;
               ObjectArguments var25 = new ObjectArguments(ArgumentSerializer.INSTANCE.load(var1, (Collection)var22.getArguments()));
               var24 = new ConfiguredEntityData(var22, var25);
            }

            if (var24 != null) {
               ConfiguredEntityData var18 = var24;
               boolean var19 = false;
               var5.add(var18);
            }
         }

         Collection var20 = (Collection)((List)var5);
         return (EntityProperty)(new EntityDataProperty(var20));
      }
   }
}
