import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Q2 {

    static LinkedList<Integer> [] adjList;
    static ArrayList<Integer> uniqueEdge = new ArrayList<>();
    
    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        // call crateAdjacencyList function
        createAdjacencyList();
        // call BFS function
        BFS(3980);
    }
    /**
     *To create the adjacency list, we create a array list to save data from the file. 
     *After that we read each line if the file and save data. We save the first edge into array list
     *and the save second edge into array list.
     *We also create linked list with the a temporary size. Split each line with space and save 
     *into Linked list and second edge into array list.
     *We iterate though the edges to get the unique edges. If not contain the tempUnique array list
     *we save it.
     */
    public static void createAdjacencyList() throws FileNotFoundException, IOException {
        // create arraylist to save data from file
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<Integer> tempUnique = new ArrayList<>();
        // filename
        String filename = "3980.edges";
        // open file
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        // read and save data from file until data is null
        while((line = br.readLine()) != null) {
            // read each line of file
            temp.add(line);
            // save first edge into arraylist
            tempUnique.add(Integer.parseInt(line.split(" ")[0]));
            // save second edge into arraylist
            tempUnique.add(Integer.parseInt(line.split(" ")[1]));
        }
        
        // create linkedlist with size of temp
        adjList = new LinkedList[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            adjList[i] = new LinkedList<Integer>();
            // split with space each line and save it into linkedlist
            adjList[i].add(Integer.parseInt(temp.get(i).split(" ")[0]));
            // save second edge into arraylist
            adjList[i].add(Integer.parseInt(temp.get(i).split(" ")[1]));
        }
        
        // get unique edges
        for(int i = 0; i < tempUnique.size(); i++) {
            if(!uniqueEdge.contains(tempUnique.get(i)) && tempUnique.get(i) != 3980) {
                // if not contain tempUnique arraylist, save it
                uniqueEdge.add(tempUnique.get(i));
            }
        }
    }
    /**
     * First we initialize the count(distance) with 0. Using the for loop we then iterate through the 
     * unique edges. We then save the arraylist as temporary with start. We loop to the length of temp
     * and also the length of adjlist. If the ith element of adjList contains jth element of temp,
     * change the ID from 0 to 1, else change ID from 1 to 0, breaking out the loop we save the ith element
     * of adjList into result. If the result contains kth elements of unique edges we print the distance.
     * Then remove all the element from temp and also result and break out of the loop. We then 
     * increment the count and remove all element from temp and update temp as result. We then remove
     * all the the elements from result. If the distance is out of range we don't print any edges.
     */
    public static void BFS(int start) {
        // initialize distance with 0
        int count = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        // loop for length of unique edge
        for(int k = 0; k < uniqueEdge.size(); k++) {
            count = 0;
            // save arraylist as temp with start
            temp.add(start);
            while (true) {
                // loop for length of temp
                for(int j = 0; j < temp.size(); j++) {
                    // loop for length of adjList
                    for(int i = 0; i < adjList.length; i++) {
                        // if ith element of adjList contains jth element of temp
                        if(adjList[i].contains(temp.get(j))) {
                            int index = adjList[i].indexOf(temp.get(j));
                            // change id from 0 to 1
                            if(index == 0)
                                index = 1;
                            // change id from 1 to 0
                            else
                                index = 0;
                            // save ith element of adjList into result
                            result.add(adjList[i].get(index));
                        }
                    }
                }
                // if result contains kth element of uniqueEdge
                if(result.contains(uniqueEdge.get(k))) {
                    // print distance
                    System.out.println(String.valueOf(uniqueEdge.get(k)) + " is at a distance of " 
                    + String.valueOf(count + 1) + " from " + String.valueOf(start));
                    // remove all element from temp
                    temp.removeAll(temp);
                    // remove all element from result
                    result.removeAll(result);
                    break;
                }
                // increase count by 1
                count++;
                // remove all element from temp
                temp.removeAll(temp);
                // update temp as result
                for(int i = 0; i < result.size(); i++) {
                    temp.add(result.get(i));
                }
                // remove all element from result
                result.removeAll(result);
                
                // if distance is out of range
                if(count > 4) {
                    // remove all element from temp
                    temp.removeAll(temp);
                    // remove all element from result
                    result.removeAll(result);
                    // print distance
                    //System.out.println(String.valueOf(uniqueEdge.get(k)) + " is at a distance of endless from " + String.valueOf(start));
                    break;
                }
            }
        }
    }
}
