package movie;

/**
 *
 * @author ibrah
 */
public class Movie {
    
    private String title;

    private String year;

    private String cycle;

    public Movie() {
    }

    public Movie(String title, String year, String cycle) {
        this.title = title;
        this.year = year;
        this.cycle = cycle;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getCycle() {
        return cycle;
    }
    
    public String getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    @Override
    public String toString() {
        return title + ", (" + year + "), " + cycle;
    }
}
