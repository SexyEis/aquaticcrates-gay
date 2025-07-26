package gg.aquatic.aquaticcrates.api.animation.prop;

import gg.aquatic.waves.item.AquaticItem;
import gg.aquatic.waves.libs.kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"},
   d2 = {"Lgg/aquatic/aquaticcrates/api/animation/prop/ItemBasedProp;", "", "item", "Lgg/aquatic/waves/item/AquaticItem;", "api"}
)
public interface ItemBasedProp {
   @Nullable
   AquaticItem item();
}
