package com.qinghaotech.domain.entity.product;

import com.qinghaotech.domain.exception.UnprocessableException;
import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * 商品变体 - 相对于 {@link Template} 它是更具体的原子商品，类似于SKU。
 *
 * @author Jinx
 */
public class Variant {

    private Integer id;

    private Template template;

    private BigDecimal price;

    private VariantInventory inventory;

    /**
     * 判断库存是否足够
     *
     * @param count 购买数量
     */
    public void assertInventoryEnough(int count) {
        if (!inventory.isEnough(count)) {
            String productName = template.getName();
            throw new UnprocessableException(
                    "Variant[%s] 库存不足: 剩余[%s] 当前[%s]".formatted(productName, inventory, count)
            );
        }
    }

    public void deductInventory(int count) {
        Assert.isTrue(count > 0, "扣减数量不能为负");
        assertInventoryEnough(count);

        int remain = inventory.value() - count;
        inventory = new VariantInventory(remain);
    }
}
