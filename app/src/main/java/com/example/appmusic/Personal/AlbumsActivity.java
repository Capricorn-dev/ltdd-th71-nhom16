package com.example.appmusic.Personal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.appmusic.R;

import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;

import java.util.ArrayList;

import adapter.ItemAdapter;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        //create a list of items in Albums Category

        ArrayList<Item> songs = new ArrayList<Item>();

        songs.add(new Item("So Good", "Zara Larsson"));

        //Create an adapter
        ItemAdapter adapter = new ItemAdapter(this, songs);
        //Make a listview
        ListView albumsListView = (ListView) findViewById(R.id.list);
        albumsListView.setAdapter(adapter);
        //Set a click listener on that View
        albumsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                //Create a new intent to open Albums1Activity
                Intent nowPlayingIntent = new Intent(AlbumsActivity.this, Album1Activity.class);
                //Start the new activity
                startActivity(nowPlayingIntent);
            }
        });
    }
}