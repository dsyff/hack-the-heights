/* The Event Class */


public class Event implements Comparable<Event>{
	public int startMinSince12;
	public int endMinSince12;
	public Course course;
	public Location location;
	public String name;
	public Event previousEvent;
	public Event nextEvent;

	public Event(){
		this.startMinSince12 = 0;
		this.endMinSince12 = 0;
		this.course = null;
		this.location = null;
		this.previousEvent = null;
		this.nextEvent = null;
	}

	public Event(int s, int e, Course c, Event pe, Event ne){
		this.startMinSince12 = s;
		this.endMinSince12 = e;
		this.course = c;
		this.location = c.location;
		this.name = c.name;
		this.previousEvent = pe;
		this.nextEvent = ne;
	}

	public Event(int s, int e, Location location, String name, Event pe, Event ne){
		this.startMinSince12 = s;
		this.endMinSince12 = e;
		this.location = location;
		this.name = name;
		this.previousEvent = pe;
		this.nextEvent = ne;
	}

	public int compareTo(Event other){
		return Integer.compare(this.startMinSince12, other.startMinSince12);
	}

	public String toString(){
		return this.course.name;
	}
}