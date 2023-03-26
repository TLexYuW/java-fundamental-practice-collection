package com.lex.practice.io.ch.raf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author : LEX_YU
 * @date : 26/03/2023
 */
public class Raf {
    public static void main(String[] args) throws IOException {
        // read=r,readwrite=rw,rws,rwd
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("input.txt"), "rw");
        System.out.println("before read offset: " + randomAccessFile.getFilePointer() +
                ", current read char " + (char) randomAccessFile.read() +
                ", after read offset: " + randomAccessFile.getFilePointer());

        randomAccessFile.seek(6);
        System.out.println("before read offset: " + randomAccessFile.getFilePointer() +
                ", current read char " + (char) randomAccessFile.read() +
                ", after read offset: " + randomAccessFile.getFilePointer());

        byte[] arr = new byte[]{'H', 'I', 'J', 'K'};
        randomAccessFile.write(arr);

        randomAccessFile.seek(0);
        System.out.println("before read offset: " + randomAccessFile.getFilePointer() +
                ", current read char " + (char) randomAccessFile.read() +
                ", after read offset: " + randomAccessFile.getFilePointer());
    }
}
