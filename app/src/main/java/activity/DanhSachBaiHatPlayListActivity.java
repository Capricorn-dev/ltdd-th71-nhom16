package activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.R;

import java.util.ArrayList;

import adapter.DanhSachBaiHatPlaylistAdapter;
import model.Playlist;

public class DanhSachBaiHatPlayListActivity extends AppCompatActivity {
    Toolbar toolBarDanhSachPlaylist;
    RecyclerView recyclerViewDSBaiHatPlayList;

    ArrayList<Playlist> playlistArrayList;

    DanhSachBaiHatPlaylistAdapter danhSachBaiHatPlaylistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_bai_hat_play_list);
        
        anhXa();
        
        initActionBar();
        getData();
    }

    private void getData() {
        playlistArrayList = new ArrayList<>();

        playlistArrayList.add(new Playlist("Hôm nay nghe gì?", R.drawable.pic1_playlist, R.drawable.pic1_playlist_1));
        playlistArrayList.add(new Playlist("Tiệc tùng cuối tuần", R.drawable.pic2_playlist, R.drawable.pic2_playlist_2));
        playlistArrayList.add(new Playlist("Âm nhạc độc quyền", R.drawable.pic3_playlist, R.drawable.pic3_playlist_3));

        playlistArrayList.add(new Playlist("Hôm nay nghe gì?", R.drawable.pic1_playlist, R.drawable.pic1_playlist_1));
        playlistArrayList.add(new Playlist("Tiệc tùng cuối tuần", R.drawable.pic2_playlist, R.drawable.pic2_playlist_2));
        playlistArrayList.add(new Playlist("Âm nhạc độc quyền", R.drawable.pic3_playlist, R.drawable.pic3_playlist_3));
        playlistArrayList.add(new Playlist("Hôm nay nghe gì?", R.drawable.pic1_playlist, R.drawable.pic1_playlist_1));
        playlistArrayList.add(new Playlist("Tiệc tùng cuối tuần", R.drawable.pic2_playlist, R.drawable.pic2_playlist_2));
        playlistArrayList.add(new Playlist("Âm nhạc độc quyền", R.drawable.pic3_playlist, R.drawable.pic3_playlist_3));

        danhSachBaiHatPlaylistAdapter = new DanhSachBaiHatPlaylistAdapter(DanhSachBaiHatPlayListActivity.this,
                this.playlistArrayList);
        recyclerViewDSBaiHatPlayList.setLayoutManager(new GridLayoutManager(DanhSachBaiHatPlayListActivity.this,
                2));
        recyclerViewDSBaiHatPlayList.setAdapter(danhSachBaiHatPlaylistAdapter);
    }

    private void initActionBar() {
        setSupportActionBar(toolBarDanhSachPlaylist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Playlist");
        toolBarDanhSachPlaylist.setTitleTextColor(Color.rgb(140, 25, 85));
        toolBarDanhSachPlaylist.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void anhXa() {
        toolBarDanhSachPlaylist = (Toolbar) findViewById(R.id.toolBarDanhSachPlaylist);
        recyclerViewDSBaiHatPlayList = (RecyclerView) findViewById(R.id.recyclerViewDSBaiHatPlayList);
    }
}