public class Calculations {
  
  private static final double earthRadius;
  private static final int lunchTime; //preferred lunch start time, in minutes since
  private static final int lunchPeriod; //minutes
  private static final double walkingSpeed; //in meters per minute

  static {
    earthRadius = 6.371e6;
    lunchTime = 720;
    lunchPeriod = 30;
    walkingSpeed = 84.0 / Math.sqrt(2.0);
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
  
  private static double travelTime(Location from, Location to) {
    return distanceBetween(from, to) / walkingSpeed;
  }
  
  public static Event lunchSuggestion(Event startEvent) {
    if (startEvent == null) return null; //no classes, no lunch suggestion
    Event currentEvent = startEvent;
    int lunchStartDiff = 1440;
    Event bestLunchEvent;
    Event bestAfterEvent;
    while (currentEvent.nextEvent != null) {
      Location from = currentEvent.building.getLocation();
      Location to = currentEvent.nextEvent.building.getLocation();
      DiningHall closestDiningHall = BuildingUpLocations.getNearest(from, to);
      Location meal = DiningHall.getLocation();
      double toTime = travelTime(from, meal);
      double awayTime = travelTime(away, meal);
      double totalTime = toTime + awayTime + lunchPeriod;
      int gapEnd = currentEvent.nextEvent.startMinSince12;
      int gapStart = currentEvent.endMinSince12;
      int lunchStart;
      if (totalTime <= gapEnd - gapStart) {
        if (gapEnd < lunchTime) lunchStart = (int) (gapEnd - awayTime - lunchPeriod);
        else if (gapStart > lunchTime) lunchStart = (int) (gapStart  + toTime);
        else if (lunchTime + lunchPeriod + awayTime > gapEnd) lunchStart = (int) (gapEnd - awayTime - lunchPeriod);
        else if (lunchTime - toTime < gapStart) lunchStart = (int) (gapStart + toTime);
        else lunchStart = lunchTime;
        if (Math.abs(lunchTime - lunchStart) < lunchStartDiff) {
          bestLunchEvent = new Event(lunchStart, lunchStart + lunchPeriod, closestDiningHall, "lunch", currentEvent, currentEvent.nextEvent);
          bestAfterEvent = currentEvent;
        }
        if (lunchStartDiff == 0) break;
      }
      currentEvent = currentEvent.nextEvent;
    }
    
    if (bestLunchEvent != null) {
      bestAfterEvent.nextEvent.previousEvent = bestLunchEvent;
      bestAfterEVent.nextEvent = bestLunchEvent;
    }
    
    return startEvent;
    
  }

}