/* The Event Class */


public class Event implements Comparable<Event>{
	public double startMinSince12;
	public double endMinSince12;
	public Course course;
	public Event previousEvent;
	public Event nextEvent;

	public Event(){
		this.startMinSince12 = 0.0;
		this.endMinSince12 = 0.0;
		this.course = null;
		this.previousEvent = null;
		this.nextEvent = null;
	}

	public Event(double s, double e, Course c, Event pe, Event ne){
		this.startMinSince12 = s;
		this.endMinSince12 = e;
		this.course = c;
		this.previousEvent = pe;
		this.nextEvent = ne;
	}

	public int compareTo(Event other){
		return Double.compare(this.startMinSince12, other.startMinSince12);
	}
}