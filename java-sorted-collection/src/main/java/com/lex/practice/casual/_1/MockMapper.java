package com.lex.practice.casual._1;

public class MockMapper {

    public static Image toImage(MockDto mockDto, Integer carId) {
        return Image.builder()
                .imgId(mockDto.getImgId())
                .carId(carId)
                .url(mockDto.getUrl())
                .build();
    }

}
