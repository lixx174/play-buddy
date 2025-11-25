package com.qinghaotech.domain.entity.product;

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

    private Integer inventory;
}
