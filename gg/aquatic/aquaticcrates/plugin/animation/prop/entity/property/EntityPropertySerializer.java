package gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property;

import gg.aquatic.waves.libs.kotlin.Metadata;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/EntityPropertySerializer;", "", "load", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/EntityProperty;", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "plugin"}
)
public interface EntityPropertySerializer {
   @NotNull
   EntityProperty load(@NotNull ConfigurationSection var1);
}
