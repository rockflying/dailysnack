package com.snack.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class ItemListActivity extends Activity {
	
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
			//NavUtils.navigateUpFromSameTask(this);
			Toast.makeText(getApplicationContext(), "UPUPUPUPUP", Toast.LENGTH_SHORT).show();
			return true;
		}
		return super.onOptionsItemSelected(item);	
	}
}
