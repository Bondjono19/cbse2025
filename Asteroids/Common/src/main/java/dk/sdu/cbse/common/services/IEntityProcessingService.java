package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

/**
 * Interface for processing each plugin.
 */

public interface IEntityProcessingService {
    /**
     *  The method runs once every frame, and is to process the plugin and its entities as the time progresses in the game. <br>
     *  <b>Preconditions</b>
     * <ul>
     * <li>
     *  The method {@link IGamePluginService#start(GameData, World)} should have run once prior to this method, 
     *  to ensure that entites, if any, have been loaded into the game prior to this method's execution. </li>
     * <li>
     *  {@code gameData} is not {@code null}.
     * </li>
     * <li> 
     * {@code world} is not {@code null}.
     * </li>
     * </ul>
     * <b>Postconditions</b>
     * <ul>
     * <li>
     * Interal state of entities managed by this plugin are updated. (such as position for instance)
     * </li>
     * <li>
     * The game world reflects the result of the plugins logic.
     * </li>
     * </ul>
     * @param gameData Global instance of GameData class. Must not be {@code null}
     * @param world Global instance of World class.  Must not be {@code null}
     */
    void process(GameData gameData, World world);
}