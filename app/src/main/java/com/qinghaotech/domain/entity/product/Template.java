package com.qinghaotech.domain.entity.product;

import com.qinghaotech.domain.primitive.Image;

import java.util.List;

/**
 * 商品模板，类似于SPU。
 *
 * @author Jinx
 */
public class Template {

    private Integer id;

    private Category category;

    private String name;

    private String description;

    private List<Image> images;
}
