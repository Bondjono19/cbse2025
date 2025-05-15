import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.enemy.EnemyPlugin;
import dk.sdu.cbse.enemy.EnemyProcessing;
import dk.sdu.cbse.shooting.IMissile;

module Enemy {
    requires Common;
    requires Missile;
    requires Collision;
    provides IGamePluginService with EnemyPlugin;
    provides IEntityProcessingService with EnemyProcessing;
    uses IMissile;
    opens dk.sdu.cbse.enemy to spring.core;
    requires spring.context;
    requires spring.beans;
}
