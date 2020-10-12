package com.mk.weather.Utils;

import com.mk.weather.R;

public class WeatherIcon {
    public static int getIcon(int code){
        if (PublicMethods.nightOrDay().equals(Constants.day)){
            switch (code){
                case 200:
                case 201:
                case 202:
                case 230:
                case 232:
                case 233:
                    return R.drawable.daily_forecast_t_storm;

                case 500:
                    return R.drawable.daily_forecast_light_rain;

                case 501:
                    return R.drawable.daily_forecast_moderate_rain;

                case 502:
                    return R.drawable.daily_forecast_heavy_rain;

                case 511:
                    return R.drawable.daily_forecast_ice_rain;

                case 600:
                    return R.drawable.daily_forecast_light_snow;

                case 601:
                case 621:
                    return R.drawable.daily_forecast_moderate_snow;

                case 602:
                case 622:
                    return R.drawable.daily_forecast_heavy_snow;

                case 610:
                    return R.drawable.daily_forecast_rain_snow;

                case 700:
                case 711:
                case 721:
                case 731:
                case 741:
                case 751:
                    return R.drawable.daily_forecast_foggy;

                case 800:
                    return R.drawable.ic_clear_day;
                case 801:
                case 802:
                    return R.drawable.daily_forecast_cloudy;
                case 803:
                case 804:
                    return R.drawable.daily_forecast_overcast;
                case 300:
                case 301:
                case 302:
                case 611:
                case 612:
                case 623:
                case 900:
                    return R.drawable.daily_forecast_pm_dirt;

            }
        }else if (PublicMethods.nightOrDay().equals(Constants.night)){
            switch (code){
                case 200:
                case 201:
                case 202:
                case 230:
                case 232:
                case 233:
                    return R.drawable.icon_gray_bg_t_storm_night;

                case 500:
                    return R.drawable.icon_gray_bg_light_rain_night;

                case 501:
                    return R.drawable.icon_gray_bg_moderate_rain_night;

                case 502:
                    return R.drawable.icon_gray_bg_heavy_rain_night;

                case 511:
                    return R.drawable.icon_gray_bg_ice_rain_night;

                case 600:
                    return R.drawable.icon_gray_bg_light_snow_night;

                case 601:
                case 621:
                    return R.drawable.icon_gray_bg_moderate_snow_night;

                case 602:
                case 622:
                    return R.drawable.icon_gray_bg_heavy_snow_night;

                case 610:
                    return R.drawable.icon_gray_bg_rain_snow_night;

                case 700:
                case 711:
                case 721:
                case 731:
                case 741:
                case 751:
                    return R.drawable.icon_gray_bg_fog_night;

                case 800:
                    return R.drawable.icon_gray_bg_sunny_night;
                case 801:
                case 802:
                    return R.drawable.icon_gray_bg_cloudy_night;
                case 803:
                case 804:
                    return R.drawable.icon_gray_bg_overcast_night;
                case 300:
                case 301:
                case 302:
                case 611:
                case 612:
                case 623:
                case 900:
                    return R.drawable.icon_gray_bg_pm_dirt_night;

            }
        }
        return R.drawable.icon_gray_bg_pm_dirt_night;
    }


    public static String getIconLottie(int code){
        if (PublicMethods.nightOrDay().equals(Constants.day)){
            switch (code){
                case 200:
                    return "4792-weather-stormshowersday.json";
                case 201:
                case 202:
                    return "4803-weather-storm.json";
                case 230:
                case 231:
                case 232:
                case 233:
                    return "4805-weather-thunder.json";

                case 500:
                case 501:
                case 502:
                case 511:
                case 520:
                case 522:
                    return "light_rain.json";

                case 521:
                    return "4801-weather-partly-shower.json";


                case 600:
                    return "4802-weather-snow-sunny.json";

                case 601:
                case 602:
                case 621:
                case 610:
                    return "4793-weather-snow.json";


                case 700:
                case 711:
                case 721:
                case 731:
                case 741:
                case 751:
                    return "4791-foggy.json";

                case 800:
                    return "4804-weather-sunny.json";
                case 801:
                case 802:
                    return "4800-weather-partly-cloudy.json";
                case 803:
                case 804:
                    return "4806-weather-windy.json";
                case 300:
                case 301:
                case 302:
                case 611:
                case 612:
                case 623:
                case 900:
                    return "unknown.json";

            }

        }
        else if ((PublicMethods.nightOrDay().equals(Constants.night))){

            switch (code) {
                case 200:
                    return "4803-weather-storm.json";
                case 201:
                case 202:
                    return "4803-weather-storm.json";
                case 230:
                case 231:
                case 232:
                case 233:
                    return "4805-weather-thunder.json";

                case 500:
                case 501:
                case 502:
                case 511:
                case 520:
                case 522:
                    return "4797-weather-rainynight.json";

                case 521:
                    return "4801-weather-partly-shower.json";


                case 600:
                    return "4798-weather-snownight.json";

                case 601:
                case 602:
                case 621:
                case 610:
                    return "4793-weather-snow.json";


                case 700:
                case 711:
                case 721:
                case 731:
                case 741:
                case 751:
                    return "4791-foggy.json";

                case 800:
                    return "4795-weather-mist.json";
                case 801:
                case 802:
                    return "4796-weather-cloudynight.json";
                case 803:
                case 804:
                    return "4806-weather-windy.json";
                case 300:
                case 301:
                case 302:
                case 611:
                case 612:
                case 623:
                case 900:
                    return "unknown.json";
            }


    } return "";
 }
 // test
    public static int testDayIcon(int code) {
        switch (code) {
            case 200:
            case 201:
            case 202:
            case 230:
            case 232:
            case 233:
                return R.drawable.daily_forecast_t_storm;

            case 500:
                return R.drawable.daily_forecast_light_rain;

            case 501:
                return R.drawable.daily_forecast_moderate_rain;

            case 502:
                return R.drawable.daily_forecast_heavy_rain;

            case 511:
                return R.drawable.daily_forecast_ice_rain;

            case 600:
                return R.drawable.daily_forecast_light_snow;

            case 601:
            case 621:
                return R.drawable.daily_forecast_moderate_snow;

            case 602:
            case 622:
                return R.drawable.daily_forecast_heavy_snow;

            case 610:
                return R.drawable.daily_forecast_rain_snow;

            case 700:
            case 711:
            case 721:
            case 731:
            case 741:
            case 751:
                return R.drawable.daily_forecast_foggy;

            case 800:
                return R.drawable.ic_clear_day;
            case 801:
            case 802:
                return R.drawable.daily_forecast_cloudy;
            case 803:
            case 804:
                return R.drawable.daily_forecast_overcast;
            case 300:
            case 301:
            case 302:
            case 611:
            case 612:
            case 623:
            case 900:
                return R.drawable.daily_forecast_pm_dirt;

        }
            return 0;
    }

    public static int testNightIcon(int code){
        switch (code){
            case 200:
            case 201:
            case 202:
            case 230:
            case 232:
            case 233:
                return R.drawable.icon_gray_bg_t_storm_night;

            case 500:
                return R.drawable.icon_gray_bg_light_rain_night;

            case 501:
                return R.drawable.icon_gray_bg_moderate_rain_night;

            case 502:
                return R.drawable.icon_gray_bg_heavy_rain_night;

            case 511:
                return R.drawable.icon_gray_bg_ice_rain_night;

            case 600:
                return R.drawable.icon_gray_bg_light_snow_night;

            case 601:
            case 621:
                return R.drawable.icon_gray_bg_moderate_snow_night;

            case 602:
            case 622:
                return R.drawable.icon_gray_bg_heavy_snow_night;

            case 610:
                return R.drawable.icon_gray_bg_rain_snow_night;

            case 700:
            case 711:
            case 721:
            case 731:
            case 741:
            case 751:
                return R.drawable.icon_gray_bg_fog_night;

            case 800:
                return R.drawable.icon_gray_bg_sunny_night;
            case 801:
            case 802:
                return R.drawable.icon_gray_bg_cloudy_night;
            case 803:
            case 804:
                return R.drawable.icon_gray_bg_overcast_night;
            case 300:
            case 301:
            case 302:
            case 611:
            case 612:
            case 623:
            case 900:
                return R.drawable.icon_gray_bg_pm_dirt_night;


    }
        return R.drawable.icon_gray_bg_pm_dirt_night;

    }
}