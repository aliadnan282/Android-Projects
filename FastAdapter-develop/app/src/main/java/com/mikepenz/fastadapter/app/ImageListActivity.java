package com.mikepenz.fastadapter.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.FastItemAdapter;
import com.mikepenz.fastadapter.app.dummy.ImageDummyData;
import com.mikepenz.fastadapter.app.items.ImageItem;
import com.mikepenz.fastadapter.helpers.ClickListenerHelper;
import com.mikepenz.materialize.MaterializeBuilder;

public class ImageListActivity extends AppCompatActivity {
    //save our FastAdapter
    private FastItemAdapter<ImageItem> mFastItemAdapter;

    private ClickListenerHelper<ImageItem> mClickListenerHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        findViewById(android.R.id.content).setSystemUiVisibility(findViewById(android.R.id.content).getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.sample_image_list);

        //style our ui
        new MaterializeBuilder().withActivity(this).build();

        //create our FastAdapter which will manage everything
        mFastItemAdapter = new FastItemAdapter<>();

        //init the ClickListenerHelper which simplifies custom click listeners on views of the Adapter
        mClickListenerHelper = new ClickListenerHelper<>(mFastItemAdapter);

        //configure our fastAdapter
        mFastItemAdapter.withOnClickListener(new FastAdapter.OnClickListener<ImageItem>() {
            @Override
            public boolean onClick(View v, IAdapter<ImageItem> adapter, ImageItem item, int position) {
                Toast.makeText(v.getContext(), item.mName, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        //get our recyclerView and do basic setup
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        //find out how many columns we display
        int columns = getResources().getInteger(R.integer.wall_splash_columns);
        if (columns == 1) {
            //linearLayoutManager for one column
            rv.setLayoutManager(new LinearLayoutManager(this));
        } else {
            //gridLayoutManager for more than one column ;)
            rv.setLayoutManager(new GridLayoutManager(this, columns));
        }
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(mFastItemAdapter);

        //fill with some sample data
        mFastItemAdapter.add(ImageDummyData.getImageItems());

        //restore selections (this has to be done after the items were added
        mFastItemAdapter.withSavedInstanceState(savedInstanceState);

        //a custom OnCreateViewHolder listener class which is used to create the viewHolders
        //we define the listener for the imageLovedContainer here for better performance
        //you can also define the listener within the items bindView method but performance is better if you do it like this
        mFastItemAdapter.withOnCreateViewHolderListener(new FastAdapter.OnCreateViewHolderListener() {
            @Override
            public RecyclerView.ViewHolder onPreCreateViewHolder(ViewGroup parent, int viewType) {
                return mFastItemAdapter.getTypeInstance(viewType).getViewHolder(parent);
            }

            @Override
            public RecyclerView.ViewHolder onPostCreateViewHolder(final RecyclerView.ViewHolder viewHolder) {
                //we do this for our ImageItem.ViewHolder
                if (viewHolder instanceof ImageItem.ViewHolder) {
                    //if we click on the imageLovedContainer
                    mClickListenerHelper.listen(viewHolder, ((ImageItem.ViewHolder) viewHolder).imageLovedContainer, new ClickListenerHelper.OnClickListener<ImageItem>() {
                        @Override
                        public void onClick(View v, int position, ImageItem item) {
                            item.withStarred(!item.mStarred);
                            //we animate the heart
                            item.animateHeart(((ViewGroup) v).getChildAt(0), ((ViewGroup) v).getChildAt(1), item.mStarred);

                            //we display the info about the click
                            Toast.makeText(ImageListActivity.this, item.mImageUrl + " - " + item.mStarred, Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                return viewHolder;
            }
        });

        //set the back arrow in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the adapter to the bundel
        outState = mFastItemAdapter.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle the click on the back arrow click
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
