
public class Point {

	int xcoord;
	int ycoord;
		
	public Point(int newXCoord, int newYCoord) {
			
	        if(newXCoord >= 0)
	        {
	        this.xcoord = newXCoord;
	        }
	        if(newYCoord >= 0)
	        {
	        this.ycoord = newYCoord;
	        }
	        else
	        {
	        this.xcoord = xcoord;
	        this.ycoord = ycoord;
	        }
	    }
		
	public Point(Point SecondaryPoint) {
		
		this.xcoord = SecondaryPoint.getXCoord();
		this.ycoord = SecondaryPoint.getYCoord();
		
	}
	
	public void setXCoord(int value) {
		
		if(value >= 0) 
		{
			this.xcoord = value;
		}
		else
		{
			this.xcoord = this.xcoord;
		}
		
	
	}
	
	public int getXCoord() {
		
		return xcoord;
		
	}
	
	public void setYCoord(int value) 
	{
		if(value >= 0) 
		{
			this.ycoord = value;
		}
		else
		{
			this.ycoord = this.ycoord;
			
		}
	}
	
	public int getYCoord() {
		
		return ycoord;
	
	}
	
	public void moveUp(int Up) {
		
		this.ycoord = ycoord - Up;
	}
	
	public void moveDown(int Down) {
		
		this.ycoord = ycoord + Down; 
		
	}
	
	public void moveRight(int Right ) {
		
		this.xcoord = xcoord + Right;
	}
	
	public void moveLeft(int Left) {
		
		this.xcoord = xcoord - Left;
	}
	
	public double distance(Point newPoint) {
		
		double x = Math.pow(this.xcoord - newPoint.xcoord, 2);
		double y = Math.pow(this.ycoord - newPoint.ycoord, 2);
		
		return Math.sqrt(x+y);
	}
	
	public boolean equals(Point newPoint) {
		
		
		if(this.xcoord == newPoint.xcoord && this.ycoord == newPoint.ycoord) {
			return true;
		}
		else{
			return false;
		}
		
		
	}
}
	
	
	
	

