package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

/**
 * Interface for processing a plugin after the main game processes for that specific time frame have been executed.
 * 
 */

public interface IPostEntityProcessingService {
    /**
     * This method runs once every frame, however, after the primary processes have executed, so entities and their states
     * can be evaluated (For instance collision)<br>
     * <b>Preconditions</b>
     * <ul>
     * <li>
     * The method {@link IEntityProcessingService#process(GameData, World)} runs prior to this method, as well as the method {@link IGamePluginService#start(GameData, World)} <br>
     * </li>
     * </ul>
     * <b>Postconditions</b>
     * <ul>
     * <li>
     * - Entity states may have been updated based on post calculations, such as collisions, health deducted etc.
     * </li>
     * <li>
     * - The world reflects the final state changes for this current frame.
     * </li>
     * </ul>
     * @param gameData Global instance of GameData class. Must not be {@code null}
     * @param world Global instance of World class.  Must not be {@code null}
     */
    public void process(GameData gameData, World world);
}
