/**
 * Mainメソッドに呼ばれるウィンドウを統括するメソッド
 * @author Yu Matsuda
 */
package main;

import javax.swing.*;
import java.awt.*;
import panels.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;


public class Window extends JFrame {

    /**
     * ディスプレイの大きさを取得し格納する変数
     */
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * JPanelを格納するコンテナ
     */
    private Container contentPane = getContentPane();
    /**
     * Clockペインを代入する変数
     */
    private JPanel clock;
    /**
     * Calendarペインを代入する変数
     */
    private JPanel calender;
    /**
     * Forecastペインを代入する変数
     */
    private JPanel forecast;
    /**
     * ウィンドウの幅
     */
    private int width = 300;
    /**
     * ウィンドウの高さ
     */
    private int height = 500;

    /**
     * フレームを既定の大きさで作成します
     */
    public Window(){
        setTitle("MyApplication");
        setBounds(screenSize.width - width,0,width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    /**
     * contentPaneにClockペインを追加します
     */
    public void addClock(){
        clock = new Clock(width,height / 20);
        contentPane.add(clock, BorderLayout.SOUTH);
    }

    /**
     * contentPaneにCalendarペインを追加します
     */
    public void addCalendar(){
        calender = new Calendar(width, height / 2);
        contentPane.add(calender,BorderLayout.NORTH);
    }

    /**
     * contentPaneにForecastペインを追加します
     */
    public void addForecast(){
        forecast = new Forecast(width, (height / 2) - (height / 20));
        contentPane.add(forecast,BorderLayout.CENTER);
    }
}
