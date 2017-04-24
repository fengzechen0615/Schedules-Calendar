package UI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AboutText {
	public void display(String title, String message) {
		Stage stage = new Stage();
		stage.setTitle("About Plus1second");
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setWidth(400);
		stage.setHeight(300);
		
		Label label = new Label();
		
		Pane pane = new Pane();
		label.setPadding(new Insets(10));
		label.setText("Alpha Version Introduction \nFeatures:\n"
				+ "•	You can add new tasks or courses into the timetable.\n"
				+ "•	You can watch the interfaces directly and find if there are\n"
				+ "     \tconflictions in the timetable.\n"
				+ "•	Every data is saved in the Mysql database.\n"
				+ "•	There are still some bugs in the application. We try our\n "
				+ "     \tbest to solve them.");
		pane.getChildren().add(label);
		
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		
		stage.showAndWait();
	}

}
