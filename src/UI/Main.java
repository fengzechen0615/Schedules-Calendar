package UI;

import database.database;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setPadding(new Insets(10));
		
		root.getChildren().add(UIGridPane.getGridPane());
		root.getChildren().add(UITabPane.getTabPane());
		
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.setTitle("Plus1second");
		primaryStage.setResizable(false);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
		database one = new database();
		String[][] a = CalendarDay.Store();
		try {
			one.wirteInSingle(a, "todolist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
