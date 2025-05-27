import dk.sdu.cbse.common.services.IPlugin;
import dk.sdu.cbse.common.services.IPostProcess;
import dk.sdu.cbse.common.services.IProcess;

module Core {
    requires javafx.graphics;
    requires Common;
    uses IPlugin;
    uses IProcess;
    uses IPostProcess;
    requires spring.context;
    requires spring.beans;
    opens dk.sdu.cbse.main to javafx.graphics;
}
