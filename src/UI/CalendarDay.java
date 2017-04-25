package UI;

import database.database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.util.Callback;


public class CalendarDay {

	private static TableView<Staff> table= new TableView<>();
	private static database db=new database();
	public static Staff[] staff=new Staff[50];
	private final static ObservableList<Staff> data =FXCollections.observableArrayList(new Staff("00:00"," "," "),
			new Staff("01:00"," "," "),
			new Staff("02:00"," "," "),
			new Staff("03:00"," "," "),
			new Staff("04:00"," "," "),
			new Staff("05:00"," "," "),
			new Staff("06:00"," "," "),
			new Staff("07:00"," "," "));
	
	public static BorderPane getDay() {
		BorderPane borderPane = new BorderPane();
		
        table= setTable();
		
		borderPane.setLeft(table);
		borderPane.setBottom(addFlowPane());
		borderPane.setRight(addflowpane2());
		
		return borderPane;
	}
	
	public static void read() throws Exception
	{
		String [][] array=new String[50][4];
		database db=new database();
		array=db.search("todolist");
		int i=0,j=data.size();
		data.clear();
		while(array[i][0]!=null)
		{
			if(i<j)
			{
				System.out.println(array[i][0]+"/"+array[i][1]+"/"+array[i][2]+"/"+array[i][3]);
				staff[i]=new Staff(array[i][1],array[i][2],array[i][3]);
				data.add(staff[i]);
				System.out.println(staff[i].getTime()+"/"+staff[i].getCourse()+"/"+staff[i].getThings());
				i++;
			}
			else
			{
				data.add(new Staff(array[i][1],array[i][2],array[i][3]));
				i++;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private static TableView<Staff> setTable()
	{
		table.setEditable(true);
		
		Callback<TableColumn<Staff, String>, 
		TableCell<Staff, String>> cellFactory= (TableColumn<Staff, String> p) -> new EditngCell();
		
		table.setPrefWidth(480);
		table.setPrefHeight(600);
		table.setMaxHeight(800);
		
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
		try {
			read();
		} catch (Exception e) {
			e.printStackTrace();
		}
		table.setItems(data);
		table.getColumns().addAll(TimeCol,CourseCol,ThingsCol);
			
		return table;
	}
	
    private static FlowPane addFlowPane() {
		
		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(10, 5, 0, 0));
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
			String[] str=new String[4];
			CalendarMonthPage c=new CalendarMonthPage();
			str[0]=""+c.getYear()+c.getMonth()+c.getDay();
			str[1]=addTime.getText();
			str[2]=addCourse.getText();
			str[3]=addThings.getText();
			addTime.clear();
			addCourse.clear();
			addThings.clear();
			try {
				db.wirteInSingle(str, "todolist");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		return flow;
	}
    
    private static FlowPane addflowpane2() {
		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(5));
		flow.setPrefWidth(330);
		
		Label sum = new Label("sum");
		sum.setMaxWidth(330);
		flow.getChildren().add(sum);
		
		return flow;
	}
  
    public static void Store()
    {
    	String[][] database = new String[50][4];
    	CalendarMonthPage c=new CalendarMonthPage();
    	for(int i=0;i<data.size();i++)
    	{
    		database[i][0]=""+c.getYear()+c.getMonth()+c.getDay();
    		database[i][1]=data.get(i).getTime();
    		database[i][2]=data.get(i).getCourse();
    		database[i][3]=data.get(i).getThings();
    	}
    	try {
			db.wirteIn(database, "todolist");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    
   /* public static void Print()
    {
    	String[][] database = new String[50][4];
    	database=Store();
    	for(int i=0;i<data.size();i++)
    	{
    		for(int j=0;j<database[i].length;j++)
    		{
    			System.out.println(database[i][j]);
    		}
    	}
    }*/
    
}
