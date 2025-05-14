import dk.sdu.cbse.HelloOnBoot;
import dk.sdu.cbse.asteroidsystem.AsteroidPlugin;
import dk.sdu.cbse.asteroidsystem.AsteroidProcessing;
import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;

module Asteroid {
    requires Common;
    provides IGamePluginService with AsteroidPlugin,HelloOnBoot;
    provides IEntityProcessingService with AsteroidProcessing;
}
