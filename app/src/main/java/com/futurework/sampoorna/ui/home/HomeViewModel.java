package com.futurework.sampoorna.ui.home;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.futurework.sampoorna.database.BlankContract;
import com.futurework.sampoorna.database.logindbHelper;

public class  HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}