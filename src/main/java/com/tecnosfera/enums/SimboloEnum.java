package com.tecnosfera.enums;

public enum SimboloEnum {

    X("X"),
    O("O"),
    EMPTY(" ");

    private final String simbolo;

    SimboloEnum(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return simbolo;
    }
}

