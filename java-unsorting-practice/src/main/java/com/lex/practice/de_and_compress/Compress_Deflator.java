package com.lex.practice.de_and_compress;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;

/**
 * @author : Lex Yu
 * @date : 2023/6/28
 */
public class Compress_Deflator {
	public static void main(String[] args) {
		try(DeflaterOutputStream dos =
				    new DeflaterOutputStream(new FileOutputStream("compressed_output.txt"))) {
			dos.write("This is some data to compress.".getBytes());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
