package exam;

public class Car {
	
	String color;
	String gearType;
	int door;
	
	public Car() {
	}
	public Car(String color,String gearType,int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGearType() {
		return gearType;
	}
	public void setGearType(String gearType) {
		this.gearType = gearType;
	}
	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	
	
	
}
