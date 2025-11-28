package com.qinghaotech.domain.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

/**
 * @author Jinx
 */
public interface CurdRepository<Entity> {

    Optional<Entity> findById(Integer id);

    void save(Entity entity);

    default Entity findByIdSafely(Integer id) {
        Optional<Entity> entity = findById(id);
        if (entity.isEmpty()) {
            throw new IllegalArgumentException("%s not existed: %s".formatted(getEntityName(), id));
        }

        return entity.get();
    }

    @SuppressWarnings("unchecked")
    private String getEntityName() {
        try {
            for (Type type : getClass().getGenericInterfaces()) {
                if (type instanceof ParameterizedType pt) {
                    if (pt.getRawType() instanceof Class<?> raw && CurdRepository.class.isAssignableFrom(raw)) {
                        Type actualType = pt.getActualTypeArguments()[0];
                        if (actualType instanceof Class<?> clazz) {
                            Class<Entity> entityClass = (Class<Entity>) clazz;
                            return entityClass.getSimpleName();
                        }
                    }
                }
            }
        } catch (Exception ignore) {

        }

        return getClass().getSimpleName();
    }
}
