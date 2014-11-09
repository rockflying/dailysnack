package com.snack.main;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.snack.main.content.SnackThemeList;

public class ItemListFragment extends ListFragment{
	
	public static final String ARG_ITEM_ID = "item_id";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_activated_1,
				android.R.id.text1, new String[] {"123", "456", "789"}));
		setupItemList();
	}
	
	private void setupItemList() {
		Activity activity = getActivity();
		
		Bundle bundle = activity.getIntent().getExtras();
		int id = bundle.getInt(ARG_ITEM_ID);
		
		String title = getResources().getString(SnackThemeList.ITEMS.get(id-1).content);
		activity.setTitle(title);
		Toast.makeText(activity,
				title,
				Toast.LENGTH_SHORT).show();
	}
}
