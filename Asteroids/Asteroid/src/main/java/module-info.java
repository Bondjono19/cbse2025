import dk.sdu.cbse.asteroidsystem.AsteroidPlugin;
import dk.sdu.cbse.asteroidsystem.AsteroidProcessing;
import dk.sdu.cbse.common.services.IProcessingService;
import dk.sdu.cbse.common.services.IPluginService;

module Asteroid {
    requires Common;
    provides IPluginService with AsteroidPlugin;
    provides IProcessingService with AsteroidProcessing;
}
