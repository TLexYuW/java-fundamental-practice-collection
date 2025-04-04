package com.lex.practice.casual._1;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Image> initialImages = Arrays.asList(
                Image.builder().imgId(1).carId(100).url("http://example.com/img1.jpg").build(),
                Image.builder().imgId(2).carId(100).url("http://example.com/img2.jpg").build(),
                Image.builder().imgId(3).carId(100).url("http://example.com/img3.jpg").build(),
                Image.builder().imgId(4).carId(100).url("http://example.com/img4.jpg").build(),
                Image.builder().imgId(5).carId(100).url("http://example.com/img5.jpg").build()
        );

        int nextAvailableId = calculateNextAvailableId(initialImages);

        MockRepository imageRepository = new MockRepository(nextAvailableId);
        initialImages.forEach(imageRepository::addImage);

        System.out.println("Mock DB: " + imageRepository.findAllByCarId(100));

        System.out.println("\nTest Cases: ==================");
        Data data = createTestData();

        MockService imageService = new MockService(imageRepository);
        List<Image> processedImages = imageService.processCarImages(100, data);

        System.out.println("\nAfter Processed Mock DB: " + imageRepository.findAllByCarId(100));
        System.out.println("Response Processed Data: " + processedImages);
    }

    private static int calculateNextAvailableId(List<Image> images) {
        return images.stream()
                .mapToInt(Image::getImgId)
                .max()
                .orElse(0) + 1;
    }

    private static Data createTestData() {
        List<MockDto> imageModels = Arrays.asList(
                MockDto.builder().imgId(2).url("http://example.com/img2.jpg").build(),
                MockDto.builder().imgId(3).url("http://example.com/img3_updated.jpg").build(),
                MockDto.builder().imgId(null).url("http://example.com/new1.jpg").build(),
                MockDto.builder().imgId(null).url("http://example.com/new2.jpg").build()
        );
        return Data.builder().imageList(imageModels).build();
    }
}
