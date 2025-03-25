package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

/**
 * Interface for processing each plugin.
 */

public interface IEntityProcessingService {
    /**
     *  The method runs once every frame, and is to process the plugin and its entities as the time progresses in the game. <br>
     *  Pre-conditions: <br>
     *  - The method {@link IGamePluginService#start(GameData, World)} should have run once prior to this method, 
     *  to ensure that entites, if any, have been loaded into the game prior to this method's execution. <br>
     *  
     * Post-conditions: <br>
     * @param gameData Global instance of GameData class. Must not be {@code null}
     * @param world Global instance of World class.  Must not be {@code null}
     */
    void process(GameData gameData, World world);
}
