import dk.sdu.cbse.asteroidsystem.AsteroidPlugin;
import dk.sdu.cbse.asteroidsystem.AsteroidProcessing;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IEntityProcessingService;

module Asteroid {
    requires Common;
    requires spring.context;
    provides IGamePluginService with AsteroidPlugin;
    provides IEntityProcessingService with AsteroidProcessing;
    exports dk.sdu.cbse.asteroidsystem;
}
