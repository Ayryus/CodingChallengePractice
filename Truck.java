public class Truck extends Vehicle {

private int cargoCapacity;	

public Truck(String newModel, int newCargoCapacity) {
	super(newModel);
	this.cargoCapacity = cargoCapacity;
	
}

public Truck(Truck toCopy) {
	
	this.cargoCapacity = toCopy.getCargoCapacity();
}

public void setCargoCapacity(int newCapacity) {
	
}

public int getCargoCapacity() {
	
return 0;	
}

public String getCategory() {
	
	
return "h";	
}

public String toString() {
	
	
	return "h";
}

public String getModel() {
	return "h";
}








}