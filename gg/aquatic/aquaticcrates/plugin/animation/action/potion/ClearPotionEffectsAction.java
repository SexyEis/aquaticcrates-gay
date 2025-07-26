package gg.aquatic.aquaticcrates.plugin.animation.action.potion;

import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.argument.AbstractObjectArgumentSerializer;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004:\u0001\u0013B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/potion/ClearPotionEffectsAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "PotionsArgument", "plugin"}
)
@SourceDebugExtension({"SMAP\nClearPotionEffectsAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClearPotionEffectsAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/potion/ClearPotionEffectsAction\n+ 2 ObjectArguments.kt\ngg/aquatic/waves/util/argument/ObjectArguments\n*L\n1#1,51:1\n98#2,2:52\n*S KotlinDebug\n*F\n+ 1 ClearPotionEffectsAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/potion/ClearPotionEffectsAction\n*L\n23#1:52,2\n*E\n"})
public final class ClearPotionEffectsAction implements ExecutableObject<PlayerBoundAnimation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments = CollectionsKt.listOf(new ClearPotionEffectsAction.PotionsArgument("potions", CollectionsKt.emptyList(), true));

   @NotNull
   public List<AquaticObjectArgument<?>> getArguments() {
      return this.arguments;
   }

   public void execute(@NotNull PlayerBoundAnimation var1, @NotNull ObjectArguments var2, @NotNull Function2<? super PlayerBoundAnimation, ? super String, String> var3) {
      Intrinsics.checkNotNullParameter(var1, "binder");
      Intrinsics.checkNotNullParameter(var2, "args");
      Intrinsics.checkNotNullParameter(var3, "textUpdater");
      String var6 = "potions";
      Function1 var7 = (Function1)ClearPotionEffectsAction$execute$$inlined$typed$default$1.INSTANCE;
      boolean var8 = false;
      Object var10000 = var2.any(var6, var7);
      if (!(var10000 instanceof List)) {
         var10000 = null;
      }

      List var9 = (List)var10000;
      if (var9 == null) {
         var9 = CollectionsKt.emptyList();
      }

      List var4 = var9;
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         PotionEffectType var10 = (PotionEffectType)var5.next();
         var1.getPlayer().removePotionEffect(var10);
      }

   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0012B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\"\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/potion/ClearPotionEffectsAction$PotionsArgument;", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "", "Lorg/bukkit/potion/PotionEffectType;", "id", "", "defaultValue", "required", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Z)V", "serializer", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "getSerializer", "()Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "Companion", "plugin"}
   )
   public static final class PotionsArgument extends AquaticObjectArgument<List<? extends PotionEffectType>> {
      @NotNull
      public static final ClearPotionEffectsAction.PotionsArgument.Companion Companion = new ClearPotionEffectsAction.PotionsArgument.Companion((DefaultConstructorMarker)null);
      @NotNull
      private final AbstractObjectArgumentSerializer<List<PotionEffectType>> serializer;

      public PotionsArgument(@NotNull String var1, @Nullable List<? extends PotionEffectType> var2, boolean var3) {
         Intrinsics.checkNotNullParameter(var1, "id");
         super(var1, var2, var3);
         this.serializer = (AbstractObjectArgumentSerializer)Companion;
      }

      @NotNull
      public AbstractObjectArgumentSerializer<List<PotionEffectType>> getSerializer() {
         return this.serializer;
      }

      @Nullable
      public List<PotionEffectType> load(@NotNull ConfigurationSection var1) {
         Intrinsics.checkNotNullParameter(var1, "section");
         return (List)this.getSerializer().load(var1, this.getId());
      }

      @Metadata(
         mv = {2, 1, 0},
         k = 1,
         xi = 48,
         d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"},
         d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/potion/ClearPotionEffectsAction$PotionsArgument$Companion;", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "", "Lorg/bukkit/potion/PotionEffectType;", "<init>", "()V", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "id", "", "plugin"}
      )
      public static final class Companion extends AbstractObjectArgumentSerializer<List<? extends PotionEffectType>> {
         private Companion() {
         }

         @NotNull
         public List<PotionEffectType> load(@NotNull ConfigurationSection var1, @NotNull String var2) {
            Intrinsics.checkNotNullParameter(var1, "section");
            Intrinsics.checkNotNullParameter(var2, "id");
            List var3 = (List)(new ArrayList());
            Iterator var4 = var1.getStringList(var2).iterator();

            while(var4.hasNext()) {
               String var5 = (String)var4.next();
               Collection var6 = (Collection)var3;
               Registry var10000 = Registry.EFFECT;
               Intrinsics.checkNotNull(var5);
               String var10001 = var5.toLowerCase(Locale.ROOT);
               Intrinsics.checkNotNullExpressionValue(var10001, "toLowerCase(...)");
               PotionEffectType var7 = (PotionEffectType)var10000.get(NamespacedKey.minecraft(var10001));
               if (var7 != null) {
                  var6.add(var7);
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
