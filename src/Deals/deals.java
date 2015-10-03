package Deals;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sktekki.reminder.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class deals extends Activity 
{
  @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.deal);
	String website="http://www.flipkart.com/";
	Document doc;
	try 
	{
		doc = Jsoup.connect(website).get();
		Elements el=doc.getElementsByClass("new-mod-foz");
		String text=el.text();
	} catch (Exception e) 
	{
		Log.wtf("name of activity","error message to show in log", e);
	}
	
}
}
