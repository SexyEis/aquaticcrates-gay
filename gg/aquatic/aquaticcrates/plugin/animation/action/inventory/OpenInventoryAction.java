package gg.aquatic.aquaticcrates.plugin.animation.action.inventory;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.util.animationitem.ArgumentItem;
import gg.aquatic.aquaticcrates.plugin.animation.prop.inventory.AnimationMenu;
import gg.aquatic.aquaticcrates.plugin.animation.prop.inventory.InventoryAnimationProp;
import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.collections.MapsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.menu.MenuSerializer;
import gg.aquatic.waves.menu.SlotSelection;
import gg.aquatic.waves.util.ConfigExtKt;
import gg.aquatic.waves.util.argument.AbstractObjectArgumentSerializer;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.argument.impl.PrimitiveObjectArgument;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004:\u0001\u0013B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/inventory/OpenInventoryAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "ItemsArgument", "plugin"}
)
@SourceDebugExtension({"SMAP\nOpenInventoryAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OpenInventoryAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/inventory/OpenInventoryAction\n+ 2 ObjectArguments.kt\ngg/aquatic/waves/util/argument/ObjectArguments\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,67:1\n99#2:68\n463#3:69\n413#3:70\n1252#4,4:71\n*S KotlinDebug\n*F\n+ 1 OpenInventoryAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/inventory/OpenInventoryAction\n*L\n29#1:68\n32#1:69\n32#1:70\n32#1:71,4\n*E\n"})
public final class OpenInventoryAction implements ExecutableObject<PlayerBoundAnimation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public OpenInventoryAction() {
      AquaticObjectArgument[] var1 = new AquaticObjectArgument[]{new PrimitiveObjectArgument("size", 9, true), new PrimitiveObjectArgument("title", "Inventory", true), new OpenInventoryAction.ItemsArgument("items", MapsKt.emptyMap(), true)};
      this.arguments = CollectionsKt.listOf(var1);
   }

   @NotNull
   public List<AquaticObjectArgument<?>> getArguments() {
      return this.arguments;
   }

   public void execute(@NotNull PlayerBoundAnimation var1, @NotNull ObjectArguments var2, @NotNull Function2<? super PlayerBoundAnimation, ? super String, String> var3) {
      Intrinsics.checkNotNullParameter(var1, "binder");
      Intrinsics.checkNotNullParameter(var2, "args");
      Intrinsics.checkNotNullParameter(var3, "textUpdater");
      Integer var10000 = var2.int("size", OpenInventoryAction::execute$lambda$0);
      int var4 = var10000 != null ? var10000 : 9;
      String var35 = var2.string("title", OpenInventoryAction::execute$lambda$1);
      if (var35 == null) {
         var35 = "Inventory";
      }

      String var5 = var35;
      String var9 = "items";
      Function1 var10 = OpenInventoryAction::execute$lambda$2;
      boolean var11 = false;
      Object var36 = var2.any(var9, var10);
      if (!(var36 instanceof Map)) {
         var36 = null;
      }

      Map var37 = (Map)var36;
      if (var37 == null) {
         var37 = MapsKt.emptyMap();
      }

      Map var6 = var37;
      boolean var32 = false;
      Map var34 = (Map)(new LinkedHashMap(MapsKt.mapCapacity(var6.size())));
      boolean var12 = false;
      Iterable var13 = (Iterable)var6.entrySet();
      boolean var14 = false;
      Iterator var15 = var13.iterator();

      while(var15.hasNext()) {
         Object var16 = var15.next();
         Entry var17 = (Entry)var16;
         boolean var19 = false;
         Object var10001 = var17.getKey();
         Entry var20 = (Entry)var16;
         Object var26 = var10001;
         boolean var21 = false;
         AquaticItem var27 = ((ArgumentItem)var20.getValue()).getActualItem((Animation)var1);
         var34.put(var26, var27);
      }

      InventoryAnimationProp var7 = new InventoryAnimationProp(var1, var5, var4, var34);
      Object var33 = var1.getProps().get("inventory");
      InventoryAnimationProp var8 = var33 instanceof InventoryAnimationProp ? (InventoryAnimationProp)var33 : null;
      if (var8 != null) {
         AnimationMenu var38 = var8.getMenu();
         if (var38 != null) {
            var38.close();
         }
      }

      var1.getProps().put("inventory", var7);
      var7.getMenu().open();
   }

   private static final String execute$lambda$0(Function2 var0, PlayerBoundAnimation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$1(Function2 var0, PlayerBoundAnimation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$2(Function2 var0, PlayerBoundAnimation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0001\u0013B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R(\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/inventory/OpenInventoryAction$ItemsArgument;", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "", "", "Lgg/aquatic/aquaticcrates/api/util/animationitem/ArgumentItem;", "id", "", "defaultValue", "required", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;Z)V", "serializer", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "getSerializer", "()Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "Companion", "plugin"}
   )
   public static final class ItemsArgument extends AquaticObjectArgument<Map<Integer, ? extends ArgumentItem>> {
      @NotNull
      public static final OpenInventoryAction.ItemsArgument.Companion Companion = new OpenInventoryAction.ItemsArgument.Companion((DefaultConstructorMarker)null);
      @NotNull
      private final AbstractObjectArgumentSerializer<Map<Integer, ArgumentItem>> serializer;

      public ItemsArgument(@NotNull String var1, @Nullable Map<Integer, ArgumentItem> var2, boolean var3) {
         Intrinsics.checkNotNullParameter(var1, "id");
         super(var1, var2, var3);
         this.serializer = (AbstractObjectArgumentSerializer)Companion;
      }

      @NotNull
      public AbstractObjectArgumentSerializer<Map<Integer, ArgumentItem>> getSerializer() {
         return this.serializer;
      }

      @NotNull
      public Map<Integer, ArgumentItem> load(@NotNull ConfigurationSection var1) {
         Intrinsics.checkNotNullParameter(var1, "section");
         return Companion.load(var1, this.getId());
      }

      @Metadata(
         mv = {2, 1, 0},
         k = 1,
         xi = 48,
         d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"},
         d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/inventory/OpenInventoryAction$ItemsArgument$Companion;", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "", "", "Lgg/aquatic/aquaticcrates/api/util/animationitem/ArgumentItem;", "<init>", "()V", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "id", "", "plugin"}
      )
      public static final class Companion extends AbstractObjectArgumentSerializer<Map<Integer, ? extends ArgumentItem>> {
         private Companion() {
         }

         @NotNull
         public Map<Integer, ArgumentItem> load(@NotNull ConfigurationSection var1, @NotNull String var2) {
            Intrinsics.checkNotNullParameter(var1, "section");
            Intrinsics.checkNotNullParameter(var2, "id");
            Map var3 = (Map)(new LinkedHashMap());
            Iterator var4 = ConfigExtKt.getSectionList(var1, var2).iterator();

            while(var4.hasNext()) {
               ConfigurationSection var5 = (ConfigurationSection)var4.next();
               MenuSerializer var10000 = MenuSerializer.INSTANCE;
               List var10001 = var5.getStringList("slots");
               Intrinsics.checkNotNullExpressionValue(var10001, "getStringList(...)");
               SlotSelection var6 = var10000.loadSlotSelection(var10001);
               ArgumentItem var7 = ArgumentItem.Companion.loadFromYml(var5);
               Iterator var8 = var6.getSlots().iterator();

               while(var8.hasNext()) {
                  int var9 = ((Number)var8.next()).intValue();
                  Integer var10 = var9;
                  var3.put(var10, var7);
               }
            }

            return var3;
         }

         // $FF: synthetic method
         public Companion(DefaultConstructorMarker var1) {
            this();
         }
      }
   }
}
