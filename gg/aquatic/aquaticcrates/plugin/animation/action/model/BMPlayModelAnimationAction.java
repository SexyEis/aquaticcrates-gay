package gg.aquatic.aquaticcrates.plugin.animation.action.model;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.plugin.animation.idle.IdleAnimationImpl;
import gg.aquatic.aquaticcrates.plugin.animation.prop.model.BMModelAnimationProp;
import gg.aquatic.waves.interactable.Interactable;
import gg.aquatic.waves.interactable.type.BMInteractable;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.argument.impl.PrimitiveObjectArgument;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.Iterator;
import java.util.List;
import kr.toxicity.model.api.animation.AnimationModifier;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/model/BMPlayModelAnimationAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
public final class BMPlayModelAnimationAction implements ExecutableObject<Animation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public BMPlayModelAnimationAction() {
      PrimitiveObjectArgument[] var1 = new PrimitiveObjectArgument[]{new PrimitiveObjectArgument("id", (Object)null, false), new PrimitiveObjectArgument("animation", "animation", true), new PrimitiveObjectArgument("fade-in", 0, false), new PrimitiveObjectArgument("fade-out", 0, false), new PrimitiveObjectArgument("speed", 1.0F, false)};
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
      String var4 = var2.string("id", BMPlayModelAnimationAction::execute$lambda$0);
      String var10000 = var2.string("animation", BMPlayModelAnimationAction::execute$lambda$1);
      if (var10000 != null) {
         String var5 = var10000;
         Integer var12 = var2.int("fade-in", BMPlayModelAnimationAction::execute$lambda$2);
         if (var12 != null) {
            int var6 = var12;
            var12 = var2.int("fade-out", BMPlayModelAnimationAction::execute$lambda$3);
            if (var12 != null) {
               int var7 = var12;
               Float var13 = var2.float("speed", BMPlayModelAnimationAction::execute$lambda$4);
               if (var13 != null) {
                  float var8 = var13;
                  if (var4 == null) {
                     if (var1 instanceof IdleAnimationImpl) {
                        Iterator var15 = ((IdleAnimationImpl)var1).getCrate().getSpawnedInteractables().iterator();

                        while(var15.hasNext()) {
                           Interactable var10 = (Interactable)var15.next();
                           if (var10 instanceof BMInteractable) {
                              ((BMInteractable)var10).getTracker().animate(var5, new AnimationModifier(var6, var7, var8));
                           }
                        }

                     }
                  } else {
                     Object var11 = var1.getProps().get("model:" + var4);
                     BMModelAnimationProp var14 = var11 instanceof BMModelAnimationProp ? (BMModelAnimationProp)var11 : null;
                     if ((var11 instanceof BMModelAnimationProp ? (BMModelAnimationProp)var11 : null) != null) {
                        BMModelAnimationProp var9 = var14;
                        var9.playAnimation(var5, var6, var7, var8);
                     }
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
}
