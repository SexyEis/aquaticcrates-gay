package gg.aquatic.aquaticcrates.plugin.crate;

import gg.aquatic.aquaticcrates.plugin.restriction.OpenData;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
public final class BasicCrate$canBeOpened$$inlined$checkRequirements$1 implements Function2<OpenData, String, String> {
   public static final BasicCrate$canBeOpened$$inlined$checkRequirements$1 INSTANCE = new BasicCrate$canBeOpened$$inlined$checkRequirements$1();

   public final String invoke(OpenData var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "str");
      return var2;
   }
}
