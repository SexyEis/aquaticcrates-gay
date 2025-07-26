package gg.aquatic.aquaticcrates.api.player;

import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.Key;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.profile.AquaticPlayer;
import gg.aquatic.waves.profile.AquaticPlayerKt;
import java.util.ArrayList;
import java.util.Iterator;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0005¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/player/PlayerHandler;", "", "<init>", "()V", "virtualKeys", "", "player", "Lorg/bukkit/entity/Player;", "id", "", "(Lorg/bukkit/entity/Player;Ljava/lang/String;)Ljava/lang/Integer;", "key", "Lgg/aquatic/aquaticcrates/api/crate/Key;", "(Lorg/bukkit/entity/Player;Lgg/aquatic/aquaticcrates/api/crate/Key;)Ljava/lang/Integer;", "physicalKeys", "totalKeys", "takeKeys", "", "amount", "api"}
)
public final class PlayerHandler {
   @NotNull
   public static final PlayerHandler INSTANCE = new PlayerHandler();

   private PlayerHandler() {
   }

   @Nullable
   public final Integer virtualKeys(@NotNull Player var1, @NotNull String var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "id");
      AquaticPlayer var10000 = AquaticPlayerKt.toAquaticPlayer(var1);
      Integer var4;
      if (var10000 != null) {
         CrateProfileEntry var3 = CrateProfileModuleKt.crateEntry(var10000);
         if (var3 != null) {
            var4 = var3.balance(var2);
            return var4;
         }
      }

      var4 = null;
      return var4;
   }

   @Nullable
   public final Integer virtualKeys(@NotNull Player var1, @NotNull Key var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "key");
      return this.virtualKeys(var1, var2.getCrate().getIdentifier());
   }

   @Nullable
   public final Integer physicalKeys(@NotNull Player var1, @NotNull Key var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "key");
      AquaticPlayer var10000 = AquaticPlayerKt.toAquaticPlayer(var1);
      if (var10000 != null && CrateProfileModuleKt.crateEntry(var10000) != null) {
         int var3 = 0;
         ItemStack[] var4 = var1.getInventory().getStorageContents();
         int var5 = 0;

         for(int var6 = var4.length; var5 < var6; ++var5) {
            ItemStack var7 = var4[var5];
            Key.Companion var8 = Key.Companion;
            if (var7 != null) {
               if (Intrinsics.areEqual(var8.get(var7), var2)) {
                  var3 += var7.getAmount();
               }
            }
         }

         return var3;
      } else {
         return null;
      }
   }

   @Nullable
   public final Integer physicalKeys(@NotNull Player var1, @NotNull String var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "id");
      AquaticPlayer var10000 = AquaticPlayerKt.toAquaticPlayer(var1);
      if (var10000 != null && CrateProfileModuleKt.crateEntry(var10000) != null) {
         int var3 = 0;
         ItemStack[] var4 = var1.getInventory().getStorageContents();
         int var5 = 0;

         for(int var6 = var4.length; var5 < var6; ++var5) {
            ItemStack var7 = var4[var5];
            Key.Companion var8 = Key.Companion;
            if (var7 != null) {
               String var11;
               label27: {
                  Key var9 = var8.get(var7);
                  if (var9 != null) {
                     Crate var10 = var9.getCrate();
                     if (var10 != null) {
                        var11 = var10.getIdentifier();
                        break label27;
                     }
                  }

                  var11 = null;
               }

               if (Intrinsics.areEqual(var11, var2)) {
                  var3 += var7.getAmount();
               }
            }
         }

         return var3;
      } else {
         return null;
      }
   }

   @Nullable
   public final Integer totalKeys(@NotNull Player var1, @NotNull Key var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "key");
      return this.totalKeys(var1, var2.getCrate().getIdentifier());
   }

   @Nullable
   public final Integer totalKeys(@NotNull Player var1, @NotNull String var2) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "id");
      Integer var10000 = this.virtualKeys(var1, var2);
      if (var10000 != null) {
         int var3 = var10000;
         var10000 = this.physicalKeys(var1, var2);
         if (var10000 != null) {
            int var4 = var10000;
            return var3 + var4;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public final boolean takeKeys(@NotNull Player var1, @NotNull String var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "player");
      Intrinsics.checkNotNullParameter(var2, "id");
      Integer var10000 = this.virtualKeys(var1, var2);
      if (var10000 == null) {
         return false;
      } else {
         int var4 = var10000;
         ArrayList var5 = new ArrayList();
         ItemStack[] var6 = var1.getInventory().getStorageContents();
         int var7 = 0;

         for(int var8 = var6.length; var7 < var8; ++var7) {
            ItemStack var9 = var6[var7];
            Key.Companion var16 = Key.Companion;
            if (var9 != null) {
               Key var17 = var16.get(var9);
               if (var17 != null) {
                  Key var10 = var17;
                  if (Intrinsics.areEqual(var10.getCrate().getIdentifier(), var2)) {
                     var5.add(var9);
                     var4 += var9.getAmount();
                     if (var4 >= var3) {
                        var4 = var3;
                        break;
                     }
                  }
               }
            }
         }

         if (var4 < var3) {
            return false;
         } else {
            int var11 = var3;
            Iterator var18 = var5.iterator();
            Intrinsics.checkNotNullExpressionValue(var18, "iterator(...)");
            Iterator var12 = var18;

            while(var12.hasNext()) {
               Object var19 = var12.next();
               Intrinsics.checkNotNullExpressionValue(var19, "next(...)");
               ItemStack var14 = (ItemStack)var19;
               if (var14.getAmount() >= var11) {
                  var14.setAmount(var14.getAmount() - var11);
                  return true;
               }

               int var15 = var14.getAmount();
               var14.setAmount(0);
               var11 -= var15;
               if (var11 == 0) {
                  return true;
               }
            }

            if (var11 > 0) {
               AquaticPlayer var20 = AquaticPlayerKt.toAquaticPlayer(var1);
               if (var20 == null) {
                  return false;
               }

               CrateProfileEntry var21 = CrateProfileModuleKt.crateEntry(var20);
               if (var21 == null) {
                  return false;
               }

               CrateProfileEntry var13 = var21;
               var13.take(var11, var2);
            }

            return true;
         }
      }
   }
}
