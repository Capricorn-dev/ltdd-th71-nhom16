package activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import adapter.DanhSachBaiHatAdapter;
import model.Album;
import model.Playlist;
import model.Song;
import model.TheLoai;
import model.songBanner;

public class DanhSachBaiHatActivity extends AppCompatActivity {
    songBanner songBanner;

    CoordinatorLayout coordinatorLayoutDsBaiHat;
    CollapsingToolbarLayout collapsingToolbarLayout;
    androidx.appcompat.widget.Toolbar toolBarDanhSach;
    ImageView imgViewDanhSachCaKhuc;
    FloatingActionButton floatingActionButtonDsBaiHat;
    RecyclerView recyclerViewDSBaiHat;

    ArrayList<Song> songArrayList;

    DanhSachBaiHatAdapter danhSachBaiHatAdapter;
    Playlist playlist;

    TheLoai theLoai;
    Album album;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_bai_hat);

        anhXa();
        DataIntent();

        init();

        if (songBanner != null && !songBanner.getTitle().equals("")) {
            setValueView(songBanner.getTitle(), songBanner.getPicture());
            getDataBanner(songBanner.getTitle(), songBanner.getPicture(), songBanner.getDescription(), songBanner.getLinkSong());
        }


        if (playlist != null && !playlist.getName().equals("")) {
            setValueView(playlist.getName(), playlist.getIcon());

            getDataPlaylist(playlist.getName());
        }

        if (theLoai != null && !theLoai.getTenTheLoai().equals("")) {
            setValueView(theLoai.getTenTheLoai(), theLoai.getHinhTheLoai());
            getDataTheLoai(theLoai.getTenTheLoai());
        }

        if (album != null && !album.getTenAlbum().equals("")) {
            setValueView(album.getTenAlbum(), album.getHinhAlbum());
            getDataAlbum(album.getTenAlbum());
        }
    }

    private void getDataAlbum(String tenAlbum) {
        songArrayList = new ArrayList<>();

        if (tenAlbum.equals("Blank Space")) {
            songArrayList.add(new Song("Blank Space", R.drawable.pic1_album, "Taylor Swift", R.drawable.acoustic_chude));
        } else if (tenAlbum.equals("Crush")) {
            songArrayList.add(new Song("Crush", R.drawable.pic2_album, "Tessa Violet", R.drawable.acoustic_chude));
        } else if (tenAlbum.equals("Sweet But Psycho")) {
            songArrayList.add(new Song("Sweet But Psycho", R.drawable.pic3_album, "Ava Max", R.drawable.acoustic_chude));
        }

        danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this,
                this.songArrayList);

        recyclerViewDSBaiHat.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
        recyclerViewDSBaiHat.setAdapter(danhSachBaiHatAdapter);
    }

    private void getDataTheLoai(String name) {
        songArrayList = new ArrayList<>();

        if (name.equals("R & B")) {
            songArrayList.add(new Song("R & B", R.drawable.acoustic_chude, "singerName", R.drawable.acoustic_chude));
        } else if (name.equals("Acoustic Pop")) {
            songArrayList.add(new Song("Acoustic Pop", R.drawable.acoustic_chude, "singerName", R.drawable.acoustic_chude));
        } else if (name.equals("Dance Pop")) {
            songArrayList.add(new Song("Dance Pop", R.drawable.acoustic_chude, "singerName", R.drawable.acoustic_chude));
        }

        danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this,
                this.songArrayList);

        recyclerViewDSBaiHat.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
        recyclerViewDSBaiHat.setAdapter(danhSachBaiHatAdapter);

    }

    private void getDataPlaylist(String position) {
        songArrayList = new ArrayList<>();

        if (position.equals("Hôm nay nghe gì?")) {
            songArrayList.add(new Song("Hôm nay nghe gì", R.drawable.acoustic_chude, "singerName", R.drawable.acoustic_chude));
        } else if (position.equals("Tiệc tùng cuối tuần")) {
            songArrayList.add(new Song("Tiệc tùng cuối tuần", R.drawable.acoustic_chude, "singerName", R.drawable.acoustic_chude));
        } else if (position.equals("Âm nhạc độc quyền")) {
            songArrayList.add(new Song("Âm nhạc độc quyền", R.drawable.acoustic_chude, "singerName", R.drawable.acoustic_chude));
        }

        danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this,
                this.songArrayList);

        recyclerViewDSBaiHat.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
        recyclerViewDSBaiHat.setAdapter(danhSachBaiHatAdapter);
    }

    private void getDataBanner(String title, int picture, String singerName, int linkSong) {
        songArrayList = new ArrayList<>();
        songArrayList.add(new Song(title, picture, singerName, linkSong));

        danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this,
                this.songArrayList);

        recyclerViewDSBaiHat.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
        recyclerViewDSBaiHat.setAdapter(danhSachBaiHatAdapter);
    }

    private void setValueView(String name, int picture) {
        collapsingToolbarLayout.setTitle(name);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), picture);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);

        collapsingToolbarLayout.setBackground(bitmapDrawable);

        Picasso.with(this).load(picture).into(imgViewDanhSachCaKhuc);
    }

    private void init() {
        setSupportActionBar(toolBarDanhSach);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBarDanhSach.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
    }

    private void anhXa() {
        coordinatorLayoutDsBaiHat = (CoordinatorLayout) findViewById(R.id.coordinatorLayoutDsBaiHat);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        toolBarDanhSach = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolBarDanhSach);
        imgViewDanhSachCaKhuc = (ImageView) findViewById(R.id.imgViewDanhSachCaKhuc);
        floatingActionButtonDsBaiHat = (FloatingActionButton) findViewById(R.id.floatingActionButtonDsBaiHat);
        recyclerViewDSBaiHat = (RecyclerView) findViewById(R.id.recyclerViewDSBaiHat);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("banner")) {
                songBanner = (songBanner)  intent.getSerializableExtra("banner");
            }

            if (intent.hasExtra("itemPlaylist")) {
                playlist = (Playlist) intent.getSerializableExtra("itemPlaylist");
            }

            if (intent.hasExtra("theLoai")) {
                theLoai = (TheLoai) intent.getSerializableExtra("theLoai");
            }

            if (intent.hasExtra("album")) {
                album = (Album) intent.getSerializableExtra("album");
            }
        }
    }
}