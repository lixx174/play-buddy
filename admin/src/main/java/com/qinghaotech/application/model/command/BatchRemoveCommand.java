package com.qinghaotech.application.model.command;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author Jinx
 */
@Getter
@Setter
public class BatchRemoveCommand {

    private Set<Integer> ids;
}
