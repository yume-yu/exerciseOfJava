package panels;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;
import myjava.NowTime;

public class Calendar extends JPanel {

    private CalendarCell dateLabels[][] = new CalendarCell[5][7];
    private JLabel calendarTitle = new JLabel();
    private JLabel dayOfWeekLabel[] = new JLabel[7];

    public Calendar(int width, int height){
        setPreferredSize(new Dimension(width, height));
        setBorder(new BevelBorder(BevelBorder.RAISED));

        initCalendarTitle(width,height / 9);
        initDayOfWeekLabel(width/(dateLabels[0].length + 1),height / 9);
        initCalendarCells(width/(dateLabels[0].length + 1),height /9);
        makeCalendar(NowTime.getNowLocalDateTime());

        for(CalendarCell[] weeks : dateLabels){
            for(CalendarCell day : weeks){
                add(day.getDateLabel());
            }
        }

    }

    private void initCalendarTitle(int cellWidth,int cellHeight){
        calendarTitle.setPreferredSize(new Dimension(cellWidth, cellHeight));
        calendarTitle.setText(NowTime.getNowLocalDateTime().getYear() + " / " + NowTime.getNowMonth());
        calendarTitle.setHorizontalAlignment(JLabel.CENTER);
        calendarTitle.setFont(new Font(calendarTitle.getFont().getFamily(),calendarTitle.getFont().getStyle(),20));
        add(calendarTitle);
    }

    private void initCalendarCells(int cellWidth,int cellHeight){
        for(int i = 0; i < dateLabels.length; i++){
            for(int j = 0; j < dateLabels[i].length; j++){
                dateLabels[i][j] = new CalendarCell(NowTime.getNowLocalDateTime());
                dateLabels[i][j].getDateLabel().setPreferredSize(new Dimension(cellWidth, cellHeight));
                dateLabels[i][j].getDateLabel().setHorizontalAlignment(JLabel.CENTER);
                dateLabels[i][j].getDateLabel().setFont(new Font(dateLabels[i][j].getDateLabel().getFont().getFamily(),dateLabels[i][j].getDateLabel().getFont().getStyle(),20));
                System.out.println(dateLabels[i][j]);
            }
        }
    }

    private void initDayOfWeekLabel(int cellWidth,int cellHeight){
        DayOfWeek dayOfWeek = DayOfWeek.SUNDAY;
        for(JLabel day : dayOfWeekLabel){
            day = new JLabel();
            day.setPreferredSize(new Dimension(cellWidth, cellHeight));
            day.setText(dayOfWeek.getDisplayName(TextStyle.SHORT,Locale.JAPAN));
            day.setHorizontalAlignment(JLabel.CENTER);
            day.setFont(new Font(day.getFont().getFamily(),day.getFont().getStyle(),20));
            if(dayOfWeek == DayOfWeek.SUNDAY){
                day.setForeground(Color.red);
            }else if(dayOfWeek == DayOfWeek.SATURDAY){
                day.setForeground(Color.blue);
            }
            this.add(day);
            dayOfWeek = dayOfWeek.plus(1);
        }
    }

    private void makeCalendar(LocalDateTime now) {
        System.out.println(now);
        LocalDateTime firstDayOfThisMonth = now.minusDays(now.getDayOfMonth()).plusDays(1);
        LocalDateTime firstDayOfThisCalendar = firstDayOfThisMonth;
        while(!(firstDayOfThisCalendar.getDayOfWeek() == DayOfWeek.SUNDAY)){
            firstDayOfThisCalendar = firstDayOfThisCalendar.minusDays(1);
        }
        for(CalendarCell[] weeks:dateLabels){
            for(CalendarCell day: weeks){
                if(firstDayOfThisCalendar.getMonth() == NowTime.getNowLocalDateTime().getMonth()) {
                    day.setAssignedDate(firstDayOfThisCalendar);
                }else{
                    day.dateLabel.setText("");
                }
                if(firstDayOfThisCalendar.isEqual(now)){
                    day.getDateLabel().setFont(new Font(day.getDateLabel().getFont().getFamily(),Font.BOLD,day.getDateLabel().getFont().getSize() + 2));
                }
                firstDayOfThisCalendar = firstDayOfThisCalendar.plusDays(1);
            }
        }
    }
}
