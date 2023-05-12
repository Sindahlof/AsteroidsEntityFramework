package dk.sdu.mmmi.cbse.bullet;


import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.TimePart;
import dk.sdu.mmmi.cbse.common.services.BulletPluginService;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class BulletPlugin implements BulletPluginService {

    private Entity bullet;

    public BulletPlugin() {
    }


    public void stop(GameData gameData, World world) {
        world.removeEntity(bullet);
    }


    @Override
    public Entity createBullet(GameData gameData, Entity entity) {
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float deacceleration = 0;
        float acceleration = 400;
        float maxSpeed = 400;
        float rotationSpeed = 0;
        float radians = positionPart.getRadians();
        float x = positionPart.getX();
        float y = positionPart.getY();

        Entity bullet = new Bullet();
        bullet.setRadius(4);

        float bx = (float) cos(radians) * entity.getRadius() * bullet.getRadius();
        float by = (float) sin(radians) * entity.getRadius() * bullet.getRadius();

        float dt = gameData.getDelta();


        bullet.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        bullet.add(new PositionPart(bx + x, by + y, radians));
        bullet.add(new TimePart(2));
        bullet.add(new LifePart(1, 69));
        return bullet;
    }

}
