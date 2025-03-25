package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

/**
 * Interface for initializing and stopping plugins for the game
 * 
 * 
 */

public interface IGamePluginService {
    /**
     * 
     * This method initializes the plugin. Add entities and other necessities. <br>
     * - Pre-Conditions: <br>
     * {@code gameData} and {@code world} should be initialized first, that is, they must not be {@code null}. <br>
     * - Post-Condtions: <br>
     * All entites that appear at start of game must have been added to world.
     * @param gameData Global instance of GameData class.
     * @param world Global instance of World class.
     */ 
    public void start(GameData gameData, World world);

     /**
     * 
     * This method stops the plugin. Removes entities and other necessities. <br>
     * - Pre-Conditions: <br>
     * {@code gameData} and {@code world} should be initialized first, they must not be {@code null} and the method {@link IGamePluginService#start(GameData, World)} should have run first. <br>
     * - Post-Condtions: <br>
     * All entites that and other things that the plugin has provided the game with, have been removed.
     * @param gameData Global instance of GameData class.
     * @param world Global instance of World class.
     */ 
    public void stop(GameData gameData, World world);
}
