/* A class implementing Event

*/

public class Event{
	public String name;
	public Schedule schedule;
	public Location location;

	public class Schedule{
		public Time monday;
		public Time tuesday;
		public Time wednesday;
		public Time thursday;
		public Time friday;
	}

	public class Time{
		public int beginhour;
		public int beginmin;
		public int endhour;
		public int endmin;
	}

	public static Event getEvent(String name, String schedule, String location){
		Event event = new Event();

		event.name = name;

		int length = 0;
		if (schedule.charAt(schedule.length()) == '*'){
			length = 1;
			schedule = schedule.substring(0, schedule.length() - 1);
		} 
		else if (schedule.contains("-")){
			length = 2;
		} 
		String[] sche = schedule.split(" ");

		int i = 0;
		while (!isNumeric(sche[i]))	i++;
		int bh = Integer.parseInt(sche[i]);
		int bm = 0;
		if (i < sche.length - 1) bm = Integer.parseInt(sche[i + 1]);
		int begintime = bh * 60 + bm;
		int endtime = begintime + 50;
		if (length == 1){
			endtime = begintime + 75;
		} else if (length == 2){
			endtime = begintime + 140;
		}
		endtime = (endtime > 1440) ? endtime - 1440 : endtime;
		int eh = endtime % 60;
		int em = endtime / 60;

		for (int j = 0; j < 2; j++){
			if (!isNumeric(sche[j])){
				if (sche[j].equals("M")){
					event.schedule.monday.beginhour = bh;
					event.schedule.monday.beginmin = bm;
					event.schedule.monday.endhour = eh;
					event.schedule.monday.endmin = em;
				} else if (sche[j].equals("T")){
					event.schedule.tuesday.beginhour = bh;
					event.schedule.tuesday.beginmin = bm;
					event.schedule.tuesday.endhour = eh;
					event.schedule.tuesday.endmin = em;
				} else if (sche[j].equals("W")){
					event.schedule.wednesday.beginhour = bh;
					event.schedule.wednesday.beginmin = bm;
					event.schedule.wednesday.endhour = eh;
					event.schedule.wednesday.endmin = em;
				} else if (sche[j].equals("TH")){
					event.schedule.thursday.beginhour = bh;
					event.schedule.thursday.beginmin = bm;
					event.schedule.thursday.endhour = eh;
					event.schedule.thursday.endmin = em;
				} else if (sche[j].equals("F")){
					event.schedule.friday.beginhour = bh;
					event.schedule.friday.beginmin = bm;
					event.schedule.friday.endhour = eh;
					event.schedule.friday.endmin = em;
				} 
			}
		}

		event.location = new Location(0.0, 0.0);

		return event;

	}

	private static boolean isNumeric(String s){
		return ((s.charAt(0) <= '9') && (s.charAt(0) >= '0'));
	}


}




