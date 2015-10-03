
package com.sktekki.reminder;

import slidingmenu.MainActivity;
import birthday.BirthdayReminder;

import com.sktekki.reminder.R;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Choreographer.FrameCallback;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.TextView;

public class ReminderListActivity extends ListActivity {
    private static final int ACTIVITY_CREATE=0;
    private static final int ACTIVITY_EDIT=1;
    
    private RemindersDbAdapter mDbHelper;
	private CustomAdapter listAdapter;
	String[] from = new String[]{RemindersDbAdapter.KEY_TITLE};
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder_list);
        listAdapter = new CustomAdapter(this,android.R.id.list, from, "fonts/SofadiOne-Regular.ttf");
        mDbHelper = new RemindersDbAdapter(this);
        mDbHelper.open();
        fillData();
        registerForContextMenu(getListView());
 
        getResources();
        //Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/SofadiOne-Regular.ttf");
        Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(),"fonts/KaushanScript-Regular.otf");
        TextView tv = (TextView) findViewById(android.R.id.empty);
        findViewById(R.layout.reminder_list);
        tv.setTypeface(tf);
                
    }
    

	private void fillData() {
        Cursor remindersCursor = mDbHelper.fetchAllReminders();
        startManagingCursor(remindersCursor);
        
        // Create an array to specify the fields we want to display in the list (only TITLE)
        String[] from = new String[]{RemindersDbAdapter.KEY_TITLE};
        
        // and an array of the fields we want to bind those fields to (in this case just text1)
        int[] to = new int[]{R.id.text1};
        
        // Now create a simple cursor adapter and set it to display
        
        SimpleCursorAdapter reminders = 
        	    new SimpleCursorAdapter(this, R.layout.reminder_row, remindersCursor, from, to);
        
        setListAdapter(reminders);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.list_menu, menu); 
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch(item.getItemId()) {
        case R.id.menu_insert: 
            createReminder();
            return true; 
        case R.id.menu_settings: 
        	Intent i = new Intent(this, TaskPreferences.class); 
        	startActivity(i); 
            return true;
        }
       
        return super.onMenuItemSelected(featureId, item);
    }
	
    @Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater mi = getMenuInflater(); 
		mi.inflate(R.menu.list_menu_item_longpress, menu); 
	}

    @Override
	public boolean onContextItemSelected(MenuItem item) {
		switch(item.getItemId()) {
    	case R.id.menu_delete:
    		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
	        mDbHelper.deleteReminder(info.id);
	        fillData();
	        return true;
		}
		return super.onContextItemSelected(item);
	}
	
    private void createReminder() {
        Intent i = new Intent(this, ReminderEditActivity.class);
        
        startActivityForResult(i, ACTIVITY_CREATE);
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent i = new Intent(this, ReminderEditActivity.class);
        i.putExtra(RemindersDbAdapter.KEY_ROWID, id);
        startActivityForResult(i, ACTIVITY_EDIT); 
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        fillData();
    }
}

 class CustomAdapter extends ArrayAdapter<CharSequence>{

    Context context; 
    int layoutResourceId;    
    CharSequence data[] = null;
    Typeface tf; 

public CustomAdapter(Context context, int layoutResourceId, CharSequence[] data, String FONT ) { 
    super(context, layoutResourceId, data);
    this.layoutResourceId = layoutResourceId;
    this.context = context;
    this.data = data;
    tf = Typeface.createFromAsset(context.getAssets(), FONT);
}  
}
