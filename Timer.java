//The timer class

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Timer {
	static Thread thread = new Thread();	
	private int startTime;
	private int currentTime = 0;
	private JLabel l;
	
	public Timer(int start){
		startTime = start;
		l = new JLabel("Time: ");
	}
	
	public void update() throws InterruptedException{
		for(int i = 60; i > 0; i--){
			thread.sleep(1000);
			l.setText(Integer.valueOf(i).toString());
		}
	}
	
}
