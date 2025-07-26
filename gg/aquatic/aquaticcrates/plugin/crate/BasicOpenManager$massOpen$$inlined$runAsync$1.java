package gg.aquatic.aquaticcrates.plugin.crate;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.entity.Player;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runAsync$1\n+ 2 BasicOpenManager.kt\ngg/aquatic/aquaticcrates/plugin/crate/BasicOpenManager\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,14:1\n99#2,7:15\n122#2,4:22\n126#2,2:27\n134#2,4:33\n147#2,4:41\n1#3:26\n6#4,4:29\n6#4,4:37\n*S KotlinDebug\n*F\n+ 1 BasicOpenManager.kt\ngg/aquatic/aquaticcrates/plugin/crate/BasicOpenManager\n*L\n127#1:29,4\n137#1:37,4\n*E\n"})
public final class BasicOpenManager$massOpen$$inlined$runAsync$1 implements Runnable {
   // $FF: synthetic field
   final int $amount$inlined;
   // $FF: synthetic field
   final int $threads$inlined;
   // $FF: synthetic field
   final ConcurrentHashMap $wonRewards$inlined;
   // $FF: synthetic field
   final CompletableFuture $finalFuture$inlined;
   // $FF: synthetic field
   final BasicOpenManager this$0;
   // $FF: synthetic field
   final Player $player$inlined;

   public BasicOpenManager$massOpen$$inlined$runAsync$1(int var1, int var2, ConcurrentHashMap var3, CompletableFuture var4, BasicOpenManager var5, Player var6) {
      this.$amount$inlined = var1;
      this.$threads$inlined = var2;
      this.$wonRewards$inlined = var3;
      this.$finalFuture$inlined = var4;
      this.this$0 = var5;
      this.$player$inlined = var6;
   }

   public final void run() {
      // $FF: Couldn't be decompiled
   }
}
