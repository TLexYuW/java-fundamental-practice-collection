package bisbos;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author : LEX_YU
 * @date : 26/03/2023
 */
public class TestBisBos {

    // create fake pdf
    // truncate -s [your_size] fakefile.pdf
    @Test
    void copy_file_to_another_pdf_buffer_stream() {
//        long start = System.nanoTime();
        long start = System.currentTimeMillis();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("fakefile.pdf"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("fakefile-copy.pdf"))) {
            int content;
            while ((content= bis.read()) != -1) {
                bos.write(content);
            }
        } catch (Exception ex) {
            System.out.println("err");
        }

        //        long end = System.nanoTime();
        long end = System.currentTimeMillis();
        long executionTime = end - start;

        System.out.println("Execution time: " + executionTime/1000 + " seconds");
//        System.out.println("Execution time: " + executionTime + " nanoseconds");
    }

    @Test
    void copy_file_to_another_pdf_stream() {
        long start = System.currentTimeMillis();
//        long start = System.nanoTime();

        try (FileInputStream fis = new FileInputStream("fakefile.pdf");
             FileOutputStream fos = new FileOutputStream("fakefile-copy.pdf")) {
            int content;
            while ((content= fis.read()) != -1) {
                fos.write(content);
            }
        } catch (Exception ex) {
            System.out.println("err");
        }
        long end = System.currentTimeMillis();
//        long end = System.nanoTime();

        long executionTime = end - start;
        System.out.println("Execution time: " + executionTime/1000 + " seconds");
//        System.out.println("Execution time: " + executionTime + " nanoseconds");
    }

}
