package gg.aquatic.aquaticcrates.plugin.animation.action;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.aquaticcrates.api.reward.RewardRarity;
import gg.aquatic.aquaticcrates.api.util.ActionsArgument;
import gg.aquatic.aquaticcrates.plugin.animation.prop.RumblingRewardProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.util.NumberExtKt;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.argument.impl.PrimitiveObjectArgument;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/RumblingRewardAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nRumblingRewardAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RumblingRewardAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/RumblingRewardAction\n+ 2 ObjectArguments.kt\ngg/aquatic/waves/util/argument/ObjectArguments\n*L\n1#1,80:1\n98#2,2:81\n98#2,2:83\n*S KotlinDebug\n*F\n+ 1 RumblingRewardAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/RumblingRewardAction\n*L\n31#1:81,2\n32#1:83,2\n*E\n"})
public final class RumblingRewardAction implements ExecutableObject<Animation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public RumblingRewardAction() {
      AquaticObjectArgument[] var1 = new AquaticObjectArgument[]{new PrimitiveObjectArgument("id", "example", true), new PrimitiveObjectArgument("rumbling-length", 0, false), new PrimitiveObjectArgument("rumbling-period", 0, false), new PrimitiveObjectArgument("ease-out", false, false), new PrimitiveObjectArgument("reward-index", 0, false), new ActionsArgument("rumble-actions", (CrateAnimationActions)null, false), new ActionsArgument("rumble-finish-actions", (CrateAnimationActions)null, false)};
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
      String var10000 = var2.string("id", RumblingRewardAction::execute$lambda$0);
      if (var10000 == null) {
         var10000 = "example";
      }

      String var4 = var10000;
      Integer var18 = var2.int("rumbling-length", RumblingRewardAction::execute$lambda$1);
      if (var18 != null) {
         int var5 = var18;
         var18 = var2.int("rumbling-period", RumblingRewardAction::execute$lambda$2);
         if (var18 != null) {
            int var6 = var18;
            Boolean var19 = var2.boolean("ease-out", RumblingRewardAction::execute$lambda$3);
            boolean var7 = var19 != null ? var19 : false;
            var18 = var2.int("reward-index", RumblingRewardAction::execute$lambda$4);
            int var8 = var18 != null ? var18 : 0;
            String var11 = "rumble-actions";
            Function1 var12 = (Function1)RumblingRewardAction$execute$$inlined$typed$default$1.INSTANCE;
            boolean var13 = false;
            Object var20 = var2.any(var11, var12);
            if (!(var20 instanceof CrateAnimationActions)) {
               var20 = null;
            }

            CrateAnimationActions var21 = (CrateAnimationActions)var20;
            if (var21 == null) {
               var21 = new CrateAnimationActions();
            }

            CrateAnimationActions var9 = var21;
            String var16 = "rumble-finish-actions";
            Function1 var17 = (Function1)RumblingRewardAction$execute$$inlined$typed$default$2.INSTANCE;
            boolean var14 = false;
            var20 = var2.any(var16, var17);
            if (!(var20 instanceof CrateAnimationActions)) {
               var20 = null;
            }

            var21 = (CrateAnimationActions)var20;
            if (var21 == null) {
               var21 = new CrateAnimationActions();
            }

            CrateAnimationActions var10 = var21;
            if (var1 instanceof CrateAnimation) {
               RumblingRewardProp var15 = new RumblingRewardProp((CrateAnimation)var1, var5, var6, var7, var8, var9, var10);
               ((Map)var1.getExtraPlaceholders()).put("rumbling-reward-name:" + var4, RumblingRewardAction::execute$lambda$5);
               ((Map)var1.getExtraPlaceholders()).put("rumbling-reward-id:" + var4, RumblingRewardAction::execute$lambda$6);
               ((Map)var1.getExtraPlaceholders()).put("rumbling-reward-chance:" + var4, RumblingRewardAction::execute$lambda$7);
               ((Map)var1.getExtraPlaceholders()).put("rumbling-reward-rarity-name:" + var4, RumblingRewardAction::execute$lambda$8);
               ((Map)var1.getExtraPlaceholders()).put("rumbling-reward-rarity-id:" + var4, RumblingRewardAction::execute$lambda$9);
               var1.getProps().put("rumbling-reward:" + var4, var15);
               var15.tick();
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

   private static final String execute$lambda$5(String var0, RumblingRewardProp var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "str");
      String var10001 = "%rumbling-reward-name:" + var0 + "%";
      Reward var10002 = var1.getCurrentReward();
      String var3;
      if (var10002 != null) {
         var3 = var10002.getDisplayName();
         if (var3 != null) {
            return StringsKt.replace$default(var2, var10001, var3, false, 4, (Object)null);
         }
      }

      var3 = "";
      return StringsKt.replace$default(var2, var10001, var3, false, 4, (Object)null);
   }

   private static final String execute$lambda$6(String var0, RumblingRewardProp var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "str");
      String var10001 = "%rumbling-reward-id:" + var0 + "%";
      Reward var10002 = var1.getCurrentReward();
      String var3;
      if (var10002 != null) {
         var3 = var10002.getId();
         if (var3 != null) {
            return StringsKt.replace$default(var2, var10001, var3, false, 4, (Object)null);
         }
      }

      var3 = "";
      return StringsKt.replace$default(var2, var10001, var3, false, 4, (Object)null);
   }

   private static final String execute$lambda$7(String var0, RumblingRewardProp var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "str");
      String var10001 = "%rumbling-reward-chance:" + var0 + "%";
      Reward var10002 = var1.getCurrentReward();
      return StringsKt.replace$default(var2, var10001, NumberExtKt.decimals((var10002 != null ? var10002.getChance() : 0.0D) * 100.0D, 2), false, 4, (Object)null);
   }

   private static final String execute$lambda$8(String var0, RumblingRewardProp var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "str");
      String var10001 = "%rumbling-reward-rarity-name:" + var0 + "%";
      Reward var10002 = var1.getCurrentReward();
      String var4;
      if (var10002 != null) {
         RewardRarity var3 = var10002.getRarity();
         if (var3 != null) {
            var4 = var3.getDisplayName();
            if (var4 != null) {
               return StringsKt.replace$default(var2, var10001, var4, false, 4, (Object)null);
            }
         }
      }

      var4 = "";
      return StringsKt.replace$default(var2, var10001, var4, false, 4, (Object)null);
   }

   private static final String execute$lambda$9(String var0, RumblingRewardProp var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "str");
      String var10001 = "%rumbling-reward-rarity-id:" + var0 + "%";
      Reward var10002 = var1.getCurrentReward();
      String var4;
      if (var10002 != null) {
         RewardRarity var3 = var10002.getRarity();
         if (var3 != null) {
            var4 = var3.getRarityId();
            if (var4 != null) {
               return StringsKt.replace$default(var2, var10001, var4, false, 4, (Object)null);
            }
         }
      }

      var4 = "";
      return StringsKt.replace$default(var2, var10001, var4, false, 4, (Object)null);
   }
}
