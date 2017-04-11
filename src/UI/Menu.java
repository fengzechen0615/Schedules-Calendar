package UI;

import javafx.application.Platform;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class Menu {
	public static MenuButton getChoice() {
		MenuButton menuButton = new MenuButton("Plus1second");
		menuButton.setMinWidth(130);
		
		MenuItem about = new MenuItem("About Plus1second");
		MenuItem exit = new MenuItem("Quit Plus1second");	

		exit.setOnAction(ActionEvent -> Platform.exit());
		about.setOnAction(e -> new AboutText().display("About Plus1second","message"));
		
		menuButton.getItems().addAll(about, exit);
		
		return menuButton;
	}
	
}
