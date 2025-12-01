package com.qinghaotech.application.model.dto;

import com.qinghaotech.domain.primitive.Status;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jinx
 */
@Getter
@Setter
public class WechatUserDto {

    private Integer id;

    private String nickname;

    private String avatar;

    private Status status;
}
