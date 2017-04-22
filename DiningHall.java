

public class Dinninghall {
	
	private String BuildingName;
	private Location location;
	private static String BuildingType = "DiningHall";

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

	public String getType(){
		return BuildingType;
	}

	
}