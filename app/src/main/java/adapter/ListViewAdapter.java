package adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.appmusic.PlayListActivity;
import com.example.appmusic.R;
import com.example.appmusic.SongsManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import fragment.Fragment_Trinh_Phat;
import model.model;

public class ListViewAdapter extends SimpleAdapter {
    LayoutInflater inflater;
    Context context;
    ArrayList<HashMap<String, String>> data;
    int resource;
    String[] from;
    int[] to;



    public ListViewAdapter(Context context,  ArrayList<HashMap<String, String>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context=context;
        this.data = data;
        this.resource = resource;
        this.from = from;
        this.to = to;
        inflater = LayoutInflater.from(context);
    }


    public static class ViewHolder{
        TextView title;
    }

    @Override
    public int getCount() { return 0;
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder Holder;
        if (view == null){
            Holder = new ViewHolder();
            view = inflater.inflate(R.layout.playlist_item,null);

            Holder.title.findViewById(R.id.songTitle);
            Holder.title.findViewById(R.id.icon);
            view.setTag(Holder);
        }else {
            Holder = (ViewHolder)view.getTag();
        }
        Holder.title.setText(from[position]);
        final View finalView = view;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, Fragment_Trinh_Phat.class);
                in.putExtra("songIndex", position);
                context.startActivity(in);
            }
        });
        return view;
    }
}
