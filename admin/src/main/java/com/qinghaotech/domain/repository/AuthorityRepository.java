package com.qinghaotech.domain.repository;

import com.qinghaotech.domain.entity.authority.Authority;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * @author Jinx
 */
public interface AuthorityRepository extends CurdRepository<Integer, Authority> {

    Optional<Authority> findByName(String name);

    Optional<Authority> findByPermission(String permission);

    /**
     * 根据父唯一标识 获取其子节点
     *
     * @param pid 父唯一标识
     * @return 子节点实体
     */
    Collection<Authority> findByPid(Integer pid);

    Collection<Authority> findByIds(Set<Integer> ids);

    /**
     * 权限名字是否存在
     *
     * @param name 权限名称
     * @return true：存在
     */
    default boolean isNameExisted(String name) {
        return findByName(name).isPresent();
    }

    /**
     * 权限标识是否存在
     *
     * @param permission 权限标识
     * @return true：存在
     */
    default boolean isPermissionExisted(String permission) {
        return findByPermission(permission).isPresent();
    }

    /**
     * 实体是否存在
     *
     * @param id 实体唯一标识
     * @return true：存在
     */
    default boolean isExisted(Integer id) {
        return findById(id).isPresent();
    }
}
