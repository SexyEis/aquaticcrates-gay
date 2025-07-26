package gg.aquatic.aquaticcrates.plugin.animation.action.path;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.plugin.animation.prop.Moveable;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.BoundPathObjectArgument;
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
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/path/BindPathAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nBindPathAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BindPathAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/path/BindPathAction\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n463#2:44\n413#2:45\n1252#3,4:46\n*S KotlinDebug\n*F\n+ 1 BindPathAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/path/BindPathAction\n*L\n35#1:44\n35#1:45\n35#1:46,4\n*E\n"})
public final class BindPathAction implements ExecutableObject<Animation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public BindPathAction() {
      AquaticObjectArgument[] var1 = new AquaticObjectArgument[]{new PrimitiveObjectArgument("object-id", "model", true), new BoundPathObjectArgument("bound-paths", BindPathAction::arguments$lambda$0, false)};
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
      String var10000 = var2.string("object-id", BindPathAction::execute$lambda$1);
      if (var10000 != null) {
         String var4 = var10000;
         Function1 var32 = (Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(ObjectArguments.any$default(var2, "bound-paths", (Function1)null, 2, (Object)null), 1);
         if (var32 == null) {
            var32 = BindPathAction::execute$lambda$2;
         }

         Function1 var5 = var32;
         Object var8 = var1.getProps().get(var4);
         Moveable var33 = var8 instanceof Moveable ? (Moveable)var8 : null;
         if ((var8 instanceof Moveable ? (Moveable)var8 : null) != null) {
            Moveable var6 = var33;
            int var7 = 0;
            ConcurrentHashMap var27 = (ConcurrentHashMap)var5.invoke(var1);
            Map var9 = (Map)var6.getBoundPaths();
            Map var10 = (Map)var27;
            boolean var11 = false;
            Map var13 = (Map)(new LinkedHashMap(MapsKt.mapCapacity(var10.size())));
            boolean var14 = false;
            Iterable var15 = (Iterable)var10.entrySet();
            boolean var16 = false;
            Iterator var17 = var15.iterator();

            while(var17.hasNext()) {
               Object var18 = var17.next();
               Entry var19 = (Entry)var18;
               boolean var21 = false;
               Object var10001 = var19.getKey();
               Entry var22 = (Entry)var18;
               Object var25 = var10001;
               boolean var23 = false;
               ++var7;
               Pair var26 = TuplesKt.to(var22.getValue(), var6.getBoundPaths().size() + var7);
               var13.put(var25, var26);
            }

            var9.putAll(var13);
            Iterator var28 = ((Map)var27).entrySet().iterator();

            while(var28.hasNext()) {
               Entry var29 = (Entry)var28.next();
               PathProp var30 = (PathProp)var29.getKey();
               PathBoundProperties var12 = (PathBoundProperties)var29.getValue();
               var13 = var30.getBoundProps();
               Pair var31 = TuplesKt.to(var6, var12);
               var13.put(var31.getFirst(), var31.getSecond());
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

   private static final ConcurrentHashMap execute$lambda$2(Animation var0) {
      Intrinsics.checkNotNullParameter(var0, "<unused var>");
      return new ConcurrentHashMap();
   }
}
