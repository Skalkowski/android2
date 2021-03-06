package com.example.calculatespeed;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		View przyciskKalkulator = findViewById(R.id.calculateButton);
		przyciskKalkulator.setOnClickListener(this);
		
		View przyciskKonwertuj = findViewById(R.id.convertButton);
		przyciskKonwertuj.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.calculateButton:
			Intent i1 = new Intent(this, Calculate.class);
			startActivity(i1);
			break;
		case R.id.convertButton:
			Intent i2 = new Intent(this, Convert.class);
			startActivity(i2);
			break;
		}
		
	}

}
