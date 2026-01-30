package com.lex.practice.jsoup.others;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author : Lex Yu
 */
public class Main {
	public static void main(String[] args) {
		try {

			String url = "https://www.nmns.edu.tw/ch/exhibitions/special-exhibitions/Exhibition-000472/";

			Document doc = Jsoup.connect(url).get();

//			Elements metaNameTags = doc.select("meta[name=description]");
//			Elements metaPropTags = doc.select("meta[property=description]");
//
//			for (Element metaTag : metaNameTags) {
//				String name = metaTag.attr("name");
//				String content = metaTag.attr("content");
//				String og_image_url = metaTag.attr("og:image");
//				System.out.println("Name: " + name);
//				System.out.println("Content: " + content);
//				System.out.println("Image: " + og_image_url);
//			}

			Element ogImageMetaTag = doc.select("meta[property=og:image]").first();
			Element descriptionMetaTag = doc.select("meta[name=description]").first();

			if (ogImageMetaTag != null) {
				String ogImageContent = ogImageMetaTag.attr("content");
				System.out.println("og:image Content: " + ogImageContent);
			}

			if (descriptionMetaTag != null) {
				String descriptionContent = descriptionMetaTag.attr("content");
				System.out.println("Description Content: " + descriptionContent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}