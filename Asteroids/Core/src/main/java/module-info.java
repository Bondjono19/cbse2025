import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.cbse.common.services.IEntityProcessingService;

module Core {
    requires javafx.graphics;
    requires Common;
    uses IGamePluginService;
    uses IEntityProcessingService;
    uses IPostEntityProcessingService;
    opens dk.sdu.cbse.main to javafx.graphics;
}
