package gg.aquatic.aquaticcrates.api.openprice;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import java.util.List;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&R\u001c\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/openprice/Price;", "", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "take", "", "player", "Lorg/bukkit/entity/Player;", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "amount", "", "has", "", "api"}
)
public interface Price {
   @NotNull
   List<AquaticObjectArgument<?>> getArguments();

   void take(@NotNull Player var1, @NotNull ObjectArguments var2, int var3);

   boolean has(@NotNull Player var1, @NotNull ObjectArguments var2, int var3);
}
