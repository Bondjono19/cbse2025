import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.common.services.IPostProcessingService;
import dk.sdu.cbse.common.services.IProcessingService;

module Core {
    requires javafx.graphics;
    requires Common;
    uses IPluginService;
    uses IProcessingService;
    uses IPostProcessingService;
    opens dk.sdu.cbse.main to javafx.graphics;
}
