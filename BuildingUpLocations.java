import java.util.ArrayList;

public class BuildingUpLocations {
 
 public static ArrayList<BuildingI> AcademicBuildingsList;
 public static ArrayList<BuildingI> DiningHallsList;
 
 static {
  AcademicBuildingsList = new ArrayList<BuildingI>();
  DiningHallsList = new ArrayList<BuildingI>();
  
  BuildingI gassonhall =  new AcademicBuilding("Gasson", new Location(42.335573, -71.170486));
  AcademicBuildingsList.add(gassonhall);
  
  BuildingI maloneyhall =  new AcademicBuilding("Maloney", new Location(42.336108, -71.168435));
  AcademicBuildingsList.add(maloneyhall);
  
  BuildingI oneilhall =  new AcademicBuilding("O'Neil", new Location(42.336072, -71.169272));
  AcademicBuildingsList.add(oneilhall);
  
  BuildingI stmaryhall =  new AcademicBuilding("St. Mary", new Location(42.336847, -71.170466));
  AcademicBuildingsList.add(stmaryhall);
  
  BuildingI devlinhall =  new AcademicBuilding("Devlin", new Location(42.336847, -71.170466));
  AcademicBuildingsList.add(devlinhall);
  
  BuildingI lyonshall =  new AcademicBuilding("Lyons", new Location(42.334967, -71.171043));
  AcademicBuildingsList.add(lyonshall);
  
  BuildingI fultonhall =  new AcademicBuilding("Fulton", new Location(42.334485, -71.169984));
  AcademicBuildingsList.add(fultonhall);
  
  BuildingI higginshall =  new AcademicBuilding("Higgins", new Location(42.335022, -71.168812));
  AcademicBuildingsList.add(higginshall);
  
  BuildingI stokesnorth =  new AcademicBuilding("Stokes North", new Location(42.334594, -71.171186));
  AcademicBuildingsList.add(stokesnorth);
  
  BuildingI stokessouth =  new AcademicBuilding("Stokes South", new Location(42.334009, -71.171334));
  AcademicBuildingsList.add(stokessouth);
  
  BuildingI carneyhall =  new AcademicBuilding("Carney", new Location(42.333599, -71.170577));
  AcademicBuildingsList.add(carneyhall);
  

  BuildingI mcguinnhall =  new AcademicBuilding("McGuinn", new Location(42.333602, -71.169727));
  AcademicBuildingsList.add(mcguinnhall);
  
  BuildingI campionhall =  new AcademicBuilding("Campion", new Location(42.333808, -71.168663));
  AcademicBuildingsList.add(campionhall);
  

  BuildingI cushinghall =  new AcademicBuilding("Cushing", new Location(42.333808, -71.168663));
  AcademicBuildingsList.add(cushinghall);
  
  BuildingI merkerthall =  new AcademicBuilding("Merkert", new Location(42.333887, -71.167247));
  AcademicBuildingsList.add(merkerthall);
  
  BuildingI robsham =  new AcademicBuilding("Robsham", new Location(42.337775, -71.168174));
  AcademicBuildingsList.add(robsham);
 
  
  DiningHallsList = new ArrayList<BuildingI>();
  
  BuildingI mac = new DiningHall("Mac", new Location(42.333339, -71.171893),"This dining hall is next to Carney and Stokes South.");
  DiningHallsList.add(mac);
  
  BuildingI hillside = new DiningHall("Hillside", new Location(42.336313, -71.168556),"This dining hall is located on the first floor of Maloney. Mealplan not accpeted.");
  DiningHallsList.add(hillside);
  
  

  BuildingI thebeancounter = new DiningHall("Hillside", new Location(42.334489, -71.170198),"This food shop is located on the first floor of Fulton. Mealplan not accpeted.");
  DiningHallsList.add(thebeancounter);
  
  BuildingI chocolatebar = new DiningHall("The Chocolate Bar", new Location(42.334030, -71.171324),"This dining hall is located on the first floor of Stokes South. Mealplan not accpeted.");
  DiningHallsList.add(chocolatebar);
  
  BuildingI therats = new DiningHall("The Rats", new Location(42.334954, -71.171013),"This dining hall is located on the basement floor of Lyons.");
  DiningHallsList.add(therats);
  
  BuildingI lower = new DiningHall("Lower", new Location(42.338035, -71.167676),"This dining hall is located next to Robsham Theatre.");
  DiningHallsList.add(lower);
}
 

}
