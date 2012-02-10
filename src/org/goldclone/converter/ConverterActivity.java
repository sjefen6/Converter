package org.goldclone.converter;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class ConverterActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		populateCategory();

		EditText inputEditText = (EditText) findViewById(R.id.inputEditText);
		inputEditText.setKeyListener(new inputListener());
	}

	private void populateCategory() {
		// Find the spinner
		Spinner categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
		// Create an aa to contain the simple_spinner_items
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this,
				R.array.categories, android.R.layout.simple_spinner_item);
		/*
		 * Set the view resource of the items in the popped up spinner to
		 * simple_spinner_dropdown_item (it looks better than
		 * simple_spinner_item)
		 */
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Set the adapter for the categorySpinner
		categorySpinner.setAdapter(aa);
		// Create a listener for the categorySpinner
		categorySpinner
				.setOnItemSelectedListener(new categorySpinnerListener());
	}

	private void populateFromTo(int categoryId) {
		/*
		 * See comments for populateCategory()
		 */
		Spinner fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
		Spinner toSpinner = (Spinner) findViewById(R.id.toSpinner);

		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this,
				categoryId, android.R.layout.simple_spinner_item);

		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		fromSpinner.setAdapter(aa);
		toSpinner.setAdapter(aa);
	}

	private class categorySpinnerListener implements OnItemSelectedListener {
		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			int categoryId = 0;
			if (arg0.getSelectedItemPosition() == 0)
				categoryId = R.array.distance;
			else if (arg0.getSelectedItemPosition() == 1)
				categoryId = R.array.area;
			else if (arg0.getSelectedItemPosition() == 2)
				categoryId = R.array.volume;
			else if (arg0.getSelectedItemPosition() == 3)
				categoryId = R.array.mass;
			else if (arg0.getSelectedItemPosition() == 4)
				categoryId = R.array.temperature;
			else if (arg0.getSelectedItemPosition() == 5)
				categoryId = R.array.time;
			else
				Toast.makeText(arg0.getContext(), "WTH Error!",
						Toast.LENGTH_LONG).show();
			populateFromTo(categoryId);
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
	}

	private class inputListener implements KeyListener {

		@Override
		public void clearMetaKeyState(View arg0, Editable arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public int getInputType() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean onKeyDown(View arg0, Editable arg1, int arg2,
				KeyEvent arg3) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onKeyOther(View arg0, Editable arg1, KeyEvent arg2) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onKeyUp(View arg0, Editable arg1, int arg2, KeyEvent arg3) {
			// TODO Auto-generated method stub
			return false;
		}
	}
}