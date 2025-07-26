package gg.aquatic.aquaticcrates.api.animation.crate;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.registry.WavesRegistry;
import gg.aquatic.waves.registry.serializer.ActionSerializer;
import gg.aquatic.waves.util.ConfigExtKt;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.generic.ConfiguredExecutableObject;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0004J\u001e\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0004J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0004J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0004J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0004J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0004J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0004J\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0004¨\u0006\u0015"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/animation/crate/AnimationSettingsFactory;", "", "<init>", "()V", "serialize", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationSettings;", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "loadFinalActions", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "loadAnimationTasks", "Ljava/util/TreeMap;", "", "loadAnimationLength", "loadPreAnimationDelay", "loadPostAnimationDelay", "loadSkippable", "", "loadIsPersonal", "loadPreAnimationTasks", "loadPostAnimationTasks", "api"}
)
@SourceDebugExtension({"SMAP\nAnimationSettingsFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimationSettingsFactory.kt\ngg/aquatic/aquaticcrates/api/animation/crate/AnimationSettingsFactory\n+ 2 ActionSerializer.kt\ngg/aquatic/waves/registry/serializer/ActionSerializer\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ActionRegistry.kt\ngg/aquatic/waves/registry/ActionRegistryKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n24#2:75\n14#2,2:86\n17#2,4:92\n24#2:99\n14#2,2:110\n17#2,4:116\n24#2:123\n14#2,2:134\n17#2,4:140\n24#2:147\n14#2,2:158\n17#2,4:164\n1611#3,9:76\n1863#3:85\n1864#3:97\n1620#3:98\n1611#3,9:100\n1863#3:109\n1864#3:121\n1620#3:122\n1611#3,9:124\n1863#3:133\n1864#3:145\n1620#3:146\n1611#3,9:148\n1863#3:157\n1864#3:169\n1620#3:170\n12#4,4:88\n12#4,4:112\n12#4,4:136\n12#4,4:160\n1#5:96\n1#5:120\n1#5:144\n1#5:168\n*S KotlinDebug\n*F\n+ 1 AnimationSettingsFactory.kt\ngg/aquatic/aquaticcrates/api/animation/crate/AnimationSettingsFactory\n*L\n16#1:75\n16#1:86,2\n16#1:92,4\n18#1:99\n18#1:110,2\n18#1:116,4\n33#1:123\n33#1:134,2\n33#1:140,4\n35#1:147\n35#1:158,2\n35#1:164,4\n16#1:76,9\n16#1:85\n16#1:97\n16#1:98\n18#1:100,9\n18#1:109\n18#1:121\n18#1:122\n33#1:124,9\n33#1:133\n33#1:145\n33#1:146\n35#1:148,9\n35#1:157\n35#1:169\n35#1:170\n16#1:88,4\n18#1:112,4\n33#1:136,4\n35#1:160,4\n16#1:96\n18#1:120\n33#1:144\n35#1:168\n*E\n"})
public abstract class AnimationSettingsFactory {
   @Nullable
   public abstract CrateAnimationSettings serialize(@Nullable ConfigurationSection var1);

   @NotNull
   protected final CrateAnimationActions loadFinalActions(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      ActionSerializer var3 = ActionSerializer.INSTANCE;
      List var4 = ConfigExtKt.getSectionList(var1, "final-tasks");
      boolean var5 = false;
      Iterable var6 = (Iterable)var4;
      boolean var7 = false;
      Collection var9 = (Collection)(new ArrayList());
      boolean var10 = false;
      boolean var12 = false;
      Iterator var13 = var6.iterator();

      String var10000;
      ExecutableObject var26;
      ConfiguredExecutableObject var39;
      Map var40;
      ExecutableObject var41;
      while(var13.hasNext()) {
         Object var14 = var13.next();
         boolean var16 = false;
         ConfigurationSection var17 = (ConfigurationSection)var14;
         boolean var18 = false;
         ActionSerializer var19 = ActionSerializer.INSTANCE;
         boolean var20 = false;
         var10000 = var17.getString("type");
         if (var10000 == null) {
            var39 = null;
         } else {
            String var21 = var10000;
            WavesRegistry var22 = WavesRegistry.INSTANCE;
            boolean var23 = false;
            var40 = (Map)var22.getACTION().get(Animation.class);
            if (var40 == null) {
               var41 = null;
            } else {
               Map var24 = var40;
               var41 = (ExecutableObject)var24.get(var21);
               if (var41 == null) {
                  var41 = null;
               } else {
                  ExecutableObject var25 = var41;
                  var41 = var25 instanceof ExecutableObject ? var25 : null;
               }
            }

            if (var41 == null) {
               var39 = null;
            } else {
               var26 = var41;
               ObjectArguments var27 = AquaticObjectArgument.Companion.loadRequirementArguments(var17, var26.getArguments());
               ConfiguredExecutableObject var47 = new ConfiguredExecutableObject(var26, var27);
               var39 = var47;
            }
         }

         if (var39 != null) {
            ConfiguredExecutableObject var28 = var39;
            boolean var29 = false;
            var9.add(var28);
         }
      }

      List var2 = CollectionsKt.toMutableList((Collection)((List)var9));
      ActionSerializer var32 = ActionSerializer.INSTANCE;
      List var33 = ConfigExtKt.getSectionList(var1, "final-tasks");
      boolean var34 = false;
      Iterable var35 = (Iterable)var33;
      boolean var8 = false;
      Collection var36 = (Collection)(new ArrayList());
      boolean var11 = false;
      boolean var37 = false;
      Iterator var38 = var35.iterator();

      while(var38.hasNext()) {
         Object var15 = var38.next();
         boolean var42 = false;
         ConfigurationSection var43 = (ConfigurationSection)var15;
         boolean var44 = false;
         ActionSerializer var45 = ActionSerializer.INSTANCE;
         boolean var46 = false;
         var10000 = var43.getString("type");
         if (var10000 == null) {
            var39 = null;
         } else {
            String var48 = var10000;
            WavesRegistry var49 = WavesRegistry.INSTANCE;
            boolean var51 = false;
            var40 = (Map)var49.getACTION().get(PlayerBoundAnimation.class);
            if (var40 == null) {
               var41 = null;
            } else {
               Map var52 = var40;
               var41 = (ExecutableObject)var52.get(var48);
               if (var41 == null) {
                  var41 = null;
               } else {
                  var26 = var41;
                  var41 = var26 instanceof ExecutableObject ? var26 : null;
               }
            }

            if (var41 == null) {
               var39 = null;
            } else {
               ExecutableObject var53 = var41;
               ObjectArguments var54 = AquaticObjectArgument.Companion.loadRequirementArguments(var43, var53.getArguments());
               ConfiguredExecutableObject var50 = new ConfiguredExecutableObject(var53, var54);
               var39 = var50;
            }
         }

         if (var39 != null) {
            ConfiguredExecutableObject var55 = var39;
            boolean var30 = false;
            var36.add(var55);
         }
      }

      List var31 = CollectionsKt.toMutableList((Collection)((List)var36));
      return new CrateAnimationActions((Collection)var2, (Collection)var31);
   }

   @NotNull
   protected final TreeMap<Integer, CrateAnimationActions> loadAnimationTasks(@Nullable ConfigurationSection var1) {
      TreeMap var2 = new TreeMap();
      if (var1 == null) {
         return var2;
      } else {
         Iterator var3 = var1.getKeys(false).iterator();

         while(true) {
            String var4;
            Integer var10000;
            do {
               if (!var3.hasNext()) {
                  return var2;
               }

               var4 = (String)var3.next();
               Intrinsics.checkNotNull(var4);
               var10000 = StringsKt.toIntOrNull(var4);
            } while(var10000 == null);

            int var5 = var10000;
            ActionSerializer var7 = ActionSerializer.INSTANCE;
            List var8 = ConfigExtKt.getSectionList(var1, var4);
            boolean var9 = false;
            Iterable var10 = (Iterable)var8;
            boolean var11 = false;
            Collection var13 = (Collection)(new ArrayList());
            boolean var14 = false;
            boolean var16 = false;
            Iterator var17 = var10.iterator();

            ExecutableObject var30;
            String var42;
            ConfiguredExecutableObject var43;
            Map var44;
            ExecutableObject var46;
            while(var17.hasNext()) {
               Object var18 = var17.next();
               boolean var20 = false;
               ConfigurationSection var21 = (ConfigurationSection)var18;
               boolean var22 = false;
               ActionSerializer var23 = ActionSerializer.INSTANCE;
               boolean var24 = false;
               var42 = var21.getString("type");
               if (var42 == null) {
                  var43 = null;
               } else {
                  String var25 = var42;
                  WavesRegistry var26 = WavesRegistry.INSTANCE;
                  boolean var27 = false;
                  var44 = (Map)var26.getACTION().get(Animation.class);
                  if (var44 == null) {
                     var46 = null;
                  } else {
                     Map var28 = var44;
                     var46 = (ExecutableObject)var28.get(var25);
                     if (var46 == null) {
                        var46 = null;
                     } else {
                        ExecutableObject var29 = var46;
                        var46 = var29 instanceof ExecutableObject ? var29 : null;
                     }
                  }

                  if (var46 == null) {
                     var43 = null;
                  } else {
                     var30 = var46;
                     ObjectArguments var31 = AquaticObjectArgument.Companion.loadRequirementArguments(var21, var30.getArguments());
                     ConfiguredExecutableObject var53 = new ConfiguredExecutableObject(var30, var31);
                     var43 = var53;
                  }
               }

               if (var43 != null) {
                  ConfiguredExecutableObject var32 = var43;
                  boolean var33 = false;
                  var13.add(var32);
               }
            }

            List var6 = CollectionsKt.toMutableList((Collection)((List)var13));
            ActionSerializer var36 = ActionSerializer.INSTANCE;
            List var37 = ConfigExtKt.getSectionList(var1, var4);
            boolean var39 = false;
            Iterable var40 = (Iterable)var37;
            boolean var12 = false;
            Collection var41 = (Collection)(new ArrayList());
            boolean var15 = false;
            boolean var45 = false;
            Iterator var47 = var40.iterator();

            while(var47.hasNext()) {
               Object var19 = var47.next();
               boolean var48 = false;
               ConfigurationSection var49 = (ConfigurationSection)var19;
               boolean var50 = false;
               ActionSerializer var51 = ActionSerializer.INSTANCE;
               boolean var52 = false;
               var42 = var49.getString("type");
               if (var42 == null) {
                  var43 = null;
               } else {
                  String var54 = var42;
                  WavesRegistry var55 = WavesRegistry.INSTANCE;
                  boolean var57 = false;
                  var44 = (Map)var55.getACTION().get(PlayerBoundAnimation.class);
                  if (var44 == null) {
                     var46 = null;
                  } else {
                     Map var58 = var44;
                     var46 = (ExecutableObject)var58.get(var54);
                     if (var46 == null) {
                        var46 = null;
                     } else {
                        var30 = var46;
                        var46 = var30 instanceof ExecutableObject ? var30 : null;
                     }
                  }

                  if (var46 == null) {
                     var43 = null;
                  } else {
                     ExecutableObject var59 = var46;
                     ObjectArguments var60 = AquaticObjectArgument.Companion.loadRequirementArguments(var49, var59.getArguments());
                     ConfiguredExecutableObject var56 = new ConfiguredExecutableObject(var59, var60);
                     var43 = var56;
                  }
               }

               if (var43 != null) {
                  ConfiguredExecutableObject var61 = var43;
                  boolean var34 = false;
                  var41.add(var61);
               }
            }

            List var35 = CollectionsKt.toMutableList((Collection)((List)var41));
            Integer var38 = var5;
            ((Map)var2).put(var38, new CrateAnimationActions((Collection)var6, (Collection)var35));
         }
      }
   }

   protected final int loadAnimationLength(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      return var1.getInt("length", 0);
   }

   protected final int loadPreAnimationDelay(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      return var1.getInt("pre-animation.delay", 0);
   }

   protected final int loadPostAnimationDelay(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      return var1.getInt("post-animation.delay", 0);
   }

   protected final boolean loadSkippable(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      return var1.getBoolean("skippable", false);
   }

   protected final boolean loadIsPersonal(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      return var1.getBoolean("personal", false);
   }

   @NotNull
   protected final TreeMap<Integer, CrateAnimationActions> loadPreAnimationTasks(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      return this.loadAnimationTasks(var1.getConfigurationSection("pre-animation.tasks"));
   }

   @NotNull
   protected final TreeMap<Integer, CrateAnimationActions> loadPostAnimationTasks(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      return this.loadAnimationTasks(var1.getConfigurationSection("post-animation.tasks"));
   }
}
