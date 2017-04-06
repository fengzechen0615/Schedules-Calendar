package classCalendar;

public class classCalendar {
	int year;
	int month;
	int day;
	int weekDay;
	int min;
	int hour;
	String className;
	String Location;
	
	public classCalendar(int[] classTime, String className, String location){
		year = classTime[0];
		month = classTime[1];
		day = classTime[2];
		hour = classTime[3];
		min = classTime[4];
		weekDay = classTime[5];
		this.className = className;
		this.Location = location;
	}
	
	public String getName(){
		return className;
	}
	
	
}
