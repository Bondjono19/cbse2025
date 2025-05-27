import dk.sdu.cbse.common.services.IPlugin;
import dk.sdu.cbse.common.services.IProcess;
import dk.sdu.cbse.shooting.IMissile;

module Player {
    requires Common;
    requires Missile;
    requires spring.context;
    requires spring.beans;
    opens dk.sdu.cbse.player to spring.core;
    provides IPlugin with dk.sdu.cbse.player.PlayerPlugin;
    provides IProcess with dk.sdu.cbse.player.PlayerControl;
    uses IMissile;
    exports dk.sdu.cbse.player;
}
