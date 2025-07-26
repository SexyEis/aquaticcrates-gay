package gg.aquatic.aquaticcrates.api;

import gg.aquatic.waves.libs.kotlin.Metadata;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/PluginSettings;", "", "useRewardsMenu", "", "logOpenings", "openingsThreshold", "", "<init>", "(ZZI)V", "getUseRewardsMenu", "()Z", "setUseRewardsMenu", "(Z)V", "getLogOpenings", "setLogOpenings", "getOpeningsThreshold", "()I", "setOpeningsThreshold", "(I)V", "api"}
)
public final class PluginSettings {
   private boolean useRewardsMenu;
   private boolean logOpenings;
   private int openingsThreshold;

   public PluginSettings(boolean var1, boolean var2, int var3) {
      this.useRewardsMenu = var1;
      this.logOpenings = var2;
      this.openingsThreshold = var3;
   }

   public final boolean getUseRewardsMenu() {
      return this.useRewardsMenu;
   }

   public final void setUseRewardsMenu(boolean var1) {
      this.useRewardsMenu = var1;
   }

   public final boolean getLogOpenings() {
      return this.logOpenings;
   }

   public final void setLogOpenings(boolean var1) {
      this.logOpenings = var1;
   }

   public final int getOpeningsThreshold() {
      return this.openingsThreshold;
   }

   public final void setOpeningsThreshold(int var1) {
      this.openingsThreshold = var1;
   }
}
