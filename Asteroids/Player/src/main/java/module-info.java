import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.shooting.IMissile;

module Player {
    requires Common;
    requires Missile;
    requires spring.context;
    requires spring.beans;
    opens dk.sdu.cbse.player to spring.core;
    provides IGamePluginService with dk.sdu.cbse.player.PlayerPlugin;
    provides IEntityProcessingService with dk.sdu.cbse.player.PlayerControl;
    uses IMissile;
    exports dk.sdu.cbse.player;
}
