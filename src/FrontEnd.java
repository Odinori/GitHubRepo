import javax.swing.*;

import java.util.List;
import java.awt.*;
import java.awt.event.*;

public class FrontEnd 
{
	//nate
	public List<String> Usernamelist;
	public List<String> Messagelist;
	
	public FrontEnd()
	{
		final JFrame frame = new JFrame("Driver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600, 400));
		frame.setLocation(400, 200);
		frame.setResizable(false);
		
		//create boxes
		Box outerBox = Box.createHorizontalBox();
		frame.add(outerBox);
		
		Box leftBox = Box.createVerticalBox();
		Box rightBox = Box.createVerticalBox();
		outerBox.add(leftBox);
		outerBox.add(rightBox);
		//left box
		Box username = Box.createHorizontalBox();
		
		final JTextField usernameField = new JTextField();
		Font font = new Font("Comic Sans MS", Font.BOLD, 24);
		usernameField.setFont(font);
		username.add(usernameField);
		
		leftBox.add(username);
		leftBox.add(Box.createVerticalStrut(275));
		
		Box messagei = Box.createHorizontalBox();
		final JTextField messagething = new JTextField();
		messagething.setFont(font);
		messagei.add(messagething);
		
		leftBox.add(messagei);
		
		
		//right box
		Box message = Box.createHorizontalBox();
		
		
		frame.pack();
		frame.setVisible(true);
		
		

	}

}
