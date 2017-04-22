/* class Day: a list of Events */


import java.util.*;

public class Day{
	public Event firstEvent;

	public Day(Event firstEvent){
		this.firstEvent = firstEvent;
	}

	public static Day getDay(List<Course> cs, String day){
		List<Event> l = new ArrayList<Event>();
		
		if (day.equals("M")){
			for (int i = 0; i < cs.size(); i++){
				Course course = cs.get(i);
				if (course.schedule.monday != null){
					Event event = new Event();
					event.startMinSince12 = course.schedule.monday.beginhour * 60 + course.schedule.monday.beginmin;
					event.endMinSince12 = course.schedule.monday.endhour * 60 + course.schedule.monday.endmin;
					event.course = course;
					l.add(event);
				}

			}
		} else if (day.equals("T")){
			for (int i = 0; i < cs.size(); i++){
				Course course = cs.get(i);
				if (course.schedule.tuesday != null){
					Event event = new Event();
					event.startMinSince12 = course.schedule.tuesday.beginhour * 60 + course.schedule.tuesday.beginmin;
					event.endMinSince12 = course.schedule.tuesday.endhour * 60 + course.schedule.tuesday.endmin;
					event.course = course;
					l.add(event);
				}
			}
		} else if (day.equals("W")){
			for (int i = 0; i < cs.size(); i++){
				Course course = cs.get(i);
				if (course.schedule.wednesday != null){
					Event event = new Event();
					event.startMinSince12 = course.schedule.wednesday.beginhour * 60 + course.schedule.wednesday.beginmin;
					event.endMinSince12 = course.schedule.wednesday.endhour * 60 + course.schedule.wednesday.endmin;
					event.course = course;
					l.add(event);
				}
			}
		} else if (day.equals("TH")){
			for (int i = 0; i < cs.size(); i++){
				Course course = cs.get(i);
				if (course.schedule.thursday != null){
					Event event = new Event();
					event.startMinSince12 = course.schedule.thursday.beginhour * 60 + course.schedule.thursday.beginmin;
					event.endMinSince12 = course.schedule.thursday.endhour * 60 + course.schedule.thursday.endmin;
					event.course = course;
					l.add(event);
				}
			}
		} else if (day.equals("F")){
			for (int i = 0; i < cs.size(); i++){
				Course course = cs.get(i);
				if (course.schedule.friday != null){
					Event event = new Event();
					event.startMinSince12 = course.schedule.friday.beginhour * 60 + course.schedule.friday.beginmin;
					event.endMinSince12 = course.schedule.friday.endhour * 60 + course.schedule.friday.endmin;
					event.course = course;
					l.add(event);
				}
			}
		}

		Collections.sort(l);

		
		Event firstEvent = null;
		if (l.size() != 0) {
			firstEvent = l.get(0);
			l.get(0).nextEvent = l.get(1);
			l.get(l.size() - 1).previousEvent = l.get(l.size() - 2);
			for (int i = 1; i < l.size() - 2; i++){
				l.get(i).nextEvent = l.get(i+1);
				l.get(i+1).previousEvent = l.get(i);
			}
		}
		return new Day(firstEvent);



	}
}
