package com.hackathon.HAC2079;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class winning extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wnning);
	}
	public void gohome(View view)
	{
		Intent openStartingPoint=new Intent(this , MainActivity.class);
		startActivity(openStartingPoint);
	}
	public void onBackPressed() {
	    // TODO Auto-generated method stub
	   
	}
}
