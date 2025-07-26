package gg.aquatic.aquaticcrates.plugin.restriction.impl;

import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.CrateHandler;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.plugin.restriction.OpenData;
import gg.aquatic.aquaticcrates.plugin.restriction.OpenRestriction;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.argument.impl.PrimitiveObjectArgument;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0002\u0010\u0012R\u001e\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/restriction/impl/AllGlobalOpenRestriction;", "Lgg/aquatic/aquaticcrates/plugin/restriction/OpenRestriction;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "", "binder", "Lgg/aquatic/aquaticcrates/plugin/restriction/OpenData;", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "(Lgg/aquatic/aquaticcrates/plugin/restriction/OpenData;Lgg/aquatic/waves/util/argument/ObjectArguments;Lkotlin/jvm/functions/Function2;)Ljava/lang/Boolean;", "plugin"}
)
@SourceDebugExtension({"SMAP\nAllGlobalOpenRestriction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllGlobalOpenRestriction.kt\ngg/aquatic/aquaticcrates/plugin/restriction/impl/AllGlobalOpenRestriction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n1869#2,2:37\n*S KotlinDebug\n*F\n+ 1 AllGlobalOpenRestriction.kt\ngg/aquatic/aquaticcrates/plugin/restriction/impl/AllGlobalOpenRestriction\n*L\n25#1:37,2\n*E\n"})
public final class AllGlobalOpenRestriction extends OpenRestriction {
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
      Integer var10000 = var2.int("radius", AllGlobalOpenRestriction::execute$lambda$0);
      if (var10000 == null) {
         return true;
      } else {
         int var4 = var10000;
         Location var5 = var1.getLocation();
         List var6 = (List)(new ArrayList());
         Iterator var7 = ((Map)CrateHandler.INSTANCE.getCrates()).entrySet().iterator();

         while(true) {
            Crate var9;
            do {
               if (!var7.hasNext()) {
                  if (var6.isEmpty()) {
                     return true;
                  }

                  var7 = var6.iterator();

                  CrateAnimation var8;
                  do {
                     if (!var7.hasNext()) {
                        return true;
                     }

                     var8 = (CrateAnimation)var7.next();
                  } while(!Intrinsics.areEqual(var8.getBaseLocation().getWorld(), var5.getWorld()) || !(var8.getBaseLocation().distanceSquared(var5) <= (double)(var4 * var4)));

                  return false;
               }

               var9 = (Crate)((Entry)var7.next()).getValue();
            } while(!(var9 instanceof OpenableCrate));

            Collection var16 = ((OpenableCrate)var9).getAnimationManager().getPlayingAnimations().values();
            Intrinsics.checkNotNullExpressionValue(var16, "<get-values>(...)");
            Iterable var10 = (Iterable)var16;
            boolean var11 = false;
            Iterator var12 = var10.iterator();

            while(var12.hasNext()) {
               Object var13 = var12.next();
               Set var14 = (Set)var13;
               boolean var15 = false;
               Intrinsics.checkNotNull(var14);
               var6.addAll((Collection)var14);
            }
         }
      }
   }

   private static final String execute$lambda$0(Function2 var0, OpenData var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }
}
