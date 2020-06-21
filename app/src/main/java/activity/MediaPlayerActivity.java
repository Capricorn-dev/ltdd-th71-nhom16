package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.appmusic.R;

import java.util.ArrayList;

import model.Song;

public class MediaPlayerActivity extends AppCompatActivity {
    Song song;
    ArrayList<Song> songArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        Intent intent = getIntent();

        if (intent.hasExtra("song")) {
            song = intent.getParcelableExtra("song");

            Toast.makeText(MediaPlayerActivity.this, song.getSongName().toString(), Toast.LENGTH_SHORT).show();
        }

        if (intent.hasExtra("allSong")) {
            songArrayList = intent.getParcelableArrayListExtra("allSong");

            for (int i = 0; i < songArrayList.size(); i++) {
                Log.d("aaaa", songArrayList.get(i).getSongName());
            }
        }
    }
}