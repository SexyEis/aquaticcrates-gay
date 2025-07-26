package gg.aquatic.aquaticcrates.plugin.command;

import gg.aquatic.aquaticcrates.plugin.CratesPlugin;
import gg.aquatic.aquaticcrates.plugin.convert.Converter;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.io.FilesKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.io.File;
import org.bukkit.command.CommandSender;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runAsync$1\n+ 2 ConvertCommand.kt\ngg/aquatic/aquaticcrates/plugin/command/ConvertCommand\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,14:1\n30#2:15\n31#2,2:17\n33#2:20\n13472#3:16\n13473#3:19\n*S KotlinDebug\n*F\n+ 1 ConvertCommand.kt\ngg/aquatic/aquaticcrates/plugin/command/ConvertCommand\n*L\n30#1:16\n30#1:19\n*E\n"})
public final class ConvertCommand$run$$inlined$runAsync$1 implements Runnable {
   // $FF: synthetic field
   final Converter $converter$inlined;
   // $FF: synthetic field
   final CommandSender $sender$inlined;

   public ConvertCommand$run$$inlined$runAsync$1(Converter var1, CommandSender var2) {
      this.$converter$inlined = var1;
      this.$sender$inlined = var2;
   }

   public final void run() {
      boolean var1 = false;
      File var10000 = CratesPlugin.Companion.getINSTANCE().getDataFolder();
      Intrinsics.checkNotNullExpressionValue(var10000, "getDataFolder(...)");
      File[] var9 = FilesKt.resolve(var10000, "convert").listFiles();
      if (var9 != null) {
         File[] var2 = var9;
         boolean var3 = false;
         int var4 = 0;

         for(int var5 = var2.length; var4 < var5; ++var4) {
            File var6 = var2[var4];
            boolean var8 = false;
            Converter var10 = this.$converter$inlined;
            CommandSender var10001 = this.$sender$inlined;
            Intrinsics.checkNotNull(var6);
            ConvertCommand.access$run$convert(var10, var10001, var6);
         }
      }

   }
}
