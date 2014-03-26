package com.example.eduwords;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Test extends Activity{
	public final static String EXTRA_MESSAGE = "com.example.EduWords.MESSAGE";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
	}
	
	public void sendMessage (View view) {
		Intent intent = new Intent(this, PoTescie.class);
		EditText editText = (EditText) findViewById(R.id.edit_test);
		String message = getString(R.string.hello_text) + " " + editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

}
