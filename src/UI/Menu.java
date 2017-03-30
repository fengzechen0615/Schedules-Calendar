package UI;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class Menu {
	public static MenuButton getChoice() {
		MenuButton menuButton = new MenuButton("Schedules Calendar");
		
		MenuItem about = new MenuItem("About Schedules Calendar");
		MenuItem exit = new MenuItem("Exit Schedules Calendar");
		
		menuButton.getItems().addAll(about, exit);
		
		return menuButton;
	}

}
