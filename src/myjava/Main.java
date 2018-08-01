package myjava;

public class Main {

    public static void main(String[] args) {
        Window win = new Window();
        win.addCalendar();
        win.addForecast();
        win.addClock();
        win.setVisible(true);
    }
}
