package com.example.josip.switchergame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Josip on 8. 10. 2017..
 */

public class GridAdapter extends BaseAdapter{
    private Context context;
    private LayoutInflater inflater;
    private int brojLevela;


    public GridAdapter(Context context, int brojLevela) {
        this.context = context;
        this.brojLevela = brojLevela;
    }

    @Override
    public int getCount() {
        return brojLevela;
    }

    @Override
    public Object getItem(int position) {
        return position+1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = convertView;
        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.levels_custom_item, null);
        }

        TextView level = (TextView) gridView.findViewById(R.id.tvLevelsCustomItem);

        level.setText(String.valueOf(position + 1));
        return gridView;
    }
}
