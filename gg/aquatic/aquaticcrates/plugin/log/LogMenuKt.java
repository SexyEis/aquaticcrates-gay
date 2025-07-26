package gg.aquatic.aquaticcrates.plugin.log;

import gg.aquatic.waves.libs.kotlin.Metadata;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"},
   d2 = {"toFriendlyTimeFromSeconds", "", "", "plugin"}
)
public final class LogMenuKt {
   @NotNull
   public static final String toFriendlyTimeFromSeconds(long var0) {
      long var2 = System.currentTimeMillis();
      long var4 = var2 - var0 * (long)'\uea60';
      if (var4 < 0L) {
         return "Just now";
      } else {
         long var6 = TimeUnit.MILLISECONDS.toSeconds(var4);
         if (var6 < 60L) {
            return var6 + " seconds ago";
         } else {
            long var8 = TimeUnit.MILLISECONDS.toMinutes(var4);
            if (var8 < 60L) {
               return var8 + " minutes ago";
            } else {
               long var10 = TimeUnit.MILLISECONDS.toHours(var4);
               if (var10 < 24L) {
                  return var10 + " hours ago";
               } else {
                  long var12 = TimeUnit.MILLISECONDS.toDays(var4);
                  if (var12 < 30L) {
                     return var12 + " days ago";
                  } else {
                     long var14 = var12 / (long)30;
                     if (var14 < 12L) {
                        return var14 + " months ago";
                     } else {
                        long var16 = var12 / (long)365;
                        return var16 + " years ago";
                     }
                  }
               }
            }
         }
      }
   }
}
