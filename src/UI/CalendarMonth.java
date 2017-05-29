package UI;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;

public class CalendarMonth {
	
	private static BorderPane border = new BorderPane();
	private static CalendarMonthPage calendar=new CalendarMonthPage();
	private static Button pre_day=new Button("Last Day");
	private static Button next_day=new Button("Next Day");
	private static Button pre_month=new Button("Last Month");
	private static Button next_month=new Button("Next Month");
	private static TextField text_year=new TextField(""+calendar.getYear());
	private static TextField text_month=new TextField(""+calendar.getMonth());
	private static TextField text_day=new TextField(""+calendar.getDay());
	private static Label showdate=new Label(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
	
	public static Button getpreyear(){
		return pre_day;
	}
	
	public static Button getpremonth(){
		return pre_month;
	}
	
	public static TextField gettextyear(){
		return text_year;
	}
	
	public static TextField gettextmonth(){
		return text_month;
	}
	
	public static TextField gettextday(){
		return text_day;
	}
	
	public static Button getnextmonth(){
		return next_month;
	}
	
	public static Button getnextyear(){
		return next_day;
	}
	
	
	public static BorderPane getMonth() {
		BorderPane borderPane = new BorderPane();
		
		borderPane.setCenter(AddStackPane());
		borderPane.setBottom(addFlowPane());
		
		return borderPane;
	}
	
	private static FlowPane addFlowPane() {
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(5,0,5,0));
		flowPane.setHgap(5);
		flowPane.setPrefWrapLength(600);
		
		showdate.setAlignment(Pos.CENTER);
		showdate.setPrefWidth(800);
        showdate.setPrefHeight(25);
		
		flowPane.getChildren().add(showdate);
		
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
			int day = (int) y / 70 * 7 + (int) x / 111 + 1 - 7 - calendar.getFirstDayOfWeek();
            if (day > 0 && day < 32) {
                calendar.setDay(day);
                calendar.setMonthPage();
                showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
                text_day.setText(calendar.getDay()+"");
                CalendarDay.date=""+calendar.getYear()+calendar.getMonth()+calendar.getDay();
                CalendarDay.LabelChange();
                try {
					CalendarDay.readDate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
		});
		
		calendar.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
		            if(mouseEvent.getClickCount() == 2){
		                System.out.println("Double clicked");
		            }
		        }
		    }
		});
		
		
		
				
		pre_day.setOnAction(event -> {//上一年
            int day = calendar.getDay() - 1;
            calendar.setDay(day);
            text_day.setText(day + "");
            calendar.setMonthPage();
            showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
            CalendarDay.date=""+calendar.getYear()+calendar.getMonth()+calendar.getDay();
            CalendarDay.LabelChange();
            try {
				CalendarDay.readDate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
		
        next_day.setOnAction(event -> {//next year
            int day = calendar.getDay() + 1;
            calendar.setDay(day);
            text_day.setText(day + "");
            calendar.setMonthPage();
            showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
            CalendarDay.date=""+calendar.getYear()+calendar.getMonth()+calendar.getDay();
            CalendarDay.LabelChange();
            try {
				CalendarDay.readDate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
        
        pre_month.setOnAction(event -> {//last month
            int month = calendar.getMonth() - 1;
            if (month < 1) {
                calendar.setMonth(12);
                month=12;
                text_month.setText("12");
                text_day.setText("1");
                calendar.setYear(calendar.getYear()-1);
                calendar.setMonthPage();
                text_year.setText(calendar.getYear()+"");
                showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
                CalendarDay.date=""+calendar.getYear()+calendar.getMonth()+calendar.getDay();
                CalendarDay.LabelChange();
                try {
					CalendarDay.readDate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } 
            else {
                calendar.setMonth(month);
                text_month.setText(month + "");
                text_day.setText("1");
                calendar.setMonthPage();
                showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
                CalendarDay.date=""+calendar.getYear()+calendar.getMonth()+calendar.getDay();
                CalendarDay.LabelChange();
                try {
					CalendarDay.readDate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            System.out.println(calendar.getMonth());
        });
        
        next_month.setOnAction(event -> {//下一月
            int month = calendar.getMonth() + 1;
            if (month > 12) {
            	calendar.setMonth(1);
            	month=1;
            	text_month.setText("1");
            	text_day.setText("1");
                calendar.setYear(calendar.getYear()+1);
                text_year.setText(calendar.getYear()+"");
                calendar.setMonthPage();
                showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
                CalendarDay.date=""+calendar.getYear()+calendar.getMonth()+calendar.getDay();
                CalendarDay.LabelChange();
                try {
					CalendarDay.readDate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
         
        	else {
                calendar.setMonth(month);
                text_month.setText(month + "");
                text_day.setText("1");
                calendar.setMonthPage();
                showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
                CalendarDay.date=""+calendar.getYear()+calendar.getMonth()+calendar.getDay();
                CalendarDay.LabelChange();
                try {
					CalendarDay.readDate();
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
            
        });
        
        text_year.setOnAction(event -> {//输入年份
            int year = Integer.parseInt(text_year.getText());
            calendar.setYear(year);
            calendar.setMonthPage();
            CalendarDay.date=""+calendar.getYear()+calendar.getMonth()+calendar.getDay();
            showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay());
            CalendarDay.LabelChange();
            try {
				CalendarDay.readDate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
        
        text_month.setOnAction(event -> {//输入月份
            int month = Integer.parseInt(text_month.getText());
            calendar.setMonth(month);
            calendar.setMonthPage();
            showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay() + "/");
            CalendarDay.date=""+calendar.getYear()+calendar.getMonth()+calendar.getDay();
            CalendarDay.LabelChange();
            try {
				CalendarDay.readDate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
			
        text_day.setOnAction(event -> {//输入月份
            int day = Integer.parseInt(text_day.getText());
			calendar.setDay(day);
            calendar.setMonthPage();
            showdate.setText(calendar.getYear() + "/" + calendar.getMonth() + "/" + calendar.getDay() + "/");
            CalendarDay.date=""+calendar.getYear()+calendar.getMonth()+calendar.getDay();
            CalendarDay.LabelChange();
            try {
				CalendarDay.readDate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
		return gridMonth;
	}

}
