package com.lex.oop_refresh.coupling.loose_coupling.eg2;

import com.lex.oop_refresh.coupling.tight_coupling.eg2.CSVExport;
import com.lex.oop_refresh.coupling.tight_coupling.eg2.JSONFetch;
import com.lex.oop_refresh.coupling.tight_coupling.eg2.PDFExport;
import com.lex.oop_refresh.coupling.tight_coupling.eg2.XMLFetch;

import java.util.List;

/**
 * @author : Lex Yu
 * @date : 2023/9/5
 */
public class MetadataCollector {

	private FetchMetadata fetchMetadata;
	private ExportMetadata exportMetadata;

	public MetadataCollector(FetchMetadata fetchMetadata, ExportMetadata exportMetadata) {
		this.fetchMetadata = fetchMetadata;
		this.exportMetadata = exportMetadata;
	}

	public void collectMetadata(){
		List<Object> metadata = fetchMetadata.fetchMetadata();
		exportMetadata.export(metadata);
	}

	public FetchMetadata getFetchMetadata() {
		return fetchMetadata;
	}

	public void setFetchMetadata(FetchMetadata fetchMetadata) {
		this.fetchMetadata = fetchMetadata;
	}

	public ExportMetadata getExportMetadata() {
		return exportMetadata;
	}

	public void setExportMetadata(ExportMetadata exportMetadata) {
		this.exportMetadata = exportMetadata;
	}
}
