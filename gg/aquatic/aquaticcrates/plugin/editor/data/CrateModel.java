package gg.aquatic.aquaticcrates.plugin.editor.data;

import gg.aquatic.aquaticcrates.plugin.crate.BasicCrate;
import gg.aquatic.aquaticcrates.plugin.editor.data.key.KeyModel;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/data/CrateModel;", "", "id", "", "displayName", "key", "Lgg/aquatic/aquaticcrates/plugin/editor/data/key/KeyModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lgg/aquatic/aquaticcrates/plugin/editor/data/key/KeyModel;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getDisplayName", "setDisplayName", "getKey", "()Lgg/aquatic/aquaticcrates/plugin/editor/data/key/KeyModel;", "setKey", "(Lgg/aquatic/aquaticcrates/plugin/editor/data/key/KeyModel;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "plugin"}
)
public final class CrateModel {
   @NotNull
   public static final CrateModel.Companion Companion = new CrateModel.Companion((DefaultConstructorMarker)null);
   @NotNull
   private String id;
   @NotNull
   private String displayName;
   @NotNull
   private KeyModel key;

   public CrateModel(@NotNull String var1, @NotNull String var2, @NotNull KeyModel var3) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var2, "displayName");
      Intrinsics.checkNotNullParameter(var3, "key");
      super();
      this.id = var1;
      this.displayName = var2;
      this.key = var3;
   }

   @NotNull
   public final String getId() {
      return this.id;
   }

   public final void setId(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.id = var1;
   }

   @NotNull
   public final String getDisplayName() {
      return this.displayName;
   }

   public final void setDisplayName(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.displayName = var1;
   }

   @NotNull
   public final KeyModel getKey() {
      return this.key;
   }

   public final void setKey(@NotNull KeyModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.key = var1;
   }

   @NotNull
   public final String component1() {
      return this.id;
   }

   @NotNull
   public final String component2() {
      return this.displayName;
   }

   @NotNull
   public final KeyModel component3() {
      return this.key;
   }

   @NotNull
   public final CrateModel copy(@NotNull String var1, @NotNull String var2, @NotNull KeyModel var3) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var2, "displayName");
      Intrinsics.checkNotNullParameter(var3, "key");
      return new CrateModel(var1, var2, var3);
   }

   // $FF: synthetic method
   public static CrateModel copy$default(CrateModel var0, String var1, String var2, KeyModel var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.displayName;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.key;
      }

      return var0.copy(var1, var2, var3);
   }

   @NotNull
   public String toString() {
      return "CrateModel(id=" + this.id + ", displayName=" + this.displayName + ", key=" + this.key + ")";
   }

   public int hashCode() {
      int var1 = this.id.hashCode();
      var1 = var1 * 31 + this.displayName.hashCode();
      var1 = var1 * 31 + this.key.hashCode();
      return var1;
   }

   public boolean equals(@Nullable Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof CrateModel)) {
         return false;
      } else {
         CrateModel var2 = (CrateModel)var1;
         if (!Intrinsics.areEqual(this.id, var2.id)) {
            return false;
         } else if (!Intrinsics.areEqual(this.displayName, var2.displayName)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.key, var2.key);
         }
      }
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/editor/data/CrateModel$Companion;", "", "<init>", "()V", "of", "Lgg/aquatic/aquaticcrates/plugin/editor/data/CrateModel;", "crate", "Lgg/aquatic/aquaticcrates/plugin/crate/BasicCrate;", "plugin"}
   )
   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final CrateModel of(@NotNull BasicCrate var1) {
         Intrinsics.checkNotNullParameter(var1, "crate");
         return new CrateModel(var1.getIdentifier(), var1.getDisplayName(), KeyModel.Companion.of(var1));
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
