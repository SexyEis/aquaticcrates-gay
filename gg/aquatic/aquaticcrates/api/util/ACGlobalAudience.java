package gg.aquatic.aquaticcrates.api.util;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.audience.AquaticAudience;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\\\u0010\n\u001aB\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00050\u0005 \r* \u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u000b0\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/util/ACGlobalAudience;", "Lgg/aquatic/waves/util/audience/AquaticAudience;", "<init>", "()V", "hidden", "", "getHidden", "()Z", "setHidden", "(Z)V", "hiddenFrom", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "Lorg/bukkit/entity/Player;", "gg.aquatic.waves.libs.kotlin.jvm.PlatformType", "getHiddenFrom", "()Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "setHiddenFrom", "(Ljava/util/concurrent/ConcurrentHashMap$KeySetView;)V", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "uuids", "", "Ljava/util/UUID;", "getUuids", "()Ljava/util/Collection;", "canBeApplied", "player", "api"}
)
@SourceDebugExtension({"SMAP\nACGlobalAudience.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ACGlobalAudience.kt\ngg/aquatic/aquaticcrates/api/util/ACGlobalAudience\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,27:1\n1617#2,9:28\n1869#2:37\n1870#2:39\n1626#2:40\n1#3:38\n*S KotlinDebug\n*F\n+ 1 ACGlobalAudience.kt\ngg/aquatic/aquaticcrates/api/util/ACGlobalAudience\n*L\n19#1:28,9\n19#1:37\n19#1:39\n19#1:40\n19#1:38\n*E\n"})
public final class ACGlobalAudience implements AquaticAudience {
   private volatile boolean hidden;
   private KeySetView<Player, Boolean> hiddenFrom = ConcurrentHashMap.newKeySet();

   public final boolean getHidden() {
      return this.hidden;
   }

   public final void setHidden(boolean var1) {
      this.hidden = var1;
   }

   public final KeySetView<Player, Boolean> getHiddenFrom() {
      return this.hiddenFrom;
   }

   public final void setHiddenFrom(KeySetView<Player, Boolean> var1) {
      this.hiddenFrom = var1;
   }

   @NotNull
   public Collection<UUID> getUuids() {
      if (this.hidden) {
         return (Collection)CollectionsKt.emptyList();
      } else {
         Collection var10000 = Bukkit.getOnlinePlayers();
         Intrinsics.checkNotNullExpressionValue(var10000, "getOnlinePlayers(...)");
         Iterable var1 = (Iterable)var10000;
         boolean var2 = false;
         Collection var4 = (Collection)(new ArrayList());
         boolean var5 = false;
         boolean var7 = false;
         Iterator var8 = var1.iterator();

         while(var8.hasNext()) {
            Object var9 = var8.next();
            boolean var11 = false;
            Player var12 = (Player)var9;
            boolean var13 = false;
            UUID var16 = this.hiddenFrom.contains(var12) ? null : var12.getUniqueId();
            if (var16 != null) {
               UUID var14 = var16;
               boolean var15 = false;
               var4.add(var14);
            }
         }

         return (Collection)((List)var4);
      }
   }

   public boolean canBeApplied(@NotNull Player var1) {
      Intrinsics.checkNotNullParameter(var1, "player");
      if (this.hidden) {
         return false;
      } else {
         return this.hiddenFrom.contains(var1) ? false : var1.isOnline();
      }
   }
}
