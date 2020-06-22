package activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.appmusic.R;

import java.util.ArrayList;

import adapter.DanhSachTatCaChuDeAdapter;
import adapter.DanhSachTheLoaiTheoChuDeAdapter;
import model.ChuDe;
import model.TheLoai;

import static adapter.DanhSachTatCaChuDeAdapter.*;

public class DanhSachTheLoaiTheoChuDeActivity extends AppCompatActivity {
    ChuDe chuDe;
    TheLoai theLoai;

    RecyclerView recyclerViewDSTheLoaiTheChuDe;
    Toolbar toolBarDanhSachTheLoaiTheChuDe;

    ArrayList<TheLoai> theLoaiArrayList;

    DanhSachTheLoaiTheoChuDeAdapter danhSachTheLoaiTheoChuDeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_the_loai_theo_chu_de);
        GetIntent();

        anhXa();
        init();
        
        getData();

    }

    private void getData() {
        theLoaiArrayList = new ArrayList<>();

        Intent intent = getIntent();

        if (intent.hasExtra("item")) {
            if (intent.getStringExtra("item").equals("Acoustic")) {
                theLoaiArrayList.add(theLoai = new TheLoai("Acoustic 1", R.drawable.dance_theloai));
                theLoaiArrayList.add(theLoai = new TheLoai("Acoustic 2", R.drawable.edm_theloai));
            } else if (intent.getStringExtra("item").equals("EDM")) {
                theLoaiArrayList.add(theLoai = new TheLoai("EDM 1", R.drawable.dance_theloai));
                theLoaiArrayList.add(theLoai = new TheLoai("EDM 2", R.drawable.edm_theloai));
            } else if (intent.getStringExtra("item").equals("Nữ thần Ariana Grande")) {
                theLoaiArrayList.add(theLoai = new TheLoai("Nữ thần Ariana Grande 1", R.drawable.dance_theloai));
                theLoaiArrayList.add(theLoai = new TheLoai("Nữ thần Ariana Grande 2", R.drawable.edm_theloai));
            } else if (intent.getStringExtra("item").equals("Ca khúc ngày mưa")) {
                theLoaiArrayList.add(theLoai = new TheLoai("Ca khúc ngày mưa 1", R.drawable.dance_theloai));
                theLoaiArrayList.add(theLoai = new TheLoai("Ca khúc ngày mưa 2", R.drawable.edm_theloai));
            } else if (intent.getStringExtra("item").equals("Yêu là chân ái")) {
                theLoaiArrayList.add(theLoai = new TheLoai("Yêu là chân ái 1", R.drawable.dance_theloai));
                theLoaiArrayList.add(theLoai = new TheLoai("Yêu là chân ái 2", R.drawable.edm_theloai));
            } else if (intent.getStringExtra("item").equals("Dance Pop")) {
                theLoaiArrayList.add(theLoai = new TheLoai("Dance Pop 1", R.drawable.dance_theloai));
                theLoaiArrayList.add(theLoai = new TheLoai("Dance Pop 2", R.drawable.edm_theloai));
            } else if (intent.getStringExtra("item").equals("Thập niên")) {
                theLoaiArrayList.add(theLoai = new TheLoai("Thập niên 1", R.drawable.dance_theloai));
                theLoaiArrayList.add(theLoai = new TheLoai("Thập niên 2", R.drawable.edm_theloai));
            } else if (intent.getStringExtra("item").equals("Music for love")) {
                theLoaiArrayList.add(theLoai = new TheLoai("Music for love 1", R.drawable.dance_theloai));
                theLoaiArrayList.add(theLoai = new TheLoai("Music for love 2", R.drawable.edm_theloai));
            }
        }
        danhSachTheLoaiTheoChuDeAdapter = new DanhSachTheLoaiTheoChuDeAdapter(DanhSachTheLoaiTheoChuDeActivity.this,
                theLoaiArrayList);

        recyclerViewDSTheLoaiTheChuDe.setLayoutManager(new GridLayoutManager(DanhSachTheLoaiTheoChuDeActivity.this,
                2));
        recyclerViewDSTheLoaiTheChuDe.setAdapter(danhSachTheLoaiTheoChuDeAdapter);
    }

    private void anhXa() {
        recyclerViewDSTheLoaiTheChuDe = (RecyclerView) findViewById(R.id.recyclerViewDSTheLoaiTheChuDe);
        toolBarDanhSachTheLoaiTheChuDe = (Toolbar) findViewById(R.id.toolBarDanhSachTheLoaiTheChuDe);
    }

    private void init() {
        setSupportActionBar(toolBarDanhSachTheLoaiTheChuDe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(chuDe.getTenChuDe());

        toolBarDanhSachTheLoaiTheChuDe.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void GetIntent() {
        Intent intent = getIntent();

        if (intent.hasExtra("chuDe")) {
            chuDe = (ChuDe) intent.getSerializableExtra("chuDe");
        }
    }
}