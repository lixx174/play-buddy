package com.qinghaotech.infra.tree;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Jinx
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TreeBuilder {

    /**
     * 构建树
     *
     * @param nodes 待构建为树的列表
     * @return tree
     */
    public <T extends Treeable<?>> Collection<T> build(Collection<T> nodes) {
        return build(nodes, Collections.emptySet());
    }


    /**
     * 构建树
     *
     * @param nodes      待构建为树的列表
     * @param checkedIds 已选中的id
     * @param <T>        构建类型
     * @return tree
     * @see Treeable
     */
    public <T extends Treeable<?>> Collection<T> build(Collection<T> nodes, Set<?> checkedIds) {
        if (nodes == null) {
            return null;
        }

        // 分组信息  key：父节点  value：该父节点的子节点
        var groups = nodes.stream()
                .collect(
                        Collectors.groupingBy(Treeable::getParentId)
                );

        // 从根节点（父节点为null的节点即根节点）开始重构
        Collection<T> roots = groups.get(null);
        if (roots == null) {
            roots = Collections.emptyList();
        } else {
            roots.forEach(root -> build(root, groups, checkedIds));
        }

        return roots;
    }


    private <T extends Treeable<?>> void build(T node, Map<?, List<T>> groups, Set<?> checkedIds) {
        if (checkedIds.contains(node.getId())) {
            node.onChecked();
        }

        Collection<T> children = groups.get(node.getId());
        if (children == null) {
            children = Collections.emptyList();
        }

        for (T child : children) {
            node.onChild(child);
            build(child, groups, checkedIds);
        }
    }

    public static TreeBuilder builder() {
        return new TreeBuilder();
    }
}
