package gg.aquatic.aquaticcrates.api.openprice;

import gg.aquatic.waves.libs.kotlin.Metadata;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"-\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
   d2 = {"PRICES", "Ljava/util/HashMap;", "", "Lgg/aquatic/aquaticcrates/api/openprice/Price;", "Lgg/aquatic/waves/libs/kotlin/collections/HashMap;", "getPRICES", "()Ljava/util/HashMap;", "api"}
)
public final class PriceKt {
   @NotNull
   private static final HashMap<String, Price> PRICES = new HashMap();

   @NotNull
   public static final HashMap<String, Price> getPRICES() {
      return PRICES;
   }
}
