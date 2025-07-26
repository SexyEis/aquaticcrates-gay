package gg.aquatic.aquaticcrates.plugin.misc.hook;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.util.BStatsUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0006¨\u0006\u0007"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/misc/hook/BStatsHook;", "", "<init>", "()V", "register", "", "register$plugin", "plugin"}
)
public final class BStatsHook {
   @NotNull
   public static final BStatsHook INSTANCE = new BStatsHook();

   private BStatsHook() {
   }

   public final void register$plugin() {
      BStatsUtils.INSTANCE.registerMetrics(19254);
   }
}
