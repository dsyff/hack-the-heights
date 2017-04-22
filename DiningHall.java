public class DiningHall implements BuildingI {
 
 private final String BuildingName;
 private Location location;
 private static String BuildingType = "DiningHall";

 public DiningHall(String BuildingName, Location location){
  this.BuildingName = BuildingName;
  this.location = location;  
 }
 
 public String getBuildingName(){
  return BuildingName;
 }
 
 public Location getLatlng(){
  return location;
 }

 public String getType(){
  return BuildingType;
 }
 public Location getLocation() {return null;}
 
}