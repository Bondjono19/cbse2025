import dk.sdu.cbse.asteroidsystem.AsteroidPlugin;
import dk.sdu.cbse.asteroidsystem.AsteroidProcessing;
import dk.sdu.cbse.common.services.IProcess;
import dk.sdu.cbse.common.services.IPlugin;

module Asteroid {
    requires Common;
    provides IPlugin with AsteroidPlugin;
    provides IProcess with AsteroidProcessing;
}
