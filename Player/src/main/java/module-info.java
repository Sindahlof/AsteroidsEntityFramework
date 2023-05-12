import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Player {
    requires Common;

    uses dk.sdu.mmmi.cbse.common.services.BulletPluginService;


    provides IEntityProcessingService with dk.sdu.mmmi.cbse.playersystem.PlayerControlSystem;
    provides IGamePluginService with dk.sdu.mmmi.cbse.playersystem.PlayerPlugin;
}