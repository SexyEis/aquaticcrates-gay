package gg.aquatic.aquaticcrates.api;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function0;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0004"},
   d2 = {"runOrCatch", "", "block", "Lgg/aquatic/waves/libs/kotlin/Function0;", "api"}
)
public final class AbstractCratesPluginKt {
   public static final void runOrCatch(@NotNull Function0<Unit> var0) {
      Intrinsics.checkNotNullParameter(var0, "block");
      boolean var1 = false;

      try {
         var0.invoke();
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }
}
