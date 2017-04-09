package UI;

import java.util.Calendar;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CalendarMonthPage extends Pane {
	private Calendar calendar=Calendar.getInstance();
	int year;
	int month;
	int day;
	int firstday;
	int finalday;
	
	public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    public void setMonth(int month) {
        calendar.set(Calendar.MONTH, month - 1);
    }

    public int getMonth() {
        return calendar.get(Calendar.MONTH) + 1;
    }

    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    public int getDay() {
        return day;
    }

    public int getFirstDayOfWeek() {
        return firstday = calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }
	
    public CalendarMonthPage() {
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        finalday = calendar.getActualMaximum(Calendar.DATE);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        firstday = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        getChildren().clear();
        paint();
    }
    
    public void paint() {
        GridPane calendar_Panel = new GridPane();
        calendar_Panel.setPrefSize(600, 420);
        String[] week = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        for (int i = 0; i < 7; i++) {
            Label label = new Label(week[i]);
            label.setAlignment(Pos.CENTER);
            label.setFont(Font.font(11));
            if (i == 0) label.setTextFill(Color.RED);
            if (i == 6) label.setTextFill(Color.BLUE);
            calendar_Panel.add(label, i, 0);
            calendar_Panel.getColumnConstraints().add(new ColumnConstraints(111));
            calendar_Panel.getRowConstraints().add(new RowConstraints(63));
            GridPane.setHalignment(label, HPos.CENTER);
            calendar_Panel.setGridLinesVisible(false);
        }
        for (int j = 0; j < finalday; j++) {
            Label label = new Label(j + 1 + "");
            label.setPrefSize(111, 63);
            label.setAlignment(Pos.CENTER);
            if (j + 1 == day) {
                label.setFont(Font.font("Cooper Black", FontWeight.BOLD, 20));
                label.setStyle("-fx-background-color: pink");
            }
            int k = firstday + j;
            if (k % 7 == 0) label.setTextFill(Color.RED);
            if (k % 7 == 6) label.setTextFill(Color.BLUE);
            calendar_Panel.add(label, k % 7, 1 + k / 7);
            GridPane.setHalignment(label, HPos.CENTER);
        }

        getChildren().add(calendar_Panel);
    }

	public void setMonthPage() {
		year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        finalday = calendar.getActualMaximum(Calendar.DATE);
        calendar.set(Calendar.DAY_OF_MONTH, 1);//将calendar设置为该月的第一天
        firstday = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        getChildren().clear();
        paint();
		
	}
}

