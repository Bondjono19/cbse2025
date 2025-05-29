import dk.sdu.cbse.collision.Collision;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    provides IPostEntityProcessingService with Collision;
    exports dk.sdu.cbse.collision;
}
