package gg.aquatic.aquaticcrates.plugin.animation.action;

import com.destroystokyo.paper.ParticleBuilder;
import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.argument.impl.ItemObjectArgument;
import gg.aquatic.waves.util.argument.impl.PrimitiveObjectArgument;
import gg.aquatic.waves.util.audience.AquaticAudience;
import gg.aquatic.waves.util.generic.ExecutableObject;
import gg.aquatic.waves.util.item.ItemStackExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Particle.Trail;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/ParticleAnimationAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nParticleAnimationAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ParticleAnimationAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/ParticleAnimationAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ObjectArguments.kt\ngg/aquatic/waves/util/argument/ObjectArguments\n*L\n1#1,142:1\n1563#2:143\n1634#2,3:144\n1563#2:147\n1634#2,3:148\n1563#2:151\n1634#2,3:152\n1563#2:155\n1634#2,3:156\n1563#2:160\n1634#2,3:161\n1563#2:164\n1634#2,3:165\n774#2:168\n865#2,2:169\n1563#2:171\n1634#2,3:172\n1563#2:175\n1634#2,3:176\n99#3:159\n*S KotlinDebug\n*F\n+ 1 ParticleAnimationAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/ParticleAnimationAction\n*L\n53#1:143\n53#1:144,3\n63#1:147\n63#1:148,3\n64#1:151\n64#1:152,3\n75#1:155\n75#1:156,3\n98#1:160\n98#1:161,3\n99#1:164\n99#1:165,3\n118#1:168\n118#1:169,2\n127#1:171\n127#1:172,3\n135#1:175\n135#1:176,3\n86#1:159\n*E\n"})
public final class ParticleAnimationAction implements ExecutableObject<Animation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public ParticleAnimationAction() {
      AquaticObjectArgument[] var1 = new AquaticObjectArgument[]{new PrimitiveObjectArgument("particle", "example", true), new PrimitiveObjectArgument("block-material", "stone", false), new PrimitiveObjectArgument("dust-scale", 1.0F, false), new PrimitiveObjectArgument("color", "0;0;0", false), new PrimitiveObjectArgument("start-color", "0;0;0", false), new PrimitiveObjectArgument("end-color", "0;0;0", false), new PrimitiveObjectArgument("sculk-roll", 0.0F, false), new PrimitiveObjectArgument("delay", 1, false), new PrimitiveObjectArgument("vector", "0;0;0", false), new PrimitiveObjectArgument("duration", 1, false), new PrimitiveObjectArgument("location-offset", (Object)null, false), new PrimitiveObjectArgument("offset", "0;0;0", false), new PrimitiveObjectArgument("speed", 0.0F, false), new PrimitiveObjectArgument("count", 1, false), new ItemObjectArgument("item", ItemStackExtKt.toCustomItem(Material.STONE), false)};
      this.arguments = CollectionsKt.listOf(var1);
   }

   @NotNull
   public List<AquaticObjectArgument<?>> getArguments() {
      return this.arguments;
   }

   public void execute(@NotNull Animation var1, @NotNull ObjectArguments var2, @NotNull Function2<? super Animation, ? super String, String> var3) {
      Intrinsics.checkNotNullParameter(var1, "binder");
      Intrinsics.checkNotNullParameter(var2, "args");
      Intrinsics.checkNotNullParameter(var3, "textUpdater");
      String var10000 = var2.string("particle", ParticleAnimationAction::execute$lambda$0);
      if (var10000 != null) {
         String var4 = var10000;
         var10000 = var4.toUpperCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var10000, "toUpperCase(...)");
         Particle var5 = Particle.valueOf(var10000);
         int var10;
         String var11;
         List var12;
         String[] var13;
         boolean var14;
         boolean var15;
         Collection var16;
         boolean var17;
         Iterator var18;
         Object var19;
         String var20;
         boolean var21;
         boolean var22;
         float var30;
         Iterable var41;
         List var44;
         String[] var48;
         Iterable var49;
         boolean var55;
         Collection var61;
         boolean var68;
         Iterator var73;
         Object var77;
         boolean var78;
         String var81;
         Integer var87;
         CharSequence var88;
         Double var89;
         ParticleBuilder var91;
         Float var94;
         switch(ParticleAnimationAction.WhenMappings.$EnumSwitchMapping$0[var5.ordinal()]) {
         case 1:
         case 2:
         case 3:
         case 4:
         case 5:
            var10000 = var2.string("block-material", ParticleAnimationAction::execute$lambda$1);
            if (var10000 == null) {
               var10000 = "stone";
            }

            var10000 = var10000.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(var10000, "toUpperCase(...)");
            Material var33 = Material.valueOf(var10000);
            var91 = (new ParticleBuilder(var5)).data(var33).spawn().data(var33.createBlockData());
            break;
         case 6:
            var94 = var2.float("dust-scale", ParticleAnimationAction::execute$lambda$2);
            var30 = var94 != null ? var94 : 1.0F;
            var10000 = var2.string("color", ParticleAnimationAction::execute$lambda$3);
            if (var10000 == null) {
               var10000 = "0;0;0";
            }

            var11 = var10000;
            var88 = (CharSequence)var11;
            var13 = new String[]{";"};
            var41 = (Iterable)StringsKt.split$default(var88, var13, false, 0, 6, (Object)null);
            var14 = false;
            var16 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var41, 10)));
            var17 = false;
            var18 = var41.iterator();

            while(var18.hasNext()) {
               var19 = var18.next();
               var20 = (String)var19;
               var21 = false;
               var87 = StringsKt.toIntOrNull(var20);
               var16.add(var87 != null ? var87 : 0);
            }

            var12 = (List)var16;
            var91 = var5.builder().color(Color.fromRGB(((Number)var12.get(0)).intValue(), ((Number)var12.get(1)).intValue(), ((Number)var12.get(2)).intValue()), var30);
            break;
         case 7:
            var94 = var2.float("dust-scale", ParticleAnimationAction::execute$lambda$5);
            var30 = var94 != null ? var94 : 1.0F;
            var10000 = var2.string("start-color", ParticleAnimationAction::execute$lambda$6);
            if (var10000 == null) {
               var10000 = "0;0;0";
            }

            var11 = var10000;
            var10000 = var2.string("end-color", ParticleAnimationAction::execute$lambda$7);
            if (var10000 == null) {
               var10000 = "0;0;0";
            }

            String var39 = var10000;
            var88 = (CharSequence)var11;
            var48 = new String[]{";"};
            var49 = (Iterable)StringsKt.split$default(var88, var48, false, 0, 6, (Object)null);
            var15 = false;
            var61 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var49, 10)));
            var68 = false;
            var73 = var49.iterator();

            while(var73.hasNext()) {
               var77 = var73.next();
               var81 = (String)var77;
               var22 = false;
               var87 = StringsKt.toIntOrNull(var81);
               var61.add(var87 != null ? var87 : 0);
            }

            var44 = (List)var61;
            var88 = (CharSequence)var39;
            String[] var56 = new String[]{";"};
            Iterable var58 = (Iterable)StringsKt.split$default(var88, var56, false, 0, 6, (Object)null);
            var55 = false;
            Collection var74 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var58, 10)));
            boolean var76 = false;
            Iterator var80 = var58.iterator();

            while(var80.hasNext()) {
               Object var82 = var80.next();
               String var83 = (String)var82;
               boolean var23 = false;
               var87 = StringsKt.toIntOrNull(var83);
               var74.add(var87 != null ? var87 : 0);
            }

            List var57 = (List)var74;
            var91 = var5.builder().colorTransition(Color.fromRGB(((Number)var44.get(0)).intValue(), ((Number)var44.get(1)).intValue(), ((Number)var44.get(2)).intValue()), Color.fromRGB(((Number)var57.get(0)).intValue(), ((Number)var57.get(1)).intValue(), ((Number)var57.get(2)).intValue()), var30);
            break;
         case 8:
            var10000 = var2.string("color", ParticleAnimationAction::execute$lambda$10);
            if (var10000 == null) {
               var10000 = "0;0;0;0";
            }

            String var31 = var10000;
            var88 = (CharSequence)var31;
            String[] var34 = new String[]{";"};
            Iterable var36 = (Iterable)StringsKt.split$default(var88, var34, false, 0, 6, (Object)null);
            boolean var47 = false;
            Collection var52 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var36, 10)));
            var55 = false;
            Iterator var63 = var36.iterator();

            while(var63.hasNext()) {
               Object var70 = var63.next();
               String var75 = (String)var70;
               var78 = false;
               var87 = StringsKt.toIntOrNull(var75);
               var52.add(var87 != null ? var87 : 0);
            }

            List var32 = (List)var52;
            var91 = var5.builder().color(Color.fromRGB(((Number)var32.get(0)).intValue(), ((Number)var32.get(1)).intValue(), ((Number)var32.get(2)).intValue()));
            break;
         case 9:
            var94 = var2.float("sculk-roll", ParticleAnimationAction::execute$lambda$12);
            var30 = var94 != null ? var94 : 0.0F;
            var91 = var5.builder().data(var30);
            break;
         case 10:
            String var45 = "item";
            Function1 var51 = ParticleAnimationAction::execute$lambda$13;
            var15 = false;
            Object var92 = var2.any(var45, var51);
            if (!(var92 instanceof AquaticItem)) {
               var92 = null;
            }

            AquaticItem var93 = (AquaticItem)var92;
            if (var93 == null) {
               var93 = ItemStackExtKt.toCustomItem(Material.STONE);
            }

            AquaticItem var29 = var93;
            var91 = var5.builder().data(var29.getItem());
            break;
         case 11:
            var87 = var2.int("delay", ParticleAnimationAction::execute$lambda$14);
            var10 = var87 != null ? var87 : 1;
            var91 = var5.builder().data(var10);
            break;
         case 12:
            var87 = var2.int("duration", ParticleAnimationAction::execute$lambda$15);
            var10 = var87 != null ? var87 : 1;
            var10000 = var2.string("vector", ParticleAnimationAction::execute$lambda$16);
            if (var10000 == null) {
               var10000 = "0;0;0";
            }

            var11 = var10000;
            var88 = (CharSequence)var11;
            var13 = new String[]{";"};
            var41 = (Iterable)StringsKt.split$default(var88, var13, false, 0, 6, (Object)null);
            var14 = false;
            var16 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var41, 10)));
            var17 = false;
            var18 = var41.iterator();

            while(var18.hasNext()) {
               var19 = var18.next();
               var20 = (String)var19;
               var21 = false;
               var89 = StringsKt.toDoubleOrNull(var20);
               var16.add(var89 != null ? var89 : 0.0D);
            }

            var12 = (List)var16;
            var88 = (CharSequence)var11;
            var48 = new String[]{";"};
            var49 = (Iterable)StringsKt.split$default(var88, var48, false, 0, 6, (Object)null);
            var15 = false;
            var61 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var49, 10)));
            var68 = false;
            var73 = var49.iterator();

            while(var73.hasNext()) {
               var77 = var73.next();
               var81 = (String)var77;
               var22 = false;
               var87 = StringsKt.toIntOrNull(var81);
               var61.add(var87 != null ? var87 : 0);
            }

            var44 = (List)var61;
            Color var90 = Color.fromRGB(((Number)var44.get(0)).intValue(), ((Number)var44.get(1)).intValue(), ((Number)var44.get(2)).intValue());
            Intrinsics.checkNotNullExpressionValue(var90, "fromRGB(...)");
            Color var50 = var90;
            var91 = var5.builder().data(new Trail(var1.getBaseLocation().clone().add(new Vector(((Number)var12.get(0)).doubleValue(), ((Number)var12.get(1)).doubleValue(), ((Number)var12.get(2)).doubleValue())), var50, var10));
            break;
         default:
            var91 = var5.builder();
         }

         ParticleBuilder var7 = var91;
         Intrinsics.checkNotNull(var7);
         ParticleBuilder var6 = var7;
         Collection var95 = var2.stringOrCollection("location-offset", ParticleAnimationAction::execute$lambda$19);
         if (var95 == null) {
            var95 = (Collection)CollectionsKt.listOf("0;0;0");
         }

         Collection var26 = var95;
         Collection var10001 = Bukkit.getOnlinePlayers();
         Intrinsics.checkNotNullExpressionValue(var10001, "getOnlinePlayers(...)");
         Iterable var8 = (Iterable)var10001;
         boolean var9 = false;
         Collection var35 = (Collection)(new ArrayList());
         boolean var43 = false;
         Iterator var53 = var8.iterator();

         while(var53.hasNext()) {
            Object var59 = var53.next();
            Player var60 = (Player)var59;
            var55 = false;
            boolean var96;
            if (!Intrinsics.areEqual(var60.getLocation().getWorld(), var1.getBaseLocation().getWorld())) {
               var96 = false;
            } else if (var60.getLocation().distanceSquared(var1.getBaseLocation()) > 1000.0D) {
               var96 = false;
            } else {
               AquaticAudience var97 = var1.getAudience();
               Intrinsics.checkNotNull(var60);
               var96 = var97.canBeApplied(var60);
            }

            if (var96) {
               var35.add(var59);
            }
         }

         var6.receivers((List)var35);
         var10000 = var2.string("offset", ParticleAnimationAction::execute$lambda$21);
         if (var10000 == null) {
            var10000 = "0;0;0";
         }

         String var27 = var10000;
         var88 = (CharSequence)var27;
         String[] var37 = new String[]{";"};
         Iterable var40 = (Iterable)StringsKt.split$default(var88, var37, false, 0, 6, (Object)null);
         boolean var38 = false;
         Collection var54 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var40, 10)));
         var14 = false;
         Iterator var62 = var40.iterator();

         while(var62.hasNext()) {
            Object var64 = var62.next();
            String var71 = (String)var64;
            var68 = false;
            var89 = StringsKt.toDoubleOrNull(var71);
            var54.add(var89 != null ? var89 : 0.0D);
         }

         List var28 = (List)var54;
         var6.offset(((Number)var28.get(0)).doubleValue(), ((Number)var28.get(1)).doubleValue(), ((Number)var28.get(2)).doubleValue());
         var89 = var2.double("speed", ParticleAnimationAction::execute$lambda$23);
         double var42 = var89 != null ? var89 : 1.0D;
         var87 = var2.int("count", ParticleAnimationAction::execute$lambda$24);
         int var46 = var87 != null ? var87 : 1;
         var6.extra(var42).count(var46);
         var53 = var26.iterator();

         while(var53.hasNext()) {
            String var65 = (String)var53.next();
            var88 = (CharSequence)var65;
            String[] var67 = new String[]{";"};
            Iterable var69 = (Iterable)StringsKt.split$default(var88, var67, false, 0, 6, (Object)null);
            var17 = false;
            Collection var79 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var69, 10)));
            var78 = false;
            Iterator var84 = var69.iterator();

            while(var84.hasNext()) {
               Object var85 = var84.next();
               String var86 = (String)var85;
               boolean var24 = false;
               var89 = StringsKt.toDoubleOrNull(var86);
               var79.add(var89 != null ? var89 : 0.0D);
            }

            List var66 = (List)var79;
            Location var98 = var1.getBaseLocation().clone().add(new Vector(((Number)var66.get(0)).doubleValue(), ((Number)var66.get(1)).doubleValue(), ((Number)var66.get(2)).doubleValue()));
            Intrinsics.checkNotNullExpressionValue(var98, "add(...)");
            Location var72 = var98;
            var6.location(var72);
            var6.spawn();
         }

      }
   }

   private static final String execute$lambda$0(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$1(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$2(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$3(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$5(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$6(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$7(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$10(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$12(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$13(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$14(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$15(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$16(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$19(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$21(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$23(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final String execute$lambda$24(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   // $FF: synthetic class
   @Metadata(
      mv = {2, 1, 0},
      k = 3,
      xi = 48
   )
   public class WhenMappings {
      // $FF: synthetic field
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[Particle.values().length];

         try {
            var0[Particle.BLOCK.ordinal()] = 1;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[Particle.BLOCK_MARKER.ordinal()] = 2;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[Particle.FALLING_DUST.ordinal()] = 3;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[Particle.DUST_PLUME.ordinal()] = 4;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[Particle.BLOCK_CRUMBLE.ordinal()] = 5;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[Particle.DUST.ordinal()] = 6;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[Particle.DUST_COLOR_TRANSITION.ordinal()] = 7;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[Particle.ENTITY_EFFECT.ordinal()] = 8;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[Particle.SCULK_CHARGE.ordinal()] = 9;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[Particle.ITEM.ordinal()] = 10;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[Particle.SHRIEK.ordinal()] = 11;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[Particle.TRAIL.ordinal()] = 12;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
