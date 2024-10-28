package com.lex.practice.pdf.itext_demos.ver_5.img;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class BlockWithImg {
    public static void main(String[] args) throws IOException, DocumentException {
        putImageInCell();
//        alignmentOrSpace();
    }

    private static void putImageInCell() throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("java-sorted-collection/src/main/resources/test.pdf"));
        document.open();
        Image img1 = Image.getInstance("java-sorted-collection/src/main/resources/l.png");
        img1.scaleAbsolute(25, 25);
        img1.setAlignment(Image.ALIGN_MIDDLE);
        Image img2 = Image.getInstance("java-sorted-collection/src/main/resources/l.png");
        img2.scaleAbsolute(50, 50);
        img2.setAlignment(Image.ALIGN_MIDDLE);

        // Create a table with two columns
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100); // Set table width to 100%
        // Add text
        PdfPCell textCell1 = new PdfPCell(new Phrase("The first"));
        textCell1.setBorderColor(BaseColor.BLACK); // Set border color to black
        textCell1.setBorderWidth(1f); // Set border width
        textCell1.setPadding(5); // Optional: add some padding
        table.addCell(textCell1);

        // Add first image
        PdfPCell cell1 = new PdfPCell();
        cell1.addElement(img1);
        cell1.setBorderColor(BaseColor.BLACK); // Set border color to black
        cell1.setBorderWidth(1f); // Set border width
        cell1.setPadding(5); // Optional: add some padding//
        table.addCell(cell1);

        // Add second image
        PdfPCell cell2 = new PdfPCell();
        cell2.addElement(img2);
        cell2.setBorderColor(BaseColor.BLACK); // Set border color to black
        cell2.setBorderWidth(1f); // Set border width
        cell2.setPadding(5); // Optional: add some padding//
        table.addCell(cell2);

        // Add text
        table.addCell(new Phrase("the second"));

        // Add table to document
        document.add(table);
        document.close();
    }

    private static void alignment() throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("java-sorted-collection/src/main/resources/test.pdf"));
        document.open();

        // Font
        Font font = FontFactory.getFont(FontFactory.TIMES_BOLD);

        // Images
        Image img1 = Image.getInstance("java-sorted-collection/src/main/resources/l.png");
        img1.scaleAbsolute(25, 25);
        img1.setAlignment(Image.ALIGN_MIDDLE);

        Image img2 = Image.getInstance("java-sorted-collection/src/main/resources/l.png");
        img2.scaleAbsolute(50, 50);
        img2.setAlignment(Image.ALIGN_MIDDLE);

        Paragraph p = new Paragraph("The first ");
        p.add(img1);
        p.add(", the second ");
        p.add(img1);
        document.add(p);
        document.close();
    }
}
