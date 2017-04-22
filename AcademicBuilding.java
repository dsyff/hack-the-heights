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
 
 public Location getLocation() {return location;}
 
 
 public String getType(){
	 
	 return BuildingType;
 }
 
 public String getDescription(){
	 return "Academic Building";
 };
 
}