package gg.aquatic.aquaticcrates.plugin.animation.prop.path;

import gg.aquatic.aquaticcrates.plugin.animation.prop.Moveable;
import gg.aquatic.waves.libs.kotlin.Metadata;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathProp;", "", "points", "Ljava/util/TreeMap;", "", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathPoint;", "getPoints", "()Ljava/util/TreeMap;", "currentPoint", "getCurrentPoint", "()Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathPoint;", "boundProps", "", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/Moveable;", "Lgg/aquatic/aquaticcrates/plugin/animation/prop/path/PathBoundProperties;", "getBoundProps", "()Ljava/util/Map;", "plugin"}
)
public interface PathProp {
   @NotNull
   TreeMap<Integer, PathPoint> getPoints();

   @NotNull
   PathPoint getCurrentPoint();

   @NotNull
   Map<Moveable, PathBoundProperties> getBoundProps();
}
