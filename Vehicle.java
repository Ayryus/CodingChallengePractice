package codingchallenge3;




public abstract class Vehicle {
	
	private String model;

	
	public Vehicle(String newModel) {
		this.model.toUpperCase();
		this.model = newModel;
		
	}
	
	public Vehicle(Vehicle toCopy) {
		this.model = toCopy.model.toUpperCase();
		
		
	}
	
	public String getModel() {
		
		return "h";
		
	}
	
	
	public void setModel(String newModel) {
		
		this.model.toUpperCase();
		
		
	}
	
	public String toString() {
		
		return "Model:" + model + "Category: " + this.getCategory();
		
	}
	
	public abstract String getCategory();
	
	
	
	
	public boolean isMidRange() {
		
		if(this.getCategory() == "MEDIUM") {
			return true;
		}
		return false;
		
		
	}
		
		
	
	
	
	
}
