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

public class FindPeopleFragment extends Fragment {
	
	public FindPeopleFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_find_people, container, false);
        Intent myIntent = new Intent(getActivity(), ReminderListActivity.class);
        getActivity().startActivity(myIntent);
        return rootView;
    }
}
