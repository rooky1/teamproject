package com.yahoo.rssreader;

import java.util.Random;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.yahoo.rssreader.fragments.SubscriptionsFragment;
import com.yahoo.rssreader.models.RSSFeed;

public class YahooRSSActivity extends FragmentActivity {

	private SubscriptionsFragment subscriptions;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yahoo_rss);
		
		FragmentManager manager = getSupportFragmentManager();
		subscriptions = (SubscriptionsFragment) manager.findFragmentById(R.id.fragmentSubscriptions);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.yahoo_rs, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case R.id.action_add_subscription:
	        addSubscriptionActivity();
	    	return true;
	    case R.id.action_refresh:
	    	refreshFragment();
	    	return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}

	private void refreshFragment() {
		//TEMP
		Toast.makeText(this, "Clicked on Refresh", Toast.LENGTH_SHORT).show();
		
	}

	private void addSubscriptionActivity() {
		//TEMP
		Toast.makeText(this, "Clicked on Add Subscription", Toast.LENGTH_SHORT).show();
		
		//PROGRAMATICALLY ADDING A FEED FOR TESTING
		RSSFeed feed = new RSSFeed();
		feed.setImageUrl("http://upload.wikimedia.org/wikipedia/en/thumb/4/43/Feed-icon.svg/128px-Feed-icon.svg.png");
		feed.setName("Some feed");
		feed.setUnreadCount(new Random().nextInt(10));
		
		subscriptions.addFeed(feed);
		
	}

}
