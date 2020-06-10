package com.example.appmusic.Personal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.appmusic.PlayerActivity;
import com.example.appmusic.R;

import java.util.ArrayList;

import adapter.ItemAdapter;

public class Album1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        //Create a list of items in first album
        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("What They Say", "Zara Larsson"));

        items.add(new Item("Lush Life", "Zara Larsson"));

        items.add(new Item("I Would Like", "Zara Larsson"));

        items.add(new Item("So Good", "Zara Larsson"));

        items.add(new Item("TG4M", "Zara Larsson"));

        items.add(new Item("Only You", "Zara Larsson"));

        items.add(new Item("Never Forget You", "Zara Larsson"));

        items.add(new Item("Sundown", "Zara Larsson"));

        items.add(new Item("Don't Let Me Be Yours", "Zara Larsson"));

        items.add(new Item("Make That Money Girl", "Zara Larsson"));

        items.add(new Item("Ain't My Fault", "Zara Larsson"));

        items.add(new Item("One Mississippi", "Zara Larsson"));

        items.add(new Item("Funeral", "Zara Larsson"));

        items.add(new Item("I Can't Fall In Love Without You", "Zara Larsson"));

        items.add(new Item("Symphony", "Zara Larsson"));

        //Create a link to ItemAdapter, has data of Item
        ItemAdapter adapter = new ItemAdapter(this, items);
        //ListView
        final ListView album1ListView = (ListView) findViewById(R.id.list);
        //Set Adapter
        album1ListView.setAdapter(adapter);
        //Set a click listener on that view
        album1ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Start the PlayerActivity
                Item selectedItem = (Item) album1ListView.getItemAtPosition(position);
                Intent PlayingIntent = new Intent(Album1Activity.this, PlayerActivity.class);
                PlayingIntent.putExtra("FIRSTLINE", selectedItem.getmFirstLine());
                PlayingIntent.putExtra("SECONDLINE", selectedItem.getmSecondLine());
                startActivity(PlayingIntent);
            }
        });
    }
}