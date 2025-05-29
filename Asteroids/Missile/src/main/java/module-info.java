import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.shooting.BasicMissileProcessing;
import dk.sdu.cbse.shooting.IMissile;

module Missile {
    requires transitive Common;
    requires spring.context;
    exports dk.sdu.cbse.shooting;
    provides IMissile with BasicMissileProcessing;
    provides IEntityProcessingService with BasicMissileProcessing;
}
