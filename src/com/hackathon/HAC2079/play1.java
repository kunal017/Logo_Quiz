package com.hackathon.HAC2079;

import java.util.Random;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class play1 extends Activity {

		public static int i=0;
		public static int hs=0;
		public static int score=0;
		public static int levels=0;
		public static int hints=3;
		public ImageView imgview;
		private SQLiteDatabase db;
		public EditText edittext;
		public TextView tvv,hr,tvv1,level;
		ContentValues contentv=new ContentValues();
	
	 public static int[] images = {
				R.drawable.apple,R.drawable.amazon,R.drawable.android,R.drawable.adidas,R.drawable.audi,R.drawable.bankofamerica,R.drawable.barclays,R.drawable.bmw,R.drawable.boeing,R.drawable.bsnl
				,R.drawable.chevrolet,R.drawable.discovery,R.drawable.dominos,R.drawable.fox,R.drawable.gatorade,R.drawable.gucci,R.drawable.heinz,R.drawable.honda,R.drawable.hp,R.drawable.indianpost
				,R.drawable.ing,R.drawable.intel,R.drawable.jaguar,R.drawable.java,R.drawable.kfc,R.drawable.lays,R.drawable.lexus,R.drawable.logitech,R.drawable.maestro,R.drawable.mcdonalds,R.drawable.mercedes
				,R.drawable.microsoft,R.drawable.montblanc,R.drawable.mtv,R.drawable.nespresso,R.drawable.nestle,R.drawable.nike,R.drawable.nissan,R.drawable.pepsi,R.drawable.philips
				,R.drawable.playboy,R.drawable.porsche,R.drawable.puma,R.drawable.redbull,R.drawable.reebok,R.drawable.rolex,R.drawable.shell,R.drawable.skoda,R.drawable.skype,R.drawable.sonyericsson
				,R.drawable.starbucks,R.drawable.toyota,R.drawable.unilever,R.drawable.uninor,R.drawable.vodafone,R.drawable.volkswagen,R.drawable.volvo,R.drawable.xbox,R.drawable.youtube,
				R.drawable.bacardi,R.drawable.bentley,R.drawable.bluetooth,R.drawable.bridgestone,R.drawable.burgerking,R.drawable.cadillac,R.drawable.calvinklein,R.drawable.castrol,R.drawable.chevron,
				R.drawable.chrysler,R.drawable.cisco,R.drawable.citroen,R.drawable.delta,R.drawable.dreamcast,R.drawable.dunkindonuts,R.drawable.emirates,R.drawable.fbi,R.drawable.flipkart,R.drawable.instagram,
				R.drawable.kappa,R.drawable.kwalitywalls,R.drawable.levis,R.drawable.lg,R.drawable.lipton,R.drawable.lotto,R.drawable.lotus,R.drawable.malibu,R.drawable.mazda,R.drawable.michelin,R.drawable.mitsubishi,
				R.drawable.motorola,R.drawable.msn,R.drawable.nasa,R.drawable.pacha,R.drawable.pantene,R.drawable.pizzahut,R.drawable.pringles,R.drawable.renault,R.drawable.rollsroyce,R.drawable.safeway,R.drawable.saturn,
				R.drawable.skullcandy,R.drawable.spotify,R.drawable.tata,R.drawable.tissot,R.drawable.twitter,R.drawable.unicef,R.drawable.wifi,R.drawable.wikipedia,R.drawable.wwf,
				R.drawable.yamaha
		};
		public static String[] names={"apple","amazon","android","adidas","audi","bankofamerica","barclays","bmw","boeing","bsnl","chevrolet","discovery","dominos","fox","gatorade","gucci","heinz","honda","hp","indianpost","ing",
			                           "intel","jaguar","java","kfc","lays","lexus","logitech","maestro","mcdonalds","mercedes","microsoft","montblanc","mtv","nespresso","nestle","nike","nissan","pepsi","philips",
			                           "playboy","porsche","puma","redbull","reebok","rolex","shell","skoda","skype","sonyericsson","starbucks","toyota","unilever","uninor","vodafone","volkswagen","volvo","xbox","youtube",
			                           "bacardi","bentley","bluetooth","bridgestone","burgerking","cadillac","calvinklein","castrol","chevron","chrysler",
			                           "cisco","citroen","delta","dreamcast","dunkindonuts","emirates","fbi","flipkart","instagram",
			                           "kappa","kwalitywalls","levis","lg","lipton","lotto","lotus","malibu","mazda","michelin","mitsubishi",
			                           "motorola","msn","nasa","pacha","pantene","pizzahut","pringles","renault","rollsroyce","safeway","saturn",
			                           "skullcandy","spotify","tata","tissot","twitter","unicef","wifi","wikipedia","wwf","yamaha"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playquiz);
		tvv=(TextView)findViewById(R.id.textView4);
		level=(TextView)findViewById(R.id.textlevel);
		tvv1=(TextView)findViewById(R.id.textView10);
		tvv.setText(score+"");
		tvv1.setText(MainActivity.m_Text);
		
		levels=(i/10)+1;
		if(i!=0)
		{
			if(i%10==0)
			{
				hints++;
			}
		}
		level.setText("Level "+levels);
		hr=(TextView)findViewById(R.id.hintremaining);
		hr.setText("Remaining : "+hints);
		
		//shuffleArray(images);
		imgview=(ImageView)findViewById(R.id.imageView1);
		imgview.setImageResource(images[i]);
		
		db=openOrCreateDatabase("logo2",MODE_APPEND,null);
		
		edittext=(EditText)findViewById(R.id.guesslogo);
		
		edittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(hasFocus){
		            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); 
		            imm.hideSoftInputFromWindow(edittext.getWindowToken(), 0);
		            }
			}
		});
	}
		 public void onBackPressed() {
			    // TODO Auto-generated method stub
			    
			}
		 public void hintplease(View view)
		 {
			 if(hints>0)
			 {
			 String p =names[i];
			 toast(p.toUpperCase());
			 hints--;
			 hr.setText("Remaining : "+hints);
			 }
			 else
			 {
				 toast("NO HINT AVAILABLE");
			 }
		 }
		 
		 public void getout(View view)
		 {
			 contentv.put("highscore", (score+""));
			 db.insert("logo2", null, contentv);
			 Intent openStartingPoint=new Intent("com.hackathon.HAC2079.GAMEOVER");
				startActivity(openStartingPoint);
		 }
		 public void nextpage(View view)
		 {
			 
			 String s=(((edittext.getText().toString()).toUpperCase()).trim()).replaceAll("\\s", "");
			 if(s.equals((names[i]).toUpperCase()))
			 {
				 i++;
				 score++;
				 if(i%10==0)
				 {
				 if(i!=0)
				 {
				 toast("CONGRATS !! LEVEL "+levels+" passed");
				 }
				 else
				 {
					 toast("CORRECT ANSWER");
				 }
				 }
				 else
				 {
					 toast("CORRECT ANSWER");
				 }
				 
				 
				 if(i<118)
				 {
				 Intent openStartingPoint=new Intent("com.hackathon.HAC2079.PLAY1");
					startActivity(openStartingPoint);
				 }
				 else
				 {
					 Intent openStartingPoint=new Intent("com.hackathon.HAC2079.WINNING");
						startActivity(openStartingPoint);
				 }
			 }
			 else if(s.length()==0)
			 {
				 toast("ENTER A NAME");
			 }
			 else
			 {
				 toast("WRONG ANSWER");
			 }
			
		 }
		 public static void shuffleArray(int[] ar,String[] name)
		  {
		    Random rnd = new Random();
		    for (int i = ar.length - 1; i > 0; i--)
		    {
		      int index = rnd.nextInt(i + 1);
		      // Simple swap
		      int a = ar[index];
		      String b = name[index];
		      ar[index] = ar[i];
		      name[index] = name[i];
		      ar[i] = a;
		      name[i] = b;
		    }
		    
	}
		 public void toast(String s)
		    {
		    	LinearLayout  layout=new LinearLayout(this);
		        layout.setBackgroundResource(R.color.black);

		        TextView  tv=new TextView(this);
		        // set the TextView properties like color, size etc
		        tv.setTextColor(Color.WHITE);
		        tv.setTextSize(45);        

		        tv.setGravity(Gravity.CENTER);

		        // set the text you want to show in  Toast
		        tv.setText(s);  

		        layout.addView(tv);

		        Toast toast=new Toast(this); //context is object of Context write "this" if you are an Activity
		       // Set The layout as Toast View
		        toast.setView(layout);

		          // Position you toast here toast position is 50 dp from bottom you can give any integral value   
		         toast.setGravity(Gravity.BOTTOM, 0, 50);
		         toast.show();
		    }
	}

	

