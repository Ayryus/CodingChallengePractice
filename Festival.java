import java.util.*;

public class Festival {
	private String name;
	private ArrayList<Movie> movieList;
	
	public Festival(String newName){
		name = newName;
		movieList = new ArrayList<Movie>();
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<Movie> getMovieList(){
		ArrayList<Movie> newlist = new ArrayList<Movie>();
		for(int count= 0; count < movieList.size(); count++)
			newlist.add(new Movie(movieList.get(count)));
		return newlist;
	}
	
	public void addMovie(Movie m){
		
		movieList.add(new Movie(m));
	}
	
	public Movie getMovieWithLowestRating(){
		Movie lowestRating;
		
		if (movieList.size() == 0)
			return null;
		else{
			lowestRating = movieList.get(0);
			for(int count= 1; count < movieList.size(); count++){
					if(movieList.get(count).getRating() < lowestRating.getRating())
						lowestRating = movieList.get(count);
			}
			
		}
		return new Movie(lowestRating);
	} 
}