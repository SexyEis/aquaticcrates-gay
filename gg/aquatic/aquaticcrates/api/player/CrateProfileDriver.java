package gg.aquatic.aquaticcrates.api.player;

import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.CrateHandler;
import gg.aquatic.aquaticcrates.api.reward.RewardContainer;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.data.DataDriver;
import gg.aquatic.waves.data.MySqlDriver;
import gg.aquatic.waves.data.SQLiteDriver;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.collections.MapsKt;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntries;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntriesKt;
import gg.aquatic.waves.libs.kotlin.jdk7.AutoCloseableKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.module.WaveModules;
import gg.aquatic.waves.profile.AquaticPlayer;
import gg.aquatic.waves.profile.ProfilesModule;
import gg.aquatic.waves.util.item.ItemStackExtKt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001+B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\fJ\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u001d\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJB\u0010\u001c\u001a>\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001e0\u001e\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001e0\u001e0\u001dJL\u0010\"\u001a\u001a\u0012\u0004\u0012\u00020!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020$0\u001d0#2\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\u001f2\b\u0010(\u001a\u0004\u0018\u00010\u001f2\b\u0010)\u001a\u0004\u0018\u00010*R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006,"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/player/CrateProfileDriver;", "", "<init>", "()V", "driver", "Lgg/aquatic/waves/data/DataDriver;", "getDriver", "()Lgg/aquatic/waves/data/DataDriver;", "isSQLite", "", "isMySQL", "get", "Lgg/aquatic/aquaticcrates/api/player/CrateProfileEntry;", "aquaticPlayer", "Lgg/aquatic/waves/profile/AquaticPlayer;", "loadKeys", "", "entry", "save", "connection", "Ljava/sql/Connection;", "saveKeys", "saveRewardContainer", "saveHistory", "profileEntry", "saveHistory$api", "loadRewardContainer", "loadHistory", "loadGlobalHistory", "Lgg/aquatic/waves/libs/kotlin/Pair;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lgg/aquatic/aquaticcrates/api/player/CrateProfileEntry$HistoryType;", "", "loadLogEntries", "", "Lgg/aquatic/aquaticcrates/api/player/CrateProfileEntry$OpenHistoryEntry;", "offset", "limit", "playerName", "crateId", "sorting", "Lgg/aquatic/aquaticcrates/api/player/CrateProfileDriver$Sorting;", "Sorting", "api"}
)
@SourceDebugExtension({"SMAP\nCrateProfileDriver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrateProfileDriver.kt\ngg/aquatic/aquaticcrates/api/player/CrateProfileDriver\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 5 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,500:1\n478#2:501\n424#2:502\n1252#3,4:503\n216#4,2:507\n126#4:509\n153#4,3:510\n72#5,2:513\n72#5,2:516\n72#5,2:519\n72#5,2:522\n72#5,2:525\n72#5,2:528\n72#5,2:531\n72#5,2:534\n72#5,2:537\n72#5,2:540\n72#5,2:543\n72#5,2:546\n72#5,2:549\n72#5,2:552\n72#5,2:555\n72#5,2:558\n1#6:515\n1#6:518\n1#6:521\n1#6:524\n1#6:527\n1#6:530\n1#6:533\n1#6:536\n1#6:539\n1#6:542\n1#6:545\n1#6:548\n1#6:551\n1#6:554\n1#6:557\n1#6:560\n*S KotlinDebug\n*F\n+ 1 CrateProfileDriver.kt\ngg/aquatic/aquaticcrates/api/player/CrateProfileDriver\n*L\n106#1:501\n106#1:502\n106#1:503,4\n127#1:507,2\n198#1:509\n198#1:510,3\n285#1:513,2\n286#1:516,2\n287#1:519,2\n288#1:522,2\n317#1:525,2\n318#1:528,2\n319#1:531,2\n320#1:534,2\n355#1:537,2\n356#1:540,2\n357#1:543,2\n358#1:546,2\n387#1:549,2\n388#1:552,2\n389#1:555,2\n390#1:558,2\n285#1:515\n286#1:518\n287#1:521\n288#1:524\n317#1:527\n318#1:530\n319#1:533\n320#1:536\n355#1:539\n356#1:542\n357#1:545\n358#1:548\n387#1:551\n388#1:554\n389#1:557\n390#1:560\n*E\n"})
public final class CrateProfileDriver {
   @NotNull
   public static final CrateProfileDriver INSTANCE = new CrateProfileDriver();
   @NotNull
   private static final DataDriver driver;

   private CrateProfileDriver() {
   }

   @NotNull
   public final DataDriver getDriver() {
      return driver;
   }

   public final boolean isSQLite() {
      return driver instanceof SQLiteDriver;
   }

   public final boolean isMySQL() {
      return !this.isSQLite();
   }

   @NotNull
   public final CrateProfileEntry get(@NotNull AquaticPlayer var1) {
      Intrinsics.checkNotNullParameter(var1, "aquaticPlayer");
      CrateProfileEntry var2 = new CrateProfileEntry(var1, new RewardContainer());
      this.loadKeys(var2);
      this.loadHistory(var2);
      this.loadRewardContainer(var2);
      return var2;
   }

   public final void loadKeys(@NotNull CrateProfileEntry var1) {
      Intrinsics.checkNotNullParameter(var1, "entry");
      String var2 = "SELECT * FROM aquaticcrates_keys WHERE id = ?";
      driver.executeQuery(var2, CrateProfileDriver::loadKeys$lambda$0, CrateProfileDriver::loadKeys$lambda$1);
   }

   public final void save(@NotNull Connection var1, @NotNull CrateProfileEntry var2) {
      Intrinsics.checkNotNullParameter(var1, "connection");
      Intrinsics.checkNotNullParameter(var2, "entry");
      this.saveKeys(var1, var2);
      this.saveHistory$api(var1, var2);
      this.saveRewardContainer(var1, var2);
   }

   private final void saveKeys(Connection var1, CrateProfileEntry var2) {
      AutoCloseable var3 = (AutoCloseable)var1.prepareStatement("REPLACE INTO aquaticcrates_keys VALUES (?, ?, ?)");
      Throwable var4 = null;

      try {
         PreparedStatement var5 = (PreparedStatement)var3;
         boolean var6 = false;
         Iterator var7 = ((Map)var2.getBalance()).entrySet().iterator();

         while(var7.hasNext()) {
            Entry var8 = (Entry)var7.next();
            String var9 = (String)var8.getKey();
            int var10 = ((Number)var8.getValue()).intValue();
            var5.setInt(1, var2.getAquaticPlayer().getIndex());
            var5.setString(2, var9);
            var5.setInt(3, var10);
            var5.addBatch();
         }

         int[] var15 = var5.executeBatch();
      } catch (Throwable var13) {
         var4 = var13;
         throw var13;
      } finally {
         AutoCloseableKt.closeFinally(var3, var4);
      }
   }

   private final void saveRewardContainer(Connection var1, CrateProfileEntry var2) {
      try {
         boolean var3 = this.isSQLite();
         String var4 = var3 ? "INSERT OR IGNORE INTO items (item_data) VALUES (?)" : "INSERT IGNORE INTO items (item_data) VALUES (?)";
         String var5 = "SELECT item_id FROM items WHERE item_data = ?";
         String var6 = var3 ? "INSERT OR REPLACE INTO player_items (player_id, item_id, quantity) VALUES (?, ?, ?)" : "\n        INSERT INTO player_items (player_id, item_id, quantity)\n        VALUES (?, ?, ?)\n        ON DUPLICATE KEY UPDATE quantity = VALUES(quantity)\n        ";
         String var7 = "SELECT item_id FROM player_items WHERE player_id = ?";
         String var8 = "DELETE FROM player_items WHERE player_id = ? AND item_id = ?";
         RewardContainer var9 = var2.getRewardContainer();
         Map var11 = (Map)var9.getItems();
         boolean var12 = false;
         Map var14 = (Map)(new LinkedHashMap(MapsKt.mapCapacity(var11.size())));
         boolean var15 = false;
         Iterable var16 = (Iterable)var11.entrySet();
         boolean var17 = false;
         Iterator var18 = var16.iterator();

         boolean var26;
         while(var18.hasNext()) {
            Object var19 = var18.next();
            Entry var20 = (Entry)var19;
            boolean var21 = false;
            ItemStack var22 = (ItemStack)var20.getKey();
            String var10001 = ItemStackExtKt.encode(var22);
            Entry var23 = (Entry)var19;
            String var24 = var10001;
            var26 = false;
            Object var177 = var23.getValue();
            var14.put(var24, var177);
         }

         Map var10 = var14;
         AutoCloseable var167 = (AutoCloseable)var1.prepareStatement(var4);
         Throwable var168 = null;

         try {
            PreparedStatement var13 = (PreparedStatement)var167;
            boolean var170 = false;
            AutoCloseable var171 = (AutoCloseable)var1.prepareStatement(var5);
            Throwable var172 = null;

            try {
               PreparedStatement var173 = (PreparedStatement)var171;
               boolean var175 = false;
               AutoCloseable var176 = (AutoCloseable)var1.prepareStatement(var6);
               Throwable var178 = null;

               try {
                  PreparedStatement var179 = (PreparedStatement)var176;
                  boolean var181 = false;
                  AutoCloseable var182 = (AutoCloseable)var1.prepareStatement(var7);
                  Throwable var183 = null;

                  try {
                     PreparedStatement var25 = (PreparedStatement)var182;
                     var26 = false;
                     AutoCloseable var27 = (AutoCloseable)var1.prepareStatement(var8);
                     Throwable var28 = null;

                     try {
                        PreparedStatement var29 = (PreparedStatement)var27;
                        boolean var30 = false;
                        Set var31 = (Set)(new LinkedHashSet());
                        var25.setInt(1, var2.getAquaticPlayer().getIndex());
                        AutoCloseable var32 = (AutoCloseable)var25.executeQuery();
                        Throwable var33 = null;

                        try {
                           ResultSet var34 = (ResultSet)var32;
                           boolean var35 = false;

                           while(var34.next()) {
                              var31.add(var34.getInt("item_id"));
                           }

                           Unit var188 = Unit.INSTANCE;
                        } catch (Throwable var154) {
                           var33 = var154;
                           throw var154;
                        } finally {
                           AutoCloseableKt.closeFinally(var32, var33);
                        }

                        Set var186 = (Set)(new LinkedHashSet());
                        boolean var189 = false;
                        Iterator var191 = var10.entrySet().iterator();

                        while(true) {
                           if (!var191.hasNext()) {
                              Iterator var187 = var31.iterator();

                              while(var187.hasNext()) {
                                 int var190 = ((Number)var187.next()).intValue();
                                 if (!var186.contains(var190)) {
                                    var29.setInt(1, var2.getAquaticPlayer().getIndex());
                                    var29.setInt(2, var190);
                                    var29.executeUpdate();
                                 }
                              }

                              Unit var185 = Unit.INSTANCE;
                              break;
                           }

                           Entry var36 = (Entry)var191.next();
                           boolean var38 = false;
                           String var39 = (String)var36.getKey();
                           int var40 = ((Number)var36.getValue()).intValue();
                           var13.setString(1, var39);
                           var13.executeUpdate();
                           Integer var41 = null;
                           var173.setString(1, var39);
                           AutoCloseable var42 = (AutoCloseable)var173.executeQuery();
                           Throwable var43 = null;

                           boolean var45;
                           try {
                              ResultSet var44 = (ResultSet)var42;
                              var45 = false;
                              if (var44.next()) {
                                 var41 = var44.getInt("item_id");
                              }

                              Unit var192 = Unit.INSTANCE;
                           } catch (Throwable var152) {
                              var43 = var152;
                              throw var152;
                           } finally {
                              AutoCloseableKt.closeFinally(var42, var43);
                           }

                           Unit var10000;
                           if (var41 != null) {
                              int var193 = ((Number)var41).intValue();
                              var45 = false;
                              var179.setInt(1, var2.getAquaticPlayer().getIndex());
                              var179.setInt(2, var193);
                              var179.setInt(3, var40);
                              var179.executeUpdate();
                              var186.add(var193);
                              var10000 = Unit.INSTANCE;
                              var10000 = Unit.INSTANCE;
                           } else {
                              var10000 = null;
                           }
                        }
                     } catch (Throwable var156) {
                        var28 = var156;
                        throw var156;
                     } finally {
                        AutoCloseableKt.closeFinally(var27, var28);
                     }

                     Unit var184 = Unit.INSTANCE;
                  } catch (Throwable var158) {
                     var183 = var158;
                     throw var158;
                  } finally {
                     AutoCloseableKt.closeFinally(var182, var183);
                  }

                  Unit var180 = Unit.INSTANCE;
               } catch (Throwable var160) {
                  var178 = var160;
                  throw var160;
               } finally {
                  AutoCloseableKt.closeFinally(var176, var178);
               }

               Unit var174 = Unit.INSTANCE;
            } catch (Throwable var162) {
               var172 = var162;
               throw var162;
            } finally {
               AutoCloseableKt.closeFinally(var171, var172);
            }

            Unit var169 = Unit.INSTANCE;
         } catch (Throwable var164) {
            var168 = var164;
            throw var164;
         } finally {
            AutoCloseableKt.closeFinally(var167, var168);
         }
      } catch (Exception var166) {
         var166.printStackTrace();
      }

   }

   public final void saveHistory$api(@NotNull Connection var1, @NotNull CrateProfileEntry var2) {
      Intrinsics.checkNotNullParameter(var1, "connection");
      Intrinsics.checkNotNullParameter(var2, "profileEntry");
      String var3 = "INSERT INTO aquaticcrates_opens (user_id, open_timestamp, crate_id) VALUES (?, ?, ?);";
      String var4 = "INSERT INTO aquaticcrates_rewards (open_id, reward_id, amount) VALUES (?, ?, ?);";
      List var5 = (List)(new ArrayList());
      AutoCloseable var6 = (AutoCloseable)var1.prepareStatement(var3, 1);
      Throwable var7 = null;

      PreparedStatement var8;
      boolean var9;
      Iterator var10;
      Iterator var14;
      try {
         var8 = (PreparedStatement)var6;
         var9 = false;
         var10 = ((Map)var2.getNewEntries()).entrySet().iterator();

         while(var10.hasNext()) {
            Collection var11 = (Collection)((Entry)var10.next()).getValue();
            Iterator var12 = var11.iterator();

            while(var12.hasNext()) {
               CrateProfileEntry.OpenHistoryEntry var13 = (CrateProfileEntry.OpenHistoryEntry)var12.next();
               var8.setInt(1, var2.getAquaticPlayer().getIndex());
               var8.setLong(2, var13.getTimestamp());
               var8.setString(3, var13.getCrateId());
               var8.addBatch();
            }
         }

         var8.executeBatch();
         ResultSet var42 = var8.getGeneratedKeys();
         var14 = ((Map)var2.getNewEntries()).entrySet().iterator();

         label255:
         while(var14.hasNext()) {
            Collection var44 = (Collection)((Entry)var14.next()).getValue();
            Iterator var46 = var44.iterator();

            while(true) {
               CrateProfileEntry.OpenHistoryEntry var15;
               do {
                  if (!var46.hasNext()) {
                     continue label255;
                  }

                  var15 = (CrateProfileEntry.OpenHistoryEntry)var46.next();
               } while(!var42.next());

               int var16 = var42.getInt(1);
               Map var17 = (Map)var15.getRewardIds();
               boolean var18 = false;
               Collection var20 = (Collection)(new ArrayList(var17.size()));
               boolean var21 = false;
               Iterator var22 = var17.entrySet().iterator();

               while(var22.hasNext()) {
                  Entry var23 = (Entry)var22.next();
                  boolean var26 = false;
                  var20.add(TuplesKt.to(var23.getKey(), var23.getValue()));
               }

               List var27 = (List)var20;
               var5.add(TuplesKt.to(var16, var27));
            }
         }

         Unit var40 = Unit.INSTANCE;
      } catch (Throwable var38) {
         var7 = var38;
         throw var38;
      } finally {
         AutoCloseableKt.closeFinally(var6, var7);
      }

      var6 = (AutoCloseable)var1.prepareStatement(var4);
      var7 = null;

      try {
         var8 = (PreparedStatement)var6;
         var9 = false;
         var10 = var5.iterator();

         label220:
         while(true) {
            if (var10.hasNext()) {
               Pair var43 = (Pair)var10.next();
               int var45 = ((Number)var43.component1()).intValue();
               List var47 = (List)var43.component2();
               var14 = var47.iterator();

               while(true) {
                  if (!var14.hasNext()) {
                     continue label220;
                  }

                  Pair var48 = (Pair)var14.next();
                  String var49 = (String)var48.component1();
                  int var50 = ((Number)var48.component2()).intValue();
                  var8.setInt(1, var45);
                  var8.setString(2, var49);
                  var8.setInt(3, var50);
                  var8.addBatch();
               }
            }

            int[] var41 = var8.executeBatch();
            return;
         }
      } catch (Throwable var36) {
         var7 = var36;
         throw var36;
      } finally {
         AutoCloseableKt.closeFinally(var6, var7);
      }
   }

   public final void loadRewardContainer(@NotNull CrateProfileEntry var1) {
      Intrinsics.checkNotNullParameter(var1, "entry");

      try {
         String var2 = "\n            SELECT i.item_data, pi.quantity\n            FROM player_items pi\n            JOIN items i ON pi.item_id = i.item_id\n            WHERE pi.player_id = ?\n        ";
         driver.useConnection(CrateProfileDriver::loadRewardContainer$lambda$18);
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   public final void loadHistory(@NotNull CrateProfileEntry var1) {
      Intrinsics.checkNotNullParameter(var1, "entry");
      String var2 = driver instanceof MySqlDriver ? "SELECT crate_id,        COUNT(*) AS all_time,        SUM(CASE WHEN open_timestamp >= UNIX_TIMESTAMP(DATE_SUB(NOW(), INTERVAL 1 DAY)) THEN 1 ELSE 0 END) AS daily,        SUM(CASE WHEN open_timestamp >= UNIX_TIMESTAMP(DATE_SUB(NOW(), INTERVAL 7 DAY)) THEN 1 ELSE 0 END) AS weekly,        SUM(CASE WHEN open_timestamp >= UNIX_TIMESTAMP(DATE_SUB(NOW(), INTERVAL 1 MONTH)) THEN 1 ELSE 0 END) AS monthly FROM aquaticcrates_opens GROUP BY crate_id;" : "SELECT crate_id,        COUNT(*) AS all_time,        SUM(CASE WHEN open_timestamp >= strftime('%s', 'now', '-1 day') THEN 1 ELSE 0 END) AS daily,        SUM(CASE WHEN open_timestamp >= strftime('%s', 'now', '-7 days') THEN 1 ELSE 0 END) AS weekly,        SUM(CASE WHEN open_timestamp >= strftime('%s', 'now', '-1 month') THEN 1 ELSE 0 END) AS monthly FROM aquaticcrates_opens GROUP BY crate_id;";
      driver.executeQuery(var2, CrateProfileDriver::loadHistory$lambda$19, CrateProfileDriver::loadHistory$lambda$24);
      String var3 = driver instanceof MySqlDriver ? "SELECT CONCAT(o.crate_id, ':', r.reward_id) AS crate_reward_id,        COUNT(*) AS all_time,        SUM(CASE WHEN o.open_timestamp >= UNIX_TIMESTAMP(DATE_SUB(NOW(), INTERVAL 1 DAY)) THEN 1 ELSE 0 END) AS daily,        SUM(CASE WHEN o.open_timestamp >= UNIX_TIMESTAMP(DATE_SUB(NOW(), INTERVAL 7 DAY)) THEN 1 ELSE 0 END) AS weekly,        SUM(CASE WHEN o.open_timestamp >= UNIX_TIMESTAMP(DATE_SUB(NOW(), INTERVAL 1 MONTH)) THEN 1 ELSE 0 END) AS monthly FROM aquaticcrates_opens o          JOIN aquaticcrates_rewards r ON o.id = r.open_id GROUP BY crate_reward_id;" : "SELECT o.crate_id || ':' || r.reward_id AS crate_reward_id,        COUNT(*) AS all_time,        SUM(CASE WHEN o.open_timestamp >= strftime('%s', 'now', '-1 day') THEN 1 ELSE 0 END) AS daily,        SUM(CASE WHEN o.open_timestamp >= strftime('%s', 'now', '-7 days') THEN 1 ELSE 0 END) AS weekly,        SUM(CASE WHEN o.open_timestamp >= strftime('%s', 'now', '-1 month') THEN 1 ELSE 0 END) AS monthly FROM aquaticcrates_opens o          JOIN aquaticcrates_rewards r ON o.id = r.open_id GROUP BY crate_reward_id;";
      driver.executeQuery(var3, CrateProfileDriver::loadHistory$lambda$25, CrateProfileDriver::loadHistory$lambda$30);
   }

   @NotNull
   public final Pair<ConcurrentHashMap<String, ConcurrentHashMap<CrateProfileEntry.HistoryType, Integer>>, ConcurrentHashMap<String, ConcurrentHashMap<CrateProfileEntry.HistoryType, Integer>>> loadGlobalHistory() {
      ConcurrentHashMap var1 = new ConcurrentHashMap();
      ConcurrentHashMap var2 = new ConcurrentHashMap();
      String var3 = driver instanceof MySqlDriver ? "SELECT crate_id,        COUNT(*) AS all_time,        SUM(CASE WHEN open_timestamp >= UNIX_TIMESTAMP(DATE_SUB(NOW(), INTERVAL 1 DAY)) THEN 1 ELSE 0 END) AS daily,        SUM(CASE WHEN open_timestamp >= UNIX_TIMESTAMP(DATE_SUB(NOW(), INTERVAL 7 DAY)) THEN 1 ELSE 0 END) AS weekly,        SUM(CASE WHEN open_timestamp >= UNIX_TIMESTAMP(DATE_SUB(NOW(), INTERVAL 1 MONTH)) THEN 1 ELSE 0 END) AS monthly FROM aquaticcrates_opens GROUP BY crate_id;" : "SELECT crate_id,        COUNT(*) AS all_time,        SUM(CASE WHEN open_timestamp >= strftime('%s', 'now', '-1 day') THEN 1 ELSE 0 END) AS daily,        SUM(CASE WHEN open_timestamp >= strftime('%s', 'now', '-7 days') THEN 1 ELSE 0 END) AS weekly,        SUM(CASE WHEN open_timestamp >= strftime('%s', 'now', '-1 month') THEN 1 ELSE 0 END) AS monthly FROM aquaticcrates_opens GROUP BY crate_id;";
      driver.executeQuery(var3, CrateProfileDriver::loadGlobalHistory$lambda$31, CrateProfileDriver::loadGlobalHistory$lambda$36);
      String var4 = driver instanceof MySqlDriver ? "SELECT CONCAT(o.crate_id, ':', r.reward_id) AS crate_reward_id,        COUNT(*) AS all_time,        SUM(CASE WHEN o.open_timestamp >= UNIX_TIMESTAMP(DATE_SUB(NOW(), INTERVAL 1 DAY)) THEN 1 ELSE 0 END) AS daily,        SUM(CASE WHEN o.open_timestamp >= UNIX_TIMESTAMP(DATE_SUB(NOW(), INTERVAL 7 DAY)) THEN 1 ELSE 0 END) AS weekly,        SUM(CASE WHEN o.open_timestamp >= UNIX_TIMESTAMP(DATE_SUB(NOW(), INTERVAL 1 MONTH)) THEN 1 ELSE 0 END) AS monthly FROM aquaticcrates_opens o          JOIN aquaticcrates_rewards r ON o.id = r.open_id GROUP BY crate_reward_id;" : "SELECT o.crate_id || ':' || r.reward_id AS crate_reward_id,        COUNT(*) AS all_time,        SUM(CASE WHEN o.open_timestamp >= strftime('%s', 'now', '-1 day') THEN 1 ELSE 0 END) AS daily,        SUM(CASE WHEN o.open_timestamp >= strftime('%s', 'now', '-7 days') THEN 1 ELSE 0 END) AS weekly,        SUM(CASE WHEN o.open_timestamp >= strftime('%s', 'now', '-1 month') THEN 1 ELSE 0 END) AS monthly FROM aquaticcrates_opens o          JOIN aquaticcrates_rewards r ON o.id = r.open_id GROUP BY crate_reward_id;";
      driver.executeQuery(var4, CrateProfileDriver::loadGlobalHistory$lambda$37, CrateProfileDriver::loadGlobalHistory$lambda$42);
      return TuplesKt.to(var1, var2);
   }

   @NotNull
   public final Map<Integer, Pair<String, CrateProfileEntry.OpenHistoryEntry>> loadLogEntries(int var1, int var2, @Nullable String var3, @Nullable String var4, @Nullable CrateProfileDriver.Sorting var5) {
      Map var6 = (Map)(new LinkedHashMap());

      try {
         StringBuilder var7 = new StringBuilder("SELECT o.id AS open_id, o.user_id, o.open_timestamp, o.crate_id, r.reward_id, r.amount, p.username\nFROM aquaticcrates_opens o\nLEFT JOIN aquaticcrates_rewards r ON o.id = r.open_id\nLEFT JOIN aquaticprofiles p ON o.user_id = p.id");
         List var8 = (List)(new ArrayList());
         if (var3 != null) {
            var8.add("p.username = ?");
         }

         if (var4 != null) {
            var8.add("o.crate_id = ?");
         }

         if (!((Collection)var8).isEmpty()) {
            var7.append(" WHERE ").append(CollectionsKt.joinToString$default((Iterable)var8, (CharSequence)" AND ", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null));
         }

         switch(var5 == null ? -1 : CrateProfileDriver.WhenMappings.$EnumSwitchMapping$0[var5.ordinal()]) {
         case 1:
            var7.append(" ORDER BY o.open_timestamp DESC");
            break;
         case 2:
            var7.append(" ORDER BY o.open_timestamp ASC");
            break;
         default:
            var7.append(" ORDER BY o.open_timestamp DESC");
         }

         var7.append(" LIMIT ? OFFSET ?");
         driver.useConnection(CrateProfileDriver::loadLogEntries$lambda$44);
      } catch (Exception var9) {
         var9.printStackTrace();
      }

      return var6;
   }

   private static final Unit loadKeys$lambda$0(CrateProfileEntry var0, PreparedStatement var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$executeQuery");
      var1.setInt(1, var0.getAquaticPlayer().getIndex());
      return Unit.INSTANCE;
   }

   private static final Unit loadKeys$lambda$1(CrateProfileEntry var0, ResultSet var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$executeQuery");

      while(var1.next()) {
         String var2 = var1.getString("key_id");
         int var3 = var1.getInt("amount");
         if ((Crate)CrateHandler.INSTANCE.getCrates().get(var2) != null) {
            Integer var4 = var3;
            ((Map)var0.getBalance()).put(var2, var4);
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit loadRewardContainer$lambda$18(String var0, CrateProfileEntry var1, Connection var2) {
      Intrinsics.checkNotNullParameter(var2, "$this$useConnection");
      AutoCloseable var3 = (AutoCloseable)var2.prepareStatement(var0);
      Throwable var4 = null;

      try {
         PreparedStatement var5 = (PreparedStatement)var3;
         boolean var6 = false;
         var5.setInt(1, var1.getAquaticPlayer().getIndex());
         AutoCloseable var7 = (AutoCloseable)var5.executeQuery();
         Throwable var8 = null;

         try {
            ResultSet var9 = (ResultSet)var7;
            boolean var10 = false;

            while(true) {
               if (!var9.next()) {
                  Unit var28 = Unit.INSTANCE;
                  break;
               }

               String var11 = var9.getString("item_data");
               int var12 = var9.getInt("quantity");
               Intrinsics.checkNotNull(var11);
               ItemStack var13 = ItemStackExtKt.decodeToItemStack(var11);
               Integer var14 = var12;
               ((Map)var1.getRewardContainer().getItems()).put(var13, var14);
            }
         } catch (Throwable var23) {
            var8 = var23;
            throw var23;
         } finally {
            AutoCloseableKt.closeFinally(var7, var8);
         }

         Unit var27 = Unit.INSTANCE;
      } catch (Throwable var25) {
         var4 = var25;
         throw var25;
      } finally {
         AutoCloseableKt.closeFinally(var3, var4);
      }

      return Unit.INSTANCE;
   }

   private static final Unit loadHistory$lambda$19(PreparedStatement var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$executeQuery");
      return Unit.INSTANCE;
   }

   private static final Unit loadHistory$lambda$24(CrateProfileEntry var0, ResultSet var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$executeQuery");

      while(var1.next()) {
         String var2 = var1.getString("crate_id");
         int var3 = var1.getInt("all_time");
         int var4 = var1.getInt("daily");
         int var5 = var1.getInt("weekly");
         int var6 = var1.getInt("monthly");
         ConcurrentMap var8 = (ConcurrentMap)var0.getOpenHistory();
         boolean var9 = false;
         Object var10000 = var8.get(var2);
         boolean var10;
         ConcurrentHashMap var11;
         boolean var12;
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         Map var7 = (Map)var10000;
         CrateProfileEntry.HistoryType var13 = CrateProfileEntry.HistoryType.ALLTIME;
         Integer var14 = var3;
         var7.put(var13, var14);
         var8 = (ConcurrentMap)var0.getOpenHistory();
         var9 = false;
         var10000 = var8.get(var2);
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         var7 = (Map)var10000;
         var13 = CrateProfileEntry.HistoryType.DAILY;
         var14 = var4;
         var7.put(var13, var14);
         var8 = (ConcurrentMap)var0.getOpenHistory();
         var9 = false;
         var10000 = var8.get(var2);
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         var7 = (Map)var10000;
         var13 = CrateProfileEntry.HistoryType.WEEKLY;
         var14 = var5;
         var7.put(var13, var14);
         var8 = (ConcurrentMap)var0.getOpenHistory();
         var9 = false;
         var10000 = var8.get(var2);
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         var7 = (Map)var10000;
         var13 = CrateProfileEntry.HistoryType.MONTHLY;
         var14 = var6;
         var7.put(var13, var14);
      }

      return Unit.INSTANCE;
   }

   private static final Unit loadHistory$lambda$25(PreparedStatement var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$executeQuery");
      return Unit.INSTANCE;
   }

   private static final Unit loadHistory$lambda$30(CrateProfileEntry var0, ResultSet var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$executeQuery");

      while(var1.next()) {
         String var2 = var1.getString("crate_reward_id");
         int var3 = var1.getInt("all_time");
         int var4 = var1.getInt("daily");
         int var5 = var1.getInt("weekly");
         int var6 = var1.getInt("monthly");
         ConcurrentMap var8 = (ConcurrentMap)var0.getRewardHistory();
         boolean var9 = false;
         Object var10000 = var8.get(var2);
         boolean var10;
         ConcurrentHashMap var11;
         boolean var12;
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         Map var7 = (Map)var10000;
         CrateProfileEntry.HistoryType var13 = CrateProfileEntry.HistoryType.ALLTIME;
         Integer var14 = var3;
         var7.put(var13, var14);
         var8 = (ConcurrentMap)var0.getRewardHistory();
         var9 = false;
         var10000 = var8.get(var2);
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         var7 = (Map)var10000;
         var13 = CrateProfileEntry.HistoryType.DAILY;
         var14 = var4;
         var7.put(var13, var14);
         var8 = (ConcurrentMap)var0.getRewardHistory();
         var9 = false;
         var10000 = var8.get(var2);
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         var7 = (Map)var10000;
         var13 = CrateProfileEntry.HistoryType.WEEKLY;
         var14 = var5;
         var7.put(var13, var14);
         var8 = (ConcurrentMap)var0.getRewardHistory();
         var9 = false;
         var10000 = var8.get(var2);
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         var7 = (Map)var10000;
         var13 = CrateProfileEntry.HistoryType.MONTHLY;
         var14 = var6;
         var7.put(var13, var14);
      }

      return Unit.INSTANCE;
   }

   private static final Unit loadGlobalHistory$lambda$31(PreparedStatement var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$executeQuery");
      return Unit.INSTANCE;
   }

   private static final Unit loadGlobalHistory$lambda$36(ConcurrentHashMap var0, ResultSet var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$executeQuery");

      while(var1.next()) {
         String var2 = var1.getString("crate_id");
         int var3 = var1.getInt("all_time");
         int var4 = var1.getInt("daily");
         int var5 = var1.getInt("weekly");
         int var6 = var1.getInt("monthly");
         ConcurrentMap var8 = (ConcurrentMap)var0;
         boolean var9 = false;
         Object var10000 = var8.get(var2);
         boolean var10;
         ConcurrentHashMap var11;
         boolean var12;
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         Map var7 = (Map)var10000;
         CrateProfileEntry.HistoryType var13 = CrateProfileEntry.HistoryType.ALLTIME;
         Integer var14 = var3;
         var7.put(var13, var14);
         var8 = (ConcurrentMap)var0;
         var9 = false;
         var10000 = var8.get(var2);
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         var7 = (Map)var10000;
         var13 = CrateProfileEntry.HistoryType.DAILY;
         var14 = var4;
         var7.put(var13, var14);
         var8 = (ConcurrentMap)var0;
         var9 = false;
         var10000 = var8.get(var2);
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         var7 = (Map)var10000;
         var13 = CrateProfileEntry.HistoryType.WEEKLY;
         var14 = var5;
         var7.put(var13, var14);
         var8 = (ConcurrentMap)var0;
         var9 = false;
         var10000 = var8.get(var2);
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         var7 = (Map)var10000;
         var13 = CrateProfileEntry.HistoryType.MONTHLY;
         var14 = var6;
         var7.put(var13, var14);
      }

      return Unit.INSTANCE;
   }

   private static final Unit loadGlobalHistory$lambda$37(PreparedStatement var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$executeQuery");
      return Unit.INSTANCE;
   }

   private static final Unit loadGlobalHistory$lambda$42(ConcurrentHashMap var0, ResultSet var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$executeQuery");

      while(var1.next()) {
         String var2 = var1.getString("crate_reward_id");
         int var3 = var1.getInt("all_time");
         int var4 = var1.getInt("daily");
         int var5 = var1.getInt("weekly");
         int var6 = var1.getInt("monthly");
         ConcurrentMap var8 = (ConcurrentMap)var0;
         boolean var9 = false;
         Object var10000 = var8.get(var2);
         boolean var10;
         ConcurrentHashMap var11;
         boolean var12;
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         Map var7 = (Map)var10000;
         CrateProfileEntry.HistoryType var13 = CrateProfileEntry.HistoryType.ALLTIME;
         Integer var14 = var3;
         var7.put(var13, var14);
         var8 = (ConcurrentMap)var0;
         var9 = false;
         var10000 = var8.get(var2);
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         var7 = (Map)var10000;
         var13 = CrateProfileEntry.HistoryType.DAILY;
         var14 = var4;
         var7.put(var13, var14);
         var8 = (ConcurrentMap)var0;
         var9 = false;
         var10000 = var8.get(var2);
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         var7 = (Map)var10000;
         var13 = CrateProfileEntry.HistoryType.WEEKLY;
         var14 = var5;
         var7.put(var13, var14);
         var8 = (ConcurrentMap)var0;
         var9 = false;
         var10000 = var8.get(var2);
         if (var10000 == null) {
            var10 = false;
            var11 = new ConcurrentHashMap();
            var12 = false;
            var10000 = var8.putIfAbsent(var2, var11);
            if (var10000 == null) {
               var10000 = var11;
            }
         }

         Intrinsics.checkNotNullExpressionValue(var10000, "getOrPut(...)");
         var7 = (Map)var10000;
         var13 = CrateProfileEntry.HistoryType.MONTHLY;
         var14 = var6;
         var7.put(var13, var14);
      }

      return Unit.INSTANCE;
   }

   private static final Unit loadLogEntries$lambda$44(StringBuilder var0, String var1, String var2, int var3, int var4, Map var5, Connection var6) {
      Intrinsics.checkNotNullParameter(var6, "$this$useConnection");
      AutoCloseable var7 = (AutoCloseable)var6.prepareStatement(var0.toString());
      Throwable var8 = null;

      try {
         PreparedStatement var9 = (PreparedStatement)var7;
         boolean var10 = false;
         int var11 = 1;
         if (var1 != null) {
            var9.setString(var11++, var1);
         }

         if (var2 != null) {
            var9.setString(var11++, var2);
         }

         var9.setInt(var11++, var3);
         var9.setInt(var11, var4);
         ResultSet var12 = var9.executeQuery();

         while(var12.next()) {
            int var13 = var12.getInt("open_id");
            long var14 = var12.getLong("open_timestamp");
            String var16 = var12.getString("crate_id");
            String var17 = var12.getString("reward_id");
            int var18 = var12.getInt("amount");
            String var19 = var12.getString("username");
            Pair var20 = (Pair)var5.get(var13);
            CrateProfileEntry.OpenHistoryEntry var21;
            Integer var23;
            if (var20 != null) {
               var21 = (CrateProfileEntry.OpenHistoryEntry)var20.getSecond();
               Map var22 = (Map)var21.getRewardIds();
               Integer var10000 = (Integer)var21.getRewardIds().get(var17);
               var23 = (var10000 != null ? var10000 : 0) + var18;
               var22.put(var17, var23);
            } else {
               Intrinsics.checkNotNull(var16);
               Pair[] var28 = new Pair[]{TuplesKt.to(var17, var18)};
               var21 = new CrateProfileEntry.OpenHistoryEntry(var14, var16, MapsKt.hashMapOf(var28));
               var23 = var13;
               var5.put(var23, new Pair(var19, var21));
            }
         }

         Unit var29 = Unit.INSTANCE;
         return Unit.INSTANCE;
      } catch (Throwable var26) {
         var8 = var26;
         throw var26;
      } finally {
         AutoCloseableKt.closeFinally(var7, var8);
      }
   }

   static {
      Object var10000 = Waves.Companion.getINSTANCE().getModules().get(WaveModules.PROFILES);
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type gg.aquatic.waves.profile.ProfilesModule");
      driver = ((ProfilesModule)var10000).getDriver();
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/player/CrateProfileDriver$Sorting;", "", "<init>", "(Ljava/lang/String;I)V", "NEWEST", "OLDEST", "api"}
   )
   public static enum Sorting {
      NEWEST,
      OLDEST;

      // $FF: synthetic field
      private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

      @NotNull
      public static EnumEntries<CrateProfileDriver.Sorting> getEntries() {
         return $ENTRIES;
      }

      // $FF: synthetic method
      private static final CrateProfileDriver.Sorting[] $values() {
         CrateProfileDriver.Sorting[] var0 = new CrateProfileDriver.Sorting[]{NEWEST, OLDEST};
         return var0;
      }
   }

   // $FF: synthetic class
   @Metadata(
      mv = {2, 1, 0},
      k = 3,
      xi = 48
   )
   public class WhenMappings {
      // $FF: synthetic field
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[CrateProfileDriver.Sorting.values().length];

         try {
            var0[CrateProfileDriver.Sorting.NEWEST.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[CrateProfileDriver.Sorting.OLDEST.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
