package com.snack.main;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.snack.main.content.SnackSubjectList;

/**
 * A fragment representing a single Item detail screen. This fragment is either
 * contained in a {@link MainListActivity} in two-pane mode (on tablets) or a
 * {@link ItemDetailActivity} on handsets.
 */
public class ItemDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The content this fragment is presenting.
	 */
	private SnackSubjectList.SnackItem mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public ItemDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = SnackSubjectList.ITEMS.get(getArguments().getInt(
					ARG_ITEM_ID));
		}
		Log.i("Info", "oncreate");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_item_detail,
				container, false);

		// Show the dummy content as text in a TextView.
//		if (mItem != null) {
//			((TextView) rootView.findViewById(R.id.item_detail))
//					.setText(mItem.content);
//		}
		getActivity().setTitle("ʱ��˫��");
		((TextView) rootView.findViewById(R.id.item_detail)).setText("--------");
//		new Thread(new NetworkHelper()).start();
//		if(NetworkHelper.content != "") {
//			((TextView) rootView.findViewById(R.id.item_detail)).setText(NetworkHelper.content);
//		}
		Log.i("Info", "oncreateview");
		return rootView;
	}
}
