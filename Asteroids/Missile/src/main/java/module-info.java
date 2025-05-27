import dk.sdu.cbse.common.services.IProcess;
import dk.sdu.cbse.shooting.BasicMissileProcessing;
import dk.sdu.cbse.shooting.IMissile;

module Missile {
    requires transitive Common;
    requires spring.context;
    exports dk.sdu.cbse.shooting;
    provides IMissile with BasicMissileProcessing;
    provides IProcess with BasicMissileProcessing;
}
