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
    requires Score;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    opens dk.sdu.cbse.main to javafx.graphics;
}
