package gg.aquatic.aquaticcrates.api.player;

import gg.aquatic.aquaticcrates.api.reward.RewardContainer;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.profile.AquaticPlayer;
import gg.aquatic.waves.profile.module.ProfileModuleEntry;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"},
   d2 = {"crateEntry", "Lgg/aquatic/aquaticcrates/api/player/CrateProfileEntry;", "Lgg/aquatic/waves/profile/AquaticPlayer;", "api"}
)
@SourceDebugExtension({"SMAP\nCrateProfileModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrateProfileModule.kt\ngg/aquatic/aquaticcrates/api/player/CrateProfileModuleKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,133:1\n382#2,7:134\n*S KotlinDebug\n*F\n+ 1 CrateProfileModule.kt\ngg/aquatic/aquaticcrates/api/player/CrateProfileModuleKt\n*L\n132#1:134,7\n*E\n"})
public final class CrateProfileModuleKt {
   @NotNull
   public static final CrateProfileEntry crateEntry(@NotNull AquaticPlayer var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Map var1 = (Map)var0.getEntries();
      String var2 = CrateProfileModule.INSTANCE.getId();
      boolean var3 = false;
      Object var4 = var1.get(var2);
      Object var10000;
      if (var4 == null) {
         boolean var5 = false;
         ProfileModuleEntry var6 = (ProfileModuleEntry)(new CrateProfileEntry(var0, new RewardContainer()));
         var1.put(var2, var6);
         var10000 = var6;
      } else {
         var10000 = var4;
      }

      return (CrateProfileEntry)var10000;
   }
}
