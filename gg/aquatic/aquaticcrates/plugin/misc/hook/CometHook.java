package gg.aquatic.aquaticcrates.plugin.misc.hook;

import gg.aquatic.aquaticcrates.api.animation.Animation;
import gg.aquatic.aquaticcrates.api.animation.prop.AnimationProp;
import gg.aquatic.comet.api.CometRegistry;
import gg.aquatic.comet.api.emitter.AbstractEmitter;
import gg.aquatic.comet.api.emitter.AbstractUnrealizedEmitter;
import gg.aquatic.comet.api.emitter.environment.EnvironmentData;
import gg.aquatic.comet.api.emitter.parent.Parent;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.Pair;
import gg.aquatic.waves.libs.kotlin.TuplesKt;
import gg.aquatic.waves.libs.kotlin.Unit;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.functions.Function2;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import gg.aquatic.waves.registry.WavesRegistry;
import gg.aquatic.waves.util.argument.AquaticObjectArgument;
import gg.aquatic.waves.util.argument.ObjectArguments;
import gg.aquatic.waves.util.argument.impl.PrimitiveObjectArgument;
import gg.aquatic.waves.util.generic.ExecutableObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/misc/hook/CometHook;", "", "<init>", "()V", "ShowCometParticleAction", "HideCometParticleAction", "CometParticleAnimationProp", "plugin"}
)
@SourceDebugExtension({"SMAP\nCometHook.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CometHook.kt\ngg/aquatic/aquaticcrates/plugin/misc/hook/CometHook\n+ 2 ActionRegistry.kt\ngg/aquatic/waves/registry/ActionRegistryKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,86:1\n6#2:87\n7#2,2:95\n6#2:97\n7#2,2:105\n381#3,7:88\n381#3,7:98\n*S KotlinDebug\n*F\n+ 1 CometHook.kt\ngg/aquatic/aquaticcrates/plugin/misc/hook/CometHook\n*L\n18#1:87\n18#1:95,2\n19#1:97\n19#1:105,2\n18#1:88,7\n19#1:98,7\n*E\n"})
public final class CometHook {
   public CometHook() {
      WavesRegistry var1 = WavesRegistry.INSTANCE;
      String var2 = "show-comet-particle";
      ExecutableObject var3 = (ExecutableObject)(new CometHook.ShowCometParticleAction());
      boolean var4 = false;
      Map var5 = (Map)var1.getACTION();
      Class var6 = Animation.class;
      boolean var7 = false;
      Object var8 = var5.get(var6);
      boolean var9;
      Map var12;
      Object var10000;
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      Map var10 = (Map)var10000;
      Pair var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
      var1 = WavesRegistry.INSTANCE;
      var2 = "hide-comet-particle";
      var3 = (ExecutableObject)(new CometHook.HideCometParticleAction());
      var4 = false;
      var5 = (Map)var1.getACTION();
      var6 = Animation.class;
      var7 = false;
      var8 = var5.get(var6);
      if (var8 == null) {
         var9 = false;
         var12 = (Map)(new HashMap());
         var5.put(var6, var12);
         var10000 = var12;
      } else {
         var10000 = var8;
      }

      var10 = (Map)var10000;
      var11 = TuplesKt.to(var2, var3);
      var10.put(var11.getFirst(), var11.getSecond());
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/misc/hook/CometHook$CometParticleAnimationProp;", "Lgg/aquatic/aquaticcrates/api/animation/prop/AnimationProp;", "animation", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "emitter", "Lgg/aquatic/comet/api/emitter/AbstractUnrealizedEmitter;", "offset", "Lorg/bukkit/util/Vector;", "yawOffset", "", "pitchOffset", "<init>", "(Lgg/aquatic/aquaticcrates/api/animation/Animation;Lgg/aquatic/comet/api/emitter/AbstractUnrealizedEmitter;Lorg/bukkit/util/Vector;FF)V", "getAnimation", "()Lgg/aquatic/aquaticcrates/api/animation/Animation;", "getOffset", "()Lorg/bukkit/util/Vector;", "getYawOffset", "()F", "getPitchOffset", "spawnedEmitter", "Lgg/aquatic/comet/api/emitter/AbstractEmitter;", "getSpawnedEmitter", "()Lgg/aquatic/comet/api/emitter/AbstractEmitter;", "tick", "", "onAnimationEnd", "plugin"}
   )
   public static final class CometParticleAnimationProp extends AnimationProp {
      @NotNull
      private final Animation animation;
      @NotNull
      private final Vector offset;
      private final float yawOffset;
      private final float pitchOffset;
      @NotNull
      private final AbstractEmitter spawnedEmitter;

      public CometParticleAnimationProp(@NotNull Animation var1, @NotNull AbstractUnrealizedEmitter var2, @NotNull Vector var3, float var4, float var5) {
         Intrinsics.checkNotNullParameter(var1, "animation");
         Intrinsics.checkNotNullParameter(var2, "emitter");
         Intrinsics.checkNotNullParameter(var3, "offset");
         super();
         this.animation = var1;
         this.offset = var3;
         this.yawOffset = var4;
         this.pitchOffset = var5;
         Location var6 = this.getAnimation().getBaseLocation().clone();
         Object var11 = null;
         boolean var8 = false;
         var6.add(this.offset);
         var6.setYaw(var6.getYaw() + this.yawOffset);
         var6.setPitch(var6.getPitch() + this.pitchOffset);
         Unit var12 = Unit.INSTANCE;
         Intrinsics.checkNotNullExpressionValue(var6, "apply(...)");
         this.spawnedEmitter = AbstractUnrealizedEmitter.realize$default(var2, (Parent)var11, var6, (EnvironmentData)null, this.getAnimation().getAudience(), 4, (Object)null);
      }

      @NotNull
      public Animation getAnimation() {
         return this.animation;
      }

      @NotNull
      public final Vector getOffset() {
         return this.offset;
      }

      public final float getYawOffset() {
         return this.yawOffset;
      }

      public final float getPitchOffset() {
         return this.pitchOffset;
      }

      @NotNull
      public final AbstractEmitter getSpawnedEmitter() {
         return this.spawnedEmitter;
      }

      public void tick() {
      }

      public void onAnimationEnd() {
         this.spawnedEmitter.kill();
      }
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/misc/hook/CometHook$HideCometParticleAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
   )
   public static final class HideCometParticleAction implements ExecutableObject<Animation, Unit> {
      @NotNull
      private final List<AquaticObjectArgument<?>> arguments = CollectionsKt.listOf(new PrimitiveObjectArgument("id", "example", true));

      @NotNull
      public List<AquaticObjectArgument<?>> getArguments() {
         return this.arguments;
      }

      public void execute(@NotNull Animation var1, @NotNull ObjectArguments var2, @NotNull Function2<? super Animation, ? super String, String> var3) {
         Intrinsics.checkNotNullParameter(var1, "binder");
         Intrinsics.checkNotNullParameter(var2, "args");
         Intrinsics.checkNotNullParameter(var3, "textUpdater");
         String var10000 = var2.string("id", CometHook.HideCometParticleAction::execute$lambda$0);
         if (var10000 != null) {
            String var4 = var10000;
            AnimationProp var5 = (AnimationProp)var1.getProps().remove(var4);
            if (var5 != null) {
               var5.onAnimationEnd();
            }

         }
      }

      private static final String execute$lambda$0(Function2 var0, Animation var1, String var2) {
         Intrinsics.checkNotNullParameter(var2, "it");
         return (String)var0.invoke(var1, var2);
      }
   }

   @Metadata(
      mv = {2, 1, 0},
      k = 1,
      xi = 48,
      d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
      d2 = {"Lgg/aquatic/aquaticcrates/plugin/misc/hook/CometHook$ShowCometParticleAction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/api/animation/Animation;", "", "Lgg/aquatic/waves/util/generic/Action;", "<init>", "()V", "arguments", "", "Lgg/aquatic/waves/util/argument/AquaticObjectArgument;", "getArguments", "()Ljava/util/List;", "execute", "binder", "args", "Lgg/aquatic/waves/util/argument/ObjectArguments;", "textUpdater", "Lgg/aquatic/waves/libs/kotlin/Function2;", "", "plugin"}
   )
   public static final class ShowCometParticleAction implements ExecutableObject<Animation, Unit> {
      @NotNull
      private final List<AquaticObjectArgument<?>> arguments;

      public ShowCometParticleAction() {
         PrimitiveObjectArgument[] var1 = new PrimitiveObjectArgument[]{new PrimitiveObjectArgument("id", "example", true), new PrimitiveObjectArgument("emitter", "example", true), new PrimitiveObjectArgument("offset", "0;0;0", false)};
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
         String var10000 = var2.string("id", CometHook.ShowCometParticleAction::execute$lambda$0);
         if (var10000 != null) {
            String var4 = var10000;
            var10000 = var2.string("emitter", CometHook.ShowCometParticleAction::execute$lambda$1);
            if (var10000 != null) {
               String var5 = var10000;
               var10000 = var2.string("offset", CometHook.ShowCometParticleAction::execute$lambda$2);
               if (var10000 == null) {
                  var10000 = "0;0;0";
               }

               List var7;
               Vector var17;
               double var19;
               label65: {
                  String var6 = var10000;
                  CharSequence var16 = (CharSequence)var6;
                  String[] var8 = new String[]{";"};
                  var7 = StringsKt.split$default(var16, var8, false, 0, 6, (Object)null);
                  var17 = new Vector;
                  String var10002 = (String)CollectionsKt.getOrNull(var7, 0);
                  if (var10002 != null) {
                     Double var18 = StringsKt.toDoubleOrNull(var10002);
                     if (var18 != null) {
                        var19 = var18;
                        break label65;
                     }
                  }

                  var19 = 0.0D;
               }

               double var23;
               label60: {
                  String var10003 = (String)CollectionsKt.getOrNull(var7, 1);
                  if (var10003 != null) {
                     Double var22 = StringsKt.toDoubleOrNull(var10003);
                     if (var22 != null) {
                        var23 = var22;
                        break label60;
                     }
                  }

                  var23 = 0.0D;
               }

               double var25;
               label55: {
                  String var10004 = (String)CollectionsKt.getOrNull(var7, 2);
                  if (var10004 != null) {
                     Double var24 = StringsKt.toDoubleOrNull(var10004);
                     if (var24 != null) {
                        var25 = var24;
                        break label55;
                     }
                  }

                  var25 = 0.0D;
               }

               Vector var15;
               Float var20;
               float var21;
               label50: {
                  var17.<init>(var19, var23, var25);
                  var15 = var17;
                  var10000 = (String)CollectionsKt.getOrNull(var7, 3);
                  if (var10000 != null) {
                     var20 = StringsKt.toFloatOrNull(var10000);
                     if (var20 != null) {
                        var21 = var20;
                        break label50;
                     }
                  }

                  var21 = 0.0F;
               }

               float var9;
               label45: {
                  var9 = var21;
                  var10000 = (String)CollectionsKt.getOrNull(var7, 4);
                  if (var10000 != null) {
                     var20 = StringsKt.toFloatOrNull(var10000);
                     if (var20 != null) {
                        var21 = var20;
                        break label45;
                     }
                  }

                  var21 = 0.0F;
               }

               float var10 = var21;
               AbstractUnrealizedEmitter var13 = CometRegistry.INSTANCE.unrealizedEmitterByID(var5);
               if (var13 != null) {
                  AbstractUnrealizedEmitter var11 = var13;
                  CometHook.CometParticleAnimationProp var12 = new CometHook.CometParticleAnimationProp(var1, var11, var15, var9, var10);
                  AnimationProp var14 = (AnimationProp)var1.getProps().remove(var4);
                  if (var14 != null) {
                     var14.onAnimationEnd();
                  }

                  var1.getProps().put(var4, var12);
               }
            }
         }
      }

      private static final String execute$lambda$0(Function2 var0, Animation var1, String var2) {
         Intrinsics.checkNotNullParameter(var2, "it");
         return (String)var0.invoke(var1, var2);
      }

      private static final String execute$lambda$1(Function2 var0, Animation var1, String var2) {
         Intrinsics.checkNotNullParameter(var2, "it");
         return (String)var0.invoke(var1, var2);
      }

      private static final String execute$lambda$2(Function2 var0, Animation var1, String var2) {
         Intrinsics.checkNotNullParameter(var2, "it");
         return (String)var0.invoke(var1, var2);
      }
   }
}
