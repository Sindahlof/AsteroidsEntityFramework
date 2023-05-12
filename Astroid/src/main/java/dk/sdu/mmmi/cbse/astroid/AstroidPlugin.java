package dk.sdu.mmmi.cbse.astroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;


public class AstroidPlugin implements IGamePluginService{

    private Entity astroid ;

    @Override
    public void start(GameData gameData, World world) {

        //Add entites to the world
        for (int i = 0; i <2; i++ ) {
            astroid = createEnemyShip(gameData);
            world.addEntity(astroid);
        }
    }

    private Entity createEnemyShip(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 70;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth() / 2;
        float y = gameData.getDisplayHeight() / 2;
        float radians = 3.1415f / 2;

        Entity astroidRock = new Astroid();
        astroidRock.setRadius(8);
        astroidRock.add(new LifePart(8,69));
        astroidRock.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        astroidRock.add(new PositionPart(x, y, radians));

        return astroidRock;
    }



    @Override
    public void stop(GameData gameData, World world) {
        //Remove entites
        world.removeEntity(astroid);
    }
}
