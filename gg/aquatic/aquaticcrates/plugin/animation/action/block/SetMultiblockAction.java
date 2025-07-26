package gg.aquatic.aquaticcrates.plugin.animation.action.block;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.aquaticcrates.api.util.VectorListArgument;
import gg.aquatic.aquaticcrates.api.util.animationitem.BlockArgument;
import gg.aquatic.aquaticcrates.plugin.animation.prop.block.BlockAnimationProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.block.AquaticBlock;
import gg.aquatic.waves.util.block.impl.VanillaBlock;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/block/SetMultiblockAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nSetMultiblockAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SetMultiblockAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/block/SetMultiblockAction\n+ 2 ObjectArguments.kt\ngg/aquatic/waves/util/argument/ObjectArguments\n*L\n1#1,36:1\n98#2,2:37\n98#2,2:39\n*S KotlinDebug\n*F\n+ 1 SetMultiblockAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/block/SetMultiblockAction\n*L\n25#1:37,2\n26#1:39,2\n*E\n"})
public final class SetMultiblockAction implements ExecutableObject<Animation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public SetMultiblockAction() {
      AquaticObjectArgument[] var1 = new AquaticObjectArgument[]{new VectorListArgument("offsets", CollectionsKt.emptyList(), false), null};
      BlockData var10008 = Material.STONE.createBlockData();
      Intrinsics.checkNotNullExpressionValue(var10008, "createBlockData(...)");
      var1[1] = new BlockArgument("block", (AquaticBlock)(new VanillaBlock(var10008)), true);
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
      String var6 = "offsets";
      Function1 var7 = (Function1)SetMultiblockAction$execute$$inlined$typed$default$1.INSTANCE;
      boolean var8 = false;
      Object var10000 = var2.any(var6, var7);
      if (!(var10000 instanceof List)) {
         var10000 = null;
      }

      List var16 = (List)var10000;
      if (var16 != null) {
         List var4 = var16;
         String var11 = "block";
         Function1 var13 = (Function1)SetMultiblockAction$execute$$inlined$typed$default$2.INSTANCE;
         boolean var9 = false;
         var10000 = var2.any(var11, var13);
         if (!(var10000 instanceof AquaticBlock)) {
            var10000 = null;
         }

         AquaticBlock var17 = (AquaticBlock)var10000;
         if (var17 != null) {
            AquaticBlock var5 = var17;
            Iterator var10 = var4.iterator();

            while(var10.hasNext()) {
               Vector var12 = (Vector)var10.next();
               int var18 = (int)var12.getX();
               String var14 = var18 + ";" + (int)var12.getY() + ";" + (int)var12.getZ();
               AnimationProp var19 = (AnimationProp)var1.getProps().get("block:" + var14);
               if (var19 != null) {
                  var19.onAnimationEnd();
               }

               BlockAnimationProp var15 = new BlockAnimationProp(var1, var5, var12);
               var1.getProps().put("block:" + var14, var15);
            }

         }
      }
   }
}
