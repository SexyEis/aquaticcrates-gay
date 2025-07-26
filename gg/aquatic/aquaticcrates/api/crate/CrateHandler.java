package gg.aquatic.aquaticcrates.api.crate;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.util.Config;
import gg.aquatic.waves.util.location.AquaticLocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR9\u0010\n\u001a*\u0012\u0004\u0012\u00020\u0006\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007`\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\t¨\u0006\u001e"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/crate/CrateHandler;", "", "<init>", "()V", "crates", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lgg/aquatic/aquaticcrates/api/crate/Crate;", "getCrates", "()Ljava/util/concurrent/ConcurrentHashMap;", "cratesToSpawn", "Ljava/util/HashMap;", "Lgg/aquatic/waves/util/location/AquaticLocation;", "Lgg/aquatic/waves/libs/kotlin/collections/HashMap;", "getCratesToSpawn", "spawned", "Lorg/bukkit/Location;", "Lgg/aquatic/aquaticcrates/api/crate/SpawnedCrate;", "getSpawned", "spawnCrate", "crate", "location", "saveSpawnedCrates", "", "config", "Lgg/aquatic/waves/util/Config;", "loadSpawnedCrates", "onWorldLoad", "world", "Lorg/bukkit/World;", "api"}
)
@SourceDebugExtension({"SMAP\nCrateHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrateHandler.kt\ngg/aquatic/aquaticcrates/api/crate/CrateHandler\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,69:1\n382#2,7:70\n72#3,2:77\n1#4:79\n*S KotlinDebug\n*F\n+ 1 CrateHandler.kt\ngg/aquatic/aquaticcrates/api/crate/CrateHandler\n*L\n26#1:70,7\n57#1:77,2\n57#1:79\n*E\n"})
public final class CrateHandler {
   @NotNull
   public static final CrateHandler INSTANCE = new CrateHandler();
   @NotNull
   private static final ConcurrentHashMap<String, Crate> crates = new ConcurrentHashMap();
   @NotNull
   private static final ConcurrentHashMap<String, HashMap<AquaticLocation, Crate>> cratesToSpawn = new ConcurrentHashMap();
   @NotNull
   private static final ConcurrentHashMap<Location, SpawnedCrate> spawned = new ConcurrentHashMap();

   private CrateHandler() {
   }

   @NotNull
   public final ConcurrentHashMap<String, Crate> getCrates() {
      return crates;
   }

   @NotNull
   public final ConcurrentHashMap<String, HashMap<AquaticLocation, Crate>> getCratesToSpawn() {
      return cratesToSpawn;
   }

   @NotNull
   public final ConcurrentHashMap<Location, SpawnedCrate> getSpawned() {
      return spawned;
   }

   @NotNull
   public final SpawnedCrate spawnCrate(@NotNull Crate var1, @NotNull Location var2) {
      Intrinsics.checkNotNullParameter(var1, "crate");
      Intrinsics.checkNotNullParameter(var2, "location");
      SpawnedCrate var3 = new SpawnedCrate(var1, var2);
      ((Map)spawned).put(var2.clone(), var3);
      return var3;
   }

   public final void saveSpawnedCrates(@NotNull Config var1) {
      Intrinsics.checkNotNullParameter(var1, "config");
      var1.load();
      FileConfiguration var10000 = var1.getConfiguration();
      Intrinsics.checkNotNull(var10000);
      FileConfiguration var2 = var10000;
      HashMap var3 = new HashMap();
      Iterator var4 = ((Map)spawned).entrySet().iterator();

      Entry var5;
      while(var4.hasNext()) {
         var5 = (Entry)var4.next();
         Location var6 = (Location)var5.getKey();
         SpawnedCrate var7 = (SpawnedCrate)var5.getValue();
         Map var8 = (Map)var3;
         World var17 = var6.getWorld();
         Intrinsics.checkNotNull(var17);
         String var9 = var17.getName();
         boolean var10 = false;
         Object var11 = var8.get(var9);
         Object var18;
         if (var11 == null) {
            boolean var12 = false;
            List var16 = (List)(new ArrayList());
            var8.put(var9, var16);
            var18 = var16;
         } else {
            var18 = var11;
         }

         Collection var15 = (Collection)var18;
         double var19 = var6.getX();
         var15.add(var19 + ":" + var6.getY() + ":" + var6.getZ() + ":" + var6.getYaw() + ":" + var7.getCrate().getIdentifier());
      }

      var4 = ((Map)var3).entrySet().iterator();

      while(var4.hasNext()) {
         var5 = (Entry)var4.next();
         String var13 = (String)var5.getKey();
         List var14 = (List)var5.getValue();
         var2.set(var13, var14);
      }

      var1.save();
   }

   public final void loadSpawnedCrates(@NotNull Config var1) {
      Intrinsics.checkNotNullParameter(var1, "config");
      var1.load();
      FileConfiguration var10000 = var1.getConfiguration();
      Intrinsics.checkNotNull(var10000);
      FileConfiguration var2 = var10000;
      Iterator var3 = var2.getKeys(false).iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         List var27 = var2.getStringList(var4);
         Intrinsics.checkNotNullExpressionValue(var27, "getStringList(...)");
         List var5 = var27;
         Iterator var6 = var5.iterator();

         while(var6.hasNext()) {
            String var7 = (String)var6.next();
            Intrinsics.checkNotNull(var7);
            CharSequence var28 = (CharSequence)var7;
            String[] var9 = new String[]{":"};
            List var8 = StringsKt.split$default(var28, var9, false, 0, 6, (Object)null);
            Intrinsics.checkNotNull(var4);
            Double var10001 = StringsKt.toDoubleOrNull((String)var8.get(0));
            if (var10001 != null) {
               double var30 = var10001;
               Double var10002 = StringsKt.toDoubleOrNull((String)var8.get(1));
               if (var10002 != null) {
                  double var32 = var10002;
                  Double var10003 = StringsKt.toDoubleOrNull((String)var8.get(2));
                  if (var10003 != null) {
                     double var33 = var10003;
                     Float var10004 = StringsKt.toFloatOrNull((String)var8.get(3));
                     if (var10004 != null) {
                        float var34 = var10004;
                        float var17 = 0.0F;
                        float var18 = var34;
                        double var19 = var33;
                        double var21 = var32;
                        double var23 = var30;
                        AquaticLocation var26 = new AquaticLocation(var4, var23, var21, var19, var18, var17);
                        Crate var29 = (Crate)crates.get(var8.get(4));
                        if (var29 != null) {
                           Crate var10 = var29;
                           Location var11 = var26.toLocation();
                           if (var11 != null) {
                              this.spawnCrate(var10, var11);
                           } else {
                              ConcurrentMap var12 = (ConcurrentMap)cratesToSpawn;
                              boolean var13 = false;
                              Object var31 = var12.get(var4);
                              if (var31 == null) {
                                 boolean var14 = false;
                                 HashMap var15 = new HashMap();
                                 boolean var16 = false;
                                 var31 = var12.putIfAbsent(var4, var15);
                                 if (var31 == null) {
                                    var31 = var15;
                                 }
                              }

                              Intrinsics.checkNotNullExpressionValue(var31, "getOrPut(...)");
                              ((Map)var31).put(var26, var10);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public final void onWorldLoad(@NotNull World var1) {
      Intrinsics.checkNotNullParameter(var1, "world");
      HashMap var10000 = (HashMap)cratesToSpawn.get(var1.getName());
      if (var10000 != null) {
         HashMap var2 = var10000;
         Iterator var3 = ((Map)var2).entrySet().iterator();

         while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            AquaticLocation var5 = (AquaticLocation)var4.getKey();
            Crate var6 = (Crate)var4.getValue();
            Location var8 = var5.toLocation();
            if (var8 != null) {
               Location var7 = var8;
               this.spawnCrate(var6, var7);
            }
         }

      }
   }
}
