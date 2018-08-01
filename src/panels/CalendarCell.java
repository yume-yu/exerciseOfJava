package panels;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CalendarCell{

    public  JLabel dateLabel ;
    private LocalDateTime assignedDate;

    public CalendarCell(){
        dateLabel = new JLabel();
    }

    public CalendarCell(LocalDateTime assignedDate){
        this.assignedDate = assignedDate;
        dateLabel = new JLabel();
        dateLabel.setText(this.assignedDate.format(DateTimeFormatter.ofPattern("dd")));
    }

    public JLabel getDateLabel(){
        return dateLabel;
    }

    public void setAssignedDate(LocalDateTime assignedDate){
        this.assignedDate = assignedDate;
        dateLabel.setText(assignedDate.format(DateTimeFormatter.ofPattern("dd")));
    }

    public LocalDateTime getAssignedDate(){
        return assignedDate;
    }
}
