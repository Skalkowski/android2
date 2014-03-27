package com.example.calculatespeed;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Spinner;

public class Calculate extends Activity {

	private static final String DISTANCE = "DISTANCE";
	private static final String TIME = "TIME";
	private static final String SPEED = "SPEED";

	private double distanceD;
	private double timeD;
	private double speedD;

	EditText distanceET;
	EditText timeET;
	EditText speedET;
	
	Spinner spinnerek;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculate);

		if (savedInstanceState == null) {
			distanceD = 0.0;
			timeD = 0.0;
			speedD = 0.0;
		} else {
			distanceD = savedInstanceState.getDouble(DISTANCE);
			timeD = savedInstanceState.getDouble(TIME);
			speedD = savedInstanceState.getDouble(SPEED);
		}

		distanceET = (EditText) findViewById(R.id.distanceEditText);
		timeET = (EditText) findViewById(R.id.timeEditText);
		speedET = (EditText) findViewById(R.id.speedEditText);
		spinnerek = (Spinner) findViewById(R.id.distanceSpinner);

		distanceET.addTextChangedListener(distanceListener);
		timeET.addTextChangedListener(timeListener);
		
	}

	private TextWatcher timeListener = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			try {
				timeD = Double.parseDouble(s.toString());
			} catch (NumberFormatException e) {
				timeD = 0.0;
			}

			updateSpeedByTime();

		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub

		}
	};

	private TextWatcher distanceListener = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			try {
				distanceD = Double.parseDouble(arg0.toString());
			} catch (NumberFormatException e) {
				distanceD = 0.0;
			}

			updateSpeedByDistance();
		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub

		}
	};

	private void updateSpeedByDistance() {
		try {
			double time = Double.parseDouble(timeET.getText().toString());
			
			spinnerek = (Spinner) findViewById(R.id.distanceSpinner);
			String test = spinnerek.getSelectedItem().toString(); 
			
			if (test.equals("Kilometers")){
				distanceD = distanceD * 1000;
			}
			else if (test.equals("Miles")) {
				distanceD = distanceD * 0.621371192;
			}
			
			else{}
			

			double score = distanceD / time;

			speedET.setText(String.valueOf(score));
		} catch (NumberFormatException e) {
			speedET.setText("dupa");
		}
	}

	private void updateSpeedByTime() {
		try {
			double distance = Double.parseDouble(distanceET.getText().toString());
			
			
			spinnerek = (Spinner) findViewById(R.id.distanceSpinner);
			String test = spinnerek.getSelectedItem().toString(); 
			
			if (test.equals("Kilometers")){
				distance = distance * 1000;
			}
			else if (test.equals("Miles")) {
				distance = distance * 0.621371192;
			}
			
			else{}
			
			double score = distance / timeD;
		
			speedET.setText(String.valueOf(score));
		} catch (NumberFormatException e) {
			speedET.setText("dupa");
		}
	}

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putDouble(DISTANCE, distanceD);
		outState.putDouble(TIME, timeD);
		outState.putDouble(SPEED, speedD);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculate, menu);
		return true;
	}

}
