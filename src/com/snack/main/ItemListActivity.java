package com.snack.main;

import com.snack.common.Callbacks;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

public class ItemListActivity extends Activity implements Callbacks{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_item_list);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This is called when the Home (Up) button is pressed
			// in the Action Bar.
//			NavUtils.navigateUpFromSameTask(this);    //from the support.v4 library
//			navigateUpTo(getParentActivityIntent());    //API 16 and above
			onBackPressed();
			return true;
		}
		return super.onOptionsItemSelected(item);	
	}

	@Override
	public void onItemSelected(int id) {
		// TODO Auto-generated method stub
		
	}
}
