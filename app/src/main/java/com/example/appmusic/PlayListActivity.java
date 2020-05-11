package com.example.appmusic;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import fragment.Fragment_Trinh_Phat;

public class PlayListActivity extends AppCompatActivity {
    public ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
    private ArrayList<HashMap<String, String>> songsListData = new ArrayList<HashMap<String, String>>();
    private ArrayAdapter<String> arrayAdapter;
    private SimpleAdapter arr;
    private SimpleAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);

        SongsManager plm = new SongsManager();
        songsList = plm.arraySong();
        EditText searchBar = (EditText) findViewById(R.id.search);
        final ListView lv = (ListView) findViewById(R.id.listview);

        songsListData.addAll(songsList);
        adapter = new SimpleAdapter(this, songsListData,
                R.layout.playlist_item, new String[]{"songTitle"}, new int[]{
                R.id.songTitle});
        lv.setAdapter(adapter);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(final CharSequence s, int start, int before, int count) {
                 PlayListActivity.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent in = new Intent(getApplicationContext(), Fragment_Trinh_Phat.class);
                in.putExtra("songIndex", position);
                setResult(100, in);
                finish();
            }
        });

    }
}