package gg.aquatic.aquaticcrates.plugin.animation.action.model;

import com.ticxo.modelengine.api.animation.handler.AnimationHandler;
import com.ticxo.modelengine.api.model.ActiveModel;
import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.plugin.animation.idle.IdleAnimationImpl;
import gg.aquatic.aquaticcrates.plugin.animation.prop.model.ModelAnimationProp;
import gg.aquatic.waves.interactable.Interactable;
import gg.aquatic.waves.interactable.type.MEGInteractable;
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
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/model/PlayModelAnimationAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
public final class PlayModelAnimationAction implements ExecutableObject<Animation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public PlayModelAnimationAction() {
      PrimitiveObjectArgument[] var1 = new PrimitiveObjectArgument[]{new PrimitiveObjectArgument("id", (Object)null, false), new PrimitiveObjectArgument("animation", "animation", true), new PrimitiveObjectArgument("fade-in", 0.0D, false), new PrimitiveObjectArgument("fade-out", 0.0D, false), new PrimitiveObjectArgument("speed", 1.0D, false)};
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
      String var4 = var2.string("id", PlayModelAnimationAction::execute$lambda$0);
      String var10000 = var2.string("animation", PlayModelAnimationAction::execute$lambda$1);
      if (var10000 != null) {
         String var5 = var10000;
         Double var16 = var2.double("fade-in", PlayModelAnimationAction::execute$lambda$2);
         if (var16 != null) {
            double var6 = var16;
            var16 = var2.double("fade-out", PlayModelAnimationAction::execute$lambda$3);
            if (var16 != null) {
               double var8 = var16;
               var16 = var2.double("speed", PlayModelAnimationAction::execute$lambda$4);
               if (var16 != null) {
                  double var10 = var16;
                  if (var4 != null) {
                     Object var14 = var1.getProps().get("model:" + var4);
                     ModelAnimationProp var19 = var14 instanceof ModelAnimationProp ? (ModelAnimationProp)var14 : null;
                     if ((var14 instanceof ModelAnimationProp ? (ModelAnimationProp)var14 : null) != null) {
                        ModelAnimationProp var15 = var19;
                        var15.playAnimation(var5, var6, var8, var10);
                     }
                  } else if (var1 instanceof IdleAnimationImpl) {
                     Iterator var12 = ((IdleAnimationImpl)var1).getCrate().getSpawnedInteractables().iterator();

                     while(true) {
                        while(true) {
                           Interactable var13;
                           do {
                              if (!var12.hasNext()) {
                                 return;
                              }

                              var13 = (Interactable)var12.next();
                           } while(!(var13 instanceof MEGInteractable));

                           ActiveModel var17 = ((MEGInteractable)var13).getActiveModel();
                           if (var17 != null) {
                              AnimationHandler var18 = var17.getAnimationHandler();
                              if (var18 != null) {
                                 var18.playAnimation(var5, var6, var8, var10, true);
                              }
                           }
                        }
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
