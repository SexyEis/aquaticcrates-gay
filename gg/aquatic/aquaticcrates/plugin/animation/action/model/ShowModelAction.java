package gg.aquatic.aquaticcrates.plugin.animation.action.model;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.BoundPathObjectArgument;
import gg.aquatic.aquaticcrates.plugin.animation.prop.model.ModelAnimationProp;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathBoundProperties;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.collections.MapsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.jvm.internal.TypeIntrinsics;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.argument.impl.PrimitiveObjectArgument;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/model/ShowModelAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nShowModelAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShowModelAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/model/ShowModelAction\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,72:1\n463#2:73\n413#2:74\n1252#3,4:75\n*S KotlinDebug\n*F\n+ 1 ShowModelAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/model/ShowModelAction\n*L\n59#1:73\n59#1:74\n59#1:75,4\n*E\n"})
public final class ShowModelAction implements ExecutableObject<Animation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public ShowModelAction() {
      AquaticObjectArgument[] var1 = new AquaticObjectArgument[]{new PrimitiveObjectArgument("id", "example", true), new PrimitiveObjectArgument("model", "", true), new PrimitiveObjectArgument("apply-skin", true, false), new PrimitiveObjectArgument("animation", (Object)null, false), new PrimitiveObjectArgument("location-offset", "0;0;0", false), new BoundPathObjectArgument("bound-paths", ShowModelAction::arguments$lambda$0, false)};
      this.arguments = CollectionsKt.listOf(var1);
   }

   @NotNull
   public List<AquaticObjectArgument<?>> getArguments() {
      return this.arguments;
   }

   public void execute(@NotNull Animation var1, @NotNull ObjectArguments var2, @NotNull Function2<? super Animation, ? super String, String> var3) {
      Intrinsics.checkNotNullParameter(var1, "binder");
      Intrinsics.checkNotNullParameter(var2, "args");
      Intrinsics.checkNotNullParameter(var3, "textUpdater");
      String var10000 = var2.string("id", ShowModelAction::execute$lambda$1);
      if (var10000 != null) {
         String var4 = var10000;
         var10000 = var2.string("model", ShowModelAction::execute$lambda$2);
         if (var10000 != null) {
            String var5 = var10000;
            Boolean var51 = var2.boolean("apply-skin", ShowModelAction::execute$lambda$3);
            boolean var6 = var51 != null ? var51 : true;
            String var7 = var2.string("animation", ShowModelAction::execute$lambda$4);
            Object var10 = ObjectArguments.any$default(var2, "bound-paths", (Function1)null, 2, (Object)null);
            Function1 var52 = TypeIntrinsics.isFunctionOfArity(var10, 1) ? (Function1)var10 : null;
            if (var52 == null) {
               var52 = ShowModelAction::execute$lambda$5;
            }

            Function1 var8;
            List var57;
            label101: {
               var8 = var52;
               var10000 = var2.string("location-offset", ShowModelAction::execute$lambda$6);
               if (var10000 != null) {
                  CharSequence var54 = (CharSequence)var10000;
                  String[] var12 = new String[]{";"};
                  var57 = StringsKt.split$default(var54, var12, false, 0, 6, (Object)null);
                  if (var57 != null) {
                     break label101;
                  }
               }

               var57 = CollectionsKt.emptyList();
            }

            List var9;
            double var58;
            Vector var61;
            label96: {
               var9 = var57;
               var61 = new Vector;
               String var10002 = (String)CollectionsKt.getOrNull(var9, 0);
               if (var10002 != null) {
                  Double var55 = StringsKt.toDoubleOrNull(var10002);
                  if (var55 != null) {
                     var58 = var55;
                     break label96;
                  }
               }

               var58 = 0.0D;
            }

            double var62;
            label91: {
               String var10003 = (String)CollectionsKt.getOrNull(var9, 1);
               if (var10003 != null) {
                  Double var59 = StringsKt.toDoubleOrNull(var10003);
                  if (var59 != null) {
                     var62 = var59;
                     break label91;
                  }
               }

               var62 = 0.0D;
            }

            double var67;
            label86: {
               String var10004 = (String)CollectionsKt.getOrNull(var9, 2);
               if (var10004 != null) {
                  Double var64 = StringsKt.toDoubleOrNull(var10004);
                  if (var64 != null) {
                     var67 = var64;
                     break label86;
                  }
               }

               var67 = 0.0D;
            }

            Vector var45;
            Float var65;
            float var68;
            label81: {
               var61.<init>(var58, var62, var67);
               var45 = var61;
               var10000 = (String)CollectionsKt.getOrNull(var9, 3);
               if (var10000 != null) {
                  var65 = StringsKt.toFloatOrNull(var10000);
                  if (var65 != null) {
                     var68 = var65;
                     break label81;
                  }
               }

               var68 = 0.0F;
            }

            float var10001;
            label76: {
               var65 = var68;
               String var46 = (String)CollectionsKt.getOrNull(var9, 4);
               if (var46 != null) {
                  Float var13 = StringsKt.toFloatOrNull(var46);
                  if (var13 != null) {
                     var10001 = var13;
                     break label76;
                  }
               }

               var10001 = 0.0F;
            }

            Pair var11 = TuplesKt.to(var65, var10001);
            ConcurrentHashMap var47 = (ConcurrentHashMap)var8.invoke(var1);
            int var48 = 0;
            Player var63 = var6 && var1 instanceof PlayerBoundAnimation ? ((PlayerBoundAnimation)var1).getPlayer() : null;
            Map var15 = (Map)var47;
            Player var31 = var63;
            boolean var16 = false;
            Map var18 = (Map)(new LinkedHashMap(MapsKt.mapCapacity(var15.size())));
            boolean var19 = false;
            Iterable var20 = (Iterable)var15.entrySet();
            boolean var21 = false;
            Iterator var22 = var20.iterator();

            while(var22.hasNext()) {
               Object var23 = var22.next();
               Entry var24 = (Entry)var23;
               boolean var26 = false;
               Object var53 = var24.getKey();
               Entry var27 = (Entry)var23;
               Object var35 = var53;
               boolean var28 = false;
               ++var48;
               Pair var36 = TuplesKt.to(var27.getValue(), var48);
               var18.put(var35, var36);
            }

            ConcurrentHashMap var39 = new ConcurrentHashMap(var18);
            ModelAnimationProp var14 = new ModelAnimationProp(var1, var5, var31, var7, var45, var39, var11);
            Iterator var49 = ((Map)var47).entrySet().iterator();

            while(var49.hasNext()) {
               Entry var50 = (Entry)var49.next();
               PathProp var17 = (PathProp)var50.getKey();
               PathBoundProperties var56 = (PathBoundProperties)var50.getValue();
               Map var60 = var17.getBoundProps();
               Pair var66 = TuplesKt.to(var14, var56);
               var60.put(var66.getFirst(), var66.getSecond());
            }

            var1.getProps().put("model:" + var4, var14);
         }
      }
   }

   private static final ConcurrentHashMap arguments$lambda$0(Animation var0) {
      Intrinsics.checkNotNullParameter(var0, "<unused var>");
      return new ConcurrentHashMap();
   }

   private static final String execute$lambda$1(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$2(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$3(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$4(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final ConcurrentHashMap execute$lambda$5(Animation var0) {
      Intrinsics.checkNotNullParameter(var0, "<unused var>");
      return new ConcurrentHashMap();
   }

   private static final String execute$lambda$6(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }
}
