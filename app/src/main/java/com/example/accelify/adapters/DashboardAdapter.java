////package com.example.accelify.adapters;
////
////import android.content.Context;
////import android.view.LayoutInflater;
////import android.view.View;
////import android.view.ViewGroup;
////import android.widget.BaseAdapter;
////import android.widget.ImageView;
////import android.widget.TextView;
////import androidx.cardview.widget.CardView;
////
////import com.example.accelify.R;
////
////public class DashboardAdapter extends BaseAdapter {
////
////    private Context context;
////    private String[] titles;
////    private int[] images;
////
////    public DashboardAdapter(Context context, String[] titles, int[] images) {
////        this.context = context;
////        this.titles = titles;
////        this.images = images;
////    }
////
////    @Override
////    public int getCount() {
////        return titles.length;
////    }
////
////    @Override
////    public Object getItem(int position) {
////        return null;
////    }
////
////    @Override
////    public long getItemId(int position) {
////        return 0;
////    }
////
////    @Override
////    public View getView(int position, View convertView, ViewGroup parent) {
////        if (convertView == null) {
////            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////            convertView = inflater.inflate(R.layout.item_dashboard_card, null);
////        }
////
////        CardView cardView = convertView.findViewById(R.id.card_view);
////        ImageView imageView = convertView.findViewById(R.id.card_image);
////        TextView textView = convertView.findViewById(R.id.card_title);
////
////        imageView.setImageResource(images[position]);
////        textView.setText(titles[position]);
////
////        return convertView;
////    }
////}
//
//
//package com.example.accelify.adapters;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.accelify.DashboardItem;
//import com.example.accelify.R;
//
//import java.util.List;
//
//public class DashboardAdapter extends BaseAdapter {
//
//    private Context context;
//    private List<DashboardItem> items;
//
//    public DashboardAdapter(Context context, List<DashboardItem> items) {
//        this.context = context;
//        this.items = items;
//    }
//
//    @Override
//    public int getCount() {
//        return items.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return items.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.dashboard_item, parent, false);
//        }
//
//        DashboardItem item = items.get(position);
//
//        ImageView itemImage = convertView.findViewById(R.id.item_image);
//        TextView itemText = convertView.findViewById(R.id.item_text);
//
//        itemImage.setImageResource(item.getImageResId());
//        itemText.setText(item.getText());
//
//        return convertView;
//    }
//}


package com.example.accelify.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.accelify.DashboardItem;
import com.example.accelify.R;

import java.util.List;

public class DashboardAdapter extends BaseAdapter {

    private Context context;
    private List<DashboardItem> items;

    public DashboardAdapter(Context context, List<DashboardItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.dashboard_item, parent, false);
        }

        DashboardItem item = items.get(position);

        ImageView itemImage = convertView.findViewById(R.id.item_image);
        TextView itemText = convertView.findViewById(R.id.item_text);

        itemImage.setImageResource(item.getImageResId());
        itemText.setText(item.getText());

        return convertView;
    }
}
