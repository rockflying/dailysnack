package com.snack.main.content;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class DetailContent {
	public List<DetailItem> ITEMS = new ArrayList<DetailItem>();
	
	/**
	 * An item representing a piece of content.
	 */
	public static class DetailItem {
		public String id;
		public String content;

		public DetailItem(String id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}
