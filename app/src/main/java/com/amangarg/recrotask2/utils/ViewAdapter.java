package com.amangarg.recrotask2.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amangarg.recrotask2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ViewAdapter extends PagerAdapter {


    JSONArray list;
    Context context;
    LayoutInflater inflater;

    public ViewAdapter(Context context, JSONArray list) {
        this.list = list;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return list.length();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = inflater.inflate(R.layout.main_adapter_layout,null,false);
        TextView productName = v.findViewById(R.id.productName);
        TextView productSubscription = v.findViewById(R.id.productSubscribed);

        try {
            JSONObject object = (JSONObject) list.get(position);

            productName.setText(object.getString("ProductName"));
            productSubscription.setText(object.getString("Subscribed"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View)object);
    }

}