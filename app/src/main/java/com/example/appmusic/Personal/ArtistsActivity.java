package com.example.appmusic.Personal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.appmusic.R;

import java.util.ArrayList;

import adapter.ItemAdapter;

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        //Create a list of items in Artists Category
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Zara Larsson", "20 tracks"));
        //Create an link to ItemAdapter
        final ItemAdapter adapter = new ItemAdapter(this, items);
        //ListView
        ListView artistsListView = (ListView) findViewById(R.id.list);
        //Set Adapter
        artistsListView.setAdapter(adapter);
        //Set click listener on that view
        artistsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Create a new intent to open link to ArtistsActivity
                Intent nowPlayingIntent = new Intent(ArtistsActivity.this, Artist1Activity.class);
                //Start the new activity
                startActivity(nowPlayingIntent);
            }
        });
    }
}