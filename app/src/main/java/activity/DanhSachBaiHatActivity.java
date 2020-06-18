package activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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
import model.Song;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_bai_hat);

        anhXa();
        DataIntent();

        init();

        if (songBanner != null && !songBanner.getTitle().equals("")) {
            setValueView(songBanner.getTitle(), songBanner.getPicture());
            GetDataBanner(songBanner.getTitle(), songBanner.getPicture(), songBanner.getDescription());
        }
    }

    private void GetDataBanner(String title, int picture, String singerName) {
        songArrayList = new ArrayList<>();
        songArrayList.add(new Song(title, picture, singerName, R.drawable.acoustic_chude));

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
                Toast.makeText(this, songBanner.getTitle(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}