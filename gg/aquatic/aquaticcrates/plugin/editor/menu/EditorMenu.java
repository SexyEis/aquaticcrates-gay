package gg.aquatic.aquaticcrates.plugin.editor.menu;

import com.google.gson.Gson;
import gg.aquatic.aquaticcrates.api.util.ItemBuilder;
import gg.aquatic.aquaticcrates.plugin.editor.EditorCategory;
import gg.aquatic.aquaticcrates.plugin.editor.data.CrateModel;
import gg.aquatic.aquaticcrates.plugin.editor.item.EditorItem;
import gg.aquatic.waves.inventory.InventoryType;
import gg.aquatic.waves.inventory.event.AsyncPacketInventoryInteractEvent;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.ranges.IntRange;
import gg.aquatic.waves.menu.MenuComponent;
import gg.aquatic.waves.menu.PrivateAquaticMenu;
import gg.aquatic.waves.menu.component.Button;
import java.util.Collection;
import java.util.Iterator;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/menu/EditorMenu;", "Lgg/aquatic/waves/menu/PrivateAquaticMenu;", "crateModel", "Lgg/aquatic/aquaticcrates/plugin/editor/data/CrateModel;", "player", "Lorg/bukkit/entity/Player;", "category", "Lgg/aquatic/aquaticcrates/plugin/editor/EditorCategory;", "previousMenu", "<init>", "(Lgg/aquatic/aquaticcrates/plugin/editor/data/CrateModel;Lorg/bukkit/entity/Player;Lgg/aquatic/aquaticcrates/plugin/editor/EditorCategory;Lgg/aquatic/aquaticcrates/plugin/editor/menu/EditorMenu;)V", "getCrateModel", "()Lgg/aquatic/aquaticcrates/plugin/editor/data/CrateModel;", "getCategory", "()Lgg/aquatic/aquaticcrates/plugin/editor/EditorCategory;", "getPreviousMenu", "()Lgg/aquatic/aquaticcrates/plugin/editor/menu/EditorMenu;", "plugin"}
)
@SourceDebugExtension({"SMAP\nEditorMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditorMenu.kt\ngg/aquatic/aquaticcrates/plugin/editor/menu/EditorMenu\n+ 2 ItemBuilder.kt\ngg/aquatic/aquaticcrates/api/util/ItemBuilderKt\n*L\n1#1,63:1\n32#2:64\n32#2:65\n*S KotlinDebug\n*F\n+ 1 EditorMenu.kt\ngg/aquatic/aquaticcrates/plugin/editor/menu/EditorMenu\n*L\n32#1:64\n45#1:65\n*E\n"})
public final class EditorMenu extends PrivateAquaticMenu {
   @NotNull
   private final CrateModel crateModel;
   @NotNull
   private final EditorCategory category;
   @Nullable
   private final EditorMenu previousMenu;

   public EditorMenu(@NotNull CrateModel var1, @NotNull Player var2, @NotNull EditorCategory var3, @Nullable EditorMenu var4) {
      Intrinsics.checkNotNullParameter(var1, "crateModel");
      Intrinsics.checkNotNullParameter(var2, "player");
      Intrinsics.checkNotNullParameter(var3, "category");
      TextComponent var10001 = Component.text("Editor | " + var1.getId());
      Intrinsics.checkNotNullExpressionValue(var10001, "text(...)");
      super((Component)var10001, InventoryType.GENERIC9X6, var2);
      this.crateModel = var1;
      this.category = var3;
      this.previousMenu = var4;
      int var5 = 0;
      Iterator var10000 = this.category.getItems().iterator();
      Intrinsics.checkNotNullExpressionValue(var10000, "iterator(...)");

      for(Iterator var6 = var10000; var6.hasNext(); ++var5) {
         Object var39 = var6.next();
         Intrinsics.checkNotNullExpressionValue(var39, "next(...)");
         Pair var7 = (Pair)var39;
         String var8 = (String)var7.component1();
         EditorItem var9 = (EditorItem)var7.component2();
         var2.sendMessage("Adding " + var8 + " to slot " + var5);
         this.addComponent((MenuComponent)var9.createButton(var8, var5, EditorMenu::_init_$lambda$0));
      }

      Material var36 = Material.BLACK_STAINED_GLASS_PANE;
      boolean var37 = false;
      ItemBuilder var38 = new ItemBuilder(var36);
      String var12 = "bg";
      boolean var10 = false;
      var38.setDisplayName(" ");
      Unit var13 = Unit.INSTANCE;
      ItemStack var10002 = var38.build();
      Collection var10003 = (Collection)CollectionsKt.toList((Iterable)(new IntRange(45, 53)));
      Object var14 = null;
      short var15 = 448;
      Object var16 = null;
      Object var17 = null;
      Object var18 = null;
      Object var19 = null;
      byte var20 = -1;
      byte var21 = 1;
      Collection var22 = var10003;
      ItemStack var23 = var10002;
      this.addComponent((MenuComponent)(new Button(var12, var23, var22, var21, var20, (MenuComponent)var19, (Function1)var18, (Function2)var17, (Function1)var16, var15, (DefaultConstructorMarker)var14)));
      if (this.previousMenu != null) {
         var36 = Material.ARROW;
         var37 = false;
         var38 = new ItemBuilder(var36);
         var12 = "previous";
         var10 = false;
         var38.setDisplayName("Previous");
         var13 = Unit.INSTANCE;
         var10002 = var38.build();
         var10003 = (Collection)CollectionsKt.listOf(49);
         Function1 var10009 = EditorMenu::_init_$lambda$3;
         Object var25 = null;
         short var26 = 192;
         Function1 var27 = var10009;
         Object var28 = null;
         Object var29 = null;
         Object var30 = null;
         byte var31 = -1;
         byte var32 = 2;
         Collection var33 = var10003;
         ItemStack var34 = var10002;
         this.addComponent((MenuComponent)(new Button(var12, var34, var33, var32, var31, (MenuComponent)var30, (Function1)var29, (Function2)var28, var27, var26, (DefaultConstructorMarker)var25)));
      }

      var2.sendMessage((new Gson()).toJson(this.crateModel));
   }

   // $FF: synthetic method
   public EditorMenu(CrateModel var1, Player var2, EditorCategory var3, EditorMenu var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 8) != 0) {
         var4 = null;
      }

      this(var1, var2, var3, var4);
   }

   @NotNull
   public final CrateModel getCrateModel() {
      return this.crateModel;
   }

   @NotNull
   public final EditorCategory getCategory() {
      return this.category;
   }

   @Nullable
   public final EditorMenu getPreviousMenu() {
      return this.previousMenu;
   }

   private static final String _init_$lambda$0(String var0, EditorMenu var1) {
      Intrinsics.checkNotNullParameter(var0, "str");
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      return var0;
   }

   private static final Unit _init_$lambda$3(EditorMenu var0, Player var1, AsyncPacketInventoryInteractEvent var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      EditorCategory var3 = var0.previousMenu.category;
      EditorMenu var4 = new EditorMenu(var0.crateModel, var1, var3.refresh(), var0.previousMenu.previousMenu);
      var4.open();
      return Unit.INSTANCE;
   }
}
