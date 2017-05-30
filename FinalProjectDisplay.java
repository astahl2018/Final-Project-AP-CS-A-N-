import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class FinalProjectDisplay extends JComponent implements ActionListener{
	private Image image;
	private int cellSize;
	private JFrame frame;
	private JSlider slider;
	private int speed;
	private JTextField textIn;
	private ArrayList<Question> questions = new ArrayList<Question>();
	private int count = 0;
	private String response;
	private JLabel l;


public FinalProjectDisplay(String title, int numRows, int numCols) {
	frame = new JFrame(title);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	frame.setPreferredSize(new Dimension(500,500));
	textIn = new JTextField("response: ");
	textIn.addActionListener(this);
	JPanel p = new JPanel();
	l = new JLabel("andrew");
	//p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
	
	p.setPreferredSize(new Dimension(500, 500));
	frame.add(p);
	p.add(l);
	p.add(textIn);
	textIn.setSize(new Dimension(250, 250));
	
	
	frame.pack(); 
	frame.setVisible(true);
	
	String[] qArr = {"Why did Andrew lose the question in science bowl" , "How does Nico decide what answer to go with in scienc bowl?"};
	String[] aArr = {"He was stalling" , "He just rolls a dice"};
	
	for(int i = 0; i < qArr.length; i++){
		questions.add(new Question(qArr[i] , aArr[i]));
	}
}
	public void actionPerformed(ActionEvent e) {
		response = textIn.getText();
		System.out.println("response: " + response);
		if (questions.get(count).checkResponse(response)) {
			System.out.println("correct");
		}
		else {
			System.out.println("incorrect");
			l.setText("wrong");
		}
	}

	public void paintComponent(Graphics g) {

	}
	
	public void pause(int milliseconds) {
		try {
		  Thread.sleep(milliseconds);
		}
		
		catch(InterruptedException e) {
		  throw new RuntimeException(e);
		}
	}
	
	public void setColor(int row, int col, Color color) {

	}
	
	
	public void stateChanged(ChangeEvent e) {
		speed = computeSpeed(slider.getValue());
	}
	
	public int getSpeed() {
		return speed;
	}
	
	private int computeSpeed(int sliderValue) {
		return (int) Math.pow(10, 0.03 * sliderValue + 3);
	}
}
