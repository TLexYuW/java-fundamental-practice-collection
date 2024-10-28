package com.lex.practice.pdf.itext_demos.ver_5;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Block {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("java-sorted-collection/src/main/resources/test.pdf"));
        document.open();
        document.add(new Paragraph("Hello World"));
        document.close();
    }
}
