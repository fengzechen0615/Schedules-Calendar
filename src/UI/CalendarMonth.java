package UI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;

public class CalendarMonth {
	
	private static BorderPane border = new BorderPane();
	private static CalendarMonthPage calendar=new CalendarMonthPage();
	private static Button pre_year=new Button("Last Year");
	private static Button next_year=new Button("Next Year");
	private static Button pre_month=new Button("Last Month");
	private static Button next_month=new Button("Next Month");
	private static TextField text_year=new TextField(""+calendar.getYear());
	private static TextField text_month=new TextField(""+calendar.getMonth());
	private static Label showdate=new Label(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
	
	public static BorderPane getMonth() {
		BorderPane borderPane = new BorderPane();
		
		borderPane.setCenter(AddStackPane());
		borderPane.setTop(addFlowPane());
		borderPane.setBottom(addFlowPane2());
		
		return borderPane;
	}
	
	private static FlowPane addFlowPane2() {
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(5,0,5,0));
		flowPane.setHgap(5);
		flowPane.setPrefWrapLength(600);
		
		showdate.setAlignment(Pos.CENTER);
		showdate.setPrefWidth(280);
        showdate.setPrefHeight(25);
		
		text_year.setPrefWidth(100);
		text_month.setPrefWidth(100);
		
		flowPane.getChildren().addAll(text_year,text_month,showdate);
		
		return flowPane;
	}

	private static FlowPane addFlowPane() {
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(5,0,5,0));
		flowPane.setHgap(5);
		flowPane.setPrefWrapLength(600);
		
		pre_year.setPrefWidth(100);
		next_year.setPrefWidth(100);
		pre_month.setPrefWidth(100);
		next_month.setPrefWidth(100);
		
		flowPane.getChildren().addAll(pre_year,next_year,pre_month,next_month);
		
		return flowPane;
	}

	private static StackPane AddStackPane() {
		StackPane gridMonth=new StackPane();
		gridMonth.getChildren().add(calendar);
		
		border.setLeft(gridMonth);
		
		//表格事件
		calendar.setOnMouseClicked(event->{
			double x=event.getX();
			double y=event.getY();
			int day = (int) y / 63 * 7 + (int) x / 111 + 1 - 7 - calendar.getFirstDayOfWeek();
            if (day > 0 && day < 32) {
                calendar.setDay(day);
                calendar.setMonthPage();
                showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
            }
		});
		
		//按钮和text文本已经备好了，你看着安吧，功能都没啥问题
		
		pre_year.setOnAction(event -> {//上一年
            int year = calendar.getYear() - 1;
            calendar.setYear(year);
            text_year.setText(year + "");
            calendar.setMonthPage();
            showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
        });
		
        next_year.setOnAction(event -> {//next year
            int year = calendar.getYear() + 1;
            calendar.setYear(year);
            text_year.setText(year + "");
            calendar.setMonthPage();
            showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
        });
        
        pre_month.setOnAction(event -> {//last month
            int month = calendar.getMonth() - 1;
            if (month < 1) {
                ;
            } else {
                calendar.setMonth(month);
                text_month.setText(month + "");
                calendar.setMonthPage();
                showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
            }
            System.out.println(calendar.getMonth());
        });
        
        next_month.setOnAction(event -> {//下一月
            int month = calendar.getMonth() + 1;
            if (month > 12) {
                ;
            } else {
                calendar.setMonth(month);
                text_month.setText(month + "");
                calendar.setMonthPage();
                showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
            }
            System.out.println(calendar.getMonth());
        });
        
        text_year.setOnAction(event -> {//输入年份
            int year = Integer.parseInt(text_year.getText());
            calendar.setYear(year);
            calendar.setMonthPage();
            showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
        });
        
        text_month.setOnAction(event -> {//输入月份
            int month = Integer.parseInt(text_month.getText());
            calendar.setMonth(month);
            calendar.setMonthPage();
            showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay() + "/");
        });
			
		return gridMonth;
	}

}
