package User_Interface;

import java.time.LocalDate;
import java.util.Locale;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class UI extends Application {
	
	private Stage stage;
	private DatePicker data;
	
	@Override
	public void start(Stage stage) {
		this.stage = stage;
		stage.setTitle("Schedules-Calender");
		initUI();
		stage.show();
	 }
	   
	 private void initUI() {
	       VBox vbox = new VBox(20);
	       vbox.setStyle("-fx-padding: 10;");
	       Scene scene = new Scene(vbox, 1000, 600);
	       stage.setScene(scene);
	 
	       data = new DatePicker();
	       data.setValue(LocalDate.now());
	 
	       GridPane gridPane = new GridPane();
	       gridPane.setHgap(10);
	       gridPane.setVgap(10);
	 
	       Label label = new Label("Date:");
	       gridPane.add(label, 0, 0);
	       GridPane.setHalignment(label, HPos.LEFT);
	 
	       gridPane.add(data, 1, 0);
	 
	       vbox.getChildren().add(gridPane);
	       gridPane.setGridLinesVisible(true);
	   }
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		launch(args);
	}
}
