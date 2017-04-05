package UI;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class weekTable {
	private TableView<Object> weektable = new TableView<>();
	TableView<Object> setWeekTable(){
		
		weektable.setEditable(true);
		weektable.setPrefSize(800, 360);
		weektable.setMaxHeight(500);
		
		TableColumn<Object, Object> classes = new TableColumn<>("Class");
		classes.setPrefWidth(100);
		classes.setCellValueFactory(new PropertyValueFactory<>("classesNmae"));	
		TableColumn<Object, Object> mon = new TableColumn<>("Monday");
		mon.setPrefWidth(100);
		
		TableColumn<Object, Object> tues = new TableColumn<>("Tuesday");
		tues.setPrefWidth(100);
		
		TableColumn<Object, Object> wed = new TableColumn<>("Wednesday");
		wed.setPrefWidth(100);
		
		TableColumn<Object, Object> thur = new TableColumn<>("Thursday");
		thur.setPrefWidth(100);
		
		TableColumn<Object, Object> fri = new TableColumn<>("Friday");
		fri.setPrefWidth(100);
		
		TableColumn<Object, Object> sta = new TableColumn<>("Staday");
		sta.setPrefWidth(100);
		
		TableColumn<Object, Object> sun = new TableColumn<>("Sunday");
		sun.setPrefWidth(100);
		
		weektable.getColumns().addAll(classes,mon,tues,wed,thur,fri,sta,sun);
		
		
		TableRow<Object> frist = new TableRow<>();
		frist.setPrefWidth(100);
		frist.setPrefHeight(100);
		TableRow<Object> second = new TableRow<>();
		second.setPrefWidth(100);
		
	
		return weektable;
	}
}
