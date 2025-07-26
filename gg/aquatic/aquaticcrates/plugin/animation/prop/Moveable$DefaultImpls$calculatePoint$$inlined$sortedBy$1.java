package gg.aquatic.aquaticcrates.plugin.animation.prop;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.comparisons.ComparisonsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.Comparator;
import java.util.Map.Entry;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 Moveable.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/Moveable$DefaultImpls\n*L\n1#1,328:1\n44#2:329\n*E\n"})
public final class Moveable$DefaultImpls$calculatePoint$$inlined$sortedBy$1<T> implements Comparator {
   public final int compare(T var1, T var2) {
      Entry var3 = (Entry)var1;
      boolean var4 = false;
      Comparable var10000 = (Comparable)((Integer)((Pair)var3.getValue()).getSecond());
      var3 = (Entry)var2;
      Comparable var5 = var10000;
      var4 = false;
      return ComparisonsKt.compareValues(var5, (Comparable)((Integer)((Pair)var3.getValue()).getSecond()));
   }
}
