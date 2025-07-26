package gg.aquatic.aquaticcrates.api.openprice;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.argument.ArgumentSerializer;
import gg.aquatic.waves.util.argument.ObjectArguments;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t¨\u0006\u000b"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/openprice/PriceSerializer;", "", "<init>", "()V", "fromSection", "Lgg/aquatic/aquaticcrates/api/openprice/ConfiguredPrice;", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "fromSections", "", "sections", "api"}
)
@SourceDebugExtension({"SMAP\nPrice.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Price.kt\ngg/aquatic/aquaticcrates/api/openprice/PriceSerializer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,30:1\n1617#2,9:31\n1869#2:40\n1870#2:42\n1626#2:43\n1#3:41\n*S KotlinDebug\n*F\n+ 1 Price.kt\ngg/aquatic/aquaticcrates/api/openprice/PriceSerializer\n*L\n28#1:31,9\n28#1:40\n28#1:42\n28#1:43\n28#1:41\n*E\n"})
public final class PriceSerializer {
   @NotNull
   public static final PriceSerializer INSTANCE = new PriceSerializer();

   private PriceSerializer() {
   }

   @Nullable
   public final ConfiguredPrice fromSection(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      String var10000 = var1.getString("type");
      if (var10000 == null) {
         return null;
      } else {
         String var2 = var10000;
         Price var5 = (Price)PriceKt.getPRICES().get(var2);
         if (var5 == null) {
            return null;
         } else {
            Price var3 = var5;
            Map var4 = ArgumentSerializer.INSTANCE.load(var1, (Collection)var3.getArguments());
            return new ConfiguredPrice(new ObjectArguments(var4), var3);
         }
      }
   }

   @NotNull
   public final List<ConfiguredPrice> fromSections(@NotNull List<? extends ConfigurationSection> var1) {
      Intrinsics.checkNotNullParameter(var1, "sections");
      Iterable var2 = (Iterable)var1;
      boolean var3 = false;
      Collection var5 = (Collection)(new ArrayList());
      boolean var6 = false;
      boolean var8 = false;
      Iterator var9 = var2.iterator();

      while(var9.hasNext()) {
         Object var10 = var9.next();
         boolean var12 = false;
         ConfigurationSection var13 = (ConfigurationSection)var10;
         boolean var14 = false;
         ConfiguredPrice var10000 = INSTANCE.fromSection(var13);
         if (var10000 != null) {
            ConfiguredPrice var15 = var10000;
            boolean var16 = false;
            var5.add(var15);
         }
      }

      return (List)var5;
   }
}
