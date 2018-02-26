
public class Movie {

	String title;
	int rating;
	
	public Movie(String newTitle, int newRating) {
		
		
		this.title = newTitle.toUpperCase();
		
		
		if (newRating >= 0 && newRating <= 10) {
			this.rating = newRating;
		}
	}
	
	public Movie(Movie secondaryMovie) {
		this.title = secondaryMovie.getTitle().toUpperCase();
		this.rating = secondaryMovie.getRating();
		
		if (secondaryMovie.getRating() >= 0 && secondaryMovie.getRating() <= 10) {
			this.rating = secondaryMovie.getRating();
		}
	}
	
		
	
	public void setTitle(String title) {

		this.title = title.toUpperCase();
	}
	
	public String getTitle() {
		
		return title;
		
	}
		
	
	public void setRating(int newRating) {
		
		if (newRating >= 0 && newRating <= 10) {
			this.rating = newRating;
		}
		else 
		{
			this.rating = this.rating;
			
		}
		
	
	}
	
	public int getRating() {
		
		return rating;
		
	}
	
	public char getCategory() {
		
		if (rating == 9 || rating == 10) {
			return 'A';

		}
		
		else if(rating == 7 || rating == 8) {
			return 'B';
			
			
		}
		
		else if (rating == 6 || rating == 5) {
			return 'C';
			
		}
		
		else if (rating == 4 || rating == 3) {
			return 'D';
			
		}
		
		else {
			return 'F';
			
		}
			
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

