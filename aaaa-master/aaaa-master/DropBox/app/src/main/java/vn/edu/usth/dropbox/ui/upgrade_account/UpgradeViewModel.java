package vn.edu.usth.dropbox.ui.upgrade_account;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UpgradeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UpgradeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is send fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}