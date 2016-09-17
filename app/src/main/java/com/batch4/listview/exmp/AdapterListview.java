package com.batch4.listview.exmp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.batch4.R;

/**
 * Created by Divyanshu on 31-07-2016.
 */
public class AdapterListview extends BaseAdapter {

    String[] result;
    Context context;
    int[] imageID;

    private static LayoutInflater inflater = null;

    public  AdapterListview(ListViewCustom listViewCustom, String[] names, int[] images){
        result = names;
        imageID = images;
        context = listViewCustom;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class Holder{
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {

        Holder holder = new Holder();
        View rowview;
        rowview = inflater.inflate(R.layout.adapter_listview,null);
        holder.img = (ImageView)rowview.findViewById(R.id.imageview1);
        holder.tv = (TextView)rowview.findViewById(R.id.textview1);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageID[position]);
        rowview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"You click : "+result[position],Toast.LENGTH_SHORT).show();
            }
        });

        return rowview;
    }
}
