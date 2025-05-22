import dk.sdu.cbse.collision.Collision;
import dk.sdu.cbse.common.services.IPostProcessingService;

module Collision {
    requires Common;
    provides IPostProcessingService with Collision;
    exports dk.sdu.cbse.collision;
}
