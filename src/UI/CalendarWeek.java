package UI;

import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class CalendarWeek {
	public static Pane getWeek() {
		Pane pane = new Pane();
		pane.getChildren().add(Button());
		
		return pane;
	}

	private static GridPane Button() {
		
		GridPane root = new GridPane();
		
        Text t1 = new Text("8:00~9:35");
        Text t3 = new Text("9:55~11:30");
        Text t5 = new Text("13:30~15:05");
        Text t7 = new Text("15:25~17:00");
        Text t9 = new Text("18:00~19:30");
        Text t11 = new Text("19:55~21:00");
        
        Text mon = new Text("Monday");
        Text thues = new Text("Thuesday");
        Text wed = new Text("Wednesday");
        Text thur = new Text("Thursday");
        Text fri = new Text("Friday");
        Text sat = new Text("Saturday");
        Text sun = new Text("Sunday");
        
        t1.setWrappingWidth(84);
        t1.setTextAlignment(TextAlignment.CENTER);
        t3.setWrappingWidth(84);
        t3.setTextAlignment(TextAlignment.CENTER);
        t5.setWrappingWidth(84);
        t5.setTextAlignment(TextAlignment.CENTER);
        t7.setWrappingWidth(84);
        t7.setTextAlignment(TextAlignment.CENTER);
        t9.setWrappingWidth(84);
        t9.setTextAlignment(TextAlignment.CENTER);
        t11.setWrappingWidth(84);
        t11.setTextAlignment(TextAlignment.CENTER);
        
        mon.setWrappingWidth(89);
        mon.setTextAlignment(TextAlignment.CENTER);
        thues.setWrappingWidth(89);
        thues.setTextAlignment(TextAlignment.CENTER);
        wed.setWrappingWidth(89);
        wed.setTextAlignment(TextAlignment.CENTER);
        thur.setWrappingWidth(89);
        thur.setTextAlignment(TextAlignment.CENTER);
        fri.setWrappingWidth(89);
        fri.setTextAlignment(TextAlignment.CENTER);
        sat.setWrappingWidth(89);
        sat.setTextAlignment(TextAlignment.CENTER);
        sun.setWrappingWidth(89);
        sun.setTextAlignment(TextAlignment.CENTER);
        
        Button mon1 = new Button();
        mon1.setText("+");
     	mon1.setMinSize(89, 70);
     	mon1.setMaxSize(89, 70);
     	
        mon1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                mon1.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
               // primaryStage.show();
            }
        });
        
        Button mon2 = new Button();
        mon2.setText("+");
     	mon2.setMinSize(89, 70);
     	mon2.setMaxSize(89, 70);
        mon2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                mon2.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button mon3 = new Button();
        mon3.setText("+");
     	mon3.setMinSize(89, 70);
     	mon3.setMaxSize(89, 70);
        mon3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                mon3.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button mon4 = new Button();
        mon4.setText("+");
     	mon4.setMinSize(89, 70);
     	mon4.setMaxSize(89, 70);
        mon4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                mon4.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button mon5 = new Button();
        mon5.setText("+");
     	mon5.setMinSize(89, 70);
     	mon5.setMaxSize(89, 70);
        mon5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                mon5.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button mon6 = new Button();
        mon6.setText("+");
     	mon6.setMinSize(89, 70);
     	mon6.setMaxSize(89, 70);
        mon6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                mon6.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button thues1 = new Button();
        thues1.setText("+");
     	thues1.setMinSize(89, 70);
     	thues1.setMaxSize(89, 70);
        thues1.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                thues1.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button thues2 = new Button();
        thues2.setText("+");
     	thues2.setMinSize(89, 70);
     	thues2.setMaxSize(89, 70);
        thues2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                thues2.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button thues3 = new Button();
        thues3.setText("+");
     	thues3.setMinSize(89, 70);
     	thues3.setMaxSize(89, 70);
        thues3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                thues3.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button thues4 = new Button();
        thues4.setText("+");
     	thues4.setMinSize(89, 70);
     	thues4.setMaxSize(89, 70);
        thues4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                thues4.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button thues5 = new Button();
        thues5.setText("+");
     	thues5.setMinSize(89, 70);
     	thues5.setMaxSize(89, 70);
        thues5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                thues5.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button thues6 = new Button();
        thues6.setText("+");
     	thues6.setMinSize(89, 70);
     	thues6.setMaxSize(89, 70);
        thues6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                thues6.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        Button wed1 = new Button();
        wed1.setText("+");
     	wed1.setMinSize(89, 70);
     	wed1.setMaxSize(89, 70);
        wed1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                wed1.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button wed2 = new Button();
        wed2.setText("+");
     	wed2.setMinSize(89, 70);
     	wed2.setMaxSize(89, 70);
        wed2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                wed2.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button wed3 = new Button();
        wed3.setText("+");
     	wed3.setMinSize(89, 70);
     	wed3.setMaxSize(89, 70);
        wed3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                wed3.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button wed4 = new Button();
        wed4.setText("+");
     	wed4.setMinSize(89, 70);
     	wed4.setMaxSize(89, 70);
        wed4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                wed4.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button wed5 = new Button();
        wed5.setText("+");
     	wed5.setMinSize(89, 70);
     	wed5.setMaxSize(89, 70);
        wed5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                wed5.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button wed6 = new Button();
        wed6.setText("+");
     	wed6.setMinSize(89, 70);
     	wed6.setMaxSize(89, 70);
        wed6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                wed6.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        Button thur1 = new Button();
        thur1.setText("+");
     	thur1.setMinSize(89, 70);
     	thur1.setMaxSize(89, 70);
        thur1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                thur1.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button thur2 = new Button();
        thur2.setText("+");
     	thur2.setMinSize(89, 70);
     	thur2.setMaxSize(89, 70);
        thur2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                thur2.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button thur3 = new Button();
        thur3.setText("+");
     	thur3.setMinSize(89, 70);
     	thur3.setMaxSize(89, 70);
        thur3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                thur3.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button thur4 = new Button();
        thur4.setText("+");
     	thur4.setMinSize(89, 70);
     	thur4.setMaxSize(89, 70);
        thur4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                thur4.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button thur5 = new Button();
        thur5.setText("+");
     	thur5.setMinSize(89, 70);
     	thur5.setMaxSize(89, 70);
        thur5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                thur5.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button thur6 = new Button();
        thur6.setText("+");
     	thur6.setMinSize(89, 70);
     	thur6.setMaxSize(89, 70);
        thur6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                thur6.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        Button fri1 = new Button();
        fri1.setText("+");
     	fri1.setMinSize(89, 70);
     	fri1.setMaxSize(89, 70);
        fri1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                fri1.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button fri2 = new Button();
        fri2.setText("+");
     	fri2.setMinSize(89, 70);
     	fri2.setMaxSize(89, 70);
        fri2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                fri2.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button fri3 = new Button();
        fri3.setText("+");
     	fri3.setMinSize(89, 70);
     	fri3.setMaxSize(89, 70);
        fri3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                fri3.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button fri4 = new Button();
        fri4.setText("+");
     	fri4.setMinSize(89, 70);
     	fri4.setMaxSize(89, 70);
        fri4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                fri4.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button fri5 = new Button();
        fri5.setText("+");
     	fri5.setMinSize(89, 70);
     	fri5.setMaxSize(89, 70);
        fri5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                fri5.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button fri6 = new Button();
        fri6.setText("+");
     	fri6.setMinSize(89, 70);
     	fri6.setMaxSize(89, 70);
        fri6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                fri6.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        Button sat1 = new Button();
        sat1.setText("+");
     	sat1.setMinSize(89, 70);
     	sat1.setMaxSize(89, 70);
        sat1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                sat1.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button sat2 = new Button();
        sat2.setText("+");
     	sat2.setMinSize(89, 70);
     	sat2.setMaxSize(89, 70);
        sat2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                sat2.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button sat3 = new Button();
        sat3.setText("+");
     	sat3.setMinSize(89, 70);
     	sat3.setMaxSize(89, 70);
        sat3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                sat3.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button sat4 = new Button();
        sat4.setText("+");
     	sat4.setMinSize(89, 70);
     	sat4.setMaxSize(89, 70);
        sat4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                sat4.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button sat5 = new Button();
        sat5.setText("+");
     	sat5.setMinSize(89, 70);
     	sat5.setMaxSize(89, 70);
        sat5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                sat5.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button sat6 = new Button();
        sat6.setText("+");
     	sat6.setMinSize(89, 70);
     	sat6.setMaxSize(89, 70);
        sat6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                sat6.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        Button sun1 = new Button();
        sun1.setText("+");
     	sun1.setMinSize(89, 70);
     	sun1.setMaxSize(89, 70);
        sun1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                sun1.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button sun2 = new Button();
        sun2.setText("+");
     	sun2.setMinSize(89, 70);
     	sun2.setMaxSize(89, 70);
        sun2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                sun2.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button sun3 = new Button();
        sun3.setText("+");
     	sun3.setMinSize(89, 70);
     	sun3.setMaxSize(89, 70);
        sun3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                sun3.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button sun4 = new Button();
        sun4.setText("+");
     	sun4.setMinSize(89, 70);
     	sun4.setMaxSize(89, 70);
        sun4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                sun4.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button sun5 = new Button();
        sun5.setText("+");
     	sun5.setMinSize(89, 70);
     	sun5.setMaxSize(89, 70);
        sun5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                sun5.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        Button sun6 = new Button();
        sun6.setText("+");
     	sun6.setMinSize(89, 70);
     	sun6.setMaxSize(89, 70);
        sun6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Tips.launch();
                System.out.println("!");
                sun6.setText(Tips.getCourse()+"\n@"+Tips.getLocation());
            }
        });
        
        root.setPadding(new Insets(10, 0, 10, 0));
        
        root.setHgap(10);
        root.setVgap(10);
        root.add(mon1, 1, 1);
        root.add(mon2, 1, 2);
        root.add(mon3, 1, 3);
        root.add(mon4, 1, 4);
        root.add(mon5, 1, 5);
        root.add(mon6, 1, 6);
        
        root.add(thues1, 2, 1);
        root.add(thues2, 2, 2);
        root.add(thues3, 2, 3);
        root.add(thues4, 2, 4);
        root.add(thues5, 2, 5);
        root.add(thues6, 2, 6);
        
        root.add(wed1, 3, 1);
        root.add(wed2, 3, 2);
        root.add(wed3, 3, 3);
        root.add(wed4, 3, 4);
        root.add(wed5, 3, 5);
        root.add(wed6, 3, 6);
        
        root.add(thur1, 4, 1);
        root.add(thur2, 4, 2);
        root.add(thur3, 4, 3);
        root.add(thur4, 4, 4);
        root.add(thur5, 4, 5);
        root.add(thur6, 4, 6);
        
        root.add(fri1, 5, 1);
        root.add(fri2, 5, 2);
        root.add(fri3, 5, 3);
        root.add(fri4, 5, 4);
        root.add(fri5, 5, 5);
        root.add(fri6, 5, 6);
        
        root.add(sat1, 6, 1);
        root.add(sat2, 6, 2);
        root.add(sat3, 6, 3);
        root.add(sat4, 6, 4);
        root.add(sat5, 6, 5);
        root.add(sat6, 6, 6);
        
        root.add(sun1, 7, 1);
        root.add(sun2, 7, 2);
        root.add(sun3, 7, 3);
        root.add(sun4, 7, 4);
        root.add(sun5, 7, 5);
        root.add(sun6, 7, 6);
        
        root.add(t1, 0, 1);
        root.add(t3, 0, 2); 
        root.add(t5, 0, 3);
        root.add(t7, 0, 4);
        root.add(t9, 0, 5);
        root.add(t11, 0, 6);
        
        root.add(mon, 1, 0);
        root.add(thues, 2, 0);
        root.add(wed, 3, 0);
        root.add(thur, 4, 0);
        root.add(fri, 5, 0);
        root.add(sat, 6, 0);
        root.add(sun, 7, 0);
        
        root.setGridLinesVisible(false);
        
		return root;
	}

}
