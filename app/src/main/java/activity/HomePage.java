package activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.appmusic.PlayerActivity;
import com.example.appmusic.R;
import com.google.android.material.tabs.TabLayout;

import adapter.MainViewFragmentAdapter;
import fragment.Fragment_Ca_Nhan;
import fragment.Fragment_Thu_Vien;
import fragment.Fragment_Trang_Chu;
import fragment.Fragment_Trinh_Phat;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class HomePage extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        andXa();
        init();
        requestPermission();
    }

    private void init() {
        MainViewFragmentAdapter adapter = new MainViewFragmentAdapter(getSupportFragmentManager());

        adapter.addFragment(new Fragment_Trang_Chu(), "Trang chủ");
        adapter.addFragment(new Fragment_Trinh_Phat(), "Trình phát nhạc");
        adapter.addFragment(new Fragment_Thu_Vien(), "Thư viện bài hát");
        adapter.addFragment(new Fragment_Ca_Nhan(), "Cá nhân");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.player);
        tabLayout.getTabAt(2).setIcon(R.drawable.libary);
        tabLayout.getTabAt(3).setIcon(R.drawable.personal);
    }

    private void andXa() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }
    /**
     * Hàm xin cấp quyền truy cập SDcard
     **/
    private void requestPermission(){
        int requestPermissionCode = 1;
        ActivityCompat.requestPermissions(HomePage.this, new
                String[]{READ_EXTERNAL_STORAGE}, requestPermissionCode);
    }


    /**
     * Hàm kiểm tra việc cấp quyền truy cập SDcard
     **/
    public boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;

    }


}
