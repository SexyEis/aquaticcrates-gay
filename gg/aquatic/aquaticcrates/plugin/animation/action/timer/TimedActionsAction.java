package gg.aquatic.aquaticcrates.plugin.animation.action.timer;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.aquaticcrates.plugin.animation.prop.timer.TimedActionsAnimationProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004:\u0001\u0013B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/timer/TimedActionsAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "TimedActionsArgument", "plugin"}
)
public final class TimedActionsAction implements ExecutableObject<Animation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments = CollectionsKt.listOf(new TimedActionsAction.TimedActionsArgument("actions", new HashMap(), true));

   @NotNull
   public List<AquaticObjectArgument<?>> getArguments() {
      return this.arguments;
   }

   public void execute(@NotNull Animation var1, @NotNull ObjectArguments var2, @NotNull Function2<? super Animation, ? super String, String> var3) {
      Intrinsics.checkNotNullParameter(var1, "binder");
      Intrinsics.checkNotNullParameter(var2, "args");
      Intrinsics.checkNotNullParameter(var3, "textUpdater");
      Object var6 = ObjectArguments.any$default(var2, "actions", (Function1)null, 2, (Object)null);
      HashMap var10000 = var6 instanceof HashMap ? (HashMap)var6 : null;
      if ((var6 instanceof HashMap ? (HashMap)var6 : null) != null) {
         HashMap var4 = var10000;
         TimedActionsAnimationProp var5 = new TimedActionsAnimationProp(var1, var4);
         var1.getProps().put("timed-actions:" + UUID.randomUUID(), var5);
         var5.tick();
      }
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0001\u0013B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R(\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/timer/TimedActionsAction$TimedActionsArgument;", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "Ljava/util/HashMap;", "", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "id", "", "defaultValue", "required", "", "<init>", "(Ljava/lang/String;Ljava/util/HashMap;Z)V", "serializer", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "getSerializer", "()Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "Serializer", "plugin"}
   )
   public static final class TimedActionsArgument extends AquaticObjectArgument<HashMap<Integer, CrateAnimationActions>> {
      public TimedActionsArgument(@NotNull String var1, @Nullable HashMap<Integer, CrateAnimationActions> var2, boolean var3) {
         Intrinsics.checkNotNullParameter(var1, "id");
         super(var1, var2, var3);
      }

      @NotNull
      public AbstractObjectArgumentSerializer<HashMap<Integer, CrateAnimationActions>> getSerializer() {
         return (AbstractObjectArgumentSerializer)TimedActionsAction.TimedActionsArgument.Serializer.INSTANCE;
      }

      @Nullable
      public HashMap<Integer, CrateAnimationActions> load(@NotNull ConfigurationSection var1) {
         Intrinsics.checkNotNullParameter(var1, "section");
         return TimedActionsAction.TimedActionsArgument.Serializer.INSTANCE.load(var1, this.getId());
      }

      @Metadata(
         mv = {2, 1, 0},
         k = 1,
         xi = 48,
         d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"},
         d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/timer/TimedActionsAction$TimedActionsArgument$Serializer;", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "Ljava/util/HashMap;", "", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "<init>", "()V", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "id", "", "plugin"}
      )
      @SourceDebugExtension({"SMAP\nTimedActionsAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimedActionsAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/timer/TimedActionsAction$TimedActionsArgument$Serializer\n+ 2 ActionSerializer.kt\ngg/aquatic/waves/registry/serializer/ActionSerializer\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ActionRegistry.kt\ngg/aquatic/waves/registry/ActionRegistryKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n24#2:62\n14#2,2:73\n17#2,4:79\n24#2:86\n14#2,2:97\n17#2,4:103\n1611#3,9:63\n1863#3:72\n1864#3:84\n1620#3:85\n1611#3,9:87\n1863#3:96\n1864#3:108\n1620#3:109\n12#4,4:75\n12#4,4:99\n1#5:83\n1#5:107\n*S KotlinDebug\n*F\n+ 1 TimedActionsAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/timer/TimedActionsAction$TimedActionsArgument$Serializer\n*L\n49#1:62\n49#1:73,2\n49#1:79,4\n50#1:86\n50#1:97,2\n50#1:103,4\n49#1:63,9\n49#1:72\n49#1:84\n49#1:85\n50#1:87,9\n50#1:96\n50#1:108\n50#1:109\n49#1:75,4\n50#1:99,4\n49#1:83\n50#1:107\n*E\n"})
      public static final class Serializer extends AbstractObjectArgumentSerializer<HashMap<Integer, CrateAnimationActions>> {
         @NotNull
         public static final TimedActionsAction.TimedActionsArgument.Serializer INSTANCE = new TimedActionsAction.TimedActionsArgument.Serializer();

         private Serializer() {
         }

         @NotNull
         public HashMap<Integer, CrateAnimationActions> load(@NotNull ConfigurationSection var1, @NotNull String var2) {
            Intrinsics.checkNotNullParameter(var1, "section");
            Intrinsics.checkNotNullParameter(var2, "id");
            HashMap var3 = new HashMap();
            ConfigurationSection var10000 = var1.getConfigurationSection(var2);
            if (var10000 == null) {
               return var3;
            } else {
               ConfigurationSection var4 = var10000;
               Iterator var5 = var4.getKeys(false).iterator();

               while(var5.hasNext()) {
                  String var6 = (String)var5.next();
                  Intrinsics.checkNotNull(var6);
                  List var7 = ConfigExtKt.getSectionList(var4, var6);
                  ActionSerializer var9 = ActionSerializer.INSTANCE;
                  boolean var10 = false;
                  Iterable var11 = (Iterable)var7;
                  boolean var12 = false;
                  Collection var14 = (Collection)(new ArrayList());
                  boolean var15 = false;
                  boolean var17 = false;
                  Iterator var18 = var11.iterator();

                  ExecutableObject var31;
                  String var41;
                  ConfiguredExecutableObject var42;
                  Map var43;
                  ExecutableObject var44;
                  while(var18.hasNext()) {
                     Object var19 = var18.next();
                     boolean var21 = false;
                     ConfigurationSection var22 = (ConfigurationSection)var19;
                     boolean var23 = false;
                     ActionSerializer var24 = ActionSerializer.INSTANCE;
                     boolean var25 = false;
                     var41 = var22.getString("type");
                     if (var41 == null) {
                        var42 = null;
                     } else {
                        String var26 = var41;
                        WavesRegistry var27 = WavesRegistry.INSTANCE;
                        boolean var28 = false;
                        var43 = (Map)var27.getACTION().get(Animation.class);
                        if (var43 == null) {
                           var44 = null;
                        } else {
                           Map var29 = var43;
                           var44 = (ExecutableObject)var29.get(var26);
                           if (var44 == null) {
                              var44 = null;
                           } else {
                              ExecutableObject var30 = var44;
                              var44 = var30 instanceof ExecutableObject ? var30 : null;
                           }
                        }

                        if (var44 == null) {
                           var42 = null;
                        } else {
                           var31 = var44;
                           ObjectArguments var32 = AquaticObjectArgument.Companion.loadRequirementArguments(var22, var31.getArguments());
                           ConfiguredExecutableObject var52 = new ConfiguredExecutableObject(var31, var32);
                           var42 = var52;
                        }
                     }

                     if (var42 != null) {
                        ConfiguredExecutableObject var33 = var42;
                        boolean var34 = false;
                        var14.add(var33);
                     }
                  }

                  List var8 = (List)var14;
                  ActionSerializer var37 = ActionSerializer.INSTANCE;
                  boolean var38 = false;
                  Iterable var39 = (Iterable)var7;
                  boolean var13 = false;
                  Collection var40 = (Collection)(new ArrayList());
                  boolean var16 = false;
                  boolean var45 = false;
                  Iterator var46 = var39.iterator();

                  while(var46.hasNext()) {
                     Object var20 = var46.next();
                     boolean var47 = false;
                     ConfigurationSection var48 = (ConfigurationSection)var20;
                     boolean var49 = false;
                     ActionSerializer var50 = ActionSerializer.INSTANCE;
                     boolean var51 = false;
                     var41 = var48.getString("type");
                     if (var41 == null) {
                        var42 = null;
                     } else {
                        String var53 = var41;
                        WavesRegistry var54 = WavesRegistry.INSTANCE;
                        boolean var56 = false;
                        var43 = (Map)var54.getACTION().get(PlayerBoundAnimation.class);
                        if (var43 == null) {
                           var44 = null;
                        } else {
                           Map var57 = var43;
                           var44 = (ExecutableObject)var57.get(var53);
                           if (var44 == null) {
                              var44 = null;
                           } else {
                              var31 = var44;
                              var44 = var31 instanceof ExecutableObject ? var31 : null;
                           }
                        }

                        if (var44 == null) {
                           var42 = null;
                        } else {
                           ExecutableObject var58 = var44;
                           ObjectArguments var59 = AquaticObjectArgument.Companion.loadRequirementArguments(var48, var58.getArguments());
                           ConfiguredExecutableObject var55 = new ConfiguredExecutableObject(var58, var59);
                           var42 = var55;
                        }
                     }

                     if (var42 != null) {
                        ConfiguredExecutableObject var60 = var42;
                        boolean var35 = false;
                        var40.add(var60);
                     }
                  }

                  List var36 = (List)var40;
                  ((Map)var3).put(Integer.parseInt(var6), new CrateAnimationActions((Collection)CollectionsKt.toMutableList((Collection)var8), (Collection)CollectionsKt.toMutableList((Collection)var36)));
               }

               return var3;
            }
         }
      }
   }
}
