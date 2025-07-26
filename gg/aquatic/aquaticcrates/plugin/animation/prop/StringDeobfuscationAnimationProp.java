package gg.aquatic.aquaticcrates.plugin.animation.prop;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.crate.CrateAnimationActions;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.util.ComponentExtKt;
import gg.aquatic.waves.util.StringExtKt;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020%H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u001d\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010\u001f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/StringDeobfuscationAnimationProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "id", "", "animation", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "deobfuscateEvery", "", "deobfuscationString", "obfuscatedFormat", "deobfuscatedFormat", "deobfuscationActions", "Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "stripColors", "", "<init>", "(Ljava/lang/String;Lgg/aquatic/aquaticcrates/api/animation/Animation;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;Z)V", "getId", "()Ljava/lang/String;", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/Animation;", "getDeobfuscateEvery", "()I", "getObfuscatedFormat", "getDeobfuscatedFormat", "getDeobfuscationActions", "()Lgg/aquatic/aquaticcrates/api/animation/crate/CrateAnimationActions;", "obfuscationString", "getObfuscationString", "length", "getLength", "deobfuscated", "getDeobfuscated", "setDeobfuscated", "(I)V", "currentString", "tick", "", "deobfuscateNext", "onAnimationEnd", "plugin"}
)
public final class StringDeobfuscationAnimationProp extends AnimationProp {
   @NotNull
   private final String id;
   @NotNull
   private final Animation animation;
   private final int deobfuscateEvery;
   @NotNull
   private final String obfuscatedFormat;
   @NotNull
   private final String deobfuscatedFormat;
   @NotNull
   private final CrateAnimationActions deobfuscationActions;
   @NotNull
   private final String obfuscationString;
   private final int length;
   private int deobfuscated;
   @NotNull
   private volatile String currentString;
   private int tick;

   public StringDeobfuscationAnimationProp(@NotNull String var1, @NotNull Animation var2, int var3, @NotNull String var4, @NotNull String var5, @NotNull String var6, @NotNull CrateAnimationActions var7, boolean var8) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var2, "animation");
      Intrinsics.checkNotNullParameter(var4, "deobfuscationString");
      Intrinsics.checkNotNullParameter(var5, "obfuscatedFormat");
      Intrinsics.checkNotNullParameter(var6, "deobfuscatedFormat");
      Intrinsics.checkNotNullParameter(var7, "deobfuscationActions");
      super();
      this.id = var1;
      this.animation = var2;
      this.deobfuscateEvery = var3;
      this.obfuscatedFormat = var5;
      this.deobfuscatedFormat = var6;
      this.deobfuscationActions = var7;
      this.obfuscationString = var8 ? ComponentExtKt.toPlain(StringExtKt.toMMComponent(this.getAnimation().updatePlaceholders(var4))) : this.getAnimation().updatePlaceholders(var4);
      this.length = this.obfuscationString.length();
      this.currentString = this.obfuscatedFormat + this.obfuscationString;
      Map var9 = (Map)this.getAnimation().getExtraPlaceholders();
      Pair var10 = TuplesKt.to("stringdeobfuscation:" + this.id, StringDeobfuscationAnimationProp::_init_$lambda$0);
      var9.put(var10.getFirst(), var10.getSecond());
   }

   @NotNull
   public final String getId() {
      return this.id;
   }

   @NotNull
   public Animation getAnimation() {
      return this.animation;
   }

   public final int getDeobfuscateEvery() {
      return this.deobfuscateEvery;
   }

   @NotNull
   public final String getObfuscatedFormat() {
      return this.obfuscatedFormat;
   }

   @NotNull
   public final String getDeobfuscatedFormat() {
      return this.deobfuscatedFormat;
   }

   @NotNull
   public final CrateAnimationActions getDeobfuscationActions() {
      return this.deobfuscationActions;
   }

   @NotNull
   public final String getObfuscationString() {
      return this.obfuscationString;
   }

   public final int getLength() {
      return this.length;
   }

   public final int getDeobfuscated() {
      return this.deobfuscated;
   }

   public final void setDeobfuscated(int var1) {
      this.deobfuscated = var1;
   }

   public void tick() {
      int var1 = this.tick++;
      if (this.tick >= this.deobfuscateEvery) {
         this.tick = 0;
         this.deobfuscateNext();
      }

   }

   private final void deobfuscateNext() {
      int var1 = this.deobfuscated++;
      if (this.deobfuscated < this.length) {
         String var10000 = this.obfuscationString.substring(0, this.length - 1 - this.deobfuscated);
         Intrinsics.checkNotNullExpressionValue(var10000, "substring(...)");
         String var3 = var10000;
         var10000 = this.obfuscationString.substring(this.length - 1 - this.deobfuscated, this.length);
         Intrinsics.checkNotNullExpressionValue(var10000, "substring(...)");
         String var2 = var10000;
         this.currentString = this.obfuscatedFormat + var3 + this.deobfuscatedFormat + var2;
         this.deobfuscationActions.execute(this.getAnimation());
      }
   }

   public void onAnimationEnd() {
   }

   private static final String _init_$lambda$0(StringDeobfuscationAnimationProp var0, String var1) {
      Intrinsics.checkNotNullParameter(var1, "str");
      return StringsKt.replace$default(var1, "%stringdeobfuscation:" + var0.id + "%", var0.currentString, false, 4, (Object)null);
   }
}
