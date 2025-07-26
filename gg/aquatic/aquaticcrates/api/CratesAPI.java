package gg.aquatic.aquaticcrates.api;

import gg.aquatic.waves.libs.kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/CratesAPI;", "", "<init>", "()V", "api"}
)
public final class CratesAPI {
   @NotNull
   public static final CratesAPI INSTANCE = new CratesAPI();

   private CratesAPI() {
   }
}
