
import dk.sdu.cbse.common.services.IMissile;
import dk.sdu.cbse.common.services.IProcess;
import dk.sdu.cbse.shooting.BasicMissileProcessing;

module Missile {
    requires transitive Common;
    exports dk.sdu.cbse.shooting;
    provides IMissile with BasicMissileProcessing;
    provides IProcess with BasicMissileProcessing;
}
