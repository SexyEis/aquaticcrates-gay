package gg.aquatic.aquaticcrates.plugin.animation.prop.entity.property;

import gg.aquatic.aquaticcrates.plugin.animation.prop.entity.EntityAnimationProp;
import gg.aquatic.waves.fake.entity.FakeEntity;
import gg.aquatic.waves.libs.kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/property/EntityProperty;", "", "apply", "", "entity", "Lgg/aquatic/waves/fake/entity/FakeEntity;", "prop", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/entity/EntityAnimationProp;", "plugin"}
)
public interface EntityProperty {
   void apply(@NotNull FakeEntity var1, @NotNull EntityAnimationProp var2);
}
