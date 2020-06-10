package com.example.appmusic.Personal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.appmusic.Personal.AlbumsActivity;
import com.example.appmusic.PlayListActivity;
import com.example.appmusic.R;

public class PersonalPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_page);
        //Albums category
        ImageView albums =  (ImageView) findViewById(R.id.imgalbums);
        //Set a click
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Albums category is clicked on.
            @Override
            public void onClick(View view) {
                //Create intent to open AlbumsActivity
                Intent albumsIntent = new Intent(PersonalPage.this, AlbumsActivity.class);
                //Start the new activity
                startActivity(albumsIntent);
            }
        });

        //Artist category
        ImageView artist =  (ImageView) findViewById(R.id.imgartist);
        //Set a click
        artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create intent to open ArtistsActivity
                Intent artistIntent = new Intent(PersonalPage.this, ArtistsActivity.class);
                //Start the new activity
                startActivity(artistIntent);
            }
        });

        //Playlist category
        ImageView playlist =  (ImageView) findViewById(R.id.imgplaylist);
        //Set a click
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create intent to open PlaylistActivty
                Intent playlistIntent = new Intent(PersonalPage.this, PlayListActivity.class);
                //Start the new activity
                startActivity(playlistIntent);
            }
        });

        //Tracks category
        ImageView tracks =  (ImageView) findViewById(R.id.imgtracks);
        //Set a click
        tracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create intent to open TracksActivity
                Intent tracksIntent = new Intent(PersonalPage.this, PlayListActivity.class);
                //Start the new activity
                startActivity(tracksIntent);
            }
        });
    }
}