package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import movie.Filmography;
import movie.Movie;

/**
 *
 * @author ibrah
 */
public class Connect {
    public static void importMovies(ArrayList<Filmography> filmography) {
        String route = System.getProperty("user.dir") + File.separator + "src" + 
                File.separator + "files" +File.separator + "MovieInput.txt";
        File f = new File(route);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            String cycle = line.split(",")[2];
            int cycleNum = 1;
            int movieNum = 1;
            
            Movie movie = new Movie();
            ArrayList<Movie> list = new ArrayList<>();
            
            while (line != null) {
                String[] data = line.split(",");
                if (!cycle.equalsIgnoreCase(data[2])) {
                    addFilmography(cycleNum, list, filmography);
                    
                    cycle = data[2];
                    list = new ArrayList<>();
                    cycleNum++;
                }
                
                movie.setTitle(data[0]);
                movie.setYear(data[1]);
                movie.setCycle(data[2]);
                
                list.add(movie);
                
                System.out.println(movieNum + ". " + movie.toString());
                
                if (movieNum == 365) {
                    addFilmography(cycleNum, list, filmography);
                }
                
                movie = new Movie();
                movieNum++;
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fatal Error System. File Not Found.");
        } catch (IOException ex) {

        }
    }
    
    public static void addFilmography (int cycleNum, ArrayList<Movie> list, 
            ArrayList<Filmography> filmography) {
        Filmography filmo = new Filmography();
        
        filmo.setPos(cycleNum);
        filmo.setList(list);
        filmography.add(filmo);
                    
        System.out.println("===============\n" + cycleNum + ". Cycle " + 
                list.get(0).getCycle() + "\n===============");
    }
}
