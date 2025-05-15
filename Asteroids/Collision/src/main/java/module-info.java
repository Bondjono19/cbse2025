import dk.sdu.cbse.collision.Collision;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    requires spring.context;
    provides IPostEntityProcessingService with Collision;
    exports dk.sdu.cbse.collision;
}
