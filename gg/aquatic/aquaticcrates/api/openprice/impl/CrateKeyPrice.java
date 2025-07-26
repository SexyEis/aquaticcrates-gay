package gg.aquatic.aquaticcrates.api.openprice.impl;

import gg.aquatic.aquaticcrates.api.openprice.Price;
import gg.aquatic.aquaticcrates.api.player.PlayerHandler;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.argument.impl.PrimitiveObjectArgument;
import java.util.List;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001e\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/openprice/impl/CrateKeyPrice;", "Lgg/aquatic/aquaticcrates/api/openprice/Price;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "take", "", "player", "Lorg/bukkit/entity/Player;", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "amount", "", "has", "", "api"}
)
public final class CrateKeyPrice implements Price {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public CrateKeyPrice() {
      PrimitiveObjectArgument[] var1 = new PrimitiveObjectArgument[]{new PrimitiveObjectArgument("crate", "", true), new PrimitiveObjectArgument("amount", 1, false)};
      this.arguments = CollectionsKt.listOf(var1);
   }

   @NotNull
   public List<AquaticObjectArgument<?>> getArguments() {
      return this.arguments;
   }

   public void take(@NotNull Player var1, @NotNull ObjectArguments var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "arguments");
      String var10000 = ObjectArguments.string$default(var2, "crate", (Function1)null, 2, (Object)null);
      if (var10000 != null) {
         String var4 = var10000;
         Integer var6 = ObjectArguments.int$default(var2, "amount", (Function1)null, 2, (Object)null);
         int var5 = var6 != null ? var6 : 1;
         PlayerHandler.INSTANCE.takeKeys(var1, var4, var3 * var5);
      }
   }

   public boolean has(@NotNull Player var1, @NotNull ObjectArguments var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "arguments");
      PlayerHandler var10000 = PlayerHandler.INSTANCE;
      String var10002 = ObjectArguments.string$default(var2, "crate", (Function1)null, 2, (Object)null);
      if (var10002 == null) {
         return false;
      } else {
         Integer var4 = var10000.totalKeys(var1, var10002);
         if (var4 != null) {
            return var4 >= var3;
         } else {
            return false;
         }
      }
   }
}
