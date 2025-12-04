package com.qinghaotech.application.model.dto;

import com.qinghaotech.domain.primitive.Gender;
import com.qinghaotech.domain.primitive.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 陪玩师
 *
 * @author Jinx
 */
@Getter
@Setter
public class CompanionDto {
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 性别
     */
    private Gender gender;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 状态
     */
    private Status status;
    private Float starLevel;
    private List<String> tags;
    private List<GameDto> games;
}
