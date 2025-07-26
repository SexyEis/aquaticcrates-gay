package gg.aquatic.aquaticcrates.plugin.awaiters;

import gg.aquatic.waves.libs.kotlin.Metadata;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/awaiters/AbstractAwaiter;", "", "<init>", "()V", "future", "Ljava/util/concurrent/CompletableFuture;", "Ljava/lang/Void;", "getFuture", "()Ljava/util/concurrent/CompletableFuture;", "loaded", "", "getLoaded", "()Z", "setLoaded", "(Z)V", "plugin"}
)
public abstract class AbstractAwaiter {
   private boolean loaded;

   @NotNull
   public abstract CompletableFuture<Void> getFuture();

   public final boolean getLoaded() {
      return this.loaded;
   }

   public final void setLoaded(boolean var1) {
      this.loaded = var1;
   }
}
