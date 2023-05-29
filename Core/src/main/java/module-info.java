import dk.sdu.mmmi.cbse.common.services.*;


module Core {
    requires Common;
    requires java.desktop;
    requires ShadedLibGDX;
    requires spring.context;

    uses dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
    uses dk.sdu.mmmi.cbse.common.services.IGamePluginService;
    uses dk.sdu.mmmi.cbse.common.services.BulletPluginService;
    uses dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

    exports dk.sdu.mmmi.cbse.components;
    exports dk.sdu.mmmi.cbse.main;
}