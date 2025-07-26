package gg.aquatic.aquaticcrates.api.util;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
public final class ConditionalActionsArgument$ConditionalAnimationActions$tryExecute$$inlined$checkRequirements$2 implements Function2<Animation, String, String> {
   public static final ConditionalActionsArgument$ConditionalAnimationActions$tryExecute$$inlined$checkRequirements$2 INSTANCE = new ConditionalActionsArgument$ConditionalAnimationActions$tryExecute$$inlined$checkRequirements$2();

   public final String invoke(Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "str");
      return var2;
   }
}
