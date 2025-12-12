package com.qinghaotech.domain.entity.role;

import com.qinghaotech.domain.entity.authority.Authority;
import com.qinghaotech.domain.primitive.Status;
import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Jinx
 */
@Getter
public class Role {

    private final Integer id;
    private String name;
    private String remark;
    private Status status;
    private Collection<Integer> authorityIds;

    public Role(String name, String remark, @NonNull Collection<Authority> authorities) {
        this(null, name, remark, Status.ENABLE, authorities);
    }

    public Role(Integer id, String name, String remark, Status status, @NonNull Collection<Authority> authorities) {
        Assert.hasText(name, "角色名称为空");
        Assert.hasText(remark, "角色备注为空");
        Assert.notNull(status, "角色状态为空");

        this.id = id;
        this.name = name;
        this.remark = remark;
        this.status = status;
        this.authorityIds = authorities.stream()
                .map(Authority::getId)
                .collect(Collectors.toSet());
    }

    /**
     * 修改角色信息
     *
     * @param name   角色名字
     * @param remark 角色备注
     */
    public void changeProfile(String name, String remark) {
        if (StringUtils.hasText(name)) {
            this.name = name;
        }
        if (StringUtils.hasText(remark)) {
            this.remark = remark;
        }
    }

    /**
     * 修改权限集
     *
     * @param authorities 权限实体集合
     */
    public void changeAuthorities(Collection<Authority> authorities) {
        this.authorityIds = authorities.stream()
                .map(Authority::getId)
                .collect(Collectors.toSet());
    }

    /**
     * 状态变更
     *
     * @param status 新状态
     */
    public void changeStatus(Status status) {
        if (status != null) {
            this.status = status;
        }
    }
}
