package com.sy.fanout.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum ExchangeEnum {

    DIRECT(1,"direct"),
    TOPIC(2,"topic"),
    FANOUT(3,"fanout"),
    HEADERS(4,"headers"),
    SYSTEM(5,"system"),
    ;
    private final Integer code;

    private final String des;

}
