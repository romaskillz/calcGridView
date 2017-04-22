package com.example.romas.calculatorgrid;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Romas on 22.04.2017.
 */

public class GridAdapter extends ArrayAdapter<String> {

    private static final String[] mNumbers = {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            "0", "."};

    Context mContext;

    // Конструктор
    public GridAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId, mNumbers);
        this.mContext = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView label = (TextView) convertView;


        if (convertView == null) {
            convertView = new TextView(mContext);
            label = (TextView) convertView;
        }
        label.setTextSize(30);
        label.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        label.setTextColor(Color.BLACK);
        label.setText(mNumbers[position]);
        return (convertView);
    }

    // возвращает содержимое выделенного элемента списка
    public String getItem(int position) {
        return mNumbers[position];
    }
}