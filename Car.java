
public class Car extends Vehicle {

	private int noOfSeats;


	public Car(String newModel, int newNoOfSeats) {
		super(newModel);
		
		this.noOfSeats = newNoOfSeats;
	
		if(newNoOfSeats >= 1 && newNoOfSeats <=8) {
			this.noOfSeats = newNoOfSeats;
		}
		
		else 
			this.noOfSeats = 1;
			
		
	}
	
	public Car(Car toCopy) {
		super(toCopy);
		
		this.noOfSeats = toCopy.getNoOfSeats();
		
		if(toCopy.getNoOfSeats() >= 1 && toCopy.getNoOfSeats() <=8) {
			this.noOfSeats = toCopy.getNoOfSeats();
		}
		
		else 
			this.noOfSeats = 1;
			
	}
	
	public int getNoOfSeats() {
		
		return noOfSeats;
	}
	
	public void setNoOfSeats(int newOfSeats) {
		
		if(newOfSeats >= 1 && newOfSeats <= 8) {
			this.noOfSeats = newOfSeats;
		}
		
		else 
			this.noOfSeats = 1;
		
	}
	
	
	public String getCategory() {
		
		if(getNoOfSeats() < 3) {
			return "SMALL";
		}
		else if(getNoOfSeats() >= 3 && noOfSeats <= 5) {
			return "MEDIUM";
		}
		else
			return "FAMILY";
		
	}
	
	public String toString() {
		
		return super.toString() + " Likes: " + noOfSeats;
		
	}

	public String getModel() {
		return getModel();
	}
	
	




}