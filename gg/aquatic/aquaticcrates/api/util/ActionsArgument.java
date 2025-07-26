package gg.aquatic.aquaticcrates.api.util;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.registry.WavesRegistry;
import gg.aquatic.waves.registry.serializer.ActionSerializer;
import gg.aquatic.waves.util.ConfigExtKt;
import gg.aquatic.waves.util.argument.AbstractObjectArgumentSerializer;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.generic.ConfiguredExecutableObject;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0012"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/util/ActionsArgument;", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "id", "", "defaultValue", "required", "", "<init>", "(Ljava/lang/String;Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;Z)V", "serializer", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "getSerializer", "()Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "Serializer", "api"}
)
public final class ActionsArgument extends AquaticObjectArgument<CrateAnimationActions> {
   public ActionsArgument(@NotNull String var1, @Nullable CrateAnimationActions var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "id");
      super(var1, var2, var3);
   }

   @NotNull
   public AbstractObjectArgumentSerializer<CrateAnimationActions> getSerializer() {
      return (AbstractObjectArgumentSerializer)ActionsArgument.Serializer.INSTANCE;
   }

   @Nullable
   public CrateAnimationActions load(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      return ActionsArgument.Serializer.INSTANCE.load(var1, this.getId());
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/util/ActionsArgument$Serializer;", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "<init>", "()V", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "id", "", "api"}
   )
   @SourceDebugExtension({"SMAP\nActionsArgument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionsArgument.kt\ngg/aquatic/aquaticcrates/api/util/ActionsArgument$Serializer\n+ 2 ActionSerializer.kt\ngg/aquatic/waves/registry/serializer/ActionSerializer\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ActionRegistry.kt\ngg/aquatic/waves/registry/ActionRegistryKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,37:1\n24#2:38\n14#2,2:49\n17#2,4:55\n24#2:62\n14#2,2:73\n17#2,4:79\n1611#3,9:39\n1863#3:48\n1864#3:60\n1620#3:61\n1611#3,9:63\n1863#3:72\n1864#3:84\n1620#3:85\n12#4,4:51\n12#4,4:75\n1#5:59\n1#5:83\n*S KotlinDebug\n*F\n+ 1 ActionsArgument.kt\ngg/aquatic/aquaticcrates/api/util/ActionsArgument$Serializer\n*L\n27#1:38\n27#1:49,2\n27#1:55,4\n28#1:62\n28#1:73,2\n28#1:79,4\n27#1:39,9\n27#1:48\n27#1:60\n27#1:61\n28#1:63,9\n28#1:72\n28#1:84\n28#1:85\n27#1:51,4\n28#1:75,4\n27#1:59\n28#1:83\n*E\n"})
   public static final class Serializer extends AbstractObjectArgumentSerializer<CrateAnimationActions> {
      @NotNull
      public static final ActionsArgument.Serializer INSTANCE = new ActionsArgument.Serializer();

      private Serializer() {
      }

      @NotNull
      public CrateAnimationActions load(@NotNull ConfigurationSection var1, @NotNull String var2) {
         Intrinsics.checkNotNullParameter(var1, "section");
         Intrinsics.checkNotNullParameter(var2, "id");
         ActionSerializer var4 = ActionSerializer.INSTANCE;
         List var5 = ConfigExtKt.getSectionList(var1, var2);
         boolean var6 = false;
         Iterable var7 = (Iterable)var5;
         boolean var8 = false;
         Collection var10 = (Collection)(new ArrayList());
         boolean var11 = false;
         boolean var13 = false;
         Iterator var14 = var7.iterator();

         String var10000;
         ExecutableObject var27;
         ConfiguredExecutableObject var40;
         Map var41;
         ExecutableObject var42;
         while(var14.hasNext()) {
            Object var15 = var14.next();
            boolean var17 = false;
            ConfigurationSection var18 = (ConfigurationSection)var15;
            boolean var19 = false;
            ActionSerializer var20 = ActionSerializer.INSTANCE;
            boolean var21 = false;
            var10000 = var18.getString("type");
            if (var10000 == null) {
               var40 = null;
            } else {
               String var22 = var10000;
               WavesRegistry var23 = WavesRegistry.INSTANCE;
               boolean var24 = false;
               var41 = (Map)var23.getACTION().get(Animation.class);
               if (var41 == null) {
                  var42 = null;
               } else {
                  Map var25 = var41;
                  var42 = (ExecutableObject)var25.get(var22);
                  if (var42 == null) {
                     var42 = null;
                  } else {
                     ExecutableObject var26 = var42;
                     var42 = var26 instanceof ExecutableObject ? var26 : null;
                  }
               }

               if (var42 == null) {
                  var40 = null;
               } else {
                  var27 = var42;
                  ObjectArguments var28 = AquaticObjectArgument.Companion.loadRequirementArguments(var18, var27.getArguments());
                  ConfiguredExecutableObject var48 = new ConfiguredExecutableObject(var27, var28);
                  var40 = var48;
               }
            }

            if (var40 != null) {
               ConfiguredExecutableObject var29 = var40;
               boolean var30 = false;
               var10.add(var29);
            }
         }

         List var3 = (List)var10;
         ActionSerializer var33 = ActionSerializer.INSTANCE;
         List var34 = ConfigExtKt.getSectionList(var1, var2);
         boolean var35 = false;
         Iterable var36 = (Iterable)var34;
         boolean var9 = false;
         Collection var37 = (Collection)(new ArrayList());
         boolean var12 = false;
         boolean var38 = false;
         Iterator var39 = var36.iterator();

         while(var39.hasNext()) {
            Object var16 = var39.next();
            boolean var43 = false;
            ConfigurationSection var44 = (ConfigurationSection)var16;
            boolean var45 = false;
            ActionSerializer var46 = ActionSerializer.INSTANCE;
            boolean var47 = false;
            var10000 = var44.getString("type");
            if (var10000 == null) {
               var40 = null;
            } else {
               String var49 = var10000;
               WavesRegistry var50 = WavesRegistry.INSTANCE;
               boolean var52 = false;
               var41 = (Map)var50.getACTION().get(PlayerBoundAnimation.class);
               if (var41 == null) {
                  var42 = null;
               } else {
                  Map var53 = var41;
                  var42 = (ExecutableObject)var53.get(var49);
                  if (var42 == null) {
                     var42 = null;
                  } else {
                     var27 = var42;
                     var42 = var27 instanceof ExecutableObject ? var27 : null;
                  }
               }

               if (var42 == null) {
                  var40 = null;
               } else {
                  ExecutableObject var54 = var42;
                  ObjectArguments var55 = AquaticObjectArgument.Companion.loadRequirementArguments(var44, var54.getArguments());
                  ConfiguredExecutableObject var51 = new ConfiguredExecutableObject(var54, var55);
                  var40 = var51;
               }
            }

            if (var40 != null) {
               ConfiguredExecutableObject var56 = var40;
               boolean var31 = false;
               var37.add(var56);
            }
         }

         List var32 = (List)var37;
         return new CrateAnimationActions((Collection)CollectionsKt.toMutableList((Collection)var3), (Collection)CollectionsKt.toMutableList((Collection)var32));
      }
   }
}
