package com.lex.practice.casual._1;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MockService {

    private final MockRepository repository;

    public List<Image> processCarImages(Integer carId, Data data) {
        Set<Integer> retainIds = data.getImageList().stream()
                .map(MockDto::getImgId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        System.out.println("Retain IDs: " + retainIds);

        List<Image> imagesToDelete = repository.findAllByCarId(carId).stream()
                .filter(img -> !retainIds.contains(img.getImgId()))
                .collect(Collectors.toList());

        System.out.println("Need to delete: " + imagesToDelete);

        repository.deleteImages(imagesToDelete);

        List<Image> imagesToSave = data.getImageList().stream()
                .map(dto -> MockMapper.toImage(dto, carId))
                .collect(Collectors.toList());

        List<Image> savedImages = repository.saveAll(imagesToSave);
        System.out.println("Saved Ids: " + savedImages);

        return savedImages;
    }
}
