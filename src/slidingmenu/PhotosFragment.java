package slidingmenu;

import com.sktekki.reminder.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PhotosFragment extends Fragment {
	
	public PhotosFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_photos, container, false);
        Intent myIntent = new Intent(getActivity(), news.MessageList.class);
        getActivity().startActivity(myIntent);
        return rootView;
    }
}
