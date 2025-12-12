package com.qinghaotech.application.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Jinx
 */
@Getter
@Setter
public abstract class BaseDto {
    /**
     * 唯一标识
     */
    private Integer id;
    /**
     * 创建时间
     */
    private LocalDateTime createAt;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 修改时间
     */
    private LocalDateTime modifyAt;
    /**
     * 修改人
     */
    private String modifyBy;
}
