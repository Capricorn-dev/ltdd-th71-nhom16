package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appmusic.Personal.AlbumsActivity;
import com.example.appmusic.Personal.ArtistsActivity;
import com.example.appmusic.Personal.PersonalPage;
import com.example.appmusic.PlayListActivity;
import com.example.appmusic.PlayerActivity;
import com.example.appmusic.R;

public class Fragment_Ca_Nhan extends Fragment {
    private View view;
    private ImageView albums;
    private ImageView artist;
    private ImageView playlist;
    private ImageView tracks;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ca_nhan, container, false);
        personal();
        return view;
    }

    private void personal() {

        //Albums category
        albums =  (ImageView) view.findViewById(R.id.imgalbums);
        //Set a click
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Albums category is clicked on.
            @Override
            public void onClick(View view) {
                //Create intent to open AlbumsActivity
                Intent albumsIntent = new Intent(getContext(), AlbumsActivity.class);
                //Start the new activity
                startActivityForResult(albumsIntent, 100);
            }
        });

        //Artist category
        artist =  (ImageView) view.findViewById(R.id.imgartist);
        //Set a click
        artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create intent to open ArtistsActivity
                Intent artistIntent = new Intent(getContext(), ArtistsActivity.class);
                //Start the new activity
                startActivityForResult(artistIntent, 100);
            }
        });

        //Playlist category
        playlist =  (ImageView) view.findViewById(R.id.imgplaylist);
        //Set a click
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create intent to open PlaylistActivty
                Intent playlistIntent = new Intent(getContext(), PlayListActivity.class);
                //Start the new activity
                startActivityForResult(playlistIntent, 100);
            }
        });

        //Tracks category
        tracks =  (ImageView) view.findViewById(R.id.imgtracks);
        //Set a click
        tracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create intent to open TracksActivity
                Intent tracksIntent = new Intent(getContext(), PlayListActivity.class);
                //Start the new activity
                startActivityForResult(tracksIntent, 100);
            }
        });
    }
}
