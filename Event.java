/* The Event Class */


public class Event implements Comparable<Event>{
	public int startMinSince12;
	public int endMinSince12;
	public Course course;
	public AcademicBuilding building;
	public String name;
	public Event previousEvent;
	public Event nextEvent;

	public Event(){
		this.startMinSince12 = 0;
		this.endMinSince12 = 0;
		this.course = null;
		this.building = null;
		this.previousEvent = null;
		this.nextEvent = null;
	}

	public Event(int s, int e, Course c, Event pe, Event ne){
		this.startMinSince12 = s;
		this.endMinSince12 = e;
		this.course = c;
		this.building = c.building;
		this.name = c.name;
		this.previousEvent = pe;
		this.nextEvent = ne;
	}

	public Event(int s, int e, AcademicBuilding building, String name, Event pe, Event ne){
		this.startMinSince12 = s;
		this.endMinSince12 = e;
		this.building = building;
		this.name = name;
		this.previousEvent = pe;
		this.nextEvent = ne;
	}

	public int compareTo(Event other){
		return Integer.compare(this.startMinSince12, other.startMinSince12);
	}

	public String toString(){
		return this.course.toString();
	}
}