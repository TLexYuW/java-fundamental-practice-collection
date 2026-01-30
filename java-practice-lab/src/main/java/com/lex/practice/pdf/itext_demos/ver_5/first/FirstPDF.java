package com.lex.practice.pdf.itext_demos.ver_5.first;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;

import java.io.FileNotFoundException;

public class FirstPDF {
    private static String FILE = "FirstPdf.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    public static void main(String[] args) throws FileNotFoundException {

    }

    private static void addMetaData(com.itextpdf.text.Document document) {
        document.addTitle("First PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Unknown");
        document.addCreator("Unknown");
    }
}
