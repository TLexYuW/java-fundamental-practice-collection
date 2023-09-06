package com.lex.oop_refresh.coupling.loose_coupling.eg2;

/**
 * @author : Lex Yu
 * @date : 2023/9/6
 */
public class Main {
	public static void main(String[] args) {
		MetadataCollector mc1 = new MetadataCollector(new XMLFetch(), new PDFExport());
		mc1.collectMetadata();
		MetadataCollector mc2 = new MetadataCollector(new XMLFetch(), new CSVExport());
		mc2.collectMetadata();
		MetadataCollector mc3 = new MetadataCollector(new JSONFetch(), new PDFExport());
		mc3.collectMetadata();
		MetadataCollector mc4 = new MetadataCollector(new JSONFetch(), new CSVExport());
		mc4.collectMetadata();
	}
}
