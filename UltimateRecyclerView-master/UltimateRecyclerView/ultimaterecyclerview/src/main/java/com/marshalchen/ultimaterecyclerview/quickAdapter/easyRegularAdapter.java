package com.marshalchen.ultimaterecyclerview.quickAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

import java.util.List;

/**
 * This is the normal adapter for implementation on the regular basis
 * Created by hesk on 4/8/15.
 */
public abstract class easyRegularAdapter<T, BINDHOLDER extends UltimateRecyclerviewViewHolder> extends UltimateViewAdapter {
    private List<T> source;

    @Override
    public UltimateRecyclerviewViewHolder getViewHolder(View view) {
        return new UltimateRecyclerviewViewHolder(view);
    }

    /**
     * dynamic object to start
     *
     * @param list the list source
     */
    public easyRegularAdapter(List<T> list) {
        source = list;
    }

    /**
     * the layout id for the normal data
     *
     * @return the ID
     */
    protected abstract int getNormalLayoutResId();

    protected abstract BINDHOLDER newViewHolder(View view);

    @Override
    public UltimateRecyclerviewViewHolder onCreateViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(getNormalLayoutResId(), parent, false);
        return newViewHolder(v);
    }

    @Override
    public int getAdapterItemCount() {
        return source.size();
    }

    @Override
    public long generateHeaderId(int i) {
        return 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == getAdapterItemCount()) return;
        withBindHolder((BINDHOLDER) holder, source.get(position), position);
    }

    protected abstract void withBindHolder(final BINDHOLDER holder, final T data, final int position);

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
    }


    public void insert(List<T> new_data) {
        insertInternal(new_data, source);
    }

    public void removeAll() {
        clearInternal(source);
    }

    public void insertFirst(T item) {
        insertFirstInternal(source, item);
    }

    public void insertLast(T item) {
        insertLastInternal(source, item);
    }

    public void removeLast() {
        removeLastInternal(source);
    }

    public void removeFirst() {
        removeFirstInternal(source);
    }
    
}
