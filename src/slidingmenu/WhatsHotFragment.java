package slidingmenu;

import birthday.BirthdayReminder;

import com.sktekki.reminder.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class WhatsHotFragment extends Fragment 
{
	public WhatsHotFragment(){}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_whats_hot, container, false);
        Intent myIntent = new Intent(getActivity(), weather.MainActivity.class);
        getActivity().startActivity(myIntent);
        return rootView;
    }
}
