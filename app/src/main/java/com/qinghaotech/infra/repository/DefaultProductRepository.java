package com.qinghaotech.infra.repository;

import com.qinghaotech.domain.entity.product.Variant;
import com.qinghaotech.domain.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Jinx
 */
@Component
public class DefaultProductRepository implements ProductRepository {
    @Override
    public Optional<Variant> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public void save(Variant variant) {

    }

    @Override
    public void remove(Variant variant) {

    }
}
