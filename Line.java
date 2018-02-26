
public class Line {

	private Point Start;
	private Point End;
	
	public Line(Point newStart, Point newEnd) {
		
		this.Start = new Point(newStart);
		this.End   = new Point(newEnd);
		
	}
	
	public void setStart(Point newStart) {
		
		this.Start = new Point(newStart);
		
	}
	
	public Point getStart() {
		
		return new Point(Start);
		
	}
	
	public void setEnd(Point newEnd) {
		
		(this.End) = new Point(newEnd);
		
	}
	
	public Point getEnd() {
		
		return new Point(End);
		
	}
	
	
	public double length() {
	//(x2-x1)^2 + (y2-y1) ^ 2
		
		Point startinfo = this.getStart();
		Point endinfo = this.getEnd();
		
		int xstartinfo = startinfo.getXCoord();
		int ystartinfo = startinfo.getYCoord();
				
		int xendinfo = endinfo.getXCoord();
		int yendinfo = endinfo.getYCoord();
		
		double xdistance = (xendinfo - xstartinfo); 
	    double ydistance = (yendinfo - ystartinfo);
	        xdistance *= xdistance;
	        
	        ydistance *= ydistance;
	        double distance = xdistance + ydistance;
	        distance = Math.sqrt(distance);

	        return distance;
		
	}
	
	
}
