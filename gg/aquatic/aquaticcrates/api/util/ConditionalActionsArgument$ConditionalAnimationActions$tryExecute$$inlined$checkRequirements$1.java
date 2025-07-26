package gg.aquatic.aquaticcrates.api.util;

import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
public final class ConditionalActionsArgument$ConditionalAnimationActions$tryExecute$$inlined$checkRequirements$1 implements Function2<PlayerBoundAnimation, String, String> {
   public static final ConditionalActionsArgument$ConditionalAnimationActions$tryExecute$$inlined$checkRequirements$1 INSTANCE = new ConditionalActionsArgument$ConditionalAnimationActions$tryExecute$$inlined$checkRequirements$1();

   public final String invoke(PlayerBoundAnimation var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "str");
      return var2;
   }
}
