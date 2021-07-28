package com.android.ecart.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.ecart.R;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {
    private final String[] sliderDataList;
    public SliderAdapter(String[] sliderDataList) {
        this.sliderDataList = sliderDataList;
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout, null);
        return new SliderAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {
        Picasso.get().load(sliderDataList[position]).into(viewHolder.imageViewBackground);
    }

    @Override
    public int getCount() {
        return sliderDataList.length;
    }

    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {
        ImageView imageViewBackground;
        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_SliderLayout);
        }
    }
}
