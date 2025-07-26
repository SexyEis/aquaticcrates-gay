package gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property.impl;

import gg.aquatic.aquaticcrates.api.util.animationitem.ArgumentItem;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.EntityAnimationProp;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property.EntityProperty;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property.EntityPropertySerializer;
import gg.aquatic.waves.fake.entity.FakeEntity;
import gg.aquatic.waves.fake.entity.data.impl.ItemEntityData.Item;
import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0015"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/impl/EntityArmorProperty;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/EntityProperty;", "helmet", "Lgg/aquatic/aquaticcrates/api/util/animationitem/ArgumentItem;", "chestplate", "leggings", "boots", "<init>", "(Lgg/aquatic/aquaticcrates/api/util/animationitem/ArgumentItem;Lgg/aquatic/aquaticcrates/api/util/animationitem/ArgumentItem;Lgg/aquatic/aquaticcrates/api/util/animationitem/ArgumentItem;Lgg/aquatic/aquaticcrates/api/util/animationitem/ArgumentItem;)V", "getHelmet", "()Lgg/aquatic/aquaticcrates/api/util/animationitem/ArgumentItem;", "getChestplate", "getLeggings", "getBoots", "apply", "", "entity", "Lgg/aquatic/waves/fake/entity/FakeEntity;", "prop", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/EntityAnimationProp;", "Serializer", "plugin"}
)
public final class EntityArmorProperty implements EntityProperty {
   @Nullable
   private final ArgumentItem helmet;
   @Nullable
   private final ArgumentItem chestplate;
   @Nullable
   private final ArgumentItem leggings;
   @Nullable
   private final ArgumentItem boots;

   public EntityArmorProperty(@Nullable ArgumentItem var1, @Nullable ArgumentItem var2, @Nullable ArgumentItem var3, @Nullable ArgumentItem var4) {
      this.helmet = var1;
      this.chestplate = var2;
      this.leggings = var3;
      this.boots = var4;
   }

   @Nullable
   public final ArgumentItem getHelmet() {
      return this.helmet;
   }

   @Nullable
   public final ArgumentItem getChestplate() {
      return this.chestplate;
   }

   @Nullable
   public final ArgumentItem getLeggings() {
      return this.leggings;
   }

   @Nullable
   public final ArgumentItem getBoots() {
      return this.boots;
   }

   public void apply(@NotNull FakeEntity var1, @NotNull EntityAnimationProp var2) {
      Intrinsics.checkNotNullParameter(var1, "entity");
      Intrinsics.checkNotNullParameter(var2, "prop");
      if (var1.getType() == EntityType.ITEM) {
         var1.updateEntity(EntityArmorProperty::apply$lambda$1);
      } else {
         if (var1.getType() != EntityType.ITEM_DISPLAY) {
            var1.updateEntity(EntityArmorProperty::apply$lambda$6);
            return;
         }

         var1.updateEntity(EntityArmorProperty::apply$lambda$8);
      }

   }

   private static final Unit apply$lambda$1(EntityArmorProperty var0, EntityAnimationProp var1, FakeEntity var2, FakeEntity var3) {
      Intrinsics.checkNotNullParameter(var3, "$this$updateEntity");
      ArgumentItem var10000 = var0.helmet;
      if (var10000 != null) {
         AquaticItem var7 = var10000.getActualItem(var1.getAnimation());
         if (var7 != null) {
            ItemStack var8 = var7.getItem();
            if (var8 != null) {
               ItemStack var4 = var8;
               boolean var5 = false;
               ArrayList var6 = new ArrayList();
               if (var2.getType() == EntityType.ITEM) {
                  CollectionsKt.addAll((Collection)var6, (Iterable)Item.INSTANCE.generate(var4));
               }

               var3.setEntityData((Collection)var6);
            }
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit apply$lambda$6(EntityArmorProperty var0, EntityAnimationProp var1, FakeEntity var2) {
      Intrinsics.checkNotNullParameter(var2, "$this$updateEntity");
      ArgumentItem var10000 = var0.helmet;
      ItemStack var3;
      boolean var4;
      AquaticItem var5;
      ItemStack var6;
      if (var10000 != null) {
         var5 = var10000.getActualItem(var1.getAnimation());
         if (var5 != null) {
            var6 = var5.getItem();
            if (var6 != null) {
               var3 = var6;
               var4 = false;
               ((Map)var2.getEquipment()).put(EquipmentSlot.HEAD, var3);
            }
         }
      }

      var10000 = var0.chestplate;
      if (var10000 != null) {
         var5 = var10000.getActualItem(var1.getAnimation());
         if (var5 != null) {
            var6 = var5.getItem();
            if (var6 != null) {
               var3 = var6;
               var4 = false;
               ((Map)var2.getEquipment()).put(EquipmentSlot.CHEST, var3);
            }
         }
      }

      var10000 = var0.leggings;
      if (var10000 != null) {
         var5 = var10000.getActualItem(var1.getAnimation());
         if (var5 != null) {
            var6 = var5.getItem();
            if (var6 != null) {
               var3 = var6;
               var4 = false;
               ((Map)var2.getEquipment()).put(EquipmentSlot.LEGS, var3);
            }
         }
      }

      var10000 = var0.boots;
      if (var10000 != null) {
         var5 = var10000.getActualItem(var1.getAnimation());
         if (var5 != null) {
            var6 = var5.getItem();
            if (var6 != null) {
               var3 = var6;
               var4 = false;
               ((Map)var2.getEquipment()).put(EquipmentSlot.FEET, var3);
            }
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit apply$lambda$8(EntityArmorProperty var0, EntityAnimationProp var1, FakeEntity var2, FakeEntity var3) {
      Intrinsics.checkNotNullParameter(var3, "$this$updateEntity");
      ArgumentItem var10000 = var0.helmet;
      if (var10000 != null) {
         AquaticItem var7 = var10000.getActualItem(var1.getAnimation());
         if (var7 != null) {
            ItemStack var8 = var7.getItem();
            if (var8 != null) {
               ItemStack var4 = var8;
               boolean var5 = false;
               ArrayList var6 = new ArrayList();
               if (var2.getType() == EntityType.ITEM_DISPLAY) {
                  CollectionsKt.addAll((Collection)var6, (Iterable)gg.aquatic.waves.fake.entity.data.impl.display.ItemDisplayEntityData.Item.INSTANCE.generate(var4));
               }

               var3.setEntityData((Collection)var6);
            }
         }
      }

      return Unit.INSTANCE;
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/impl/EntityArmorProperty$Serializer;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/EntityPropertySerializer;", "<init>", "()V", "load", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/EntityProperty;", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "plugin"}
   )
   public static final class Serializer implements EntityPropertySerializer {
      @NotNull
      public static final EntityArmorProperty.Serializer INSTANCE = new EntityArmorProperty.Serializer();

      private Serializer() {
      }

      @NotNull
      public EntityProperty load(@NotNull ConfigurationSection var1) {
         Intrinsics.checkNotNullParameter(var1, "section");
         ArgumentItem var2 = ArgumentItem.Companion.loadFromYml(var1.getConfigurationSection("armor.helmet"));
         ArgumentItem var3 = ArgumentItem.Companion.loadFromYml(var1.getConfigurationSection("armor.chestplate"));
         ArgumentItem var4 = ArgumentItem.Companion.loadFromYml(var1.getConfigurationSection("armor.leggings"));
         ArgumentItem var5 = ArgumentItem.Companion.loadFromYml(var1.getConfigurationSection("armor.boots"));
         return (EntityProperty)(new EntityArmorProperty(var2, var3, var4, var5));
      }
   }
}
