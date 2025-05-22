import dk.sdu.cbse.common.services.IProcessingService;
import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.shooting.IMissile;

module Player {
    requires Common;
    requires Missile;
    provides IPluginService with dk.sdu.cbse.player.PlayerPlugin;
    provides IProcessingService with dk.sdu.cbse.player.PlayerControl;
    uses IMissile;
}
