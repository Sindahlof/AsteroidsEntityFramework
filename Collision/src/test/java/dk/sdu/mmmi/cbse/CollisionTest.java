package dk.sdu.mmmi.cbse;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.Type;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CollisionTest {
    private GameData gameData;
    private World world;
    private Collision collision;
    private Entity entity1;
    private Entity entity2;
    private PositionPart position;
    private LifePart lifePart;

    @BeforeEach
    public void setUp(){
        //Initialization
        this.collision = new Collision();
        this.entity1 = new Entity();
        this.entity2 = new Entity();
        this.position = new PositionPart(2,2,2);

        this.lifePart = new LifePart(1,0);
        this.world = new World();

        //Arrange
        this.entity1.add(this.position);
        this.entity2.add(this.position);
        this.entity1.add(this.lifePart);
        this.entity2.add(this.lifePart);
        this.entity1.setRadius(1);
        this.entity1.setRadius(1);

        //Act
        this.entity1.setType(Type.PLAYER);
        this.entity2.setType(Type.ENEMY);
        this.world.addEntity(entity1);
        this.world.addEntity(entity2);

    }

    @Test
    public void testColision(){
        //This test shows that after colision accours one entity is removed.

        //Act
        collision.process(gameData,world);
        LifePart lifePart1 = entity2.getPart(LifePart.class);
        System.out.println(lifePart1.getLife());

        //Assert
        Assertions.assertEquals(-1,lifePart1.getLife());

    }
}