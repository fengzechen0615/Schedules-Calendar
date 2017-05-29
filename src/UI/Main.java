package UI;

import java.awt.Dimension;
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;

import javafx.application.Application;  
import javafx.event.ActionEvent;  
import javafx.event.EventHandler;  
import javafx.geometry.Insets;  
import javafx.geometry.Pos;  
import javafx.scene.Scene;  
import javafx.scene.control.Button;  
import javafx.scene.control.Label;  
import javafx.scene.control.PasswordField;  
import javafx.scene.control.TextField;  
import javafx.scene.layout.GridPane;  
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;  
import javafx.stage.Stage;  

import database.database;

public class Main extends Application {  
	  
    private Connection conn;  
    private PreparedStatement ps;  
    private ResultSet rs;  
    TextField userTextField = new TextField(); 
    TextField passField = new TextField(); 
    private GridPane grid;  
    private String user;
    private String pass;
    
    
    
    public static void main(String[] args) throws Exception {
    	launch(args);
    	
    }  
      
    @Override  
    public void start(final Stage primaryStage) throws Exception {  
        //窗口标题  
    	
        primaryStage.setTitle("Welcome");  
        //设置面板及布局  
        String u;
        String p;
        grid = new GridPane();  
        grid.setAlignment(Pos.CENTER);  
        grid.setHgap(10);  
        grid.setVgap(10);  
        grid.setPadding(new Insets(25));  
        //文本框  
        Text scenetitle = new Text("Welcome");  
        scenetitle.setId("welcome-text");  
        grid.add(scenetitle, 0, 0, 2, 1);  
        //标签  
        Label userName = new Label("MySQL User:");  
        grid.add(userName, 0, 1);  
        //文本输入框  
        //final TextField userTextField = new TextField();  
        userTextField.setOnAction(event ->{
        	user=String.valueOf(userTextField.getText());
        });
        grid.add(userTextField, 1, 1);  
        Label passwd = new Label("Password");  
        grid.add(passwd, 0, 2);  
        //密码输入框  
        //PasswordField passwdField = new PasswordField();  
        passField.setOnAction(event ->{
        	pass=String.valueOf(passField.getText());
        });
        grid.add(passField, 1, 2);  
        //按钮及按钮布局  
        Button btn = new Button("Log in");  
        HBox hbBtn = new HBox(10);  
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);  
        hbBtn.getChildren().add(btn);  
        grid.add(hbBtn, 1, 4);  
         
        //登陆按钮单击事件  
        btn.setOnAction(new EventHandler<ActionEvent>() {  
            @Override  
            public void handle(ActionEvent arg0) {  
                
                VBox root = new VBox();
                user=String.valueOf(userTextField.getText());
                pass=String.valueOf(passField.getText());
        		root.setPadding(new Insets(10));
        		database db = new database();
        		try {
					db.setUp(user, pass);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
        		
        		
				
        		root.getChildren().add(UIGridPane.getGridPane());
        		try {
					root.getChildren().add(UITabPane.getTabPane());
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        		int screenWidth = screenSize.width;
        		int screenHight = screenSize.height;
        		
                Scene scene = new Scene(root, 800, 600);
                
                primaryStage.setScene(scene);
                primaryStage.setTitle("Plus1second");
                primaryStage.setResizable(false);
                primaryStage.setX(screenWidth/2 - 400);
                primaryStage.setY(screenHight/2 - 300);
                   
            }  
        });  
        
        Scene scene = new Scene(grid,300,275);  
        primaryStage.setScene(scene);  
        primaryStage.show();  
    }  
      
}  
