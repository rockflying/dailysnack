package com.snack.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.snack.common.SnackLink;


public class NetworkHelper implements Runnable{
	private final String baseUrl = "http://www.kekenet.com";
	
	private String url = "http://www.kekenet.com/read/";
	
	private final String[] subjects = {"时尚双语", "职场英语", "校园英语", "时事新闻"};
	
	private String subject = "kouyu_photo";
	
	private List<String> urlList = new ArrayList<String>();
	
	private List<String> titleList = new ArrayList<String>();
	
	public NetworkHelper(String target) {
		url = target;
	}
	
	public NetworkHelper() {
	}
	
	public List<String> getUrlList() {
		return urlList;
	}

	public List<String> getTitleList() {
		return titleList;
	}

	public void getContent() {
		try {
						
			Document doc = Jsoup.connect(url).get();

			Elements elements = doc.getElementsByClass(subject);

			for(Element element : elements) {
				Elements hrefs = element.select("a[href]");
				int dup = 0;
				for(Element href : hrefs) {
					if(dup == 1) {  //to skip duplicated links
						dup = 0;
						continue;
					}
					dup = 1;
					urlList.add(href.attr(baseUrl+"href"));
					titleList.add(href.attr("title"));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		getContent();
	}
	
	public Map<String, List<SnackLink>> getsubjectMap() {

		return null;
	}
}
