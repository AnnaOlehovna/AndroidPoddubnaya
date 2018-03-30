package com.olehovnagmail.anya.homeworks.homework6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.olehovnagmail.anya.R;
import com.olehovnagmail.anya.databinding.ItemWeatherBinding;
import com.olehovnagmail.anya.homeworks.homework6.convertDate.ConvertDate;
import com.olehovnagmail.anya.homeworks.homework6.entity.Weather;


import java.util.ArrayList;
import java.util.List;


public class WeatherListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Weather> weathers = new ArrayList<>();

    public void setItems(List<Weather> weather) {
        this.weathers.clear();
        this.weathers.addAll(weather);

        //метод заставляет перерисовывать элементы
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather,
                parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        WeatherListAdapter.MyHolder myHolder = (WeatherListAdapter.MyHolder) holder;
        final Weather weather = weathers.get(position);
        String title = weather.getTitle().toLowerCase();
        switch (title) {
            case "sunny":
            case "clear":
                myHolder.image.setImageResource(R.drawable.sunny);
                break;
            case "clouds":
                myHolder.image.setImageResource(R.drawable.cloud);
                break;
            case "rain":
                myHolder.image.setImageResource(R.drawable.rain);
                break;
            default:
                myHolder.image.setImageResource(R.drawable.cloud);
                break;
        }


        myHolder.description.setText(weather.getDescription());
        ConvertDate convertDate = new ConvertDate();
        myHolder.date.setText(convertDate.convertDateToString(weather.getDate()));
        myHolder.location.setText(weather.locationToString());
        String minimumTemp = "Minimum temperature: "+ String.valueOf(weather.getTempMin());
        myHolder.minTemp.setText(minimumTemp);
        String maximumTemp = "Maximum temperature: "+ String.valueOf(weather.getTempMax());
        myHolder.maxTemp.setText(maximumTemp);
        String humid = "Humidity: "+String.valueOf(weather.getHumidity());
        myHolder.humidity.setText(humid);



    }

    @Override
    public int getItemCount() {
        return weathers.size();
    }


    private static class MyHolder extends RecyclerView.ViewHolder {



        ImageView image;
        TextView description;
        TextView date;
        TextView location;
        TextView minTemp;
        TextView maxTemp;
        TextView humidity;

        public MyHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_weather);
            description = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);
            location = itemView.findViewById(R.id.location);
            minTemp = itemView.findViewById(R.id.min_temp);
            maxTemp = itemView.findViewById(R.id.max_temp);
            humidity = itemView.findViewById(R.id.humidity);

        }
    }
}
