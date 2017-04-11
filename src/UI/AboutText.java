package UI;

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
		pane.getChildren().add(label);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		
		stage.showAndWait();
	}

}
