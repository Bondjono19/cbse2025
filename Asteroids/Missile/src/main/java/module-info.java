import dk.sdu.cbse.common.services.IProcessingService;
import dk.sdu.cbse.shooting.BasicMissileProcessing;
import dk.sdu.cbse.shooting.IMissile;

module Missile {
    requires transitive Common;
    exports dk.sdu.cbse.shooting;
    provides IMissile with BasicMissileProcessing;
    provides IProcessingService with BasicMissileProcessing;
}
