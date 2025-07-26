package gg.aquatic.aquaticcrates.plugin.animation.action.block;

import gg.aquatic.aquaticcrates.api.animation.Animation;
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
import gg.aquatic.waves.util.argument.impl.PrimitiveObjectArgument;
import gg.aquatic.waves.util.block.AquaticBlock;
import gg.aquatic.waves.util.block.impl.VanillaBlock;
import gg.aquatic.waves.util.generic.ExecutableObject;
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
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/block/SetBlockAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nSetBlockAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SetBlockAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/block/SetBlockAction\n+ 2 ObjectArguments.kt\ngg/aquatic/waves/util/argument/ObjectArguments\n*L\n1#1,37:1\n98#2,2:38\n*S KotlinDebug\n*F\n+ 1 SetBlockAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/block/SetBlockAction\n*L\n25#1:38,2\n*E\n"})
public final class SetBlockAction implements ExecutableObject<Animation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public SetBlockAction() {
      AquaticObjectArgument[] var1 = new AquaticObjectArgument[]{new PrimitiveObjectArgument("offset", "0;0;0", false), null};
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
      Vector var10000 = var2.vector("offset", SetBlockAction::execute$lambda$0);
      if (var10000 != null) {
         Vector var4 = var10000;
         String var7 = "block";
         Function1 var8 = (Function1)SetBlockAction$execute$$inlined$typed$default$1.INSTANCE;
         boolean var9 = false;
         Object var10 = var2.any(var7, var8);
         if (!(var10 instanceof AquaticBlock)) {
            var10 = null;
         }

         AquaticBlock var11 = (AquaticBlock)var10;
         if (var11 != null) {
            AquaticBlock var5 = var11;
            int var12 = (int)var4.getX();
            String var6 = var12 + ";" + (int)var4.getY() + ";" + (int)var4.getZ();
            Object var14 = var1.getProps().get("block:" + var6);
            BlockAnimationProp var13 = var14 instanceof BlockAnimationProp ? (BlockAnimationProp)var14 : null;
            if (var13 != null) {
               var13.getPacketBlock().changeBlock(var5);
            } else {
               BlockAnimationProp var15 = new BlockAnimationProp(var1, var5, var4);
               var1.getProps().put("block:" + var6, var15);
            }
         }
      }
   }

   private static final String execute$lambda$0(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }
}
