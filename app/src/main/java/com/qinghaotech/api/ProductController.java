package com.qinghaotech.api;

import com.qinghaotech.application.Result;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.dto.ProductDto;
import com.qinghaotech.application.model.dto.ProductPageDto;
import com.qinghaotech.application.model.query.ProductPageQuery;
import com.qinghaotech.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品 API
 *
 * @author Jinx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;


    /**
     * 商品分页
     *
     * @return 陪玩师简介分页
     */
    @GetMapping("/page")
    public Result<PageReply<ProductPageDto>> page(ProductPageQuery query) {
        return Result.succeed(service.page(query));
    }

    /**
     * 商品详情
     *
     * @param id 商品唯一标识
     * @return 陪玩师详情
     */
    @PutMapping("/detail")
    public Result<ProductDto> detail(Integer id) {
        return Result.succeed(service.detail(id));
    }
}
