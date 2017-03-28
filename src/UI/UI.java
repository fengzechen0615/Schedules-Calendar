package UI;

import java.time.LocalDate;
import java.util.Locale;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class UI extends Application{
	
	private DatePicker date;

	@Override
	public void start(Stage primaryStage) {
		BorderPane border = new BorderPane();
		
		HBox hBox = addHBox();
		border.setTop(hBox);
		
		primaryStage.setTitle("Schedules Calendar");
		Scene scene = new Scene(border, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private HBox addHBox() {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10, 20, 10, 240));
		hbox.setSpacing(10);
		
		Button day = new Button("Day");
		day.setPrefSize(100, 20);
		
		Button week = new Button("Week");
		week.setPrefSize(100, 20);
		
		Button month = new Button("Month");
		month.setPrefSize(100, 20);
		
		date = new DatePicker();
		date.setValue(LocalDate.now());	
    	
		hbox.getChildren().addAll(day,week,month,date);
		
        return hbox;
	}
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.CHINA);
		launch(args);
	}

}
