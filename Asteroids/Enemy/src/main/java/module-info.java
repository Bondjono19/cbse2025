import dk.sdu.cbse.common.services.IMissile;
import dk.sdu.cbse.common.services.IPlugin;
import dk.sdu.cbse.common.services.IProcess;
import dk.sdu.cbse.enemy.EnemyPlugin;
import dk.sdu.cbse.enemy.EnemyProcessing;

module Enemy {
    requires Common;
    provides IPlugin with EnemyPlugin;
    provides IProcess with EnemyProcessing;
    uses IMissile;
}
