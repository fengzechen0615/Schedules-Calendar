package UI;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import database.database;

public class Tips {

	static TextField CcourseName=new TextField();
	static TextField location = new TextField();
	public static void start() throws Exception {
		database db = new database();
		Stage window=new Stage();
		window.setTitle("Enter your course");
		window.initModality(Modality.APPLICATION_MODAL);
	    window.setWidth(300);
	    window.setHeight(489);
	    window.setResizable(false);
		VBox tips=new VBox();
		tips.setPadding(new Insets(3));
		Label label=new Label("Enter your course's name");
		Label label2=new Label("Enter your course's location");
		Button button=new Button("Save");
		button.setOnAction((ActionEvent e)->{
			String[] a = new String[4];
			a[1] = n;
			a[2] = Tips.getCourse();
			a[3] = Tips.getLocation();
			try {
				db.update(a, "schedule");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
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
	
	static String n;
	public static void getName(String name){
		n = name;
	}
	
}
