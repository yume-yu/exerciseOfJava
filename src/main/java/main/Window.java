package main;

import javax.swing.*;
import java.awt.*;
import panels.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;


public class Window extends JFrame {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private Container contentPane = getContentPane();
    private JPanel clock;
    private JPanel calender;
    private JPanel forecast;
    private int width = 300;
    private int height = 500;

    public Window(){
        setTitle("MyApplication");
        setBounds(screenSize.width - width,0,width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void addClock(){
        clock = new Clock(width,height / 20);
        contentPane.add(clock, BorderLayout.SOUTH);
    }

    public void addCalendar(){
        calender = new Calendar(width, height / 2);
        contentPane.add(calender,BorderLayout.NORTH);
    }

    public void addForecast(){
        forecast = new Forecast(width, (height / 2) - (height / 20));
        contentPane.add(forecast,BorderLayout.CENTER);
    }
}
