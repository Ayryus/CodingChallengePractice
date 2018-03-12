public abstract class Vehicle {
	
	private String model = "";

	
	public Vehicle(String newModel) {
		this.model = newModel.toUpperCase();
		
	}
	
	public Vehicle(Vehicle toCopy) {
		this.model = toCopy.getModel().toUpperCase();
	
	}
	
	public String getModel() {
		return model.toUpperCase();
	}
	
	
	public void setModel(String newModel) {
		
		this.model = newModel.toUpperCase();
		
	}
	
	public String toString() {
		
		return "Model:" + model + "Category: " + getCategory();
		
	}
	
	public abstract String getCategory();
	
	
	
	
	public boolean isMidRange() {
		
		if(this.getCategory() == "MEDIUM") {
			return true;
		}
		return false;
		
		
	}
		
		
	
	
	
	
}