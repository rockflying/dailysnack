package com.snack.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentParser {
	private String content;
	
	private List<String> list = new ArrayList<String>();
	
	private List<Map<String, String>> urlList;
	
	public ContentParser(String str) {
		content = str;
	}
	
	public List<Map<String, String>> getUrlList() {
		parseContent();
		return urlList;
	}
	
	private void parseContent() {
		
	}
}
