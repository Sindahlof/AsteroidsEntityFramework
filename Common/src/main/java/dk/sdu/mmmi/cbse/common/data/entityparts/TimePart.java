package dk.sdu.mmmi.cbse.common.data.entityparts;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

import java.util.concurrent.TimeUnit;

public class TimePart implements EntityPart {

    private float expiraton;

    public TimePart(float expiraton){
        this.expiraton = expiraton;
    }

    public void setExpiraton(float expiraton) {
        this.expiraton = expiraton;
    }

    public float getExpiraton() {
        return expiraton;
    }

    public void reduceExpiration(float delta){
        this.expiraton -= delta;
    }

    @Override
    public void process(GameData gameData, Entity entity) {
        if (expiraton > 0){
            reduceExpiration(gameData.getDelta());
        }

        if (expiraton <= 0){
            LifePart lifePart = entity.getPart(LifePart.class);
            lifePart.setLife(0);
        }


    }
}
