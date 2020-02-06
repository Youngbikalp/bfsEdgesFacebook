import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Q1 {

    /**
     * @param args the command line arguments
     * We first create the arraylist to save the input data. After that we read the text file.
     * We create a two dimensional linkedlist to save data. The one dimensional is the array and other
     * one dimensional is the linkedlist. Then we split each line with space and save it into the linkelist
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        // create arraylist to save input data
        ArrayList<String> temp = new ArrayList<>();
        // file_name is 3980.edges
        String filename = "3980.edges";
        // open file 
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        // until null, read data from file
        while((line = br.readLine()) != null) {
            temp.add(line);
        }
        
        // create 2d linkedlist to save data, 1d is array, other 1d is linkedlist
        LinkedList<Integer> [] adjList = new LinkedList[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            adjList[i] = new LinkedList<Integer>();
            // split each line with space and save it into linkedlist
            adjList[i].add(Integer.parseInt(temp.get(i).split(" ")[0]));
            adjList[i].add(Integer.parseInt(temp.get(i).split(" ")[1]));
        }
    }
    
}
