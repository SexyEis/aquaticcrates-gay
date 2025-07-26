package gg.aquatic.aquaticcrates.api.util;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.registry.WavesRegistry;
import gg.aquatic.waves.registry.serializer.ActionSerializer;
import gg.aquatic.waves.registry.serializer.RequirementSerializer;
import gg.aquatic.waves.util.ConfigExtKt;
import gg.aquatic.waves.util.argument.AbstractObjectArgumentSerializer;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.generic.ConfiguredExecutableObject;
import gg.aquatic.waves.util.generic.ExecutableObject;
import gg.aquatic.waves.util.requirement.ConfiguredRequirement;
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
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0011\u0012B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/util/ConditionalActionsArgument;", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "Lgg/aquatic/aquaticcrates/api/util/ConditionalActionsArgument$ConditionalAnimationActions;", "id", "", "defaultValue", "required", "", "<init>", "(Ljava/lang/String;Lgg/aquatic/aquaticcrates/api/util/ConditionalActionsArgument$ConditionalAnimationActions;Z)V", "serializer", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "getSerializer", "()Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "Serializer", "ConditionalAnimationActions", "api"}
)
public final class ConditionalActionsArgument extends AquaticObjectArgument<ConditionalActionsArgument.ConditionalAnimationActions> {
   public ConditionalActionsArgument(@NotNull String var1, @Nullable ConditionalActionsArgument.ConditionalAnimationActions var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "id");
      super(var1, var2, var3);
   }

   @NotNull
   public AbstractObjectArgumentSerializer<ConditionalActionsArgument.ConditionalAnimationActions> getSerializer() {
      return (AbstractObjectArgumentSerializer)ConditionalActionsArgument.Serializer.INSTANCE;
   }

   @NotNull
   public ConditionalActionsArgument.ConditionalAnimationActions load(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      return ConditionalActionsArgument.Serializer.INSTANCE.load(var1, "");
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0016"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/util/ConditionalActionsArgument$ConditionalAnimationActions;", "", "actions", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "conditions", "", "Lgg/aquatic/waves/util/requirement/ConfiguredRequirement;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "playerBoundConditions", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "failActions", "<init>", "(Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;Ljava/util/List;Ljava/util/List;Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;)V", "getActions", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "getConditions", "()Ljava/util/List;", "getPlayerBoundConditions", "getFailActions", "tryExecute", "", "animation", "api"}
   )
   @SourceDebugExtension({"SMAP\nConditionalActionsArgument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConditionalActionsArgument.kt\ngg/aquatic/aquaticcrates/api/util/ConditionalActionsArgument$ConditionalAnimationActions\n+ 2 CollectionExt.kt\ngg/aquatic/waves/util/collection/CollectionExtKt\n*L\n1#1,77:1\n15#2,4:78\n15#2,4:82\n*S KotlinDebug\n*F\n+ 1 ConditionalActionsArgument.kt\ngg/aquatic/aquaticcrates/api/util/ConditionalActionsArgument$ConditionalAnimationActions\n*L\n65#1:78,4\n67#1:82,4\n*E\n"})
   public static final class ConditionalAnimationActions {
      @NotNull
      private final CrateAnimationActions actions;
      @NotNull
      private final List<ConfiguredRequirement<Animation>> conditions;
      @NotNull
      private final List<ConfiguredRequirement<PlayerBoundAnimation>> playerBoundConditions;
      @NotNull
      private final CrateAnimationActions failActions;

      public ConditionalAnimationActions(@NotNull CrateAnimationActions var1, @NotNull List<ConfiguredRequirement<Animation>> var2, @NotNull List<ConfiguredRequirement<PlayerBoundAnimation>> var3, @NotNull CrateAnimationActions var4) {
         Intrinsics.checkNotNullParameter(var1, "actions");
         Intrinsics.checkNotNullParameter(var2, "conditions");
         Intrinsics.checkNotNullParameter(var3, "playerBoundConditions");
         Intrinsics.checkNotNullParameter(var4, "failActions");
         super();
         this.actions = var1;
         this.conditions = var2;
         this.playerBoundConditions = var3;
         this.failActions = var4;
      }

      @NotNull
      public final CrateAnimationActions getActions() {
         return this.actions;
      }

      @NotNull
      public final List<ConfiguredRequirement<Animation>> getConditions() {
         return this.conditions;
      }

      @NotNull
      public final List<ConfiguredRequirement<PlayerBoundAnimation>> getPlayerBoundConditions() {
         return this.playerBoundConditions;
      }

      @NotNull
      public final CrateAnimationActions getFailActions() {
         return this.failActions;
      }

      public final void tryExecute(@NotNull Animation var1) {
         Intrinsics.checkNotNullParameter(var1, "animation");
         boolean var2 = true;
         boolean var10000;
         Collection var3;
         if (var1 instanceof PlayerBoundAnimation) {
            var3 = (Collection)this.playerBoundConditions;
            Animation var4 = var1;
            boolean var5 = false;
            Iterator var6 = var3.iterator();

            while(true) {
               if (!var6.hasNext()) {
                  var10000 = true;
                  break;
               }

               ConfiguredRequirement var7 = (ConfiguredRequirement)var6.next();
               if (!var7.execute(var4, (Function2)ConditionalActionsArgument$ConditionalAnimationActions$tryExecute$$inlined$checkRequirements$1.INSTANCE)) {
                  var10000 = false;
                  break;
               }
            }

            if (!var10000) {
               var2 = false;
            }
         }

         if (var2) {
            var3 = (Collection)this.conditions;
            boolean var8 = false;
            Iterator var9 = var3.iterator();

            while(true) {
               if (!var9.hasNext()) {
                  var10000 = true;
                  break;
               }

               ConfiguredRequirement var10 = (ConfiguredRequirement)var9.next();
               if (!var10.execute(var1, (Function2)ConditionalActionsArgument$ConditionalAnimationActions$tryExecute$$inlined$checkRequirements$2.INSTANCE)) {
                  var10000 = false;
                  break;
               }
            }

            if (!var10000) {
               var2 = false;
            }
         }

         if (var2) {
            this.actions.execute(var1);
         } else {
            this.failActions.execute(var1);
         }

      }
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/util/ConditionalActionsArgument$Serializer;", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "Lgg/aquatic/aquaticcrates/api/util/ConditionalActionsArgument$ConditionalAnimationActions;", "<init>", "()V", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "id", "", "api"}
   )
   @SourceDebugExtension({"SMAP\nConditionalActionsArgument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConditionalActionsArgument.kt\ngg/aquatic/aquaticcrates/api/util/ConditionalActionsArgument$Serializer\n+ 2 ActionSerializer.kt\ngg/aquatic/waves/registry/serializer/ActionSerializer\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ActionRegistry.kt\ngg/aquatic/waves/registry/ActionRegistryKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 RequirementSerializer.kt\ngg/aquatic/waves/registry/serializer/RequirementSerializer\n+ 7 RequirementRegistry.kt\ngg/aquatic/waves/registry/RequirementRegistryKt\n*L\n1#1,77:1\n24#2:78\n14#2,2:89\n17#2,4:95\n24#2:102\n14#2,2:113\n17#2,4:119\n24#2:180\n14#2,2:191\n17#2,4:197\n24#2:204\n14#2,2:215\n17#2,4:221\n1611#3,9:79\n1863#3:88\n1864#3:100\n1620#3:101\n1611#3,9:103\n1863#3:112\n1864#3:124\n1620#3:125\n1611#3,9:127\n1863#3:136\n1864#3:151\n1620#3:152\n1611#3,9:154\n1863#3:163\n1864#3:178\n1620#3:179\n1611#3,9:181\n1863#3:190\n1864#3:202\n1620#3:203\n1611#3,9:205\n1863#3:214\n1864#3:226\n1620#3:227\n12#4,4:91\n12#4,4:115\n12#4,4:193\n12#4,4:217\n1#5:99\n1#5:123\n1#5:150\n1#5:177\n1#5:201\n1#5:225\n26#6:126\n12#6,2:137\n14#6,9:141\n26#6:153\n12#6,2:164\n14#6,9:168\n12#7,2:139\n12#7,2:166\n*S KotlinDebug\n*F\n+ 1 ConditionalActionsArgument.kt\ngg/aquatic/aquaticcrates/api/util/ConditionalActionsArgument$Serializer\n*L\n34#1:78\n34#1:89,2\n34#1:95,4\n36#1:102\n36#1:113,2\n36#1:119,4\n42#1:180\n42#1:191,2\n42#1:197,4\n44#1:204\n44#1:215,2\n44#1:221,4\n34#1:79,9\n34#1:88\n34#1:100\n34#1:101\n36#1:103,9\n36#1:112\n36#1:124\n36#1:125\n38#1:127,9\n38#1:136\n38#1:151\n38#1:152\n40#1:154,9\n40#1:163\n40#1:178\n40#1:179\n42#1:181,9\n42#1:190\n42#1:202\n42#1:203\n44#1:205,9\n44#1:214\n44#1:226\n44#1:227\n34#1:91,4\n36#1:115,4\n42#1:193,4\n44#1:217,4\n34#1:99\n36#1:123\n38#1:150\n40#1:177\n42#1:201\n44#1:225\n38#1:126\n38#1:137,2\n38#1:141,9\n40#1:153\n40#1:164,2\n40#1:168,9\n38#1:139,2\n40#1:166,2\n*E\n"})
   public static final class Serializer extends AbstractObjectArgumentSerializer<ConditionalActionsArgument.ConditionalAnimationActions> {
      @NotNull
      public static final ConditionalActionsArgument.Serializer INSTANCE = new ConditionalActionsArgument.Serializer();

      private Serializer() {
      }

      @NotNull
      public ConditionalActionsArgument.ConditionalAnimationActions load(@NotNull ConfigurationSection var1, @NotNull String var2) {
         Intrinsics.checkNotNullParameter(var1, "section");
         Intrinsics.checkNotNullParameter(var2, "id");
         ActionSerializer var4 = ActionSerializer.INSTANCE;
         List var5 = ConfigExtKt.getSectionList(var1, "actions");
         boolean var6 = false;
         Iterable var7 = (Iterable)var5;
         boolean var8 = false;
         Collection var10 = (Collection)(new ArrayList());
         boolean var11 = false;
         boolean var13 = false;
         Iterator var14 = var7.iterator();

         String var10000;
         boolean var17;
         boolean var19;
         boolean var21;
         boolean var24;
         ExecutableObject var27;
         ConfiguredExecutableObject var125;
         Map var126;
         ExecutableObject var127;
         while(var14.hasNext()) {
            Object var15 = var14.next();
            var17 = false;
            ConfigurationSection var18 = (ConfigurationSection)var15;
            var19 = false;
            ActionSerializer var20 = ActionSerializer.INSTANCE;
            var21 = false;
            var10000 = var18.getString("type");
            if (var10000 == null) {
               var125 = null;
            } else {
               String var22 = var10000;
               WavesRegistry var23 = WavesRegistry.INSTANCE;
               var24 = false;
               var126 = (Map)var23.getACTION().get(Animation.class);
               if (var126 == null) {
                  var127 = null;
               } else {
                  Map var25 = var126;
                  var127 = (ExecutableObject)var25.get(var22);
                  if (var127 == null) {
                     var127 = null;
                  } else {
                     ExecutableObject var26 = var127;
                     var127 = var26 instanceof ExecutableObject ? var26 : null;
                  }
               }

               if (var127 == null) {
                  var125 = null;
               } else {
                  var27 = var127;
                  ObjectArguments var28 = AquaticObjectArgument.Companion.loadRequirementArguments(var18, var27.getArguments());
                  ConfiguredExecutableObject var79 = new ConfiguredExecutableObject(var27, var28);
                  var125 = var79;
               }
            }

            if (var125 != null) {
               ConfiguredExecutableObject var29 = var125;
               boolean var30 = false;
               var10.add(var29);
            }
         }

         List var3 = (List)var10;
         ActionSerializer var37 = ActionSerializer.INSTANCE;
         List var38 = ConfigExtKt.getSectionList(var1, "actions");
         boolean var40 = false;
         Iterable var43 = (Iterable)var38;
         boolean var9 = false;
         Collection var51 = (Collection)(new ArrayList());
         boolean var12 = false;
         boolean var57 = false;
         Iterator var59 = var43.iterator();

         boolean var31;
         boolean var66;
         boolean var71;
         boolean var77;
         boolean var88;
         ExecutableObject var102;
         while(var59.hasNext()) {
            Object var16 = var59.next();
            var66 = false;
            ConfigurationSection var69 = (ConfigurationSection)var16;
            var71 = false;
            ActionSerializer var74 = ActionSerializer.INSTANCE;
            var77 = false;
            var10000 = var69.getString("type");
            if (var10000 == null) {
               var125 = null;
            } else {
               String var81 = var10000;
               WavesRegistry var83 = WavesRegistry.INSTANCE;
               var88 = false;
               var126 = (Map)var83.getACTION().get(PlayerBoundAnimation.class);
               if (var126 == null) {
                  var127 = null;
               } else {
                  Map var92 = var126;
                  var127 = (ExecutableObject)var92.get(var81);
                  if (var127 == null) {
                     var127 = null;
                  } else {
                     var27 = var127;
                     var127 = var27 instanceof ExecutableObject ? var27 : null;
                  }
               }

               if (var127 == null) {
                  var125 = null;
               } else {
                  var102 = var127;
                  ObjectArguments var107 = AquaticObjectArgument.Companion.loadRequirementArguments(var69, var102.getArguments());
                  ConfiguredExecutableObject var85 = new ConfiguredExecutableObject(var102, var107);
                  var125 = var85;
               }
            }

            if (var125 != null) {
               ConfiguredExecutableObject var113 = var125;
               var31 = false;
               var51.add(var113);
            }
         }

         List var36 = (List)var51;
         RequirementSerializer var39 = RequirementSerializer.INSTANCE;
         List var41 = ConfigExtKt.getSectionList(var1, "conditions");
         var8 = false;
         Iterable var45 = (Iterable)var41;
         boolean var48 = false;
         Collection var54 = (Collection)(new ArrayList());
         var13 = false;
         boolean var60 = false;
         Iterator var61 = var45.iterator();

         boolean var82;
         boolean var94;
         ExecutableObject var110;
         ConfiguredRequirement var128;
         while(var61.hasNext()) {
            Object var64 = var61.next();
            var19 = false;
            ConfigurationSection var73 = (ConfigurationSection)var64;
            var21 = false;
            RequirementSerializer var78 = RequirementSerializer.INSTANCE;
            var82 = false;
            var10000 = var73.getString("type");
            if (var10000 == null) {
               var128 = null;
            } else {
               String var86 = var10000;
               WavesRegistry var89 = WavesRegistry.INSTANCE;
               var94 = false;
               var126 = (Map)var89.getREQUIREMENT().get(Animation.class);
               if (var126 == null) {
                  var127 = null;
               } else {
                  Map var98 = var126;
                  var127 = (ExecutableObject)var98.get(var86);
                  if (var127 == null) {
                     var127 = null;
                  } else {
                     var102 = var127;
                     var127 = var102 instanceof ExecutableObject ? var102 : null;
                  }
               }

               var110 = var127;
               if (var110 == null) {
                  System.out.println("[Waves] Action type " + var86 + " does not exist!");
                  var128 = null;
               } else {
                  ObjectArguments var91 = AquaticObjectArgument.Companion.loadRequirementArguments(var73, var110.getArguments());
                  ConfiguredRequirement var95 = new ConfiguredRequirement(var110, var91);
                  var128 = var95;
               }
            }

            if (var128 != null) {
               ConfiguredRequirement var115 = var128;
               var31 = false;
               var54.add(var115);
            }
         }

         var5 = (List)var54;
         RequirementSerializer var42 = RequirementSerializer.INSTANCE;
         List var44 = ConfigExtKt.getSectionList(var1, "conditions");
         var9 = false;
         Iterable var50 = (Iterable)var44;
         var11 = false;
         Collection var56 = (Collection)(new ArrayList());
         var57 = false;
         boolean var63 = false;
         Iterator var65 = var50.iterator();

         ExecutableObject var117;
         while(var65.hasNext()) {
            Object var67 = var65.next();
            var71 = false;
            ConfigurationSection var76 = (ConfigurationSection)var67;
            var77 = false;
            RequirementSerializer var84 = RequirementSerializer.INSTANCE;
            var24 = false;
            var10000 = var76.getString("type");
            if (var10000 == null) {
               var128 = null;
            } else {
               String var93 = var10000;
               WavesRegistry var97 = WavesRegistry.INSTANCE;
               boolean var100 = false;
               var126 = (Map)var97.getREQUIREMENT().get(PlayerBoundAnimation.class);
               if (var126 == null) {
                  var127 = null;
               } else {
                  Map var105 = var126;
                  var127 = (ExecutableObject)var105.get(var93);
                  if (var127 == null) {
                     var127 = null;
                  } else {
                     var110 = var127;
                     var127 = var110 instanceof ExecutableObject ? var110 : null;
                  }
               }

               var117 = var127;
               if (var117 == null) {
                  System.out.println("[Waves] Action type " + var93 + " does not exist!");
                  var128 = null;
               } else {
                  ObjectArguments var99 = AquaticObjectArgument.Companion.loadRequirementArguments(var76, var117.getArguments());
                  ConfiguredRequirement var103 = new ConfiguredRequirement(var117, var99);
                  var128 = var103;
               }
            }

            if (var128 != null) {
               ConfiguredRequirement var118 = var128;
               boolean var32 = false;
               var56.add(var118);
            }
         }

         var38 = (List)var56;
         ActionSerializer var46 = ActionSerializer.INSTANCE;
         List var47 = ConfigExtKt.getSectionList(var1, "fail");
         var48 = false;
         Iterable var53 = (Iterable)var47;
         var12 = false;
         Collection var58 = (Collection)(new ArrayList());
         var60 = false;
         var17 = false;
         Iterator var68 = var53.iterator();

         ExecutableObject var120;
         while(var68.hasNext()) {
            Object var70 = var68.next();
            var21 = false;
            ConfigurationSection var80 = (ConfigurationSection)var70;
            var82 = false;
            ActionSerializer var90 = ActionSerializer.INSTANCE;
            var88 = false;
            var10000 = var80.getString("type");
            if (var10000 == null) {
               var125 = null;
            } else {
               String var101 = var10000;
               WavesRegistry var104 = WavesRegistry.INSTANCE;
               boolean var108 = false;
               var126 = (Map)var104.getACTION().get(Animation.class);
               if (var126 == null) {
                  var127 = null;
               } else {
                  Map var114 = var126;
                  var127 = (ExecutableObject)var114.get(var101);
                  if (var127 == null) {
                     var127 = null;
                  } else {
                     var117 = var127;
                     var127 = var117 instanceof ExecutableObject ? var117 : null;
                  }
               }

               if (var127 == null) {
                  var125 = null;
               } else {
                  var120 = var127;
                  ObjectArguments var121 = AquaticObjectArgument.Companion.loadRequirementArguments(var80, var120.getArguments());
                  ConfiguredExecutableObject var106 = new ConfiguredExecutableObject(var120, var121);
                  var125 = var106;
               }
            }

            if (var125 != null) {
               ConfiguredExecutableObject var33 = var125;
               boolean var34 = false;
               var58.add(var33);
            }
         }

         var41 = (List)var58;
         ActionSerializer var49 = ActionSerializer.INSTANCE;
         List var52 = ConfigExtKt.getSectionList(var1, "fail");
         var11 = false;
         Iterable var55 = (Iterable)var52;
         var13 = false;
         Collection var62 = (Collection)(new ArrayList());
         var63 = false;
         var66 = false;
         Iterator var72 = var55.iterator();

         while(var72.hasNext()) {
            Object var75 = var72.next();
            var77 = false;
            ConfigurationSection var87 = (ConfigurationSection)var75;
            var24 = false;
            ActionSerializer var96 = ActionSerializer.INSTANCE;
            var94 = false;
            var10000 = var87.getString("type");
            if (var10000 == null) {
               var125 = null;
            } else {
               String var109 = var10000;
               WavesRegistry var111 = WavesRegistry.INSTANCE;
               boolean var116 = false;
               var126 = (Map)var111.getACTION().get(PlayerBoundAnimation.class);
               if (var126 == null) {
                  var127 = null;
               } else {
                  Map var119 = var126;
                  var127 = (ExecutableObject)var119.get(var109);
                  if (var127 == null) {
                     var127 = null;
                  } else {
                     var120 = var127;
                     var127 = var120 instanceof ExecutableObject ? var120 : null;
                  }
               }

               if (var127 == null) {
                  var125 = null;
               } else {
                  ExecutableObject var122 = var127;
                  ObjectArguments var123 = AquaticObjectArgument.Companion.loadRequirementArguments(var87, var122.getArguments());
                  ConfiguredExecutableObject var112 = new ConfiguredExecutableObject(var122, var123);
                  var125 = var112;
               }
            }

            if (var125 != null) {
               ConfiguredExecutableObject var124 = var125;
               boolean var35 = false;
               var62.add(var124);
            }
         }

         var44 = (List)var62;
         return new ConditionalActionsArgument.ConditionalAnimationActions(new CrateAnimationActions((Collection)CollectionsKt.toMutableList((Collection)var3), (Collection)CollectionsKt.toMutableList((Collection)var36)), var5, var38, new CrateAnimationActions((Collection)CollectionsKt.toMutableList((Collection)var41), (Collection)CollectionsKt.toMutableList((Collection)var44)));
      }
   }
}
