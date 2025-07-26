package gg.aquatic.aquaticcrates.plugin.command;

import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.CrateHandler;
import gg.aquatic.aquaticcrates.api.crate.Key;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.player.CrateProfileEntry;
import gg.aquatic.aquaticcrates.api.player.CrateProfileModuleKt;
import gg.aquatic.aquaticcrates.plugin.misc.Messages;
import gg.aquatic.waves.command.ICommand;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.ArraysKt;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.profile.AquaticPlayer;
import gg.aquatic.waves.profile.AquaticPlayerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0016¢\u0006\u0002\u0010\u000bJ+\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/command/KeyCommand;", "Lgg/aquatic/waves/command/ICommand;", "<init>", "()V", "run", "", "sender", "Lorg/bukkit/command/CommandSender;", "args", "", "", "(Lorg/bukkit/command/CommandSender;[Ljava/lang/String;)V", "tabComplete", "", "(Lorg/bukkit/command/CommandSender;[Ljava/lang/String;)Ljava/util/List;", "plugin"}
)
@SourceDebugExtension({"SMAP\nKeyCommand.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KeyCommand.kt\ngg/aquatic/aquaticcrates/plugin/command/KeyCommand\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,266:1\n1563#2:267\n1634#2,3:268\n1563#2:271\n1634#2,3:272\n*S KotlinDebug\n*F\n+ 1 KeyCommand.kt\ngg/aquatic/aquaticcrates/plugin/command/KeyCommand\n*L\n217#1:267\n217#1:268,3\n260#1:271\n260#1:272,3\n*E\n"})
public final class KeyCommand implements ICommand {
   @NotNull
   public static final KeyCommand INSTANCE = new KeyCommand();

   private KeyCommand() {
   }

   public void run(@NotNull CommandSender var1, @NotNull String[] var2) {
      Intrinsics.checkNotNullParameter(var1, "sender");
      Intrinsics.checkNotNullParameter(var2, "args");
      if (!var1.hasPermission("aquaticcrates.admin")) {
         Messages.NO_PERMISSION.getMessage().send(var1);
      } else if (var2.length < 2) {
         Messages.HELP.send(var1);
      } else {
         String var10000 = var2[1].toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var10000, "toLowerCase(...)");
         String var3 = var10000;
         String var4;
         Crate var5;
         boolean var8;
         boolean var9;
         boolean var28;
         Integer var37;
         AquaticPlayer var38;
         Key var40;
         switch(var3.hashCode()) {
         case 3016252:
            if (var3.equals("bank")) {
               if (!var1.hasPermission("aquaticcrates.command.key.bank")) {
                  Messages.NO_PERMISSION.getMessage().send(var1);
                  return;
               }

               if (var2.length == 3) {
                  if (!var1.hasPermission("aquaticcrates.command.key.bank.other")) {
                     Messages.NO_PERMISSION.getMessage().send(var1);
                     return;
                  }

                  var4 = var2[2];
                  Player var17 = Bukkit.getPlayer(var4);
                  if (var17 == null) {
                     Messages.UNKNOWN_PLAYER.getMessage().send(var1);
                     return;
                  }

                  var38 = AquaticPlayerKt.toAquaticPlayer(var17);
                  CrateProfileEntry var20 = var38 != null ? CrateProfileModuleKt.crateEntry(var38) : null;
                  if (var20 == null) {
                     Messages.NON_INITIALIZED_PLAYER.send(var1);
                     return;
                  }

                  Messages.KEY_BANK_HEADER.send(var1);
                  Iterator var23 = ((Map)var20.getBalance()).entrySet().iterator();

                  while(var23.hasNext()) {
                     Entry var25 = (Entry)var23.next();
                     String var29 = (String)var25.getKey();
                     int var32 = ((Number)var25.getValue()).intValue();
                     var40 = Key.Companion.get(var29);
                     if (var40 != null) {
                        Key var34 = var40;
                        Messages.KEY_BANK_ENTRY.getMessage().replace("%key%", var34.getCrate().getDisplayName()).replace("%amount%", String.valueOf(var32)).send(var1);
                     }
                  }

                  Messages.KEY_BANK_FOOTER.send(var1);
                  return;
               }

               if (!(var1 instanceof Player)) {
                  return;
               }

               var38 = AquaticPlayerKt.toAquaticPlayer((Player)var1);
               CrateProfileEntry var15 = var38 != null ? CrateProfileModuleKt.crateEntry(var38) : null;
               if (var15 == null) {
                  Messages.NON_INITIALIZED_PLAYER_SELF.send(var1);
                  return;
               }

               Messages.KEY_BANK_HEADER.send(var1);
               Iterator var16 = ((Map)var15.getBalance()).entrySet().iterator();

               while(var16.hasNext()) {
                  Entry var19 = (Entry)var16.next();
                  String var22 = (String)var19.getKey();
                  int var24 = ((Number)var19.getValue()).intValue();
                  var40 = Key.Companion.get(var22);
                  if (var40 != null) {
                     Key var27 = var40;
                     Messages.KEY_BANK_ENTRY.getMessage().replace("%key%", var27.getCrate().getDisplayName()).replace("%amount%", String.valueOf(var24)).send((Player)var1);
                  }
               }

               Messages.KEY_BANK_FOOTER.send(var1);
               return;
            }
            break;
         case 3173137:
            if (var3.equals("give")) {
               if (var2.length < 5) {
                  var1.sendMessage("Usage: /acrates key give <crate> <player> <amount> [-s] [-off] [-v]");
                  return;
               }

               var4 = var2[2];
               var5 = (Crate)CrateHandler.INSTANCE.getCrates().get(var4);
               if (var5 == null) {
                  Messages.UNKNOWN_CRATE.getMessage().send(var1);
                  return;
               }

               String var18 = var2[3];
               var37 = StringsKt.toIntOrNull(var2[4]);
               if (var37 == null) {
                  KeyCommand var30 = (KeyCommand)this;
                  boolean var33 = false;
                  Messages.UNKNOWN_NUMBER.getMessage().send(var1);
                  return;
               }

               int var21 = var37;
               var8 = ArraysKt.contains(var2, "-s");
               var9 = ArraysKt.contains(var2, "-off");
               var28 = ArraysKt.contains(var2, "-v");
               Player var31 = Bukkit.getPlayer(var18);
               if (var31 == null) {
                  if (var9) {
                     var1.sendMessage("Trying to give the key to offline player...");
                     return;
                  }

                  Messages.UNKNOWN_PLAYER.getMessage().send(var1);
                  return;
               }

               if (var28) {
                  var38 = AquaticPlayerKt.toAquaticPlayer(var31);
                  CrateProfileEntry var35 = var38 != null ? CrateProfileModuleKt.crateEntry(var38) : null;
                  if (var35 == null) {
                     var1.sendMessage("Player is not initialized!");
                     return;
                  }

                  var35.give(var21, var4);
               } else if (var5 instanceof OpenableCrate) {
                  var40 = ((OpenableCrate)var5).getKey();
                  Player[] var36 = new Player[]{var31};
                  var40.giveItem(var21, var36);
               }

               if (!var8) {
                  Messages.KEY_RECEIVED.getMessage().replace(KeyCommand::run$lambda$1).send(var31);
                  var1.sendMessage("Key given!");
               }

               return;
            }
            break;
         case 41740528:
            if (var3.equals("giveall")) {
               if (var2.length < 4) {
                  var1.sendMessage("Usage: /acrates key giveall <crate> <amount> [-s] [-off]");
                  return;
               }

               var4 = var2[2];
               var5 = (Crate)CrateHandler.INSTANCE.getCrates().get(var4);
               if (var5 == null) {
                  Messages.UNKNOWN_CRATE.getMessage().send(var1);
                  return;
               }

               var37 = StringsKt.toIntOrNull(var2[3]);
               if (var37 == null) {
                  KeyCommand var26 = (KeyCommand)this;
                  var28 = false;
                  Messages.UNKNOWN_NUMBER.getMessage().send(var1);
                  return;
               }

               int var6 = var37;
               boolean var7 = ArraysKt.contains(var2, "-s");
               var8 = ArraysKt.contains(var2, "-off");
               var9 = ArraysKt.contains(var2, "-v");
               HashSet var10 = new HashSet();
               Iterator var11 = Bukkit.getOnlinePlayers().iterator();

               while(true) {
                  while(var11.hasNext()) {
                     Player var12 = (Player)var11.next();
                     Intrinsics.checkNotNull(var12);
                     var38 = AquaticPlayerKt.toAquaticPlayer(var12);
                     if (var38 != null) {
                        CrateProfileEntry var39 = CrateProfileModuleKt.crateEntry(var38);
                        if (var39 != null) {
                           CrateProfileEntry var13 = var39;
                           ((Collection)var10).add(var12.getName());
                           if (var9) {
                              var13.give(var6, var4);
                           } else if (var5 instanceof OpenableCrate) {
                              var40 = ((OpenableCrate)var5).getKey();
                              Player[] var14 = new Player[]{var12};
                              var40.giveItem(var6, var14);
                           }

                           if (!var7) {
                              Messages.KEY_RECEIVED.getMessage().replace(KeyCommand::run$lambda$3).send(var12);
                           }
                        }
                     }
                  }

                  if (var8) {
                     if (!var9) {
                        var1.sendMessage("Keys are gonna be given as virtual keys to offline players!");
                     }

                     var1.sendMessage("Trying to give the key to offline players...");
                  }

                  if (!var7) {
                     var1.sendMessage("Key given to " + var10.size() + " players!");
                  }

                  return;
               }
            }
         }

         var1.sendMessage("Unknown subcommand. Usage: /acrates key <give|giveall> ...");
      }
   }

   @NotNull
   public List<String> tabComplete(@NotNull CommandSender var1, @NotNull String[] var2) {
      Intrinsics.checkNotNullParameter(var1, "sender");
      Intrinsics.checkNotNullParameter(var2, "args");
      if (var2.length == 1) {
         String[] var15 = new String[]{"give", "giveall", "bank"};
         return CollectionsKt.listOf(var15);
      } else {
         String var10000 = var2[0].toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var10000, "toLowerCase(...)");
         String var3 = var10000;
         String[] var5;
         List var23;
         Set var24;
         Collection var25;
         switch(var3.hashCode()) {
         case 3016252:
            if (var3.equals("bank")) {
               if (var2.length != 2) {
                  return CollectionsKt.emptyList();
               }

               if (!var1.hasPermission("aquaticcrates.command.key.bank.other")) {
                  return CollectionsKt.emptyList();
               }

               var25 = Bukkit.getOnlinePlayers();
               Intrinsics.checkNotNullExpressionValue(var25, "getOnlinePlayers(...)");
               Iterable var4 = (Iterable)var25;
               boolean var17 = false;
               Collection var7 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var4, 10)));
               boolean var18 = false;
               Iterator var19 = var4.iterator();

               while(var19.hasNext()) {
                  Object var20 = var19.next();
                  Player var21 = (Player)var20;
                  boolean var22 = false;
                  var7.add(var21.getName());
               }

               return (List)var7;
            }
            break;
         case 3173137:
            if (var3.equals("give")) {
               if (!var1.hasPermission("aquaticcrates.admin")) {
                  return CollectionsKt.emptyList();
               }

               switch(var2.length) {
               case 2:
                  var24 = CrateHandler.INSTANCE.getCrates().keySet();
                  Intrinsics.checkNotNullExpressionValue(var24, "<get-keys>(...)");
                  var23 = CollectionsKt.toList((Iterable)var24);
                  break;
               case 3:
                  var25 = Bukkit.getOnlinePlayers();
                  Intrinsics.checkNotNullExpressionValue(var25, "getOnlinePlayers(...)");
                  Iterable var16 = (Iterable)var25;
                  boolean var6 = false;
                  Collection var8 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var16, 10)));
                  boolean var9 = false;
                  Iterator var10 = var16.iterator();

                  while(var10.hasNext()) {
                     Object var11 = var10.next();
                     Player var12 = (Player)var11;
                     boolean var13 = false;
                     var8.add(var12.getName());
                  }

                  var23 = (List)var8;
                  break;
               case 4:
                  var5 = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
                  var23 = CollectionsKt.listOf(var5);
                  break;
               default:
                  var5 = new String[]{"-s", "-off", "-v"};
                  var23 = CollectionsKt.listOf(var5);
               }

               return var23;
            }
            break;
         case 41740528:
            if (var3.equals("giveall")) {
               if (!var1.hasPermission("aquaticcrates.admin")) {
                  return CollectionsKt.emptyList();
               }

               switch(var2.length) {
               case 2:
                  var24 = CrateHandler.INSTANCE.getCrates().keySet();
                  Intrinsics.checkNotNullExpressionValue(var24, "<get-keys>(...)");
                  var23 = CollectionsKt.toList((Iterable)var24);
                  break;
               case 3:
                  var5 = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
                  var23 = CollectionsKt.listOf(var5);
                  break;
               default:
                  var5 = new String[]{"-s", "-off", "-v"};
                  var23 = CollectionsKt.listOf(var5);
               }

               return var23;
            }
         }

         return CollectionsKt.emptyList();
      }
   }

   private static final String run$lambda$1(int var0, String var1, Crate var2, String var3) {
      Intrinsics.checkNotNullParameter(var3, "str");
      return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(var3, "%amount%", String.valueOf(var0), false, 4, (Object)null), "%id%", var1, false, 4, (Object)null), "%name%", var2.getDisplayName(), false, 4, (Object)null);
   }

   private static final String run$lambda$3(int var0, String var1, Crate var2, String var3) {
      Intrinsics.checkNotNullParameter(var3, "str");
      return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(var3, "%amount%", String.valueOf(var0), false, 4, (Object)null), "%id%", var1, false, 4, (Object)null), "%name%", var2.getDisplayName(), false, 4, (Object)null);
   }
}
