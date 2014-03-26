package com.example.eduwords;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        View przyciskTest = findViewById(R.id.przycisk_test);
		przyciskTest.setOnClickListener(this);
		
		View przyciskOpis = findViewById(R.id.przycisk_opis);
		przyciskOpis.setOnClickListener(this);
		View przyciskAutor = findViewById(R.id.przycisk_autor);
		przyciskAutor.setOnClickListener(this);
		View przyciskWyjscie = findViewById(R.id.przycisk_wyjscie);
		przyciskWyjscie.setOnClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.przycisk_test:
			Intent i1 = new Intent(this, Test.class);
			startActivity(i1);
			break;
		case R.id.przycisk_opis:
			Intent i2 = new Intent(this, Opis.class);
			startActivity(i2);
			break;
		case R.id.przycisk_wyjscie:
			System.exit(0);
			break;
		}
	}
    
}
