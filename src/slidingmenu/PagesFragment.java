package slidingmenu;

import birthday.BirthdayReminder;

import com.sktekki.reminder.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PagesFragment extends Fragment {
	
	public PagesFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_pages, container, false);
        Intent myIntent = new Intent(getActivity(), Deals.deals.class);
        getActivity().startActivity(myIntent);
        return rootView;
    }
}
