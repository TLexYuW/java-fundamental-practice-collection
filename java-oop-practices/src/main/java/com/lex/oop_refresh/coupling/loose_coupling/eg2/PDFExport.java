package com.lex.oop_refresh.coupling.loose_coupling.eg2;

import java.io.File;
import java.util.List;

/**
 * @author : Lex Yu
 * @date : 2023/9/5
 */
public class PDFExport implements ExportMetadata {
	@Override
	public File export(List<Object> metadata) {
		System.out.println("Exporting data to PDF...");
		File outputPDF = null;
		return outputPDF;
	}
}
