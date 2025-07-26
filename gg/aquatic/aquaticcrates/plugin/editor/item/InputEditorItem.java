package gg.aquatic.aquaticcrates.plugin.editor.item;

import gg.aquatic.aquaticcrates.plugin.editor.menu.EditorMenu;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.input.InputHandle;
import gg.aquatic.waves.inventory.PacketInventory;
import gg.aquatic.waves.inventory.event.AsyncPacketInventoryInteractEvent;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.menu.component.Button;
import java.util.Collection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dBQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u001e"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/item/InputEditorItem;", "Lgg/aquatic/aquaticcrates/plugin/editor/item/EditorItem;", "itemStack", "Lorg/bukkit/inventory/ItemStack;", "inputHandle", "Lgg/aquatic/waves/input/InputHandle;", "dataApplier", "Lgg/aquatic/waves/libs/kotlin/Function1;", "", "", "chatMessage", "", "validator", "", "<init>", "(Lorg/bukkit/inventory/ItemStack;Lgg/aquatic/waves/input/InputHandle;Lkotlin/jvm/functions/Function1;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)V", "getItemStack", "()Lorg/bukkit/inventory/ItemStack;", "getInputHandle", "()Lgg/aquatic/waves/input/InputHandle;", "getDataApplier", "()Lkotlin/jvm/functions/Function1;", "getChatMessage", "()Ljava/util/Collection;", "getValidator", "execute", "event", "Lgg/aquatic/waves/inventory/event/AsyncPacketInventoryInteractEvent;", "Companion", "Builder", "plugin"}
)
@SourceDebugExtension({"SMAP\nInputEditorItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InputEditorItem.kt\ngg/aquatic/aquaticcrates/plugin/editor/item/InputEditorItem\n+ 2 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n*L\n1#1,61:1\n6#2,4:62\n*S KotlinDebug\n*F\n+ 1 InputEditorItem.kt\ngg/aquatic/aquaticcrates/plugin/editor/item/InputEditorItem\n*L\n24#1:62,4\n*E\n"})
public final class InputEditorItem implements EditorItem {
   @NotNull
   public static final InputEditorItem.Companion Companion = new InputEditorItem.Companion((DefaultConstructorMarker)null);
   @NotNull
   private final ItemStack itemStack;
   @NotNull
   private final InputHandle inputHandle;
   @NotNull
   private final Function1<String, Unit> dataApplier;
   @NotNull
   private final Collection<String> chatMessage;
   @NotNull
   private final Function1<String, Boolean> validator;

   public InputEditorItem(@NotNull ItemStack var1, @NotNull InputHandle var2, @NotNull Function1<? super String, Unit> var3, @NotNull Collection<String> var4, @NotNull Function1<? super String, Boolean> var5) {
      Intrinsics.checkNotNullParameter(var1, "itemStack");
      Intrinsics.checkNotNullParameter(var2, "inputHandle");
      Intrinsics.checkNotNullParameter(var3, "dataApplier");
      Intrinsics.checkNotNullParameter(var4, "chatMessage");
      Intrinsics.checkNotNullParameter(var5, "validator");
      super();
      this.itemStack = var1;
      this.inputHandle = var2;
      this.dataApplier = var3;
      this.chatMessage = var4;
      this.validator = var5;
   }

   // $FF: synthetic method
   public InputEditorItem(ItemStack var1, InputHandle var2, Function1 var3, Collection var4, Function1 var5, int var6, DefaultConstructorMarker var7) {
      if ((var6 & 8) != 0) {
         var4 = (Collection)CollectionsKt.emptyList();
      }

      if ((var6 & 16) != 0) {
         var5 = InputEditorItem::_init_$lambda$0;
      }

      this(var1, var2, var3, var4, var5);
   }

   @NotNull
   public ItemStack getItemStack() {
      return this.itemStack;
   }

   @NotNull
   public final InputHandle getInputHandle() {
      return this.inputHandle;
   }

   @NotNull
   public final Function1<String, Unit> getDataApplier() {
      return this.dataApplier;
   }

   @NotNull
   public final Collection<String> getChatMessage() {
      return this.chatMessage;
   }

   @NotNull
   public final Function1<String, Boolean> getValidator() {
      return this.validator;
   }

   public void execute(@NotNull AsyncPacketInventoryInteractEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "event");
      Player var2 = var1.getViewer().getPlayer();
      PacketInventory var10000 = var1.getInventory();
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type gg.aquatic.aquaticcrates.plugin.editor.menu.EditorMenu");
      EditorMenu var3 = (EditorMenu)var10000;
      boolean var4 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new InputEditorItem$execute$$inlined$runSync$1(var2, this, var3)));
   }

   @NotNull
   public Button createButton(@NotNull String var1, int var2, @NotNull Function2<? super String, ? super EditorMenu, String> var3) {
      return EditorItem.DefaultImpls.createButton(this, var1, var2, var3);
   }

   private static final boolean _init_$lambda$0(String var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      return true;
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001e\u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001b0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013¨\u0006 "},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/item/InputEditorItem$Builder;", "", "itemStack", "Lorg/bukkit/inventory/ItemStack;", "inputHandle", "Lgg/aquatic/waves/input/InputHandle;", "<init>", "(Lorg/bukkit/inventory/ItemStack;Lgg/aquatic/waves/input/InputHandle;)V", "getItemStack", "()Lorg/bukkit/inventory/ItemStack;", "getInputHandle", "()Lgg/aquatic/waves/input/InputHandle;", "validator", "Lgg/aquatic/waves/libs/kotlin/Function1;", "", "", "getValidator", "()Lkotlin/jvm/functions/Function1;", "setValidator", "(Lkotlin/jvm/functions/Function1;)V", "chatMessage", "", "getChatMessage", "()Ljava/util/Collection;", "setChatMessage", "(Ljava/util/Collection;)V", "dataApplier", "", "getDataApplier", "setDataApplier", "build", "Lgg/aquatic/aquaticcrates/plugin/editor/item/InputEditorItem;", "plugin"}
   )
   public static final class Builder {
      @NotNull
      private final ItemStack itemStack;
      @NotNull
      private final InputHandle inputHandle;
      @NotNull
      private Function1<? super String, Boolean> validator;
      @NotNull
      private Collection<String> chatMessage;
      @NotNull
      private Function1<? super String, Unit> dataApplier;

      public Builder(@NotNull ItemStack var1, @NotNull InputHandle var2) {
         Intrinsics.checkNotNullParameter(var1, "itemStack");
         Intrinsics.checkNotNullParameter(var2, "inputHandle");
         super();
         this.itemStack = var1;
         this.inputHandle = var2;
         this.validator = InputEditorItem.Builder::validator$lambda$0;
         this.chatMessage = (Collection)CollectionsKt.emptyList();
         this.dataApplier = InputEditorItem.Builder::dataApplier$lambda$1;
      }

      @NotNull
      public final ItemStack getItemStack() {
         return this.itemStack;
      }

      @NotNull
      public final InputHandle getInputHandle() {
         return this.inputHandle;
      }

      @NotNull
      public final Function1<String, Boolean> getValidator() {
         return this.validator;
      }

      public final void setValidator(@NotNull Function1<? super String, Boolean> var1) {
         Intrinsics.checkNotNullParameter(var1, "<set-?>");
         this.validator = var1;
      }

      @NotNull
      public final Collection<String> getChatMessage() {
         return this.chatMessage;
      }

      public final void setChatMessage(@NotNull Collection<String> var1) {
         Intrinsics.checkNotNullParameter(var1, "<set-?>");
         this.chatMessage = var1;
      }

      @NotNull
      public final Function1<String, Unit> getDataApplier() {
         return this.dataApplier;
      }

      public final void setDataApplier(@NotNull Function1<? super String, Unit> var1) {
         Intrinsics.checkNotNullParameter(var1, "<set-?>");
         this.dataApplier = var1;
      }

      @NotNull
      public final InputEditorItem build() {
         return new InputEditorItem(this.itemStack, this.inputHandle, this.dataApplier, this.chatMessage, this.validator);
      }

      private static final boolean validator$lambda$0(String var0) {
         Intrinsics.checkNotNullParameter(var0, "it");
         return true;
      }

      private static final Unit dataApplier$lambda$1(String var0) {
         Intrinsics.checkNotNullParameter(var0, "it");
         return Unit.INSTANCE;
      }
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\r¨\u0006\u000e"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/item/InputEditorItem$Companion;", "", "<init>", "()V", "builder", "Lgg/aquatic/aquaticcrates/plugin/editor/item/InputEditorItem;", "itemStack", "Lorg/bukkit/inventory/ItemStack;", "inputHandle", "Lgg/aquatic/waves/input/InputHandle;", "Lgg/aquatic/waves/libs/kotlin/Function1;", "Lgg/aquatic/aquaticcrates/plugin/editor/item/InputEditorItem$Builder;", "", "Lgg/aquatic/waves/libs/kotlin/ExtensionFunctionType;", "plugin"}
   )
   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final InputEditorItem builder(@NotNull ItemStack var1, @NotNull InputHandle var2, @NotNull Function1<? super InputEditorItem.Builder, Unit> var3) {
         Intrinsics.checkNotNullParameter(var1, "itemStack");
         Intrinsics.checkNotNullParameter(var2, "inputHandle");
         Intrinsics.checkNotNullParameter(var3, "builder");
         InputEditorItem.Builder var4 = new InputEditorItem.Builder(var1, var2);
         var3.invoke(var4);
         return var4.build();
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
