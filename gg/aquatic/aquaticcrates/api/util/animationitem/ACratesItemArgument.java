package gg.aquatic.aquaticcrates.api.util.animationitem;

import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.argument.AbstractObjectArgumentSerializer;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.item.ItemStackExtKt;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/util/animationitem/ACratesItemArgument;", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "Lgg/aquatic/aquaticcrates/api/util/animationitem/ArgumentItem;", "id", "", "defaultValue", "required", "", "<init>", "(Ljava/lang/String;Lgg/aquatic/aquaticcrates/api/util/animationitem/ArgumentItem;Z)V", "serializer", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "getSerializer", "()Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "Serializer", "api"}
)
public final class ACratesItemArgument extends AquaticObjectArgument<ArgumentItem> {
   @NotNull
   private final AbstractObjectArgumentSerializer<ArgumentItem> serializer;

   public ACratesItemArgument(@NotNull String var1, @Nullable ArgumentItem var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "id");
      super(var1, var2, var3);
      this.serializer = (AbstractObjectArgumentSerializer)ACratesItemArgument.Serializer.INSTANCE;
   }

   @NotNull
   public AbstractObjectArgumentSerializer<ArgumentItem> getSerializer() {
      return this.serializer;
   }

   @NotNull
   public ArgumentItem load(@NotNull ConfigurationSection var1) {
      Intrinsics.checkNotNullParameter(var1, "section");
      return ACratesItemArgument.Serializer.INSTANCE.load(var1, this.getId());
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/util/animationitem/ACratesItemArgument$Serializer;", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "Lgg/aquatic/aquaticcrates/api/util/animationitem/ArgumentItem;", "<init>", "()V", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "id", "", "api"}
   )
   public static final class Serializer extends AbstractObjectArgumentSerializer<ArgumentItem> {
      @NotNull
      public static final ACratesItemArgument.Serializer INSTANCE = new ACratesItemArgument.Serializer();

      private Serializer() {
      }

      @NotNull
      public ArgumentItem load(@NotNull ConfigurationSection var1, @NotNull String var2) {
         Intrinsics.checkNotNullParameter(var1, "section");
         Intrinsics.checkNotNullParameter(var2, "id");
         ConfigurationSection var10000 = var1.getConfigurationSection(var2);
         if (var10000 == null) {
            return new ArgumentItem("rewarditem:0", (AquaticItem)null);
         } else {
            ConfigurationSection var3 = var10000;
            String var6 = var3.getString("type");
            if (var6 == null) {
               var6 = "regular";
            }

            String var4 = var6;
            AquaticItem var5 = ItemStackExtKt.loadFromYml(AquaticItem.Companion, var3);
            return new ArgumentItem(var4, var5);
         }
      }
   }
}
