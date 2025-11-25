package com.qinghaotech.infra.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.dto.ProductDto;
import com.qinghaotech.application.model.dto.ProductPageDto;
import com.qinghaotech.application.repository.ProductQueryRepository;
import org.springframework.stereotype.Component;

/**
 * @author Jinx
 */
@Component
public class DefaultProductQueryRepository implements ProductQueryRepository {
    @Override
    public Page<ProductPageDto> findAll(PageQuery query) {
        return null;
    }

    @Override
    public ProductDto findById(Integer id) {
        return null;
    }
}
