package dk.sdu.mmmi.cbse.astroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.Type;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;


public class AstroidControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {

        Random random = new Random();

        for (Entity astroid : world.getEntities(Astroid.class)){
            PositionPart positionPart = astroid.getPart(PositionPart.class);
            MovingPart movingPart = astroid.getPart(MovingPart.class);
            LifePart lifePart = astroid.getPart(LifePart.class);

            int i = random.nextInt(3);
            switch (i){
                case 0:
                    movingPart.setUp(true);
                case 1:
                    movingPart.setLeft(true);

                case 2:

                case 3:
                    movingPart.setRight(true);

            }

            lifePart.process(gameData,astroid);
            movingPart.process(gameData, astroid);
            positionPart.process(gameData, astroid);

           if(lifePart.isIsHit()){
               Entity[] smallAstroids = createSmallAstroid(astroid,gameData);
               for (Entity smallAstroid : smallAstroids) {
                   world.addEntity(smallAstroid);
               }
               lifePart.setIsHit(false);
               world.removeEntity(astroid);
                return;
           }

            movingPart.setLeft(false);
            movingPart.setRight(false);
            movingPart.setUp(false);
            updateShape(astroid);
        }
    }

    private Entity[] createSmallAstroid(Entity entity, GameData gameData) {
        Entity[] smallAstroid = new Entity[2];
        PositionPart positionPart = entity.getPart(PositionPart.class);

        for (int i = 0; i < smallAstroid.length; i++){
        float deacceleration = 10;
        float acceleration = 70;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = 3.1415f / 2;
        LifePart lifePart = entity.getPart(LifePart.class);
        int f = lifePart.getLife() - 1;

        Entity astroidRock = new Astroid();
        astroidRock.setRadius(8);
        astroidRock.setType(Type.ASTROID);
        astroidRock.add(new LifePart(f,69));
        astroidRock.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        astroidRock.add(new PositionPart(x, y, radians));
        smallAstroid[i] = astroidRock;
        }
        return smallAstroid;
    }

    private void updateShape(Entity entity){
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        LifePart lifePart = entity.getPart(LifePart.class);
        int size = lifePart.getLife() * 8;
        entity.setRadius(size);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * size);
        shapey[0] = (float) (y + Math.sin(radians) * size);

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f/8 ) * size);
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f/8 ) * size);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * size);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * size);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f/8 ) * size);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f/8 ) * size);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
}
