package gg.aquatic.aquaticcrates.plugin.command;

import gg.aquatic.aquaticcrates.plugin.convert.Converter;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.io.File;
import org.bukkit.command.CommandSender;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runAsync$1\n+ 2 ConvertCommand.kt\ngg/aquatic/aquaticcrates/plugin/command/ConvertCommand\n*L\n1#1,14:1\n38#2,2:15\n*E\n"})
public final class ConvertCommand$run$$inlined$runAsync$2 implements Runnable {
   // $FF: synthetic field
   final File $inputFile$inlined;
   // $FF: synthetic field
   final Converter $converter$inlined;
   // $FF: synthetic field
   final CommandSender $sender$inlined;

   public ConvertCommand$run$$inlined$runAsync$2(File var1, Converter var2, CommandSender var3) {
      this.$inputFile$inlined = var1;
      this.$converter$inlined = var2;
      this.$sender$inlined = var3;
   }

   public final void run() {
      boolean var1 = false;
      ConvertCommand.access$run$convert(this.$converter$inlined, this.$sender$inlined, this.$inputFile$inlined);
   }
}
