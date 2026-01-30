//package com.lex.practice.pdf.itext_demos.upper_7.block.list;
//
//
//import com.itextpdf.io.font.constants.StandardFonts;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.List;
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
//            document.add(new Paragraph("iText is:").setFont(font));
//            List list = new List().setSymbolIndent(12).setListSymbol("•");
//            list.add("Never gonna give you up")
//                    .add("Never gonna let you down")
//                    .add("Never gonna run around and desert you")
//                    .add("Never gonna make you cry")
//                    .add("Never gonna say goodbye")
//                    .add("Never gonna tell a lie and hurt you");
//            document.add(list);
//        }
//    }
//}
