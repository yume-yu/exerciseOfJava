package parser;

import java.util.List;
import java.util.ArrayList;

public class Forecasts {
    public String date;
    public String dateLabel;
    public String telop;
    public List<ForecastImage> image;
    public List<ForecastTemp> temperature;

    public Forecasts(String date,String dateLabel,String telop){
        this.date = date;
        this.dateLabel = dateLabel;
        this.telop = telop;
        this.image = new ArrayList<ForecastImage>();
        this.temperature = new ArrayList<ForecastTemp>();
    }
}
