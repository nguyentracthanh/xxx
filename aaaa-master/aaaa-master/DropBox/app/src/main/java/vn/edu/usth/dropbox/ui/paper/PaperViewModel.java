package vn.edu.usth.dropbox.ui.paper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PaperViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PaperViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is send fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}