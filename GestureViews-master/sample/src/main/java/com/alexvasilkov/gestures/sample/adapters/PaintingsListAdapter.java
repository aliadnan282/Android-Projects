package com.alexvasilkov.gestures.sample.adapters;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.alexvasilkov.android.commons.utils.Views;
import com.alexvasilkov.gestures.sample.R;
import com.alexvasilkov.gestures.sample.logic.Painting;
import com.alexvasilkov.gestures.sample.utils.glide.GlideHelper;

public class PaintingsListAdapter extends BaseAdapter implements View.OnClickListener {

    private final Painting[] mPaintings;
    private final OnPaintingListener mListener;

    public PaintingsListAdapter(Painting[] paintings, OnPaintingListener listener) {
        mPaintings = paintings;
        mListener = listener;
    }

    @Override
    public int getCount() {
        return mPaintings.length;
    }

    @Override
    public Object getItem(int position) {
        return mPaintings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = onCreateHolder(parent);
            holder.itemView.setTag(R.id.tag_holder, holder);
        } else {
            holder = (ViewHolder) convertView.getTag(R.id.tag_holder);
        }
        onBindHolder(holder, position);
        return holder.itemView;
    }

    private ViewHolder onCreateHolder(ViewGroup parent) {
        ViewHolder holder = new ViewHolder(parent);
        holder.image.setOnClickListener(this);
        return holder;
    }

    private void onBindHolder(ViewHolder holder, int position) {
        holder.image.setTag(R.id.tag_item, position);
        GlideHelper.loadResource(mPaintings[position].getImageId(), holder.image);
    }

    @Override
    public void onClick(@NonNull View view) {
        int pos = (Integer) view.getTag(R.id.tag_item);
        mListener.onPaintingClick(mPaintings[pos], pos, (ImageView) view);
    }

    public static ImageView getImage(View itemView) {
        ViewHolder holder = (ViewHolder) itemView.getTag(R.id.tag_holder);
        return holder == null ? null : holder.image;
    }

    static class ViewHolder {
        public final View itemView;
        public final ImageView image;

        public ViewHolder(ViewGroup parent) {
            itemView = Views.inflate(parent, R.layout.item_image);
            image = (ImageView) itemView;
        }
    }

    public interface OnPaintingListener {
        void onPaintingClick(Painting painting, int position, ImageView image);
    }

}
