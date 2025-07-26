package gg.aquatic.aquaticcrates.api.util;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.util.argument.AbstractObjectArgumentSerializer;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0012B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\"\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/util/VectorListArgument;", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "", "Lorg/bukkit/util/Vector;", "id", "", "defaultValue", "required", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Z)V", "serializer", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "getSerializer", "()Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "Serializer", "api"}
)
public final class VectorListArgument extends AquaticObjectArgument<List<? extends Vector>> {
   @NotNull
   private final AbstractObjectArgumentSerializer<List<Vector>> serializer;

   public VectorListArgument(@NotNull String var1, @Nullable List<? extends Vector> var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "id");
      super(var1, var2, var3);
      this.serializer = (AbstractObjectArgumentSerializer)VectorListArgument.Serializer.INSTANCE;
   }

   @NotNull
   public AbstractObjectArgumentSerializer<List<Vector>> getSerializer() {
      return this.serializer;
   }

   @Nullable
   public List<Vector> load(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      return VectorListArgument.Serializer.INSTANCE.load(var1, this.getId());
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/util/VectorListArgument$Serializer;", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "", "Lorg/bukkit/util/Vector;", "<init>", "()V", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "id", "", "api"}
   )
   public static final class Serializer extends AbstractObjectArgumentSerializer<List<? extends Vector>> {
      @NotNull
      public static final VectorListArgument.Serializer INSTANCE = new VectorListArgument.Serializer();

      private Serializer() {
      }

      @NotNull
      public List<Vector> load(@NotNull ConfigurationSection var1, @NotNull String var2) {
         Intrinsics.checkNotNullParameter(var1, "section");
         Intrinsics.checkNotNullParameter(var2, "id");
         List var10000 = var1.getStringList(var2);
         Intrinsics.checkNotNullExpressionValue(var10000, "getStringList(...)");
         List var3 = var10000;
         List var4 = (List)(new ArrayList());
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            String var6 = (String)var5.next();
            Intrinsics.checkNotNull(var6);
            CharSequence var9 = (CharSequence)var6;
            String[] var8 = new String[]{";"};
            List var7 = StringsKt.split$default(var9, var8, false, 0, 6, (Object)null);
            if (var7.size() == 3) {
               Vector var10 = new Vector(Double.parseDouble((String)var7.get(0)), Double.parseDouble((String)var7.get(1)), Double.parseDouble((String)var7.get(2)));
               var4.add(var10);
            }
         }

         return var4;
      }
   }
}
