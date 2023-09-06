package com.lex.oop_refresh.coupling.loose_coupling.eg2;

import java.io.File;
import java.util.List;

/**
 * @author : Lex Yu
 * @date : 2023/9/6
 */
public interface ExportMetadata {
	File export(List<Object> metadata);

}
