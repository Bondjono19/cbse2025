import dk.sdu.cbse.common.services.IMissile;
import dk.sdu.cbse.common.services.IPlugin;
import dk.sdu.cbse.common.services.IProcess;

module Player {
    requires Common;
    provides IPlugin with dk.sdu.cbse.player.PlayerPlugin;
    provides IProcess with dk.sdu.cbse.player.PlayerControl;
    uses IMissile;
}
