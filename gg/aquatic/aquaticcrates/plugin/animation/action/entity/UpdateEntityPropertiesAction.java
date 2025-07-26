package gg.aquatic.aquaticcrates.plugin.animation.action.entity;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.EntityAnimationProp;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property.EntityPropertiesObjectArgument;
import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property.EntityProperty;
import gg.aquatic.waves.fake.entity.FakeEntity;
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
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/entity/UpdateEntityPropertiesAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
)
@SourceDebugExtension({"SMAP\nUpdateEntityPropertiesAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpdateEntityPropertiesAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/entity/UpdateEntityPropertiesAction\n+ 2 ObjectArguments.kt\ngg/aquatic/waves/util/argument/ObjectArguments\n*L\n1#1,31:1\n98#2,2:32\n*S KotlinDebug\n*F\n+ 1 UpdateEntityPropertiesAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/entity/UpdateEntityPropertiesAction\n*L\n21#1:32,2\n*E\n"})
public final class UpdateEntityPropertiesAction implements ExecutableObject<Animation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments;

   public UpdateEntityPropertiesAction() {
      AquaticObjectArgument[] var1 = new AquaticObjectArgument[]{new PrimitiveObjectArgument("id", "example-entity", true), new EntityPropertiesObjectArgument("properties", CollectionsKt.emptyList(), true)};
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
      String var10000 = var2.string("id", UpdateEntityPropertiesAction::execute$lambda$0);
      if (var10000 != null) {
         String var4 = var10000;
         String var7 = "properties";
         Function1 var8 = (Function1)UpdateEntityPropertiesAction$execute$$inlined$typed$default$1.INSTANCE;
         boolean var9 = false;
         Object var10 = var2.any(var7, var8);
         if (!(var10 instanceof Collection)) {
            var10 = null;
         }

         Collection var11 = (Collection)var10;
         if (var11 != null) {
            Collection var5 = var11;
            Object var13 = var1.getProps().get("entity:" + var4);
            EntityAnimationProp var12 = var13 instanceof EntityAnimationProp ? (EntityAnimationProp)var13 : null;
            if ((var13 instanceof EntityAnimationProp ? (EntityAnimationProp)var13 : null) != null) {
               EntityAnimationProp var6 = var12;
               var6.getEntity().updateEntity(UpdateEntityPropertiesAction::execute$lambda$1);
            }
         }
      }
   }

   private static final String execute$lambda$0(Function2 var0, Animation var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      return (String)var0.invoke(var1, var2);
   }

   private static final Unit execute$lambda$1(Collection var0, EntityAnimationProp var1, FakeEntity var2) {
      Intrinsics.checkNotNullParameter(var2, "$this$updateEntity");
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         EntityProperty var4 = (EntityProperty)var3.next();
         var4.apply(var2, var1);
      }

      return Unit.INSTANCE;
   }
}
