package UI;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;

public class UITabPane {
	public static TabPane getTabPane() {
		TabPane tab = new TabPane();
		tab.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tab.setTabMinWidth(100);
		
		Tab tab_day = new Tab("Day");
		tab_day.setContent(CalendarDay.getDay());
		
		Tab tab_week = new Tab("Week");
		//tab_week.setContent(CalendarWeek.getWeek());
		
		Tab tab_month = new Tab("Month");
		tab_month.setContent(CalendarMonth.getMonth());
		
		tab.getTabs().add(tab_day);
		tab.getTabs().add(tab_week);
		tab.getTabs().add(tab_month);
		
		return tab;
		
	}
}
