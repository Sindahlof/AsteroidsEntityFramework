package dk.sdu.mmmi.cbse.components;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.utils.SPILocator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("processInjection")
public class ProcessInjection {

    public void startProcess(GameData gameData, World world) {
        List<IEntityProcessingService> list =  SPILocator.locateAll(IEntityProcessingService.class);
        for (IEntityProcessingService processing : list){
            processing.process(gameData, world);
        }
    }
}
