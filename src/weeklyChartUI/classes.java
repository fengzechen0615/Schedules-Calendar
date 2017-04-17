package weeklyChartUI;

import javafx.beans.property.SimpleStringProperty;

public class classes {
	

	  final SimpleStringProperty classtime;
      final SimpleStringProperty mon;
      final SimpleStringProperty thues;
      final SimpleStringProperty wed;
      final SimpleStringProperty thur;
      final SimpleStringProperty fri;
      final SimpleStringProperty sat;
      final SimpleStringProperty sun;

      
      public classes(String time, String mon, String thues, String wed, String thur,String fri, String sat, String sun) {
          this.classtime = new SimpleStringProperty(time);
          this.mon = new SimpleStringProperty(mon);
          this.thues = new SimpleStringProperty(thues);
          this.wed = new SimpleStringProperty(wed);
          this.thur = new SimpleStringProperty(thur);
          this.fri = new SimpleStringProperty(fri);
          this.sat = new SimpleStringProperty(sat);
          this.sun = new SimpleStringProperty(sun);
      }

      public String getClassTime() {
          return classtime.get();
      }

      public void setclasstime(String time) {
          classtime.set(time);
      }

      public String getMon() {
          return mon.get();
      }

      public void setMon(String m) {
          mon.set(m);
      }

      public String getThues() {
          return thues.get();
      }

      public void setThues(String t) {
          thues.set(t);
      }
      
      public String getWed() {
          return wed.get();
      }

      public void setWed(String w) {
          wed.set(w);
      }
      
      public String getThur() {
          return thur.get();
      }

      public void setThur(String t) {
          thur.set(t);
      }
      public String getFri() {
          return fri.get();
      }

      public void setFri(String f) {
          fri.set(f);
      }
      public String getSat() {
          return sat.get();
      }

      public void setSat(String s) {
          sat.set(s);
      }
      public String getSun() {
          return sun.get();
      }

      public void setSun(String s) {
         sun.set(s);
      }
}
