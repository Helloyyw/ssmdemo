package com.ziro.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class WeiXiuEntity {
    private Long id;
    private String name;
    private String type;
    private String yuanyin;
    private String cuoshi;
    private String houguo;
}
