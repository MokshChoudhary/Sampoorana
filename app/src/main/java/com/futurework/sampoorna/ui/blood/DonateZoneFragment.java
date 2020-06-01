package com.futurework.sampoorna.ui.blood;

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

import com.futurework.sampoorna.R;

public class DonateZoneFragment extends Fragment {

    private DonateZoneViewModel donateZoneViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        donateZoneViewModel =
                ViewModelProviders.of(this).get(DonateZoneViewModel.class);
        View root = inflater.inflate(R.layout.fragment_blood, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        donateZoneViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
