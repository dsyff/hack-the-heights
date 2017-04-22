/* The Week Class */

import java.util.*;

public class Week{
	public Day monday;
	public Day tuesday;
	public Day wednesday;
	public Day thursday;
	public Day friday;

	public Week(List<Course> cs){
		this.monday = Day.getDay(cs, "M");
		this.tuesday = Day.getDay(cs, "T");
		this.wednesday = Day.getDay(cs, "W");
		this.thursday = Day.getDay(cs, "TH");
		this.friday = Day.getDay(cs, "F");
	}
}
