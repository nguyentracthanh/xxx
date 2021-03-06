package vn.edu.usth.dropbox.ui.upgrade_account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import vn.edu.usth.dropbox.R;

public class UpgradeFragment extends Fragment {

    private UpgradeViewModel upgradeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        upgradeViewModel =
                ViewModelProviders.of(this).get(UpgradeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_files, container, false);

        return root;
    }
}