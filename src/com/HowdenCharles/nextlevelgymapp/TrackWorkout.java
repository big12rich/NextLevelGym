package com.HowdenCharles.nextlevelgymapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TrackWorkout extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_track_workout);
		// Show the Up button in the action bar.
		//setupActionBar();
	
    final ListView listview = (ListView) findViewById(R.id.listView1);
    String[] values = new String[] { "Bicep Curls", "Leg Press", "Squats", "Bench Press" };

    final ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < values.length; ++i) {
      list.add(values[i]);
    }
    final StableArrayAdapter adapter = new StableArrayAdapter(this,
        android.R.layout.simple_list_item_1, list);
    listview.setAdapter(adapter);

    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

      @SuppressLint("NewApi")
	@Override


public void onItemClick(AdapterView<?> parent, View view,
  int position, long id) {
   switch( position ) {
     case 0:  Intent nextScreen1 = new Intent(getApplicationContext(), BicepCurl.class);     
              startActivity(nextScreen1);
              break;
     case 1:  Intent nextScreen2 = new Intent(getApplicationContext(), LegPress.class);     
              startActivity(nextScreen2);
              break;
     case 2:  Intent nextScreen3 = new Intent(getApplicationContext(), Squats.class);     
              startActivity(nextScreen3);
              break;
     case 3:  Intent nextScreen4 = new Intent(getApplicationContext(), BenchPress.class);     
              startActivity(nextScreen4);
              break;
     case 4:  Intent nextScreen5 = new Intent(getApplicationContext(), SkullCrusher.class);     
              startActivity(nextScreen5);
              break;
    }
}


    });
  }

  private class StableArrayAdapter extends ArrayAdapter<String> {

    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public StableArrayAdapter(Context context, int textViewResourceId,
        List<String> objects) {
      super(context, textViewResourceId, objects);
      for (int i = 0; i < objects.size(); ++i) {
        mIdMap.put(objects.get(i), i);
      }
    }

    @Override
    public long getItemId(int position) {
      String item = getItem(position);
      return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
      return true;
    }
  }
  

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.track_workout, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
