import java.awt.*;
import java.util.*;

//do not modify
public class FinalProject {
	 private int[][] grid;
	  private FinalProjectDisplay display;
	  private int count = 0;
	  
	  private int TEXT = 1;
	  
	public static void main(String[] args) {
	    FinalProject lab = new FinalProject(120, 80);
	    lab.run();
	    //plays game
	  }
	
	public FinalProject(int numRows, int numCols) {
	    String[] names = {"Andrew", "Nico"};
	    
	    //gives names array values
	    grid = new int[numRows][numCols];
	    display = new FinalProjectDisplay("Final Project", numRows, numCols);
	    
	  }
	
	public void updateDisplay() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					display.setColor(i,j, Color.white);
				}
				else if (grid[i][j] == 1) {
					display.setColor(i, j, Color.black);
				}
			}
		}
	  }
	
	public void step() {
		grid[0][0] = 1;
	}
	public void run() {
		//runs the program
	  while (true) {
	    for (int i = 0; i < display.getSpeed(); i++)
	      step();
	    	//"moves" the elements in the display
	    updateDisplay();
	    //updates the display
	    display.repaint();
	    display.pause(1);  //wait for redrawing and for mouse
	  }
	}
	
}
