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
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/openprice/OpenPrice;", "", "price", "Lgg/aquatic/aquaticcrates/api/openprice/ConfiguredPrice;", "failActions", "", "Lgg/aquatic/waves/util/generic/ConfiguredExecutableObject;", "Lorg/bukkit/entity/Player;", "", "<init>", "(Lgg/aquatic/aquaticcrates/api/openprice/ConfiguredPrice;Ljava/util/List;)V", "getPrice", "()Lgg/aquatic/aquaticcrates/api/openprice/ConfiguredPrice;", "getFailActions", "()Ljava/util/List;", "tryTake", "", "player", "amount", "", "api"}
)
@SourceDebugExtension({"SMAP\nOpenPrice.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OpenPrice.kt\ngg/aquatic/aquaticcrates/api/openprice/OpenPrice\n+ 2 CollectionExt.kt\ngg/aquatic/waves/util/collection/CollectionExtKt\n*L\n1#1,21:1\n21#2,4:22\n*S KotlinDebug\n*F\n+ 1 OpenPrice.kt\ngg/aquatic/aquaticcrates/api/openprice/OpenPrice\n*L\n17#1:22,4\n*E\n"})
public final class OpenPrice {
   @NotNull
   private final ConfiguredPrice price;
   @NotNull
   private final List<ConfiguredExecutableObject<Player, Unit>> failActions;

   public OpenPrice(@NotNull ConfiguredPrice var1, @NotNull List<ConfiguredExecutableObject<Player, Unit>> var2) {
      Intrinsics.checkNotNullParameter(var1, "price");
      Intrinsics.checkNotNullParameter(var2, "failActions");
      super();
      this.price = var1;
      this.failActions = var2;
   }

   @NotNull
   public final ConfiguredPrice getPrice() {
      return this.price;
   }

   @NotNull
   public final List<ConfiguredExecutableObject<Player, Unit>> getFailActions() {
      return this.failActions;
   }

   public final boolean tryTake(@NotNull Player var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      if (this.price.has(var1, var2)) {
         this.price.take(var1, var2);
         return true;
      } else {
         Collection var3 = (Collection)this.failActions;
         Function2 var4 = OpenPrice::tryTake$lambda$0;
         boolean var5 = false;
         Iterator var6 = var3.iterator();

         while(var6.hasNext()) {
            ConfiguredExecutableObject var7 = (ConfiguredExecutableObject)var6.next();
            var7.execute(var1, var4);
         }

         return false;
      }
   }

   private static final String tryTake$lambda$0(Player var0, String var1) {
      Intrinsics.checkNotNullParameter(var0, "p");
      Intrinsics.checkNotNullParameter(var1, "str");
      String var10002 = var0.getName();
      Intrinsics.checkNotNullExpressionValue(var10002, "getName(...)");
      return StringsKt.replace$default(var1, "%player%", var10002, false, 4, (Object)null);
   }
}
