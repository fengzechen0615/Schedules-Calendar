package UI;

import javafx.application.Platform;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class Menu {
	public static MenuButton getChoice() {
		MenuButton menuButton = new MenuButton("Plus1second");
		
		MenuItem about = new MenuItem("About Plus1second");
		MenuItem exit = new MenuItem("Exit Plus1second");	

		exit.setOnAction(ActionEvent -> Platform.exit());
		
		menuButton.getItems().addAll(about, exit);
		
		return menuButton;
	}

}
