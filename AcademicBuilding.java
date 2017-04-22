


public class AcademicBuilding implements Building{ 

	private String BuildingName;
	private Location location;
	private static String BuildingType = "Academic";

	public Academic(String BuildingName, location){
		this.BuildingName = BuildingName;
		this.location = location;  
	}
	public String getBuildingName(){
		return BuildingName;
	}
	public Location getLatlng(){
		return location;
	}

	
}