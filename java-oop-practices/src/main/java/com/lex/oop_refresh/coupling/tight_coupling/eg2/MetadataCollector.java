package com.lex.oop_refresh.coupling.tight_coupling.eg2;

import java.util.List;

/**
 * @author : Lex Yu
 * @date : 2023/9/5
 */
public class MetadataCollector {
	private XMLFetch xmlFetch = new XMLFetch();
	private JSONFetch jsonFetch = new JSONFetch();
	private CSVExport csvExport = new CSVExport();
	private PDFExport pdfExport = new PDFExport();
	;
	public void collectMetadata() {
		System.out.println("Collect data from xml, then export to csv...");
		List<Object> metadata = xmlFetch.fetchMetadata();
		csvExport.export(metadata);
	}

	public void collectMetadata(int inputType, int outputType) {
		if (outputType == 1) {
			List<Object> metadata = null;
			if (inputType == 1) {
				metadata = xmlFetch.fetchMetadata();
			} else {
				metadata = jsonFetch.fetchMetadata();
			}
			csvExport.export(metadata);
		} else {
			List<Object> metadata = null;
			if (inputType == 1) {
				metadata = xmlFetch.fetchMetadata();
			} else {
				metadata = jsonFetch.fetchMetadata();
			}
			pdfExport.export(metadata);
		}
	}
}
