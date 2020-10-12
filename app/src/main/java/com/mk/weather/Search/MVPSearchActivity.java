package com.mk.weather.Search;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.jakewharton.rxbinding3.widget.RxTextView;
import com.mk.weather.CustomView.MyTextView;
import com.mk.weather.R;
import com.mk.weather.Search.searchModel.Datum;
import com.mk.weather.Utils.Constants;
import com.mk.weather.Utils.PublicMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class MVPSearchActivity extends AppCompatActivity implements MVPSearchContract.View {
    MVPSearchPresenter presenter = new MVPSearchPresenter();
    EditText searchCity;
//    TextView text1;
    String TAG = "monitor_";
    MyTextView cityName,cityTemp;
    RelativeLayout relative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        bind();
        presenter.attachView(this);
        Log.d(TAG, "onCreate: ");

        RxTextView.textChanges(searchCity)
                .debounce(1300 , TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onChange);

    }

    private void onChange(CharSequence charSequence) {
        rest(charSequence.toString());
        Log.d(TAG, "onChange: ");
    }

    void rest(String city){
        presenter.onGetCityDetail(city);
        Log.d(TAG, "rest: ");
    }


    @Override
    public void result(List<Datum> search) {
        if (search != null && search.size() > 0) {
            for (int i = 0; i < search.size(); i++) {
                Log.d(TAG, "result: ");
                cityName.setTxt(search.get(i).getCityName());
                cityTemp.setTxt(PublicMethods.roundFloat(search.get(i).getTemp())+ Constants.c);
            }
        }
    }

    @Override
    public void onFailed(Throwable t) {
//        PublicMethods.toast("City Not Found");
PublicMethods.toast(t.toString());
    }
    private void bind() {
        searchCity = findViewById(R.id.searchCity);
        Typeface medium = Typeface.createFromAsset(this.getAssets(),"JosefinSans-Medium.ttf");
        searchCity.setTypeface(medium);
//        text1 = findViewById(R.id.text1);
        cityName = findViewById(R.id.cityName);
        cityTemp = findViewById(R.id.cityTemp);
        relative = findViewById(R.id.relative);
        relative.setOnClickListener(V->{
            Intent returnIntent = new Intent();
            returnIntent.putExtra(Constants.cityName , cityName.getText());
            setResult(Activity.RESULT_OK , returnIntent);
            finish();
        });
    }


}