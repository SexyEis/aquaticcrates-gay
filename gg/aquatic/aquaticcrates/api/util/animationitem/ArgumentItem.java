package gg.aquatic.aquaticcrates.api.util.animationitem;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.animation.prop.ItemBasedProp;
import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.OpenableCrate;
import gg.aquatic.aquaticcrates.api.reward.Reward;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.random.Random;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.util.item.ItemStackExtKt;
import java.util.Locale;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/util/animationitem/ArgumentItem;", "", "type", "", "baseItem", "Lgg/aquatic/waves/item/AquaticItem;", "<init>", "(Ljava/lang/String;Lgg/aquatic/waves/item/AquaticItem;)V", "getType", "()Ljava/lang/String;", "getBaseItem", "()Lgg/aquatic/waves/item/AquaticItem;", "getActualItem", "animation", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "Companion", "api"}
)
public final class ArgumentItem {
   @NotNull
   public static final ArgumentItem.Companion Companion = new ArgumentItem.Companion((DefaultConstructorMarker)null);
   @NotNull
   private final String type;
   @Nullable
   private final AquaticItem baseItem;

   public ArgumentItem(@NotNull String var1, @Nullable AquaticItem var2) {
      Intrinsics.checkNotNullParameter(var1, "type");
      super();
      this.type = var1;
      this.baseItem = var2;
   }

   @NotNull
   public final String getType() {
      return this.type;
   }

   @Nullable
   public final AquaticItem getBaseItem() {
      return this.baseItem;
   }

   @NotNull
   public final AquaticItem getActualItem(@NotNull Animation var1) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      String var10000 = this.type.toLowerCase(Locale.ROOT);
      Intrinsics.checkNotNullExpressionValue(var10000, "toLowerCase(...)");
      AquaticItem var8;
      Reward var9;
      if (StringsKt.startsWith$default(var10000, "rewarditem:", false, 2, (Object)null)) {
         Integer var11 = StringsKt.toIntOrNull(StringsKt.substringAfter$default(this.type, "rewarditem:", (String)null, 2, (Object)null));
         int var7 = var11 != null ? var11 : 0;
         if (var1 instanceof CrateAnimation) {
            RolledReward var5 = (RolledReward)CollectionsKt.getOrNull(((CrateAnimation)var1).getRewards(), var7);
            if (var5 == null) {
               var5 = (RolledReward)CollectionsKt.firstOrNull(((CrateAnimation)var1).getRewards());
            }

            if (var5 != null) {
               var9 = var5.getReward();
               if (var9 != null) {
                  var8 = var9.getItem();
                  if (var8 != null) {
                     return var8;
                  }
               }
            }

            var8 = this.baseItem;
            if (var8 == null) {
               var8 = ItemStackExtKt.toCustomItem(Material.STONE);
            }
         } else {
            var8 = ItemStackExtKt.toCustomItem(Material.STONE);
         }

         return var8;
      } else {
         var10000 = this.type.toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var10000, "toLowerCase(...)");
         if (StringsKt.startsWith$default(var10000, "rumbling-reward:", false, 2, (Object)null)) {
            String var6 = StringsKt.substringAfter$default(this.type, "rumbling-reward:", (String)null, 2, (Object)null);
            Object var4 = var1.getProps().get("rumbling-reward:" + var6);
            ItemBasedProp var10 = var4 instanceof ItemBasedProp ? (ItemBasedProp)var4 : null;
            if ((var4 instanceof ItemBasedProp ? (ItemBasedProp)var4 : null) != null) {
               var8 = var10.item();
               if (var8 != null) {
                  return var8;
               }
            }

            var8 = ItemStackExtKt.toCustomItem(Material.STONE);
            return var8;
         } else {
            var10000 = this.type.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(var10000, "toLowerCase(...)");
            if (Intrinsics.areEqual(var10000, "randomrewarditem")) {
               if (var1 instanceof CrateAnimation) {
                  Crate var2 = ((CrateAnimation)var1).getAnimationManager().getCrate();
                  if (var2 instanceof OpenableCrate) {
                     var9 = (Reward)CollectionsKt.randomOrNull(((OpenableCrate)var2).getRewardManager().getRewards().values(), (Random)Random.Default);
                     if (var9 == null) {
                        return ItemStackExtKt.toCustomItem(Material.STONE);
                     }

                     Reward var3 = var9;
                     return var3.getItem();
                  }

                  var8 = ItemStackExtKt.toCustomItem(Material.STONE);
               } else {
                  var8 = ItemStackExtKt.toCustomItem(Material.STONE);
               }

               return var8;
            } else {
               var8 = this.baseItem;
               if (var8 == null) {
                  var8 = ItemStackExtKt.toCustomItem(Material.STONE);
               }

               return var8;
            }
         }
      }
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/util/animationitem/ArgumentItem$Companion;", "", "<init>", "()V", "loadFromYml", "Lgg/aquatic/aquaticcrates/api/util/animationitem/ArgumentItem;", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "api"}
   )
   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final ArgumentItem loadFromYml(@Nullable ConfigurationSection var1) {
         String var10000;
         label11: {
            if (var1 != null) {
               var10000 = var1.getString("type");
               if (var10000 != null) {
                  break label11;
               }
            }

            var10000 = "regular";
         }

         String var2 = var10000;
         AquaticItem var3 = ItemStackExtKt.loadFromYml(AquaticItem.Companion, var1);
         return new ArgumentItem(var2, var3);
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
