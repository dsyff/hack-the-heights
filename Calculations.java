public class Calculations {
  
  private static final double earthRadius;

  static {
    earthRadius = 6.371e6;
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
  
  public static void main(String[] args) {
    
  }
  
}