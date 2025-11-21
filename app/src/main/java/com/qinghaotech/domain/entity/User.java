package com.qinghaotech.domain.entity;


import com.qinghaotech.domain.primitive.Status;
import lombok.Getter;

/**
 * @author Jinx
 */
@Getter
public class User implements Entity {

    private Integer id;

    private String name;

    private Status status;

    private Account account;
    private Credential credential;
}
