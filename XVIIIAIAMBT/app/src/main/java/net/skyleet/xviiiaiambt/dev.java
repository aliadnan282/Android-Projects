package net.skyleet.xviiiaiambt;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class dev extends Fragment implements View.OnClickListener {

View rootview;
    public dev() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_dev, container, false);

        TextView tv = (TextView) rootview.findViewById(R.id.tel);
        tv.setOnClickListener(this);

        return rootview;


    }

    @Override
    public void onClick(View v) {
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:9649810466"));
            startActivity(myIntent);
    }
}
