public class AcademicBuilding implements BuildingI { 

 private String BuildingName;
 private Location location;
 private static String BuildingType = "Academic";

 public AcademicBuilding (String BuildingName, Location location){
  this.BuildingName = BuildingName;
  this.location = location;  
 }
 public String getBuildingName(){
  return BuildingName;
 }
 public Location getLatlng(){
  return location;
 }
 public Location getLocation() {return null;}
 
}