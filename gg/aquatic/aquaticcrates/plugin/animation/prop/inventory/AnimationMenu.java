package gg.aquatic.aquaticcrates.plugin.animation.prop.inventory;

import gg.aquatic.waves.inventory.InventoryType;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.menu.PrivateAquaticMenu;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/inventory/AnimationMenu;", "Lgg/aquatic/waves/menu/PrivateAquaticMenu;", "title", "Lnet/kyori/adventure/text/Component;", "type", "Lgg/aquatic/waves/inventory/InventoryType;", "player", "Lorg/bukkit/entity/Player;", "<init>", "(Lnet/kyori/adventure/text/Component;Lgg/aquatic/waves/inventory/InventoryType;Lorg/bukkit/entity/Player;)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "close", "", "plugin"}
)
public final class AnimationMenu extends PrivateAquaticMenu {
   private boolean closed;

   public AnimationMenu(@NotNull Component var1, @NotNull InventoryType var2, @NotNull Player var3) {
      Intrinsics.checkNotNullParameter(var1, "title");
      Intrinsics.checkNotNullParameter(var2, "type");
      Intrinsics.checkNotNullParameter(var3, "player");
      super(var1, var2, var3);
   }

   public final boolean getClosed() {
      return this.closed;
   }

   public final void setClosed(boolean var1) {
      this.closed = var1;
   }

   public final void close() {
      this.closed = true;
      this.getPlayer().closeInventory();
   }
}
