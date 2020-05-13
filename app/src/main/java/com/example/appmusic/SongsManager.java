package com.example.appmusic;

import android.annotation.SuppressLint;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class SongsManager {
    final String MEDIA_PATH = new String("/sdcard/Download/");
    public ArrayList<HashMap<String, String>> arraySong = new ArrayList<HashMap<String, String>>();

    @SuppressLint("SdCardPath")
    public ArrayList<HashMap<String, String>> arraySong() {
        File file = new File(MEDIA_PATH);
        File[] list = file.listFiles();

        if (list !=null) {
            for (File value : list) {
                if (value.getName().endsWith(".mp3")) {
                    HashMap<String, String> songMap = new HashMap<String, String>();
                    songMap.put("songTitle", value.getName().substring(0, (value.getName().length() - 4)));
                    songMap.put("songPath", value.getPath());
                    arraySong.add(songMap);
                }
            }
        } else {
            HashMap<String, String> songMap = new HashMap<String, String>();
            songMap.put("songTitle", "Error");
            songMap.put("songPath", null);
            arraySong.add(songMap);
        }
        return arraySong;
    }
}

