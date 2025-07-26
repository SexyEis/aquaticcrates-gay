package gg.aquatic.aquaticcrates.plugin.restriction.impl;

import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.plugin.restriction.OpenData;
import gg.aquatic.aquaticcrates.plugin.restriction.OpenRestriction;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.argument.impl.PrimitiveObjectArgument;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0002\u0010\u0012R\u001e\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/restriction/impl/PlayerOpenRestriction;", "Lgg/aquatic/aquaticcrates/plugin/restriction/OpenRestriction;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "", "binder", "Lgg/aquatic/aquaticcrates/plugin/restriction/OpenData;", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "(Lgg/aquatic/aquaticcrates/plugin/restriction/OpenData;Lgg/aquatic/waves/util/argument/ObjectArguments;Lkotlin/jvm/functions/Function2;)Ljava/lang/Boolean;", "plugin"}
)
public final class PlayerOpenRestriction extends OpenRestriction {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments = CollectionsKt.listOf(new PrimitiveObjectArgument("radius", 5, true));

   @NotNull
   public List<AquaticObjectArgument<?>> getArguments() {
      return this.arguments;
   }

   @NotNull
   public Boolean execute(@NotNull OpenData var1, @NotNull ObjectArguments var2, @NotNull Function2<? super OpenData, ? super String, String> var3) {
      Intrinsics.checkNotNullParameter(var1, "binder");
      Intrinsics.checkNotNullParameter(var2, "args");
      Intrinsics.checkNotNullParameter(var3, "textUpdater");
      Integer var10000 = var2.int("radius", PlayerOpenRestriction::execute$lambda$0);
      if (var10000 != null) {
         int var4 = var10000;
         Player var5 = var1.getPlayer();
         Location var6 = var1.getLocation();
         OpenableCrate var7 = var1.getCrate();
         Set var11 = (Set)var7.getAnimationManager().getPlayingAnimations().get(var5.getUniqueId());
         if (var11 == null) {
            return true;
         } else {
            Set var8 = var11;
            if (var8.isEmpty()) {
               return true;
            } else {
               Iterator var9 = var8.iterator();

               CrateAnimation var10;
               do {
                  if (!var9.hasNext()) {
                     return true;
                  }

                  var10 = (CrateAnimation)var9.next();
               } while(!Intrinsics.areEqual(var10.getBaseLocation().getWorld(), var6.getWorld()) || !(var10.getBaseLocation().distanceSquared(var6) <= (double)(var4 * var4)));

               return false;
            }
         }
      } else {
         return true;
      }
   }

   private static final String execute$lambda$0(Function2 var0, OpenData var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }
}
