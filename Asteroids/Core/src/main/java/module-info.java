import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

module Core {
    requires javafx.graphics;
    requires Common;
    uses IGamePluginService;
    uses IEntityProcessingService;
    uses IPostEntityProcessingService;
    requires spring.context;
    requires spring.beans;
    requires spring.web;
    requires spring.boot;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    requires java.net.http;
    opens dk.sdu.cbse.main to javafx.graphics,spring.core,spring.beans,spring.context,spring.web,spring.boot;
}
