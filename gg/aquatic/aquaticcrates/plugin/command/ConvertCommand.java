package gg.aquatic.aquaticcrates.plugin.command;

import gg.aquatic.aquaticcrates.plugin.CratesPlugin;
import gg.aquatic.aquaticcrates.plugin.convert.Converter;
import gg.aquatic.aquaticcrates.plugin.convert.ConverterKt;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.command.ICommand;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.io.FilesKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.Config;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0016¢\u0006\u0002\u0010\u000bJ+\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/command/ConvertCommand;", "Lgg/aquatic/waves/command/ICommand;", "<init>", "()V", "run", "", "sender", "Lorg/bukkit/command/CommandSender;", "args", "", "", "(Lorg/bukkit/command/CommandSender;[Ljava/lang/String;)V", "tabComplete", "", "(Lorg/bukkit/command/CommandSender;[Ljava/lang/String;)Ljava/util/List;", "plugin"}
)
@SourceDebugExtension({"SMAP\nConvertCommand.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConvertCommand.kt\ngg/aquatic/aquaticcrates/plugin/command/ConvertCommand\n+ 2 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,52:1\n12#2,4:53\n12#2,4:57\n11228#3:61\n11563#3,3:62\n1#4:65\n*S KotlinDebug\n*F\n+ 1 ConvertCommand.kt\ngg/aquatic/aquaticcrates/plugin/command/ConvertCommand\n*L\n29#1:53,4\n37#1:57,4\n46#1:61\n46#1:62,3\n*E\n"})
public final class ConvertCommand implements ICommand {
   @NotNull
   public static final ConvertCommand INSTANCE = new ConvertCommand();

   private ConvertCommand() {
   }

   public void run(@NotNull CommandSender var1, @NotNull String[] var2) {
      Intrinsics.checkNotNullParameter(var1, "sender");
      Intrinsics.checkNotNullParameter(var2, "args");
      if (var1.hasPermission("aquaticcrates.admin")) {
         if (var2.length < 3) {
            var1.sendMessage("Usage: /aquaticcrates convert <converter> <input file> <output file>");
         } else {
            Converter var10000 = (Converter)ConverterKt.getCONVERTERS().get(var2[1]);
            if (var10000 == null) {
               var1.sendMessage("Invalid converter: " + var2[1]);
            } else {
               Converter var3 = var10000;
               String var4 = var2[2];
               if (Intrinsics.areEqual(var4, "*")) {
                  boolean var7 = false;
                  Waves.Companion.getINSTANCE().getServer().getScheduler().runTaskAsynchronously((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new ConvertCommand$run$$inlined$runAsync$1(var3, var1)));
               } else {
                  File var8 = CratesPlugin.Companion.getINSTANCE().getDataFolder();
                  Intrinsics.checkNotNullExpressionValue(var8, "getDataFolder(...)");
                  File var5 = FilesKt.resolve(FilesKt.resolve(var8, "convert"), var2[2]);
                  boolean var6 = false;
                  Waves.Companion.getINSTANCE().getServer().getScheduler().runTaskAsynchronously((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new ConvertCommand$run$$inlined$runAsync$2(var5, var3, var1)));
               }
            }
         }
      }
   }

   @NotNull
   public List<String> tabComplete(@NotNull CommandSender var1, @NotNull String[] var2) {
      Intrinsics.checkNotNullParameter(var1, "sender");
      Intrinsics.checkNotNullParameter(var2, "args");
      List var16;
      switch(var2.length) {
      case 1:
         Set var17 = ConverterKt.getCONVERTERS().keySet();
         Intrinsics.checkNotNullExpressionValue(var17, "<get-keys>(...)");
         var16 = CollectionsKt.toList((Iterable)var17);
         break;
      case 2:
         File var10000 = CratesPlugin.Companion.getINSTANCE().getDataFolder();
         Intrinsics.checkNotNullExpressionValue(var10000, "getDataFolder(...)");
         File[] var15 = FilesKt.resolve(var10000, "convert").listFiles();
         if (var15 != null) {
            File[] var3 = var15;
            boolean var4 = false;
            File[] var5 = var3;
            Collection var6 = (Collection)(new ArrayList(var3.length));
            boolean var7 = false;
            int var8 = 0;

            for(int var9 = var3.length; var8 < var9; ++var8) {
               File var10 = var5[var8];
               boolean var12 = false;
               var6.add(var10.getName());
            }

            var16 = CollectionsKt.toMutableList((Collection)((List)var6));
            if (var16 != null) {
               List var14 = var16;
               var7 = false;
               var14.add("*");
               var16 = var14;
               break;
            }
         }

         var16 = CollectionsKt.emptyList();
         break;
      default:
         var16 = CollectionsKt.emptyList();
      }

      return var16;
   }

   private static final void run$convert(Converter var0, CommandSender var1, File var2) {
      long var3 = System.currentTimeMillis();
      Config var5 = new Config(var2, (JavaPlugin)CratesPlugin.Companion.getINSTANCE());
      boolean var7 = false;
      var5.load();
      var0.convert(var5);
      String var10001 = var2.getName();
      var1.sendMessage("Converted " + var10001 + " in " + (System.currentTimeMillis() - var3) + "ms");
   }

   // $FF: synthetic method
   public static final void access$run$convert(Converter var0, CommandSender var1, File var2) {
      run$convert(var0, var1, var2);
   }
}
