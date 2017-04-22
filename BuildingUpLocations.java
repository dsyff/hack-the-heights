import java.util.ArrayList;
import java.util.Hashtable;

public class BuildingUpLocations {
 
 public static ArrayList<BuildingI> AcademicBuildingsList;
 public static ArrayList<BuildingI> DiningHallsList;
 private static Hashtable<String,Location> abhashtable;
 private static Hashtable<String,Location> dhhashtable;
 
 static {
  AcademicBuildingsList = new ArrayList<BuildingI>();
 
  
  abhashtable = new Hashtable<String,Location>();
  dhhashtable = new Hashtable<String,Location>();
  
  BuildingI gassonhall =  new AcademicBuilding("Gasson", new Location(42.335573, -71.170486));
  AcademicBuildingsList.add(gassonhall);
  abhashtable.put("Gasson", new Location(42.335573, -71.170486));
  
  BuildingI maloneyhall =  new AcademicBuilding("Maloney", new Location(42.336108, -71.168435));
  AcademicBuildingsList.add(maloneyhall);
  abhashtable.put("Maloney", new Location(42.336108, -71.168435));
  
  BuildingI oneilhall =  new AcademicBuilding("O'Neil", new Location(42.336072, -71.169272));
  AcademicBuildingsList.add(oneilhall);
  abhashtable.put("O'Neil", new Location(42.336072, -71.169272));
  
  BuildingI stmaryhall =  new AcademicBuilding("St. Mary", new Location(42.336847, -71.170466));
  AcademicBuildingsList.add(stmaryhall);
  abhashtable.put("St. Mary", new Location(42.336847, -71.170466));
  
  BuildingI devlinhall =  new AcademicBuilding("Devlin", new Location(42.336847, -71.170466));
  AcademicBuildingsList.add(devlinhall);
  abhashtable.put("Devlin", new Location(42.336847, -71.170466));
  
  BuildingI lyonshall =  new AcademicBuilding("Lyons", new Location(42.334967, -71.171043));
  AcademicBuildingsList.add(lyonshall);
  abhashtable.put("Lyons", new Location(42.334967, -71.171043));
  
  BuildingI fultonhall =  new AcademicBuilding("Fulton", new Location(42.334485, -71.169984));
  AcademicBuildingsList.add(fultonhall);
  abhashtable.put("Fulton", new Location(42.334485, -71.169984));
  
  BuildingI higginshall =  new AcademicBuilding("Higgins", new Location(42.335022, -71.168812));
  AcademicBuildingsList.add(higginshall);
  abhashtable.put("Higgins", new Location(42.335022, -71.168812));
  
  BuildingI stokesnorth =  new AcademicBuilding("Stokes North", new Location(42.334594, -71.171186));
  AcademicBuildingsList.add(stokesnorth);
  abhashtable.put("Stokes North", new Location(42.334594, -71.171186));
  
  BuildingI stokessouth =  new AcademicBuilding("Stokes South", new Location(42.334009, -71.171334));
  AcademicBuildingsList.add(stokessouth);
  abhashtable.put("Stokes South", new Location(42.334009, -71.171334));
  
  BuildingI carneyhall =  new AcademicBuilding("Carney", new Location(42.333566, -71.170651));
  AcademicBuildingsList.add(carneyhall);
  abhashtable.put("Carney", new Location(42.333599, -71.170577));
  

  BuildingI mcguinnhall =  new AcademicBuilding("McGuinn", new Location(42.333602, -71.169727));
  AcademicBuildingsList.add(mcguinnhall);
  abhashtable.put("McGuinn", new Location(42.333602, -71.169727));
  
  BuildingI campionhall =  new AcademicBuilding("Campion", new Location(42.333808, -71.168663));
  AcademicBuildingsList.add(campionhall);
  abhashtable.put("Campion", new Location(42.333808, -71.168663));
  

  BuildingI cushinghall =  new AcademicBuilding("Cushing", new Location(42.333808, -71.168663));
  AcademicBuildingsList.add(cushinghall);
  abhashtable.put("Cushing", new Location(42.333808, -71.168663));
  
  BuildingI merkerthall =  new AcademicBuilding("Merkert", new Location(42.333887, -71.167247));
  AcademicBuildingsList.add(merkerthall);
  abhashtable.put("Merkert", new Location(42.333887, -71.167247));
  
  BuildingI robsham =  new AcademicBuilding("Robsham", new Location(42.337775, -71.168174));
  AcademicBuildingsList.add(robsham);
  abhashtable.put("Robsham", new Location(42.337775, -71.168174));
 
  
  DiningHallsList = new ArrayList<BuildingI>();
  
  BuildingI mac = new DiningHall("Mac", new Location(42.333339, -71.171893),"This dining hall is next to Carney and Stokes South.");
  DiningHallsList.add(mac);
  dhhashtable.put("Mac", new Location(42.333339, -71.171893));
  
  
  BuildingI hillside = new DiningHall("Hillside", new Location(42.336313, -71.168556),"This dining hall is located on the first floor of Maloney. Mealplan not accpeted.");
  DiningHallsList.add(hillside);
  dhhashtable.put("Hillside", new Location(42.336313, -71.168556));
  
  

  BuildingI thebeancounter = new DiningHall("Hillside", new Location(42.334489, -71.170198),"This food shop is located on the first floor of Fulton. Mealplan not accpeted.");
  DiningHallsList.add(thebeancounter);
  dhhashtable.put("Hillside", new Location(42.336313, -71.168556));
  
  BuildingI chocolatebar = new DiningHall("The Chocolate Bar", new Location(42.334030, -71.171324),"This dining hall is located on the first floor of Stokes South. Mealplan not accpeted.");
  DiningHallsList.add(chocolatebar);
  dhhashtable.put("The Chocolate Bar", new Location(42.334030, -71.171324));
  
  BuildingI therats = new DiningHall("The Rats", new Location(42.334954, -71.171013),"This dining hall is located on the basement floor of Lyons.");
  DiningHallsList.add(therats);
  dhhashtable.put("The Rats", new Location(42.334954, -71.171013));
  
  BuildingI lower = new DiningHall("Lower", new Location(42.338035, -71.167676),"This dining hall is located next to Robsham Theatre.");
  DiningHallsList.add(lower);
  dhhashtable.put("Lower", new Location(42.338035, -71.167676));
  
  
}
 
 public Location getABLocation(String building){
	 return abhashtable.get(building);
 }
 
 public static Hashtable<String, Location> getDHHashTable(){
	 return dhhashtable;
 }
 
 private static double distance(Location from, Location to, Location meal) {
 return Calculations.distanceBetween(from, meal) + Calculations.distanceBetween(to, meal);
 
 }
 public static DiningHall getNearestLunch(Location from, Location to){
	 double minimum = distance(from, to, DiningHallsList.get(0).getLocation());
	 DiningHall nearestLunch = (DiningHall) DiningHallsList.get(0);
	 for (BuildingI e : DiningHallsList) {
		 double newminimum = distance(from, to, e.getLocation());
		 if (newminimum<minimum){
			 minimum = newminimum;
			 nearestLunch = (DiningHall) e;
		 }
	 }
	 
	 return nearestLunch;
	 
	 
 }
 

}

