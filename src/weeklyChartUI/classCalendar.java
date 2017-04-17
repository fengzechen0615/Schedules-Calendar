package weeklyChartUI;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class classCalendar extends Application {

    private final TableView<classes> table = new TableView<>();
    private final ObservableList<classes> data =
            FXCollections.observableArrayList(
    	            new classes("8:00-9:00", " ", " "," "," "," ", " "," "));
    final HBox hb = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(850);
        stage.setHeight(800);

        final Label label = new Label("weekly classes");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn<classes, String> timeCol = 
            new TableColumn<>("Time");
        timeCol.setMinWidth(100);
        timeCol.setCellValueFactory(
            new PropertyValueFactory<>("Time"));

        timeCol.setCellFactory(TextFieldTableCell.<classes>forTableColumn());
        timeCol.setOnEditCommit(
            (CellEditEvent<classes, String> t) -> {
                ((classes) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setclasstime(t.getNewValue());
        });


        TableColumn<classes, String> monCol = new TableColumn<>("Monday");
        monCol.setMinWidth(100);
        monCol.setCellValueFactory(
            new PropertyValueFactory<>("Monday"));
        monCol.setCellFactory(TextFieldTableCell.<classes>forTableColumn());
        monCol.setOnEditCommit(
            (CellEditEvent<classes, String> t) -> {
                ((classes) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setMon(t.getNewValue());
        });

        TableColumn<classes, String> thuesCol = new TableColumn<>("Thuesday");
        thuesCol.setMinWidth(100);
        thuesCol.setCellValueFactory(
            new PropertyValueFactory<>("Thuesday"));
        thuesCol.setCellFactory(TextFieldTableCell.<classes>forTableColumn());       
        thuesCol.setOnEditCommit(
            (CellEditEvent<classes, String> t) -> {
                ((classes) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setThues(t.getNewValue());
        });
        
        TableColumn<classes, String> wedCol = new TableColumn<>("Wedsday");
        wedCol.setMinWidth(100);
        wedCol.setCellValueFactory(
            new PropertyValueFactory<>("Wedday"));
        wedCol.setCellFactory(TextFieldTableCell.<classes>forTableColumn());       
        wedCol.setOnEditCommit(
            (CellEditEvent<classes, String> t) -> {
                ((classes) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setWed(t.getNewValue());
        });
        
        TableColumn<classes, String> thurslCol = new TableColumn<>("Thursday");
        thurslCol.setMinWidth(100);
        thurslCol.setCellValueFactory(
            new PropertyValueFactory<>("Thursday"));
        thurslCol.setCellFactory(TextFieldTableCell.<classes>forTableColumn());       
        thurslCol.setOnEditCommit(
            (CellEditEvent<classes, String> t) -> {
                ((classes) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setThur(t.getNewValue());
        });
        
        TableColumn<classes, String> friCol = new TableColumn<>("Friday");
        friCol.setMinWidth(100);
        friCol.setCellValueFactory(
            new PropertyValueFactory<>("Friday"));
        friCol.setCellFactory(TextFieldTableCell.<classes>forTableColumn());       
        friCol.setOnEditCommit(
            (CellEditEvent<classes, String> t) -> {
                ((classes) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setFri(t.getNewValue());
        });
        
        TableColumn<classes, String> satCol = new TableColumn<>("Saturday");
        satCol.setMinWidth(100);
        satCol.setCellValueFactory(
            new PropertyValueFactory<>("Saturday"));
        satCol.setCellFactory(TextFieldTableCell.<classes>forTableColumn());       
        satCol.setOnEditCommit(
            (CellEditEvent<classes, String> t) -> {
                ((classes) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setSat(t.getNewValue());
        });
        
        TableColumn<classes, String> sunCol = new TableColumn<>("Sunday");
        sunCol.setMinWidth(100);
        sunCol.setCellValueFactory(
            new PropertyValueFactory<>("Sunday"));
        sunCol.setCellFactory(TextFieldTableCell.<classes>forTableColumn());       
        sunCol.setOnEditCommit(
            (CellEditEvent<classes, String> t) -> {
                ((classes) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setSun(t.getNewValue());
        });

        table.setItems(data);
        table.getColumns().addAll(timeCol, monCol, thuesCol, wedCol, thurslCol, friCol, satCol, sunCol);

        final TextField addTime = new TextField();
        addTime.setPromptText("Time");
        addTime.setMaxWidth(timeCol.getPrefWidth());
        final TextField addMon = new TextField();
        addMon.setMaxWidth(monCol.getPrefWidth());
        addMon.setPromptText("Mon");
        final TextField addThues = new TextField();
        addThues.setMaxWidth(thuesCol.getPrefWidth());
        addThues.setPromptText("Thues");
        final TextField addWed = new TextField();
        addWed.setMaxWidth(wedCol.getPrefWidth());
        addWed.setPromptText("Wed");
        final TextField addThurs = new TextField();
        addThurs.setMaxWidth(thuesCol.getPrefWidth());
        addThurs.setPromptText("Thurs");
        final TextField addFri = new TextField();
        addFri.setMaxWidth(friCol.getPrefWidth());
        addFri.setPromptText("Fri");
        final TextField addSat = new TextField();
        addSat.setMaxWidth(satCol.getPrefWidth());
        addSat.setPromptText("Sat");
        final TextField addSun = new TextField();
        addSun.setMaxWidth(thuesCol.getPrefWidth());
        addSun.setPromptText("Sun");

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            data.add(new classes(
                    addTime.getText(),
                    addMon.getText(),
                    addThues.getText(),
                    addWed.getText(),
                    addThurs.getText(),
                    addFri.getText(),
                    addSat.getText(),
                    addSun.getText()));
            addTime.clear();
            addMon.clear();
            addThues.clear();
            addWed.clear();
            addThurs.clear();
            addFri.clear();
            addSat.clear();
            addSun.clear();
            
        });

        hb.getChildren().addAll(addTime, addMon, addThues, addWed, addThurs, addFri, addSat, addSun, addButton);
        hb.setSpacing(8);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
}