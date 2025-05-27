import dk.sdu.cbse.collision.Collision;
import dk.sdu.cbse.common.services.IPostProcess;

module Collision {
    requires Common;
    provides IPostProcess with Collision;
    exports dk.sdu.cbse.collision;
}
