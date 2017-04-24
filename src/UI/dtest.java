package UI;

import database.database;

public class dtest {
	public static void main (String[] args)
	{
		database one = new database();
		String[][] a = CalendarDay.Store();
		try {
			one.wirteInSingle(a, "todolist");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
