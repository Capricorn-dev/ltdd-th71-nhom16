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

import adapter.DanhSachTheLoaiTheoChuDeAdapter;
import model.ChuDe;
import model.TheLoai;

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

        theLoaiArrayList.add(theLoai = new TheLoai("R & B", R.drawable.dance_theloai));
        theLoaiArrayList.add(theLoai = new TheLoai("Acoustic Pop", R.drawable.edm_theloai));
        theLoaiArrayList.add(theLoai = new TheLoai("Dance Pop", R.drawable.dancepop_theloai));

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