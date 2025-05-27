import dk.sdu.cbse.common.services.IPlugin;
import dk.sdu.cbse.common.services.IProcess;
import dk.sdu.cbse.enemy.EnemyPlugin;
import dk.sdu.cbse.enemy.EnemyProcessing;
import dk.sdu.cbse.shooting.IMissile;

module Enemy {
    requires Common;
    requires Missile;
    requires Collision;
    provides IPlugin with EnemyPlugin;
    provides IProcess with EnemyProcessing;
    uses IMissile;
    opens dk.sdu.cbse.enemy to spring.core;
    exports dk.sdu.cbse.enemy;
    requires spring.context;
    requires spring.beans;
}
