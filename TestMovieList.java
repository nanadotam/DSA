/**
 * Test movie class using Avengers movies
 */

public class TestMovieList {
    public static void main(String[] args) {
        NanaMovieList list = new NanaMovieList();

        // Add movies to the list
        list.addMovie("The Avengers", 2012, 8.0);
        list.addMovie("Avengers: Age of Ultron", 2015, 7.3);
        list.addMovie("Avengers: Infinity War", 2018, 8.4);
        list.addMovie("Avengers: Endgame", 2019, 8.8);
        list.addMovie("Captain America: The Winter Soldier", 2019, 7.7);

        // Display movies in the list
        list.displayMovies();

        // Display average rating of movies
        System.out.println("Average Rating of All Avenger Movies: " + list.calculateAverageRating());

        // Remove movies from list
        // Remove 'Captain America' since it's not an avengers movie
        list.removeMovie("Captain America: The Winter Soldier");


        // Display new list
        list.displayMovies();

        // Calculate new average rating
        System.out.println("New Average Rating of All Avenger Movies: " + list.calculateAverageRating());
    }
}
