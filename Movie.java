public class Movie {
    private String title;
    private int releaseYear;
    private double rating;


    // constructor
    public Movie (String title, int releaseYear, double rating) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

    // convert movie details to string
    @Override
    public String toString() {
        return String.format("%s (%d) - Rating: %.1f", title, releaseYear, rating);
    }

}
