package vn.edu.usth.dropbox.ui.offline;

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

public class OfflineFragment extends Fragment {

    private OfflineViewModel offlineViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        offlineViewModel =
                ViewModelProviders.of(this).get(OfflineViewModel.class);
        View root = inflater.inflate(R.layout.fragment_offline, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        offlineViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}