package weeklyUI;



import javax.xml.stream.events.StartDocument;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Tips {

	static TextField CcourseName=new TextField();
	static TextField location = new TextField();
	public static void start() throws Exception {
		Stage window=new Stage();
		window.setTitle("Enter your course");
		window.initModality(Modality.APPLICATION_MODAL);
	    window.setWidth(300);
	    window.setHeight(450);
	    window.setResizable(false);
		VBox tips=new VBox();
		tips.setPadding(new Insets(3));
		Label label=new Label("Enter your course's name");
		Label label2=new Label("Enter your course's location");
		Button button=new Button("Save");
		button.setOnAction((ActionEvent e)->{
			window.close();
		});
		tips.getChildren().addAll(label, CcourseName,label2, location, button);
		
		Scene scene = new Scene(tips);
	    window.setScene(scene);
	    window.showAndWait();
	}
	
	public static String getCourse()
	{
		String string="";
		string=CcourseName.getText();
		return string;
	}
	
	public static String getLocation()
	{
		String string="";
		string=location.getText();
		return string;
	}
	
	public static void launch()
	{
		try {
			start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
