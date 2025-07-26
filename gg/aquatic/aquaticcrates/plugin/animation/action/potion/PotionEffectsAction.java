package gg.aquatic.aquaticcrates.plugin.animation.action.potion;

import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.collections.MapsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.ConfigExtKt;
import gg.aquatic.waves.util.argument.AbstractObjectArgumentSerializer;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004:\u0001\u0013B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/potion/PotionEffectsAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "PotionsArgument", "plugin"}
)
@SourceDebugExtension({"SMAP\nPotionEffectsAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PotionEffectsAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/potion/PotionEffectsAction\n+ 2 ObjectArguments.kt\ngg/aquatic/waves/util/argument/ObjectArguments\n*L\n1#1,60:1\n98#2,2:61\n*S KotlinDebug\n*F\n+ 1 PotionEffectsAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/potion/PotionEffectsAction\n*L\n25#1:61,2\n*E\n"})
public final class PotionEffectsAction implements ExecutableObject<PlayerBoundAnimation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments = CollectionsKt.listOf(new PotionEffectsAction.PotionsArgument("potions", MapsKt.emptyMap(), true));

   @NotNull
   public List<AquaticObjectArgument<?>> getArguments() {
      return this.arguments;
   }

   public void execute(@NotNull PlayerBoundAnimation var1, @NotNull ObjectArguments var2, @NotNull Function2<? super PlayerBoundAnimation, ? super String, String> var3) {
      Intrinsics.checkNotNullParameter(var1, "binder");
      Intrinsics.checkNotNullParameter(var2, "args");
      Intrinsics.checkNotNullParameter(var3, "textUpdater");
      String var6 = "potions";
      Function1 var7 = (Function1)PotionEffectsAction$execute$$inlined$typed$default$1.INSTANCE;
      boolean var8 = false;
      Object var10000 = var2.any(var6, var7);
      if (!(var10000 instanceof Map)) {
         var10000 = null;
      }

      Map var11 = (Map)var10000;
      if (var11 == null) {
         var11 = MapsKt.emptyMap();
      }

      Map var4 = var11;
      Iterator var5 = var4.entrySet().iterator();

      while(var5.hasNext()) {
         Entry var12 = (Entry)var5.next();
         PotionEffectType var13 = (PotionEffectType)var12.getKey();
         Pair var14 = (Pair)var12.getValue();
         int var9 = ((Number)var14.component1()).intValue();
         int var10 = ((Number)var14.component2()).intValue();
         var1.getPlayer().addPotionEffect(new PotionEffect(var13, var9, var10, false, false, false));
      }

   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001:\u0001\u0014B9\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012 \u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\u0011\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R4\u0010\r\u001a\"\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/potion/PotionEffectsAction$PotionsArgument;", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "", "Lorg/bukkit/potion/PotionEffectType;", "Lgg/aquatic/waves/libs/kotlin/Pair;", "", "id", "", "defaultValue", "required", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;Z)V", "serializer", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "getSerializer", "()Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "Companion", "plugin"}
   )
   public static final class PotionsArgument extends AquaticObjectArgument<Map<PotionEffectType, ? extends Pair<? extends Integer, ? extends Integer>>> {
      @NotNull
      public static final PotionEffectsAction.PotionsArgument.Companion Companion = new PotionEffectsAction.PotionsArgument.Companion((DefaultConstructorMarker)null);
      @NotNull
      private final AbstractObjectArgumentSerializer<Map<PotionEffectType, Pair<Integer, Integer>>> serializer;

      public PotionsArgument(@NotNull String var1, @Nullable Map<PotionEffectType, Pair<Integer, Integer>> var2, boolean var3) {
         Intrinsics.checkNotNullParameter(var1, "id");
         super(var1, var2, var3);
         this.serializer = (AbstractObjectArgumentSerializer)Companion;
      }

      @NotNull
      public AbstractObjectArgumentSerializer<Map<PotionEffectType, Pair<Integer, Integer>>> getSerializer() {
         return this.serializer;
      }

      @Nullable
      public Map<PotionEffectType, Pair<Integer, Integer>> load(@NotNull ConfigurationSection var1) {
         Intrinsics.checkNotNullParameter(var1, "section");
         return (Map)this.getSerializer().load(var1, this.getId());
      }

      @Metadata(
         mv = {2, 1, 0},
         k = 1,
         xi = 48,
         d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\"\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"},
         d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/potion/PotionEffectsAction$PotionsArgument$Companion;", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "", "Lorg/bukkit/potion/PotionEffectType;", "Lgg/aquatic/waves/libs/kotlin/Pair;", "", "<init>", "()V", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "id", "", "plugin"}
      )
      public static final class Companion extends AbstractObjectArgumentSerializer<Map<PotionEffectType, ? extends Pair<? extends Integer, ? extends Integer>>> {
         private Companion() {
         }

         @Nullable
         public Map<PotionEffectType, Pair<Integer, Integer>> load(@NotNull ConfigurationSection var1, @NotNull String var2) {
            Intrinsics.checkNotNullParameter(var1, "section");
            Intrinsics.checkNotNullParameter(var2, "id");
            Map var3 = (Map)(new LinkedHashMap());
            Iterator var4 = ConfigExtKt.getSectionList(var1, var2).iterator();

            while(var4.hasNext()) {
               ConfigurationSection var5 = (ConfigurationSection)var4.next();
               Registry var10000 = Registry.POTION_EFFECT_TYPE;
               String var10001 = var5.getString("potion");
               if (var10001 != null) {
                  PotionEffectType var11 = (PotionEffectType)var10000.get(NamespacedKey.minecraft(var10001));
                  if (var11 != null) {
                     PotionEffectType var6 = var11;
                     int var7 = var5.getInt("duration");
                     int var8 = var5.getInt("amplifier");
                     Pair var10 = TuplesKt.to(var6, TuplesKt.to(var7, var8));
                     var3.put(var10.getFirst(), var10.getSecond());
                  }
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
