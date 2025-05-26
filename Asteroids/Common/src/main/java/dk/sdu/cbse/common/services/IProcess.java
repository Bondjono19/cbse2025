package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

/**
 * Interface for processing each plugin.
 */

public interface IProcess {
    /**
     *  The method runs once every frame, and is to process the plugin and its entities as the time progresses in the game. <br>
     *  Pre-conditions: <br>
     *  - The method {@link IPlugin#start(GameData, World)} should have run once prior to this method, 
     *  to ensure that entites, if any, have been loaded into the game prior to this method's execution. <br>
     *  - {@code gameData} is not {@code null}.
     *  - {@code world} is not {@code null}.
     * Post-conditions: <br>
     * - Interal state of entities managed by this plugin are updated. (such as position for instance)
     * - The game world reflects the result of the plugins logic.
     * @param gameData Global instance of GameData class. Must not be {@code null}
     * @param world Global instance of World class.  Must not be {@code null}
     */
    void process(GameData gameData, World world);
}
