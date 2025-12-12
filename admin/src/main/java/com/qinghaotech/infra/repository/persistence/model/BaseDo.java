package com.qinghaotech.infra.repository.persistence.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Jinx
 */
@Getter
@Setter
public abstract class BaseDo {
    private Integer id;
    private LocalDateTime createAt;
    private String createBy;
    private LocalDateTime modifyAt;
    private String modifyBy;
    private boolean deleted;
}
