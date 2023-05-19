 module Astroid {
    exports dk.sdu.mmmi.cbse.astroid;
    requires Common;

    provides dk.sdu.mmmi.cbse.common.services.IGamePluginService with dk.sdu.mmmi.cbse.astroid.AstroidPlugin;
    provides dk.sdu.mmmi.cbse.common.services.IEntityProcessingService with dk.sdu.mmmi.cbse.astroid.AstroidControlSystem;
 }