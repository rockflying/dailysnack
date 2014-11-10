package com.snack.main;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.snack.common.Callbacks;
import com.snack.main.content.SnackSubjectList;

public class ItemListFragment extends ListFragment{
	
	public static final String ARG_ITEM_ID = "item_id";
	
	private Callbacks mCallbacks = sDummyCallbacks;
	
	private static Callbacks sDummyCallbacks = new Callbacks() {
		@Override
		public void onItemSelected(int id) {
		}
	};
	
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
		
		String title = getResources().getString(SnackSubjectList.ITEMS.get(id-1).content);
		activity.setTitle(title);
//		Toast.makeText(activity,
//				title,
//				Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		// Activities containing this fragment must implement its callbacks.
		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException(
					"Activity must implement Callbacks.");
		}

		mCallbacks  = (Callbacks) activity;
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		mCallbacks = sDummyCallbacks;
	}
	
	@Override
	public void onListItemClick(ListView listView, View view, int position,
			long id) {
		super.onListItemClick(listView, view, position, id);

		mCallbacks.onItemSelected(SnackSubjectList.ITEMS.get(position).id);
	}
}
