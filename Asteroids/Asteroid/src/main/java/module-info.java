import dk.sdu.cbse.HelloOnBoot;
import dk.sdu.cbse.asteroidsystem.AsteroidPlugin;
import dk.sdu.cbse.asteroidsystem.AsteroidProcessing;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IEntityProcessingService;

module Asteroid {
    requires Common;
    provides IGamePluginService with AsteroidPlugin,HelloOnBoot;
    provides IEntityProcessingService with AsteroidProcessing;
}
