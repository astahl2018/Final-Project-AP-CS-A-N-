//Just for testing stuff

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Test extends Question implements ActionListener{
	public Test(String q, String a) {
		super(q, a);
	}

	JTextField txtInput = new JTextField("");
	
	public void actionPerformed(ActionEvent e) {
		String response = txtInput.getText(); //How to get input from the user
	}
	
	public static void main(String[] args){
		ArrayList<Question> questions = null;
		String[] qArr = {"Why did Andrew lose the question in science bowl" , "How does Nico decide what answer to go with in scienc bowl?"};
		String[] aArr = {"He was stalling" , "He just rolls a dice"};
		
		for(int i = 0; i < qArr.length; i++){
			questions.add(new Question(qArr[i] , aArr[i]));
		}
	}
	
}

