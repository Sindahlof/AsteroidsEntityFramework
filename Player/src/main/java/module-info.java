import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Player {
    exports Player;

    requires Common;

    uses dk.sdu.mmmi.cbse.common.services.IGamePluginService;

    provides dk.sdu.mmmi.cbse.playersystem.Player;
}