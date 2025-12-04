package com.qinghaotech.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Repo findById 时未查询到实体时异常。
 *
 * @author Jinx
 */
@Getter
public class IdNotFoundException extends RuntimeException {

    private final int code = HttpStatus.UNPROCESSABLE_ENTITY.value();

    public IdNotFoundException(Object id) {
        super("非法id: %s".formatted(id));
    }
}
