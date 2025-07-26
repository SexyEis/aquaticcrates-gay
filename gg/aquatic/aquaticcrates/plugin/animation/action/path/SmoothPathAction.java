package gg.aquatic.aquaticcrates.plugin.animation.action.path;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.plugin.animation.prop.path.SmoothPathProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.argument.impl.PrimitiveObjectArgument;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.List;
import java.util.TreeMap;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/path/SmoothPathAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nSmoothPathAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmoothPathAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/path/SmoothPathAction\n+ 2 ObjectArguments.kt\ngg/aquatic/waves/util/argument/ObjectArguments\n*L\n1#1,26:1\n98#2,2:27\n*S KotlinDebug\n*F\n+ 1 SmoothPathAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/path/SmoothPathAction\n*L\n20#1:27,2\n*E\n"})
public final class SmoothPathAction implements ExecutableObject<Animation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public SmoothPathAction() {
      AquaticObjectArgument[] var1 = new AquaticObjectArgument[]{new PrimitiveObjectArgument("id", "smooth-path1", true), new PathPointsArgument("points", new TreeMap(), true)};
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
      String var10000 = var2.string("id", SmoothPathAction::execute$lambda$0);
      if (var10000 != null) {
         String var4 = var10000;
         String var7 = "points";
         Function1 var8 = (Function1)SmoothPathAction$execute$$inlined$typed$default$1.INSTANCE;
         boolean var9 = false;
         Object var10 = var2.any(var7, var8);
         if (!(var10 instanceof TreeMap)) {
            var10 = null;
         }

         TreeMap var11 = (TreeMap)var10;
         if (var11 != null) {
            TreeMap var5 = var11;
            SmoothPathProp var6 = new SmoothPathProp(var1, var5);
            var1.getProps().put("path:" + var4, var6);
         }
      }
   }

   private static final String execute$lambda$0(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }
}
