package com.alura.challenge.enumeration;

import lombok.Getter;

@Getter
public enum EGeneralProperties{
    DEFAULT_FORMAT_DATE("yyyy-MM-dd");

    private final String value;

    EGeneralProperties( String value ){
        this.value = value;
    }

}
