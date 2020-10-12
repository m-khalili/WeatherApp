package com.mk.weather.WeatherMVP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mk.weather.CustomView.MyTextView;
import com.mk.weather.CustomView.MyImageView;
import com.mk.weather.R;
import com.mk.weather.Utils.Constants;
import com.mk.weather.Utils.PublicMethods;
import com.mk.weather.Utils.WeatherIcon;
import com.mk.weather.WeatherMVP.HourlyModel.ListModel;
import com.mk.weather.WeatherMVP.HourlyModel.Weather;


import java.util.List;

public class RecyclerAdapterHourly extends RecyclerView.Adapter<RecyclerAdapterHourly.Holder> {
    List<ListModel> hourlyData;
    Context mContext;


    public RecyclerAdapterHourly(List<ListModel> hourlyData, Context mContext) {
        this.hourlyData = hourlyData;
        this.mContext = mContext;
    }

    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.hourly_recycler_item,parent,false);

        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        if (hourlyData.get(position) != null){
            holder.time.setTxt(PublicMethods.getTime(hourlyData.get(position).getDt()));
            double temp = PublicMethods.ktoC(hourlyData.get(position).getMain().getTemp());
            holder.temp.setTxt((PublicMethods.roundFloat(temp))+Constants.c);
            List<Weather> weathers = hourlyData.get(position).getWeather();
            for (int i = 0; i< weathers.size(); i++){
                holder.description.setTxt(weathers.get(i).getDescription());
                holder.image.loadImgFromDrawable(WeatherIcon.getIcon(weathers.get(i).getId()));


            }

        }

//        if (hourlyData.get(position)!= null){
//            holder.time.setTxt(PublicMethods.getTime(hourlyData.get(position).getTs()));
//            holder.temp.setTxt(String.valueOf(PublicMethods.roundFloat(hourlyData.get(position).getTemp())) + Constants.c);
//            holder.image.loadImgFromDrawable(PublicMethods.getIcon(hourlyData.get(position).getWeather().getCode()));
//            holder.description.setTxt(hourlyData.get(position).getWeather().getDescription());
//        }
    }

    @Override
    public int getItemCount() {
        return hourlyData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        MyTextView temp,time,description;
        MyImageView image;
        public Holder(@NonNull View itemView) {
            super(itemView);
            temp = itemView.findViewById(R.id.temp);
            time = itemView.findViewById(R.id.time);
            image = itemView.findViewById(R.id.image);
            description = itemView.findViewById(R.id.description);
        }
    }
}
