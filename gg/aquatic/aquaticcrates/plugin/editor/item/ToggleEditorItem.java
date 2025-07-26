package gg.aquatic.aquaticcrates.plugin.editor.item;

import gg.aquatic.aquaticcrates.api.util.ItemBuilder;
import gg.aquatic.aquaticcrates.plugin.editor.menu.EditorMenu;
import gg.aquatic.waves.inventory.PacketInventory;
import gg.aquatic.waves.inventory.event.AsyncPacketInventoryInteractEvent;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.menu.component.Button;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/item/ToggleEditorItem;", "Lgg/aquatic/aquaticcrates/plugin/editor/item/EditorItem;", "currentState", "", "name", "", "lore", "", "dataApplier", "Lgg/aquatic/waves/libs/kotlin/Function1;", "", "<init>", "(ZLjava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getCurrentState", "()Z", "getName", "()Ljava/lang/String;", "getLore", "()Ljava/util/List;", "getDataApplier", "()Lkotlin/jvm/functions/Function1;", "itemStack", "Lorg/bukkit/inventory/ItemStack;", "getItemStack", "()Lorg/bukkit/inventory/ItemStack;", "execute", "event", "Lgg/aquatic/waves/inventory/event/AsyncPacketInventoryInteractEvent;", "plugin"}
)
@SourceDebugExtension({"SMAP\nToggleEditorItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ToggleEditorItem.kt\ngg/aquatic/aquaticcrates/plugin/editor/item/ToggleEditorItem\n+ 2 ItemBuilder.kt\ngg/aquatic/aquaticcrates/api/util/ItemBuilderKt\n*L\n1#1,38:1\n32#2:39\n*S KotlinDebug\n*F\n+ 1 ToggleEditorItem.kt\ngg/aquatic/aquaticcrates/plugin/editor/item/ToggleEditorItem\n*L\n17#1:39\n*E\n"})
public final class ToggleEditorItem implements EditorItem {
   private final boolean currentState;
   @NotNull
   private final String name;
   @NotNull
   private final List<String> lore;
   @NotNull
   private final Function1<Boolean, Unit> dataApplier;

   public ToggleEditorItem(boolean var1, @NotNull String var2, @NotNull List<String> var3, @NotNull Function1<? super Boolean, Unit> var4) {
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var3, "lore");
      Intrinsics.checkNotNullParameter(var4, "dataApplier");
      super();
      this.currentState = var1;
      this.name = var2;
      this.lore = var3;
      this.dataApplier = var4;
   }

   public final boolean getCurrentState() {
      return this.currentState;
   }

   @NotNull
   public final String getName() {
      return this.name;
   }

   @NotNull
   public final List<String> getLore() {
      return this.lore;
   }

   @NotNull
   public final Function1<Boolean, Unit> getDataApplier() {
      return this.dataApplier;
   }

   @NotNull
   public ItemStack getItemStack() {
      Material var2 = this.currentState ? Material.REDSTONE_TORCH : Material.LEVER;
      boolean var3 = false;
      ItemBuilder var4 = new ItemBuilder(var2);
      boolean var6 = false;
      var4.setDisplayName(this.name);
      ArrayList var7 = new ArrayList();
      CollectionsKt.addAll((Collection)var7, (Iterable)this.lore);
      ((Collection)var7).add("Current state: " + this.currentState);
      var4.setLore((List)var7);
      ItemStack var1 = var4.build();
      return var1;
   }

   public void execute(@NotNull AsyncPacketInventoryInteractEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "event");
      this.dataApplier.invoke(!this.currentState);
      PacketInventory var10000 = var1.getInventory();
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type gg.aquatic.aquaticcrates.plugin.editor.menu.EditorMenu");
      EditorMenu var2 = (EditorMenu)var10000;
      EditorMenu var3 = new EditorMenu(var2.getCrateModel(), var1.getViewer().getPlayer(), var2.getCategory().refresh(), var2.getPreviousMenu());
      var3.open();
   }

   @NotNull
   public Button createButton(@NotNull String var1, int var2, @NotNull Function2<? super String, ? super EditorMenu, String> var3) {
      return EditorItem.DefaultImpls.createButton(this, var1, var2, var3);
   }
}
