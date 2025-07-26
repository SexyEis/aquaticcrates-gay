package gg.aquatic.aquaticcrates.plugin.crate;

import gg.aquatic.aquaticcrates.api.crate.Crate;
import gg.aquatic.aquaticcrates.api.crate.Key;
import gg.aquatic.aquaticcrates.api.interaction.key.KeyInteractHandler;
import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function1;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\b\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/crate/KeyImpl;", "Lgg/aquatic/aquaticcrates/api/crate/Key;", "crate", "Lgg/aquatic/aquaticcrates/api/crate/Crate;", "item", "Lgg/aquatic/waves/item/AquaticItem;", "mustBeHeld", "", "interactHandler", "Lgg/aquatic/waves/libs/kotlin/Function1;", "Lgg/aquatic/aquaticcrates/api/interaction/key/KeyInteractHandler;", "<init>", "(Lgg/aquatic/aquaticcrates/api/crate/Crate;Lgg/aquatic/waves/item/AquaticItem;ZLkotlin/jvm/functions/Function1;)V", "getMustBeHeld", "()Z", "getInteractHandler", "()Lgg/aquatic/aquaticcrates/api/interaction/key/KeyInteractHandler;", "plugin"}
)
public final class KeyImpl extends Key {
   private final boolean mustBeHeld;
   @NotNull
   private final KeyInteractHandler interactHandler;

   public KeyImpl(@NotNull Crate var1, @NotNull AquaticItem var2, boolean var3, @NotNull Function1<? super KeyImpl, ? extends KeyInteractHandler> var4) {
      Intrinsics.checkNotNullParameter(var1, "crate");
      Intrinsics.checkNotNullParameter(var2, "item");
      Intrinsics.checkNotNullParameter(var4, "interactHandler");
      super(var1, var2);
      this.mustBeHeld = var3;
      this.interactHandler = (KeyInteractHandler)var4.invoke(this);
   }

   public boolean getMustBeHeld() {
      return this.mustBeHeld;
   }

   @NotNull
   public KeyInteractHandler getInteractHandler() {
      return this.interactHandler;
   }
}
