package gg.aquatic.aquaticcrates.plugin.misc;

import gg.aquatic.aquaticcrates.plugin.CratesPlugin;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntries;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntriesKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.Config;
import gg.aquatic.waves.util.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006#"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/misc/Messages;", "", "path", "", "def", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Object;)V", "getPath", "()Ljava/lang/String;", "getDef", "()Ljava/lang/Object;", "HELP", "PLUGIN_RELOADED", "PLUGIN_RELOADING", "NO_PERMISSION", "UNKNOWN_CRATE", "UNKNOWN_NUMBER", "UNKNOWN_PLAYER", "KEY_RECEIVED", "PLUGIN_IS_NOT_LOADED", "KEY_BANK_HEADER", "KEY_BANK_ENTRY", "KEY_BANK_FOOTER", "NON_INITIALIZED_PLAYER", "NON_INITIALIZED_PLAYER_SELF", "message", "Lgg/aquatic/waves/util/Message;", "getMessage", "()Lgg/aquatic/waves/util/Message;", "send", "", "sender", "Lorg/bukkit/command/CommandSender;", "Companion", "plugin"}
)
@SourceDebugExtension({"SMAP\nMessages.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Messages.kt\ngg/aquatic/aquaticcrates/plugin/misc/Messages\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n1563#2:60\n1634#2,3:61\n*S KotlinDebug\n*F\n+ 1 Messages.kt\ngg/aquatic/aquaticcrates/plugin/misc/Messages\n*L\n40#1:60\n40#1:61,3\n*E\n"})
public enum Messages {
   @NotNull
   public static final Messages.Companion Companion = new Messages.Companion((DefaultConstructorMarker)null);
   @NotNull
   private final String path;
   @NotNull
   private final Object def;
   @NotNull
   private static final Config config = new Config("messages.yml", (JavaPlugin)CratesPlugin.Companion.getINSTANCE());
   HELP("help", CollectionsKt.listOf("")),
   PLUGIN_RELOADED("plugin-reloaded", "Plugin has been reloaded!"),
   PLUGIN_RELOADING("plugin-reloading", "Plugin is being reloaded!"),
   NO_PERMISSION("no-permission", "You do not have permission to do this!"),
   UNKNOWN_CRATE("unknown-crate", "Unknown crate!"),
   UNKNOWN_NUMBER("unknown-number", "Unknown number format!"),
   UNKNOWN_PLAYER("unknown-player", "Unknown player!"),
   KEY_RECEIVED("key-received", "&fYou have received &7x%amount% %id% &fkey!"),
   PLUGIN_IS_NOT_LOADED("plugin-is-not-loaded", "Plugin is not loaded!"),
   KEY_BANK_HEADER("key-bank.header", "Your virtual keys: "),
   KEY_BANK_ENTRY("key-bank.entry", "&7- &f%key%: %amount%"),
   KEY_BANK_FOOTER("key-bank.footer", ""),
   NON_INITIALIZED_PLAYER("non-initialized-player", "Player is not initialized!"),
   NON_INITIALIZED_PLAYER_SELF("non-initialized-player-self", "Your profile is not initialized!");

   // $FF: synthetic field
   private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

   private Messages(String var3, Object var4) {
      this.path = var3;
      this.def = var4;
   }

   @NotNull
   public final String getPath() {
      return this.path;
   }

   @NotNull
   public final Object getDef() {
      return this.def;
   }

   @NotNull
   public final Message getMessage() {
      Object var1 = Companion.getCfg().get(this.path, this.def);
      Message var10000;
      if (var1 instanceof Collection) {
         Iterable var2 = (Iterable)var1;
         boolean var3 = false;
         Collection var5 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var2, 10)));
         boolean var6 = false;
         Iterator var7 = var2.iterator();

         while(var7.hasNext()) {
            Object var8 = var7.next();
            boolean var10 = false;
            var5.add(String.valueOf(var8));
         }

         Collection var12 = (Collection)((List)var5);
         var10000 = new Message(var12);
      } else {
         var10000 = new Message(String.valueOf(var1));
      }

      return var10000;
   }

   public final void send(@NotNull CommandSender var1) {
      Intrinsics.checkNotNullParameter(var1, "sender");
      this.getMessage().send(var1);
   }

   @NotNull
   public static EnumEntries<Messages> getEntries() {
      return $ENTRIES;
   }

   // $FF: synthetic method
   private static final Messages[] $values() {
      Messages[] var0 = new Messages[]{HELP, PLUGIN_RELOADED, PLUGIN_RELOADING, NO_PERMISSION, UNKNOWN_CRATE, UNKNOWN_NUMBER, UNKNOWN_PLAYER, KEY_RECEIVED, PLUGIN_IS_NOT_LOADED, KEY_BANK_HEADER, KEY_BANK_ENTRY, KEY_BANK_FOOTER, NON_INITIALIZED_PLAYER, NON_INITIALIZED_PLAYER_SELF};
      return var0;
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/misc/Messages$Companion;", "", "<init>", "()V", "config", "Lgg/aquatic/waves/util/Config;", "load", "", "cfg", "Lorg/bukkit/configuration/file/FileConfiguration;", "getCfg", "()Lorg/bukkit/configuration/file/FileConfiguration;", "plugin"}
   )
   public static final class Companion {
      private Companion() {
      }

      public final void load() {
         Messages.config.load();
      }

      @NotNull
      public final FileConfiguration getCfg() {
         FileConfiguration var10000 = Messages.config.getConfiguration();
         Intrinsics.checkNotNull(var10000);
         return var10000;
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
