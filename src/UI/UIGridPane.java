package UI;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class UIGridPane {
	public static GridPane getGridPane() {
		GridPane gridPane = new GridPane();
		gridPane.setHgap(1);
		gridPane.setVgap(0);
		gridPane.setPadding(new Insets(0, 0, 8, 0));
		
		CalendarMonth.getpreyear().setPrefWidth(90);
		CalendarMonth.getnextyear().setPrefWidth(90);
		CalendarMonth.getpremonth().setPrefWidth(90);
		CalendarMonth.getnextmonth().setPrefWidth(90);
		CalendarMonth.gettextday().setPrefWidth(50);
		CalendarMonth.gettextmonth().setPrefWidth(50);
		CalendarMonth.gettextyear().setPrefWidth(50);
		
		gridPane.add(Menu.getChoice(), 0, 0);
		gridPane.add(CalendarMonth.getpreyear(), 104, 0);
		gridPane.add(CalendarMonth.getnextyear(), 110, 0);
		gridPane.add(CalendarMonth.getpremonth(), 105, 0);
		gridPane.add(CalendarMonth.getnextmonth(), 109, 0);
		gridPane.add(CalendarMonth.gettextday(), 108, 0);
		gridPane.add(CalendarMonth.gettextmonth(), 107, 0);
		gridPane.add(CalendarMonth.gettextyear(), 106, 0);
		
		
		gridPane.setGridLinesVisible(false);
		
		return gridPane;
	}

}
