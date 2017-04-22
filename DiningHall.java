public class DiningHall implements BuildingI {
 
 private final String BuildingName;
 private Location location;
 private static String BuildingType = "DiningHall";
 private static String description;

 public DiningHall(String BuildingName, Location location, String description){
  this.BuildingName = BuildingName;
  this.location = location;  
  this.description = description;
 }
 
 public String getBuildingName(){
  return BuildingName;
 }
 
 public String getType(){
  return BuildingType;
 }
 public Location getLocation() {return location;}

 public String getDescription(){return description;}
 
 
}