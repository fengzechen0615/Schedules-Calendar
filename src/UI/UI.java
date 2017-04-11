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
import javafx.scene.control.TableRow;
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
	private  TableView<Course> table2= new TableView<>();
	private final ObservableList<Staff> data =FXCollections.observableArrayList(
			new Staff("8:00","Math","Worksheet"));
	private BorderPane border = new BorderPane();
	
	@Override
	public void start(Stage primaryStage) {
		table=setTable();
		weekTable wTable=new weekTable();
		TableView<Object> table2=wTable.setWeekTable();
		table2.setVisible(true);
		border.setLeft(table2);
		
		table.setVisible(false);
		
		border.setBottom(addFlowPane());		
		border.setTop(addgp());
		border.setRight(addflowpane2());

		primaryStage.setTitle("Schedules Calendar");
		Scene scene = new Scene(border, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
	private FlowPane addflowpane2() {
		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(5));
		flow.setPrefWidth(330);
		
		Label sum = new Label("sum");
		sum.setMaxWidth(330);
		flow.getChildren().add(sum);
		
		return flow;
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
	
	private TableView<Course> WeekPage()
	{
		table2.setEditable(true);
		Callback<TableColumn<Staff, String>, 
		TableCell<Staff, String>> cellFactory= (TableColumn<Staff, String> p) -> new EditngCell();
		table2.setPrefSize(640, 480);
		TableRow<Course> Timerow=new TableRow<>();
		Timerow.setPrefSize(70, 60);
		
		TableColumn<Course,String> Mon=new TableColumn<>("Monday");
		Mon.setPrefWidth(60);
		
		TableColumn<Course,String> Tue=new TableColumn<>("Tuesday");
		Tue.setPrefWidth(60);
		
		TableColumn<Course,String> Wed=new TableColumn<>("Wednesday");
		Wed.setPrefWidth(60);
		
		
		TableColumn<Course,String> Thur=new TableColumn<>("Thursday");
		Thur.setPrefWidth(60);
		
		TableColumn<Course,String> Fri=new TableColumn<>("Friday");
		Fri.setPrefWidth(60);
		
		TableColumn<Course,String> Sat=new TableColumn<>("Saturday");
		Sat.setPrefWidth(60);
		
		TableColumn<Course,String> Sun=new TableColumn<>("Sunday");
		Sun.setPrefWidth(60);
		
		table2.getColumns().addAll(Mon,Tue,Wed,Thur,Fri,Sat,Sun);
		
		
		
		
		
		return table2;
	}
	
	
		
	public static void main(String[] args) {
		Locale.setDefault(Locale.CHINA);
		launch(args);
	}

}
