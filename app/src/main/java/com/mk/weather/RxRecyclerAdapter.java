package com.mk.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mk.weather.CustomView.MyImageView;
import com.mk.weather.Utils.PublicMethods;
import com.mk.weather.WeatherMVP.dailyModel.DailyDatum;

import java.util.List;

public class RxRecyclerAdapter extends RecyclerView.Adapter<RxRecyclerAdapter.Holder> {
    Context mContext;
    List<DailyDatum> dailyData;


    public RxRecyclerAdapter(Context mContext, List<DailyDatum> dailyData) {
        this.mContext = mContext;
        this.dailyData = dailyData;
    }

    @Override
    public RxRecyclerAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.recycler_daily_item , parent , false);

        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RxRecyclerAdapter.Holder holder, int position) {
//        try {
//            holder.imgDaily.loadImgFromDrawable(R.drawable.ic_weather_sunny_grey600_36dp);
//            holder.dateDaily.setText(PublicMethods.getDay(dailyData.get(position).getTs()));
//            holder.tempDaily.setText(PublicMethods.roundFloat(dailyData.get(position).getLowTemp()));
//        }catch (Exception e){
//            //ss
//        }


    }
    @Override
    public int getItemCount() {
        return dailyData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        MyImageView imgDaily;
        TextView tempDaily,dateDaily;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imgDaily = itemView.findViewById(R.id.imgDaily);
            tempDaily = itemView.findViewById(R.id.tempDaily);
            dateDaily = itemView.findViewById(R.id.dateDaily);
        }
    }
}
