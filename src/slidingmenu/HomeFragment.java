package slidingmenu;

import birthday.BirthdayReminder;

import com.sktekki.reminder.R;
import com.sktekki.reminder.ReminderListActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment{
	
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) 
	{
		ReminderListActivity rr=new ReminderListActivity();
        View rootView = inflater.inflate(R.layout.birth_contact, container, false);
        Intent myIntent = new Intent(getActivity(), BirthdayReminder.class);
        getActivity().startActivity(myIntent);
        return rootView;
    }
}
