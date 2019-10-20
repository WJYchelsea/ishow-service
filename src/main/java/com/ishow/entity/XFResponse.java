package com.ishow.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhaohaojie
 * @date 2019-10-20 15:04
 */
@Getter
@Setter
public class XFResponse {
    private String code;
    private Data data;
    private String desc;
    private String sid;
}