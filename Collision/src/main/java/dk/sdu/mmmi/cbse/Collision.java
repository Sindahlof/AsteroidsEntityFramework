package dk.sdu.mmmi.cbse;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
public class Collision implements IPostEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity : world.getEntities()){
            for (Entity collides : world.getEntities()){
                LifePart life = entity.getPart(LifePart.class);
                LifePart col = collides.getPart(LifePart.class);
                if (entity.getID().equals(collides.getID())) {
                    continue;
                }
                System.out.println(entity.getType());
                if (entity.getType().equals(collides.getType())){
                    continue;
                }

                //System.out.println(life.isDead());
                if (life.isDead()){
                    world.removeEntity(entity);
                }
                if(pythagaros(entity,collides)){
                    int fu = life.getLife() - 1;
                    int bar = col.getLife() - 1;
                    life.setLife(fu);
                    col.setLife(bar);
                    life.setIsHit(true);
                    col.setIsHit(true);
                }
            }
        }
    }

    private boolean pythagaros(Entity entity1, Entity entity2){
        PositionPart part1 = entity1.getPart(PositionPart.class);
        PositionPart part2 = entity2.getPart(PositionPart.class);

        float dx = part1.getX() - part2.getX();
        float dy = part1.getY() - part2.getY();

        float collide = (float) Math.sqrt(dx * dx + dy * dy );

        if (collide < entity1.getRadius() + entity2.getRadius()){
            return true;
        }

        return false;
    }



}