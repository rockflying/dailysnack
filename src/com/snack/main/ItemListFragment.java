package com.snack.main;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ItemListFragment extends ListFragment{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_activated_1,
				android.R.id.text1, new String[] {"123", "456", "789"}));
	}
}
