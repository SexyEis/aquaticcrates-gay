package gg.aquatic.aquaticcrates.plugin.animation.action.model;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.BoundPathObjectArgument;
import gg.aquatic.aquaticcrates.plugin.animation.prop.model.BMModelAnimationProp;
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
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/model/BMShowModelAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nBMShowModelAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BMShowModelAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/model/BMShowModelAction\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n463#2:69\n413#2:70\n1252#3,4:71\n*S KotlinDebug\n*F\n+ 1 BMShowModelAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/model/BMShowModelAction\n*L\n55#1:69\n55#1:70\n55#1:71,4\n*E\n"})
public final class BMShowModelAction implements ExecutableObject<Animation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public BMShowModelAction() {
      AquaticObjectArgument[] var1 = new AquaticObjectArgument[]{new PrimitiveObjectArgument("id", "example", true), new PrimitiveObjectArgument("model", "", true), new PrimitiveObjectArgument("animation", (Object)null, false), new PrimitiveObjectArgument("location-offset", "0;0;0", false), new BoundPathObjectArgument("bound-paths", BMShowModelAction::arguments$lambda$0, false)};
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
      String var10000 = var2.string("id", BMShowModelAction::execute$lambda$1);
      if (var10000 != null) {
         String var4 = var10000;
         var10000 = var2.string("model", BMShowModelAction::execute$lambda$2);
         if (var10000 != null) {
            String var5 = var10000;
            String var6 = var2.string("animation", BMShowModelAction::execute$lambda$3);
            Object var9 = ObjectArguments.any$default(var2, "bound-paths", (Function1)null, 2, (Object)null);
            Function1 var48 = TypeIntrinsics.isFunctionOfArity(var9, 1) ? (Function1)var9 : null;
            if (var48 == null) {
               var48 = BMShowModelAction::execute$lambda$4;
            }

            Function1 var7;
            List var52;
            label87: {
               var7 = var48;
               var10000 = var2.string("location-offset", BMShowModelAction::execute$lambda$5);
               if (var10000 != null) {
                  CharSequence var50 = (CharSequence)var10000;
                  String[] var11 = new String[]{";"};
                  var52 = StringsKt.split$default(var50, var11, false, 0, 6, (Object)null);
                  if (var52 != null) {
                     break label87;
                  }
               }

               var52 = CollectionsKt.emptyList();
            }

            List var8;
            double var55;
            Vector var56;
            label82: {
               var8 = var52;
               var56 = new Vector;
               String var10002 = (String)CollectionsKt.getOrNull(var8, 0);
               if (var10002 != null) {
                  Double var53 = StringsKt.toDoubleOrNull(var10002);
                  if (var53 != null) {
                     var55 = var53;
                     break label82;
                  }
               }

               var55 = 0.0D;
            }

            double var59;
            label77: {
               String var10003 = (String)CollectionsKt.getOrNull(var8, 1);
               if (var10003 != null) {
                  Double var57 = StringsKt.toDoubleOrNull(var10003);
                  if (var57 != null) {
                     var59 = var57;
                     break label77;
                  }
               }

               var59 = 0.0D;
            }

            double var63;
            label72: {
               String var10004 = (String)CollectionsKt.getOrNull(var8, 2);
               if (var10004 != null) {
                  Double var61 = StringsKt.toDoubleOrNull(var10004);
                  if (var61 != null) {
                     var63 = var61;
                     break label72;
                  }
               }

               var63 = 0.0D;
            }

            Vector var42;
            Float var60;
            float var62;
            label67: {
               var56.<init>(var55, var59, var63);
               var42 = var56;
               var10000 = (String)CollectionsKt.getOrNull(var8, 3);
               if (var10000 != null) {
                  var60 = StringsKt.toFloatOrNull(var10000);
                  if (var60 != null) {
                     var62 = var60;
                     break label67;
                  }
               }

               var62 = 0.0F;
            }

            float var10001;
            label62: {
               var60 = var62;
               String var43 = (String)CollectionsKt.getOrNull(var8, 4);
               if (var43 != null) {
                  Float var12 = StringsKt.toFloatOrNull(var43);
                  if (var12 != null) {
                     var10001 = var12;
                     break label62;
                  }
               }

               var10001 = 0.0F;
            }

            Pair var10 = TuplesKt.to(var60, var10001);
            ConcurrentHashMap var44 = (ConcurrentHashMap)var7.invoke(var1);
            int var45 = 0;
            Map var14 = (Map)var44;
            boolean var15 = false;
            Map var17 = (Map)(new LinkedHashMap(MapsKt.mapCapacity(var14.size())));
            boolean var18 = false;
            Iterable var19 = (Iterable)var14.entrySet();
            boolean var20 = false;
            Iterator var21 = var19.iterator();

            while(var21.hasNext()) {
               Object var22 = var21.next();
               Entry var23 = (Entry)var22;
               boolean var25 = false;
               Object var51 = var23.getKey();
               Entry var26 = (Entry)var22;
               Object var33 = var51;
               boolean var27 = false;
               ++var45;
               Pair var34 = TuplesKt.to(var26.getValue(), var45);
               var17.put(var33, var34);
            }

            ConcurrentHashMap var37 = new ConcurrentHashMap(var17);
            BMModelAnimationProp var13 = new BMModelAnimationProp(var1, var5, var6, var42, var37, var10);
            Iterator var46 = ((Map)var44).entrySet().iterator();

            while(var46.hasNext()) {
               Entry var47 = (Entry)var46.next();
               PathProp var16 = (PathProp)var47.getKey();
               PathBoundProperties var49 = (PathBoundProperties)var47.getValue();
               Map var54 = var16.getBoundProps();
               Pair var58 = TuplesKt.to(var13, var49);
               var54.put(var58.getFirst(), var58.getSecond());
            }

            var1.getProps().put("model:" + var4, var13);
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

   private static final ConcurrentHashMap execute$lambda$4(Animation var0) {
      Intrinsics.checkNotNullParameter(var0, "<unused var>");
      return new ConcurrentHashMap();
   }

   private static final String execute$lambda$5(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }
}
