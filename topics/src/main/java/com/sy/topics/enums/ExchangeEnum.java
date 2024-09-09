package com.sy.topics.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExchangeEnum {

    DIRECT(1,"exchnage-direct"),
    TOPIC(2,"topic"),
    FANOUT(3,"fanout"),
    HEADERS(4,"headers"),
    SYSTEM(5,"system"),
    ;
    private final Integer code;

    private final String name;

}
