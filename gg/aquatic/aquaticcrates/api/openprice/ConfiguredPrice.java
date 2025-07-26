package gg.aquatic.aquaticcrates.api.openprice;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.argument.ObjectArguments;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/openprice/ConfiguredPrice;", "", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "price", "Lgg/aquatic/aquaticcrates/api/openprice/Price;", "<init>", "(Lgg/aquatic/waves/util/argument/ObjectArguments;Lgg/aquatic/aquaticcrates/api/openprice/Price;)V", "getArgs", "()Lgg/aquatic/waves/util/argument/ObjectArguments;", "getPrice", "()Lgg/aquatic/aquaticcrates/api/openprice/Price;", "take", "", "player", "Lorg/bukkit/entity/Player;", "amount", "", "has", "", "api"}
)
public final class ConfiguredPrice {
   @NotNull
   private final ObjectArguments args;
   @NotNull
   private final Price price;

   public ConfiguredPrice(@NotNull ObjectArguments var1, @NotNull Price var2) {
      Intrinsics.checkNotNullParameter(var1, "args");
      Intrinsics.checkNotNullParameter(var2, "price");
      super();
      this.args = var1;
      this.price = var2;
   }

   @NotNull
   public final ObjectArguments getArgs() {
      return this.args;
   }

   @NotNull
   public final Price getPrice() {
      return this.price;
   }

   public final void take(@NotNull Player var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      this.price.take(var1, this.args, var2);
   }

   public final boolean has(@NotNull Player var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      return this.price.has(var1, this.args, var2);
   }
}
