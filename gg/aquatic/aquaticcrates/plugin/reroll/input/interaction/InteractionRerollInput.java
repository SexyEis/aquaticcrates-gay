package gg.aquatic.aquaticcrates.plugin.reroll.input.interaction;

import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimation;
import gg.aquatic.aquaticcrates.api.reroll.RerollInput;
import gg.aquatic.aquaticcrates.api.reroll.RerollManager;
import gg.aquatic.aquaticcrates.api.reward.RolledReward;
import gg.aquatic.aquaticcrates.plugin.reroll.input.InputSettingsFactory;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntries;
import gg.aquatic.waves.libs.kotlin.enums.EnumEntriesKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0003\u0016\u0017\u0018B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J4\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0019"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/reroll/input/interaction/InteractionRerollInput;", "Lgg/aquatic/aquaticcrates/api/reroll/RerollInput;", "interactions", "", "Lgg/aquatic/aquaticcrates/plugin/reroll/input/interaction/InteractionRerollInput$InteractionType;", "Lgg/aquatic/aquaticcrates/plugin/reroll/input/interaction/InteractionRerollInput$Action;", "<init>", "(Ljava/util/Map;)V", "getInteractions", "()Ljava/util/Map;", "handle", "Ljava/util/concurrent/CompletableFuture;", "Lgg/aquatic/aquaticcrates/api/reroll/RerollManager$RerollResult;", "rerollManager", "Lgg/aquatic/aquaticcrates/api/reroll/RerollManager;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimation;", "player", "Lorg/bukkit/entity/Player;", "rewards", "", "Lgg/aquatic/aquaticcrates/api/reward/RolledReward;", "Action", "InteractionType", "Companion", "plugin"}
)
public final class InteractionRerollInput implements RerollInput {
   @NotNull
   public static final InteractionRerollInput.Companion Companion = new InteractionRerollInput.Companion((DefaultConstructorMarker)null);
   @NotNull
   private final Map<InteractionRerollInput.InteractionType, InteractionRerollInput.Action> interactions;

   public InteractionRerollInput(@NotNull Map<InteractionRerollInput.InteractionType, ? extends InteractionRerollInput.Action> var1) {
      Intrinsics.checkNotNullParameter(var1, "interactions");
      super();
      this.interactions = var1;
   }

   @NotNull
   public final Map<InteractionRerollInput.InteractionType, InteractionRerollInput.Action> getInteractions() {
      return this.interactions;
   }

   @NotNull
   public CompletableFuture<RerollManager.RerollResult> handle(@NotNull RerollManager var1, @NotNull CrateAnimation var2, @NotNull Player var3, @NotNull Collection<? extends RolledReward> var4) {
      Intrinsics.checkNotNullParameter(var1, "rerollManager");
      Intrinsics.checkNotNullParameter(var2, "animation");
      Intrinsics.checkNotNullParameter(var3, "player");
      Intrinsics.checkNotNullParameter(var4, "rewards");
      CompletableFuture var5 = new CompletableFuture();
      Map var6 = InteractionInputHandler.INSTANCE.getAwaiting();
      Pair var7 = TuplesKt.to(var3.getUniqueId(), TuplesKt.to(var5, this.interactions));
      var6.put(var7.getFirst(), var7.getSecond());
      return var5;
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/reroll/input/interaction/InteractionRerollInput$Action;", "", "<init>", "(Ljava/lang/String;I)V", "REROLL", "CLAIM", "plugin"}
   )
   public static enum Action {
      REROLL,
      CLAIM;

      // $FF: synthetic field
      private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

      @NotNull
      public static EnumEntries<InteractionRerollInput.Action> getEntries() {
         return $ENTRIES;
      }

      // $FF: synthetic method
      private static final InteractionRerollInput.Action[] $values() {
         InteractionRerollInput.Action[] var0 = new InteractionRerollInput.Action[]{REROLL, CLAIM};
         return var0;
      }
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/reroll/input/interaction/InteractionRerollInput$Companion;", "Lgg/aquatic/aquaticcrates/plugin/reroll/input/InputSettingsFactory;", "<init>", "()V", "serialize", "Lgg/aquatic/aquaticcrates/api/reroll/RerollInput;", "cfg", "Lorg/bukkit/configuration/file/FileConfiguration;", "plugin"}
   )
   public static final class Companion implements InputSettingsFactory {
      private Companion() {
      }

      @Nullable
      public RerollInput serialize(@NotNull FileConfiguration var1) {
         Intrinsics.checkNotNullParameter(var1, "cfg");
         ConfigurationSection var10000 = var1.getConfigurationSection("reroll.interaction");
         if (var10000 == null) {
            return null;
         } else {
            ConfigurationSection var2 = var10000;
            Map var3 = (Map)(new LinkedHashMap());
            Iterator var4 = var2.getKeys(false).iterator();

            while(var4.hasNext()) {
               String var5 = (String)var4.next();
               Intrinsics.checkNotNull(var5);
               String var8 = var5.toUpperCase(Locale.ROOT);
               Intrinsics.checkNotNullExpressionValue(var8, "toUpperCase(...)");
               InteractionRerollInput.InteractionType var6 = InteractionRerollInput.InteractionType.valueOf(var8);
               var8 = var2.getString(var5);
               Intrinsics.checkNotNull(var8);
               var8 = var8.toUpperCase(Locale.ROOT);
               Intrinsics.checkNotNullExpressionValue(var8, "toUpperCase(...)");
               InteractionRerollInput.Action var7 = InteractionRerollInput.Action.valueOf(var8);
               var3.put(var6, var7);
            }

            return (RerollInput)(new InteractionRerollInput(var3));
         }
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/reroll/input/interaction/InteractionRerollInput$InteractionType;", "", "<init>", "(Ljava/lang/String;I)V", "RIGHT_CLICK", "LEFT_CLICK", "SNEAK", "plugin"}
   )
   public static enum InteractionType {
      RIGHT_CLICK,
      LEFT_CLICK,
      SNEAK;

      // $FF: synthetic field
      private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

      @NotNull
      public static EnumEntries<InteractionRerollInput.InteractionType> getEntries() {
         return $ENTRIES;
      }

      // $FF: synthetic method
      private static final InteractionRerollInput.InteractionType[] $values() {
         InteractionRerollInput.InteractionType[] var0 = new InteractionRerollInput.InteractionType[]{RIGHT_CLICK, LEFT_CLICK, SNEAK};
         return var0;
      }
   }
}
