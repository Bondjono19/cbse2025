package dk.sdu.cbse.enemtest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IMissile;
import dk.sdu.cbse.enemy.Enemy;
import dk.sdu.cbse.enemy.EnemyPlugin;
import dk.sdu.cbse.enemy.EnemyProcessing;



public class EnemyTest {

    @Mock
    private World world;

    @Mock
    private GameData gameData;

    @Mock
    private IMissile missile;

    @InjectMocks
    private EnemyProcessing enemyProcessing;

    private Entity enemy;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        enemyProcessing = new EnemyProcessing();

        enemy = mock(Enemy.class);
    }

    //test that enemies are removed when they have 0 health
    @Test
    public void removeEnemyWhen0Health(){
        //mock getEntities method so that it always returns enemy obj
        when(world.getEntities(Enemy.class)).thenReturn(Collections.singletonList(enemy));
        //mock that enemy health is always 0
        when(enemy.getHealth()).thenReturn((double)0);
        //run single frame
        enemyProcessing.process(gameData, world);
        //verify that removeEntity method has been run on enemy obj
        verify(world).removeEntity(enemy);

    }

    //test that enemies move around
    @Test
    public void testEnemyMovement(){
        double enemyXPos = 50;//some random number
        double enemyYPos = 50;//some random number
        enemy.setX(enemyXPos);
        enemy.setY(enemyYPos);
        world.addEntity(enemy);
        enemyProcessing.process(gameData, world);
        //assert that coordinates are different after processing frame
        assertNotEquals(enemyXPos,enemy.getX());
        assertNotEquals(enemyYPos,enemy.getY());
    }

}