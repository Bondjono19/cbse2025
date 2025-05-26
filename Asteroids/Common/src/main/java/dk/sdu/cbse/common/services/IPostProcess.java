package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

/**
 * Interface for processing a plugin after the main game processes for that specific time frame have been executed.
 * 
 */

public interface IPostProcess {
    /**
     * This method runs once every frame, however, after the primary processes have executed, so entities and their states
     * can be evaluated (For instance collision)<br>
     * Pre-conditions: <br>
     * - The method {@link IProcess#process(GameData, World)} runs prior to this method, as well as the method {@link IPlugin#start(GameData, World)} <br>
     * Post-conditionns: <br>
     * @param gameData Global instance of GameData class. Must not be {@code null}
     * @param world Global instance of World class.  Must not be {@code null}
     */
    public void process(GameData gameData, World world);
}
