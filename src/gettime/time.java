package gettime;
import java.text.SimpleDateFormat;
import java.util.Date;

public class time {
	public int[] gettime(){
		Date year = new Date();
		Date month = new Date();
		Date day = new Date();
		Date hour = new Date();
		Date minute = new Date();
		
		SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdfmon = new SimpleDateFormat("MM");
		SimpleDateFormat sdfd = new SimpleDateFormat("dd");
		SimpleDateFormat sdfh = new SimpleDateFormat("HH");
		SimpleDateFormat sdfmin = new SimpleDateFormat("mm");
		
		String stry = sdfy.format(year);
		String strmon = sdfmon.format(month);
		String strd = sdfd.format(day);
		String strh = sdfh.format(hour);
		String strmin = sdfmin.format(minute);
		
		int y = Integer.parseInt(stry);
		int mon = Integer.parseInt(strmon);
		int d = Integer.parseInt(strd);
		int h = Integer.parseInt(strh);
		int min = Integer.parseInt(strmin);
		
		int[] time = new int[5];
		time[0] = y;
		time[1] = mon;
		time[2] = d;
		time[3] = h;
		time[4] = min;
				
		return time;
	}
	public int getWeekDay(){
		Date weekday = new Date();
		SimpleDateFormat sdfwd =  new SimpleDateFormat("EEEE");
		String strwd = sdfwd.format(weekday);
		int wd = 0;
		if(strwd == "星期一")
			wd = 1;
		if(strwd == "星期二")
			wd = 2;
		if(strwd == "星期三")
			wd = 3;
		if(strwd == "星期四")
			wd = 4;
		if(strwd == "星期五")
			wd = 5;
		if(strwd == "星期六")
			wd = 6;
		if(strwd == "星期日")
			wd = 7;
		return wd;
	}
}
