public class NanaMovieList {
    CustomArrayList movieList = new CustomArrayList();

    // add a movie to the list
    public void addMovie(String title, int releaseYear, double rating) {
        Movie movie = new Movie(title, releaseYear, rating);
        movieList.add(movie);
    }

    // display movie list
    public void displayMovies() {
        System.out.println("Movie list: ");
        System.out.println("_________________");
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println((i+1) +": "+ movieList.get(i).toString());
        }
    }
    
    // Calculate average rating of movies
    public double calculateAverageRating() {
        if (movieList.isEmpty()) { // array_size == 0
            return 0.0;    
        }

        // initialize rating variables
        double totalRating = 0.0;
        double avgRating = 0.0;
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = (Movie) movieList.get(i);
            totalRating += movie.getRating();
        }
        avgRating = totalRating / movieList.size();
        return Math.round(avgRating * 100.0) / 100.0;
    }

    // Removing movie from list by title
    public void removeMovie(String title) {
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = (Movie) movieList.get(i); // cast returned Object type to Movie
            if (movie.getTitle().equals(title)) {
                movieList.remove(i);   
                break;
            }
        }
    }
}
