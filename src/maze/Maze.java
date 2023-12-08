/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maze;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author 
 */
public class Maze {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          
            File mazeFile = new File ("maze1.txt");
        Maze testMaze = null;
        testMaze = new Maze(mazeFile);
        if (testMaze!= null){
            testMaze.solvePrintMaze();
        }
        else
            System.out.println("Maze file cannot be found");
    }

// TODO code application logic here

    private Maze(File mazeFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void solvePrintMaze() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    

