package gg.aquatic.aquaticcrates.plugin.log;

import gg.aquatic.aquaticcrates.api.player.CrateProfileDriver;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.input.impl.ChatInput;
import gg.aquatic.waves.inventory.ButtonType;
import gg.aquatic.waves.inventory.event.AsyncPacketInventoryInteractEvent;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.menu.AquaticMenu;
import gg.aquatic.waves.menu.MenuComponent;
import gg.aquatic.waves.menu.PrivateAquaticMenu;
import gg.aquatic.waves.menu.settings.IButtonSettings;
import gg.aquatic.waves.util.ComponentExtKt;
import gg.aquatic.waves.util.PAPIUtilKt;
import gg.aquatic.waves.util.StringExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020#H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/log/LogMenu;", "Lgg/aquatic/waves/menu/PrivateAquaticMenu;", "settings", "Lgg/aquatic/aquaticcrates/plugin/log/LogMenuSettings;", "player", "Lorg/bukkit/entity/Player;", "<init>", "(Lgg/aquatic/aquaticcrates/plugin/log/LogMenuSettings;Lorg/bukkit/entity/Player;)V", "getSettings", "()Lgg/aquatic/aquaticcrates/plugin/log/LogMenuSettings;", "value", "", "crateFilter", "getCrateFilter", "()Ljava/lang/String;", "playerFilter", "getPlayerFilter", "", "page", "getPage", "()I", "Lgg/aquatic/aquaticcrates/api/player/CrateProfileDriver$Sorting;", "sorting", "getSorting", "()Lgg/aquatic/aquaticcrates/api/player/CrateProfileDriver$Sorting;", "", "isLoading", "()Z", "hasNextPage", "getHasNextPage", "entryComponents", "Ljava/util/ArrayList;", "Lgg/aquatic/waves/menu/MenuComponent;", "Lgg/aquatic/waves/libs/kotlin/collections/ArrayList;", "loadButtons", "", "applyFilters", "loadEntries", "plugin"}
)
@SourceDebugExtension({"SMAP\nLogMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LogMenu.kt\ngg/aquatic/aquaticcrates/plugin/log/LogMenu\n+ 2 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,236:1\n12#2,4:237\n6#2,4:242\n6#2,4:246\n1#3:241\n*S KotlinDebug\n*F\n+ 1 LogMenu.kt\ngg/aquatic/aquaticcrates/plugin/log/LogMenu\n*L\n164#1:237,4\n78#1:242,4\n113#1:246,4\n*E\n"})
public final class LogMenu extends PrivateAquaticMenu {
   @NotNull
   private final LogMenuSettings settings;
   @Nullable
   private String crateFilter;
   @Nullable
   private String playerFilter;
   private int page;
   @NotNull
   private CrateProfileDriver.Sorting sorting;
   private volatile boolean isLoading;
   private boolean hasNextPage;
   @NotNull
   private final ArrayList<MenuComponent> entryComponents;

   public LogMenu(@NotNull LogMenuSettings var1, @NotNull Player var2) {
      Intrinsics.checkNotNullParameter(var1, "settings");
      Intrinsics.checkNotNullParameter(var2, "player");
      super(var1.getMenuSettings().getTitle(), var1.getMenuSettings().getType(), var2);
      this.settings = var1;
      this.sorting = CrateProfileDriver.Sorting.NEWEST;
      this.entryComponents = new ArrayList();
      this.loadButtons();
      this.loadEntries();
   }

   @NotNull
   public final LogMenuSettings getSettings() {
      return this.settings;
   }

   @Nullable
   public final String getCrateFilter() {
      return this.crateFilter;
   }

   @Nullable
   public final String getPlayerFilter() {
      return this.playerFilter;
   }

   public final int getPage() {
      return this.page;
   }

   @NotNull
   public final CrateProfileDriver.Sorting getSorting() {
      return this.sorting;
   }

   public final boolean isLoading() {
      return this.isLoading;
   }

   public final boolean getHasNextPage() {
      return this.hasNextPage;
   }

   private final void loadButtons() {
      Iterator var1 = ((Map)this.settings.getMenuSettings().getComponents()).entrySet().iterator();

      while(var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         String var3 = (String)var2.getKey();
         IButtonSettings var4 = (IButtonSettings)var2.getValue();
         this.addComponent(var4.create(LogMenu::loadButtons$lambda$1, LogMenu::loadButtons$lambda$8));
      }

   }

   private final void applyFilters() {
      this.page = 0;
      this.loadEntries();
   }

   private final void loadEntries() {
      this.isLoading = true;
      Iterator var1 = CollectionsKt.toMutableList((Collection)this.entryComponents).iterator();

      while(var1.hasNext()) {
         MenuComponent var2 = (MenuComponent)var1.next();
         this.removeComponent(var2);
      }

      this.entryComponents.clear();
      boolean var3 = false;
      Waves.Companion.getINSTANCE().getServer().getScheduler().runTaskAsynchronously((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new LogMenu$loadEntries$$inlined$runAsync$1(this)));
   }

   private static final String loadButtons$lambda$1(LogMenu var0, String var1, AquaticMenu var2) {
      Intrinsics.checkNotNullParameter(var1, "str");
      Intrinsics.checkNotNullParameter(var2, "menu");
      String var10000 = StringsKt.replace$default(PAPIUtilKt.updatePAPIPlaceholders(var1, var0.getPlayer()), "%page%", String.valueOf(var0.page + 1), false, 4, (Object)null);
      String var10001 = "%sorting%";
      String var10002 = var0.sorting.name().toLowerCase(Locale.ROOT);
      Intrinsics.checkNotNullExpressionValue(var10002, "toLowerCase(...)");
      String var3 = var10002;
      if (((CharSequence)var3).length() > 0) {
         StringBuilder var11 = new StringBuilder();
         char var4 = var3.charAt(0);
         StringBuilder var8 = var11;
         String var7 = "%sorting%";
         String var6 = var10000;
         boolean var5 = false;
         var10000 = String.valueOf(var4);
         Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type java.lang.String");
         var10000 = var10000.toUpperCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var10000, "toUpperCase(...)");
         CharSequence var9 = (CharSequence)var10000;
         var10000 = var6;
         var10001 = var7;
         var11 = var8.append(var9);
         byte var10 = 1;
         String var10003 = var3.substring(var10);
         Intrinsics.checkNotNullExpressionValue(var10003, "substring(...)");
         var10002 = var11.append(var10003).toString();
      } else {
         var10002 = var3;
      }

      var10000 = StringsKt.replace$default(var10000, var10001, var10002, false, 4, (Object)null);
      var10002 = var0.playerFilter;
      if (var10002 == null) {
         var10002 = "";
      }

      var10000 = StringsKt.replace$default(var10000, "%player-filter%", var10002, false, 4, (Object)null);
      var10002 = var0.crateFilter;
      if (var10002 == null) {
         var10002 = "";
      }

      return StringsKt.replace$default(var10000, "%crate-filter%", var10002, false, 4, (Object)null);
   }

   private static final Unit loadButtons$lambda$8$lambda$3(LogMenu var0, String var1) {
      String var10000 = var1;
      if (var1 == null) {
         var10000 = "";
      }

      String var2 = var10000;
      if (((CharSequence)var2).length() == 0) {
         var0.playerFilter = null;
         var0.applyFilters();
         var0.open();
         return Unit.INSTANCE;
      } else {
         var0.playerFilter = var2;
         var0.applyFilters();
         var0.open();
         return Unit.INSTANCE;
      }
   }

   private static final void loadButtons$lambda$8$lambda$4(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit loadButtons$lambda$8$lambda$6(LogMenu var0, String var1) {
      String var10000 = var1;
      if (var1 == null) {
         var10000 = "";
      }

      String var2 = var10000;
      if (((CharSequence)var2).length() == 0) {
         var0.crateFilter = null;
         var0.applyFilters();
         var0.open();
         return Unit.INSTANCE;
      } else {
         var0.crateFilter = var2;
         var0.applyFilters();
         var0.open();
         return Unit.INSTANCE;
      }
   }

   private static final void loadButtons$lambda$8$lambda$7(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit loadButtons$lambda$8(String var0, LogMenu var1, AsyncPacketInventoryInteractEvent var2) {
      Intrinsics.checkNotNullParameter(var2, "e");
      int var3;
      boolean var4;
      switch(var0.hashCode()) {
      case -887731735:
         if (var0.equals("prev-page")) {
            if (var1.isLoading) {
               return Unit.INSTANCE;
            }

            if (var1.page <= 0) {
               return Unit.INSTANCE;
            }

            var3 = var1.page;
            var1.page = var3 + -1;
            var1.loadEntries();
         }
         break;
      case 3536286:
         if (var0.equals("sort")) {
            CrateProfileDriver.Sorting var5 = var1.sorting.ordinal() + 1 >= CrateProfileDriver.Sorting.getEntries().size() ? (CrateProfileDriver.Sorting)CrateProfileDriver.Sorting.getEntries().get(0) : (CrateProfileDriver.Sorting)CrateProfileDriver.Sorting.getEntries().get(var1.sorting.ordinal() + 1);
            var1.sorting = var5;
            var1.applyFilters();
            return Unit.INSTANCE;
         }
         break;
      case 45654210:
         if (var0.equals("crate-filter")) {
            if (var2.getButtonType() == ButtonType.RIGHT) {
               if (var1.crateFilter == null) {
                  return Unit.INSTANCE;
               }

               var1.crateFilter = null;
               var1.applyFilters();
               return Unit.INSTANCE;
            }

            if (var2.getButtonType() == ButtonType.LEFT) {
               var4 = false;
               Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new LogMenu$loadButtons$lambda$8$$inlined$runSync$2(var1)));
               ComponentExtKt.send((CommandSender)var1.getPlayer(), StringExtKt.toMMComponent("&7Crate Filter\n\n&fIn order to apply the crate filter, please enter the crate ID you would like to filter by.\n&fIf you want to cancel the edit, please type &ccancel&f."));
               ChatInput.createHandle$default(ChatInput.INSTANCE, (List)null, 1, (Object)null).await(var1.getPlayer()).thenAccept(LogMenu::loadButtons$lambda$8$lambda$7);
               return Unit.INSTANCE;
            }
         }
         break;
      case 996789220:
         if (var0.equals("player-filter")) {
            if (var2.getButtonType() == ButtonType.RIGHT) {
               if (var1.playerFilter == null) {
                  return Unit.INSTANCE;
               }

               var1.playerFilter = null;
               var1.applyFilters();
               return Unit.INSTANCE;
            }

            if (var2.getButtonType() == ButtonType.LEFT) {
               var4 = false;
               Waves.Companion.getINSTANCE().getServer().getScheduler().runTask((Plugin)Waves.Companion.getINSTANCE(), (Runnable)(new LogMenu$loadButtons$lambda$8$$inlined$runSync$1(var1)));
               ComponentExtKt.send((CommandSender)var1.getPlayer(), StringExtKt.toMMComponent("&7Player Filter\n\n&fIn order to apply the player filter, please enter the player name you would like to filter by.\n&fIf you want to cancel the edit, please type &ccancel&f."));
               ChatInput.createHandle$default(ChatInput.INSTANCE, (List)null, 1, (Object)null).await(var1.getPlayer()).thenAccept(LogMenu::loadButtons$lambda$8$lambda$4);
            }
         }
         break;
      case 1170921769:
         if (var0.equals("next-page")) {
            if (var1.isLoading) {
               return Unit.INSTANCE;
            }

            if (!var1.hasNextPage) {
               return Unit.INSTANCE;
            }

            var3 = var1.page++;
            var1.loadEntries();
         }
      }

      return Unit.INSTANCE;
   }

   // $FF: synthetic method
   public static final void access$setHasNextPage$p(LogMenu var0, boolean var1) {
      var0.hasNextPage = var1;
   }

   // $FF: synthetic method
   public static final ArrayList access$getEntryComponents$p(LogMenu var0) {
      return var0.entryComponents;
   }

   // $FF: synthetic method
   public static final void access$setLoading$p(LogMenu var0, boolean var1) {
      var0.isLoading = var1;
   }
}
