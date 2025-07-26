package gg.aquatic.aquaticcrates.api;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/AbstractCratesPlugin;", "Lorg/bukkit/plugin/java/JavaPlugin;", "<init>", "()V", "settings", "Lgg/aquatic/aquaticcrates/api/PluginSettings;", "getSettings", "()Lgg/aquatic/aquaticcrates/api/PluginSettings;", "Companion", "api"}
)
public abstract class AbstractCratesPlugin extends JavaPlugin {
   @NotNull
   public static final AbstractCratesPlugin.Companion Companion = new AbstractCratesPlugin.Companion((DefaultConstructorMarker)null);
   public static AbstractCratesPlugin INSTANCE;

   @NotNull
   public abstract PluginSettings getSettings();

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"},
      d2 = {"Lgg/aquatic/aquaticcrates/api/AbstractCratesPlugin$Companion;", "", "<init>", "()V", "INSTANCE", "Lgg/aquatic/aquaticcrates/api/AbstractCratesPlugin;", "getINSTANCE", "()Lgg/aquatic/aquaticcrates/api/AbstractCratesPlugin;", "setINSTANCE", "(Lgg/aquatic/aquaticcrates/api/AbstractCratesPlugin;)V", "api"}
   )
   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final AbstractCratesPlugin getINSTANCE() {
         AbstractCratesPlugin var10000 = AbstractCratesPlugin.INSTANCE;
         if (var10000 != null) {
            return var10000;
         } else {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            return null;
         }
      }

      public final void setINSTANCE(@NotNull AbstractCratesPlugin var1) {
         Intrinsics.checkNotNullParameter(var1, "<set-?>");
         AbstractCratesPlugin.INSTANCE = var1;
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
