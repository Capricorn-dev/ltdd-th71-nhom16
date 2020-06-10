package adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.appmusic.Personal.Item;
import com.example.appmusic.R;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(Activity context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.selection_item, parent, false);
        }

        Item currentItem = (Item) getItem(position);
        TextView firstLineTextView = (TextView) listItemView.findViewById(R.id.first_line_text_view);
        firstLineTextView.setText(currentItem.getmFirstLine());
        TextView secondLineTextView = (TextView) listItemView.findViewById(R.id.second_line_text_view);
        secondLineTextView.setText(currentItem.getmSecondLine());

        return listItemView;
    }
}