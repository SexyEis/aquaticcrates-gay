package gg.aquatic.aquaticcrates.api.util;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.util.argument.AbstractObjectArgumentSerializer;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import java.util.List;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/util/VectorArgument;", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "Lorg/bukkit/util/Vector;", "id", "", "defaultValue", "required", "", "<init>", "(Ljava/lang/String;Lorg/bukkit/util/Vector;Z)V", "serializer", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "getSerializer", "()Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "Serializer", "api"}
)
public final class VectorArgument extends AquaticObjectArgument<Vector> {
   @NotNull
   private final AbstractObjectArgumentSerializer<Vector> serializer;

   public VectorArgument(@NotNull String var1, @Nullable Vector var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "id");
      super(var1, var2, var3);
      this.serializer = (AbstractObjectArgumentSerializer)VectorArgument.Serializer.INSTANCE;
   }

   @NotNull
   public AbstractObjectArgumentSerializer<Vector> getSerializer() {
      return this.serializer;
   }

   @Nullable
   public Vector load(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      Vector var10000 = VectorArgument.Serializer.INSTANCE.load(var1, this.getId());
      if (var10000 == null) {
         var10000 = (Vector)this.getDefaultValue();
      }

      return var10000;
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/util/VectorArgument$Serializer;", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "Lorg/bukkit/util/Vector;", "<init>", "()V", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "id", "", "api"}
   )
   public static final class Serializer extends AbstractObjectArgumentSerializer<Vector> {
      @NotNull
      public static final VectorArgument.Serializer INSTANCE = new VectorArgument.Serializer();

      private Serializer() {
      }

      @Nullable
      public Vector load(@NotNull ConfigurationSection var1, @NotNull String var2) {
         Intrinsics.checkNotNullParameter(var1, "section");
         Intrinsics.checkNotNullParameter(var2, "id");
         String var10000 = var1.getString(var2);
         if (var10000 == null) {
            return null;
         } else {
            String var3 = var10000;
            CharSequence var7 = (CharSequence)var3;
            String[] var5 = new String[]{";"};
            List var4 = StringsKt.split$default(var7, var5, false, 0, 6, (Object)null);
            if (var4.size() != 3) {
               return null;
            } else {
               Vector var6 = new Vector(Double.parseDouble((String)var4.get(0)), Double.parseDouble((String)var4.get(1)), Double.parseDouble((String)var4.get(2)));
               return var6;
            }
         }
      }
   }
}
