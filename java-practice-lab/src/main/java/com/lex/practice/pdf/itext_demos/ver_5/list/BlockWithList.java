package com.lex.practice.pdf.itext_demos.ver_5.list;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BlockWithList {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("java-sorted-collection/src/main/resources/test.pdf"));
        document.open();

        Font font = FontFactory.getFont(FontFactory.TIMES_BOLD);
        document.add(new Paragraph("iText is:", font));

        List list = new List();
        list.setListSymbol(new Chunk("•", font));
        list.add("Never gonna give you up");
        list.add("Never gonna let you down");
        list.add("Never gonna run around and desert you");
        list.add("Never gonna make you cry");
        list.add("Never gonna say goodbye");
        list.add("Never gonna tell a lie and hurt you");
        document.add(list);

        document.close();
    }
}
