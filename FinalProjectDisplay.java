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


public FinalProjectDisplay(String title, int numRows, int numCols) {
	frame = new JFrame(title);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	frame.setPreferredSize(new Dimension(500,500));
	textIn = new JTextField("response: ");
	textIn.addActionListener(this);
	JPanel p = new JPanel();
	p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
	p.add(textIn);
	frame.add(textIn);
	frame.add(this);
	frame.pack(); 
	frame.setVisible(true);
}
	public void actionPerformed(ActionEvent e) {
		String response = textIn.getText();
		System.out.println(e);
	}

	public void paintComponent(Graphics g) {
		g.drawString("Andrew", 250, 250);
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
