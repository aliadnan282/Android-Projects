package net.skyleet.xviiiaiambt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReachUs extends Fragment {


    public ReachUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reach_us, container, false);

//        String url = "http://google.com/";
//        WebView view =(WebView) view.findViewById(R.id.webView);
//        view.getSettings().setJavaScriptEnabled(true);
//        view.loadUrl(url);

    }

}
