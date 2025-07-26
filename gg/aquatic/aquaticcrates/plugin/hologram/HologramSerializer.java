package gg.aquatic.aquaticcrates.plugin.hologram;

import gg.aquatic.aquaticcrates.api.hologram.AquaticHologramSettings;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.util.ConfigExtKt;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/hologram/HologramSerializer;", "", "<init>", "()V", "loadAquaticHologram", "Lgg/aquatic/aquaticcrates/api/hologram/AquaticHologramSettings;", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "plugin"}
)
public final class HologramSerializer {
   @NotNull
   public static final HologramSerializer INSTANCE = new HologramSerializer();

   private HologramSerializer() {
   }

   @NotNull
   public final AquaticHologramSettings loadAquaticHologram(@Nullable ConfigurationSection var1) {
      if (var1 == null) {
         return new AquaticHologramSettings((Set)(new HashSet()), new Vector());
      } else {
         String var10000 = var1.getString("offset", "0;1.5;0");
         Intrinsics.checkNotNull(var10000);
         CharSequence var6 = (CharSequence)var10000;
         String[] var3 = new String[]{";"};
         List var2 = StringsKt.split$default(var6, var3, false, 0, 6, (Object)null);
         Vector var5 = new Vector(Double.parseDouble((String)var2.get(0)), Double.parseDouble((String)var2.get(1)), Double.parseDouble((String)var2.get(2)));
         Set var4 = gg.aquatic.waves.hologram.HologramSerializer.INSTANCE.loadLines(ConfigExtKt.getSectionList(var1, "lines"));
         Bukkit.getConsoleSender().sendMessage("Loaded hologram with " + var4.size() + " lines");
         return new AquaticHologramSettings(var4, var5);
      }
   }
}
