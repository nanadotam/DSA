public class Song {
    String title;
    String artist;
    int duration;

    // Constructor
    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }


    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    /*
     * Sets the title of the song.
     *
     * @param title The title of the song
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /*
     * Sets the artist of the song.
     *
     * @param artist The name of the artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }


    // Helper method 
    // Converts duration from "SS" to "H:MM:SS" format   
    public String getFormattedDuration() {
        int hours = duration / 3600;
        int min = (duration % 3600) / 60;
        int secs = duration % 60;

        if (hours <= 0) {
            return String.format("%02d:%02d", min, secs);
        } else {
            return String.format("%d:%02d:%02d", hours, min, secs);
        }
    }

    /*
    @Override
    public String toString() {
        return title + " by " + artist + " [" + getFormattedDuration() + "]";
    }
    */
}
