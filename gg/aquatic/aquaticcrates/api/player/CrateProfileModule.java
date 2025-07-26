package gg.aquatic.aquaticcrates.api.player;

import gg.aquatic.waves.data.MySqlDriver;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jdk7.AutoCloseableKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.profile.AquaticPlayer;
import gg.aquatic.waves.profile.ProfilesModule;
import gg.aquatic.waves.profile.module.ProfileModule;
import gg.aquatic.waves.profile.module.ProfileModuleEntry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/player/CrateProfileModule;", "Lgg/aquatic/waves/profile/module/ProfileModule;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "initialize", "", "connection", "Ljava/sql/Connection;", "loadEntry", "Lgg/aquatic/waves/profile/module/ProfileModuleEntry;", "player", "Lgg/aquatic/waves/profile/AquaticPlayer;", "api"}
)
public final class CrateProfileModule implements ProfileModule {
   @NotNull
   public static final CrateProfileModule INSTANCE = new CrateProfileModule();
   @NotNull
   private static final String id = "aquaticcrates_profile_module";

   private CrateProfileModule() {
   }

   @NotNull
   public String getId() {
      return id;
   }

   public void initialize(@NotNull Connection var1) {
      Intrinsics.checkNotNullParameter(var1, "connection");
      if (CrateProfileDriver.INSTANCE.isSQLite()) {
         String var2 = "PRAGMA foreign_keys = ON;";
         var1.createStatement().execute(var2);
      }

      AutoCloseable var118 = (AutoCloseable)var1.prepareStatement(CrateProfileDriver.INSTANCE.isSQLite() ? "\n            CREATE TABLE IF NOT EXISTS items (\n                item_id INTEGER PRIMARY KEY AUTOINCREMENT, -- Auto-increment for SQLite\n                item_data BLOB NOT NULL, -- Serialized data of the ItemStack (JSON or binary)\n                UNIQUE(item_data) -- Ensure no duplicate items\n            );\n            " : "\n            CREATE TABLE IF NOT EXISTS items (\n                item_id INT AUTO_INCREMENT PRIMARY KEY, -- Auto-increment for MySQL\n                item_data BLOB NOT NULL, -- Serialized data of the ItemStack (JSON or binary)\n                UNIQUE(item_data) -- Ensure no duplicate items\n            );\n            ");
      Throwable var3 = null;

      PreparedStatement var4;
      boolean var5;
      boolean var119;
      try {
         var4 = (PreparedStatement)var118;
         var5 = false;
         var119 = var4.execute();
      } catch (Throwable var116) {
         var3 = var116;
         throw var116;
      } finally {
         AutoCloseableKt.closeFinally(var118, var3);
      }

      var118 = (AutoCloseable)var1.prepareStatement("\n            CREATE TABLE IF NOT EXISTS player_items (\n                player_id INTEGER NOT NULL,\n                item_id INTEGER NOT NULL,\n                quantity INTEGER NOT NULL,\n                PRIMARY KEY (player_id, item_id), -- Composite primary key\n                FOREIGN KEY (player_id) REFERENCES aquaticprofiles(id) ON DELETE CASCADE, -- Cascading delete\n                FOREIGN KEY (item_id) REFERENCES items(item_id) ON DELETE CASCADE\n            );\n            ");
      var3 = null;

      try {
         var4 = (PreparedStatement)var118;
         var5 = false;
         var119 = var4.execute();
      } catch (Throwable var114) {
         var3 = var114;
         throw var114;
      } finally {
         AutoCloseableKt.closeFinally(var118, var3);
      }

      var118 = (AutoCloseable)var1.prepareStatement("CREATE TABLE IF NOT EXISTS aquaticcrates_keys (id INTEGER NOT NULL, key_id NVARCHAR(64) NOT NULL, amount INTEGER NOT NULL, PRIMARY KEY (id, key_id), FOREIGN KEY (id) REFERENCES aquaticprofiles(id))");
      var3 = null;

      try {
         var4 = (PreparedStatement)var118;
         var5 = false;
         var119 = var4.execute();
      } catch (Throwable var112) {
         var3 = var112;
         throw var112;
      } finally {
         AutoCloseableKt.closeFinally(var118, var3);
      }

      if (ProfilesModule.INSTANCE.getDriver() instanceof MySqlDriver) {
         var118 = (AutoCloseable)var1.prepareStatement("CREATE TABLE IF NOT EXISTS \naquaticcrates_opens (\nid INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, \nuser_id INTEGER NOT NULL, \nopen_timestamp INTEGER NOT NULL, \ncrate_id NVARCHAR(64) NOT NULL, \nFOREIGN KEY (user_id) REFERENCES aquaticprofiles(id)\n)");
         var3 = null;

         try {
            var4 = (PreparedStatement)var118;
            var5 = false;
            var119 = var4.execute();
         } catch (Throwable var110) {
            var3 = var110;
            throw var110;
         } finally {
            AutoCloseableKt.closeFinally(var118, var3);
         }
      } else {
         var118 = (AutoCloseable)var1.prepareStatement("CREATE TABLE IF NOT EXISTS \naquaticcrates_opens (\nid INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, \nuser_id INTEGER NOT NULL, \nopen_timestamp INTEGER NOT NULL, \ncrate_id NVARCHAR(64) NOT NULL, \nFOREIGN KEY (user_id) REFERENCES aquaticprofiles(id)\n)");
         var3 = null;

         try {
            var4 = (PreparedStatement)var118;
            var5 = false;
            var119 = var4.execute();
         } catch (Throwable var108) {
            var3 = var108;
            throw var108;
         } finally {
            AutoCloseableKt.closeFinally(var118, var3);
         }
      }

      if (ProfilesModule.INSTANCE.getDriver() instanceof MySqlDriver) {
         var118 = (AutoCloseable)var1.prepareStatement("CREATE TABLE IF NOT EXISTS aquaticcrates_rewards (id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, open_id INTEGER NOT NULL, reward_id NVARCHAR(64) NOT NULL, amount INTEGER NOT NULL, FOREIGN KEY (open_id) REFERENCES aquaticcrates_opens(id))");
         var3 = null;

         try {
            var4 = (PreparedStatement)var118;
            var5 = false;
            var119 = var4.execute();
         } catch (Throwable var106) {
            var3 = var106;
            throw var106;
         } finally {
            AutoCloseableKt.closeFinally(var118, var3);
         }
      } else {
         var118 = (AutoCloseable)var1.prepareStatement("CREATE TABLE IF NOT EXISTS aquaticcrates_rewards (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, open_id INTEGER NOT NULL, reward_id NVARCHAR(64) NOT NULL, amount INTEGER NOT NULL, FOREIGN KEY (open_id) REFERENCES aquaticcrates_opens(id))");
         var3 = null;

         try {
            var4 = (PreparedStatement)var118;
            var5 = false;
            var119 = var4.execute();
         } catch (Throwable var104) {
            var3 = var104;
            throw var104;
         } finally {
            AutoCloseableKt.closeFinally(var118, var3);
         }
      }

   }

   @NotNull
   public ProfileModuleEntry loadEntry(@NotNull AquaticPlayer var1) {
      Intrinsics.checkNotNullParameter(var1, "player");
      return (ProfileModuleEntry)CrateProfileDriver.INSTANCE.get(var1);
   }
}
