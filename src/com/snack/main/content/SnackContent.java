package com.snack.main.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public class SnackContent {
	private List<SnackItem> ITEMS = new ArrayList<SnackItem>();
	
	private Map<String, SnackItem> ITEM_MAP = new HashMap<String, SnackItem>();
	
	
	/**
	 * add item to list and map
	 * @param item
	 */
	public void addItem(SnackItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}
	
	/**
	 * An item representing a piece of content.
	 */
	public static class SnackItem {
		public String id;
		public String content;

		public SnackItem(String id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}
