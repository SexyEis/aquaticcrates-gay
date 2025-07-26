package gg.aquatic.aquaticcrates.plugin.animation.prop.inventory;

import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.prop.PlayerBoundAnimationProp;
import gg.aquatic.waves.inventory.InventoryType;
import gg.aquatic.waves.inventory.event.AsyncPacketInventoryInteractEvent;
import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.menu.AquaticMenu;
import gg.aquatic.waves.menu.MenuComponent;
import gg.aquatic.waves.menu.component.Button;
import gg.aquatic.waves.util.StringExtKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/inventory/InventoryAnimationProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/PlayerBoundAnimationProp;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "title", "", "size", "", "items", "", "Lgg/aquatic/waves/item/AquaticItem;", "<init>", "(Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;Ljava/lang/String;ILjava/util/Map;)V", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "menu", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/inventory/AnimationMenu;", "getMenu", "()Lgg/aquatic/aquaticcrates/plugin/animation/prop/inventory/AnimationMenu;", "tick", "", "onAnimationEnd", "plugin"}
)
public final class InventoryAnimationProp extends PlayerBoundAnimationProp {
   @NotNull
   private final PlayerBoundAnimation animation;
   @NotNull
   private final AnimationMenu menu;

   public InventoryAnimationProp(@NotNull PlayerBoundAnimation var1, @NotNull String var2, int var3, @NotNull Map<Integer, AquaticItem> var4) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      Intrinsics.checkNotNullParameter(var2, "title");
      Intrinsics.checkNotNullParameter(var4, "items");
      super();
      this.animation = var1;
      AnimationMenu var10001 = new AnimationMenu;
      Component var10003 = StringExtKt.toMMComponent(this.getAnimation().updatePlaceholders(var2));
      InventoryType var10004;
      switch(var3) {
      case 9:
         var10004 = InventoryType.GENERIC9X1;
         break;
      case 18:
         var10004 = InventoryType.GENERIC9X2;
         break;
      case 27:
         var10004 = InventoryType.GENERIC9X3;
         break;
      case 36:
         var10004 = InventoryType.GENERIC9X4;
         break;
      case 45:
         var10004 = InventoryType.GENERIC9X5;
         break;
      case 54:
         var10004 = InventoryType.GENERIC9X6;
         break;
      default:
         var10004 = InventoryType.GENERIC9X6;
      }

      var10001.<init>(var10003, var10004, this.getAnimation().getPlayer());
      AnimationMenu var5 = var10001;
      AnimationMenu var6 = var5;
      boolean var7 = false;
      Iterator var8 = var4.entrySet().iterator();

      while(var8.hasNext()) {
         Entry var9 = (Entry)var8.next();
         int var10 = ((Number)var9.getKey()).intValue();
         AquaticItem var11 = (AquaticItem)var9.getValue();
         Map var12 = (Map)var6.getComponents();
         Pair var13 = TuplesKt.to("slot_" + var10, new Button("slot_" + var10, var11.getItem(), (Collection)CollectionsKt.listOf(var10), 1, 1, (MenuComponent)null, InventoryAnimationProp::menu$lambda$3$lambda$0, InventoryAnimationProp::menu$lambda$3$lambda$1, InventoryAnimationProp::menu$lambda$3$lambda$2));
         var12.put(var13.getFirst(), var13.getSecond());
      }

      this.menu = var5;
   }

   @NotNull
   public PlayerBoundAnimation getAnimation() {
      return this.animation;
   }

   @NotNull
   public final AnimationMenu getMenu() {
      return this.menu;
   }

   public void tick() {
   }

   public void onAnimationEnd() {
      this.menu.close();
   }

   private static final boolean menu$lambda$3$lambda$0(AquaticMenu var0) {
      Intrinsics.checkNotNullParameter(var0, "m");
      return true;
   }

   private static final String menu$lambda$3$lambda$1(InventoryAnimationProp var0, String var1, AquaticMenu var2) {
      Intrinsics.checkNotNullParameter(var1, "str");
      Intrinsics.checkNotNullParameter(var2, "menu");
      return var0.getAnimation().updatePlaceholders(var1);
   }

   private static final Unit menu$lambda$3$lambda$2(AsyncPacketInventoryInteractEvent var0) {
      Intrinsics.checkNotNullParameter(var0, "e");
      return Unit.INSTANCE;
   }
}
