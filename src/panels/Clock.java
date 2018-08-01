package panels;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import myjava.NowTime;



public class Clock extends JPanel {

    private final int CLOCKMARGIN = 20;
    private final int CLOCKLABELHEIGHT = 30;
    private JLabel clockPane = new JLabel();

    public Clock(int width,int height) {
        setBorder(new BevelBorder(BevelBorder.RAISED));

        clockPane.setPreferredSize(new Dimension(width - CLOCKMARGIN,CLOCKLABELHEIGHT));
        clockPane.setHorizontalAlignment(JLabel.CENTER);
        clockPane.setText(NowTime.getNowTime());
        clockPane.setFont(new Font(clockPane.getFont().getFamily(),Font.PLAIN,20));
        this.add(clockPane);

        Timer updateClock = new java.util.Timer();
        updateClock.schedule(new TimerTask() {
            @Override
            public void run() {
                getNowTime();
            }
        }, new Date(),500);

    }

    public void getNowTime() {
        this.clockPane.setText(NowTime.getNowTime());
    }

}
