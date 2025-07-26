package gg.aquatic.aquaticcrates.plugin.log;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.menu.settings.PrivateMenuSettings;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/log/LogMenuSettings;", "", "menuSettings", "Lgg/aquatic/waves/menu/settings/PrivateMenuSettings;", "logSlots", "", "", "<init>", "(Lgg/aquatic/waves/menu/settings/PrivateMenuSettings;Ljava/util/Collection;)V", "getMenuSettings", "()Lgg/aquatic/waves/menu/settings/PrivateMenuSettings;", "getLogSlots", "()Ljava/util/Collection;", "plugin"}
)
public final class LogMenuSettings {
   @NotNull
   private final PrivateMenuSettings menuSettings;
   @NotNull
   private final Collection<Integer> logSlots;

   public LogMenuSettings(@NotNull PrivateMenuSettings var1, @NotNull Collection<Integer> var2) {
      Intrinsics.checkNotNullParameter(var1, "menuSettings");
      Intrinsics.checkNotNullParameter(var2, "logSlots");
      super();
      this.menuSettings = var1;
      this.logSlots = var2;
   }

   @NotNull
   public final PrivateMenuSettings getMenuSettings() {
      return this.menuSettings;
   }

   @NotNull
   public final Collection<Integer> getLogSlots() {
      return this.logSlots;
   }
}
