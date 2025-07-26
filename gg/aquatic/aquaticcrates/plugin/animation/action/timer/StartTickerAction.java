package gg.aquatic.aquaticcrates.plugin.animation.action.timer;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.aquaticcrates.api.util.ActionsArgument;
import gg.aquatic.aquaticcrates.plugin.animation.prop.timer.TickerAnimationProp;
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
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/timer/StartTickerAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nStartTickerAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StartTickerAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/timer/StartTickerAction\n+ 2 ObjectArguments.kt\ngg/aquatic/waves/util/argument/ObjectArguments\n*L\n1#1,29:1\n98#2,2:30\n*S KotlinDebug\n*F\n+ 1 StartTickerAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/timer/StartTickerAction\n*L\n21#1:30,2\n*E\n"})
public final class StartTickerAction implements ExecutableObject<Animation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public StartTickerAction() {
      AquaticObjectArgument[] var1 = new AquaticObjectArgument[]{new ActionsArgument("actions", (CrateAnimationActions)null, true), new PrimitiveObjectArgument("tick-every", 1, false), new PrimitiveObjectArgument("id", "example", false), new PrimitiveObjectArgument("repeat-limit", -1, false)};
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
      String var6 = "actions";
      Function1 var7 = (Function1)StartTickerAction$execute$$inlined$typed$default$1.INSTANCE;
      boolean var8 = false;
      Object var10000 = var2.any(var6, var7);
      if (!(var10000 instanceof CrateAnimationActions)) {
         var10000 = null;
      }

      CrateAnimationActions var9 = (CrateAnimationActions)var10000;
      if (var9 != null) {
         CrateAnimationActions var4 = var9;
         Integer var11 = var2.int("tick-every", StartTickerAction::execute$lambda$0);
         if (var11 != null) {
            int var5 = var11;
            var11 = var2.int("repeat-limit", StartTickerAction::execute$lambda$1);
            int var10 = var11 != null ? var11 : -1;
            String var12 = var2.string("id", StartTickerAction::execute$lambda$2);
            if (var12 != null) {
               String var13 = var12;
               TickerAnimationProp var14 = new TickerAnimationProp(var1, var13, var5, var4, var10);
               var1.getProps().put("ticker:" + var13, var14);
            }
         }
      }
   }

   private static final String execute$lambda$0(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$1(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$2(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }
}
