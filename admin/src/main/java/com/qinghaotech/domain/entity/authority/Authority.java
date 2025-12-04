package com.qinghaotech.domain.entity.authority;

import com.qinghaotech.domain.Entity;
import com.qinghaotech.domain.exception.UnprocessableException;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.function.Predicate;

/**
 * @author Jinx
 */
@Getter
public class Authority implements Entity {

    private final Integer id;
    private Integer parentId;
    private String name;
    private AuthorityResource resource;
    private String permission;
    private Integer sortNo;

    @Builder
    public Authority(Integer id, Integer parentId, String name, String type, String path, String permission, Integer sortNo) {
        Assert.hasText(name, "权限名称为空");
        Assert.hasText(permission, "权限标识为空");
        Assert.notNull(sortNo, "权限排序号为空");

        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.resource = new AuthorityResource(type, path);
        this.permission = permission;
        this.sortNo = sortNo;
    }

    /**
     * 更名
     *
     * @param name   新权限名称
     * @param action 断言回调，判断该权限名称是否存在。
     */
    public void rename(String name, Predicate<String> action) {
        if (StringUtils.hasText(name)) {
            if (action.test(name)) {
                throw new UnprocessableException("权限名称:%s 已存在".formatted(name));
            }

            this.name = name;
        }
    }

    public void changeResource(AuthorityResource resource) {
        if (resource != null) {
            this.resource = resource;
        }
    }

    /**
     * 修改权限标识
     *
     * @param permission 新权限标识
     * @param action     断言回调，判断该权限标识是否存在。
     */
    public void changePermission(String permission, Predicate<String> action) {
        if (StringUtils.hasText(permission)) {
            if (action.test(permission)) {
                throw new UnprocessableException("权限标识:%s 已存在".formatted(permission));
            }

            this.permission = permission;
        }
    }

    public void reorder(Integer sortNo) {
        if (sortNo != null) {
            this.sortNo = sortNo;
        }
    }

    /**
     * 重新指定父权限
     *
     * @param pid    父权限id
     * @param action 断言回调，判断该权限id是否存在。
     */
    public void reassignParent(Integer pid, Predicate<Integer> action) {
        if (pid != null) {
            Assert.isTrue(!pid.equals(id), "父权限:%s 不能指定自己".formatted(pid));

            if (action.test(pid)) {
                throw new UnprocessableException("父权限:%s 已存在".formatted(pid));
            }
        }

        this.parentId = pid;
    }
}
