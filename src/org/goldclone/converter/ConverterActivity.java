package org.goldclone.converter;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView.OnEditorActionListener;

public class ConverterActivity extends Activity {

	private class inputListener implements OnEditorActionListener {

		@Override
		public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
			calculate();
			return false;
		}

	}

	int category;
	EditText inputEditText;
	Spinner toSpinner;
	Spinner fromSpinner;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		populateCategory();

		inputEditText = (EditText) findViewById(R.id.inputEditText);
		inputEditText.setOnEditorActionListener(new inputListener());
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
		fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
		toSpinner = (Spinner) findViewById(R.id.toSpinner);

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
			category = arg0.getSelectedItemPosition();

			if (category == 0)
				categoryId = R.array.distance;
			else if (category == 1)
				categoryId = R.array.area;
			else if (category == 2)
				categoryId = R.array.volume;
			else if (category == 3)
				categoryId = R.array.mass;
			else if (category == 4)
				categoryId = R.array.temperature;
			else if (category == 5)
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

	private void calculate() {
		// TODO Auto-generated method stub
		EditText outputEditText = (EditText) findViewById(R.id.outputEditText);
		String a = inputEditText.getText().toString();
		double input = Double.parseDouble(a);
		int from = (int) fromSpinner.getSelectedItemId();
		int to = (int) toSpinner.getSelectedItemId();

		if (category == 0) // Distance
			outputEditText.setText(Double.toString(distanceConverter.getInstance()
					.convert(input, from, to)));
		else if (category == 1) // Area
			outputEditText.setText(Double.toString(areaConverter.getInstance()
					.convert(input, from, to)));
		else if (category == 2) // Volume
			outputEditText.setText(Double.toString(volumeConverter
					.getInstance().convert(input, from, to)));
		else if (category == 3) // Mass
			outputEditText.setText(Double.toString(massConverter.getInstance()
					.convert(input, from, to)));
		else if (category == 4) // Temperature
			outputEditText.setText(Double.toString(temperatureConverter
					.getInstance().convert(input, from, to)));
		else if (category == 5) // Time
			outputEditText.setText(Double.toString(timeConverter.getInstance()
					.convert(input, from, to)));
		else
			Toast.makeText(getBaseContext(), "WTH Error!", Toast.LENGTH_LONG)
					.show();
	}
}