package dk.sdu.cbse.shooting;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

public interface IMissile {
    public Entity createMissile(Entity shooter,Class<?> origin);
}
