package com.qinghaotech.application.model.dto;

import com.qinghaotech.domain.entity.companion.CompanionLevel;
import com.qinghaotech.domain.entity.companion.CompanionPrice;
import com.qinghaotech.domain.entity.companion.CompanionTag;
import com.qinghaotech.domain.primitive.Game;
import com.qinghaotech.domain.primitive.Status;

import java.util.List;

/**
 * @author Jinx
 */
public class CompanionDto {
    private Integer id;

    private Status status;
    private CompanionLevel level;
    private CompanionPrice price;
    private List<CompanionTag> tags;
    private List<Game> games;
}
