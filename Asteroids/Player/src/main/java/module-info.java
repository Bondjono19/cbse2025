import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.shooting.IMissile;

module Player {
    requires Common;
    requires Missile;
    provides IGamePluginService with dk.sdu.cbse.player.PlayerPlugin;
    provides IEntityProcessingService with dk.sdu.cbse.player.PlayerControl;
    uses IMissile;
}
