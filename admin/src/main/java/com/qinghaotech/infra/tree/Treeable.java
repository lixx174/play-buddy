package com.qinghaotech.infra.tree;


/**
 * 实现该接口的模型可以被重构为树
 *
 * @param <ID> 模型唯一标识类型
 * @author Jinx
 */
public interface Treeable<ID> {

    /**
     * 当前节点标记
     *
     * @return 节点唯一标识
     */
    ID getId();

    /**
     * 获取父节点标记
     *
     * @return 父节点标记
     */
    ID getParentId();

    /**
     * 当遍历到子节点时
     * <p>
     * 构建树时遍历到子节点时触发
     *
     * @param child 当前节点的子节点
     */
    void onChild(Treeable<?> child);

    /**
     * 当前节点被选中时
     * <p>
     * 构建树时遍历到该节点被选中时触发
     */
    void onChecked();
}
