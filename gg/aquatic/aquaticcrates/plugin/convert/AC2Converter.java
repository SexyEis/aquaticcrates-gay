package gg.aquatic.aquaticcrates.plugin.convert;

import gg.aquatic.aquaticcrates.plugin.CratesPlugin;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.io.FilesKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.Config;
import gg.aquatic.waves.util.ConfigExtKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.MemoryConfiguration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/convert/AC2Converter;", "Lgg/aquatic/aquaticcrates/plugin/convert/Converter;", "<init>", "()V", "convert", "", "config", "Lgg/aquatic/waves/util/Config;", "plugin"}
)
@SourceDebugExtension({"SMAP\nAC2Converter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AC2Converter.kt\ngg/aquatic/aquaticcrates/plugin/convert/AC2Converter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,80:1\n1869#2,2:81\n*S KotlinDebug\n*F\n+ 1 AC2Converter.kt\ngg/aquatic/aquaticcrates/plugin/convert/AC2Converter\n*L\n56#1:81,2\n*E\n"})
public final class AC2Converter implements Converter {
   @NotNull
   public static final AC2Converter INSTANCE = new AC2Converter();

   private AC2Converter() {
   }

   public void convert(@NotNull Config var1) {
      Intrinsics.checkNotNullParameter(var1, "config");
      FileConfiguration var10000 = var1.getConfiguration();
      Intrinsics.checkNotNull(var10000);
      FileConfiguration var2 = var10000;
      File var27 = CratesPlugin.Companion.getINSTANCE().getDataFolder();
      Intrinsics.checkNotNullExpressionValue(var27, "getDataFolder(...)");
      File var3 = FilesKt.resolve(var27, "converted");
      var3.mkdirs();
      String var10003 = var1.getFile().getName();
      Intrinsics.checkNotNullExpressionValue(var10003, "getName(...)");
      Config var4 = new Config(FilesKt.resolve(var3, var10003), (JavaPlugin)CratesPlugin.Companion.getINSTANCE());
      var4.load();
      var10000 = var4.getConfiguration();
      Intrinsics.checkNotNull(var10000);
      FileConfiguration var5 = var10000;
      var5.set("display-name", var2.getString("display-name"));
      var5.set("key", var2.getConfigurationSection("key"));
      var5.set("key.requires-crate-to-open", (Object)null);
      if (!var2.getBoolean("requires-crate-to-open")) {
         var5.set("key.interaction.RIGHT.type", "CRATE_OPEN");
      }

      ConfigurationSection var28 = var2.getConfigurationSection("visual");
      ConfigurationSection var6;
      boolean var7;
      String var29;
      if (var28 != null) {
         var6 = var28;
         var7 = false;
         var29 = var6.getString("type");
         Intrinsics.checkNotNull(var29);
         String var8 = var29;
         ArrayList var9 = new ArrayList();
         var29 = var8.toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var29, "toLowerCase(...)");
         if (Intrinsics.areEqual(var29, "modelengine")) {
            MemoryConfiguration var10 = new MemoryConfiguration();
            var10.set("model", var2.getString("visual.model"));
            var10.set("type", "MODELENGINE");
            var9.add(var10);
         }

         var5.set("interactables", var9);
      }

      var28 = var2.getConfigurationSection("hologram");
      if (var28 != null) {
         var6 = var28;
         var7 = false;
         var5.set("offset", var6.getString("offset", "0;0;0"));
         ArrayList var18 = new ArrayList();
         Iterator var21 = ConfigExtKt.getSectionList(var6, "lines").iterator();

         while(var21.hasNext()) {
            ConfigurationSection var24 = (ConfigurationSection)var21.next();
            if (Intrinsics.areEqual(var24.getString("type"), "TEXT_DISPLAY")) {
               var18.add(var24);
               var24.set("type", "TEXT");
            }
         }
      }

      var28 = var2.getConfigurationSection("rewards");
      Object var31;
      if (var28 != null) {
         var6 = var28;
         var7 = false;
         Set var30 = var6.getKeys(false);
         Intrinsics.checkNotNullExpressionValue(var30, "getKeys(...)");
         Iterable var19 = (Iterable)var30;
         boolean var22 = false;
         Iterator var25 = var19.iterator();

         while(var25.hasNext()) {
            Object var11 = var25.next();
            String var12 = (String)var11;
            boolean var13 = false;
            var28 = var6.getConfigurationSection(var12);
            Intrinsics.checkNotNull(var28);
            ConfigurationSection var14 = var28;
            Iterator var15 = var14.getKeys(false).iterator();

            while(var15.hasNext()) {
               String var16 = (String)var15.next();
               Intrinsics.checkNotNull(var16);
               var29 = var16.toLowerCase(Locale.ROOT);
               Intrinsics.checkNotNullExpressionValue(var29, "toLowerCase(...)");
               if (!Intrinsics.areEqual(var29, "hologram")) {
                  var31 = var14.get(var16);
                  Intrinsics.checkNotNull(var31);
                  Object var17 = var31;
                  var5.set("rewards." + var12 + "." + var16, var17);
               }
            }
         }
      }

      var28 = var2.getConfigurationSection("preview");
      if (var28 != null) {
         var6 = var28;
         var7 = false;
         if (var6.getBoolean("openable-using-key")) {
            var5.set("key.interaction.LEFT.type", "PREVIEW-CRATE");
         }

         Iterator var20 = var6.getKeys(false).iterator();

         while(var20.hasNext()) {
            String var23 = (String)var20.next();
            Intrinsics.checkNotNull(var23);
            var29 = var23.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(var29, "toLowerCase(...)");
            if (!Intrinsics.areEqual(var29, "openable-using-key")) {
               var31 = var6.get(var23);
               Intrinsics.checkNotNull(var31);
               Object var26 = var31;
               var5.set("preview." + var23, var26);
            }
         }
      }

      var4.save();
   }
}
