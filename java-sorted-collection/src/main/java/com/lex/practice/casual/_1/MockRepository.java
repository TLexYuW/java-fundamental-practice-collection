package com.lex.practice.casual._1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MockRepository {

    private final List<Image> images = new ArrayList<>();
    private final AtomicInteger idGenerator;

    public MockRepository(int initialIdValue) {
        this.idGenerator = new AtomicInteger(initialIdValue);
    }

    public MockRepository() {
        this(1);
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public List<Image> findAllByCarId(Integer carId) {
        return images.stream()
                .filter(img -> img.getCarId().equals(carId))
                .collect(Collectors.toList());
    }

    public void deleteImages(List<Image> imagesToDelete) {
        images.removeAll(imagesToDelete);
    }

    public List<Image> saveAll(List<Image> imagesToSave) {
        Set<Integer> existingIds = images.stream()
                .map(Image::getImgId)
                .collect(Collectors.toSet());

        List<Image> result = new ArrayList<>();

        for (Image img : imagesToSave) {
            if (img.getImgId() == null) {
                Image newImage = Image.builder()
                        .imgId(idGenerator.getAndIncrement())
                        .carId(img.getCarId())
                        .url(img.getUrl())
                        .build();
                images.add(newImage);
                result.add(newImage);
            } else {
                if (existingIds.contains(img.getImgId())) {
                    images.removeIf(existingImg ->
                            existingImg.getImgId() != null &&
                                    existingImg.getImgId().equals(img.getImgId())
                    );
                }
                images.add(img);
                result.add(img);
            }
        }

        return result;
    }
}
