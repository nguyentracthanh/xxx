package vn.edu.usth.dropbox.ui.paper;

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

public class PaperFragment extends Fragment {

    private PaperViewModel paperViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        paperViewModel =
                ViewModelProviders.of(this).get(PaperViewModel.class);
        View root = inflater.inflate(R.layout.fragment_files, container, false);

        return root;
    }
}