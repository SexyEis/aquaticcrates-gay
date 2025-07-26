package gg.aquatic.aquaticcrates.plugin.animation.action;

import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.argument.impl.ItemObjectArgument;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/EquipmentAnimationAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nEquipmentAnimationAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EquipmentAnimationAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/EquipmentAnimationAction\n+ 2 ObjectArguments.kt\ngg/aquatic/waves/util/argument/ObjectArguments\n*L\n1#1,73:1\n98#2,2:74\n98#2,2:76\n98#2,2:78\n98#2,2:80\n98#2,2:82\n98#2,2:84\n98#2,2:86\n*S KotlinDebug\n*F\n+ 1 EquipmentAnimationAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/EquipmentAnimationAction\n*L\n28#1:74,2\n29#1:76,2\n30#1:78,2\n31#1:80,2\n32#1:82,2\n33#1:84,2\n34#1:86,2\n*E\n"})
public final class EquipmentAnimationAction implements ExecutableObject<PlayerBoundAnimation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public EquipmentAnimationAction() {
      ItemObjectArgument[] var1 = new ItemObjectArgument[]{new ItemObjectArgument("helmet", (AquaticItem)null, false), new ItemObjectArgument("chestplate", (AquaticItem)null, false), new ItemObjectArgument("leggings", (AquaticItem)null, false), new ItemObjectArgument("boots", (AquaticItem)null, false), new ItemObjectArgument("hand", (AquaticItem)null, false), new ItemObjectArgument("offhand", (AquaticItem)null, false), new ItemObjectArgument("hotbar", (AquaticItem)null, false)};
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
      if (var1 instanceof CrateAnimation) {
         String var5 = "helmet";
         Function1 var6 = (Function1)EquipmentAnimationAction$execute$$inlined$typed$default$1.INSTANCE;
         boolean var7 = false;
         Object var10000 = var2.any(var5, var6);
         if (!(var10000 instanceof AquaticItem)) {
            var10000 = null;
         }

         AquaticItem var4 = (AquaticItem)var10000;
         String var19 = "chestplate";
         Function1 var21 = (Function1)EquipmentAnimationAction$execute$$inlined$typed$default$2.INSTANCE;
         boolean var8 = false;
         var10000 = var2.any(var19, var21);
         if (!(var10000 instanceof AquaticItem)) {
            var10000 = null;
         }

         AquaticItem var18 = (AquaticItem)var10000;
         String var22 = "leggings";
         Function1 var24 = (Function1)EquipmentAnimationAction$execute$$inlined$typed$default$3.INSTANCE;
         boolean var9 = false;
         var10000 = var2.any(var22, var24);
         if (!(var10000 instanceof AquaticItem)) {
            var10000 = null;
         }

         AquaticItem var20 = (AquaticItem)var10000;
         String var25 = "boots";
         Function1 var27 = (Function1)EquipmentAnimationAction$execute$$inlined$typed$default$4.INSTANCE;
         boolean var10 = false;
         var10000 = var2.any(var25, var27);
         if (!(var10000 instanceof AquaticItem)) {
            var10000 = null;
         }

         AquaticItem var23 = (AquaticItem)var10000;
         String var28 = "hand";
         Function1 var30 = (Function1)EquipmentAnimationAction$execute$$inlined$typed$default$5.INSTANCE;
         boolean var11 = false;
         var10000 = var2.any(var28, var30);
         if (!(var10000 instanceof AquaticItem)) {
            var10000 = null;
         }

         AquaticItem var26 = (AquaticItem)var10000;
         String var31 = "offhand";
         Function1 var33 = (Function1)EquipmentAnimationAction$execute$$inlined$typed$default$6.INSTANCE;
         boolean var12 = false;
         var10000 = var2.any(var31, var33);
         if (!(var10000 instanceof AquaticItem)) {
            var10000 = null;
         }

         AquaticItem var29 = (AquaticItem)var10000;
         String var34 = "hotbar";
         Function1 var35 = (Function1)EquipmentAnimationAction$execute$$inlined$typed$default$7.INSTANCE;
         boolean var13 = false;
         var10000 = var2.any(var34, var35);
         if (!(var10000 instanceof AquaticItem)) {
            var10000 = null;
         }

         AquaticItem var32 = (AquaticItem)var10000;
         boolean var14;
         ItemStack var36;
         ItemStack var38;
         if (var4 != null) {
            var38 = var4.getItem();
            if (var38 != null) {
               var36 = var38;
               var14 = false;
               ((Map)((CrateAnimation)var1).getPlayerEquipment()).put(CrateAnimation.EquipmentSlot.HELMET, var36);
            }
         }

         if (var18 != null) {
            var38 = var18.getItem();
            if (var38 != null) {
               var36 = var38;
               var14 = false;
               ((Map)((CrateAnimation)var1).getPlayerEquipment()).put(CrateAnimation.EquipmentSlot.CHESTPLATE, var36);
            }
         }

         if (var20 != null) {
            var38 = var20.getItem();
            if (var38 != null) {
               var36 = var38;
               var14 = false;
               ((Map)((CrateAnimation)var1).getPlayerEquipment()).put(CrateAnimation.EquipmentSlot.LEGGINGS, var36);
            }
         }

         if (var23 != null) {
            var38 = var23.getItem();
            if (var38 != null) {
               var36 = var38;
               var14 = false;
               ((Map)((CrateAnimation)var1).getPlayerEquipment()).put(CrateAnimation.EquipmentSlot.BOOTS, var36);
            }
         }

         if (var26 != null) {
            var38 = var26.getItem();
            if (var38 != null) {
               var36 = var38;
               var14 = false;
               ((Map)((CrateAnimation)var1).getPlayerEquipment()).put(CrateAnimation.EquipmentSlot.HAND, var36);
            }
         }

         if (var29 != null) {
            var38 = var29.getItem();
            if (var38 != null) {
               var36 = var38;
               var14 = false;
               ((Map)((CrateAnimation)var1).getPlayerEquipment()).put(CrateAnimation.EquipmentSlot.OFFHAND, var36);
            }
         }

         if (var32 != null) {
            var38 = var32.getItem();
            if (var38 != null) {
               var36 = var38;
               var14 = false;
               CrateAnimation.EquipmentSlot[] var15 = new CrateAnimation.EquipmentSlot[]{CrateAnimation.EquipmentSlot.NUM_0, CrateAnimation.EquipmentSlot.NUM_1, CrateAnimation.EquipmentSlot.NUM_2, CrateAnimation.EquipmentSlot.NUM_3, CrateAnimation.EquipmentSlot.NUM_4, CrateAnimation.EquipmentSlot.NUM_5, CrateAnimation.EquipmentSlot.NUM_6, CrateAnimation.EquipmentSlot.NUM_7, CrateAnimation.EquipmentSlot.NUM_8};
               List var16 = CollectionsKt.listOf(var15);
               Iterator var37 = var16.iterator();

               while(var37.hasNext()) {
                  CrateAnimation.EquipmentSlot var17 = (CrateAnimation.EquipmentSlot)var37.next();
                  ((Map)((CrateAnimation)var1).getPlayerEquipment()).put(var17, var36);
               }
            }
         }

         var1.getPlayer().updateInventory();
      }
   }
}
