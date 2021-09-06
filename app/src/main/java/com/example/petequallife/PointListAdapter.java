package com.example.petequallife;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PointListAdapter extends BaseAdapter {
    LayoutInflater inflater = null;
    private ArrayList<PointData> pData = null;
    private int nListCnt = 0;

    public PointListAdapter(ArrayList<PointData> _pData){
        pData = _pData;
        nListCnt = pData.size();
    }

    @Override
    public int getCount()
    {
        Log.i("TAG", "getCount: " + nListCnt);
        return nListCnt;
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            final Context context = parent.getContext();
            if (inflater == null)
            {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            convertView = inflater.inflate(R.layout.listview_point_item, parent, false);
        }

        TextView text = convertView.findViewById(R.id.point_item_text);
        TextView point = convertView.findViewById(R.id.point_item_point);
        TextView heart = convertView.findViewById(R.id.point_item_heart);

        text.setText(pData.get(position).text);
        if(pData.get(position).point>0){
            point.setText("+"+pData.get(position).point);
        } else{
            point.setText(""+pData.get(position).point);
        }
        if(pData.get(position).heart>0){
            heart.setText("+" + pData.get(position).heart);
        } else{
            heart.setText(""+pData.get(position).heart);
        }


        return convertView;
    }
}
