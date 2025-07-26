package gg.aquatic.aquaticcrates.plugin.command;

import gg.aquatic.aquaticcrates.api.AbstractCratesPlugin;
import gg.aquatic.aquaticcrates.plugin.CratesPlugin;
import gg.aquatic.aquaticcrates.plugin.misc.Messages;
import gg.aquatic.waves.command.ICommand;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0016¢\u0006\u0002\u0010\u000bJ+\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/command/ReloadCommand;", "Lgg/aquatic/waves/command/ICommand;", "<init>", "()V", "run", "", "sender", "Lorg/bukkit/command/CommandSender;", "args", "", "", "(Lorg/bukkit/command/CommandSender;[Ljava/lang/String;)V", "tabComplete", "", "(Lorg/bukkit/command/CommandSender;[Ljava/lang/String;)Ljava/util/List;", "plugin"}
)
public final class ReloadCommand implements ICommand {
   @NotNull
   public static final ReloadCommand INSTANCE = new ReloadCommand();

   private ReloadCommand() {
   }

   public void run(@NotNull CommandSender var1, @NotNull String[] var2) {
      Intrinsics.checkNotNullParameter(var1, "sender");
      Intrinsics.checkNotNullParameter(var2, "args");
      if (!var1.hasPermission("aquaticcrates.admin")) {
         Messages.NO_PERMISSION.getMessage().send(var1);
      } else {
         Messages.PLUGIN_RELOADING.send(var1);
         AbstractCratesPlugin var10000 = CratesPlugin.Companion.getINSTANCE();
         Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type gg.aquatic.aquaticcrates.plugin.CratesPlugin");
         ((CratesPlugin)var10000).reloadPlugin().thenAccept(ReloadCommand::run$lambda$1);
      }
   }

   @NotNull
   public List<String> tabComplete(@NotNull CommandSender var1, @NotNull String[] var2) {
      Intrinsics.checkNotNullParameter(var1, "sender");
      Intrinsics.checkNotNullParameter(var2, "args");
      return CollectionsKt.emptyList();
   }

   private static final Unit run$lambda$0(CommandSender var0, Boolean var1) {
      if (!var1) {
         Messages.PLUGIN_IS_NOT_LOADED.send(var0);
         return Unit.INSTANCE;
      } else {
         Messages.PLUGIN_RELOADED.send(var0);
         return Unit.INSTANCE;
      }
   }

   private static final void run$lambda$1(Function1 var0, Object var1) {
      var0.invoke(var1);
   }
}
