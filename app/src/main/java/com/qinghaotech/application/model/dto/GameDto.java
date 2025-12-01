package com.qinghaotech.application.model.dto;

import com.qinghaotech.domain.primitive.Status;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jinx
 */
@Getter
@Setter
public class GameDto {

    private Integer id;
    private String name;
    private String avatar;
    private Status status;
}
