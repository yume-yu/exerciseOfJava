package parser;

import java.util.ArrayList;
import java.util.List;

public class ForecastDateStructure {
    public String title;
    public List<String> link;
    public String publictime;
    public Location location;
    public Description description;
    public Forecasts forecasts;
    public PinpointLocation pinpointLocation;
    public Copyright copyright;

    public ForecastDateStructure(String title, String publictime, Location location,Description description,Forecasts forecasts,PinpointLocation pinpointLocation,Copyright copyright){
        this.title = title;
        this.publictime = publictime;
        this.location = location;
        this.description = description;
        this.forecasts = forecasts;
        this.pinpointLocation = pinpointLocation;
        this.copyright = copyright;
        this.link = new ArrayList<String>();

    }
}
