//Andrew Stahl and Nico Espinosa Dice
// 06/1/2017
//Final Project
//This lab creates an educational game where the user must enter correct responses to questions 

import java.awt.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
//import statements

public class FinalProject{
//creates class
	
	  private FinalProjectDisplay display;
	  private int count = 0;
	  private int situation = 0;
	  //creates variables
	  
	public static void main(String[] args) throws FileNotFoundException {
	//main
	    FinalProject lab = new FinalProject();
	    lab.run();
	    //creates and runs the game
	  }
	
	public FinalProject() throws FileNotFoundException{
		//constructor creates display
	    String[] names = {"Andrew", "Nico"};
	    display = new FinalProjectDisplay("Final Project");
	  }
	
	
	public void run() throws FileNotFoundException {
		//runs the program
	  for (int i = 0; i < 10; i++) {
		  display.repaint();
		  display.pause(1);
	  }
	}	
}
