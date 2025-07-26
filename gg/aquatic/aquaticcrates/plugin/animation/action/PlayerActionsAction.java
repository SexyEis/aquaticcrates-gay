package gg.aquatic.aquaticcrates.plugin.animation.action;

import gg.aquatic.aquaticcrates.api.animation.PlayerBoundAnimation;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.registry.WavesRegistry;
import gg.aquatic.waves.registry.serializer.ActionSerializer;
import gg.aquatic.waves.util.ConfigExtKt;
import gg.aquatic.waves.util.argument.AbstractObjectArgumentSerializer;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.generic.ConfiguredExecutableObject;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004:\u0001\u0013B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/PlayerActionsAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/PlayerBoundAnimation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "PlayerActionsArgument", "plugin"}
)
@SourceDebugExtension({"SMAP\nPlayerActionsAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerActionsAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/PlayerActionsAction\n+ 2 ObjectArguments.kt\ngg/aquatic/waves/util/argument/ObjectArguments\n*L\n1#1,53:1\n98#2,2:54\n*S KotlinDebug\n*F\n+ 1 PlayerActionsAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/PlayerActionsAction\n*L\n24#1:54,2\n*E\n"})
public final class PlayerActionsAction implements ExecutableObject<PlayerBoundAnimation, Unit> {
   @NotNull
   private final List<AquaticObjectArgument<?>> arguments = CollectionsKt.listOf(new PlayerActionsAction.PlayerActionsArgument("actions", CollectionsKt.emptyList(), true));

   @NotNull
   public List<AquaticObjectArgument<?>> getArguments() {
      return this.arguments;
   }

   public void execute(@NotNull PlayerBoundAnimation var1, @NotNull ObjectArguments var2, @NotNull Function2<? super PlayerBoundAnimation, ? super String, String> var3) {
      Intrinsics.checkNotNullParameter(var1, "binder");
      Intrinsics.checkNotNullParameter(var2, "args");
      Intrinsics.checkNotNullParameter(var3, "textUpdater");
      String var6 = "actions";
      Function1 var7 = (Function1)PlayerActionsAction$execute$$inlined$typed$default$1.INSTANCE;
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
         ConfiguredExecutableObject var10 = (ConfiguredExecutableObject)var5.next();
         var10.execute(var1.getPlayer(), PlayerActionsAction::execute$lambda$0);
      }

   }

   private static final String execute$lambda$0(Function2 var0, PlayerBoundAnimation var1, Player var2, String var3) {
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      Intrinsics.checkNotNullParameter(var3, "str");
      return (String)var0.invoke(var1, var3);
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00020\u0001:\u0001\u0014B3\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\u0011\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R.\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/PlayerActionsAction$PlayerActionsArgument;", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "", "Lgg/aquatic/waves/util/generic/ConfiguredExecutableObject;", "Lorg/bukkit/entity/Player;", "", "id", "", "defaultValue", "required", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Z)V", "serializer", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "getSerializer", "()Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "Companion", "plugin"}
   )
   public static final class PlayerActionsArgument extends AquaticObjectArgument<List<? extends ConfiguredExecutableObject<Player, Unit>>> {
      @NotNull
      public static final PlayerActionsAction.PlayerActionsArgument.Companion Companion = new PlayerActionsAction.PlayerActionsArgument.Companion((DefaultConstructorMarker)null);
      @NotNull
      private final AbstractObjectArgumentSerializer<List<ConfiguredExecutableObject<Player, Unit>>> serializer;

      public PlayerActionsArgument(@NotNull String var1, @Nullable List<? extends ConfiguredExecutableObject<Player, Unit>> var2, boolean var3) {
         Intrinsics.checkNotNullParameter(var1, "id");
         super(var1, var2, var3);
         this.serializer = (AbstractObjectArgumentSerializer)Companion;
      }

      @NotNull
      public AbstractObjectArgumentSerializer<List<ConfiguredExecutableObject<Player, Unit>>> getSerializer() {
         return this.serializer;
      }

      @Nullable
      public List<ConfiguredExecutableObject<Player, Unit>> load(@NotNull ConfigurationSection var1) {
         Intrinsics.checkNotNullParameter(var1, "section");
         return (List)this.getSerializer().load(var1, this.getId());
      }

      @Metadata(
         mv = {2, 1, 0},
         k = 1,
         xi = 48,
         d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u001c\u0012\u0018\u0012\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"},
         d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/action/PlayerActionsAction$PlayerActionsArgument$Companion;", "Lgg/aquatic/waves/util/argument/AbstractObjectArgumentSerializer;", "", "Lgg/aquatic/waves/util/generic/ConfiguredExecutableObject;", "Lorg/bukkit/entity/Player;", "", "<init>", "()V", "load", "section", "Lorg/bukkit/configuration/ConfigurationSection;", "id", "", "plugin"}
      )
      @SourceDebugExtension({"SMAP\nPlayerActionsAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerActionsAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/PlayerActionsAction$PlayerActionsArgument$Companion\n+ 2 ActionSerializer.kt\ngg/aquatic/waves/registry/serializer/ActionSerializer\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ActionRegistry.kt\ngg/aquatic/waves/registry/ActionRegistryKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n24#2:54\n14#2,2:65\n17#2,4:71\n1611#3,9:55\n1863#3:64\n1864#3:76\n1620#3:77\n12#4,4:67\n1#5:75\n*S KotlinDebug\n*F\n+ 1 PlayerActionsAction.kt\ngg/aquatic/aquaticcrates/plugin/animation/action/PlayerActionsAction$PlayerActionsArgument$Companion\n*L\n48#1:54\n48#1:65,2\n48#1:71,4\n48#1:55,9\n48#1:64\n48#1:76\n48#1:77\n48#1:67,4\n48#1:75\n*E\n"})
      public static final class Companion extends AbstractObjectArgumentSerializer<List<? extends ConfiguredExecutableObject<Player, Unit>>> {
         private Companion() {
         }

         @NotNull
         public List<ConfiguredExecutableObject<Player, Unit>> load(@NotNull ConfigurationSection var1, @NotNull String var2) {
            Intrinsics.checkNotNullParameter(var1, "section");
            Intrinsics.checkNotNullParameter(var2, "id");
            ActionSerializer var3 = ActionSerializer.INSTANCE;
            List var4 = ConfigExtKt.getSectionList(var1, "actions");
            boolean var5 = false;
            Iterable var6 = (Iterable)var4;
            boolean var7 = false;
            Collection var9 = (Collection)(new ArrayList());
            boolean var10 = false;
            boolean var12 = false;
            Iterator var13 = var6.iterator();

            while(var13.hasNext()) {
               Object var14 = var13.next();
               boolean var16 = false;
               ConfigurationSection var17 = (ConfigurationSection)var14;
               boolean var18 = false;
               ActionSerializer var19 = ActionSerializer.INSTANCE;
               boolean var20 = false;
               String var10000 = var17.getString("type");
               ConfiguredExecutableObject var31;
               if (var10000 == null) {
                  var31 = null;
               } else {
                  String var21 = var10000;
                  WavesRegistry var22 = WavesRegistry.INSTANCE;
                  boolean var23 = false;
                  Map var32 = (Map)var22.getACTION().get(Player.class);
                  ExecutableObject var33;
                  if (var32 == null) {
                     var33 = null;
                  } else {
                     Map var24 = var32;
                     var33 = (ExecutableObject)var24.get(var21);
                     if (var33 == null) {
                        var33 = null;
                     } else {
                        ExecutableObject var25 = var33;
                        var33 = var25 instanceof ExecutableObject ? var25 : null;
                     }
                  }

                  if (var33 == null) {
                     var31 = null;
                  } else {
                     ExecutableObject var26 = var33;
                     ObjectArguments var27 = AquaticObjectArgument.Companion.loadRequirementArguments(var17, var26.getArguments());
                     ConfiguredExecutableObject var30 = new ConfiguredExecutableObject(var26, var27);
                     var31 = var30;
                  }
               }

               if (var31 != null) {
                  ConfiguredExecutableObject var28 = var31;
                  boolean var29 = false;
                  var9.add(var28);
               }
            }

            return (List)var9;
         }

         // $FF: synthetic method
         public Companion(DefaultConstructorMarker var1) {
            this();
         }
      }
   }
}
