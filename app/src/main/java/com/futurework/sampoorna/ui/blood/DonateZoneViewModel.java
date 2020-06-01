package com.futurework.sampoorna.ui.blood;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DonateZoneViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DonateZoneViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}