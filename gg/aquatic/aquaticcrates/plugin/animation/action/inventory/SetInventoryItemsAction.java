package gg.aquatic.aquaticcrates.plugin.animation.action.inventory;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.api.util.animationitem.ArgumentItem;
import gg.aquatic.aquaticcrates.plugin.animation.prop.inventory.InventoryAnimationProp;
import gg.aquatic.waves.inventory.event.AsyncPacketInventoryInteractEvent;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.collections.MapsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.menu.AquaticMenu;
import gg.aquatic.waves.menu.MenuComponent;
import gg.aquatic.waves.menu.component.Button;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/inventory/SetInventoryItemsAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nSetInventoryItemsAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SetInventoryItemsAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/inventory/SetInventoryItemsAction\n+ 2 ObjectArguments.kt\ngg/aquatic/waves/util/argument/ObjectArguments\n*L\n1#1,43:1\n98#2,2:44\n*S KotlinDebug\n*F\n+ 1 SetInventoryItemsAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/inventory/SetInventoryItemsAction\n*L\n24#1:44,2\n*E\n"})
public final class SetInventoryItemsAction implements ExecutableObject<PlayerBoundAnimation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments = CollectionsKt.listOf(new OpenInventoryAction.ItemsArgument("items", MapsKt.emptyMap(), true));

   @NotNull
   public List<AquaticObjectArgument<?>> getArguments() {
      return this.arguments;
   }

   public void execute(@NotNull PlayerBoundAnimation var1, @NotNull ObjectArguments var2, @NotNull Function2<? super PlayerBoundAnimation, ? super String, String> var3) {
      Intrinsics.checkNotNullParameter(var1, "binder");
      Intrinsics.checkNotNullParameter(var2, "args");
      Intrinsics.checkNotNullParameter(var3, "textUpdater");
      AnimationProp var10000 = (AnimationProp)var1.getProps().get("inventory");
      if (var10000 != null) {
         InventoryAnimationProp var4 = (InventoryAnimationProp)var10000;
         String var7 = "items";
         Function1 var8 = (Function1)SetInventoryItemsAction$execute$$inlined$typed$default$1.INSTANCE;
         boolean var9 = false;
         Object var11 = var2.any(var7, var8);
         if (!(var11 instanceof Map)) {
            var11 = null;
         }

         Map var12 = (Map)var11;
         if (var12 != null) {
            Map var5 = var12;
            Iterator var6 = var5.entrySet().iterator();

            while(var6.hasNext()) {
               Entry var13 = (Entry)var6.next();
               int var14 = ((Number)var13.getKey()).intValue();
               ArgumentItem var15 = (ArgumentItem)var13.getValue();
               Button var10 = new Button("slot_" + var14, var15.getActualItem((Animation)var1).getItem(), (Collection)CollectionsKt.listOf(var14), 1, 1, (MenuComponent)null, SetInventoryItemsAction::execute$lambda$0, SetInventoryItemsAction::execute$lambda$1, SetInventoryItemsAction::execute$lambda$2);
               ((Map)var4.getMenu().getComponents()).put(var10.getId(), var10);
               var4.getMenu().updateComponent((MenuComponent)var10);
            }

         }
      }
   }

   private static final boolean execute$lambda$0(AquaticMenu var0) {
      Intrinsics.checkNotNullParameter(var0, "<unused var>");
      return true;
   }

   private static final String execute$lambda$1(PlayerBoundAnimation var0, String var1, AquaticMenu var2) {
      Intrinsics.checkNotNullParameter(var1, "str");
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      return var0.updatePlaceholders(var1);
   }

   private static final Unit execute$lambda$2(AsyncPacketInventoryInteractEvent var0) {
      Intrinsics.checkNotNullParameter(var0, "<unused var>");
      return Unit.INSTANCE;
   }
}
