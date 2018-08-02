package panels;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import com.google.gson.*;
import main.getWebRequestAnswer;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.Timer;
import java.util.Date;
import java.util.TimerTask;

public class Forecast extends JPanel {

    private JsonObject forecast;
    private JLabel forecastTitle;
    private JLabel publicTime;
    private JLabel weatherInfo;
    private JLabel weatherIcon;
    private JLabel weatherInfoT;
    private JLabel weatherIconT;

    public Forecast(int width, int height){
        forecast = getWebRequestAnswer.getForecast("130010");/*東京*/
        setPreferredSize(new Dimension(width, height));
        setBorder(new BevelBorder(BevelBorder.RAISED));

        forecastTitle = new JLabel(forecast.get("title").getAsString());
        forecastTitle.setFont(new Font(forecastTitle.getFont().getFamily(),forecastTitle.getFont().getStyle(),20));
        forecastTitle.setHorizontalAlignment(JLabel.CENTER);
        forecastTitle.setPreferredSize(new Dimension(width,20));
        JLabel today = new JLabel("今日");
        today.setPreferredSize(new Dimension(width,today.getFont().getSize() + 10));
        today.setHorizontalAlignment(JLabel.CENTER);
        today.setVerticalAlignment(JLabel.BOTTOM);
        publicTime = new JLabel(forecast.get("publicTime").getAsString());
        weatherInfo = new JLabel(forecast.get("forecasts").getAsJsonArray().get(0).getAsJsonObject().get("telop").getAsString());
        try {
            weatherIcon = new JLabel();
            weatherIcon.setIcon(new ImageIcon(new URL(forecast.get("forecasts").getAsJsonArray().get(0).getAsJsonObject().get("image").getAsJsonObject().get("url").getAsString())));
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        weatherInfoT = new JLabel(forecast.get("forecasts").getAsJsonArray().get(1).getAsJsonObject().get("telop").getAsString());
        try {
            weatherIconT = new JLabel();
            weatherIconT.setIcon(new ImageIcon(new URL(forecast.get("forecasts").getAsJsonArray().get(1).getAsJsonObject().get("image").getAsJsonObject().get("url").getAsString())));
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        JLabel tomorrow = new JLabel("明日");
        tomorrow.setPreferredSize(new Dimension(width,today.getFont().getSize() + 10));
        tomorrow.setHorizontalAlignment(JLabel.CENTER);
        tomorrow.setVerticalAlignment(JLabel.BOTTOM);
        //publicTime.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        add(forecastTitle);
        add(today);
        add(weatherInfo);
        add(weatherIcon);
        add(tomorrow);
        add(weatherInfoT);
        add(weatherIconT);
        add(publicTime,BorderLayout.SOUTH);

        Timer updateForecast = new java.util.Timer();
        updateForecast.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        forecast = getWebRequestAnswer.getForecast("130010");/*東京*/
                                        publicTime = new JLabel(forecast.get("publicTime").getAsString());
                                        weatherInfo = new JLabel(forecast.get("forecasts").getAsJsonArray().get(0).getAsJsonObject().get("telop").getAsString());
                                        try {
                                            weatherIcon = new JLabel();
                                            weatherIcon.setIcon(new ImageIcon(new URL(forecast.get("forecasts").getAsJsonArray().get(0).getAsJsonObject().get("image").getAsJsonObject().get("url").getAsString())));
                                        }catch (MalformedURLException e){
                                            e.printStackTrace();
                                        }
                                        weatherInfoT = new JLabel(forecast.get("forecasts").getAsJsonArray().get(1).getAsJsonObject().get("telop").getAsString());
                                        try {
                                            weatherIconT = new JLabel();
                                            weatherIconT.setIcon(new ImageIcon(new URL(forecast.get("forecasts").getAsJsonArray().get(1).getAsJsonObject().get("image").getAsJsonObject().get("url").getAsString())));
                                        }catch (MalformedURLException e){
                                            e.printStackTrace();
                                        }
                                    }
                                },new Date(),36000000
        );
    }
}
