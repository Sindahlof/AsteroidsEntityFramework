import dk.sdu.mmmi.cbse.common.services.BulletPluginService;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

module Bullet {
    requires Common;
    exports dk.sdu.mmmi.cbse.bullet;


    provides IEntityProcessingService with dk.sdu.mmmi.cbse.bullet.BulletMovementSystem;
    provides BulletPluginService with dk.sdu.mmmi.cbse.bullet.BulletPlugin;
}