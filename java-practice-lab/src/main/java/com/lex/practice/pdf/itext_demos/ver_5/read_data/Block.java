package com.lex.practice.pdf.itext_demos.ver_5.read_data;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Block {
    public static void main(String[] args) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("java-sorted-collection/src/main/resources/united_states.pdf"));
        document.open();
        document.setMargins(20, 20, 20, 20);

        PdfPTable table = new PdfPTable(new float[]{4, 1, 3, 4, 3, 3, 3, 3, 1});
        table.setWidthPercentage(100);

        Font boldFont = FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE);
        Font normalFont = FontFactory.getFont(FontFactory.COURIER);

        BufferedReader br = new BufferedReader(new FileReader("java-sorted-collection/src/main/resources/united_states.csv"));
        String line = br.readLine();
        process(table, line, boldFont, true);
        while ((line = br.readLine()) != null) {
            process(table, line, normalFont, false);
        }
        document.add(table);
        document.close();
    }

    public static void process(PdfPTable table, String line, Font font, boolean isHeader) {
        StringTokenizer tokenizer = new StringTokenizer(line, ";");
        while (tokenizer.hasMoreTokens()) {
            table.addCell(new PdfPCell(new Phrase(tokenizer.nextToken(), font)));
        }
    }
}
