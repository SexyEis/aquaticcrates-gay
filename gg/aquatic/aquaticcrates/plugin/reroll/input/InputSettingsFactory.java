package gg.aquatic.aquaticcrates.plugin.reroll.input;

import gg.aquatic.aquaticcrates.api.reroll.RerollInput;
import gg.aquatic.waves.libs.kotlin.Metadata;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/reroll/input/InputSettingsFactory;", "", "serialize", "Lgg/aquatic/aquaticcrates/api/reroll/RerollInput;", "cfg", "Lorg/bukkit/configuration/file/FileConfiguration;", "plugin"}
)
public interface InputSettingsFactory {
   @Nullable
   RerollInput serialize(@NotNull FileConfiguration var1);
}
