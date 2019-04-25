package com.example.msi.tabbedactivityorg;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by msi on 1/20/2018.
 */

public class CustomAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Information> Items;

    public CustomAdapter(Activity activity, ArrayList<Information> items) {
        this.activity = activity;
    Items = items;
}

    @Override
    public int getCount() {
        return Items.size();
    }

    @Override
    public Information getItem(int i) {
        return Items.get(i);

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
