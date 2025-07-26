package gg.aquatic.aquaticcrates.plugin.editor.item;

import gg.aquatic.aquaticcrates.plugin.editor.menu.EditorMenu;
import gg.aquatic.waves.inventory.event.AsyncPacketInventoryInteractEvent;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.reflect.KFunction;
import gg.aquatic.waves.menu.AquaticMenu;
import gg.aquatic.waves.menu.MenuComponent;
import gg.aquatic.waves.menu.component.Button;
import java.util.Collection;
import java.util.List;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J4\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u0011H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/item/EditorItem;", "", "itemStack", "Lorg/bukkit/inventory/ItemStack;", "getItemStack", "()Lorg/bukkit/inventory/ItemStack;", "execute", "", "event", "Lgg/aquatic/waves/inventory/event/AsyncPacketInventoryInteractEvent;", "createButton", "Lgg/aquatic/waves/menu/component/Button;", "id", "", "slot", "", "updater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "Lgg/aquatic/aquaticcrates/plugin/editor/menu/EditorMenu;", "plugin"}
)
public interface EditorItem {
   @NotNull
   ItemStack getItemStack();

   void execute(@NotNull AsyncPacketInventoryInteractEvent var1);

   @NotNull
   Button createButton(@NotNull String var1, int var2, @NotNull Function2<? super String, ? super EditorMenu, String> var3);

   @Metadata(
      mv = {2, 1, 0},
      k = 3,
      xi = 48
   )
   public static final class DefaultImpls {
      @NotNull
      public static Button createButton(@NotNull EditorItem var0, @NotNull String var1, int var2, @NotNull Function2<? super String, ? super EditorMenu, String> var3) {
         Intrinsics.checkNotNullParameter(var1, "id");
         Intrinsics.checkNotNullParameter(var3, "updater");
         ItemStack var5 = var0.getItemStack();
         List var6 = CollectionsKt.listOf(var2);
         KFunction var7 = (KFunction)(new Function1<AsyncPacketInventoryInteractEvent, Unit>(var0) {
            public final void invoke(AsyncPacketInventoryInteractEvent var1) {
               Intrinsics.checkNotNullParameter(var1, "p0");
               ((EditorItem)this.receiver).execute(var1);
            }
         });
         Button var4 = new Button(var1, var5, (Collection)var6, 1, 100, (MenuComponent)null, EditorItem.DefaultImpls::createButton$lambda$1, EditorItem.DefaultImpls::createButton$lambda$2, (Function1)var7);
         return var4;
      }

      // $FF: synthetic method
      public static Button createButton$default(EditorItem var0, String var1, int var2, Function2 var3, int var4, Object var5) {
         if (var5 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createButton");
         } else {
            if ((var4 & 4) != 0) {
               var3 = EditorItem.DefaultImpls::createButton$lambda$0;
            }

            return var0.createButton(var1, var2, var3);
         }
      }

      private static String createButton$lambda$0(String var0, EditorMenu var1) {
         Intrinsics.checkNotNullParameter(var0, "str");
         Intrinsics.checkNotNullParameter(var1, "<unused var>");
         return var0;
      }

      private static boolean createButton$lambda$1(AquaticMenu var0) {
         Intrinsics.checkNotNullParameter(var0, "it");
         return true;
      }

      private static String createButton$lambda$2(Function2 var0, String var1, AquaticMenu var2) {
         Intrinsics.checkNotNullParameter(var1, "str");
         Intrinsics.checkNotNullParameter(var2, "menu");
         return (String)var0.invoke(var1, (EditorMenu)var2);
      }
   }
}
