package fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.appmusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import model.ChuDe;
import model.TheLoai;


public class Fragment_ChuDe_TheLoai extends Fragment {
    View view;

    HorizontalScrollView horizontalScrollView;
    TextView txtViewXemThem;

    ChuDe chuDe;
    TheLoai theLoai;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude_theloai, container, false);
        anhXa();
        getData();
        return view;
    }

    private void getData() {
        final ArrayList<ChuDe> chuDeArrayList  = new ArrayList<>();
        final ArrayList<TheLoai> theLoaiArrayList = new ArrayList<>();

        chuDeArrayList.add(chuDe = new ChuDe("Acoustic", R.drawable.acoustic_chude));
        chuDeArrayList.add(chuDe = new ChuDe("EDM", R.drawable.thapnien_chude));
        chuDeArrayList.add(chuDe = new ChuDe("Music for love", R.drawable.love_chude));

        theLoaiArrayList.add(theLoai = new TheLoai("R & B", R.drawable.dance_theloai));
        theLoaiArrayList.add(theLoai = new TheLoai("Acoustic Pop", R.drawable.edm_theloai));
        theLoaiArrayList.add(theLoai = new TheLoai("Dance Pop", R.drawable.dancepop_theloai));

        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams layout =  new LinearLayout.LayoutParams(580, 250);
        layout.setMargins(10, 20, 10, 30);

        for (int i = 0;  i < theLoaiArrayList.size(); i++) {
            CardView cardView = new CardView(getActivity());
            cardView.setRadius(10);

            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            Picasso.with(getActivity()).load(theLoaiArrayList.get(i).getHinhTheLoai()).into(imageView);

            cardView.setLayoutParams(layout);
            cardView.addView(imageView);

            linearLayout.addView(cardView);
        }

        for (int i = 0;  i < chuDeArrayList.size(); i++) {
            CardView cardView = new CardView(getActivity());
            cardView.setRadius(10);

            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            Picasso.with(getActivity()).load(chuDeArrayList.get(i).getHinhChuDe()).into(imageView);

            cardView.setLayoutParams(layout);
            cardView.addView(imageView);

            linearLayout.addView(cardView);
        }

        horizontalScrollView.addView(linearLayout);
    }

    private void anhXa() {
        horizontalScrollView = view.findViewById(R.id.horizontalScrollView);
        txtViewXemThem = view.findViewById(R.id.txtViewXemThem);
    }
}
