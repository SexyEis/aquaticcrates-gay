package gg.aquatic.aquaticcrates.api.player;

import gg.aquatic.aquaticcrates.api.reward.RewardContainer;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntries;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntriesKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.profile.AquaticPlayer;
import gg.aquatic.waves.profile.module.ProfileModuleEntry;
import java.sql.Connection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002+,B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0018J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u0017\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0018J\u001e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0018J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u000e\u0010\n\u001a\u00020\r2\u0006\u0010$\u001a\u00020\fJ\u0016\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\r2\u0006\u0010$\u001a\u00020\fJ\u0016\u0010'\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\r2\u0006\u0010$\u001a\u00020\fJ\u0016\u0010(\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\r2\u0006\u0010$\u001a\u00020\fJ\u0016\u0010)\u001a\u00020*2\u0006\u0010&\u001a\u00020\r2\u0006\u0010$\u001a\u00020\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR-\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R)\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\r0\u00120\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R)\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\r0\u00120\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016¨\u0006-"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/player/CrateProfileEntry;", "Lgg/aquatic/waves/profile/module/ProfileModuleEntry;", "aquaticPlayer", "Lgg/aquatic/waves/profile/AquaticPlayer;", "rewardContainer", "Lgg/aquatic/aquaticcrates/api/reward/RewardContainer;", "<init>", "(Lgg/aquatic/waves/profile/AquaticPlayer;Lgg/aquatic/aquaticcrates/api/reward/RewardContainer;)V", "getRewardContainer", "()Lgg/aquatic/aquaticcrates/api/reward/RewardContainer;", "balance", "Ljava/util/HashMap;", "", "", "Lgg/aquatic/waves/libs/kotlin/collections/HashMap;", "getBalance", "()Ljava/util/HashMap;", "newEntries", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lgg/aquatic/aquaticcrates/api/player/CrateProfileEntry$OpenHistoryEntry;", "getNewEntries", "()Ljava/util/concurrent/ConcurrentHashMap;", "openHistory", "Lgg/aquatic/aquaticcrates/api/player/CrateProfileEntry$HistoryType;", "getOpenHistory", "rewardHistory", "getRewardHistory", "historyType", "saveAndPrune", "", "crateId", "rewardId", "save", "connection", "Ljava/sql/Connection;", "id", "give", "amount", "take", "set", "has", "", "OpenHistoryEntry", "HistoryType", "api"}
)
@SourceDebugExtension({"SMAP\nCrateProfileEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrateProfileEntry.kt\ngg/aquatic/aquaticcrates/api/player/CrateProfileEntry\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n1#2:107\n*E\n"})
public final class CrateProfileEntry extends ProfileModuleEntry {
   @NotNull
   private final RewardContainer rewardContainer;
   @NotNull
   private final HashMap<String, Integer> balance;
   @NotNull
   private final ConcurrentHashMap<String, Collection<CrateProfileEntry.OpenHistoryEntry>> newEntries;
   @NotNull
   private final ConcurrentHashMap<String, ConcurrentHashMap<CrateProfileEntry.HistoryType, Integer>> openHistory;
   @NotNull
   private final ConcurrentHashMap<String, ConcurrentHashMap<CrateProfileEntry.HistoryType, Integer>> rewardHistory;

   public CrateProfileEntry(@NotNull AquaticPlayer var1, @NotNull RewardContainer var2) {
      Intrinsics.checkNotNullParameter(var1, "aquaticPlayer");
      Intrinsics.checkNotNullParameter(var2, "rewardContainer");
      super(var1);
      this.rewardContainer = var2;
      this.balance = new HashMap();
      this.newEntries = new ConcurrentHashMap();
      this.openHistory = new ConcurrentHashMap();
      this.rewardHistory = new ConcurrentHashMap();
   }

   @NotNull
   public final RewardContainer getRewardContainer() {
      return this.rewardContainer;
   }

   @NotNull
   public final HashMap<String, Integer> getBalance() {
      return this.balance;
   }

   @NotNull
   public final ConcurrentHashMap<String, Collection<CrateProfileEntry.OpenHistoryEntry>> getNewEntries() {
      return this.newEntries;
   }

   @NotNull
   public final ConcurrentHashMap<String, ConcurrentHashMap<CrateProfileEntry.HistoryType, Integer>> getOpenHistory() {
      return this.openHistory;
   }

   @NotNull
   public final ConcurrentHashMap<String, ConcurrentHashMap<CrateProfileEntry.HistoryType, Integer>> getRewardHistory() {
      return this.rewardHistory;
   }

   public final int openHistory(@NotNull CrateProfileEntry.HistoryType var1) {
      Intrinsics.checkNotNullParameter(var1, "historyType");
      int var2 = 0;
      Iterator var3 = ((Map)this.openHistory).entrySet().iterator();

      while(var3.hasNext()) {
         ConcurrentHashMap var4 = (ConcurrentHashMap)((Entry)var3.next()).getValue();
         Integer var10000 = (Integer)var4.get(var1);
         if (var10000 != null) {
            int var5 = ((Number)var10000).intValue();
            boolean var6 = false;
            var2 += var5;
         }
      }

      return var2;
   }

   public final int rewardHistory(@NotNull CrateProfileEntry.HistoryType var1) {
      Intrinsics.checkNotNullParameter(var1, "historyType");
      int var2 = 0;
      Iterator var3 = ((Map)this.rewardHistory).entrySet().iterator();

      while(var3.hasNext()) {
         ConcurrentHashMap var4 = (ConcurrentHashMap)((Entry)var3.next()).getValue();
         Integer var10000 = (Integer)var4.get(var1);
         if (var10000 != null) {
            int var5 = ((Number)var10000).intValue();
            boolean var6 = false;
            var2 += var5;
         }
      }

      return var2;
   }

   public final void saveAndPrune() {
      CrateProfileDriver.INSTANCE.getDriver().useConnection(CrateProfileEntry::saveAndPrune$lambda$2);
   }

   public final int openHistory(@NotNull String var1, @NotNull CrateProfileEntry.HistoryType var2) {
      Intrinsics.checkNotNullParameter(var1, "crateId");
      Intrinsics.checkNotNullParameter(var2, "historyType");
      int var3 = 0;
      ConcurrentHashMap var10000 = (ConcurrentHashMap)this.openHistory.get(var1);
      if (var10000 != null) {
         Integer var6 = (Integer)var10000.get(var2);
         if (var6 != null) {
            int var4 = ((Number)var6).intValue();
            boolean var5 = false;
            var3 += var4;
         }
      }

      return var3;
   }

   public final int rewardHistory(@NotNull String var1, @NotNull String var2, @NotNull CrateProfileEntry.HistoryType var3) {
      Intrinsics.checkNotNullParameter(var1, "crateId");
      Intrinsics.checkNotNullParameter(var2, "rewardId");
      Intrinsics.checkNotNullParameter(var3, "historyType");
      int var4 = 0;
      ConcurrentHashMap var10000 = (ConcurrentHashMap)this.rewardHistory.get(var1 + ":" + var2);
      if (var10000 == null) {
         return var4;
      } else {
         ConcurrentHashMap var5 = var10000;
         Integer var8 = (Integer)var5.get(var3);
         if (var8 != null) {
            int var6 = ((Number)var8).intValue();
            boolean var7 = false;
            var4 += var6;
         }

         return var4;
      }
   }

   public void save(@NotNull Connection var1) {
      Intrinsics.checkNotNullParameter(var1, "connection");

      try {
         CrateProfileDriver.INSTANCE.save(var1, this);
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   public final int balance(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Object var10000 = this.balance.getOrDefault(var1, 0);
      Intrinsics.checkNotNullExpressionValue(var10000, "getOrDefault(...)");
      return ((Number)var10000).intValue();
   }

   public final void give(int var1, @NotNull String var2) {
      Intrinsics.checkNotNullParameter(var2, "id");
      ((Map)this.balance).put(var2, this.balance(var2) + var1);
   }

   public final void take(int var1, @NotNull String var2) {
      Intrinsics.checkNotNullParameter(var2, "id");
      int var3 = this.balance(var2) - var1;
      if (var3 < 0) {
         ((Map)this.balance).put(var2, 0);
      } else {
         Integer var4 = var3;
         ((Map)this.balance).put(var2, var4);
      }

   }

   public final void set(int var1, @NotNull String var2) {
      Intrinsics.checkNotNullParameter(var2, "id");
      Integer var3 = var1;
      ((Map)this.balance).put(var2, var3);
   }

   public final boolean has(int var1, @NotNull String var2) {
      Intrinsics.checkNotNullParameter(var2, "id");
      return this.balance(var2) >= var1;
   }

   private static final Unit saveAndPrune$lambda$2(CrateProfileEntry var0, Connection var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$useConnection");
      CrateProfileDriver.INSTANCE.saveHistory$api(var1, var0);
      var0.newEntries.clear();
      return Unit.INSTANCE;
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/player/CrateProfileEntry$HistoryType;", "", "<init>", "(Ljava/lang/String;I)V", "ALLTIME", "MONTHLY", "WEEKLY", "DAILY", "api"}
   )
   public static enum HistoryType {
      ALLTIME,
      MONTHLY,
      WEEKLY,
      DAILY;

      // $FF: synthetic field
      private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

      @NotNull
      public static EnumEntries<CrateProfileEntry.HistoryType> getEntries() {
         return $ENTRIES;
      }

      // $FF: synthetic method
      private static final CrateProfileEntry.HistoryType[] $values() {
         CrateProfileEntry.HistoryType[] var0 = new CrateProfileEntry.HistoryType[]{ALLTIME, MONTHLY, WEEKLY, DAILY};
         return var0;
      }
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J%\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b`\tHÆ\u0003JC\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b`\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/player/CrateProfileEntry$OpenHistoryEntry;", "", "timestamp", "", "crateId", "", "rewardIds", "Ljava/util/HashMap;", "", "Lgg/aquatic/waves/libs/kotlin/collections/HashMap;", "<init>", "(JLjava/lang/String;Ljava/util/HashMap;)V", "getTimestamp", "()J", "getCrateId", "()Ljava/lang/String;", "getRewardIds", "()Ljava/util/HashMap;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "api"}
   )
   public static final class OpenHistoryEntry {
      private final long timestamp;
      @NotNull
      private final String crateId;
      @NotNull
      private final HashMap<String, Integer> rewardIds;

      public OpenHistoryEntry(long var1, @NotNull String var3, @NotNull HashMap<String, Integer> var4) {
         Intrinsics.checkNotNullParameter(var3, "crateId");
         Intrinsics.checkNotNullParameter(var4, "rewardIds");
         super();
         this.timestamp = var1;
         this.crateId = var3;
         this.rewardIds = var4;
      }

      public final long getTimestamp() {
         return this.timestamp;
      }

      @NotNull
      public final String getCrateId() {
         return this.crateId;
      }

      @NotNull
      public final HashMap<String, Integer> getRewardIds() {
         return this.rewardIds;
      }

      public final long component1() {
         return this.timestamp;
      }

      @NotNull
      public final String component2() {
         return this.crateId;
      }

      @NotNull
      public final HashMap<String, Integer> component3() {
         return this.rewardIds;
      }

      @NotNull
      public final CrateProfileEntry.OpenHistoryEntry copy(long var1, @NotNull String var3, @NotNull HashMap<String, Integer> var4) {
         Intrinsics.checkNotNullParameter(var3, "crateId");
         Intrinsics.checkNotNullParameter(var4, "rewardIds");
         return new CrateProfileEntry.OpenHistoryEntry(var1, var3, var4);
      }

      // $FF: synthetic method
      public static CrateProfileEntry.OpenHistoryEntry copy$default(CrateProfileEntry.OpenHistoryEntry var0, long var1, String var3, HashMap var4, int var5, Object var6) {
         if ((var5 & 1) != 0) {
            var1 = var0.timestamp;
         }

         if ((var5 & 2) != 0) {
            var3 = var0.crateId;
         }

         if ((var5 & 4) != 0) {
            var4 = var0.rewardIds;
         }

         return var0.copy(var1, var3, var4);
      }

      @NotNull
      public String toString() {
         return "OpenHistoryEntry(timestamp=" + this.timestamp + ", crateId=" + this.crateId + ", rewardIds=" + this.rewardIds + ")";
      }

      public int hashCode() {
         int var1 = Long.hashCode(this.timestamp);
         var1 = var1 * 31 + this.crateId.hashCode();
         var1 = var1 * 31 + this.rewardIds.hashCode();
         return var1;
      }

      public boolean equals(@Nullable Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof CrateProfileEntry.OpenHistoryEntry)) {
            return false;
         } else {
            CrateProfileEntry.OpenHistoryEntry var2 = (CrateProfileEntry.OpenHistoryEntry)var1;
            if (this.timestamp != var2.timestamp) {
               return false;
            } else if (!Intrinsics.areEqual(this.crateId, var2.crateId)) {
               return false;
            } else {
               return Intrinsics.areEqual(this.rewardIds, var2.rewardIds);
            }
         }
      }
   }
}
