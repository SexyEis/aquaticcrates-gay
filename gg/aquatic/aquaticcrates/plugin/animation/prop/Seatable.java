package gg.aquatic.aquaticcrates.plugin.animation.prop;

import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.EntityAnimationProp;
import gg.aquatic.waves.libs.kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/Seatable;", "", "addPassenger", "", "entityAnimationProp", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/EntityAnimationProp;", "removePassenger", "plugin"}
)
public interface Seatable {
   void addPassenger(@NotNull EntityAnimationProp var1);

   void removePassenger(@NotNull EntityAnimationProp var1);
}
