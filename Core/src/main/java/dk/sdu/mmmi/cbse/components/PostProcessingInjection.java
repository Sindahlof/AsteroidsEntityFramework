package dk.sdu.mmmi.cbse.components;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.cbse.common.utils.SPILocator;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service("postProcessInjection")
public class PostProcessingInjection {

    public void startPostProcessing(GameData gameData, World world) {
        List<IPostEntityProcessingService> list = SPILocator.locateAll(IPostEntityProcessingService.class);
        for (IPostEntityProcessingService processing : list){
            processing.process(gameData,world);
        }
    }
}
