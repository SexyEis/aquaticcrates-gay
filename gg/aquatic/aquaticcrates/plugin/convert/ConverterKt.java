package gg.aquatic.aquaticcrates.plugin.convert;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.collections.MapsKt;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"-\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
   d2 = {"CONVERTERS", "Ljava/util/HashMap;", "", "Lgg/aquatic/aquaticcrates/plugin/convert/Converter;", "Lgg/aquatic/waves/libs/kotlin/collections/HashMap;", "getCONVERTERS", "()Ljava/util/HashMap;", "plugin"}
)
public final class ConverterKt {
   @NotNull
   private static final HashMap<String, Converter> CONVERTERS;

   @NotNull
   public static final HashMap<String, Converter> getCONVERTERS() {
      return CONVERTERS;
   }

   static {
      Pair[] var0 = new Pair[]{TuplesKt.to("ac2", AC2Converter.INSTANCE)};
      CONVERTERS = MapsKt.hashMapOf(var0);
   }
}
