package classCalendar;


public class classCalendar {
	int begainWeek;
	int endWeek;
	date date;
	//int[] weekDay;
	int classtime;
	String className;
	String Location;
	
	public classCalendar(String className, String location, int classtime, date date, int bw, int ew){
		
		this.className = className;
		this.Location = location;
		this.date = date;
		begainWeek = bw;
		endWeek = ew;
		this.classtime = classtime;
	}
	
	public String getName(){
		return className;
	}
	
	public String getLocation(){
		return Location;
	}
	
//	public int[] getWeekDay(){
//		return weekDay;
//	}
	
//	classCalendar newclass =  new classCalendar(className, Location, classtime, date, begainWeek, endWeek);
//	
//	classCalendar getClassCalendar(){
//		return newclass;
//	}
	
	void getDate(){
		int week = begainWeek;
		while (week<=endWeek){
			System.out.println(date.year + "-" + date.month + "-" + date.day);
			date.nextWeek(date);
			week = week + 1;
		}
	}
		
		

	
	
}
