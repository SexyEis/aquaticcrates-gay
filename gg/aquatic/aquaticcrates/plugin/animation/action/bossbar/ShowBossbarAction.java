package gg.aquatic.aquaticcrates.plugin.animation.action.bossbar;

import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.plugin.animation.prop.BossbarAnimationProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.argument.impl.PrimitiveObjectArgument;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.List;
import java.util.Locale;
import net.kyori.adventure.bossbar.BossBar.Color;
import net.kyori.adventure.bossbar.BossBar.Overlay;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/bossbar/ShowBossbarAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
public final class ShowBossbarAction implements ExecutableObject<PlayerBoundAnimation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public ShowBossbarAction() {
      PrimitiveObjectArgument[] var1 = new PrimitiveObjectArgument[]{new PrimitiveObjectArgument("id", "bossbar", true), new PrimitiveObjectArgument("message", "", true), new PrimitiveObjectArgument("color", "white", false), new PrimitiveObjectArgument("style", "solid", false), new PrimitiveObjectArgument("progress", 1.0D, false)};
      this.arguments = CollectionsKt.listOf(var1);
   }

   @NotNull
   public List<AquaticObjectArgument<?>> getArguments() {
      return this.arguments;
   }

   public void execute(@NotNull PlayerBoundAnimation var1, @NotNull ObjectArguments var2, @NotNull Function2<? super PlayerBoundAnimation, ? super String, String> var3) {
      Intrinsics.checkNotNullParameter(var1, "binder");
      Intrinsics.checkNotNullParameter(var2, "args");
      Intrinsics.checkNotNullParameter(var3, "textUpdater");
      String var10000 = var2.string("id", ShowBossbarAction::execute$lambda$0);
      if (var10000 != null) {
         String var4 = var10000;
         var10000 = ObjectArguments.string$default(var2, "message", (Function1)null, 2, (Object)null);
         if (var10000 != null) {
            String var5 = var10000;
            var10000 = var2.string("color", ShowBossbarAction::execute$lambda$1);
            if (var10000 != null) {
               String var6 = var10000;
               var10000 = var2.string("style", ShowBossbarAction::execute$lambda$2);
               if (var10000 != null) {
                  String var7 = var10000;
                  Float var11 = var2.float("progress", ShowBossbarAction::execute$lambda$3);
                  float var8 = var11 != null ? var11 : 1.0F;
                  String var10004 = var6.toUpperCase(Locale.ROOT);
                  Intrinsics.checkNotNullExpressionValue(var10004, "toUpperCase(...)");
                  Color var12 = Color.valueOf(var10004);
                  String var10005 = var7.toUpperCase(Locale.ROOT);
                  Intrinsics.checkNotNullExpressionValue(var10005, "toUpperCase(...)");
                  BossbarAnimationProp var9 = new BossbarAnimationProp(var1, var5, var12, Overlay.valueOf(var10005), var8);
                  AnimationProp var10 = (AnimationProp)var1.getProps().put("bossbar:" + var4, var9);
                  if (var10 != null) {
                     var10.onAnimationEnd();
                  }

               }
            }
         }
      }
   }

   private static final String execute$lambda$0(Function2 var0, PlayerBoundAnimation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$1(Function2 var0, PlayerBoundAnimation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$2(Function2 var0, PlayerBoundAnimation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$3(Function2 var0, PlayerBoundAnimation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }
}
