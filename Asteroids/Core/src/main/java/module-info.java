import dk.sdu.cbse.common.services.IPlugin;
import dk.sdu.cbse.common.services.IPostProcess;
import dk.sdu.cbse.common.services.IProcess;

module Core {
    requires javafx.graphics;
    requires Common;
    uses IPlugin;
    uses IProcess;
    uses IPostProcess;
    opens dk.sdu.cbse.main to javafx.graphics;
}
