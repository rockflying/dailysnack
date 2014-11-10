package com.snack.main.content;

import java.util.ArrayList;
import java.util.List;

import com.snack.main.R;


/**
 * @author Administrator
 *
 */
public class SnackSubjectList {
	public static  List<SnackItem> ITEMS = new ArrayList<SnackItem>();
	
	static {
		addItem(new SnackItem(1, R.string.recommand));
		addItem(new SnackItem(2, R.string.campus));
		addItem(new SnackItem(3, R.string.fashion));
		addItem(new SnackItem(3, R.string.news));
		addItem(new SnackItem(3, R.string.office));
	}
	
	/**
	 * add item to list
	 * @param item
	 */
	public static void addItem(SnackItem item) {
		ITEMS.add(item);
	}
	
	/**
	 * An item representing a piece of content.
	 */
	public static class SnackItem {
		public int id;
		public int content;

		public SnackItem(int id, int content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content + "";
		}
	}
}
