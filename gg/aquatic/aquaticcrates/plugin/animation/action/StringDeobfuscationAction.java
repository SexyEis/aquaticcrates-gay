package gg.aquatic.aquaticcrates.plugin.animation.action;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.aquaticcrates.api.util.ActionsArgument;
import gg.aquatic.aquaticcrates.plugin.animation.prop.StringDeobfuscationAnimationProp;
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
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/StringDeobfuscationAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nStringDeobfuscationAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringDeobfuscationAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/StringDeobfuscationAction\n+ 2 ObjectArguments.kt\ngg/aquatic/waves/util/argument/ObjectArguments\n*L\n1#1,44:1\n99#2:45\n*S KotlinDebug\n*F\n+ 1 StringDeobfuscationAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/StringDeobfuscationAction\n*L\n28#1:45\n*E\n"})
public final class StringDeobfuscationAction implements ExecutableObject<Animation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public StringDeobfuscationAction() {
      AquaticObjectArgument[] var1 = new AquaticObjectArgument[]{new PrimitiveObjectArgument("deobfuscate-every", 1, false), new PrimitiveObjectArgument("id", "example", false), new PrimitiveObjectArgument("deobfuscation-string", "example", true), new PrimitiveObjectArgument("obfuscated-format", "<obfuscated><gray>", true), new PrimitiveObjectArgument("deobfuscated-format", "<white>", true), new ActionsArgument("deobfuscation-actions", new CrateAnimationActions(), false), new PrimitiveObjectArgument("strip-colors", true, false)};
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
      Integer var10000 = var2.int("deobfuscate-every", StringDeobfuscationAction::execute$lambda$0);
      if (var10000 != null) {
         int var4 = var10000;
         String var15 = var2.string("deobfuscation-string", StringDeobfuscationAction::execute$lambda$1);
         if (var15 != null) {
            String var5 = var15;
            var15 = var2.string("obfuscated-format", StringDeobfuscationAction::execute$lambda$2);
            if (var15 != null) {
               String var6 = var15;
               var15 = var2.string("deobfuscated-format", StringDeobfuscationAction::execute$lambda$3);
               if (var15 != null) {
                  String var7 = var15;
                  String var11 = "deobfuscation-actions";
                  Function1 var12 = StringDeobfuscationAction::execute$lambda$4;
                  boolean var13 = false;
                  Object var16 = var2.any(var11, var12);
                  if (!(var16 instanceof CrateAnimationActions)) {
                     var16 = null;
                  }

                  CrateAnimationActions var17 = (CrateAnimationActions)var16;
                  if (var17 != null) {
                     CrateAnimationActions var8 = var17;
                     var15 = var2.string("id", StringDeobfuscationAction::execute$lambda$5);
                     if (var15 == null) {
                        var15 = "example";
                     }

                     String var9 = var15;
                     Boolean var18 = var2.boolean("strip-colors", StringDeobfuscationAction::execute$lambda$6);
                     boolean var10 = var18 != null ? var18 : false;
                     StringDeobfuscationAnimationProp var14 = new StringDeobfuscationAnimationProp(var9, var1, var4, var5, var6, var7, var8, var10);
                     var1.getProps().put("deobfuscation:" + var9, var14);
                  }
               }
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

   private static final String execute$lambda$3(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$4(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$5(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$6(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }
}
