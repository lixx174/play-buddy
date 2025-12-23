package com.qinghaotech.application.model.dto;

import com.qinghaotech.infra.tree.Treeable;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @author Jinx
 */
@Getter
@Setter
public class AuthorityTreeDto implements Treeable<Integer> {

    /**
     * 权限id
     */
    private Integer id;
    /**
     * 父权限id
     */
    private Integer parentId;
    /**
     * 权限名字
     */
    private String name;
    /**
     * 是否选中 true：已选中
     */
    private boolean checked;
    /**
     * 子权限
     */
    private Collection<AuthorityTreeDto> children;

    @Override
    public void onChild(Treeable<?> child) {
        children.add((AuthorityTreeDto) child);
    }

    @Override
    public void onChecked() {
        checked = true;
    }
}
