package ice.tea09.demoswipeviewtablayout.fragment;

import ice.tea09.demoswipeviewtablayout.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ThirdTabFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {		
		View view = inflater.inflate(R.layout.third_tab_fragment, container, false);        
        return view;
	}
	
}
