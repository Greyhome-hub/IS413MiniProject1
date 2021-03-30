package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Main extends Application {
    GregorianCalendar calendar = new GregorianCalendar();
    Button btnPrev = new Button("Prior");
    Button btnNext = new Button("Next");

    Label monthYear = new Label(PopulateCalendar.getMonthName(calendar)
            + ", " +String.valueOf(calendar.get(Calendar.YEAR)));

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Calendar");

        BorderPane mainPane = new BorderPane();
        final GridPane[] calendarGrid = {new GridPane()};


        //calendar month, year label
        BorderPane.setAlignment(monthYear, Pos.TOP_CENTER);
        mainPane.setTop(monthYear);
        // calendar contents
        calendarGrid[0] = PopulateCalendar.getCalendarContents(calendar);
        mainPane.setCenter(calendarGrid[0]);
        //buttons
        HBox buttonHBox = new HBox(10, btnPrev, btnNext);
        buttonHBox.setAlignment(Pos.BOTTOM_CENTER);
        mainPane.setBottom(buttonHBox);




        primaryStage.setScene(new Scene(mainPane, 600, 500));



        btnPrev.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                calendar.add(Calendar.MONTH, -1);
                monthYear.setText(PopulateCalendar.getMonthName(calendar)
                        + ", " +String.valueOf(calendar.get(Calendar.YEAR)));
                calendarGrid[0] = PopulateCalendar.getCalendarContents(calendar);
                mainPane.setCenter(calendarGrid[0]);
            }
        });

        btnNext.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                calendar.add(Calendar.MONTH, 1);
                monthYear.setText(PopulateCalendar.getMonthName(calendar)
                        + ", " +String.valueOf(calendar.get(Calendar.YEAR)));
                calendarGrid[0] = PopulateCalendar.getCalendarContents(calendar);
                mainPane.setCenter(calendarGrid[0]);
            }
        });

        primaryStage.show();
    }

  /*  class MonthAdvance
        implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            calendar.add(Calendar.MONTH, 1);
            monthYear.setText(PopulateCalendar.getMonthName(calendar)
                    + ", " +String.valueOf(calendar.get(Calendar.YEAR)));
            GridPane calendarGrid = PopulateCalendar.getCalendarContents(calendar);
        }
    }*/


    public static void main(String[] args) {
        launch(args);
    }
}
