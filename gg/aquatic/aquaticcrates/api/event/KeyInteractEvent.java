package gg.aquatic.aquaticcrates.api.event;

import gg.aquatic.waves.api.event.AquaticEvent;
import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/event/KeyInteractEvent;", "Lgg/aquatic/waves/api/event/AquaticEvent;", "<init>", "()V", "api"}
)
public final class KeyInteractEvent extends AquaticEvent {
   public KeyInteractEvent() {
      super(false, 1, (DefaultConstructorMarker)null);
   }
}
