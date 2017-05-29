package UI;

import javafx.beans.property.SimpleStringProperty;

public class Staff {
	private  SimpleStringProperty Time;
	private  SimpleStringProperty Course;
	private  SimpleStringProperty Things;
	public Staff(String time,String course,String things)
	{
		this.Time=new SimpleStringProperty(time);
		this.Course=new SimpleStringProperty(course);
		this.Things=new SimpleStringProperty(things);
	}
	
	public String getTime()
	{
		return Time.get();
	}
	
	public void setTime(String time)
	{
		Time.set(time);
	}
	
	public String getCourse()
	{
		return Course.get();
	}
	
	public void setCourse(String course)
	{
		Course.set(course);
	}
	
	public String getThings()
	{
		return Things.get();
	}
	
	public void setThings(String things)
	{
		Things.set(things);
	}
	
}
