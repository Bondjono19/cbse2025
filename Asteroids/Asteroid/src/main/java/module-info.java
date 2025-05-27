import dk.sdu.cbse.HelloOnBoot;
import dk.sdu.cbse.asteroidsystem.AsteroidPlugin;
import dk.sdu.cbse.asteroidsystem.AsteroidProcessing;
import dk.sdu.cbse.common.services.IPlugin;
import dk.sdu.cbse.common.services.IProcess;

module Asteroid {
    requires Common;
    provides IPlugin with AsteroidPlugin,HelloOnBoot;
    provides IProcess with AsteroidProcessing;
}
