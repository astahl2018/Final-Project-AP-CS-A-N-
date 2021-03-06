//Andrew Stahl and Nico Espinosa Dice
// 06/1/2017
//Final Project
//This lab creates an educational game where the user must enter correct responses to questions 

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


public class FinalProjectDisplay extends JComponent implements ActionListener{
//creates class that extends JComponent and implements ActionListener 
	
	private JFrame frame;
	private JSlider slider;
	private JTextField textIn;
	private ArrayList<Question> questions = new ArrayList<Question>();
	private int count = 0;
	private String response;
	private JLabel question;
	private JLabel responseLabel;
	private JLabel points;
	private JLabel correct;
	private JPanel p;
	private int lives= 3;
	private JLabel livesLabel;
	//creates variables

public FinalProjectDisplay(String title){
	//constructor
	try {
	File inputFileQ = new File("questionsInput.txt");
	Scanner inputQ = new Scanner(inputFileQ);
	File inputFileA = new File("answersInput.txt");
	Scanner inputA = new Scanner(inputFileA);
	
	frame = new JFrame(title);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	frame.setPreferredSize(new Dimension(500,500));
	textIn = new JTextField("");
	textIn.addActionListener(this);
	p = new JPanel();
	points = new JLabel("Points: " + String.valueOf(count));
	//creates frame and panel
	//creates text field
	
	String[] qArr = new String[10];
	String[] aArr = new String[10];
	//question and answer arrays (string)
	
	boolean bool1 = true;
	int i = 0;
	while (bool1) {
		//while loop to read input from file
		if (inputQ.hasNextLine()) {
			//if it has more
			qArr[i] = inputQ.nextLine();
			aArr[i] = inputA.nextLine();
			//adds next line as string to arrays
		}
		else {
			bool1 = false;
			//otherwise, sets the boolean to false
		}
		i++;
	}
	inputQ.close();
	inputA.close();
	
	for(int j = 0; j < qArr.length; j++){
		questions.add(new Question(qArr[j] , aArr[j]));
	}
	//makes a Question ArrayList that has a Question object for each set of question/answers
	
	question = new JLabel(questions.get(count).getQuestion());
	livesLabel = new JLabel("Lives: " + String.valueOf(lives));
	p.setLayout(new BorderLayout());
	p.setPreferredSize(new Dimension(500, 500));
	correct = new JLabel("");
	p.add(correct, BorderLayout.WEST);
	frame.add(p);
	p.add(question, BorderLayout.NORTH);
	p.add(textIn);
	p.add(points, BorderLayout.SOUTH);
	p.add(livesLabel, BorderLayout.EAST);
	textIn.setSize(new Dimension(250, 250));
	//adds labels to the panel
	//question label, response (text field), points label, wrong answers label
	

	frame.pack(); 
	frame.setVisible(true);
	//allows user to actually see
	
}
	catch (FileNotFoundException e) {
		System.out.println("File not found");
	}
}

	public void actionPerformed(ActionEvent e) {
	//when text is entered into the text field
		response = textIn.getText();
		if (lives == 0) {
			question.setText("Game over. You answered 3 questions wrong.");
			//if there are three total answers wrong, the game is over
			p.remove(textIn);
			//text field is removed so user can no longer input text
		}
		if (questions.get(count).checkResponse(response)) {
			//if the question is correct
			count+=1;
			correct.setText("Correct!");
			//indicate to user that the question was correct
			if (count < questions.size()) {
				question.setText(questions.get(count).getQuestion());
				//if there are still more questions, then display a new one
				textIn.setText("");
			}
			
			else {
				question.setText("You win! Thanks for playing.");
				p.remove(textIn);
				//otherwise, the game is over
				//removes text field so user can no longer input data
			}
			points.setText("Points: " + String.valueOf(count));
		}
		else {
			correct.setText("Incorrect");
			lives -= 1;
			livesLabel.setText("Lives: " + String.valueOf(lives));
			if (lives == 0) {
				question.setText("Game over. You answered 3 questions wrong.");
				//if there are three total answers wrong, the game is over
				p.remove(textIn);
				//text field is removed so user can no longer input text
			}
			//If the response is wrong, adds to total wrong answers
		}
		
	}

	
	public void pause(int milliseconds) {
		try {
		  Thread.sleep(milliseconds);
		}
		
		catch(InterruptedException e) {
		  throw new RuntimeException(e);
		}
	}
	//pause
}
	
