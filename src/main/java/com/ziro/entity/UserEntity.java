package com.ziro.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserEntity {
    private int id;
    private String name;
    private String pwd;
    private int acl;
}
