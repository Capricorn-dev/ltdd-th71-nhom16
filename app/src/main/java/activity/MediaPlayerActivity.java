package activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmusic.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import adapter.ViewPagerMediaPlayer;
import fragment.Fragment_Dia_Nhac;
import fragment.Fragment_MediaPlayer_Playlist;
import model.Song;

public class MediaPlayerActivity extends AppCompatActivity {
    Song song;
    ArrayList<Song> songArrayList;

    Toolbar toolBarMediaPlayer;
    ViewPager viewPagerMediaPlayer;

    ImageButton btnRepeat, btnShuffle;

    TextView txtViewCurrentDuration, txtViewTotalDuration;
    SeekBar seekBarSong;

    ImageButton btnPrevious, btnBackward, btnPlay, btnForward, btnNext;

    public static ArrayList<Song> mediaPlayerArrayList = new ArrayList<>();

    public static ViewPagerMediaPlayer viewPagerMediaPlayerAdapter;

    Fragment_Dia_Nhac fragment_dia_nhac;
    Fragment_MediaPlayer_Playlist fragment_mediaPlayer_playlist;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        getDataFromIntent();

        anhXa();
        init();

//        eventClick();
    }

//    private void eventClick() {
//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (viewPagerMediaPlayerAdapter.getItem(1) != null) {
//                    if (songArrayList.size() > 0) {
//                        fragment_dia_nhac.changeRecordBackGround(songArrayList.get(0).getPicture());
//                        handler.removeCallbacks(this);
//                    } else {
//                        handler.postDelayed(this, 300);
//                    }
//                }
//            }
//        },500);
//
//        btnPlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mediaPlayer.isPlaying()) {
//                    mediaPlayer.pause();
//                    btnPlay.setImageResource(R.drawable.btn_play);
//                } else {
//                    mediaPlayer.start();
//                    btnPlay.setImageResource(R.drawable.btn_pause);
//                }
//            }
//        });
//    }

//    class playMp3 extends AsyncTask<Integer, Void, Integer> {
//
//        @Override
//        protected Integer doInBackground(Integer... integers) {
//            return integers[0];
//        }
//
//        @Override
//        protected void onPostExecute(Integer song) {
//            super.onPostExecute(song);
//            try {
//                mediaPlayer = new MediaPlayer();
////                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mp) {
//                        mediaPlayer.stop();
//                        mediaPlayer.reset();
//                    }
//                });
//
//                mediaPlayer.setDataSource(String.valueOf(song));
//                mediaPlayer.prepare();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            mediaPlayer.start();
//            SetTimeTotal();
//        }
//    }

    private void SetTimeTotal() {
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        txtViewTotalDuration.setText(format.format(mediaPlayer.getDuration()));
        seekBarSong.setMax(mediaPlayer.getDuration());
    }

    private void getDataFromIntent() {

        Intent intent = getIntent();
        mediaPlayerArrayList.clear();

        if (intent != null) {
            if (intent.hasExtra("song")) {
                song = intent.getParcelableExtra("song");
                mediaPlayerArrayList.add(song);
            }

            if (intent.hasExtra("allSong")) {
                songArrayList = intent.getParcelableArrayListExtra("allSong");

                mediaPlayerArrayList = songArrayList;
            }
        }
    }

    private void init() {
        setSupportActionBar(toolBarMediaPlayer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBarMediaPlayer.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolBarMediaPlayer.setTitleTextColor(Color.BLACK);

        fragment_dia_nhac = new Fragment_Dia_Nhac();
        fragment_mediaPlayer_playlist = new Fragment_MediaPlayer_Playlist();

        viewPagerMediaPlayerAdapter = new ViewPagerMediaPlayer(getSupportFragmentManager());
        viewPagerMediaPlayerAdapter.addFragment(fragment_mediaPlayer_playlist);
        viewPagerMediaPlayerAdapter.addFragment(fragment_dia_nhac);

        viewPagerMediaPlayer.setAdapter(viewPagerMediaPlayerAdapter);

//        songArrayList = new ArrayList<>();
//        mediaPlayer = new MediaPlayer();
//
//        fragment_dia_nhac = (Fragment_Dia_Nhac) viewPagerMediaPlayerAdapter.getItem(1);
//        if (songArrayList.size() > 0) {
//            getSupportActionBar().setTitle(songArrayList.get(0).getSongName());
//            new playMp3().execute(songArrayList.get(0).getSongLink());
//            btnPlay.setImageResource(R.drawable.btn_pause);
//        }
    }

    private void anhXa() {
        toolBarMediaPlayer = (Toolbar) findViewById(R.id.toolBarMediaPlayer);
        viewPagerMediaPlayer = (ViewPager) findViewById(R.id.viewPagerMediaPlayer);

        btnRepeat = (ImageButton) findViewById(R.id.btnRepeat);
        btnShuffle = (ImageButton) findViewById(R.id.btnShuffle);

        txtViewCurrentDuration = (TextView) findViewById(R.id.txtViewCurrentDuration);
        txtViewTotalDuration = (TextView) findViewById(R.id.txtViewTotalDuration);

        seekBarSong = (SeekBar) findViewById(R.id.seekBarSong);

        btnPrevious = (ImageButton) findViewById(R.id.btnPrevious);
        btnBackward = (ImageButton) findViewById(R.id.btnBackward);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        btnForward = (ImageButton) findViewById(R.id.btnForward);
        btnNext = (ImageButton) findViewById(R.id.btnNext);
    }
}