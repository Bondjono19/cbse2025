import dk.sdu.cbse.asteroidsystem.AsteroidPlugin;
import dk.sdu.cbse.asteroidsystem.AsteroidProcessing;
import dk.sdu.cbse.common.services.IPlugin;
import dk.sdu.cbse.common.services.IProcess;

module Asteroid {
    requires Common;
    requires spring.context;
    provides IPlugin with AsteroidPlugin;
    provides IProcess with AsteroidProcessing;
    exports dk.sdu.cbse.asteroidsystem;
}
