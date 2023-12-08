/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author
 */
public class MyMaze {
    private int entrance;
    private int exit;
    private ArrayList<ArrayList<Character>> a;
    
   
		
    public int[][] readFile("C:\\Users\\HAMRAH\\Desktop\\New folder\\t.txt"){
		int [][] a;
		BufferedReader bf = null;
        try {
            bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\HAMRAH\\Desktop\\New folder\\t.txt"))));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyMaze.class.getName()).log(Level.SEVERE, null, ex);
        }
		String s=s=bf.readLine();
		int row = Integer.parseInt(s.substring(0, s.indexOf(",")));
		int col = Integer.parseInt(s.substring(s.indexOf(",")+1));
		a = new int[row][col];
		byte r=0;
		while((s=bf.readLine()) != null){
			int c=0;
			char q [] = s.toCharArray();
			for(int i = 0; i<q.length; i+=2){
				a[r][c]=Integer.parseInt(q[i]+"");
						c++;
			}
			r++;
		}
		bf.close();
		
			

    public void solvePrintMaze()
    {
       a= solveMaze();
        for (int i = 0; i < a.size(); i++)
        {
            for (int j = 0; j < a.get(i).size(); j++)
                System.out.print(a.get(i).get(j));
            System.out.print("\n");
        }

    }
        
        public ArrayList<ArrayList<Character>> solveMaze()
    {
         ArrayList<ArrayList<Character>> maze = null;
        ArrayList<ArrayList<Character>> workedMaze = maze;
         ArrayList<ArrayList<Character>> solvedMaze = maze;
        int row = maze.size()  - 1;

        int column = entrance;
        int   moves = 0;

        while (!(row == 0 && column == exit))
        {
            System.out.println(row);
            System.out.println(column);
            solvedMaze.get(row).set(column, 'R');
            ArrayList<Character> tempRowSolved = solvedMaze.get(row);
            tempRowSolved.set(column, 'R');
            ArrayList<Character> tempRowWorked = workedMaze.get(row);

            if (isDeadEnd(row, column, workedMaze))
            {
                tempRowWorked.set(column, 'x');
            }
            workedMaze.set(row, tempRowWorked);
            System.out.println(workedMaze);
            solvedMaze.set(row, tempRowSolved);
            
            column = nextColumn(row, column, workedMaze);
            row = nextRow(row, column, workedMaze);

            
        }
        return solvedMaze;
    }
        
        
          public static boolean canMove (int row, int column,ArrayList<ArrayList<Character>> arrayMaze)
    {
        if (column < arrayMaze.size() && column >=0 && row < arrayMaze.get(row).size() && row >= 0 && arrayMaze.get(row).get(column).equals( ' '))
        {
            return true;
        }
        return false;
    }
          
          
           public static boolean canMoveBot (int row, int column, ArrayList<ArrayList<Character>> arrayMaze)
    {
        return canMove(row+1, column, arrayMaze);
    }
    public static boolean canMoveTop (int row, int column,ArrayList<ArrayList<Character>> arrayMaze)
    {
        return canMove(row-1, column, arrayMaze);
    }
    public static boolean canMoveLeft (int row, int column, ArrayList<ArrayList<Character>> arrayMaze)
    {
        return canMove(row, column -1, arrayMaze);
    }
    public static boolean canMoveRight (int row, int column, ArrayList<ArrayList<Character>> arrayMaze)
    {
        return canMove(row, column + 1, arrayMaze);
    }
    
    public static boolean isDeadEnd (int row, int column, ArrayList<ArrayList<Character>> arrayMaze)
    {
        int  n = 0;
        if (!(canMoveBot(row, column, arrayMaze)))
            n++;
        if (!(canMoveBot(row, column, arrayMaze)))
            n++;
        if (!(canMoveBot(row, column, arrayMaze)))
            n++;
        if (!(canMoveBot(row, column, arrayMaze)))
            n++;
        if (n >= 3)
            return true;
        return false;
    }
    
    public int nextRow(int row, int column, ArrayList<ArrayList<Character>> arrayMaze)
    {
        if (canMoveTop(row, column, arrayMaze))
            return row - 1;
        if (canMoveBot(row, column, arrayMaze))
            return row + 1;
        return row;
    }
    
    public int nextColumn(int row, int column, ArrayList<ArrayList<Character>> arrayMaze)
    {
        if (canMoveRight(row, column, arrayMaze))
            return column + 1;
        if (canMoveLeft(row, column, arrayMaze))
            return column - 1;
        return column;
    }
}