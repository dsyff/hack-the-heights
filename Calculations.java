public class Calculations {
  
  private static final double earthRadius;
  private static final int lunchTime; //in minutes since
  private static final int lunchPeriod; //minutes

  static {
    earthRadius = 6.371e6;
    lunchTime = 1440;
    lunchPeriod = 30;
  }
  
  private static double sine (double degrees) {return Math.sin (Math.toRadians (degrees));}
  private static double cosine (double degrees) {return Math.cos (Math.toRadians (degrees));}
  
  public static double distanceBetween(Location pt1, Location pt2) {
    double latDiff = pt2.lat - pt1.lat;
    double lngDiff = pt2.lng - pt1.lng;
    double haversine = Math.pow(sine(latDiff/2), 2.0) + cosine(pt1.lat) * cosine(pt2.lat) * Math.pow(sine(lngDiff/2), 2);
    double unitDistance = 2 * Math.atan2(Math.sqrt(haversine), Math.sqrt(1 - haversine));
    return earthRadius * unitDistance;
  }
  
  
  private static boolean isValid(Location from, Location lunch, Location to) {
  //not implemented
    return true;
  }
  
  private static eventBefore(Event startEvent, int time) {
  
  
  }
  
  public static Event lunchSuggestion(Event startEvent) {
    lunchEvent = new Event();//ask andre for how to create event
    if (startEvent == null) return null; //no classes, no lunch suggestion
    Event currentEvent = startEvent;
    int lunchStart = 0;
    while (currentEvent.nextEvent != null) {
      nearest
      currentEvent = currentEvent.nextEvent;
    }
    
  
  }

}