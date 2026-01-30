//package com.lex.practice.pdf.itext_demos.upper_7.block.img;
//
//
//import com.itextpdf.io.font.constants.StandardFonts;
//import com.itextpdf.io.image.ImageDataFactory;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Image;
//import com.itextpdf.layout.element.Paragraph;
//
//import java.io.IOException;
//
//public class BlockWithList {
//    public static void main(String[] args) throws IOException {
//        PdfWriter writer = new PdfWriter("java-sorted-collection/src/main/resources/test.pdf");
//        PdfDocument pdf = new PdfDocument(writer);
//        // font
//        PdfFont font = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD, "UTF-8");
//        try (Document document = new Document(pdf)) {
//            Image img1 = new Image(ImageDataFactory.create("java-sorted-collection/src/main/resources/l.png"));
//            img1.setHeight(25);
//            img1.setWidth(25);
//            Image img2 = new Image(ImageDataFactory.create("java-sorted-collection/src/main/resources/l.png"));
//            img2.setHeight(50);
//            img2.setWidth(50);
//            Paragraph p = new Paragraph("The first")
//                    .add(img1)
//                    .add(", the second ")
//                    .add(img1);
//            document.add(p);
//        }
//    }
//}
