package vn.edu.usth.dropbox.ui.home;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import vn.edu.usth.dropbox.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    TextView txtview;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        txtview=root.findViewById(R.id.textDropbox);

        Typeface typeface=Typeface.createFromAsset(getActivity().getAssets(), "font/HALGERIB.TTF");
        txtview.setTypeface(typeface);
        return root;
    }
}