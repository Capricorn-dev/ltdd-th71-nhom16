package com.example.appmusic;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Random;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class PlayerActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {
    ImageView cdDisc;
    Animation animation;
    private ImageButton btnPlay;
    private ImageButton btnForward;
    private ImageButton btnBackward;
    private ImageButton btnNext;
    private ImageButton btnPrevious;
    private ImageButton btnPlaylist;
    private ImageButton btnRepeat;
    private ImageButton btnShuffle;
    private SeekBar     songProgressBar;
    private TextView    songTitleLabel;
    private TextView    songCurrentDurationLabel;
    private TextView    songTotalDurationLabel;
    private SongsManager songsManager;
    boolean isRepeat        = false;
    boolean isShuffle       = false;
    int position            = 0;
    int forwardTime         = 10000;
    int backwardTime        = 10000;
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        /**
         * Hàm lấy ID của các phần tử
         **/
        anhXa();

        songsManager = new SongsManager();
        SetDataSource(position);
        mediaPlayer.setOnCompletionListener(this);


        /**
         * Bắt đầu phát nhạc
         **/
        btnPlayOnClickListener();

        /**
         * Chuyển bài hát tiếp theo
         * Nếu đi đến cuối danh sách phát thì phát bài hát đầu tiên
         **/
        btnNextOnClickListener();

        /**
         * Quay lại bài hát trước đó
         * Nếu đi đến đầu danh sách phát thì phát bài hát cuối cùng
         **/
        btnPreviousOnClickListener();

        /**
         * Lặp lại bài hát đang phát
         **/
        btnRepeatOnClickListener();

        /**
         * Phát ngẫu nhiên bài hát
         **/
        btnShuffleOnClickListener();

        /**
         * Tiến trình chạy bài hát
         **/
        songProgressBarOnSeekBarChangeListener();

    }

    private void songProgressBarOnSeekBarChangeListener() {
        songProgressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(songProgressBar.getProgress());
            }
        });
    }

    private void btnShuffleOnClickListener() {
        btnShuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShuffle) {
                    isShuffle = false;
                    Toast.makeText(getApplicationContext(), "Shuffle is OFF", Toast.LENGTH_SHORT).show();
                    btnShuffle.setImageResource(R.drawable.btn_shuffle);
                } else {
                    // make repeat to true
                    isShuffle= true;
                    Toast.makeText(getApplicationContext(), "Shuffle is ON", Toast.LENGTH_SHORT).show();
                    // make shuffle to false
                    isRepeat = false;
                    btnShuffle.setImageResource(R.drawable.shuffle_press);
                    btnRepeat.setImageResource(R.drawable.repeat);
                }
            }
        });
    }



        /**
         * Tua nhanh 10s
         **/
        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                if (currentPosition + forwardTime <= mediaPlayer.getDuration()){
                    mediaPlayer.seekTo(currentPosition + forwardTime);
                }else {
                    mediaPlayer.seekTo(mediaPlayer.getDuration());
                }
            }
        });


        /**
         * Tua lùi 10s
         **/
        btnBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                if (currentPosition - backwardTime >= 0){
                    mediaPlayer.seekTo(currentPosition - backwardTime);
                }else {
                    mediaPlayer.seekTo(0);
                }
            }
        });



        /**
         * Tiến trình chạy bài hát
         **/
        songProgressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


    private void btnRepeatOnClickListener() {
        btnRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRepeat) {
                    isRepeat = false;
                    Toast.makeText(getApplicationContext(), "Repeat is OFF", Toast.LENGTH_SHORT).show();
                    btnRepeat.setImageResource(R.drawable.btn_repeat);
                } else {
                    isRepeat = true;
                    isShuffle = false;
                    Toast.makeText(getApplicationContext(), "Repeat is ON", Toast.LENGTH_SHORT).show();
                    btnRepeat.setImageResource(R.drawable.repeat_press);
                    btnShuffle.setImageResource(R.drawable.shuffle);
                }
            }
        });
    }

    private void btnPreviousOnClickListener() {
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                if (position < 0) {
                    position = songsManager.arraySong().size()-1;
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                SetDataSource(position);
                mediaPlayer.start();
                SetTimeTotal();
            }
        });
    }

    private void btnNextOnClickListener() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if (position > songsManager.arraySong().size()-1){
                    position = 0;
                }
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                SetDataSource(position);
                mediaPlayer.start();
                SetTimeTotal();
            }
        });
    }

    private void btnPlayOnClickListener() {
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission()) {
                    if(mediaPlayer.isPlaying()) {
                        if(mediaPlayer != null)
                        {
                            mediaPlayer.pause();
                            btnPlay.setImageResource(R.drawable.btn_play);
                            cdDisc.clearAnimation();
                        }
                    }
                    else {
                        if(mediaPlayer != null) {
                            mediaPlayer.start();
                            cdDisc.startAnimation(animation);
                            btnPlay.setImageResource(R.drawable.btn_pause);
                            SetTimeTotal();
                            UpdateTimeSong();
                        }
                    }
                }
                else {
                    requestPermission();
                }
            }
        });
    }

    /**
     * Hàm lấy ID của các phần tử
     **/
    @SuppressLint("ResourceType")
    private void anhXa() {
        cdDisc                   = (ImageView) findViewById(R.id.cdDisc);
        btnPlay                  = (ImageButton) findViewById(R.id.btnPlay);
        btnForward               = (ImageButton) findViewById(R.id.btnForward);
        btnBackward              = (ImageButton) findViewById(R.id.btnBackward);
        btnNext                  = (ImageButton) findViewById(R.id.btnNext);
        btnPrevious              = (ImageButton) findViewById(R.id.btnPrevious);
        btnPlaylist              = (ImageButton) findViewById(R.id.btnPlaylist);
        btnRepeat                = (ImageButton) findViewById(R.id.btnRepeat);
        btnShuffle               = (ImageButton) findViewById(R.id.btnShuffle);
        songProgressBar          = (SeekBar) findViewById(R.id.songProgressBar);
        songTitleLabel           = (TextView) findViewById(R.id.songTitle);
        songCurrentDurationLabel = (TextView) findViewById(R.id.songCurrentDurationLabel);
        songTotalDurationLabel   = (TextView) findViewById(R.id.songTotalDurationLabel);
        animation                = AnimationUtils.loadAnimation(this,R.animator.disc_rotate);
    }


    /**
     * Hàm xin cấp quyền truy cập SDcard
     **/
    private void requestPermission(){
        int requestPermissionCode = 1;
        ActivityCompat.requestPermissions(PlayerActivity.this, new
                String[]{READ_EXTERNAL_STORAGE}, requestPermissionCode);
    }


    /**
     * Hàm kiểm tra việc cấp quyền truy cập SDcard
     **/
    public boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;

    }


    /**
     * Hàm lấy vị trí phát nhạc và setDataSource cho MediaPlayer
     **/
    public void  SetDataSource(int songIndex){
        try{
            mediaPlayer.reset();
            mediaPlayer.setDataSource(songsManager.arraySong().get(songIndex).get("songPath"));
            songTitleLabel.setText(songsManager.arraySong().get(position).get("songTitle"));
            mediaPlayer.prepare();
        } catch (IllegalArgumentException | IllegalStateException | IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Thiết lập độ dài của bài hát
     **/
    private void SetTimeTotal() {
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        songTotalDurationLabel.setText(format.format(mediaPlayer.getDuration()));
        songProgressBar.setMax(mediaPlayer.getDuration());
    }


    /**
     * Hiển thị tiến trình của bài hát đang phát
     **/
    private void UpdateTimeSong() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat format = new SimpleDateFormat("mm:ss");
                songCurrentDurationLabel.setText(format.format(mediaPlayer.getCurrentPosition()));
                songProgressBar.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this,500);
            }
        },100);
    }


    /**
     * Kiểm tra bài hát phát hết chưa
     * Nếu nút Repeat bật thì phát lặp lại
     * Nếu nút Shuffle bật thì phát trộn bài ngẫu nhiên
     **/
    @Override
    public void onCompletion(MediaPlayer arg0) {
        if(isRepeat){
            SetDataSource(position);
            mediaPlayer.start();
        }else if(isShuffle){
            Random rand = new Random();
            position = rand.nextInt(songsManager.arraySong().size());
            SetDataSource(position);
            mediaPlayer.start();
            SetTimeTotal();
        }else {
            position++;
            if (position > songsManager.arraySong().size()-1){
                position = 0;
            }
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            SetDataSource(position);
            mediaPlayer.start();
            SetTimeTotal();
        }

    }

}
