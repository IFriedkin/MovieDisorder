package movie;

import java.util.ArrayList;

/**
 *
 * @author ibrah
 */
public class Filmography {
    
    private int pos;
    private ArrayList<Movie> list;

    public Filmography() {
    }

    public Filmography(int pos, ArrayList<Movie> list) {
        this.pos = pos;
        this.list = list;
    }
    
    public int getPos() {
        return pos;
    }

    public ArrayList<Movie> getList() {
        return list;
    }

    
    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setList(ArrayList<Movie> list) {
        this.list = list;
    }
}
