import dk.sdu.cbse.HelloOnBoot;
import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.enemy.EnemyPlugin;
import dk.sdu.cbse.enemy.EnemyProcessing;
import dk.sdu.cbse.shooting.IMissile;

module Enemy {
    requires Common;
    requires Missile;
    requires Collision;
    provides IGamePluginService with EnemyPlugin,HelloOnBoot;
    provides IEntityProcessingService with EnemyProcessing;
    uses IMissile;
}
