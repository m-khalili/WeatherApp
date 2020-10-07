package com.mk.weather.WeatherMVP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mk.weather.CustomView.MyImageView;
import com.mk.weather.CustomView.MyTextView;
import com.mk.weather.R;
import com.mk.weather.Utils.Constants;
import com.mk.weather.Utils.PublicMethods;
import com.mk.weather.Utils.WeatherIcon;
import com.mk.weather.WeatherMVP.dailyModel.DailyDatum;

import java.util.List;

public class RecyclerAdapterDailyForecast extends RecyclerView.Adapter<RecyclerAdapterDailyForecast.Holder> {
    List<DailyDatum> dailyData;
    Context mContext;
    public RecyclerAdapterDailyForecast(List<DailyDatum> dailyData, Context mContext) {
        this.dailyData = dailyData;
        this.mContext = mContext;
    }

    @Override
    public RecyclerAdapterDailyForecast.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_daily_item , parent , false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterDailyForecast.Holder holder, int position) {
//        holder.temp.setText(PublicMethods.roundFloat(dailyData.get(position).getLowTemp()));
        holder.temp.setTxt(PublicMethods.roundFloat(dailyData.get(position).getMaxTemp())+ Constants.degree+"/"+PublicMethods.roundFloat(dailyData.get(position).getMinTemp())+Constants.degree);
        holder.img.loadImgFromDrawable(WeatherIcon.getIcon(dailyData.get(position).getWeather().getCode().intValue()));
        holder.date.setTxt(PublicMethods.getDay(dailyData.get(position).getTs()));

    }

    @Override
    public int getItemCount() {
        return dailyData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        MyTextView temp,date;
        MyImageView img;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgDaily);
            temp = itemView.findViewById(R.id.tempDaily);
            date = itemView.findViewById(R.id.dateDaily);

        }
    }
}
