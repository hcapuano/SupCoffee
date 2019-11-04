package com.example.supcoffee;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ListManagment extends BaseAdapter implements ListAdapter {

    private ArrayList<String> list = new ArrayList<String>();
    public int itemToDelete;
    private Context context;

    ListManagment(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View viewAddCoffee = convertView;
        if (viewAddCoffee == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewAddCoffee = inflater.inflate(R.layout.activity_listview, null);
        }

        TextView listItemText = viewAddCoffee.findViewById(R.id.label);
        listItemText.setText(list.get(position));

        String all = (String) listItemText.getText();

        listItemText.setText(all.substring(0, all.length() -1));

        float rating = Float.parseFloat(all.substring(all.length() -1));
        RatingBar ratingBar = viewAddCoffee.findViewById(R.id.ratingBar);
        ratingBar.setRating((float) rating);

        return viewAddCoffee;
    }
}
