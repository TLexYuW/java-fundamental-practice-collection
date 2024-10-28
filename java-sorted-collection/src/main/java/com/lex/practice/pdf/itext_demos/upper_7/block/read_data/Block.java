//package com.lex.practice.pdf.itext_demos.upper_7.block.read_data;
//
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.pdf.PdfDocument;
//import com.itextpdf.text.pdf.PdfWriter;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.StringTokenizer;
//
//public class Block {
//    public static void main(String[] args) throws IOException {
//        PdfWriter writer = new PdfWriter("java-sorted-collection/src/main/resources/united_states.pdf");
//        PdfDocument pdf = new PdfDocument(writer);
//        try (Document document = new Document(pdf, PageSize.A4.rotate())) {
//            document.setMargins(20, 20, 20, 20);
//            PdfFont font = PdfFontFactory.createFont(StandardFonts.COURIER_BOLDOBLIQUE);
//            PdfFont bold = PdfFontFactory.createFont(StandardFonts.COURIER_BOLDOBLIQUE);
//            Table table = new Table(new float[]{4, 1, 3, 4, 3, 3, 3, 3, 1});
//            table.setWidth(UnitValue.createPercentValue(100));
//            BufferedReader br = new BufferedReader(new FileReader("java-sorted-collection/src/main/resources/united_states.csv"));
//            String line = br.readLine();
//            process(table, line, bold, true);
//            while ((line = br.readLine()) != null) {
//                process(table, line, font, false);
//            }
//            document.add(table);
//        }
//    }
//
//    public static void process(Table table, String line, PdfFont font, boolean isHeader) {
//        StringTokenizer tokenizer = new StringTokenizer(line, ";");
//        while (tokenizer.hasMoreTokens()) {
//            if (isHeader) {
//                table.addHeaderCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
//            } else {
//                table.addCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
//            }
//        }
//    }
//}
