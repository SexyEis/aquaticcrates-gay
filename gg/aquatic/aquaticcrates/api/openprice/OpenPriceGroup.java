package gg.aquatic.aquaticcrates.api.openprice;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.util.generic.ConfiguredExecutableObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/openprice/OpenPriceGroup;", "", "prices", "", "Lgg/aquatic/aquaticcrates/api/openprice/OpenPrice;", "failActions", "Lgg/aquatic/waves/util/generic/ConfiguredExecutableObject;", "Lorg/bukkit/entity/Player;", "", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getPrices", "()Ljava/util/List;", "getFailActions", "tryTake", "", "player", "amount", "", "api"}
)
@SourceDebugExtension({"SMAP\nOpenPriceGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OpenPriceGroup.kt\ngg/aquatic/aquaticcrates/api/openprice/OpenPriceGroup\n+ 2 CollectionExt.kt\ngg/aquatic/waves/util/collection/CollectionExtKt\n*L\n1#1,19:1\n21#2,4:20\n*S KotlinDebug\n*F\n+ 1 OpenPriceGroup.kt\ngg/aquatic/aquaticcrates/api/openprice/OpenPriceGroup\n*L\n16#1:20,4\n*E\n"})
public final class OpenPriceGroup {
   @NotNull
   private final List<OpenPrice> prices;
   @NotNull
   private final List<ConfiguredExecutableObject<Player, Unit>> failActions;

   public OpenPriceGroup(@NotNull List<OpenPrice> var1, @NotNull List<ConfiguredExecutableObject<Player, Unit>> var2) {
      Intrinsics.checkNotNullParameter(var1, "prices");
      Intrinsics.checkNotNullParameter(var2, "failActions");
      super();
      this.prices = var1;
      this.failActions = var2;
   }

   @NotNull
   public final List<OpenPrice> getPrices() {
      return this.prices;
   }

   @NotNull
   public final List<ConfiguredExecutableObject<Player, Unit>> getFailActions() {
      return this.failActions;
   }

   public final boolean tryTake(@NotNull Player var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Iterator var3 = this.prices.iterator();

      while(var3.hasNext()) {
         OpenPrice var4 = (OpenPrice)var3.next();
         if (var4.tryTake(var1, var2)) {
            return true;
         }
      }

      Collection var8 = (Collection)this.failActions;
      Function2 var9 = OpenPriceGroup::tryTake$lambda$0;
      boolean var5 = false;
      Iterator var6 = var8.iterator();

      while(var6.hasNext()) {
         ConfiguredExecutableObject var7 = (ConfiguredExecutableObject)var6.next();
         var7.execute(var1, var9);
      }

      return false;
   }

   private static final String tryTake$lambda$0(Player var0, String var1) {
      Intrinsics.checkNotNullParameter(var0, "p");
      Intrinsics.checkNotNullParameter(var1, "str");
      String var10002 = var0.getName();
      Intrinsics.checkNotNullExpressionValue(var10002, "getName(...)");
      return StringsKt.replace$default(var1, "%player%", var10002, false, 4, (Object)null);
   }
}
