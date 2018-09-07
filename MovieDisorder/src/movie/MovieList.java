package movie;

/**
 *
 * @author ibrah
 */
public class MovieList {
    
    private int pos;
    private Movie movie;

    public MovieList() {
    }

    public MovieList(int pos) {
        this.pos = pos;
    }

    public MovieList(int pos, Movie movie) {
        this.pos = pos;
        this.movie = movie;
    }
    
    public int getPos() {
        return pos;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return pos + ". " + movie;
    }
}
