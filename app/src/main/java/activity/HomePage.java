package activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.appmusic.R;
import com.google.android.material.tabs.TabLayout;

import adapter.MainViewFragmentAdapter;
import fragment.Fragment_Ca_Nhan;
import fragment.Fragment_The_Loai;
import fragment.Fragment_Thu_Vien;
import fragment.Fragment_Trang_Chu;

public class HomePage extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        
        andXa();
        init();
    }

    private void init() {
        MainViewFragmentAdapter adapter = new MainViewFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_Trang_Chu(), "Trang chủ");
        adapter.addFragment(new Fragment_The_Loai(), "Thể loại");
        adapter.addFragment(new Fragment_Thu_Vien(), "Thư viện");
        adapter.addFragment(new Fragment_Ca_Nhan(), "Cá nhân");

        viewPager.setAdapter(adapter);
        tabLayout.getTabAt(0).setIcon(R.drawable.homepage);
        tabLayout.getTabAt(1).setIcon(R.drawable.category);
        tabLayout.getTabAt(2).setIcon(R.drawable.libary);
        tabLayout.getTabAt(3).setIcon(R.drawable.personal);
    }

    private void andXa() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }


}
