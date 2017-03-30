package UI;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class UIGridPane {
	public static GridPane getGridPane() {
		GridPane gridPane = new GridPane();
		gridPane.setHgap(71);
		gridPane.setVgap(0);
		gridPane.setPadding(new Insets(0, 0, 8, 0));
		
		gridPane.add(Menu.getChoice(), 0, 0);
		gridPane.add(Datepicker.getDatepicker(), 6, 0);
		
		gridPane.setGridLinesVisible(false);
		
		return gridPane;
	}

}
