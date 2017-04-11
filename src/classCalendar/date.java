package classCalendar;

public class date {
	int year;
	int month;
	int day;

	public date(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
	}
	
	
	date nextWeek(date date) {
		day = day + 7;
		int maxday = maxday(date.month, date.year);
		if (day < maxday) {
			date.day = day;
			return date;
		}
		if (day >= maxday) {
			if (date.month == 12) {
				date.year = date.year + 1;
				date.month = 1;
				date.day = 1;
				return date;
			}
			if (date.month != 12) {
				date.day = day % maxday(date.month, date.year);
				date.month = date.month + 1;
				return date;
			}
		}
		return date;

	}

	int Leapyear(int y) {
		if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
			return 1;
		} else {
			return 0;
		}
	}

	int maxday(int m, int y) {
		if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
			return 31;
		} else if (m == 4 || m == 6 || m == 9 || m == 11) {
			return 30;
		} else if (m == 2) {
			if (Leapyear(y) == 1) {
				return 29;
			}
			if (Leapyear(y) != 1) {
				return 28;
			}
		}
		return 0;
	}
}
