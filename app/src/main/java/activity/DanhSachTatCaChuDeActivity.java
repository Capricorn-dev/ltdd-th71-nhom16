package activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.appmusic.R;

import java.util.ArrayList;

import adapter.DanhSachTatCaChuDeAdapter;
import model.ChuDe;

public class DanhSachTatCaChuDeActivity extends AppCompatActivity {
    Toolbar toolBarDanhSachTatCaChuDe;
    RecyclerView recyclerViewDSTatCaChuDe;

    ChuDe chuDe;
    ArrayList<ChuDe> chuDeArrayList;
    DanhSachTatCaChuDeAdapter danhSachTatCaChuDeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_tat_ca_chu_de);
        
        anhXa();
        init();
        
        getData();
    }

    private void getData() {
        chuDeArrayList = new ArrayList<>();

        chuDeArrayList.add(chuDe = new ChuDe("Acoustic", R.drawable.acoustic_chude));
        chuDeArrayList.add(chuDe = new ChuDe("EDM", R.drawable.thapnien_chude));
        chuDeArrayList.add(chuDe = new ChuDe("Music for love", R.drawable.love_chude));
        chuDeArrayList.add(chuDe = new ChuDe("Music for love", R.drawable.love_chude));
        chuDeArrayList.add(chuDe = new ChuDe("Music for love", R.drawable.love_chude));
        chuDeArrayList.add(chuDe = new ChuDe("Music for love", R.drawable.love_chude));
        chuDeArrayList.add(chuDe = new ChuDe("Music for love", R.drawable.love_chude));
        chuDeArrayList.add(chuDe = new ChuDe("Music for love", R.drawable.love_chude));

        danhSachTatCaChuDeAdapter = new DanhSachTatCaChuDeAdapter(DanhSachTatCaChuDeActivity.this,
                chuDeArrayList);

        recyclerViewDSTatCaChuDe.setLayoutManager(new GridLayoutManager(DanhSachTatCaChuDeActivity.this,
                1));
        recyclerViewDSTatCaChuDe.setAdapter(danhSachTatCaChuDeAdapter);
    }

    private void init() {
        setSupportActionBar(toolBarDanhSachTatCaChuDe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất cả chủ đề");

        toolBarDanhSachTatCaChuDe.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void anhXa() {
        toolBarDanhSachTatCaChuDe = (Toolbar) findViewById(R.id.toolBarDanhSachTatCaChuDe);
        recyclerViewDSTatCaChuDe = (RecyclerView) findViewById(R.id.recyclerViewDSTatCaChuDe);
    }
}