import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    requires Astroid;
    requires Bullet;

    provides IPostEntityProcessingService with dk.sdu.mmmi.cbse.Collision;
}