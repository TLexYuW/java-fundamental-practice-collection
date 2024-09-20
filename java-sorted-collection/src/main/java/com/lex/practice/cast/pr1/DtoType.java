package com.lex.practice.cast.pr1;

public enum DtoType {
    ONE(OneDTO.class),
    TWO(TwoDTO.class);

    private final Class<? extends BaseDTO> dtoClass;

    DtoType(Class<? extends BaseDTO> dtoClass) {
        this.dtoClass = dtoClass;
    }

    public Class<? extends BaseDTO> getDtoClass() {
        return dtoClass;
    }
}
