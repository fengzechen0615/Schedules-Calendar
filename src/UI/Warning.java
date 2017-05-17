package UI;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Warning {
	

	public void launch()
	{
		Stage window =new Stage();
		window.setTitle("Warning");
		window.setWidth(200);
		window.setHeight(100);
		
		
		VBox tips=new VBox();
		tips.setPadding(new Insets(3));
		
		Label label=new Label();
		
		label.setText("Please Enter Valid Time Data\n"
				+ "Please Enter Again");
		
		tips.getChildren().add(label);
		Button button=new Button("OK");
		button.setOnAction((ActionEvent e)->{
			window.close();
		});
		
		tips.getChildren().add(button);
		
		
		Scene scene = new Scene(tips);
		window.setScene(scene);
		window.setResizable(false);
		
		window.showAndWait();
		
	}
}
