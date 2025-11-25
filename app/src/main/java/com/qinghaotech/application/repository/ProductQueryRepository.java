package com.qinghaotech.application.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.dto.ProductDto;
import com.qinghaotech.application.model.dto.ProductPageDto;

/**
 * @author jinx
 */
public interface ProductQueryRepository {

    Page<ProductPageDto> findAll(PageQuery query);

    ProductDto findById(Integer id);
}
