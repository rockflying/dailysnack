package com.snack.main;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.snack.common.Callbacks;
import com.snack.common.SnackLink;

/**
 * Main list activity representing a list of subject items.
 */
public class MainListActivity extends Activity implements Callbacks {

	private Map<String, List<SnackLink>> subjectMap = new HashMap<String, List<SnackLink>>();
		
	private Date wgetime = null;  //download time
	
	private final long MiSEC = 43200000;  //1000*60*60*24/2  half day
	/**
	 * Whether or not the activity is in two-pane mode, i.e. running on a tablet
	 * device.
	 */
	private boolean mTwoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_list);

//		if (findViewById(R.id.item_detail_container) != null) {
//			// The detail container view will be present only in the
//			// large-screen layouts (res/values-large and
//			// res/values-sw600dp). If this view is present, then the
//			// activity should be in two-pane mode.
//			mTwoPane = true;
//
//			// In two-pane mode, list items should be given the
//			// 'activated' state when touched.
//			((ItemListFragment) getSupportFragmentManager().findFragmentById(
//					R.id.item_list)).setActivateOnItemClick(true);
//		}

		// TODO: If exposing deep links into your app, handle intents here.
	}

	/**
	 * Callback method indicating that
	 * the item with the given ID was selected.
	 */
	@Override
	public void onItemSelected(int id) {
		if(null == wgetime) {
			wgetime = new Date();
			downloadContent();
		}
		if (mTwoPane) {
			// In two-pane mode, show the detail view in this activity by
			// adding or replacing the detail fragment using a
			// fragment transaction.
			Bundle arguments = new Bundle();
			arguments.putInt(ItemDetailFragment.ARG_ITEM_ID, id);
			ItemDetailFragment fragment = new ItemDetailFragment();
			fragment.setArguments(arguments);
			getFragmentManager().beginTransaction()
					.replace(R.id.item_detail_container, fragment).commit();

		} else {
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			Intent detailIntent = new Intent(this, ItemListActivity.class);
			detailIntent.putExtra(ItemListFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
	
	private void downloadContent() {
		
	}
}
