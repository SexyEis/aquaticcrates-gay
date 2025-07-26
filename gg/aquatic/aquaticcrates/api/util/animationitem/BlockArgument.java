package gg.aquatic.aquaticcrates.api.util.animationitem;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.argument.AbstractObjectArgumentSerializer;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.block.AquaticBlock;
import gg.aquatic.waves.util.block.AquaticBlockSerializer;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/util/animationitem/BlockArgument;", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "Lgg/aquatic/waves/util/block/AquaticBlock;", "id", "", "defaultValue", "required", "", "<init>", "(Ljava/lang/String;Lgg/aquatic/waves/util/block/AquaticBlock;Z)V", "serializer", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "getSerializer", "()Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "Serializer", "api"}
)
public final class BlockArgument extends AquaticObjectArgument<AquaticBlock> {
   @NotNull
   private final AbstractObjectArgumentSerializer<AquaticBlock> serializer;

   public BlockArgument(@NotNull String var1, @Nullable AquaticBlock var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "id");
      super(var1, var2, var3);
      this.serializer = (AbstractObjectArgumentSerializer)BlockArgument.Serializer.INSTANCE;
   }

   @NotNull
   public AbstractObjectArgumentSerializer<AquaticBlock> getSerializer() {
      return this.serializer;
   }

   @Nullable
   public AquaticBlock load(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      return (AquaticBlock)this.getSerializer().load(var1, this.getId());
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/util/animationitem/BlockArgument$Serializer;", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "Lgg/aquatic/waves/util/block/AquaticBlock;", "<init>", "()V", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "id", "", "api"}
   )
   public static final class Serializer extends AbstractObjectArgumentSerializer<AquaticBlock> {
      @NotNull
      public static final BlockArgument.Serializer INSTANCE = new BlockArgument.Serializer();

      private Serializer() {
      }

      @Nullable
      public AquaticBlock load(@NotNull ConfigurationSection var1, @NotNull String var2) {
         Intrinsics.checkNotNullParameter(var1, "section");
         Intrinsics.checkNotNullParameter(var2, "id");
         ConfigurationSection var10000 = var1.getConfigurationSection(var2);
         if (var10000 == null) {
            return null;
         } else {
            ConfigurationSection var3 = var10000;
            return AquaticBlockSerializer.INSTANCE.load(var3);
         }
      }
   }
}
