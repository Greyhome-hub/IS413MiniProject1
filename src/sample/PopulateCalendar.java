package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.Calendar;
import java.util.GregorianCalendar;



public class PopulateCalendar {
    public static String getMonthName(GregorianCalendar calendar) {
        int month = calendar.get(Calendar.MONTH);

        String monthString = null;

        switch(month){
            case 0:
                monthString = "January";
                break;
            case 1:
                monthString = "February";
                break;
            case 2:
                monthString = "March";
                break;
            case 3:
                monthString = "April";
                break;
            case 4:
                monthString = "May";
                break;
            case 5:
                monthString = "June";
                break;
            case 6:
                monthString = "July";
                break;
            case 7:
                monthString = "August";
                break;
            case 8:
                monthString = "September";
                break;
            case 9:
                monthString = "October";
                break;
            case 10:
                monthString = "November";
                break;
            case 11:
                monthString = "December";
                break;
        }

        return monthString;
    }

    public static GridPane getCalendarContents(GregorianCalendar calendar){
        GridPane calendarGrid = new GridPane();
        Label sunday = new Label("Sunday");
        Label monday = new Label("Monday");
        Label tuesday = new Label("Tuesday");
        Label wednesday = new Label("Wednesday");
        Label thursday = new Label("Thursday");
        Label friday = new Label("Friday");
        Label saturday = new Label("Saturday");
        Label dayOfMonth = new Label("1");

        calendarGrid.setAlignment(Pos.CENTER);
        calendarGrid.setHgap(10);
        calendarGrid.setVgap(25);
        calendarGrid.setPadding(new Insets(25,25,25,25));
        calendarGrid.add(sunday,0,0);
        calendarGrid.add(monday,1,0);
        calendarGrid.add(tuesday,2,0);
        calendarGrid.add(wednesday,3,0);
        calendarGrid.add(thursday,4,0);
        calendarGrid.add(friday,5,0);
        calendarGrid.add(saturday,6,0);

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int mainMonth = calendar.get(Calendar.MONTH);
        int mainYear = calendar.get(Calendar.YEAR);
        int firstDay = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.add(Calendar.DAY_OF_MONTH, -firstDay + 1);


        int [][] arr = new int[6][7];

        for (int w = 0; w <= 5; ++w) {
            for (int d = 0; d <= 6; ++d) {
                arr[w][d] = calendar.get(Calendar.DAY_OF_MONTH);
                Label label = new Label(String.valueOf(arr[w][d]));
                if (calendar.get(Calendar.MONTH) != mainMonth){label.setTextFill(Color.LIGHTGRAY);}
                calendarGrid.add(label, d, 1 + w);
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
        }

        //reset date
        calendar.set(Calendar.MONTH, mainMonth);
        calendar.set(Calendar.YEAR, mainYear);

        return calendarGrid;
    }
}
