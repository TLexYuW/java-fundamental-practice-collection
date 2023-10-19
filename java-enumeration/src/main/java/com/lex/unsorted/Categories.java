package com.lex.unsorted;

/**
 * @author : Lex Yu
 */
public enum Categories {
	MAIN_PAGE(1,"categories");
	private final Integer id;
	private final String slug;

	Categories(Integer id, String slug) {
		this.id = id;
		this.slug = slug;
	}

	public Integer getId() {
		return id;
	}

	public String getSlug() {
		return slug;
	}
}
