package gg.aquatic.aquaticcrates.plugin.restriction;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.util.generic.ExecutableObject;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/restriction/OpenRestriction;", "Lgg/aquatic/waves/util/generic/ExecutableObject;", "Lgg/aquatic/aquaticcrates/plugin/restriction/OpenData;", "", "Lgg/aquatic/waves/util/generic/Condition;", "<init>", "()V", "plugin"}
)
public abstract class OpenRestriction implements ExecutableObject<OpenData, Boolean> {
}
