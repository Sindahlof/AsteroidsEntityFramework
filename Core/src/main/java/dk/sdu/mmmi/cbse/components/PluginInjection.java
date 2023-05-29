package dk.sdu.mmmi.cbse.components;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.utils.SPILocator;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("pluginInjector")
public class PluginInjection {

    public void pluginCreate(GameData gameData, World world) {
        List<IGamePluginService> list = SPILocator.locateAll(IGamePluginService.class);
        for (IGamePluginService plugin : list) {
            plugin.start(gameData, world);
        }
    }
}
