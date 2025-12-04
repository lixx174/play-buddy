package com.qinghaotech.domain.repository;

import com.qinghaotech.domain.exception.UnprocessableException;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Jinx
 */
public interface CurdRepository<ID, Entity> {

    /**
     * 通过id查询实体
     *
     * @param id 实体id
     * @return 实体
     */
    Optional<Entity> findById(ID id);

    /**
     * 保存实体
     *
     * @param entity 实体
     */
    void save(Entity entity);

    /**
     * 删除实体
     *
     * @param entity 实体
     */
    void remove(Entity entity);

    /**
     * 通过id查询实体。如果不存在会抛出{@link UnprocessableException}。
     *
     * @param id 实体id
     * @return 实体
     */
    default Entity findByIdOrElseThrow(ID id) {
        Optional<Entity> entity = findById(id);
        if (entity.isEmpty()) {
            throw new UnprocessableException("非法id: %s".formatted(id));
        }

        return entity.get();
    }

    /**
     * 通过id查询实体。如果不存在则执行一个回调。
     *
     * @param id     实体id
     * @param action 构建实体回调
     * @return 实体
     */
    default Entity findByIdOrElseThrow(ID id, Supplier<Entity> action) {
        Optional<Entity> entity = findById(id);
        return entity.orElseGet(action);
    }

    /**
     * 批量保存实体
     *
     * @param entities 实体数组
     */
    default void remove(Collection<Entity> entities) {
        for (Entity entity : entities) {
            remove(entity);
        }
    }
}
