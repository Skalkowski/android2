package com.example.bmi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void licz(View view){
		Intent intent = new Intent(this, Wynik.class);
		EditText wagaText = (EditText) findViewById(R.id.edit_waga);
		

		
		EditText wzrostText = (EditText) findViewById(R.id.edit_wzrost);
		String wagaS = wagaText.getText().toString();
		double waga = Double.parseDouble(wagaS);
		String wzrostS = wzrostText.getText().toString();
		double wzrost = Double.parseDouble(wzrostS)/100;
		double wynik = waga/(wzrost*wzrost);
		String wynik2 = Double.toString(wynik);
		intent.putExtra(EXTRA_MESSAGE, wynik2);
		startActivity(intent);
		
	}

}
