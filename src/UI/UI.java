package UI;

import java.time.LocalDate;
import java.util.Locale;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class UI extends Application{
	
	private DatePicker date;
	private  TableView<Staff> table= new TableView<>();
	private final ObservableList<Staff> data =FXCollections.observableArrayList(
			new Staff("8:00","Math","Worksheet"));
	private BorderPane border = new BorderPane();
	
	@Override
	public void start(Stage primaryStage) {
		//HBox h2box = add2HBox(addgp2());
		//h2box.setMaxWidth(480);
		table=setTable();
		
		border.setLeft(table);;
		border.setBottom(addFlowPane());		
		border.setTop(addgp());
		border.setRight(addgd2());

		primaryStage.setTitle("Schedules Calendar");
		Scene scene = new Scene(border, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private GridPane addgd2() {
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(0, 10, 0, 10));
		
		Label sp = new Label("Sum up");
		grid.add(sp, 10, 0);
		
		//grid.setGridLinesVisible(true);
		
		return grid;
	}
	
	private FlowPane addFlowPane() {
		
		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(0, 5, 12, 0));
		flow.setVgap(4);
		flow.setHgap(4);
		flow.setPrefWrapLength(470);
		
		final TextField addTime=new TextField();
		addTime.setPromptText("Time");
		addTime.setMaxWidth(60);
		flow.getChildren().add(addTime);
		
		final TextField addCourse=new TextField();
		addCourse.setPromptText("Course");
		addCourse.setPrefWidth(180);
		flow.getChildren().add(addCourse);
		
		final TextField addThings=new TextField();
		addThings.setPromptText("Things");
		addThings.setPrefWidth(180);
		flow.getChildren().add(addThings);
		
		final Button addButton = new Button("Add");
		addButton.setPrefWidth(50);
		flow.getChildren().add(addButton);
		
		addButton.setOnAction((ActionEvent e)->
		{
			data.add(new Staff(addTime.getText(),addCourse.getText(),addThings.getText()));
			addTime.clear();
			addCourse.clear();
			addThings.clear();
			
		});
		
		return flow;
	}

	/*private HBox add2HBox() {
		HBox hbox=new HBox();
		final TextField addTime=new TextField();
		addTime.setPromptText("Time");
		addTime.setMaxWidth(60);
		
		final TextField addCourse=new TextField();
		addCourse.setPromptText("Course");
		addCourse.setPrefWidth(180);
		
		final TextField addThings=new TextField();
		addThings.setPromptText("Things");
		addThings.setPrefWidth(180);
		
		final Button addButton = new Button("Add");
		addButton.setPrefWidth(50);
		addButton.setOnAction((ActionEvent e)->
		{
			data.add(new Staff(addTime.getText(),addCourse.getText(),addThings.getText()));
			addTime.clear();
			addCourse.clear();
			addThings.clear();
			
		});
		hbox.getChildren().addAll(addTime,addCourse,addThings,addButton);
		hbox.setSpacing(2);
		return hbox;
	}*/
	/*private GridPane addgp2() {
		
		GridPane grid = new GridPane();
		grid.setHgap(4);
		grid.setVgap(4);
		grid.setPadding(new Insets(0, 5, 5, 5));
		
		final TextField addTime=new TextField();
		addTime.setPromptText("Time");
		addTime.setMaxWidth(60);
		grid.add(addTime, 0, 1);
		
		final TextField addCourse=new TextField();
		addCourse.setPromptText("Course");
		addCourse.setPrefWidth(180);
		grid.add(addCourse, 0, 2);
		
		final TextField addThings=new TextField();
		addThings.setPromptText("Things");
		addThings.setPrefWidth(180);
		grid.add(addThings, 0, 3);
		
		final Button addButton = new Button("Add");
		addButton.setPrefWidth(50);
		grid.add(addTime, 0, 4);
		
		addButton.setOnAction((ActionEvent e)->
		{
			data.add(new Staff(addTime.getText(),addCourse.getText(),addThings.getText()));
			addTime.clear();
			addCourse.clear();
			addThings.clear();
			
		});
		
		return grid;
	}*/
	
	private GridPane addgp() {
		GridPane grid = new GridPane(); 
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 10, 10, 10));
		
		Button day = new Button("Day");
		day.setPrefSize(80, 20);
	    grid.add(day,15, 1);
	    
	    Button week = new Button("Week");
	    week.setPrefSize(80, 20);
	    grid.add(week, 16, 1);
	    
	    Button month = new Button("Month");
		month.setPrefSize(80, 20);
		grid.add(month, 17, 1);
		
		date = new DatePicker();
		date.setValue(LocalDate.now());	
		grid.add(date, 30, 1);
	    
		grid.setGridLinesVisible(false);
		
		return grid;
	}

	@SuppressWarnings("unchecked")
	private TableView<Staff> setTable()
	{
		table.setEditable(true);
		
		Callback<TableColumn<Staff, String>, 
		TableCell<Staff, String>> cellFactory= (TableColumn<Staff, String> p) -> new EditngCell();
		
		table.setPrefSize(480, 360);
		table.setMaxHeight(500);
		
		TableColumn<Staff,String> TimeCol=new TableColumn<>("Time");
		TimeCol.setPrefWidth(60);
		TimeCol.setMinWidth(60);
		TimeCol.setMaxWidth(100);
		TimeCol.setCellValueFactory(new PropertyValueFactory<>("Time"));
		TimeCol.setCellFactory(cellFactory);
		TimeCol.setOnEditCommit((CellEditEvent<Staff,String> t)->
		{
			((Staff) t.getTableView().getItems().get(
					t.getTablePosition().getRow())).setTime(
							t.getNewValue());
		});
				
		
		TableColumn<Staff,String> CourseCol=new TableColumn<>("Course");
		CourseCol.setPrefWidth(210);
		CourseCol.setMinWidth(190);
		CourseCol.setMaxWidth(210);
		CourseCol.setCellValueFactory(new PropertyValueFactory<>("Course"));
		CourseCol.setCellFactory(cellFactory);
		CourseCol.setOnEditCommit((CellEditEvent<Staff,String> t)->
		{
			((Staff) t.getTableView().getItems().get(
					t.getTablePosition().getRow())).setCourse(
							t.getNewValue());
		});
		
		TableColumn<Staff,String> ThingsCol=new TableColumn<>("Things");
		ThingsCol.setPrefWidth(210);
		ThingsCol.setMinWidth(190);
		ThingsCol.setMaxWidth(210);
		ThingsCol.setCellValueFactory(new PropertyValueFactory<>("Things"));
		ThingsCol.setCellFactory(cellFactory);
		ThingsCol.setOnEditCommit((CellEditEvent<Staff,String> t)->
		{
			((Staff) t.getTableView().getItems().get(
					t.getTablePosition().getRow())).setThings(
							t.getNewValue());
		});
		
		table.setItems(data);
		table.getColumns().addAll(TimeCol,CourseCol,ThingsCol);
		
		
		return table;
	}
	

	/*private HBox addHBox() {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10, 20, 10, 240));
		hbox.setSpacing(10);
		
		Button day = new Button("Day");
		day.setPrefSize(100, 20);
		
		Button week = new Button("Week");
		week.setPrefSize(100, 20);
		
		Button month = new Button("Month");
		month.setPrefSize(100, 20);
		
		date = new DatePicker();
		date.setValue(LocalDate.now());	
    	
		hbox.getChildren().addAll(day,week,month,date);
		
        return hbox;
	}*/
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.CHINA);
		launch(args);
	}

}