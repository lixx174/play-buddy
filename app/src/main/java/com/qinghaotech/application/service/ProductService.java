package com.qinghaotech.application.service;

import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.dto.ProductDto;
import com.qinghaotech.application.model.dto.ProductPageDto;
import com.qinghaotech.application.repository.ProductQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Jinx
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductQueryRepository productQueryRepository;


    public PageReply<ProductPageDto> page(PageQuery query) {
        return PageReply.of(productQueryRepository.findAll(query));
    }


    public ProductDto detail(Integer id) {
        return productQueryRepository.findById(id);
    }
}
