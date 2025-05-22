import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.common.services.IProcessingService;
import dk.sdu.cbse.enemy.EnemyPlugin;
import dk.sdu.cbse.enemy.EnemyProcessing;
import dk.sdu.cbse.shooting.IMissile;

module Enemy {
    requires Common;
    requires Missile;
    requires Collision;
    provides IPluginService with EnemyPlugin;
    provides IProcessingService with EnemyProcessing;
    uses IMissile;
}
