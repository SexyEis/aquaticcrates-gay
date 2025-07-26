package gg.aquatic.aquaticcrates.plugin.animation.action.entity;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.BoundPathObjectArgument;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.EntityAnimationProp;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property.EntityPropertiesObjectArgument;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property.EntityProperty;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathBoundProperties;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.PathProp;
import gg.aquatic.waves.fake.entity.FakeEntity;
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
import java.util.Collection;
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
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/entity/ShowEntityAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nShowEntityAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShowEntityAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/entity/ShowEntityAction\n+ 2 ObjectArguments.kt\ngg/aquatic/waves/util/argument/ObjectArguments\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,77:1\n99#2:78\n463#3:79\n413#3:80\n1252#4,4:81\n*S KotlinDebug\n*F\n+ 1 ShowEntityAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/entity/ShowEntityAction\n*L\n35#1:78\n56#1:79\n56#1:80\n56#1:81,4\n*E\n"})
public final class ShowEntityAction implements ExecutableObject<Animation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public ShowEntityAction() {
      AquaticObjectArgument[] var1 = new AquaticObjectArgument[]{new PrimitiveObjectArgument("id", "example-entity", true), new PrimitiveObjectArgument("entity-type", "zombie", true), new EntityPropertiesObjectArgument("properties", CollectionsKt.emptyList(), false), new PrimitiveObjectArgument("location-offset", "0;0;0", false), new BoundPathObjectArgument("bound-paths", ShowEntityAction::arguments$lambda$0, false)};
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
      String var10000 = var2.string("id", ShowEntityAction::execute$lambda$1);
      if (var10000 != null) {
         String var4 = var10000;
         var10000 = var2.string("entity-type", ShowEntityAction::execute$lambda$2);
         if (var10000 != null) {
            String var5 = var10000;
            String var9 = "properties";
            Function1 var10 = ShowEntityAction::execute$lambda$3;
            boolean var11 = false;
            Object var47 = var2.any(var9, var10);
            if (!(var47 instanceof List)) {
               var47 = null;
            }

            List var49 = (List)var47;
            if ((List)var47 != null) {
               List var6 = var49;
               var10000 = var2.string("location-offset", ShowEntityAction::execute$lambda$4);
               if (var10000 == null) {
                  var10000 = "";
               }

               List var7;
               double var53;
               Vector var55;
               label83: {
                  CharSequence var54 = (CharSequence)var10000;
                  String[] var8 = new String[]{";"};
                  var7 = StringsKt.split$default(var54, var8, false, 0, 6, (Object)null);
                  var55 = new Vector;
                  String var10002 = (String)CollectionsKt.getOrNull(var7, 0);
                  if (var10002 != null) {
                     Double var51 = StringsKt.toDoubleOrNull(var10002);
                     if (var51 != null) {
                        var53 = var51;
                        break label83;
                     }
                  }

                  var53 = 0.0D;
               }

               double var58;
               label78: {
                  String var10003 = (String)CollectionsKt.getOrNull(var7, 1);
                  if (var10003 != null) {
                     Double var56 = StringsKt.toDoubleOrNull(var10003);
                     if (var56 != null) {
                        var58 = var56;
                        break label78;
                     }
                  }

                  var58 = 0.0D;
               }

               double var63;
               label73: {
                  String var10004 = (String)CollectionsKt.getOrNull(var7, 2);
                  if (var10004 != null) {
                     Double var61 = StringsKt.toDoubleOrNull(var10004);
                     if (var61 != null) {
                        var63 = var61;
                        break label73;
                     }
                  }

                  var63 = 0.0D;
               }

               Vector var40;
               Float var60;
               float var62;
               label68: {
                  var55.<init>(var53, var58, var63);
                  var40 = var55;
                  var10000 = (String)CollectionsKt.getOrNull(var7, 3);
                  if (var10000 != null) {
                     var60 = StringsKt.toFloatOrNull(var10000);
                     if (var60 != null) {
                        var62 = var60;
                        break label68;
                     }
                  }

                  var62 = 0.0F;
               }

               float var10001;
               label63: {
                  var60 = var62;
                  String var42 = (String)CollectionsKt.getOrNull(var7, 4);
                  if (var42 != null) {
                     Float var43 = StringsKt.toFloatOrNull(var42);
                     if (var43 != null) {
                        var10001 = var43;
                        break label63;
                     }
                  }

                  var10001 = 0.0F;
               }

               Pair var41 = TuplesKt.to(var60, var10001);
               Function1 var64 = (Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(ObjectArguments.any$default(var2, "bound-paths", (Function1)null, 2, (Object)null), 1);
               if (var64 == null) {
                  var64 = ShowEntityAction::execute$lambda$5;
               }

               var10 = var64;
               ConcurrentHashMap var44 = (ConcurrentHashMap)var10.invoke(var1);
               int var12 = 0;
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
                  Object var50 = var23.getKey();
                  Entry var26 = (Entry)var22;
                  Object var31 = var50;
                  boolean var27 = false;
                  ++var12;
                  Pair var32 = TuplesKt.to(var26.getValue(), var12);
                  var17.put(var31, var32);
               }

               ConcurrentHashMap var59 = new ConcurrentHashMap(var17);
               Collection var35 = (Collection)var6;
               ConcurrentHashMap var37 = var59;
               EntityAnimationProp var13 = new EntityAnimationProp(var1, var40, var37, var5, var35, var41);
               Iterator var45 = ((Map)var44).entrySet().iterator();

               while(var45.hasNext()) {
                  Entry var46 = (Entry)var45.next();
                  PathProp var16 = (PathProp)var46.getKey();
                  PathBoundProperties var48 = (PathBoundProperties)var46.getValue();
                  Map var52 = var16.getBoundProps();
                  Pair var57 = TuplesKt.to(var13, var48);
                  var52.put(var57.getFirst(), var57.getSecond());
               }

               var13.getEntity().updateEntity(ShowEntityAction::execute$lambda$7);
               var1.getProps().put("entity:" + var4, var13);
            }
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

   private static final Unit execute$lambda$7(List var0, EntityAnimationProp var1, FakeEntity var2) {
      Intrinsics.checkNotNullParameter(var2, "$this$updateEntity");
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         EntityProperty var4 = (EntityProperty)var3.next();
         var4.apply(var2, var1);
      }

      return Unit.INSTANCE;
   }
}
