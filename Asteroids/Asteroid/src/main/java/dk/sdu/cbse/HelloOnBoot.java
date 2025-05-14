package dk.sdu.cbse;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;

public class HelloOnBoot implements IGamePluginService{

    @Override
    public void start(GameData gameData, World world) {
        System.out.println("Hello from package 1 - dk.sdu.cbse.HelloOnBoot");
    }

    @Override
    public void stop(GameData gameData, World world) {
        System.out.println("Bye from package 1");
    }
    
}
