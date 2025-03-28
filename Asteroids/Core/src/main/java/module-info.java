import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

module Core {
    requires javafx.graphics;
    requires Common;
    uses IGamePluginService;
    uses IEntityProcessingService;
    uses IPostEntityProcessingService;
    opens dk.sdu.cbse.main to javafx.graphics;
}
