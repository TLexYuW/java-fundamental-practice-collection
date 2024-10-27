package com.lex.practice.pdf.itext_demos.block;


import java.io.File;
import java.io.FileNotFoundException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class Block {
    public static void main(String[] args) throws FileNotFoundException {
        PdfWriter writer = new PdfWriter("java-sorted-collection/src/main/resources/test.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        try (Document document = new Document(pdf)) {
            document.add(new Paragraph("Hello World"));
        }
    }
}
