package gg.aquatic.aquaticcrates.plugin.animation.prop;

import com.destroystokyo.paper.profile.PlayerProfile;
import gg.aquatic.waves.Waves;
import gg.aquatic.waves.api.nms.NMSHandler;
import gg.aquatic.waves.api.nms.profile.GameEventAction;
import gg.aquatic.waves.api.nms.profile.ProfileEntry;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.util.EntityExtKt;
import gg.aquatic.waves.util.version.ServerVersion;
import net.kyori.adventure.text.Component;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nBukkitRunnableExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BukkitRunnableExt.kt\ngg/aquatic/waves/util/BukkitRunnableExtKt$runLaterSync$1\n+ 2 CameraAnimationProp.kt\ngg/aquatic/aquaticcrates/plugin/animation/prop/CameraAnimationProp\n*L\n1#1,32:1\n63#2,26:33\n*E\n"})
public final class CameraAnimationProp$attachPlayer$lambda$2$$inlined$runLaterSync$1 implements Runnable {
   // $FF: synthetic field
   final CameraAnimationProp this$0;

   public CameraAnimationProp$attachPlayer$lambda$2$$inlined$runLaterSync$1(CameraAnimationProp var1) {
      this.this$0 = var1;
   }

   public final void run() {
      boolean var1 = false;
      Object var2 = this.this$0.getPacketEntity().getSpawnPacket();
      Player var3 = this.this$0.getAnimation().getPlayer();
      EntityExtKt.sendPacket$default(var3, var2, false, 2, (Object)null);
      ServerVersion var10000 = ServerVersion.Companion.ofAquatic((JavaPlugin)Waves.Companion.getINSTANCE());
      int var4 = (var10000 != null ? var10000.isOlder(ServerVersion.V_1_21_4) : true) ? 0 : CameraAnimationProp.access$modernPlayerListOrder(this.this$0, var3);
      NMSHandler var8 = Waves.Companion.getNMS_HANDLER();
      CameraAnimationProp var10004 = this.this$0;
      PlayerProfile var10005 = var3.getPlayerProfile();
      Intrinsics.checkNotNullExpressionValue(var10005, "getPlayerProfile(...)");
      Object var5 = var8.createPlayerInfoUpdatePacket(2, new ProfileEntry(CameraAnimationProp.access$toUserProfile(var10004, var10005), true, 0, GameMode.CREATIVE, (Component)null, true, var4));
      Object var6 = Waves.Companion.getNMS_HANDLER().createChangeGameStatePacket(GameEventAction.CHANGE_GAME_MODE, (float)GameMode.SPECTATOR.getValue());
      Object var7 = Waves.Companion.getNMS_HANDLER().createCameraPacket(this.this$0.getPacketEntity().getEntityId());
      EntityExtKt.sendPacket$default(var3, var5, false, 2, (Object)null);
      EntityExtKt.sendPacket$default(var3, var6, false, 2, (Object)null);
      EntityExtKt.sendPacket$default(var3, var7, false, 2, (Object)null);
   }
}
