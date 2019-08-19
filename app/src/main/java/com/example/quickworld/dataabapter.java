package com.example.quickworld;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class dataabapter extends ArrayAdapter<dataset> {
    public dataabapter(@NonNull View.OnClickListener context, int resource, @NonNull ArrayList<dataset> objects) {
        super((Context) context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View check = convertView;
        if (check == null) {
            check = LayoutInflater.from(getContext()).inflate(R.layout.template, parent, false);
        }
        final dataset enter = getItem(position);

        TextView content = check.findViewById(R.id.content_image);
        content.setText(enter.getContent());

        TextView disp = check.findViewById(R.id.disp_image);
        disp.setText(enter.getDescription());

        TextView img = check.findViewById(R.id.image);
        img.setBackgroundColor(enter.getcolor());
        return check;
    }
}