import java.awt.*;
import java.util.*;

//do not modify
public class FinalProject {
	  private FinalProjectDisplay display;
	  private int count = 0;
	  
	public static void main(String[] args) {
	    FinalProject lab = new FinalProject(200, 200);
	    lab.run();
	  }
	
	public FinalProject(int numRows, int numCols) {
	    String[] names = {"Andrew", "Nico"};
	    display = new FinalProjectDisplay("Final Project", numRows, numCols);
	  }
	
	public void updateDisplay() {
		
	  }
	
	public void step() {
		
	}
	
	public void run() {
		//runs the program
	  while (true) {
	    for (int i = 0; i < display.getSpeed(); i++) {
	      step();
	    }
	    
	    updateDisplay();
	    display.repaint();
	  }
	}
	
}
