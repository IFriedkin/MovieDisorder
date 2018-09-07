package moviedisorder;

import java.util.ArrayList;
import java.util.Random;
import movie.Filmography;
import movie.Movie;
import movie.MovieList;

/**
 *
 * @author ibrah
 */
public class Main {
    private static ArrayList<Filmography> filmography = new ArrayList();
    private static ArrayList<MovieList> movieList = new ArrayList();
    private static ArrayList<MovieList> positions = new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        files.Connect.importMovies(filmography);
        createPositions();
        Thread.sleep(4000);
        generateMovieList();
        printList();
    }
    
    public static void generateMovieList () {
        int movieNum = 1;
        int max = positions.size() - 1;
        int cycleNum = randomCycle(max);
        
        do {
            if (!filmography.isEmpty()) {
                insertMovieList(movieNum, 
                        filmography.get(cycleNum).getList().get(0));
                
                removeMovie(cycleNum);
                removeCycle(cycleNum);
                
                max = positions.size() - 1;

                cycleNum = randomCycle(max);
            }
 
            movieNum++;
        } while (movieNum < 365);
        
       insertMovieList(movieNum, filmography.get(0).getList().get(0));
        
        System.out.println("SALIDA");
    }
    
    public static void insertMovieList(int movieNum, Movie movie) {
        MovieList ml = new MovieList();
        
        ml.setPos(movieNum);
        ml.setMovie(movie);

        movieList.add(ml);
    }
    
    public static int randomCycle (int max) {
        Random r = new Random();
        int random = 0 + r.nextInt(max - 0 + 1);
        
        return positions.get(random).getPos();
    }
    
    public static void removeCycle (int cycleNum) {
        if (filmography.get(cycleNum).getList().isEmpty()) {
            filmography.remove(cycleNum);
            correctPositions(cycleNum);
        }
    }
    
    public static void correctPositions (int cycleNum) {
        int auxPos = 0;
        int value = positions.get(cycleNum).getPos();
             
        for (int i = 0; i < positions.size(); i++) {
            if (positions.get(i).getPos() == value) {
                positions.remove(i);
                i--;
            }
        }
        
        for (int i = 0; i < positions.size(); i++) {
            if (positions.get(i).getPos() > value) {
                auxPos = positions.get(i).getPos() - 1;
                positions.get(i).setPos(auxPos);
            }
        }
    }
    
    public static void removeMovie (int cycleNum) {
        filmography.get(cycleNum).getList().remove(0);
    }
    
    public static void printList () {
        for (MovieList movL : movieList) {
            System.out.println(movL.toString());
        }
    }
    
    public static void createPositions() {
        /*private static int[] positions = new int[] {0,1,2,3,4,5,6,7,8,9,9,9,10,11,
        12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,
        35,36,37,38};*/
        MovieList movieList = new MovieList();
        
        for (int i = 0; i<39; i++) {
            movieList.setPos(i);
            positions.add(movieList);
            
            if (i == 9) {
                for (int j = 0; j < 32; j++) {
                    movieList = new MovieList();
                    movieList.setPos(i);
                    positions.add(movieList);
                }
            }
            
            movieList = new MovieList();
        }
        
        System.out.println("Size positions: " + positions.size());
    }
}
