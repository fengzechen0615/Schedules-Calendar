package UI;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class weekTable {
	private TableView<String> weektable = new TableView<>();
	private TableView<String> setWeekTable(){
		
		weektable.setEditable(true);
		weektable.setPrefSize(800, 360);
		weektable.setMaxHeight(500);
		
		TableColumn<Object, Object> Class = new TableColumn<>("Class");
		TableColumn<Object, Object> mon = new TableColumn<>("Monday");
		TableColumn<Object, Object> tues = new TableColumn<>("Tuesday");
		TableColumn<Object, Object> wed = new TableColumn<>("Wednesday");
		TableColumn<Object, Object> thur = new TableColumn<>("Thursday");
		TableColumn<Object, Object> fri = new TableColumn<>("Friday");
		TableColumn<Object, Object> sta = new TableColumn<>("Staday");
		TableColumn<Object, Object> sun = new TableColumn<>("Sunday");
		
		
		return weektable;
	}
}
