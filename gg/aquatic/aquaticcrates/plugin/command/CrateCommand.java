package gg.aquatic.aquaticcrates.plugin.command;

import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.CrateHandler;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.crate.SpawnedCrate;
import gg.aquatic.aquaticcrates.plugin.crate.BasicCrate;
import gg.aquatic.aquaticcrates.plugin.editor.EditorCategory;
import gg.aquatic.aquaticcrates.plugin.editor.category.MainEditorCategory;
import gg.aquatic.aquaticcrates.plugin.editor.data.CrateModel;
import gg.aquatic.aquaticcrates.plugin.editor.menu.EditorMenu;
import gg.aquatic.aquaticcrates.plugin.misc.Messages;
import gg.aquatic.waves.command.ICommand;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.ArraysKt;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0016¢\u0006\u0002\u0010\u000bJ+\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/command/CrateCommand;", "Lgg/aquatic/waves/command/ICommand;", "<init>", "()V", "run", "", "sender", "Lorg/bukkit/command/CommandSender;", "args", "", "", "(Lorg/bukkit/command/CommandSender;[Ljava/lang/String;)V", "tabComplete", "", "(Lorg/bukkit/command/CommandSender;[Ljava/lang/String;)Ljava/util/List;", "plugin"}
)
@SourceDebugExtension({"SMAP\nCrateCommand.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrateCommand.kt\ngg/aquatic/aquaticcrates/plugin/command/CrateCommand\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,257:1\n1563#2:258\n1634#2,3:259\n1563#2:262\n1634#2,3:263\n1563#2:266\n1634#2,3:267\n*S KotlinDebug\n*F\n+ 1 CrateCommand.kt\ngg/aquatic/aquaticcrates/plugin/command/CrateCommand\n*L\n208#1:258\n208#1:259,3\n219#1:262\n219#1:263,3\n235#1:266\n235#1:267,3\n*E\n"})
public final class CrateCommand implements ICommand {
   @NotNull
   public static final CrateCommand INSTANCE = new CrateCommand();

   private CrateCommand() {
   }

   public void run(@NotNull CommandSender var1, @NotNull String[] var2) {
      Intrinsics.checkNotNullParameter(var1, "sender");
      Intrinsics.checkNotNullParameter(var2, "args");
      if (!var1.hasPermission("aquaticcrates.admin")) {
         Messages.NO_PERMISSION.getMessage().send(var1);
      } else if (var2.length < 2) {
         var1.sendMessage("Usage: /acrates crate give/open/massopen ...");
      } else {
         String var10000 = var2[1].toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var10000, "toLowerCase(...)");
         String var3 = var10000;
         String var4;
         String var6;
         boolean var9;
         Crate var11;
         Player var13;
         switch(var3.hashCode()) {
         case -318184504:
            if (var3.equals("preview")) {
               if (var2.length < 4) {
                  var1.sendMessage("Usage: /acrates crate preview <crate> <player>");
                  return;
               }

               var4 = var2[2];
               var11 = (Crate)CrateHandler.INSTANCE.getCrates().get(var4);
               if (var11 == null) {
                  Messages.UNKNOWN_CRATE.getMessage().send(var1);
                  return;
               }

               if (!(var11 instanceof BasicCrate)) {
                  return;
               }

               var6 = var2[3];
               var13 = var1.getServer().getPlayer(var6);
               if (var13 == null) {
                  Messages.UNKNOWN_PLAYER.getMessage().send(var1);
                  return;
               }

               ((BasicCrate)var11).openPreview(var13, (SpawnedCrate)null);
            }
            break;
         case 3108362:
            if (var3.equals("edit")) {
               if (!var1.hasPermission("aquaticcrates.admin")) {
                  return;
               }

               if (var2.length < 3) {
                  var1.sendMessage("Usage: /acrates crate edit <crate>");
                  return;
               }

               if (!(var1 instanceof Player)) {
                  var1.sendMessage("You must be a player to use this command!");
                  return;
               }

               var4 = var2[2];
               var11 = (Crate)CrateHandler.INSTANCE.getCrates().get(var4);
               if (var11 == null) {
                  Messages.UNKNOWN_CRATE.getMessage().send((Player)var1);
                  return;
               }

               var1.sendMessage("Opening editor...");
               CrateModel var12 = CrateModel.Companion.of((BasicCrate)var11);
               EditorMenu var14 = new EditorMenu(var12, (Player)var1, (EditorCategory)(new MainEditorCategory(var12)), (EditorMenu)null);
               var14.open();
            }
            break;
         case 3173137:
            if (var3.equals("give")) {
               if (!(var1 instanceof Player)) {
                  return;
               }

               if (var2.length < 3) {
                  var1.sendMessage("Usage: /acrates crate give <crate>");
                  return;
               }

               var4 = var2[2];
               var11 = (Crate)CrateHandler.INSTANCE.getCrates().get(var4);
               if (var11 == null) {
                  Messages.UNKNOWN_CRATE.getMessage().send((Player)var1);
                  return;
               }

               if (!(var11 instanceof BasicCrate)) {
                  return;
               }

               ((BasicCrate)var11).getCrateItem().giveItem((Player)var1);
            }
            break;
         case 3417674:
            if (var3.equals("open")) {
               if (var2.length < 4) {
                  var1.sendMessage("Usage: /acrates crate open <crate> <player> [-nokey] [-instant]");
                  return;
               }

               var4 = var2[2];
               var11 = (Crate)CrateHandler.INSTANCE.getCrates().get(var4);
               if (var11 == null) {
                  Messages.UNKNOWN_CRATE.getMessage().send(var1);
                  return;
               }

               if (!(var11 instanceof BasicCrate)) {
                  return;
               }

               var6 = var2[3];
               var13 = var1.getServer().getPlayer(var6);
               if (var13 == null) {
                  Messages.UNKNOWN_PLAYER.getMessage().send(var1);
                  return;
               }

               boolean var15 = ArraysKt.contains(var2, "-nokey");
               var9 = ArraysKt.contains(var2, "-instant");
               BasicCrate var18;
               Location var10002;
               if (var9) {
                  if (var15) {
                     var18 = (BasicCrate)var11;
                     var10002 = var13.getLocation();
                     Intrinsics.checkNotNullExpressionValue(var10002, "getLocation(...)");
                     var18.instantOpen(var13, var10002, (SpawnedCrate)null);
                     return;
                  }

                  var18 = (BasicCrate)var11;
                  var10002 = var13.getLocation();
                  Intrinsics.checkNotNullExpressionValue(var10002, "getLocation(...)");
                  var18.tryInstantOpen(var13, var10002, (SpawnedCrate)null);
                  return;
               }

               if (var15) {
                  var18 = (BasicCrate)var11;
                  var10002 = var13.getLocation();
                  Intrinsics.checkNotNullExpressionValue(var10002, "getLocation(...)");
                  var18.open(var13, var10002, (SpawnedCrate)null);
                  return;
               }

               var18 = (BasicCrate)var11;
               var10002 = var13.getLocation();
               Intrinsics.checkNotNullExpressionValue(var10002, "getLocation(...)");
               var18.tryOpen(var13, var10002, (SpawnedCrate)null);
            }
            break;
         case 283284286:
            if (var3.equals("massopen")) {
               if (var2.length < 5) {
                  var1.sendMessage("Usage: /acrates crate massopen <crate> <player> <amount> [threads] [-nokey]");
                  return;
               }

               var4 = var2[3];
               Player var5 = Bukkit.getPlayer(var4);
               if (var5 == null) {
                  Messages.UNKNOWN_PLAYER.getMessage().send(var1);
                  return;
               }

               var6 = var2[2];
               Crate var7 = (Crate)CrateHandler.INSTANCE.getCrates().get(var6);
               if (var7 == null) {
                  Messages.UNKNOWN_CRATE.getMessage().send(var1);
                  return;
               }

               Integer var8 = StringsKt.toIntOrNull(var2[4]);
               if (var8 == null) {
                  Messages.UNKNOWN_NUMBER.getMessage().send(var1);
                  return;
               }

               var9 = ArraysKt.contains(var2, "-nokey");
               int var10 = 4;
               if (var2.length > 5) {
                  Integer var16 = StringsKt.toIntOrNull(var2[5]);
                  var10 = var16 != null ? var16 : 4;
               }

               if (var7 instanceof OpenableCrate) {
                  if (var9) {
                     ((OpenableCrate)var7).massOpen(var5, var8, var10);
                  } else {
                     ((OpenableCrate)var7).tryMassOpen(var5, var8, var10);
                  }
               } else {
                  var1.sendMessage("This crate cannot be mass opened!");
                  Unit var17 = Unit.INSTANCE;
               }
            }
         }

      }
   }

   @NotNull
   public List<String> tabComplete(@NotNull CommandSender var1, @NotNull String[] var2) {
      Intrinsics.checkNotNullParameter(var1, "sender");
      Intrinsics.checkNotNullParameter(var2, "args");
      if (var2.length == 1) {
         String[] var15 = new String[]{"give", "open", "massopen", "preview", "edit"};
         return CollectionsKt.listOf(var15);
      } else {
         String var10000 = var2[0].toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var10000, "toLowerCase(...)");
         String var3 = var10000;
         String[] var5;
         boolean var6;
         Collection var8;
         boolean var9;
         Iterator var10;
         Object var11;
         Player var12;
         boolean var13;
         Iterable var16;
         List var23;
         Collection var24;
         Set var25;
         switch(var3.hashCode()) {
         case -318184504:
            if (var3.equals("preview")) {
               if (var2.length == 2) {
                  var25 = CrateHandler.INSTANCE.getCrates().keySet();
                  Intrinsics.checkNotNullExpressionValue(var25, "<get-keys>(...)");
                  var23 = CollectionsKt.toList((Iterable)var25);
               } else {
                  var24 = Bukkit.getOnlinePlayers();
                  Intrinsics.checkNotNullExpressionValue(var24, "getOnlinePlayers(...)");
                  Iterable var4 = (Iterable)var24;
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

                  var23 = (List)var7;
               }

               return var23;
            }
            break;
         case 3108362:
            if (var3.equals("edit")) {
               if (var2.length == 2) {
                  var25 = CrateHandler.INSTANCE.getCrates().keySet();
                  Intrinsics.checkNotNullExpressionValue(var25, "<get-keys>(...)");
                  var23 = CollectionsKt.toList((Iterable)var25);
               } else {
                  var23 = CollectionsKt.emptyList();
               }

               return var23;
            }
            break;
         case 3173137:
            if (var3.equals("give")) {
               if (var2.length == 2) {
                  var25 = CrateHandler.INSTANCE.getCrates().keySet();
                  Intrinsics.checkNotNullExpressionValue(var25, "<get-keys>(...)");
                  var23 = CollectionsKt.toList((Iterable)var25);
               } else {
                  var23 = CollectionsKt.emptyList();
               }

               return var23;
            }
            break;
         case 3417674:
            if (var3.equals("open")) {
               switch(var2.length) {
               case 2:
                  var25 = CrateHandler.INSTANCE.getCrates().keySet();
                  Intrinsics.checkNotNullExpressionValue(var25, "<get-keys>(...)");
                  var23 = CollectionsKt.toList((Iterable)var25);
                  return var23;
               case 3:
                  var24 = Bukkit.getOnlinePlayers();
                  Intrinsics.checkNotNullExpressionValue(var24, "getOnlinePlayers(...)");
                  var16 = (Iterable)var24;
                  var6 = false;
                  var8 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var16, 10)));
                  var9 = false;
                  var10 = var16.iterator();

                  while(var10.hasNext()) {
                     var11 = var10.next();
                     var12 = (Player)var11;
                     var13 = false;
                     var8.add(var12.getName());
                  }

                  var23 = (List)var8;
                  return var23;
               default:
                  var5 = new String[]{"-nokey", "-instant"};
                  var23 = CollectionsKt.listOf(var5);
                  return var23;
               }
            }
            break;
         case 283284286:
            if (var3.equals("massopen")) {
               switch(var2.length) {
               case 2:
                  var25 = CrateHandler.INSTANCE.getCrates().keySet();
                  Intrinsics.checkNotNullExpressionValue(var25, "<get-keys>(...)");
                  var23 = CollectionsKt.toList((Iterable)var25);
                  return var23;
               case 3:
                  var24 = Bukkit.getOnlinePlayers();
                  Intrinsics.checkNotNullExpressionValue(var24, "getOnlinePlayers(...)");
                  var16 = (Iterable)var24;
                  var6 = false;
                  var8 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var16, 10)));
                  var9 = false;
                  var10 = var16.iterator();

                  while(var10.hasNext()) {
                     var11 = var10.next();
                     var12 = (Player)var11;
                     var13 = false;
                     var8.add(var12.getName());
                  }

                  var23 = (List)var8;
                  return var23;
               case 4:
                  var5 = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
                  var23 = CollectionsKt.listOf(var5);
                  return var23;
               case 5:
                  var5 = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
                  var23 = CollectionsKt.listOf(var5);
                  return var23;
               default:
                  var23 = CollectionsKt.listOf("-nokey");
                  return var23;
               }
            }
         }

         var23 = CollectionsKt.emptyList();
         return var23;
      }
   }
}
