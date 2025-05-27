package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.Entity;

/**
 * Interface for creating missile instances.
 */

public interface IMissile {

    /**
     * This method creates a missile <br>
     * <b>Preconditions</b>
     * <ul>
     * <li>
     * {@code shooter} and {@code origin} must not be null, formally:
     * </li>
     * <li>
     * {@code shooter} != null
     * </li>
     * <li>
     * {@code origin} != null
     * </li>
     * </ul>
     * <b>Postconditions</b>
     * <ul>
     * <li>
     * An instance of a missile has been returned to the calling function.
     * </li>
     * </ul>
     * @param shooter instance of the entity that shoots the missile
     * @param origin Class of shooter
     * @return returns an instance of a missile, that is, an entity which is a missile.
     */

    public Entity createMissile(Entity shooter,Class<?> origin);
}
